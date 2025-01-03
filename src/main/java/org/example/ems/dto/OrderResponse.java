package org.example.ems.dto;

public record OrderResponse(
        Long orderId , String userName , String proName , Integer qty  ,Double price
){
}
