package com.example.oficina.buiseness;


import com.example.oficina.Repository.CustomerRepository;
import com.example.oficina.Repository.ReceptionistRepository;
import com.example.oficina.controllers.DTOs.CustomerDTO.CreateCustomerDTO;
  import com.example.oficina.infrastrure.exceptions.ConflictException;
import com.example.oficina.models.Customer;
import com.example.oficina.models.Receptionist;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    //private   final  CustomerService customerService;
    private  final CustomerRepository customerRepository;
private  final ReceptionistRepository receptionistRepository;

    public Customer createCustomer(Long id,CreateCustomerDTO createCustomerDTO){


        if(!receptionistRepository.existsById(id)){
            throw  new ConflictException("Não existe um recepcionista com esse nome");
        }
        if (customerRepository.existsByBI(createCustomerDTO.BI())){
            throw  new ConflictException("Ja existe um cliente com ese BI");

        }
        System.out.println("This id is "+id);
        var custmer=new Customer();


        custmer.setName(createCustomerDTO.name());
              custmer.setCreatedAt(Instant.now());

                      custmer.setBI( createCustomerDTO.BI());
                        custmer.setReceptionist(receptionistRepository.findById(id).get());

        return customerRepository.save(custmer);




    }



    public  Customer getCustomerByid(Long id){
        if(customerRepository.existsById(id)){
            throw  new ConflictException("Cliente nao encontrado");
        }
        var entity=customerRepository.findById(id);
        return  entity.get();
    }


    public  void  deleteById(Long id){

        if(customerRepository.existsById(id)){

            customerRepository.deleteById(id);
        }

    }

    public List<Customer> ListCustmers(){

        return  customerRepository.findAll();
    }
    public  Customer findCustomerByName(String name){

        var entity=customerRepository.findByName(name);

        if(entity.isPresent()){

            return  entity.get();
        }

        return  null;
    }


}
