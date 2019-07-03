package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.Dbconnect;

public class ProductDetails {

	int Id;
	String Name;
	String Description;
	float Price;
	String Image;

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

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public ProductDetails(int id, String name, String description, float price, String image) {
		super();
		Id = id;
		Name = name;
		Description = description;
		Price = price;
		Image = image;
	}

	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDetails(ProductDetails prod) {
		super();
		this.setId(prod.getId());
		this.setDescription(prod.getDescription());
		this.setImage(prod.getDescription());
		this.setName(prod.getName());
		this.setPrice(prod.getPrice());
	}

	public ProductDetails(int id) throws SQLException {
		super();
		Connection con = null;
		con = Dbconnect.connect();
		if (con != null) {
			ResultSet rs = null;
			Statement stmt = con.createStatement();
			String query5 = "select * from Product where Id = '" + id + "'";
			rs = stmt.executeQuery(query5);
			while (rs.next()) {
				this.setId(rs.getInt("Id"));
				this.setName(rs.getString("Name"));
				this.setDescription(rs.getString("Description"));
				this.setPrice(rs.getFloat("Price"));
				this.setImage(rs.getString("Image"));
			}
		}
	}

}
