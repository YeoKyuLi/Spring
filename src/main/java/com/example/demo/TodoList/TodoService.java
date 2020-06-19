package com.example.demo.TodoList;


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TodoService {
    // Normally, controller classes talk with the methods in repository classes directly, there is nothing wrong.
    // But, if we need to some business logic, we should not write this code block in controller.
    // Because of this, the service layer is needed.
    List<Todo> findAll();
    String findTodoByTitle(String title);
    Todo findTodoByOrder(long order);
    void saveOrUpdateTodo(Todo todo);
    void deleteTodo(String id);
}
