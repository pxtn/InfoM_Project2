package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
