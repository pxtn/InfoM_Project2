package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
