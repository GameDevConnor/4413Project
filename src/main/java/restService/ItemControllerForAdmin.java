package restService;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import dao.ItemDAOImpl;
import model.Cart;
import model.Item;

/**
 * Servlet implementation class ItemControllerForAdmin
 */
@WebServlet({ "/items"})
public class ItemControllerForAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemControllerForAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve current signed in user's username
		HttpSession session = request.getSession(true);
		String currentUser = (String) session.getAttribute("currentUser");
		String url = "";
		
		String base = "/jsp/";
		if (currentUser.equals("admin@yorku.ca")) {		
			url = base + "adminMain.jsp";
		}
		else {
			url = base + "shoppingMain.jsp";
		}		
		
		String action = request.getParameter("action");
		String keyWord = request.getParameter("keyWord");
		String id = request.getParameter("id");
		Boolean flag = true; // flag used to identify if forward dispatcher should be called
		
		System.out.println(request.getQueryString());
		
		if (action != null) {
			switch (action) {
				case "allItems": {
					findAllItems(request, response);
	
					// if current user is admin, direct to listOfItemsStructureForAdmin.jsp
					if (currentUser.equals("admin@yorku.ca")) {
						url = base + "listOfItemsStructureForAdmin.jsp";					
					}
					// if current user is customer, direct to listOfItemsStructure.jsp
					else {
						url = base + "listOfItemsStructure.jsp";
					}
					flag = true;
					break;				
				}
				case "add": {
					addToCart(request, response, id);
					url = base + "cartStructure.jsp";
					flag = true;
					break;					
				}
			}
		}
		
		if (flag) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void findAllItems(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// list all items for admin management
		try {
			// calling DAO method to retrieve a list of all items 
			ItemDAO itemDao = new ItemDAOImpl();
			List<Item> itemList = itemDao.findAllItems();
			request.setAttribute("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	private void addToCart(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {
		// list all items for admin management
		try {
			HttpSession session = request.getSession(true);
			Cart cart;
		      synchronized (session) {  // synchronized to prevent concurrent updates
		         // Retrieve the shopping cart for this session, if any. Otherwise, create one.
		         cart = (Cart) session.getAttribute("cart");
		         if (cart == null) {  // No cart, create one.
		            cart = new Cart();
//		            session.setAttribute("cart", cart);  // Save it into session
		         }
		      }
			// calling DAO method to retrieve a list of all items 
			ItemDAO itemDao = new ItemDAOImpl();
			Item item = itemDao.findItemById(id);
			if (!cart.containsItem(item.getId())) {
				cart.add(item);
			}
//			cart.add(item);
            session.setAttribute("cart", cart);  // Save it into session

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
