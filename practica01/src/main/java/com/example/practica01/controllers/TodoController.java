package com.example.practica01.controllers;

import com.example.practica01.models.ApiResponse;
import com.example.practica01.models.TodoModel;
import com.example.practica01.repositories.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@RestController()
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    protected TodoRepository todoRepository;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> hellow(){
        log.error("Consultando todos los productos desde el API"); // Esto se guardará en el archivo

         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(ApiResponse.builder()
                         .timestamp(LocalDateTime.now())
                         .status(HttpStatus.OK.value())
                         .message("Sin Registros")
                         .build()
                 );
    //ApiResponse.<Producto>builder().status(404).message("No encontrado").build()
    //.body(ApiResponse.success(tmp, "ok")
    //return ResponseEntity.notFound().build();
    }

    @GetMapping("/items")
    public ResponseEntity<ApiResponse<List<TodoModel>>> getItemsTodo(){
        try {
            log.info("Entra a getItemsTodo" );
            List<TodoModel> items = new ArrayList<>();
            items = todoRepository.findAll();
            log.info("Recupera items");
            String message = items.isEmpty() ? "No se encontraron Datos" : "Datos exitosos";
            return ResponseEntity.ok(ApiResponse.success(items, message));

        } catch (Exception e) {
            log.error("Error al recuperar datos " + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(ApiResponse.error(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE.value() ));
        }
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ApiResponse<Optional<TodoModel>>> getItemTodo(@PathVariable Long id){

        Optional<TodoModel> todoModel = todoRepository.findById(id);

        if (todoModel.isEmpty()) {
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiResponse.error("El item con ID " + id + " no existe", 404));
        }

        return ResponseEntity.ok(ApiResponse.success(todoModel, "Dato recuperado"));

    }

    @PostMapping("/item")
    public ResponseEntity<ApiResponse<TodoModel>> createItem(@Valid @RequestBody TodoModel todoModel){
        todoRepository.save(todoModel);

        return ResponseEntity.ok(ApiResponse.success(todoModel, "Item Creado"));
    }

    @PutMapping("/item/Edit/{id}")
    public ResponseEntity<ApiResponse<TodoModel>> updateItem(@PathVariable Long id, @RequestBody TodoModel todoModel){
        Optional<TodoModel> existingTodo = todoRepository.findById(id);

        if (existingTodo.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("El item con ID " + id + " no existe", 404));
        }

        existingTodo.get().setDescripcion(todoModel.getDescripcion());
        existingTodo.get().setEstado(todoModel.getEstado());
        existingTodo.get().setPrioridad(todoModel.getPrioridad());

        TodoModel updatedTodo = todoRepository.save(existingTodo.get());

        return ResponseEntity.ok(ApiResponse.success(updatedTodo, "Item actualizado correctamente"));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<ApiResponse> deleteItem(){
        return  null;
    }

    @PutMapping("/itemState/{id}")
    public ResponseEntity<ApiResponse> inactiveItem(){
        return null;
    }
    
}
