package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Product;
import ch.zhaw.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
