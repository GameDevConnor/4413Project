package restService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
					// current user is customer, add item to shopping cart
					addToCart(request, response, id);
					url = base + "cartStructure.jsp";

					flag = true;
					break;					
				}
				case "insert": {
					// Admin - add item to DB		
					String itemId = request.getParameter("id");
					String name = request.getParameter("name");
					String description = request.getParameter("dsec");
					String category = request.getParameter("category");
					String brand = request.getParameter("brand");					
					int quantity = Integer.parseInt(request.getParameter("qty"));
					float price = Float.parseFloat(request.getParameter("price"));
					
					System.out.println("Insert id: " + itemId + " name: " + name);

					Item item = new Item(itemId, name, description, category, brand, quantity, price);	
					
					insertItem(request, response, item, quantity);				
					url = "/items?action=allItems"; // Redirect to All Items screen once added
					flag = true;
					break;
				}
				case "delete": {	
					// Admin - delete item from DB		
					deleteItem(request, response, id);
					url = "/items?action=allItems";
					System.out.println("Remove id: " + id);
					flag = true;
					break;					
				}
				case "update": {
					// Admin - update item quantity in DB		
					// Get item by id using DAO
					ItemDAO itemDao = new ItemDAOImpl();
					Item item = itemDao.findItemById(id);
					
					// Get new qty from input and update db 
					int qtyNew = Integer.parseInt(request.getParameter("qty" + id));					
					System.out.println("Update id: " + id + " qty: " + qtyNew);
					
					insertItem(request, response, item, qtyNew);
					url = "/items?action=allItems";					
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
	
	private void insertItem(HttpServletRequest request,
			HttpServletResponse response, Item item, int quantity) throws ServletException, IOException {
		try {
			// calling DAO method to insert an item
			ItemDAO itemDao = new ItemDAOImpl();
			itemDao.insert(item, quantity);
			//request.setAttribute("item", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteItem(HttpServletRequest request,
			HttpServletResponse response, String id) throws ServletException, IOException {
		try {
			// calling DAO method to remove an item
			ItemDAO itemDao = new ItemDAOImpl();
			itemDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
