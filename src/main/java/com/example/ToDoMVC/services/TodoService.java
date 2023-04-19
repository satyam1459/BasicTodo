package com.example.ToDoMVC.services;

import com.example.ToDoMVC.repository.TodoDao;
import com.example.ToDoMVC.services.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public List<Todo> getAllTodos(){
        return todoDao.getTodosFromDataSource();
    }

    public String addMyTodo(Todo todo){
        boolean insertionStatus = todoDao.save(todo);
        if(insertionStatus)
            return "Todo added succesfully";
        else
            return "Todo addition failed..!!";
    }

    public Todo getTodoBasedOnId(String id) {
        List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
        for(Todo todo : todoListRightNow){
            if(todo.getId().equals(id)) return todo;
        }
        return null;
    }
}
