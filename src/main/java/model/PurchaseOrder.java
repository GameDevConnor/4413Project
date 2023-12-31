package model;

import java.util.Date;

public class PurchaseOrder {
	
	int id;
	User user;
	Item item;
	int qtyOrdered;
	float totalPrice;
	String dateOfCreation;
	
	public PurchaseOrder() {
		dateOfCreation = new Date().toString();
	}

	public PurchaseOrder(int id, User user, Item item, int qty, float totalPrice) {
		
		this.id = id;
		this.user = user;
		this.item = item;
		this.qtyOrdered = qty;
		this.totalPrice = totalPrice;
		dateOfCreation = new Date().toString();
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
