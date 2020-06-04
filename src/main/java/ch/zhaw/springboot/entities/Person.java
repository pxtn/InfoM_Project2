package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String surname;
	private String address;
	private Date birthDate;

	public Person(String name, String surname, String address, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.birthDate = birthDate;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthDate() {
		return birthDate;
	}
}
