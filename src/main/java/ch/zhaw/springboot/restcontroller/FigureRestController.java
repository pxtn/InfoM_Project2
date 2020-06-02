package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Figure;
import ch.zhaw.springboot.repositories.FigureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
