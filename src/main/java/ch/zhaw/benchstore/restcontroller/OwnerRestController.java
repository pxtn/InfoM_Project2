package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Owner;
import ch.zhaw.benchstore.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OwnerRestController {

	@Autowired
	private OwnerRepository repository;

	@RequestMapping(value = "benchstore/owners", method = RequestMethod.GET)
	public ResponseEntity<List<Owner>> getOwners() {
		List<Owner> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Owner>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Owner>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/owner/{id}", method = RequestMethod.GET)
	public Optional<Owner> getOwnerById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "benchstore/owner/add", method = RequestMethod.POST)
	public ResponseEntity<Owner>  newOwner(@RequestBody Owner newOwner) {
		return new ResponseEntity<Owner>(repository.save(newOwner), HttpStatus.CREATED);
	}

	@RequestMapping(value = "benchstore/owner/{id}", method = RequestMethod.DELETE)
	public void deleteOwner(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
