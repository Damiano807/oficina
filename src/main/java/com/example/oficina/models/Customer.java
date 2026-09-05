package com.example.oficina.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cliente")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;
    @Column(name="BI",length =16)
    private String BI;
    private Instant createdAt;
    private  Instant updateAt;
    @OneToMany(mappedBy="customer")
   private List<Vehicle> veiculos;

    @ManyToOne
    @JoinColumn(name="recepcionistId",referencedColumnName = "id")
    private  Receptionist receptionist;
 }
