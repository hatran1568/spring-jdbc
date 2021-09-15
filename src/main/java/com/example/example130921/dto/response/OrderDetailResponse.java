package com.example.example130921.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private int orderId;
    private int productId;
    private int quantity;
}
