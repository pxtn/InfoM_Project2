package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Figure;
import ch.zhaw.benchstore.repositories.FigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FigureRestController {

	@Autowired
	private FigureRepository repository;

	@RequestMapping(value = "benchstore/figures", method = RequestMethod.GET)
	public ResponseEntity<List<Figure>> getFigures() {
		List<Figure> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Figure>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Figure>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/figures/{business_id}", method = RequestMethod.GET)
	public ResponseEntity<List<Figure>> getFiguresForBusiness(@PathVariable Long business_id) {
		List<Figure> result = this.repository.getFiguresForBusiness(business_id);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Figure>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Figure>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/figures/{business_id}/{year}/{month}", method = RequestMethod.GET)
	public ResponseEntity<List<Figure>> getFiguresForBusinessByMonthOfYear(@PathVariable Long business_id, @PathVariable int year, @PathVariable int month) {
		List<Figure> result = this.repository.getFiguresForBusinessByMonthOfYear(business_id, year, month);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Figure>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Figure>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/figure/{id}", method = RequestMethod.GET)
	public Optional<Figure> getFigureById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "benchstore/figure/{id}", method = RequestMethod.DELETE)
	public void deleteFigure(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
