package org.domain;

public class Product {
	private String name;
	private Double price;
	
	public Product(String n,Double p) {
		this.name=n;
		this.price=p;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name != null && name.equals(other.name)) {
			return true;
		} else 
			return false;
	}

}
