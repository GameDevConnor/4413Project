package dao;

import java.util.List;

import model.Category;
import model.Item;
import model.User;

public interface ItemDAO {
	
	public List<Item> findAllItems();
	
	public List<Item> searchItemByKeywords(String item);
	
	public List<String> findAllCategories();
	
	public List<Item> findItemsByCategory(String category);
	
	public List<String> findAllBrands();
	
	public List<Item> findItemsByBrand(String brand);
	
	public void insert(Item item, int quantity);
	
	public void delete(String itemID);
	
	public void purchase(Item item, User user, int quantity);
	
	public Item findItemById(String itemID);

}
