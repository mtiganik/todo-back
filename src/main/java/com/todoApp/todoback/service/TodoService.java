package com.todoApp.todoback.service;

import com.todoApp.todoback.model.Todo;

import java.util.List;
import java.util.Map;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    Todo getTodoById(Long id);
    Todo updateTodo(long id, Todo todo);
    Map<String, Boolean> deleteTodo(Long id);
}
