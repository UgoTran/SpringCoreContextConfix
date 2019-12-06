package com.hivetech.servletjsp.service.impl;

import com.hivetech.servletjsp.model.Order;
import com.hivetech.servletjsp.service.OrderService;
import com.hivetech.servletjsp.util.Connection_Utils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

//    private static String SELECT_ORDERS = "SELECT * FROM orders LIMIT 10;";
    private static String SELECT_ORDERS = "SELECT o.*, c.customerName FROM orders AS o LEFT JOIN customers AS c ON o.customerNumber=c.customerNumber LIMIT 10;";

    @Override
    public List<Order> orders() {
        List<Order> list = new ArrayList<>();
        try {
            Statement stm = Connection_Utils.connect().createStatement();
            ResultSet rs = stm.executeQuery(SELECT_ORDERS);


            while (rs.next()) {
                int id = rs.getInt(1);
                Date orderDate = rs.getDate("orderDate");
                Date requiredDate = rs.getDate("requiredDate");
                Date shippedDate = rs.getDate("shippedDate");
                String status = rs.getString("status");
                String comments = rs.getString("comments");
                String customerName = rs.getString("customerName");

                Order tempOrder = new Order(id, orderDate, requiredDate,
                        shippedDate, status, comments, customerName);

                list.add(tempOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean add(Order order) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
