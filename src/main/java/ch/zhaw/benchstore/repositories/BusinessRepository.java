package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {

}
