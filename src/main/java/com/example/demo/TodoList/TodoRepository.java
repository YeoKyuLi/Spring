package com.example.demo.TodoList;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface TodoRepository extends MongoRepository<Todo, String> {

//    List<Todo> findByLastName(@Param("name") String name);

    // No need implementation, Just one interface, and you have CRUD,
    String findTodoByTitle(String title);
    Todo findTodoByOrder(long order);
    List<Todo> findTodoByTitleAndDone(String title);
    List<Todo> findTodoByDone(boolean done);

}