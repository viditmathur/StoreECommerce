package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconnect;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String userId = (String) request.getAttribute("UserId");
		String Password = null;
		Connection con = null;
		ResultSet rs = null;
		con = Dbconnect.connect();
		if (con != null) {
			Statement stmt;
			try {
				stmt = con.createStatement();
				String query5 = "Select* from [Auth] where Id='" + userId + "';";
				rs = stmt.executeQuery(query5);
				while (rs.next()) {
					userId=rs.getString("Id").toString();
					Password=rs.getString("Password").toString();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(Password.equals(request.getAttribute("Password").toString())) {
			session.setAttribute("UserId", userId);
			response.sendRedirect("Welcome.jsp");

		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
