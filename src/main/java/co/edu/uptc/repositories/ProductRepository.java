package co.edu.uptc.repositories;

import co.edu.uptc.entityes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
