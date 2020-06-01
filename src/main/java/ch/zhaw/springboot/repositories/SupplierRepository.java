package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
