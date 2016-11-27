/**
 * 
 */
package com.nitin.action.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nitin.dao.*;

/**
 * @author Nitin Gudle
 *Aug 9, 2012 2:52:20 PM
 *Project:-ATT
 *Package:-com.nitin.action.user
 *File:-AdminLogin.java
 */
public class AdminLogin extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			AdminDAO adminDAO=AdminDAO.getInstance();
			boolean result=adminDAO.loginCheck(name, pass);
			if(result)
			{
				RequestDispatcher rd=null;
				request.setAttribute("admin", name);
				rd=request.getRequestDispatcher("/res/JSP/Admin/home.jsp");
				rd.forward(request,response);
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/index.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in AdminLogin Servlet................."+e);
			out.println("Error in AdminLogin Servlet.................");
		}
	}
}