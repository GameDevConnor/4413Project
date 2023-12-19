package restService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseOrderDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Address;
import model.PurchaseOrder;
import model.User;

/**
 * Servlet implementation class CustomerControllerForAdmin
 * Used for admin to view all users, review/update a specific user info
 */
@WebServlet({ "/customers"})
public class CustomerControllerForAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerControllerForAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "adminMain.jsp";
		String action = request.getParameter("action");
		String username = request.getParameter("username");
		String keyWord = request.getParameter("keyWord");
		Boolean flag = true; // flag used to identify if forward dispatcher should be called

		// Retrieve current signed in user's username
		HttpSession session = request.getSession(true);
		String currentUser = (String) session.getAttribute("currentUser");
		
		System.out.println(request.getQueryString());
		
		if (action != null) {
			switch (action) {
			case "allUsers":
				findAllUsers(request, response);
				url = base + "listOfUsersStructure.jsp";
				flag = true;
				break;
			case "review": {
				System.out.println("review " + username);
				searchUsersByKeyword(request, response, username);		
				findAllPurchaseOrdersByUsername(request, response, username);	
				url = base + "customerInfo.jsp";
				flag = true;
				break;
			}
			case "insert": {
				System.out.println("Insert " + username);
				
				String userName = request.getParameter("username");
				String firstName = request.getParameter("firstname");
				String lastName = request.getParameter("lastname");
				String password = request.getParameter("password");				
				
				User customer = new User(userName, password, firstName, lastName);				
				
				String street = request.getParameter("street");
				String province = request.getParameter("province");
				String country = request.getParameter("country");
				String zip = request.getParameter("zip");
				String phone = request.getParameter("phone");
				
				/*// if any shipping info field is not empty, ask user to enter complete shipping info
				// !addressFieldCheck1 used to check if any shipping info field was entered
				// addressFieldCheck2 used to check if user entered complete shipping info
				Boolean addressFieldCheck1 = (street==null || street.isEmpty() && province==null || province.isEmpty() 
						|| country==null || country.isEmpty() || zip==null || zip.isEmpty()
						|| phone==null || phone.isEmpty());
				Boolean addressFieldCheck2 = (street!=null && !street.isEmpty() && province!=null && !province.isEmpty() 
						&& country!=null && !country.isEmpty() && zip!=null && !zip.isEmpty()
						&& phone!=null && !phone.isEmpty());
				if (!addressFieldCheck1) {		
					if (addressFieldCheck2) {
						Address address = new Address(street, province, country, zip, phone);				
						customer.setAddress(address);						
					}
					else {
						response.setContentType("text/html"); //step 1 - typical servlet steps					
						PrintWriter out = response.getWriter(); //step 2 - typical servlet steps
						out.println("<!DOCTYPE html>");
						out.println("<h1>All shipping info must be filled!</h1>");
						RequestDispatcher dis = request.getRequestDispatcher(url);
						dis.include(request, response);
						out.close();
					}
				}*/
				Address address = new Address(street, province, country, zip, phone);				
				customer.setAddress(address);		
				
				insertUser(request, response, customer);				
				url = "/html/signIn.html"; // Redirect to sign in screen once new user created
				flag = true;
				break;
			}
			case "update": {
				System.out.println("update " + username);
				searchUsersByKeyword(request, response, username);				
				url = base + "customerInfo.jsp";
				flag = true;
				break;
			}
			case "signOut": {
				System.out.println("Sign Out " + currentUser);	
				url = "/html/signIn.html";
				flag = true;
				session.removeAttribute("currentUser");
				break;
			}
			case "delete": {
				System.out.println("delete " + username);
				deleteUser(request, response, username);					
				
				if (currentUser.equals("admin@yorku.ca")) {
					url = "customers?action=allUsers";
					
					response.setContentType("text/html"); //step 1 - typical servlet steps
					PrintWriter out = response.getWriter(); //step 2 - typical servlet steps
					out.println("<!DOCTYPE html>");
					out.println("<h2>" + username + " - Account Deleted!</h2>;");
					RequestDispatcher dis = request.getRequestDispatcher(url);
					dis.include(request, response);
					out.close();
					flag = false;
					break;
				}
				else {
					url = "/html/signIn.html";
					
					response.setContentType("text/html"); //step 1 - typical servlet steps
					PrintWriter out = response.getWriter(); //step 2 - typical servlet steps
					out.println("<!DOCTYPE html>");
					out.println("<h1>" + username + " - Account Deleted! Goodbye!</h1>");
					RequestDispatcher dis = request.getRequestDispatcher(url);
					dis.include(request, response);
					out.close();
					session.removeAttribute("currentUser");
					flag = false;
					break;
				}				
			}
			case "searchUser":
				searchUsersByKeyword(request, response, keyWord);
				url = base + "searchUserResult.jsp";
				flag = true;
				break;
			}
		}
		if (flag) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			//System.out.println(request.getContextPath());
			//response.sendRedirect(request.getContextPath() + url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void findAllUsers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// list all users for admin management
		try {
			// calling DAO method to retrieve a list of all users 
			UserDAO userDao = new UserDAOImpl();
			List<User> userList = userDao.findAllUsers();
			request.setAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	private void searchUsersByKeyword(HttpServletRequest request,
			HttpServletResponse response, String keyWord) throws ServletException, IOException {
		try {
			// calling DAO method to retrieve a user by their username
			UserDAO userDao = new UserDAOImpl();
			User user = userDao.searchUsersByKeyword(keyWord);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	private void insertUser(HttpServletRequest request,
			HttpServletResponse response, User user) throws ServletException, IOException {
		try {
			// calling DAO method to insert a user
			UserDAO userDao = new UserDAOImpl();
			userDao.insert(user);
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response, String keyWord) throws ServletException, IOException {
		try {
			// calling DAO method to delete a user
			UserDAO userDao = new UserDAOImpl();
			userDao.delete(keyWord);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	private void findAllPurchaseOrdersByUsername(HttpServletRequest request,
			HttpServletResponse response, String currentUser) throws ServletException, IOException {
		// list all purchase orders for current customer
		try {
			// calling DAO method to retrieve a list of all purchase orders 
			PurchaseOrderDAOImpl poDao = new PurchaseOrderDAOImpl();
			List<PurchaseOrder> poList = poDao.findAllPurchaseOrdersByUsername(currentUser);
			request.setAttribute("poList", poList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
