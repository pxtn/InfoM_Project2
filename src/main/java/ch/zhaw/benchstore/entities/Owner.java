package ch.zhaw.benchstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner extends Person {

	private String homeCommunity;
	private String phoneNumber;

	@OneToMany(
			mappedBy = "owner",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Business> businesses = new ArrayList<>();

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
