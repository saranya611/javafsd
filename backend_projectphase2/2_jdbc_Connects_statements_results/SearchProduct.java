package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class SearchProduct
 */
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded successfully");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javatraining","root","sarasowmi");
			System.out.println("connected successfully");
			PreparedStatement pstmt = con.prepareStatement("select * from product where id = ?");
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			String search=request.getParameter("search");
			pstmt.setString(1, search);
			
			if(search.isEmpty()) {
			pw.println("you have not entered the product ID. Try again..!");
			pw.println("<br>");
			pw.println("<br><a href='index.html'>Enter productID</a>");
			}else {
				ResultSet rs  = pstmt.executeQuery();
				if(rs.next()) {
					pw.println("Product ID is "+rs.getInt(1));
					pw.println("<br>");
					pw.println("Product name is "+rs.getString(2));
					pw.println("<br>");
					pw.println("Price is "+rs.getInt(3));
				}else {
					pw.println("There is no product. Try again..!");
				}
				pw.println("<br>");
				pw.println("<br><a href='index.html'>Search another product</a>");
			}
			}catch(Exception e) {
				System.out.println(e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
