
import java.io.IOException;
import java.io.PrintWriter;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
*/

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PassCheck
 */
@WebServlet("/Pass")
public class PassCheck extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	private String pass;
	private String username;
	private LoginPortal e1=new LoginPortal();
Employee_Login emp1=(Employee_Login) e1.Login();
Validator v1=emp1.get_validator();

	public PassCheck() {
		super();}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter p1=response.getWriter()	;
		p1.println("<html>");
		p1.println("<body>");
		p1.println("<h1>hello Pass Servlet</h1>");
		
		
		p1.println("</html>");
		p1.println("</body>");
		p1.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter p1 = response.getWriter();
		
		p1.println("<HTML>");
		p1.println("<BODY>"+"<div align="+"center>");

		pass = request.getParameter("pass");
		username = request.getParameter("username");
		request.setAttribute("username",username );
		ServletContext sc = this.getServletContext();
		
		switch (v1.Login(username, pass)) {
		case -1: {
			RequestDispatcher rd2 = sc.getRequestDispatcher("/Register.jsp");
			rd2.forward(request,response);
			break;
		}
		
		case 1:{
			RequestDispatcher rd1 = sc.getRequestDispatcher("/yourportal.jsp");
			rd1.forward(request, response);
			break;
		}
		case 0:{
			RequestDispatcher rd3 = sc.getRequestDispatcher("/Wrong_pass.jsp");
			rd3.forward(request, response);
		}
			
		default:
			//response.sendError(404);
			throw new IllegalArgumentException("Unexpected value: " + v1.Login(username, pass));
		}
		/*if (v1.Login(username, pass)==1) {
			RequestDispatcher rd1 = sc.getRequestDispatcher("/yourportal.jsp");
			rd1.forward(request, response);
			
		} 
		else if(v1.Login(username,pass)==-1) {
			RequestDispatcher rd2 = sc.getRequestDispatcher("/Register.jsp");
			rd2.forward(request,response);
		}
		
		else {
			RequestDispatcher rd3 = sc.getRequestDispatcher("/Wrong_pass.jsp");
			rd3.forward(request, response);
			}*/

		p1.println("</div></body>");
		p1.println("</HTML>");
		p1.close();

	}

}
