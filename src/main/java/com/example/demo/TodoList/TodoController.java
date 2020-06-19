package com.example.demo.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/")
    public List<Todo> getAllToDoLists(){
        return todoService.findAll();
    }

    @PostMapping(value ="/")
    public ResponseEntity<?> saveOrUpdateTodo(@RequestBody Todo todo)
    {
        todoService.saveOrUpdateTodo(todo);
        return new ResponseEntity("Todo added successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/{order}")
    public void deleteToDo(@PathVariable Long order){
        todoService.deleteTodo(todoService.findTodoByOrder(order).getId());
    }
//    @DeleteMapping(value = "/{studentNumber}")
//    public void deleteStudent(@PathVariable Long studentNumber) {
//        studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
//    }
}
