package com.hivetech.springweb;

import java.util.List;

public interface TodoService {
    List<Todo> getToDos();
    Todo getToDo(String id);
}
