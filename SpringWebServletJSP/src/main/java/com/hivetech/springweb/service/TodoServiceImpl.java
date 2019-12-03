package com.hivetech.springweb.service;

import com.hivetech.springweb.model.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoServiceImpl implements TodoService {

    private Map<String, Todo> contentProvider = new HashMap<String, Todo>();

    public Map<String, Todo> getModel() {
        return contentProvider;
    }

    public TodoServiceImpl() {
        Todo todo1 = new Todo();
        Todo todo2 = new Todo();
        todo1.setId("0001");
        todo1.setDesc("Todo One");
        todo2.setId("0002");
        todo2.setDesc("Todo Two");
        contentProvider.put(todo1.getId(), todo1);
        contentProvider.put(todo2.getId(), todo2);
    }

    @Override
    public List<Todo> getToDos() {
        return new ArrayList<>(contentProvider.values());
    }

    @Override
    public Todo getToDo(String id) {
        return contentProvider.get(id);
    }
}
