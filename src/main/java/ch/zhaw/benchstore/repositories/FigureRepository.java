package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Figure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FigureRepository extends JpaRepository<Figure, Long> {

}
