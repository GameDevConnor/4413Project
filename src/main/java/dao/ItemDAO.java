package dao;

import java.util.List;

import model.Item;
import model.User;

public interface ItemDAO {
	
	public List<User> findAllItems();
	
	public User searchItemsByKeyword(String item);
	
	public void insert(Item item);
	
	public void delete(String itemID);
	

}
