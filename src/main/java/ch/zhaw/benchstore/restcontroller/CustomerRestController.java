package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Customer;
import ch.zhaw.benchstore.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping(value = "benchstore/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Customer>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/customer/{id}", method = RequestMethod.GET)
	public Optional<Customer> getCustomerById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "benchstore/customer/add", method = RequestMethod.POST)
	public ResponseEntity<Customer>  newCustomer(@RequestBody Customer newCustomer) {
		return new ResponseEntity<Customer>(repository.save(newCustomer), HttpStatus.CREATED);
	}

	@RequestMapping(value = "benchstore/customer/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
