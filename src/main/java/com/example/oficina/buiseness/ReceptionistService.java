package com.example.oficina.buiseness;


import com.example.oficina.Repository.ReceptionistRepository;
import com.example.oficina.controllers.DTOs.ReceptionistDTOS.CreateReceptionistDTO;
import com.example.oficina.controllers.DTOs.ReceptionistDTOS.LoginReceptionistDTO;
import com.example.oficina.controllers.DTOs.ReceptionistDTOS.UpdateReceptionistDTO;
import com.example.oficina.infrastrure.exceptions.ConflictException;
import com.example.oficina.models.Receptionist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceptionistService {

    private  final ReceptionistRepository ReceptionistRepositoRy;


    public  Long createReceptionist(CreateReceptionistDTO atendetorDTO){

            if(ReceptionistRepositoRy.existsByUsername(atendetorDTO.username())){

                throw  new ConflictException("Ther is an user with this username "+atendetorDTO.username());
            }
        var atendetor=new Receptionist(null,atendetorDTO.name(),
                atendetorDTO.username(), atendetorDTO.password(),
                Instant.now(),null);

          var entity=  ReceptionistRepositoRy.save(atendetor);

            return  entity.getId();
    }

    public Receptionist login(LoginReceptionistDTO loginAtendetorDTO){

        Optional<Receptionist> entity=ReceptionistRepositoRy.findByUsername(loginAtendetorDTO.username());

        if(entity.isPresent()){
            var user=entity.get();
            if (user.getPassword()==loginAtendetorDTO.password()){
                System.out.println("Login feito com sucesso");
                return  user;
            }


        }

        return  null;
    }

    public Receptionist getRecepcionistById(Long id){

        var entity=ReceptionistRepositoRy.findById(id);
        if(entity.isPresent()){


            return  entity.get();
        }


        return  null;

    }


    public  void deleteuserbyId(Long id){

        if(ReceptionistRepositoRy.existsById(id)){

            ReceptionistRepositoRy.deleteById(id);

        }

    }

    public List<Receptionist>  listUsers (){


        return  ReceptionistRepositoRy.findAll();
    }

    public Receptionist updateUser(UpdateReceptionistDTO atendetor, Long id){

        var entity=ReceptionistRepositoRy.findById( id);

        if(entity.isPresent()){
            var user=entity.get();
            boolean update=false;
            if(atendetor.username()!=null && atendetor.username()!=""){

                user.setUsername(atendetor.username());
                update=true;
            }  if(atendetor.password()!=null && atendetor.password()!=""){

                user.setPassword(atendetor.password());
                update=true;
            }
            if(update){
                user.setUpdatedat(Instant.now());
            }



            return  ReceptionistRepositoRy.save(user);

        }



        return  null;
    }
}
