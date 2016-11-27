/**
 * 
 */
package com.nitin.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nitin.dao.UserDAO;

/**
 * @author Nitin Gudle
 *Aug 13, 2012 1:15:22 PM
 *Project:-ATT
 *Package:-com.nitin.action.user
 *File:-DeleteI.java
 */
public class DeleteI extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			UserDAO userDAO=UserDAO.getInstance();
			String user=request.getParameter("user");
			String select[]=request.getParameterValues("select");
			if(select==null)
				response.sendRedirect(request.getContextPath()+"/res/JSP/User/deletei.jsp?no=1&user="+user);
			else
			{
				boolean result=false;
				for(int i=0;i<select.length;i++)
				{
					if(userDAO.deleteI(select[i]))
					{
						result=true;
					}
					else
					{
						result=false;
						break;
					}
				}
				if(result)
					response.sendRedirect(request.getContextPath()+"/res/JSP/User/deletei.jsp?no=2&user="+user);
				else
					response.sendRedirect(request.getContextPath()+"/res/JSP/User/deletei.jsp??no=3&user="+user);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in DeleteI Servlet................."+e);
			out.println("Error in DeleteI Servlet.................");
		}
	}
}