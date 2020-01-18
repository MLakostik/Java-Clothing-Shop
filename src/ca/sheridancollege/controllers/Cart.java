package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ca.sheridancollege.beans.Product;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean isEmpty;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Michael Lakostik | 991515743
		// isEmpty is a boolean to make sure an item is selected before user is taken to the ViewCart Servet
		if(isEmpty == false) {
			request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		//Create an array of strings that contain the values of each item selected from the shop
		String[] items = request.getParameterValues("item");
		
		List<Product> productList = new CopyOnWriteArrayList<Product>();;
		
		//If no items are selected the user is sent back to the home page with a redirect
		if (items == null) {
			response.sendRedirect("./Home.jsp");
			//Create a product array list for each ordered product
		
			request.getSession().setAttribute("productList", productList);
			isEmpty = true;
		} else {
			isEmpty = false;
			//productList = (List<Product>) request.getSession().getAttribute("productList");
			request.getSession().setAttribute("productList", productList);
		}
		
		/*
		 * If a user has selected at least 1 item a for loop begins
		 * 
		 * The for loop iterates through the items array and splits the values which are
		 * separated by commas in the form. Each index of the array represents one of the 4 values
		 * in the product object (brand, type, color, and price)
		 * 
		 * A new product object is then created and is added to the productList copyOnWriteArrayList
		 * 
		 * The productList is then added to the session
		 */
		if (isEmpty == false) {
			for (int i = 0; i < items.length; i++) {
				String[] item = items[i].split(",");
				String brand = item[0];
				String type = item[1];
				String color = item[2];
				double price = Double.parseDouble(item[3]);

				Product product = new Product(brand, type, color, price);

				productList.add(product);

			}
			//request.getSession(true).setAttribute("productList", productList);
		}
		doGet(request, response);
	}
}
