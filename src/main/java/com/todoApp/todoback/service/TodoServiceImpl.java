package com.todoApp.todoback.service;

import com.todoApp.todoback.model.Todo;
import com.todoApp.todoback.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " does not exist"));
    }

    @Override
    public Todo updateTodo(long id, Todo todoDetails) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " does not exist"));
        if(todoDetails.getTodoName() != null){
            todo.setTodoName(todoDetails.getTodoName());
        }
        if(todoDetails.getIsDone() != null) {
            todo.setIsDone(todoDetails.getIsDone());
        }
        todo.setLastModified(todoDetails.getLastModified());

        return todoRepository.save(todo);
    }

    @Override
    public Map<String, Boolean> deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " does not exist"));
        todoRepository.delete(todo);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
