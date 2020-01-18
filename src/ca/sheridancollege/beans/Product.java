//Michael Lakostik | 991515743
package ca.sheridancollege.beans;

public class Product {
	String brand;
	String type;
	String color;
	double price;
	
	public Product(String brand, String type, String color, double price) {
		super();
		this.brand = brand;
		this.type = type;
		this.color = color;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return brand + " " + type + " (" + color + ")";
	}
}
