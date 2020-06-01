package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {

}
