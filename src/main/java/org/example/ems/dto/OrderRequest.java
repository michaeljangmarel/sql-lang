package org.example.ems.dto;

public record OrderRequest (
        Long userId ,  Long proId , Integer qty
){
}
