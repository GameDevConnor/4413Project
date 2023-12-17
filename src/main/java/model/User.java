package model;

import java.util.List;

public class User {
	
	String username;
	String password;
	List<Item> purchases;
	String firstName;
	String lastName;
	Address address;
	
	public User(String username, String password, String firstName, String lastName) {		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(String username, String password, List<Item> purchases, String firstName, String lastName,
			Address address) {
		
		this.username = username;
		this.password = password;
		this.purchases = purchases;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public User () {
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Item> getPurchases() {
		return purchases;
	}


	public void setPurchases(List<Item> purchases) {
		this.purchases = purchases;
	}

}
