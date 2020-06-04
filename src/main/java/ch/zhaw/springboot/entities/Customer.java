package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Customer extends Person {

	private String shippingAddress;
	private String email;

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
