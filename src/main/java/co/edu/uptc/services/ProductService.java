package co.edu.uptc.services;

import co.edu.uptc.entityes.Product;
import co.edu.uptc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return  productRepository.findAll();
    }

    public Product findById(Integer id){
        Optional<Product> optional = productRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    public Product save (Product product){
        return productRepository.save(product);
    }
    public Product update(Product product) {
        // Verificar si el producto existe en la base de datos
        Product existingProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Actualizar el stock del producto con el nuevo valor
        existingProduct.setStock(product.getStock());

        // Guardar el producto actualizado en la base de datos
        return productRepository.save(existingProduct);
    }

}
