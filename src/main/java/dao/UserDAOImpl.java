package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Address;
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
//	   	 String queryString = "select * from customer where user = '" + user + "'";
	   	 String queryString = "select * from customer, address where customer.addressID = address.id and exists (select * from customer where username = '" + user + "')";

	   	
	   	 queryString += ";";
	   	 System.out.println(queryString);
	   	 
	   	 User customer = new User();
	   	 

	   	 
	   	 try {
			
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
	   	
	   	 
	   	 while (resultSet.next()) {
			String userName = resultSet.getString("username");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String password = resultSet.getString("password");
			
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setUsername(userName);
			customer.setPassword(password);
			
			String street = resultSet.getString("street");
			String province = resultSet.getString("province");
			String country = resultSet.getString("country");
			String zip = resultSet.getString("zip");
			String phone = resultSet.getString("phone");
			
			Address address = new Address(street, province, country, zip, phone);
			
			customer.setAddress(address);


			
			
		}

	   	
	   	 
	   	 
	   	 connection.close();
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
