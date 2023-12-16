package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		
		String queryString = "select * from customer join address on customer.addressID = address.id;";
	   	System.out.println(queryString);
	   	
	   	
	   	 try {
				
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
	   	 
	   	 while (resultSet.next()) {
			String userName = resultSet.getString("username");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String password = resultSet.getString("pass");
			
			User customer = new User();
			
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


			users.add(customer);
			
			
		}

	   	
	   	 
	   	 
	   	 connection.close();
	   	} catch (Exception e) {
			// TODO: handle exception
	   		e.printStackTrace();
//			System.out.println(e);
		}
	   	
		
		
		return users;
	}

	@Override
	public User searchUsersByKeyword(String user) {
		// TODO Auto-generated method stub
//	   	 String queryString = "select * from customer where user = '" + user + "'";
//	   	 String queryString = "select * from customer, address where customer.addressID = address.id and exists (select * from customer where username = '" + user + "')";
		 String queryString = "select * from customer, address where username = '" + user + "' and customer.addressID = address.id";
	   	
	   	 queryString += ";";
	   	 System.out.println(queryString);
	   	 
	   	 User customer = new User();
	   	 

	   	 
	   	 try {
			
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
	   	 ResultSet resultSet = statement.executeQuery(queryString);
	   	
	   	 
	   	resultSet.next();
	   	 
		String userName = resultSet.getString("username");
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		String password = resultSet.getString("pass");
		
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
		System.out.println("current user: " + userName); 
	   	
	   	 connection.close();
	   	} catch (Exception e) {
			// TODO: handle exception
		}
	   	 
	   	
	   	return customer;
	   	 
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
		
		String addressqueryString = "select id from address where address.street = '" + user.getAddress().getStreet() + "' and address.province = " + "'" + user.getAddress().getProvince() + "' and address.country = '" + user.getAddress().getCountry() + "' and address.zip = '" + user.getAddress().getZip() +"' and address.phone = '" + user.getAddress().getPhone() + "'";
		addressqueryString += ";";
	   	System.out.println(addressqueryString);
		
	
		
	   	 try {
				
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
	   	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
	   	 
	   	 java.sql.Statement statement = connection.createStatement();
	   	 
		 ResultSet resultSet = statement.executeQuery(addressqueryString);

	   	 
		 int address = 0;
	   
		 while (resultSet.next()) {
			 address = resultSet.getInt("id");
			 
			}
		 
		 if (address == 0) {
			 String getMaxAddress = "select id from address;";
			 ResultSet maxAddressResultSet = statement.executeQuery(getMaxAddress);

			 int maxAddress = 1;
			 
			 while (maxAddressResultSet.next()) {
				 	maxAddress = resultSet.getInt("id");
				 
				}
			 
			 
			 String addAddress = "insert into address values (" + maxAddress + 1 + "," + user.getAddress().getStreet() + "," + user.getAddress().getProvince() + "," + user.getAddress().getCountry() + "," + user.getAddress().getZip() + user.getAddress().getPhone() + ");";
			 int insertResultSetAddress = statement.executeUpdate(addAddress);

			 
		 }
		 
		 
			String queryString = "insert into customer values (" + user.getUsername() + "," + user.getPassword() + "," + user.getFirstName() + "," + user.getLastName() + "," + address + ")";
			queryString += ";";
		   	System.out.println(queryString);
			int insertResultSetCustomer = statement.executeUpdate(queryString);

	   	
	   	 
	   	 
	   	 connection.close();
	   	} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		try {


			Class.forName("com.mysql.cj.jdbc.Driver");
			
		   	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","EECS4413");
			PreparedStatement statement = connection
					.prepareStatement("delete from customer where username='?'");
			statement.setString(1, username);
			statement.execute();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
