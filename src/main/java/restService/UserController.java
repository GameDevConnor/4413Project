package restService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

/**
 * Servlet implementation class UserController
 * Used to check sign in info
 * If username and password is not found in user DB, redirect to signUp.html
 * If username is found in DB, check user type and validate credentials
 * 			If user is admin, direct to adminMain.jsp
 * 				Admin has predefined username “admin” and password “pass”
 * 			If user is customer, direct to shoppingMain.jsp
 */
@WebServlet({ "/SignIn"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/html/signIn.html";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean flag = true; // flag used to identify if forward dispatcher should be called
		
		System.out.println("user: " + username + "; pass: " + password);
		
		if (username != null && password != null) {
			
			if (username.equals("admin@yorku.ca")) {
				if (password.equals("pass")) {				
					url = "/jsp/adminMain.jsp";		
					flag = true;
				}
				else {
					response.setContentType("text/html"); //step 1 - typical servlet steps					
					PrintWriter out = response.getWriter(); //step 2 - typical servlet steps
					out.println("<!DOCTYPE html>");
					out.println("<h1>Incorrect Password!</h1>");
					RequestDispatcher dis = request.getRequestDispatcher(url);
					dis.include(request, response);
					out.close();
					flag = false;
				}
			}
			else {
				try {
					// calling DAO method to retrieve a user by their username
					UserDAO userDao = new UserDAOImpl();
					User user = userDao.searchUsersByKeyword(username);
					if (user == null) {
						url = "/jsp/signUp.jsp";
						request.setAttribute("username", username);
						request.setAttribute("password", password);
						flag = true;
					}
					else if (user.getPassword().equals(password)){
							request.setAttribute("user", user);
							url = "/jsp/shoppingMain.jsp";
							flag = true;
						}
					else {
						response.setContentType("text/html"); //step 1 - typical servlet steps
						PrintWriter out = response.getWriter(); //step 2 - typical servlet steps
						out.println("<!DOCTYPE html>");
						out.println("<h1>Incorrect Password!</h1>");
						RequestDispatcher dis = request.getRequestDispatcher(url);
						dis.include(request, response);
						out.close();
						flag = false;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
	
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

}
