package co.edu.uptc.controllers;

import co.edu.uptc.entityes.Product;
import co.edu.uptc.responses.ResponseHandler;
import co.edu.uptc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produts")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Object> findAll (){
        try {
            List<Product> result = productService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result );
        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        try {
            Product product = productService.findById(id);

            return  ResponseHandler.generateResponse("Success",HttpStatus.OK,product );
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Product customer){
        try {
            Product result = productService.save( customer );

            return  ResponseHandler.generateResponse("Success",HttpStatus.CREATED,result);

        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }


}
