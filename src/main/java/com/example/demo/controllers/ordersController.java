package com.example.demo.controllers;

import com.example.demo.models.Orders;
import com.example.demo.repositories.IOrdersRepository;
//import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
public class ordersController {

    @Autowired
    private IOrdersRepository repository;

    @GetMapping("/orders")
    public List<Orders> getOrders() { return repository.findAll(); }

    @GetMapping("/orders/{id}")
    public Optional<Orders> getOrdersById(@PathVariable Integer id) { return repository.findById(id); };


    @PostMapping("/orders")
    public Orders postOrders(@RequestBody Orders orders) {
        repository.save(orders);
        return repository.save(orders);
    }

    @PutMapping("/orders/{id}")
    public Orders updateOrders(@PathVariable int id, @Validated @RequestBody Orders orderRequest) {
        return repository.findById(id)
                .map(order -> {
                    if (orderRequest.getProductName() != null) {
                        order.setProductName(orderRequest.getProductName());
                    }
                    if (orderRequest.getProductId() != null) {
                        order.setProductId(orderRequest.getProductId());
                    }
                    if (orderRequest.getUserId() != null) {
                        order.setUserId(orderRequest.getUserId());
                    }
                    if (orderRequest.getDate() != null) {
                        order.setDate(orderRequest.getDate());
                    }
                    if (orderRequest.getDeliveryMethod() != null) {
                        order.setDeliveryMethod(orderRequest.getDeliveryMethod());
                    }
                    return repository.save(order);
                }).orElseThrow(() -> new EntityNotFoundException("No product found with ID " + id));
    }

    @DeleteMapping("orders/{id}")
    public String deleteOrders(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Orders Deleted";
    }


}