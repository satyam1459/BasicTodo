package com.example.ToDoMVC.services;

import com.example.ToDoMVC.repository.TodoDao;
import com.example.ToDoMVC.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.parseBoolean;

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

    public String removeTodoById(String id) {
        String status = "";
        boolean deleteResponse = false;
        if(id != null){
            List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
            for(Todo todo : todoListRightNow) {
                if (todo.getId().equals(id)) {
                    deleteResponse = todoDao.remove(todo);
                    if(deleteResponse) {
                        status = "Todo with id " + " was deleted..!!!";
                    }
                    else status = "Todo with id " + id + "was not deleted";
                    return status;
                }
            }
        }
       return "Todo with id " + id + " was not found";
    }

    public String updateTodoStatusById(String id, String status) {
      boolean updateStatus = todoDao.update(id,parseBoolean(status));
    if(updateStatus)    return "Todo with id : "+id + " was updated..!!";
    return "Todo with id : "+id + " was not found..!!";
    }

    public List<Todo> getTodoByUserStatus(String status) {
        List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
        List<Todo> todoListStatusBased = new ArrayList<>();
        for(Todo todo : todoListRightNow){
            if(todo.isTodoStatus() == Boolean.parseBoolean(status))
                todoListStatusBased.add(todo);
        }
        return todoListStatusBased;
    }
}
