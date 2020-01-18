<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, ca.sheridancollege.beans.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Cart</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<h1>Shopping Cart JSP</h1>
	<table class="products">
		<tbody>
			<tr>
				<th>Brand</th>
				<th>Colour</th>
				<th>Type</th>
				<th>Price</th>
			</tr>
			<% //Michael Lakostik | 991515743 | lakostim
			List<Product> productList = (List<Product>) request.getSession().getAttribute("productList");
			pageContext.setAttribute("products", productList);
			%>
		
		<c:forEach items="${products}" var="product">
        <tr>
          <td><c:out value="${product.brand}" /></td>
          <td><c:out value="${product.color}" /></td>
          <td><c:out value="${product.type}" /></td>
          <td><c:out value="${product.price}" /></td>
        </tr>
		</c:forEach>
			
		</tbody>
	</table>
	<div class="cartBox">
		<a href="Home.jsp"><div class="cartBtn">Continue Shopping</div></a>
		<a href="CheckOut.jsp"><div class="cartBtn">Checkout</div></a>
	</div>
</body>
</html>