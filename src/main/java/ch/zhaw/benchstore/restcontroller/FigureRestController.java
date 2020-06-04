package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Figure;
import ch.zhaw.benchstore.repositories.FigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


	@RequestMapping(value = "benchstore/figures", method = RequestMethod.POST)
	Figure newFigure(@RequestBody Figure newFigure) {
		return repository.save(newFigure);
	}

	@RequestMapping(value = "benchstore/figures/{id}", method = RequestMethod.DELETE)
	public void deleteFigure(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
