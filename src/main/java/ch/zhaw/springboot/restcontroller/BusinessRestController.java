package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Business;
import ch.zhaw.springboot.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessRestController {

	@Autowired
	private BusinessRepository repository;

	@RequestMapping(value = "benchstore/businesses", method = RequestMethod.GET)
	public ResponseEntity<List<Business>> getBusinesses() {
		List<Business> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Business>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Business>>(HttpStatus.NOT_FOUND);
		}
	}
}
