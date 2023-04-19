package com.example.ToDoMVC.repository;

import com.example.ToDoMVC.services.models.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {

    private List<Todo> todoList;


    public TodoDao(List<Todo> todoList) {
        this.todoList = new ArrayList<>();
        //not needed......done for testing
        todoList.add(new Todo("0","Dummy Todo for testing",true));
    }

    public List<Todo> getTodosFromDataSource() {
        return todoList;
    }

    public boolean save(Todo todo){
        todoList.add(todo);
        return true;
    }
}
