/**
 * 
 */
package com.nitin.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nitin.dao.UserDAO;


public class SendMail extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String user=request.getParameter("user");
			String to=request.getParameter("to");
			String sub=request.getParameter("sub");
			String msg=request.getParameter("msg");
			UserDAO userDAO=UserDAO.getInstance();
			RequestDispatcher rd=null;
			if(userDAO.loginCheck(to))
			{
				boolean result=userDAO.sendMail(user, to, sub, msg);
				if(result)
				{
					request.setAttribute("user", user);
					rd=request.getRequestDispatcher("/res/JSP/User/write.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					request.setAttribute("user", user);
					rd=request.getRequestDispatcher("/res/JSP/User/write.jsp?no=3");
					rd.forward(request,response);
				}
			}
			else
			{
				request.setAttribute("user", user);
				rd=request.getRequestDispatcher("/res/JSP/User/write.jsp?no=1");
				rd.forward(request,response);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error in SendMail Servlet................."+e);
			out.println("Error in SendMail Servlet.................");
		}
	}
}