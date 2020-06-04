package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Supplier;
import ch.zhaw.benchstore.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupplierRestController {

	@Autowired
	private SupplierRepository repository;

	@RequestMapping(value = "benchstore/suppliers", method = RequestMethod.GET)
	public ResponseEntity<List<Supplier>> getSuppliers() {
		List<Supplier> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Supplier>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Supplier>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/supplier/{id}", method = RequestMethod.GET)
	public Optional<Supplier> getSupplierById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "benchstore/supplier/add", method = RequestMethod.POST)
	public ResponseEntity<Supplier>  newSupplier(@RequestBody Supplier newSupplier) {
		return new ResponseEntity<Supplier>(repository.save(newSupplier), HttpStatus.CREATED);
	}

	@RequestMapping(value = "benchstore/supplier/{id}", method = RequestMethod.DELETE)
	public void deleteSupplier(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
