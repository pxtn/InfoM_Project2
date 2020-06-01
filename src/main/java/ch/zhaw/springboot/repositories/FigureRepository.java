package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Figure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FigureRepository extends JpaRepository<Figure, Long> {

}
