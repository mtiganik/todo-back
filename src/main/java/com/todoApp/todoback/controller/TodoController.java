package com.todoApp.todoback.controller;

import com.todoApp.todoback.model.Todo;
import com.todoApp.todoback.repository.TodoRepository;
import com.todoApp.todoback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")

public class TodoController {

    @Autowired
    private TodoService todoService;

    // get all todos
    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    // create todo rest api
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    // get todo by id rest api
    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    // update todo rest api
    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails){
        Todo todo = todoService.updateTodo(id, todoDetails);
        return ResponseEntity.ok(todo);
    }

    // delete todo rest api
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTodo(@PathVariable Long id){
        var response = todoService.deleteTodo(id);
        return ResponseEntity.ok(response);
    }

}
