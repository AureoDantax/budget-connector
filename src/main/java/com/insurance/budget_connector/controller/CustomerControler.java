package com.insurance.budget_connector.controller;

import com.insurance.budget_connector.dto.CustomerRequestDTO;
import com.insurance.budget_connector.model.Customer;
import com.insurance.budget_connector.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerControler {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO)  {
        var cust = customerService.createCustomer(customerRequestDTO);
        return ResponseEntity.ok(cust);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        var cust = customerService.getCustomer(id);
        return ResponseEntity.ok(cust);
    }
}
