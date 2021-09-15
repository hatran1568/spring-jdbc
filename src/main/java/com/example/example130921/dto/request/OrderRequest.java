package com.example.example130921.dto.request;

import com.example.example130921.utils.validation.CustomerId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest {
    @NotNull
    @CustomerId
    private Integer customerId;

    @NotNull
    private Integer employeeId;

    @FutureOrPresent
    private Date orderDate;
}
