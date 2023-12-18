package model;


public class Purchase {
	
	String user;
	Item item;
	int quantity;
	
	public Purchase() {
		
	}

	public Purchase(String user, Item item, int qty) {
		
		this.quantity = qty;
		this.user = user;
		this.item = item;
	}


	public int getId() {
		return quantity;
	}

	public void setQty(int qty) {
		this.quantity = qty;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
