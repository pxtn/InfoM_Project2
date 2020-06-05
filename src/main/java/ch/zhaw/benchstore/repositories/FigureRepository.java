package ch.zhaw.benchstore.repositories;

import ch.zhaw.benchstore.entities.Figure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FigureRepository extends JpaRepository<Figure, Long> {

    @Query("SELECT fig FROM Figure fig WHERE fig.business.id = ?1")
    public List<Figure> getFiguresForBusiness(long business_id);

    @Query("SELECT fig FROM Figure fig WHERE fig.business.id = ?1 AND YEAR(fig.date) = ?2 AND MONTH(fig.date) = ?3")
    public List<Figure> getFiguresForBusinessByMonthOfYear(long business_id, int year, int month);

}
