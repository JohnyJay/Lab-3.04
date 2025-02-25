package com.lab._4.repository;

import com.lab._4.model.Customer;
import com.lab._4.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerName(String name);
    List<Customer> findAllByStatus(CustomerStatus status);

}
