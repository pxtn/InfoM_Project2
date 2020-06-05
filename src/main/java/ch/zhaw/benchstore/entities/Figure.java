package ch.zhaw.benchstore.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Figure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double income;
	private double expenses;
	private double advertisementExpenses;
	private Date date;

	@ManyToOne(fetch=FetchType.EAGER)
	private Business business;

	public Figure(double income, double expenses, double advertisementExpenses, Date date, Business business) {
		this.income = income;
		this.expenses = expenses;
		this.advertisementExpenses = advertisementExpenses;
		this.date = date;
		this.business = business;
	}

	public Figure() {
	}

	public double getIncome() {
		return this.income;
	}

	public double getExpenses() {
		return this.expenses;
	}

	public double getAdvertisementExpenses() {
		return this.advertisementExpenses;
	}

	public Date getDate() {
		return this.date;
	}

	public Business getBusiness() {
		return this.business;
	}
}
