package com.example.oficina.buiseness;

import com.example.oficina.Repository.ReceptionistRepository;
import com.example.oficina.controllers.DTOs.ReceptionistDTOS.CreateReceptionistDTO;
import com.example.oficina.models.Receptionist;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class ReceptionistServiceTest {

    @Mock
    private ReceptionistRepository recepcionistRepositoRy;

    @InjectMocks
    private ReceptionistService recepcionistService;
    @Captor
    private  ArgumentCaptor<Long> argumentCaptorId;

    @Captor
    private ArgumentCaptor<Receptionist> argumentCaptorRecepcionist;
@Captor
private  ArgumentCaptor<String> argumentCaptorUsername;
    @Nested
    class CreateReceptionist {
        @Test
        @DisplayName("Should ncreate an ate ")

         void shoudCreatAnAtendettor() {
            Long id=50+ new Random().nextLong();
            var atendetor=new Receptionist(id,"name",
                    "username","password",
                    Instant.now(),null);

            var input =new CreateReceptionistDTO("name",
                    "username","email",
                    "password");
            doReturn(atendetor).when(recepcionistRepositoRy).save(argumentCaptorRecepcionist.capture());
           // doReturn(Optional.of(atendetor)).when(atendedorRepositoRy).findByUsername(argumentCaptorUsername.capture());

     var output=recepcionistService.createReceptionist(input);

     var capture=argumentCaptorRecepcionist.getValue();
        assertNotNull(output);
        assertEquals(capture.getName(),input.name());
            assertEquals(capture.getUsername(),input.username());
            assertEquals(capture.getPassword(),input.password());







        }
        @Test
        @DisplayName("ShouldGetARecepcionist")
        void  ShouldGetARecepcionist(){
            Long id=50+new Random().nextLong();
            var recepcionist=new Receptionist(id,"name",
                    "username","password",
                    Instant.now(),null);
            doReturn(Optional.of(recepcionist)).when(recepcionistRepositoRy).findById(argumentCaptorId.capture());
            var output=recepcionistService.getRecepcionistById(id);

            assertNotNull(output);
            assertEquals(argumentCaptorId.getValue(),output.getId());

        }
        @Test
        @DisplayName("Should List of Recepcionits")

        void ShouldListARecepcionist(){

            Long id=50+new Random().nextLong();
            var recepcionist  = new Receptionist(id,"name","username","email",Instant.now(),null);
            var list= List.of(recepcionist) ;
            doReturn(list).when(recepcionistRepositoRy).findAll();

            var ouput=recepcionistRepositoRy.findAll();
            assertNotNull(ouput);
            assertEquals(list.size(),ouput.size());
        }

        }
        @Test
    @DisplayName("Should Delete a Recepcionist")

    void ShouldDeleteARecepcionist(){



        }
    }

