package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchUsersByKeyword(String user) {
		// TODO Auto-generated method stub
	   	 String queryString = "select * from customer where user = '" + user + "'";
	   	
	   	 queryString += ";";
	   	 System.out.println(queryString);
	   	 
	   	 User customer = new User();
	   	 

	   	 
	   	 try {
			
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab6","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
	   	
	   	 		
	   	 
	   	 while (resultSet.next()) {
			String userName = resultSet.getString("user");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setUsername(userName);
			
		}
	   	} catch (Exception e) {
			// TODO: handle exception
		}
	   	 
	   	
	   	return customer;
	   	 
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		
	}

}
