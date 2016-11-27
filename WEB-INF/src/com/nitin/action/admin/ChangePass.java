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

/**
 * @author Nitin Gudle
 *Aug 13, 2012 11:22:16 AM
 *Project:-ATT
 *Package:-com.nitin.action.admin
 *File:-ChangePass.java
 */
public class ChangePass extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String user=request.getParameter("user");
			String opass=request.getParameter("opass");
			String npass=request.getParameter("npass");
			String cpass=request.getParameter("cpass");
			AdminDAO adminDAO=AdminDAO.getInstance();
			boolean result=adminDAO.loginCheck(user, opass);
			if(result)
			{
				if(npass.equalsIgnoreCase(cpass))
				{
					if(adminDAO.changePass(user, opass, npass))
					{
						response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/change.jsp?no=2&user="+user);
					}
					else
					{
						response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/change.jsp?no=3&user="+user);
					}
				}
				else
				{
					response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/change.jsp?no=4&user="+user);
				}
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/change.jsp?no=1&user="+user);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in ChangePass Servlet................."+e);
			out.println("Error in ChangePass Servlet.................");
		}
	}
}