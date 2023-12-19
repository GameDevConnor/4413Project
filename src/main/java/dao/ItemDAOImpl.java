package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.Item;
import model.PurchaseOrder;
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
	   		e.printStackTrace();
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
			
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	@Override
	public void insert(Item item, int quantity) {
		// TODO Auto-generated method stub
		
		String itemqueryString = "select id from item where id = '" + item.getId() + "'";
		itemqueryString += ";";
	   	System.out.println(itemqueryString);

	   	try {				
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
		 ResultSet resultSet = statement.executeQuery(itemqueryString);
		 
		 if (resultSet.next()) {
			
			String updateQuery = "update item set quantity = " + quantity + " where id = '" + item.getId() + "';";
		   		
		   	Statement updateStatement = connection.createStatement();
			   	 
			int updateResultSet = updateStatement.executeUpdate(updateQuery);
			System.out.println(updateStatement.toString());		
		 }
		 else {			 
			 String insertItemQueryString = "insert into item values ('" + item.getId() + "','" + item.getName() + "','" + item.getDescription() + "','" + item.getCategory() + "','" + item.getBrand() + "'," + item.getQuantity() + "," + item.getPrice() + ");";
			 
			 Statement insertStatement = connection.createStatement();
		   	 
			 int insertResultSet = insertStatement.executeUpdate(insertItemQueryString);	
			 System.out.println(insertStatement.toString());		
		 }
		 
	   	 connection.close();
	   	} catch (Exception e) {
			// TODO: handle exception
	   		e.printStackTrace();
		}
	}

	@Override
	public void delete(String itemID) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		   	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
			PreparedStatement statement = connection
					.prepareStatement("delete from item where id=?;");
			statement.setString(1, itemID);
			statement.execute();
			
			System.out.println(statement.toString());		
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void purchase(Item item, User user, int quantity) {
		// TODO Auto-generated method stub
		
		String queryString = "select id from PO;";
	   	System.out.println(queryString);

	   	try {				
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
	   	 
	   	 int id = 0;

	   	 while (resultSet.next()) {
			id = resultSet.getInt("id");
		 }

	   	 PurchaseOrder po = new PurchaseOrder(id + 1, user, item, quantity);

	   	 String insertItemQueryString = "insert into po values ('" + po.getId() + "','" + po.getUser().getUsername() + "','" + po.getItem().getId() + "','" + po.getDateOfCreation().toString() + "');";
		 
		 Statement insertStatement = connection.createStatement();
	   	 
		 int insertResultSet = insertStatement.executeUpdate(insertItemQueryString);

		 String updateQuery = "update item set quantity = quantity -" + quantity + " where id = '" + item.getId() + "';";
	   		
		 Statement updateStatement = connection.createStatement();
			   	 
		 int updateResultSet = updateStatement.executeUpdate(updateQuery);

	   	 connection.close();
	   	} catch (Exception e) {
	   		e.printStackTrace();
		}
	}
	
	@Override
	    public Item findItemById(String itemId) {
	        Item item = null;
	        String queryString = "SELECT * FROM item WHERE id = ?;";

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "EECS4413");
	             PreparedStatement statement = connection.prepareStatement(queryString)) {

	            statement.setString(1, itemId);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                String id = resultSet.getString("id");
	                String name = resultSet.getString("itemName");
	                String description = resultSet.getString("itemDescription");
	                String category = resultSet.getString("category");
	                String brand = resultSet.getString("brand");
	                int quantity = resultSet.getInt("quantity");
	                float price = resultSet.getFloat("price");

	                item = new Item(id, name, description, category, brand, quantity, price);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return item;
	    }

}
