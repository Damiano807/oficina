package com.example.oficina.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String matricula;
    private  String cor;
    private  String marca;
    private  String descricao;
    private Instant registered_at;
    private  Instant delivery_date;
    private  Status statu=Status.AVALIANDO;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="cliente_id",nullable = false)
    private  Cliente cliente;


}
