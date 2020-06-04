package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String initiator;
	private Date dateOfOrder;
	private Date dateOfDelivery;

	@ManyToMany
	List<Product> products = new ArrayList<Product>();
	@ManyToMany
	List<Business> businesses = new ArrayList<Business>();

	@ManyToOne
	private Customer customer;

	public Order(String initiator, Date dateOfOrder, Date dateOfDelivery, Customer customer) {
		this.initiator = initiator;
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
		this.customer = customer;
	}

	public Order() {
	}

	public String getInitiator() {
		return this.initiator;
	}

	public Date getDateOfOrder() {
		return this.dateOfOrder;
	}

	public Date getDateOfDelivery() {
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

	public Customer getCustomer() {
		return customer;
	}
}
