package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
