package co.edu.uptc.controllers;

import co.edu.uptc.entityes.Customer;
import co.edu.uptc.responses.ResponseHandler;
import co.edu.uptc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> findAll (){
        try {
            List<Customer> result = customerService.findAll();
            return ResponseHandler.generateResponse("Success",HttpStatus.OK, result );
        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try {
            Customer customer = customerService.findById(id);

            return  ResponseHandler.generateResponse("Success",HttpStatus.OK,customer );
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Customer customer){
        try {
            Customer result = customerService.save( customer );

            return  ResponseHandler.generateResponse("Success",HttpStatus.CREATED,result);

        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try{
            Customer customer = customerService.findById(id);
            if(customer != null){
                customerService.delete(customer);
                return ResponseHandler.generateResponse("Succes",HttpStatus.ACCEPTED, customer );
            }else{
                return ResponseHandler.generateResponse("Success",HttpStatus.NOT_FOUND, null );
            }

        }catch( Exception e ){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }

    }
}
