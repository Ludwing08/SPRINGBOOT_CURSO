package com.example.practica01.repositories;

import com.example.practica01.models.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoModel, Long> {

}
