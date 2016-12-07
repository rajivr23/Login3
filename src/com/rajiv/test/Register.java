package com.rajiv.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	
        String username = request.getParameter("user");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        System.out.println("username>>>>>>>>>>>>>>>>>>>>>>"+username);
        
        try{
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql://Localhost:3306/info","root","rajiv");

      /* Statement s=con.createStatement();
      String sql="insert into login3 values('"+username+"','"+email+"','"+pass+"')";*/
      PreparedStatement pst =(PreparedStatement) con.prepareStatement("insert into login3(user,email,pass) values(?,?,?)");
      pst.setString(1, username);
      pst.setString(2, email); 
      pst.setString(3, pass); 
     // RequestDispatcher rd=null;
      int i=0;
    i=pst.executeUpdate();
    
    out.println("<br>username: "+username);
	out.println("<br>email: "+email);
	out.println("<br>password: "+pass);
	
        
          if(i>0)
          {
            out.println("<br>You are sucessfully registered");
            out.println("<br> Go back to login page");
           // rd=request.getRequestDispatcher("index.html");
           // rd.include(request, response);
          }
        //  response.sendRedirect("Success.html");
          
          
         
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }