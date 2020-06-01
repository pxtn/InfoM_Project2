package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String initiator;
	private LocalDateTime dateOfOrder;
	private LocalDateTime dateOfDelivery;

	@ManyToMany
	List<Product> products = new ArrayList<Product>();
	@ManyToMany
	List<Business> businesses = new ArrayList<Business>();

	public Order(String initiator, LocalDateTime dateOfOrder, LocalDateTime dateOfDelivery) {
		this.initiator = initiator;
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
	}

	public Order() {
	}

	public String getInitiator() {
		return this.initiator;
	}

	public LocalDateTime getDateOfOrder() {
		return this.dateOfOrder;
	}

	public LocalDateTime getDateOfDelivery() {
		return this.dateOfDelivery;
	}

	public void addProduct(Product p) {
		this.products.add(p);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addBusiness(Business b) {
		this.businesses.add(b);
	}

	public List<Business> getBusinesses() {
		return businesses;
	}
}
