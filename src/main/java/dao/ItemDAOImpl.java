package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.Item;
import model.User;

public class ItemDAOImpl implements ItemDAO {

	@Override
	public List<Item> findAllItems() {
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<Item>();
		
		String queryString = "select * from item;";
	   	System.out.println(queryString);
	   	
	   	
	   	 try {
				
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
	   	
	   	 
	   	 while (resultSet.next()) {
			String id = resultSet.getString("id");
			String name = resultSet.getString("itemName");
			String description = resultSet.getString("itemDescription");
			String category = resultSet.getString("category");
			String brand = resultSet.getString("brand");
			int quantity = resultSet.getInt("quantity");
			float price = resultSet.getFloat("price");

			
			Item item = new Item(id, name, description, category, brand, quantity, price);


			items.add(item);
			
			
		}

	   	
	   	 
	   	 
	   	 connection.close();
	   	} catch (Exception e) {
			// TODO: handle exception
		}
	   	
		
		
		return items;
	}

	@Override
	public List<Item> searchItemByKeywords(String keyWord) {
		// TODO Auto-generated method stub
		
		List<Item> result = new ArrayList<Item>();
		
		// select * from book inner join author on book.id = author.book_id inner join category on category.id = book.category_id where BOOK_TITLE like '%Jeff%' or FIRST_NAME like '%Jeff%' or LAST_NAME like '%Jeff%';
		String sql = "select * from item"
				+ " where itemName like '%"
				+ keyWord.trim()
				+ "%'"
				+ " or itemDescription like '%"
				+ keyWord.trim()
				+ "%'"
				+ " or category like '%" + keyWord.trim() + "%'"
				+ " or brand like '%" + keyWord.trim() + "%'";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		   	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
		   	 
		   	java.sql.Statement statement = connection.createStatement();


			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				
                
				String id = resultSet.getString("id");
				String name = resultSet.getString("itemName");
				String description = resultSet.getString("itemDescription");
				String category = resultSet.getString("category");
				String brand = resultSet.getString("brand");
				int quantity = resultSet.getInt("quantity");
				float price = resultSet.getFloat("price");

				
				Item item = new Item(id, name, description, category, brand, quantity, price);
				

				
				result.add(item);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	@Override
	public void insert(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String itemID) {
		// TODO Auto-generated method stub
		
	}

}