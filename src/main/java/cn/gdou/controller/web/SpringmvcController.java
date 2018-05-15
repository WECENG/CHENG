package cn.gdou.controller.web;

import cn.gdou.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("spring")
public class SpringmvcController {
    @Autowired
    private OrderServices orderServices;

    @RequestMapping(value = "order",method = RequestMethod.GET)
    public String showOrder(Model model){
        model.addAttribute("order",orderServices.orderSave());
        model.addAttribute("order1",orderServices.findOrdersByCustomer());
        model.addAttribute("order2",orderServices.queryOrders());
        model.addAttribute("order3",orderServices.findOrdersByType("admin"));
        return "order";
    }
}
