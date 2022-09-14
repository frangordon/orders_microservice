package com.example.demo.repositories;

import com.example.demo.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<Orders, Integer> {
}
