package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Purchase {
	
	String user;
	Item item;
	int quantity;
	
	private List<Purchase> purchases;

	
	public Purchase() {
	      purchases = new ArrayList<Purchase>();
		
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
	
	public List<Purchase> getPurchases() {
		return purchases;
	}
	
	 
	   public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	// Add a Book into this Cart, with qtyOrdered. If the book of id already exists, update the qty ordered
	   // if not, create a new book.
	   public void add(Purchase item) {
	      
	      purchases.add(item);
	   }
	   
	   public boolean containsItem(String id) {
		   for (Purchase item : purchases) {
			   if (item.getItem().getId().equals(id)) {
				   return true;
			   }
		   }
		   
		   return false;
	   }
	 
	   // Update the quantity for the given id, of total orderqty
	   public void update(String id, int newQty) {
	      
		   for (Purchase item : purchases) {
			   if (item.getItem().getId().equals(id)) {
				   item.getItem().setQuantity(newQty);
			   }
		   }
		   
	   }
	 
	   // Remove a Book given its id
	   public void remove(String id) {
	      Iterator<Purchase> iter = purchases.iterator();
//	      while (iter.hasNext()) {
//	    	 if (iter.next().getId() == id) {
//	    		 cart.remove(iter.next());
//	    	 }
//	      }
	      
		   for (int i = 0; i < purchases.size(); i++) {
			if (purchases.get(i).getItem().getId().equals(id)) {
				purchases.remove(i);
			}
		}
	   }
	 
	   // Get the number of Books in this Cart
	   public int size() {
	      return purchases.size();
	   }
	 
	   // Check if this Cart is empty
	   public boolean isEmpty() {
	      return size() == 0;
	   }
	 
	 

}
