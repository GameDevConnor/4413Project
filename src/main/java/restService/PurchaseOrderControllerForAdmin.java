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

import dao.ItemDAO;
import dao.ItemDAOImpl;
import dao.PurchaseOrderDAOImpl;
import model.Item;
import model.PurchaseOrder;

/**
 * Servlet implementation class PurchaseOrderControllerForAdmin
 */
@WebServlet({ "/purchaseOrders"})
public class PurchaseOrderControllerForAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseOrderControllerForAdmin() {
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
		
		String base = "/jsp/";
		String url = base + "listOfPurchaseOrdersStructure.jsp";	
		String action = request.getParameter("action");
		Boolean flag = true; // flag used to identify if forward dispatcher should be called
		
		System.out.println(request.getQueryString());
		
		if (action != null) {
			switch (action) {
				case "allItems": {
					findAllPurchaseOrders(request, response);	
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

	private void findAllPurchaseOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// list all purchase orders for admin management
		try {
			// calling DAO method to retrieve a list of all purchase orders 
			PurchaseOrderDAOImpl poDao = new PurchaseOrderDAOImpl();
			List<PurchaseOrder> poList = poDao.findAllPurchaseOrders();
			request.setAttribute("poList", poList);
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
