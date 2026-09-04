package com.example.oficina.Repository;


import com.example.oficina.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Customer,Long> {
}
