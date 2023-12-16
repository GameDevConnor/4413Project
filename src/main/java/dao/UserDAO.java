package dao;
import java.util.List;

import model.*;

public interface UserDAO {
	

		public List<User> findAllUsers();
		
		public User searchUsersByKeyword(String user);
		
		public void insert(User user);
		
		public void delete(String username);
		
		public List<String> purchaseHistory(User user);
		
}
