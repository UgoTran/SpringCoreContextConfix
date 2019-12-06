package com.hivetech.servletjsp.servlet;

import com.hivetech.servletjsp.model.Order;
import com.hivetech.servletjsp.service.OrderService;
import com.hivetech.servletjsp.service.impl.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;

    public void init(){
        orderService = new OrderServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> list = orderService.orders();

        request.setAttribute("listOrder", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/_listOrder.jsp");
        dispatcher.forward(request, response);
    }
}
