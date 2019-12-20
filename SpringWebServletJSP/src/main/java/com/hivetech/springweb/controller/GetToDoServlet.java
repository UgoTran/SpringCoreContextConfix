package com.hivetech.springweb.controller;

import com.hivetech.springweb.model.Todo;
import com.hivetech.springweb.service.TodoService;
import com.hivetech.springweb.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/todo")
public class GetToDoServlet extends HttpServlet {
    @Autowired
    private TodoService toDoService;
//    private WebApplicationContext webApplicationContext;

//    public GetToDoServlet() {
//        super();
//    }

//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
////        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
////        toDoService = (TodoService) webApplicationContext.getBean("todoService");
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean isInt = Utils.isInteger(id);
        if (isInt) {
            Todo todo = toDoService.getToDo(id);
            if (todo == null) {
                request.setAttribute("error", "No ToDo found for this id: " + id);
            } else {
                request.setAttribute("todo", todo);
            }
        } else {
            request.setAttribute("error", "id must be an integer value.");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
