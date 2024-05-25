package com.antran.demo.Service;

import com.antran.demo.entity.Customer;
import com.antran.demo.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Optional<Customer> getAllCustomerById(int id);
     Customer createCustomer(Customer customer);
     List<Customer> getAllCustomers();
     Customer updateCustomer(int id, Customer customerDetails);
    void deleteCustomer(int id);
}
