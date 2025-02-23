package com.cpweb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cpweb.backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
