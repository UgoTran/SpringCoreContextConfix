package com.hivetech.springweb.service;

import com.hivetech.springweb.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getToDos();
    Todo getToDo(String id);
}
