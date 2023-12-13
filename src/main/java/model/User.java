package model;

import java.util.List;

public class User {
	
	String username;
	String password;
	List<Item> purchases;
	String firstName;
	
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


	String lastName;
	
	
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
