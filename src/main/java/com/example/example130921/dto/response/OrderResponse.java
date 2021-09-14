package com.example.example130921.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int orderId;
    private int customerId;
    private int employeeId;
    private Date orderDate;
}
