package ch.zhaw.benchstore.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String address;

	@ManyToMany(mappedBy = "suppliers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	List<Product> products = new ArrayList<Product>();

	public Supplier(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Supplier() {
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public void addProduct(Product p) {
		this.products.add(p);
	}

	public List<Product> getProducts() {
		return products;
	}
}
