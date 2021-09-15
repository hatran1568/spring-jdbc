package com.example.example130921.utils.validation;

import com.example.example130921.utils.ForeignKeyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= ForeignKeyValidator.class)
public @interface CustomerId {

    String message() default "Customer id conflicts with foreign key constraint";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
