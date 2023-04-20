package com.example.ToDoMVC.controller;


import com.example.ToDoMVC.services.TodoService;
import com.example.ToDoMVC.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value ="/getTodoByStatus")//request param
    public List<Todo> getTodoByStatus(@RequestParam String status){
        return todoService.getTodoByUserStatus(status);
    }
    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestBody Todo todo){
       return todoService.addMyTodo(todo);
    }

    @RequestMapping(value = "/getTodoById/{id}",method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
        return todoService.getTodoBasedOnId(id);
    }

    //create a delete endpoint
    @DeleteMapping(value ="/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id ){
        return todoService.removeTodoById(id);
    }

    //updation of Todo
    @PutMapping(value = "updateTodoById/{id}/{status}")
    public String updateTodoStatusById(@PathVariable String id,@PathVariable String status){
        return todoService.updateTodoStatusById(id,status);
    }

}

