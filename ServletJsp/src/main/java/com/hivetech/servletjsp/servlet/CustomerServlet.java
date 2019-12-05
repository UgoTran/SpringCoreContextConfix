package com.hivetech.servletjsp.servlet;

import com.hivetech.servletjsp.model.Customer;
import com.hivetech.servletjsp.service.CustomerService;
import com.hivetech.servletjsp.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet{
    private CustomerService customerService;

    public void init(){
        customerService = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Customer> list = customerService.customers();

        request.setAttribute("listCustomer", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/_listCustomer.jsp");
        dispatcher.forward(request, response);

//        String action = request.getServletPath();
//        switch (action){
//            case "/list":
//                listCustomer(request,response);
//                break;
//
//            case "/delete":
//                deleteCustomer(request,response);
//                break;
//            default:
//                RequestDispatcher dispatcher = request.getRequestDispatcher("views/_404.jsp");
//                dispatcher.forward(request,response);
//                break;
//        }
    }

//    CRUD
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = customerService.customers();

        request.setAttribute("listCustomer", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/_listCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(1111);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
