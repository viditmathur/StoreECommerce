package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.Dbconnect;

public class Auth {
	int UserId;
	String Name;
	String Address;
	int MobileNumber;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(int i) {
		MobileNumber = i;
	}

	public Auth(int userId, String name, String address, int mobileNumber) {
		super();
		UserId = userId;
		Name = name;
		Address = address;
		MobileNumber = mobileNumber;
	}
	public Auth(int userId) throws SQLException {
		super();
		UserId = userId;
		Connection con = null;
		ResultSet rs = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt = con.createStatement();
			String query5 = "Select* from User where Id='" + userId + "';";
			rs = stmt.executeQuery(query5);
			while (rs.next()) {
				this.setUserId(rs.getInt("Id"));
				this.setMobileNumber(rs.getInt("ContactNumber"));
				this.setName(rs.getString("Name"));
				this.setAddress(rs.getString("Address"));
			}
		}
	}

	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}

}
