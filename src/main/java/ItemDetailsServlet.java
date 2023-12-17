import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAOImpl;
import model.Item;

@WebServlet("/ItemDetailsServlet")
public class ItemDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        // Use your DAO to fetch item details by ID
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        Item item = itemDAO.findItemById(productId);

        // Create HTML representation of item details
        String itemDetailsHtml = "<h2>" + item.getName() + "</h2>"
                + "<p>Description: " + item.getDescription() + "</p>"
                + "<p>Category: " + item.getCategory() + "</p>"
                + "<p>Brand: " + item.getBrand() + "</p>"
                + "<p>Quantity: " + item.getQuantity() + "</p>"
                + "<p>Price: $" + item.getPrice() + "</p>";

        // Set content type to HTML
        response.setContentType("text/html");

        // Write item details as HTML response
        try (PrintWriter out = response.getWriter()) {
            out.write(itemDetailsHtml);
        }
    }
}

