<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import= "com.ProductDetails" %>
<%@ page import= "com.CategoryDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/StoreECommerce.css">
<title>Product Page</title>
</head>
<body>
	<%
	int parameter;
if(request.getParameter("product")!=null){
	 parameter= Integer.parseInt(request.getParameter("product"));
}
else
{
	 parameter=1;
}
ProductDetails Product=new ProductDetails(parameter); 
	int categoryparameter;
if(request.getParameter("category")!=null){
	 categoryparameter= Integer.parseInt(request.getParameter("category"));
}
else
{
	 categoryparameter=1;
}
CategoryDetails Category=new CategoryDetails(categoryparameter); 
%>
	<div id="main">
		<header>
			Welcome
			<div id="navBar">
				<ul style="float: left; margin: 3px;">
					<li style="display: inline; margin: 3px; float: left;"><a href="Welcome.jsp">
							Home </a></li>
					<li style="display: inline; margin: 3px; float: right;"><a
						href="index.jsp"> Logout </a></li>
					<li style="display: inline; margin: 3px; margin-right:2%; float: right;"><a href="Cart.jsp">
							Cart </a></li>
				</ul>
			</div>
		</header>
		<br> <br>
		<div id="indexLeftColumn">
<br>More Products <br>
			<%int siz=Category.size();
			for(int i=0; i<siz ;i++){
			ProductDetails Prod = new ProductDetails(Category.getProductList(i));
			%> 
			<div class="productBox">
				<a href="Product.jsp?product=<%Prod.getId();%>&category=<%Category.getId();%>"> <span
					class="productLabelText"><%=Prod.getName()%></span><img src="<%Prod.getImage();%>">
				</a>
			</div>
			<%}%>
		</div>


		<div id="indexRightColumn">
			<br> Products <br>
			<form action="Product" method="post">
			<div class="productImage">
				<img style="height:25%;width:25%;margin:5%" src="<%=Product.getImage()%>">
			</div><br>
			<input type="hidden" name="productId" value="<%=Product.getId()%>" >
			<div class="productName" >
				<%=Product.getName() %>
			</div><br>
			<div class="productPrice">
				<%=Product.getPrice() %>
			</div><br>
			<div class="productDescription">
				<%=Product.getDescription() %>
			</div>
			<input type="submit" value="Add to Cart"></input>
			</form>
		</div>


		<footer>Copyright</footer>
	</div>

</body>
</html>