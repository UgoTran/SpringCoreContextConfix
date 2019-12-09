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
import java.util.logging.Logger;

@WebServlet("/customer/info")
public class InfoCustomerServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(InfoCustomerServlet.class.getName());

    private CustomerService customerService;

    public void init() {
        customerService = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("customerNumber"));
        Customer selectedCustomer = customerService.getCustomerById(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/_customerInfo.jsp");
        request.setAttribute("selectedCustomer", selectedCustomer);
        dispatcher.forward(request, response);

        LOGGER.info("action: " + request.getServletPath() + " | Customer: " + id);
    }

}
