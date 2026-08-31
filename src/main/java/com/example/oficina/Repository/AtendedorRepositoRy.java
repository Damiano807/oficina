package com.example.oficina.Repository;

import com.example.oficina.models.Atendetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendedorRepositoRy  extends JpaRepository<Atendetor,Long> {
}
