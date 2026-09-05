package com.example.oficina.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="recepcionist")
@NoArgsConstructor
public class Receptionist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;



    private  String name;

    private String username;
    private  String password;
    private Instant createat;
    private  Instant updatedat;

    @OneToMany
  private List<Customer> customers;




}
