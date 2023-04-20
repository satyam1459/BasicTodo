package com.example.ToDoMVC.repository;

import com.example.ToDoMVC.models.Todo;
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

    public boolean remove(Todo todo) {
        todoList.remove(todo);
        return true;
    }

    public boolean update(String id, boolean status){
       boolean updateStatus = false;
        for(Todo todo : todoList){
            if (todo.getId().equals(id)){
                //remove original
                remove(todo);

                //change this todo now
                todo.setTodoStatus(status);

                //add this new todo
                save(todo);
                return true;
            }
        }
        return false;
    }
}
