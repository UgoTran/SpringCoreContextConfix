package com.hivetech.servletjsp.service;

import com.hivetech.servletjsp.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> orders();
    boolean add(Order order);
    boolean update(Order order);
    boolean delete(int id);
}
