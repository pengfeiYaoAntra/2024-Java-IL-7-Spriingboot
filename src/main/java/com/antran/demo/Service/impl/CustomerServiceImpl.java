package com.antran.demo.Service.impl;

import com.antran.demo.Service.CustomerService;
import com.antran.demo.entity.Customer;
import com.antran.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }
    @Override
    public Optional<Customer> getAllCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));

        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setAge(customerDetails.getAge());
        customer.setCountry(customerDetails.getCountry());

        return customerRepository.save(customer);
    }
    public void deleteCustomer(int id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));

        customerRepository.delete(customer);
    }
}
