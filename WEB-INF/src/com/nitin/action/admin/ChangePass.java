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