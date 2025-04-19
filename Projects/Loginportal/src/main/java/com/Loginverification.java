package com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First_servlet
 */

public class Loginverification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Loginverification() {
		// TODO Auto-generated constructor stub
	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String result=null;
		String e1=null;
		response.setContentType("text/html");
		PrintWriter p1 = response.getWriter();
		
		p1.println("<HTML>");
		p1.println("<BODY>"+"<div align="+"center");
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root",
				"furious7")) {

			Statement st = con.createStatement();
String Query="SELECT "+ "password"+" FROM "+ "login_details"+" WHERE " +"'" + "balram" + "';";
			//String Query = op.select("password", "login_details", "username=" + "'" + uname + "'");
			ResultSet rs = st.executeQuery("select password from login_details where username='mchdjdndn';");

			while (rs.next()) {
				result = rs.getString(1);
				
			}

		}

		catch (SQLException e) {
			// Handling code here
			p1.println(e);
			e1=e.toString();

		}
		p1.println("Hello this is first servlet program </br>");
		p1.println(result);
		p1.println("<h1>hello </h1>"+e1+"</div></body>");
		p1.println("</HTML>");
		p1.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
