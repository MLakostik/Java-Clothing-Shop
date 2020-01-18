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
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	Michael Lakostik | 991515743
		 * An arrayList productList is created and gets the values that are stored in the session
		 * An html table is then generated with the append method
		 */
		List<Product> productList = (List<Product>) request.getSession(false).getAttribute("productList");
		
		response.setContentType("text/html");
		
		response.getWriter().append("<link rel=\"stylesheet\" href=\"styles/style.css\">");
		response.getWriter().append("<h1>Shopping Cart</h1>");
		
		response.getWriter().append("<table class=\"products\"> <tr>\n" + 
				"    <th>Brand</th>" + 
				"    <th>Colour</th>" + 
				"    <th>Type</th>" + 
				"    <th>Price</th>" + 
				"  </tr>");
		//The for loop goes through the productList and adds a row for each product in a html table
		//All values are taken using the get methods included in the product class
		for(int i=0; i<productList.size(); i++) {
			
			response.getWriter().append(
				"  <tr>" + 
				"    <td>" + productList.get(i).getBrand() + "</td>" + 
				"    <td>" + productList.get(i).getColor() + "</td>" + 
				"    <td>" + productList.get(i).getType() + "</td>" + 
				"    <td>$" + productList.get(i).getPrice() + "</td>" + 
				"  </tr>");
		}
				
		response.getWriter().append("</table>");
		
		//Generate the html for the Continue Shopping and Checkout buttons
		response.getWriter().append("<div class=\"cartBox\"><a href=\"Home.jsp\">"
				+ "<div class=\"cartBtn\">Continue Shopping</div></a>"
				+ "<a href=\"CheckOut\">"
						+ "<div class=\"cartBtn\">Checkout</div></a></div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
