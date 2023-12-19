package model;

public class Item {
	
	String id;
	String name;
	String description;
	String category;
	String brand;
	int quantity; // quantity in stock
	float price;
	int orderedQty;
	
	public Item(String id, String name, String description, String category, String brand, int quantity, float price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Item() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String toString() {
		return name + "," + description + "," + category + "," + brand + "," + quantity + "," + price;
	}

}
