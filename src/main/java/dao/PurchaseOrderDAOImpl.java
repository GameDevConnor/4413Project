package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Item;
import model.PurchaseOrder;
import model.User;

public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {

	@Override
	public List<PurchaseOrder> findAllPurchaseOrders() {
		List<PurchaseOrder> pos = new ArrayList<PurchaseOrder>();
		
		String queryString = "select * from PO;";
	   	System.out.println(queryString);
   	
	   	try {				
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
   	 
	   	 while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String username = resultSet.getString("customerID");
			String itemID = resultSet.getString("itemID");
			//List<String> itemID = resultSet.getString("itemID");
			String dateOfPurchase = resultSet.getString("dateOfPurchase");
			
			// calling DAO method to find current user 
			UserDAO userDao = new UserDAOImpl();
			User user = userDao.searchUsersByKeyword(username);
			// calling DAO method to find purchased item			
			ItemDAO itemDao = new ItemDAOImpl();
			Item item = itemDao.findItemById(itemID);					
			
			//List<Item> itemList = itemDao.findItemById(itemID);
		
			PurchaseOrder po = new PurchaseOrder(id, user, item);
			po.setDateOfCreation(dateOfPurchase);
			pos.add(po);
		}
	   	 
	   	 connection.close();
	   	} catch (Exception e) {
	   		e.printStackTrace();
		}
	   	
		return pos;
	}

	@Override
	public List<PurchaseOrder> findAllPurchaseOrdersByUsername(String username) {
List<PurchaseOrder> pos = new ArrayList<PurchaseOrder>();
		
		String queryString = "select * from PO where customerID = '" + username + "';";
	   	System.out.println(queryString);
   	
	   	try {				
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
   	 
	   	 while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String itemID = resultSet.getString("itemID");
			//List<String> itemID = resultSet.getString("itemID");
			String dateOfPurchase = resultSet.getString("dateOfPurchase");
			
			// calling DAO method to find current user 
			UserDAO userDao = new UserDAOImpl();
			User user = userDao.searchUsersByKeyword(username);
			// calling DAO method to find purchased item			
			ItemDAO itemDao = new ItemDAOImpl();
			Item item = itemDao.findItemById(itemID);					
		
			PurchaseOrder po = new PurchaseOrder(id, user, item);
			po.setDateOfCreation(dateOfPurchase);
			pos.add(po);
		}
	   	 
	   	 connection.close();
	   	} catch (Exception e) {
	   		e.printStackTrace();
		}
	   	
		return pos;
	}

}
