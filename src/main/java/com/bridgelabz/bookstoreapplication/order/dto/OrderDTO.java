package com.bridgelabz.bookstoreapplication.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
    private Long cart_id;
    private String address;
}
