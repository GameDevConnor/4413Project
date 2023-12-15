package dao;

import java.util.List;

import model.Item;
import model.User;

public interface ItemDAO {
	
	public List<Item> findAllItems();
	
	public List<Item> searchItemByKeywords(String item);
	
	public void insert(Item item, int quantity);
	
	public void delete(String itemID);
	

}
