package com.hivetech.servletjsp.servlet.customer;

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
import java.util.logging.Logger;

@WebServlet("/customer/add")
public class AddCustomerServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AddCustomerServlet.class.getName());

    private CustomerService customerService;

    public void init() {
        customerService = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("customerNumber"));
        Customer cust = customerService.getCustomerById(id);
        request.setAttribute("cust", cust);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/_customerInfo.jsp");
        dispatcher.forward(request, response);
    }
}
