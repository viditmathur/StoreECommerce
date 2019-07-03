package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.Dbconnect;

public class OrderDetails {
	int userId;
	float totalAmount;
	int oderId;
	String date;
	ArrayList<ProductDetails> productList;
	String status;
	int totalProducts;

	public OrderDetails(int userId, float totalAmount, int oderId, String date, ArrayList<ProductDetails> productList,
			String status, int totalProducts) {
		super();
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.oderId = oderId;
		this.date = date;
		this.productList = productList;
		this.status = status;
		this.totalProducts = totalProducts;
	}

	public OrderDetails(int orderId) throws SQLException {
		super();
		Connection con = null;
		ResultSet rs = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "Select* from Order where Id='" + orderId + "';";
			rs = stmt.executeQuery(query5);
			while (rs.next()) {
				this.setOderId(rs.getInt("Id"));
				this.setUserId(rs.getInt("UserId"));
				this.setDate(rs.getString("Date"));
				this.setStatus(rs.getString("Status"));
				this.setTotalAmount(rs.getFloat("Amount"));
			}
			String query6 = "Select* from OrderDetails where OrderId='" + orderId + "' ;";
			rs = stmt.executeQuery(query6);
			while (rs.next()) {
				this.getProductList().add(new ProductDetails(rs.getInt("Id")));
				this.setTotalAmount(this.getTotalAmount() + rs.getFloat("Amount"));
				this.setTotalProducts(this.getTotalProducts() + 1);

			}
		}
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getOderId() {
		return oderId;
	}

	public void setOderId(int oderId) {
		this.oderId = oderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<ProductDetails> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ProductDetails> productList) {
		this.productList = productList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(int totalProducts) {
		this.totalProducts = totalProducts;
	}

	public static void addProductToOrder(int UserId, int OrderId, int productId, int quantity) throws SQLException {
		Connection con = null;
		ProductDetails addProduct = new ProductDetails(productId);
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "insert into Order_Product_Mapping ([OrderId],[Id],[Quantity],[Price]) values('" + OrderId
					+ "','" + productId + "','" + quantity + "','" + addProduct.getPrice() + "');";
			stmt.executeQuery(query5);
		}
	}

	public static void createNewOrder(OrderDetails Order) throws SQLException {
		Connection con = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "insert into [Order] ([Id],[UserId],[Date],[Status],[Amount]) values('" + Order.getOderId()
					+ "','" + Order.getUserId() + "','" + Order.getDate() + "','" + Order.getStatus() + "','"
					+ Order.getTotalAmount() + "');";
			stmt.executeQuery(query5);
		}
	}

	public static void deleteFromOrder(int OrderId, int ProductId) throws SQLException {
		Connection con = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "delete from OrderDetails where [Id]='" + ProductId + "', AND OrderId ='" + OrderId + "');";
			stmt.executeQuery(query5);
		}
	}

	public static void UpdateOrderDetails(int OrderId, int ProductId, int quantity) throws SQLException {
		Connection con = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "Update OrderDetails  SET Quantity ='" + quantity + "' where [Id]='" + ProductId
					+ "', AND OrderId ='" + OrderId + "');";
			stmt.executeQuery(query5);
		}
	}

	public static void UpdateOrderStatus(int OrderId, String status) throws SQLException {
		Connection con = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "Update Order  SET Status ='" + status + "' where [Id]='" + OrderId + "');";
			stmt.executeQuery(query5);
		}
	}

	public static void UpdateOrderDate(int OrderId, String date) throws SQLException {
		Connection con = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "Update Order  SET Date ='" + date + "' where [Id]='" + OrderId + "');";
			stmt.executeQuery(query5);
		}
	}
	public static ArrayList<Integer> FetchOrderId(int UserId, String status) throws SQLException {
		Connection con = null;
		con = Dbconnect.connect();
		ArrayList<Integer> OrderId = new ArrayList<Integer>();
		ResultSet rs=null;
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "Select * from  Order where [UserId]='" + UserId + "' AND Status ='"+status+");";
			rs=stmt.executeQuery(query5);
			while(rs.next()) {
				OrderId.add(rs.getInt("Id"));
			}
		}
		return OrderId;
	}

}
