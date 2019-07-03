package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.Dbconnect;

public class CategoryDetails {
	int Id;
	String Name;
	String Description;
	String Image;
	public String getImage() {
		return Image;
	}



	public void setImage(String image) {
		Image = image;
	}



	ArrayList<ProductDetails> ProductList =new ArrayList<ProductDetails>();



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}
	public int size() {
		return ProductList.size();
		
	}


	public ArrayList<ProductDetails> getProductList() {
		return ProductList;
	}
	public ProductDetails getProductList(int num) {
		return ProductList.get(num);
	}


	public void setProductList(ArrayList<ProductDetails> productList) {
		ProductList = productList;
	}



	public CategoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CategoryDetails(int id, String name, String description, String image, ArrayList<ProductDetails> productList) {
		super();
		Id = id;
		Name = name;
		Description = description;
		ProductList = productList;
		Image=image;
	}



	public CategoryDetails(int id) throws SQLException {
		super();
		Connection con = null;
		con=Dbconnect.connect();
		if (con!=null) {
			ResultSet rs=null;
			Statement stmt = con.createStatement();
			String query5 = "select * from Category where Id = '"+id+"'";
			try{
				rs=stmt.executeQuery(query5);

				while(rs.next())
				{
					this.setId(rs.getInt("Id"));
					this.setName(rs.getString("Name").toString());
					this.setDescription((rs.getString("Description").toString()));
					this.setImage((rs.getString("Image").toString()));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			String query6 = "select * from Category_Product_Mapping where CategoryId = '"+id+"'";
			try{
				rs=stmt.executeQuery(query6);
				ArrayList<ProductDetails> prodlist=new ArrayList<ProductDetails>();
				while(rs.next())
				{
					prodlist.add(new ProductDetails(rs.getInt("ProductId")));
				}
				this.setProductList(prodlist);
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			
		}
	}

}
