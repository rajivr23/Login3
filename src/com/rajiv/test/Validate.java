package com.rajiv.test;

import java.sql.*;
public class Validate {

	public static boolean checkUser(String username,String email,String pass)
	{
		boolean st=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/info","root","rajiv");
			Statement stmt=con.createStatement();
			String sql="select * from login3 where user='"+username+"' and email='"+email+"' and pass='"+pass+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				st=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}

}
