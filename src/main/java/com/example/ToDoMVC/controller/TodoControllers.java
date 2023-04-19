package com.example.ToDoMVC.controller;


import com.example.ToDoMVC.services.TodoService;
import com.example.ToDoMVC.services.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoControllers {

    @Autowired
    TodoService todoService;


    //get me all todo in my present todo-List
    @GetMapping(value = "/getAllTodos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestBody Todo todo){
       return todoService.addMyTodo(todo);
    }

    @RequestMapping(value = "/getTodoById/{id}",method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
        return todoService.getTodoBasedOnId(id);
    }

}

