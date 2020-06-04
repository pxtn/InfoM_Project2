package ch.zhaw.benchstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends Person {

	private String shippingAddress;
	private String email;

	@OneToMany(
			mappedBy = "customer",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Order> orders = new ArrayList<>();

	public Customer(String name, String surname, String address, Date birthDate, String email, String shippingAddress) {
		super(name, surname, address, birthDate);
		this.email = email;
		this.shippingAddress = shippingAddress;
	}

	public Customer() {
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public String getEmail() {
		return email;
	}
}
