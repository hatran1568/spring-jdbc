package com.example.example130921.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
