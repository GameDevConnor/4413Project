package restService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import dao.ItemDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Cart;
import model.Item;
import model.Purchase;
import model.User;

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
    }
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// calling DAO method to retrieve category List from Database, for left column display
        ItemDAO itemDao = new ItemDAOImpl();
		List<String> categoryList = itemDao.findAllCategories();
		List<String> brandList = itemDao.findAllBrands();
		
		ServletContext context = getServletConfig().getServletContext();  
		context.setAttribute("categoryList", categoryList);
		context.setAttribute("brandList", brandList);
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
				case "search":
					searchItems(request, response, keyWord);
					url = base + "searchItemResult.jsp";
					break;

				case "add": {										
					// Customer - add item to shopping cart
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
				case "checkout": {
					// Customer - check out items and update db PO 
					addPurchasesToDB(request, response);
					url = base + "checkoutStructure.jsp";					
					flag = true;
					break;
				}
				case "categoryList": {
					// Customer - filter by categoryList 
					String category = request.getParameter("category");
					findItemsByCategory(request, response, category);
					url = base + "listOfItemsStructure.jsp";				
					flag = true;
					break;
				}
				case "brandList": {
					// Customer - filter by categoryList 
					String brand = request.getParameter("brand");
					findItemsByBrand(request, response, brand);
					url = base + "listOfItemsStructure.jsp";				
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
	
	
	
	private void addPurchasesToDB(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(true);
			Purchase purchase;
		      synchronized (session) {  // synchronized to prevent concurrent updates
		         // Retrieve the shopping cart for this session, if any. Otherwise, create one.
		         purchase = (Purchase) session.getAttribute("purchases");
		         
		      }
			// calling DAO method to retrieve a list of all items 
			ItemDAO itemDao = new ItemDAOImpl();
			UserDAO userDAO = new UserDAOImpl();
			
			for (Purchase individualPurchase : purchase.getPurchases()) {
				User user = userDAO.searchUsersByKeyword(individualPurchase.getUser());
				itemDao.purchase(individualPurchase.getItem(), user, individualPurchase.getQuantity());
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
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
	
	//search item by keyword
	private void searchItems(HttpServletRequest request,
			HttpServletResponse response, String keyWord)
			throws ServletException, IOException {
		try {
			// calling DAO method to search book by keyword 
			ItemDAO itemDao = new ItemDAOImpl();
			List<Item> itemList = itemDao.searchItemByKeywords(keyWord);
			request.setAttribute("itemList", itemList);

		} catch (Exception e) {
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
	
	private void findItemsByCategory(HttpServletRequest request,
			HttpServletResponse response, String cate)
			throws ServletException, IOException {
		try {
			// calling DAO method to search items by catetory 
			ItemDAO itemDao = new ItemDAOImpl();
			List<Item> itemList = itemDao.findItemsByCategory(cate);

			request.setAttribute("itemList", itemList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void findItemsByBrand(HttpServletRequest request,
			HttpServletResponse response, String brand)
			throws ServletException, IOException {
		try {
			// calling DAO method to search items by brand 
			ItemDAO itemDao = new ItemDAOImpl();
			List<Item> itemList = itemDao.findItemsByBrand(brand);

			request.setAttribute("itemList", itemList);

		} catch (Exception e) {
			System.out.println(e);
		}
	}


}
