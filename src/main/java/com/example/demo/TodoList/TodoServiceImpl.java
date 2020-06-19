package com.example.demo.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAll(){
        return todoRepository.findAll();
    };
    @Override
    public String findTodoByTitle(String title){
        return todoRepository.findTodoByTitle(title);
    };

    @Override
    public Todo findTodoByOrder(long order){
        return todoRepository.findTodoByOrder(order);
    }
    @Override
    public void saveOrUpdateTodo(Todo todo)
    {
        todoRepository.save(todo);
    };
    @Override
    public void deleteTodo(String id){
        todoRepository.deleteById(id);
    };
}
