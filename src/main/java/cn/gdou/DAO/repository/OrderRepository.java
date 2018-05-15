package cn.gdou.DAO.repository;

import cn.gdou.DAO.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String>,OrderOpearations {
   //自定义方法
    List<Order> findByCustomer(String c);

    //指定查询,json语句格式
    @Query("{'customer': ?0}")
    List<Order> findOrders(String c);


}
