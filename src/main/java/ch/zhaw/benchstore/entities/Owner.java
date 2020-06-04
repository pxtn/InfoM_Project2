package ch.zhaw.benchstore.entities;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Owner extends Person {

	private String homeCommunity;
	private String phoneNumber;

	public Owner(String name, String surname, String address, Date birthDate, String homeCommunity, String phoneNumber) {
		super(name, surname, address, birthDate);
		this.homeCommunity = homeCommunity;
		this.phoneNumber = phoneNumber;
	}

	public Owner() {
	}

	public String getHomeCommunity() {
		return homeCommunity;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
