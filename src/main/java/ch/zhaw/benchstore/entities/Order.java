package ch.zhaw.benchstore.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Date dateOfOrder;
	private Date dateOfDelivery;

	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(
			name = "order_product",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	List<Product> products = new ArrayList<Product>();

	@ManyToMany(mappedBy = "orders")
	List<Business> businesses = new ArrayList<Business>();

	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;

	public Order(Date dateOfOrder, Date dateOfDelivery, Customer customer) {
		this.dateOfOrder = dateOfOrder;
		this.dateOfDelivery = dateOfDelivery;
		this.customer = customer;
	}

	public Order() {
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
