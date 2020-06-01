package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private double price;

	@ManyToMany
	List<Supplier> suppliers = new ArrayList<Supplier>();
	@ManyToMany
	List<Order> orders = new ArrayList<Order>();

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Product() {
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public void addSupplier(Supplier s) {
		this.suppliers.add(s);
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void addOrder(Order o) {
		this.orders.add(o);
	}

	public List<Order> getOrders() {
		return orders;
	}
}
