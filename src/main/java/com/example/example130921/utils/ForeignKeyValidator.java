package com.example.example130921.utils;

import com.example.example130921.dao.repository.CustomerRepository;
import com.example.example130921.dto.request.OrderRequest;
import com.example.example130921.utils.validation.CustomerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ForeignKeyValidator implements ConstraintValidator<CustomerId, OrderRequest> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void initialize(CustomerId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(OrderRequest orderRequest, ConstraintValidatorContext constraintValidatorContext) {
        return customerRepository.getIdList().contains(orderRequest.getCustomerId());
    }


}
