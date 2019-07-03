<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.ProductDetails" %>
<%@ page import= "com.CategoryDetails" %>
<%@ page import= "com.connection.Dbconnect" %>
<%@ page import= "java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/StoreECommerce.css">
<title>Category Page</title>
</head>
<body>
<%
int parameter;
if(request.getParameter("category")!=null){
 parameter= Integer.parseInt(request.getParameter("category"));
}
else
{
 parameter=1;
}
CategoryDetails Category=new CategoryDetails(parameter);
%>

	<div id="main">
		<header>
			Welcome<br>
			<div class="navbar">
				<ul style="float: left; margin: 3px;">
					<li style="display: inline; margin: 3px; float: left;"><a
						href="Welcome.jsp"> Home </a></li>
					<li style="display: inline; margin: 3px; float: right;"><a
						href="index.jsp"> Logout </a></li>
					<li style="display: inline; margin: 3px; float: right;"><a
						href="Cart.jsp"> Cart </a></li>
					<li style="display: inline; margin: 3px; float: right;"><a
						href=""> Search </a></li>
				</ul>
			</div>
		</header>
		<br> <br>
		<div class="banner">
			<br><%=Category.getName() %><br> <img style="height:25%;width:25%;margin:3%"
				src="images/<%=Category.getImage()%>" style="width: 96%; margin: 2%">
			<br>
				<%=Category.getDescription() %><br><br>
		</div>
		<div class="components">
			<br> Products<br><br>
<%for(int i=0;i<Category.size();i++){ 
%>		
				<div class="categoryBox" >
				 <span
						class="categoryLabelText"><%=Category.getProductList().get(i).getName() %></span><br>
					<a href="Product.jsp?product=<%=Category.getProductList().get(i).getId()%>&category=<%=Category.getId() %>">
						<span class="categoryLabelText" ><img style="height:120px;width:146px" src="images/<%=Category.getProductList().get(i).getImage() %>"></span><br><br>
						<input type="button" value="View"><br>
					</a>
					<span class="categoryLabelText" style="font-size:smaller">Rs. <%=Category.getProductList().get(i).getPrice()%></span><br>
					
					
						<span class="categoryLabelText" style="font-size:smaller"><%=Category.getProductList().get(i).getDescription() %></span><br><br>
				</div>
		
<%} %>		</div>

<div>
<br><br>
</div>
		<footer>Copyright</footer>
	</div>

</body>
</html>