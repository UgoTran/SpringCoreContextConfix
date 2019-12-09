package com.hivetech.servletjsp.servlet.customer;

import com.hivetech.servletjsp.model.Customer;
import com.hivetech.servletjsp.service.CustomerService;
import com.hivetech.servletjsp.service.impl.CustomerServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Logger;

@WebServlet("/customer/edit")
public class EditCustomerServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(InfoCustomerServlet.class.getName());

    private CustomerService customerService;

    public void init() {
        customerService = new CustomerServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int customerNumber = Integer.valueOf(request.getParameter("customerNumber"));
        String customerName = request.getParameter("customerName");
        String contactLastName = request.getParameter("contactLastName");
        String contactFirstName = request.getParameter("contactFirstName");
        String phone = request.getParameter("phone");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");
        String country = request.getParameter("country");
        Integer salesRepEmployeeNumber = Integer.parseInt(request.getParameter("salesRepEmployeeNumber"));
        Double creditLimit = Double.valueOf(request.getParameter("creditLimit"));
        LocalDate birthday = StringUtils.isAnyBlank(request.getParameter("birthday")) ?
                null : LocalDate.parse(request.getParameter("birthday"));

        Customer editionCustomer = new Customer(
                customerNumber,
                customerName,
                contactLastName,
                contactFirstName,
                phone,
                addressLine1,
                addressLine2,
                city,
                state,
                postalCode,
                country,
                salesRepEmployeeNumber,
                creditLimit,
                birthday
        );

        boolean updated = customerService.update(editionCustomer);
        response.sendRedirect("/customer/list");
        LOGGER.info(String.format("Method: %s | action: %s  | Updated: %b | Customer: %d  ",
                request.getMethod(), request.getRequestURI(), updated, customerNumber
        ));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
