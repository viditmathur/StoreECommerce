<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ProductDetails"%>
<%@ page import="com.OrderDetails"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="main">
		<header>
			Welcome
			<div id="navBar">
				<ul style="float: left; margin: 3px;">
					<li style="display: inline; margin: 3px; float: left;"><a
						href="Welcome.jsp"> Home </a></li>
					<li style="display: inline; margin: 3px; float: right;"><a
						href="index.jsp"> Logout </a></li>
					<li
						style="display: inline; margin: 3px; margin-right: 2%; float: right;"><a
						href="Cart.jsp"> Cart </a></li>
				</ul>
			</div>
		</header>
		<br> <br>

		<%
			int OrderId = Integer.parseInt(session.getAttribute("OrderId").toString());
			OrderDetails cart = new OrderDetails(OrderId);
			ArrayList<ProductDetails> productsInCart = cart.getProductList();
		%>
		<div id="indexLeftColumn">
		
			<br> Products in Cart <br>
		<%
			int siz = productsInCart.size();
			for (int i = 0; i < siz; i++) {
				ProductDetails Prod = new ProductDetails(productsInCart.get(i));
		%>
			<div class="productBox">
				<span class="productLabelText"><%=Prod.getName()%></span><img
					src="<%Prod.getImage();%>"><span><%=Prod.getPrice()%>
				</span>

			</div>
			<%
				}
			%>
		</div>
		<div id="indexRightColumn">
			<form action="checkout" method="post">
				<br> Cart Details <br>
				<div class="productBox">
					<span>Cart Status : <%=cart.getStatus()%></span><br> <span>Total
						Products in Cart : <%=cart.getTotalProducts()%></span><br> <span
						class="productLabelText">Total Amount : <%=cart.getTotalAmount()%></span><br>
				</div>
				<button type="submit">Confirm</button>
			</form>
		</div>

		<footer>Copyright</footer>

	</div>
</body>
</html>