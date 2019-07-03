package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.CategoryDetails;

public class Dbconnect {
	public static ArrayList<CategoryDetails> fetchallcategories() {
		ArrayList<CategoryDetails> categorylist= new ArrayList<CategoryDetails>();
		try{
			Connection conn= connect();
			if(conn!=null) {
				String query6 = "select * from Category";
				try{
					ResultSet rs=null;
					Statement stmt = conn.createStatement();
					rs=stmt.executeQuery(query6);
					while(rs.next())
					{
					categorylist.add(new CategoryDetails(rs.getInt("Id")));
					}
					return categorylist;
				}
				catch(Exception e) {
					e.printStackTrace();
				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return categorylist;
		
	}
	public static Connection connect() {
	try {
		
	       
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG336;database=StoreECOmmerce";
				String user = "vidit";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
				return	con;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		catch(Exception c){
			c.printStackTrace();
			return null;
		}
	return null;}
}
