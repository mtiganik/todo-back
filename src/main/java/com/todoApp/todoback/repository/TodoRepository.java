package com.todoApp.todoback.repository;

import com.todoApp.todoback.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
