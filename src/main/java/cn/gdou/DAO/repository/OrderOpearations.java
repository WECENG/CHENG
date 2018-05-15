package cn.gdou.DAO.repository;

import cn.gdou.DAO.model.Order;

import java.util.List;

public interface OrderOpearations {
    List<Order> findOrdersByType(String t);
}
