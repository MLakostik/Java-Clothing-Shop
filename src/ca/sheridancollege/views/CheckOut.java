package ca.sheridancollege.views;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Product;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Michael Lakostik | 991515743
		
		//Create another product list using the list stored in the session
		List<Product> productList = (List<Product>) request.getSession(false).getAttribute("productList");
		
		//Generate another html page with the append method
		response.setContentType("text/html");
		
		response.getWriter().append("<link rel=\"stylesheet\" href=\"styles/style.css\">");
		
		response.getWriter().append("<table class=\"products\">");
		
		//Create a double to store the subTotal of the users order
		double subTotal = 0;
		
		//Iterate through each product selected and create a new table row for the data
		//The subTotal also adds the price of each item
		for (int i = 0; i < productList.size(); i++) {
			response.getWriter().append(
					"  <tr>" + 
					"    <td>" + productList.get(i).toString() + "</td>" + 
					"    <td>$" + productList.get(i).getPrice() + "</td>" + 
					"  </tr>");
			subTotal += productList.get(i).getPrice();
		}
		
		response.getWriter().append("<h1>Your Order</h1>");
		
		//Create several table rows with with the following data
		// Subtotal, Tax, and Total
		//The string.format method is used to round each double to 2 decimal places
		response.getWriter().append(
				"  <tr>" + 
				"    <td>" + "Sub Total" + "</td>" + 
				"    <td>$" + String.format("%.2f", subTotal) + "</td>" + 
				"  </tr>" + 
				"  <tr>" + 
				"    <td>" + "Tax" + "</td>" + 
				"    <td>" + "13%" + "</td>" + 
				"  </tr>" +
				"  <tr>" + 
				"    <td>" + "Total" + "</td>" + 
				"    <td>$" + String.format("%.2f", subTotal +(subTotal * 0.13)) + "</td>" + 
				"  </tr></table>");
		
		response.getWriter().append("<div class=\"cartBox\"><a href=\"./\">"
				+ "<div class=\"cartBtn\">Order Again</div></a></div>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
