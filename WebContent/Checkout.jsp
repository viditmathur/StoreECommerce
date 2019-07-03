<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ProductDetails"%>
<%@ page import="com.OrderDetails"%>
<%@ page import="com.Auth"%>
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
		int UserId = Integer.parseInt(session.getAttribute("UserId").toString());
			Auth user=new Auth(UserId);
			OrderDetails cart = new OrderDetails(OrderId);
			ArrayList<ProductDetails> productsInCart = cart.getProductList();
		%>
		<div id="indexLeftColumn">
		
			<br> Order Details <br>
			<%
			
		%>
			<div class="productBox">
			<form action="confirmation" method="post">
			<input type="text" name="Name" value="<%=user.getName() %>"><br>
			<input type="text" name="Address" value="<%=user.getAddress()%>"><br>
			<input type="text" name="ContactNumber" value="<%=user.getMobileNumber()%>"><br>
			<button type="submit">Place Order</button>
			</form>
			</div>
			<%
			
			%>
		</div>
		<div id="indexRightColumn">
				<br> Order Summary  <br>
				<div class="productBox">
					<span>Cart Status : <%=cart.getStatus()%></span><br> <span>Total
						Products in Cart : <%=cart.getTotalProducts()%></span><br> <span
						class="productLabelText">Total Amount : <%=cart.getTotalAmount()%></span><br>
				</div>
		</div>

		<footer>Copyright</footer>

	</div>
</body>
</html>