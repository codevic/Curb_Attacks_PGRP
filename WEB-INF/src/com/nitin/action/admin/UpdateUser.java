/**
 * 
 */
package com.nitin.action.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nitin.dao.AdminDAO;

public class UpdateUser extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String id=request.getParameter("id");
			String uname=request.getParameter("uname");
			String uid=request.getParameter("uid");
			String upass=request.getParameter("upass");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String email=request.getParameter("email");
			
			AdminDAO adminDAO=AdminDAO.getInstance();
			if(adminDAO.updateUser(id,uname, uid, upass, city, state, email))
					response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/edit.jsp?no=2");
			else
				response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/edit1.jsp?no=3");
		}
		catch(Exception e)
		{
			System.out.println("Error in AdminLogin Servlet................."+e);
			out.println("Error in AdminLogin Servlet.................");
		}
	}
}