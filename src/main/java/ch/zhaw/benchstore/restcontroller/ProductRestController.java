package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Product;
import ch.zhaw.benchstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository repository;

	@RequestMapping(value = "benchstore/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/product/{id}", method = RequestMethod.GET)
	public Optional<Product> getProductById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "benchstore/product/add", method = RequestMethod.POST)
	public ResponseEntity<Product>  newProduct(@RequestBody Product newProduct) {
		return new ResponseEntity<Product>(repository.save(newProduct), HttpStatus.CREATED);
	}

	@RequestMapping(value = "benchstore/product/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
