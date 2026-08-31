package com.example.oficina.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.service.spi.InjectService;
//import jakarta.validation.constraints.NotBlank;
import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="atendetor")
public class Atendetor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;



    private  String name;

    private String username;
    private  String password;
    private Instant createat;
    private  Instant updatedat;




}
