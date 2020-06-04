package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
