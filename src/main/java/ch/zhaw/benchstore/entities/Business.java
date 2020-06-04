package ch.zhaw.benchstore.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String address;
	private long employeeCount;
	private long retailSpace;

	@ManyToMany
	List<Order> orders = new ArrayList<Order>();

	@ManyToOne
	private Owner owner;

	public Business(String name, String address, long employeeCount, long retailSpace, Owner owner) {
		this.name = name;
		this.address = address;
		this.employeeCount = employeeCount;
		this.retailSpace = retailSpace;
		this.owner = owner;
	}

	public Business() {
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public long getRetailSpace() {
		return this.retailSpace;
	}

	public long getEmployeeCount() {
		return this.employeeCount;
	}

	public void addOrder(Order o) {
		this.orders.add(o);
	}

	public List<Order> getOrders() {
		return orders;
	}

	public Owner getOwner() {
		return owner;
	}
}
