package com.example.oficina.Repository;


import com.example.oficina.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsByBI(String BI);


    Optional<Customer> findByName(String name);
}
