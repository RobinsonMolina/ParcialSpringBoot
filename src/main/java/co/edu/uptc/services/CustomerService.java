package co.edu.uptc.services;

import co.edu.uptc.repositories.CustomerRepository;
import co.edu.uptc.entityes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return  customerRepository.findAll();
    }

    public Customer findById(Integer id){
        Optional<Customer> optional = customerRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Customer save (Customer customer){
        return customerRepository.save(customer);
    }

    public void delete (Customer customer){
        customerRepository.delete(customer);
    }
}
