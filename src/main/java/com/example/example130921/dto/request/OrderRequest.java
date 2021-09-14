package com.example.example130921.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @NotNull
    private int customerId;
    @NotNull
    private int employeeId;
    private Date orderDate;
}
