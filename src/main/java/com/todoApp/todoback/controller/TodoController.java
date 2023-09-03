package com.todoApp.todoback.controller;

import com.todoApp.todoback.model.Todo;
import com.todoApp.todoback.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")

public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    // get all todos
    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    // create todo rest api
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

    // get todo by id rest api
    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " does not exist"));
        return ResponseEntity.ok(todo);
    }

    // update todo rest api
    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " does not exist"));
        todo.setTodoName(todoDetails.getTodoName());
        todo.setIsDone(todoDetails.getIsDone());

        Todo updateTodo = todoRepository.save(todo);
        return ResponseEntity.ok(updateTodo);
    }

    // delete todo rest api
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTodo(@PathVariable Long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo with id: " + id + " does not exist"));
        todoRepository.delete(todo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
