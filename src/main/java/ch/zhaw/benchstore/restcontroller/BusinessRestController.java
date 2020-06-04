package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Business;
import ch.zhaw.benchstore.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value = "benchstore/businesses", method = RequestMethod.POST)
	Business newBusiness(@RequestBody Business newBusiness) {
		return repository.save(newBusiness);
	}

	@RequestMapping(value = "benchstore/businesses/{id}", method = RequestMethod.DELETE)
	public void deleteBusiness(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
