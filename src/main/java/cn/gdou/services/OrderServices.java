package cn.gdou.services;

import cn.gdou.DAO.model.Item;
import cn.gdou.DAO.model.Order;
import cn.gdou.DAO.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public Order orderSave(){
        LinkedHashSet<Item> set=new LinkedHashSet<>();
        Item item=new Item(Long.parseLong("2"),"apple",120,10);
        set.add(item);
        Order order=new Order("2","Wisem","guest",set);
        order=orderRepository.save(order);
        return order;
    }

    public List<Order> findOrdersByCustomer(){
        return orderRepository.findByCustomer("Wisem");
    }

    public List<Order> queryOrders(){
        return orderRepository.findOrders("Wisem");
    }

    public List<Order> findOrdersByType(String t){
        return orderRepository.findOrdersByType(t);
    }
}
