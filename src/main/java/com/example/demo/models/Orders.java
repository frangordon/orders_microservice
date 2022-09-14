package com.example.demo.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Column
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="productName", nullable = false)
    private String productName;
    @Column(name="productId", nullable = false)
    private Integer productId;
    @Column(name="userId", nullable = false)
    private Integer userId;
    @Column(name="date", nullable = false)
    private String date;
    @Column(name="deliveryMethod", nullable = false)
    private String deliveryMethod;

}
