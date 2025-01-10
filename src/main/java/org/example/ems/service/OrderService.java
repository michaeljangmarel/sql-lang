package org.example.ems.service;

import org.example.ems.dto.OrderRequest;
import org.example.ems.dto.OrderResponse;
import org.example.ems.model.Order;
import org.example.ems.model.Product;
import org.example.ems.model.User;
import org.example.ems.repo.OrderRepo;
import org.example.ems.repo.ProductRepo;
import org.example.ems.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private  ProductRepo  productRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;

    public List<OrderResponse> addOrder(List<OrderRequest> orderRequest) {
        List<Order> orders = new ArrayList<>();
        for (var  order : orderRequest) {
            User user = userRepo.findById(order.userId()).orElseThrow( () -> new RuntimeException("User not found"));
            Product product = productRepo.findById(order.proId()).orElseThrow( () -> new RuntimeException("Product not found"));
            Order  order1 = new Order(user , product , order.qty());
            orders.add(order1);
        }
        List<Order> savedOrder = orderRepo.saveAll(orders);
        return  savedOrder.stream().map(order -> new OrderResponse(order.getId() , order.getUser().getFullName() , order.getProduct().getName() , order.getQty() , order.getProduct().getPrice())).collect(Collectors.toUnmodifiableList());
    }

}
