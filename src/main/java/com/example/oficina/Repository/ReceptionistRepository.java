package com.example.oficina.Repository;

import com.example.oficina.models.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist,Long> {

    boolean  existsByUsername(String username);


    Optional<Receptionist> findByUsername(String username);
}
