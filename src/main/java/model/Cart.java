package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
 
   private List<Item> cart;
   
    
   // constructor
   public Cart() {
      cart = new ArrayList<Item>();
   }
 
   // Add a Book into this Cart, with qtyOrdered. If the book of id already exists, update the qty ordered
   // if not, create a new book.
   public void add(Item item) {
      
      cart.add(item);
   }
   
   public boolean containsItem(String id) {
	   for (Item item : cart) {
		   if (item.getId().equals(id)) {
			   return true;
		   }
	   }
	   
	   return false;
   }
 
   // Update the quantity for the given id, of total orderqty
   public void update(String id, int newQty) {
      
	   for (Item item : cart) {
		   if (item.getId().equals(id)) {
			   item.setQuantity(newQty);
		   }
	   }
	   
   }
 
   // Remove a Book given its id
   public void remove(String id) {
      Iterator<Item> iter = cart.iterator();
//      while (iter.hasNext()) {
//    	 if (iter.next().getId() == id) {
//    		 cart.remove(iter.next());
//    	 }
//      }
      
	   for (int i = 0; i < cart.size(); i++) {
		if (cart.get(i).getId().equals(id)) {
			cart.remove(i);
		}
	}
   }
 
   // Get the number of Books in this Cart
   public int size() {
      return cart.size();
   }
 
   // Check if this Cart is empty
   public boolean isEmpty() {
      return size() == 0;
   }
 
   // Return all the Books in a List<Book>
   public List<Item> getItems() {
      return cart;
   }
 
   // Remove all the items in this Cart
   public void clear() {
      cart.clear();
   }
   
   public float totalPrice() {
	   float totalPrice = 0;
	   for (Item item : cart) {
		totalPrice += item.getPrice();
	}
	   return totalPrice;
   }
   
   public List<Item> getCart() {
	   return this.cart;
   }
   
   
   
}