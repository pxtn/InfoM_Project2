package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
