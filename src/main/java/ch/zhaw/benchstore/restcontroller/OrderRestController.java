package ch.zhaw.benchstore.restcontroller;

import ch.zhaw.benchstore.entities.Order;
import ch.zhaw.benchstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@RequestMapping(value = "benchstore/orders/delayed", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getDelayedOrders() {
		List<Order> result = this.repository.getDelayedOrders();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/orders/{customer_id}", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrdersFromCustomerWithId(@PathVariable Long customer_id) {
		List<Order> result = this.repository.getOrdersFromCustomerWithId(customer_id);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "benchstore/order/{id}", method = RequestMethod.GET)
	public Optional<Order> getOrderById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = "benchstore/order/{id}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
