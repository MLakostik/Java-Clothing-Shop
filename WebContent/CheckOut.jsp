<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List, ca.sheridancollege.beans.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<h1>Your Order JSP</h1>
	<% //Michael Lakostik | 991515743 | lakostim
			List<Product> productList = (List<Product>) request.getSession().getAttribute("productList");

			pageContext.setAttribute("products", productList);
			
			double subTotal = 0;
			for(Product product : productList){
				subTotal += product.getPrice();
			} 
			pageContext.setAttribute("subTotal", subTotal);
			
			%>
	<table class="products">
		<tbody>

			<c:forEach items="${products}" var="product">
				<tr>
					<td><c:out
							value="${product.brand} ${product.type} (${product.color})" /></td>
					<td><c:out value="${product.price}" /></td>
				</tr>
			</c:forEach>

			<tr>
				<td>Sub Total</td>
				<td><c:out value="${subTotal}" /></td>
			</tr>

			<tr>
				<td>Tax</td>
				<td>13%</td>
			</tr>

			<tr>
				<td>Total</td>
				<td><fmt:formatNumber type="number" maxFractionDigits="2"
						minFractionDigits="2" value="${subTotal+subTotal*0.13}" /></td>
			</tr>
		</tbody>
	</table>

	<div class="cartBox">
		<a href="Home.jsp"><div class="cartBtn">Order Again</div></a>
	</div>
</body>
</html>