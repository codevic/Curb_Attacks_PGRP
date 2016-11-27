/**
 * 
 */
package com.nitin.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nitin.dao.AdminDAO;
import com.nitin.dao.UserDAO;

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
			UserDAO userDAO=UserDAO.getInstance();
			boolean result=userDAO.loginCheck(user, opass);
			if(result)
			{
				if(npass.equalsIgnoreCase(cpass))
				{
					if(userDAO.changePass(user, opass, npass))
					{
						response.sendRedirect(request.getContextPath()+"/res/JSP/User/change.jsp?no=2&user="+user);
					}
					else
					{
						response.sendRedirect(request.getContextPath()+"/res/JSP/User/change.jsp?no=3&user="+user);
					}
				}
				else
				{
					response.sendRedirect(request.getContextPath()+"/res/JSP/User/change.jsp?no=4&user="+user);
				}
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/res/JSP/User/change.jsp?no=1&user="+user);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in ChangePass Servlet................."+e);
			out.println("Error in ChangePass Servlet.................");
		}
	}
}