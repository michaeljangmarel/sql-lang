package org.example.ems.api;


import org.example.ems.dto.OrderRequest;
import org.example.ems.dto.OrderResponse;
import org.example.ems.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/add/pro")
public class OrderApi {
    @Autowired
    private OrderService orderService ;

    @PostMapping("/save")
    public ResponseEntity<List<OrderResponse>>addOrders(@RequestBody List<OrderRequest>  orderRequests ){
        List<OrderResponse>  orderResponses = orderService.addOrder(orderRequests);
        return  new ResponseEntity<>(orderResponses , HttpStatus.CREATED);
    }
}
