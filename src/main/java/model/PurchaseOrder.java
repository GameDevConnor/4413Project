package model;

import java.util.Date;

public class PurchaseOrder {
	
	int id;
	User user;
	Item item;
	Date dateOfCreation;
	
	public PurchaseOrder() {
		dateOfCreation = new Date();
	}

	public PurchaseOrder(int id, User user, Item item) {
		
		this.id = id;
		this.user = user;
		this.item = item;
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
	
	
	

}
