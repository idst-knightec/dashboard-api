package com.example.dashboard_api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(String id) {

        UUID uuid = UUID.fromString(id);
        Optional<Customer> optionalCustomer = customerRepo.findById(uuid);
        if (optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }
        log.info("Customer with id: {} doesn't exist", id);
        return null;
    }

    public Customer saveCustomer (Customer customer) {
        Customer savedCustomer = customerRepo.save(customer);

        log.info("Customer with id: {} saved successfully", customer.getId());
        return savedCustomer;
    }
}
