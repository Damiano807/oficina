package com.example.oficina.controllers;


import com.example.oficina.buiseness.ReceptionistService;
import com.example.oficina.controllers.DTOs.ReceptionistDTOS.CreateReceptionistDTO;
import com.example.oficina.controllers.DTOs.ReceptionistDTOS.UpdateReceptionistDTO;
import com.example.oficina.models.Receptionist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atendetor")
@RequiredArgsConstructor
public class ReceptionistController {

    private  final ReceptionistService ReceptionistService;


    @PostMapping("/creat")
    public ResponseEntity<Receptionist> creat(@RequestBody CreateReceptionistDTO atendetorDTO){
        var atendetorid=ReceptionistService.createReceptionist(atendetorDTO);


        return  ResponseEntity.created(URI.create("/atendetor/"+atendetorid.toString())).build();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Receptionist>  getById(@PathVariable("id")  Long id){

        var user=ReceptionistService.getRecepcionistById(id);

        return  ResponseEntity.ok(user);
    }
 @GetMapping
 public  ResponseEntity<List<Receptionist>> getAll(){

        var  listUsers=ReceptionistService.listUsers();

        return  ResponseEntity.ok(listUsers);

 }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteById(@PathVariable("id")  Long id){

        ReceptionistService.deleteuserbyId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Receptionist>  updateAtendetor(@PathVariable("id") Long id, @RequestBody UpdateReceptionistDTO updateAtendatorDTO){

        var user=ReceptionistService.updateUser(updateAtendatorDTO,id);

        return  ResponseEntity.ok(user);
    }


}
