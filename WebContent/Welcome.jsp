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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/StoreECommerce.css">
<title>Home Page</title>
</head>
<body>
<%
ArrayList<CategoryDetails> categorylist = new ArrayList<CategoryDetails>();
categorylist=Dbconnect.fetchallcategories();
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
			<br>Description For E-Commerce<br> <img
				src="images/storebanner.jfif" style="width: 96%; margin: 2%">
			<br>

		</div>
		<div class="components">
			<br> Categories<br>
<%for(int i=0;i<categorylist.size();i++){ 
%>		
				<div class="categoryBox" >
					<spanclass="categoryLabelText"><%=categorylist.get(i).getName() %></span><br>
						<span class="categoryLabelText" style="font-size:smaller"><%=categorylist.get(i).getDescription() %></span><br>
						<a href="Category.jsp?category=<%=categorylist.get(i).getId()%>"> 
						<span class="categoryLabelText" ><img style="height:96px;width:140px;margin:10px" src="images/<%=categorylist.get(i).getImage() %>"></span><br>
						<span class="categoryLabelText" style="font-size:smaller"><input type="button" value="View"></span><br>
						
					</a>
				</div>
		
<%} %>		</div>


		<footer>Copyright</footer>
	</div>

</body>
</html>