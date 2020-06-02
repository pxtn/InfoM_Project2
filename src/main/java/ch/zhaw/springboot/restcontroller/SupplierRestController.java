package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Supplier;
import ch.zhaw.springboot.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
