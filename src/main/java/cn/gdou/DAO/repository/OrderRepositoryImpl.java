package cn.gdou.DAO.repository;

import cn.gdou.DAO.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class OrderRepositoryImpl implements OrderOpearations {

    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Order> findOrdersByType(String t) {
        String type=t.equals("admin")?"guest":t;
        Criteria where=Criteria.where("type").is(type);
        Query query=Query.query(where);
        return mongo.find(query,Order.class);
    }
}
