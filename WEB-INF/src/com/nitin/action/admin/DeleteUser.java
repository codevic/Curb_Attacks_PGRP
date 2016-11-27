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


public class DeleteUser extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			AdminDAO adminDAO=AdminDAO.getInstance();
			String select[]=request.getParameterValues("select");
			if(select==null)
				response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/delete.jsp?no=1");
			else
			{
				boolean result=false;
				for(int i=0;i<select.length;i++)
				{
					if(adminDAO.deleteUser(select[i]))
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
					response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/delete.jsp?no=2");
				else
					response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/delete.jsp?no=3");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in AdminLogin Servlet................."+e);
			out.println("Error in AdminLogin Servlet.................");
		}
	}
}