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

import com.nitin.dao.AdminDAO;


public class CreateUser extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			
			String uname=request.getParameter("uname");
			String uid=request.getParameter("uid");
			String upass=request.getParameter("upass");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String email=request.getParameter("email");
			
			AdminDAO adminDAO=AdminDAO.getInstance();
			boolean result=adminDAO.loginCheck(uid);
			if(!result)
			{
				if(adminDAO.createUser(uname, uid, upass, city, state, email))
					response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/create.jsp?no=2");
				else
					response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/create.jsp?no=3");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/create.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in AdminLogin Servlet................."+e);
			out.println("Error in AdminLogin Servlet.................");
		}
	}
}