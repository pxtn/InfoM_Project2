package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
