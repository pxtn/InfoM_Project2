package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Order;
import ch.zhaw.springboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

	@Autowired
	private OrderRepository repository;

	@RequestMapping(value = "benchstore/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}


	@RequestMapping(value = "benchstore/orders", method = RequestMethod.POST)
	Order newOrder(@RequestBody Order newOrder) {
		return repository.save(newOrder);
	}

	@RequestMapping(value = "benchstore/orders/{id}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
