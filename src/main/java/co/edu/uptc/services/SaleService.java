package co.edu.uptc.services;

import co.edu.uptc.repositories.SaleRepository;
import co.edu.uptc.entityes.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public Sale save (Sale sale){
        return saleRepository.save(sale);
    }
}
