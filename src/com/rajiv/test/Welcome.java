package com.rajiv.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		
		
		PrintWriter out=response.getWriter();
		
		out.println(" Welcome User");
		String username=request.getParameter("user");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		out.println("<br> the user details are<br>");
		
		
		out.println("username:" +username);
		out.print("<br>email:"+email);
		out.print("<br>password:"+pass);
		
	}

	

}
