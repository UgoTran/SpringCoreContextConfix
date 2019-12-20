package com.hivetech.springweb.controller;

import com.hivetech.springweb.model.Todo;
import com.hivetech.springweb.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/todos")
public class TodoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //We have already configured in applicationContext.xml for annotation
//    @Autowired
    private TodoService toDoService;
    //Spring ApplicationContext to get the beans
    private WebApplicationContext webApplicationContext;

    public TodoServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // get Spring ApplicationContext
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        // get the bean from ApplicationContext
        toDoService = (TodoService) webApplicationContext.getBean("todoService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the data from source using Spring Service
        List<Todo> todos = toDoService.getToDos();
        // set the returned data to the variable for later use
        request.setAttribute("todos", todos);
        // forward the response to the jsp page
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
