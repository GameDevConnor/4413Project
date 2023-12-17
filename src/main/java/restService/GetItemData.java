package restService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import dao.ItemDAOImpl;
import model.Item;



/**
 * Servlet implementation class GetItemData
 */
public class GetItemData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetItemData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		if (request.getParameter("comm") != null) {
			  
			if (request.getParameter("comm").equals("ajax")) {
				
				
			ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
						
			System.out.println("URL: " + request.toString());

			System.out.println("Parameter: " + request.getParameter("a"));
			
			Item item = itemDAOImpl.findItemById(request.getParameter("a"));
			
		   	JSONObject jsonObject = new JSONObject();
		   	jsonObject.put("itemName", item.getName());
		   	jsonObject.put("itemDescription", item.getDescription());
		   	jsonObject.put("itemCategory", item.getCategory());
		   	jsonObject.put("itemBrand", item.getBrand());
		   	jsonObject.put("itemQuantity", item.getQuantity());
		   	jsonObject.put("itemPrice", item.getPrice());
		   	
		   	response.getWriter().print(jsonObject.toString());
			}
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
