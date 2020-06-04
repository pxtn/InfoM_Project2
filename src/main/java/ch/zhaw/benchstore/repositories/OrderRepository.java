package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
