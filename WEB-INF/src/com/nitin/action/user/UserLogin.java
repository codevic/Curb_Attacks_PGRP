/**
 * 
 */
package com.nitin.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nitin.dao.UserDAO;
import com.nitin.utility.Utility;


public class UserLogin extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			UserDAO userDAO=UserDAO.getInstance();
			String ip=request.getLocalAddr();
			if(request.getSession().getAttribute("ATT")=="yes")
			{
				String code=Utility.parseString(request.getParameter("code"));
				boolean chk=false;
				Vector v=(Vector)request.getSession().getAttribute("code");
				if(v!=null)
				for(int i=0;i<v.size();i++)
				{
					String c=(String)v.get(i);
					if(code.charAt(i)==c.charAt(0))
					{
						chk=true;
					}
					else
					{
						break;
					}
				}
				if(chk)
				{
					if(userDAO.loginCheck(name, pass))
					{
						int count=userDAO.trackLogin(name, ip);
						if(count==1000)
							userDAO.trackIT(name, ip);
						else
							userDAO.trackIncrement(name, ip);
						RequestDispatcher rd=null;
						request.setAttribute("user", name);
						rd=request.getRequestDispatcher("/res/JSP/User/home.jsp");
						rd.forward(request,response);
					}
					else
						response.sendRedirect(request.getContextPath()+"/index.jsp?no=2&ATT=3");
				}
				else
					response.sendRedirect(request.getContextPath()+"/index.jsp?no=4&ATT=3");
			
				request.getSession().setAttribute("ATT", "No");
			}
			else
			{	
				boolean result=userDAO.loginCheck(name, pass);
				if(result)
				{
					int count=userDAO.trackLogin(name, ip);
					if(count==1000)
						userDAO.trackIT(name, ip);
					else
						userDAO.trackIncrement(name, ip);
					RequestDispatcher rd=null;
					request.setAttribute("user", name);
					rd=request.getRequestDispatcher("/res/JSP/User/home.jsp");
					rd.forward(request,response);
				}
				else
				{
					int count=userDAO.trackLogin(name, ip);
					if(count!=1000)
					{
						if(count<Integer.parseInt(Utility.getPro("threshold")))
						{
							response.sendRedirect(request.getContextPath()+"/index.jsp?no=2&ATT=3");
						}
						else
						{
							userDAO.trackIncrement(name, ip);
							response.sendRedirect(request.getContextPath()+"/index.jsp?no=2");
						}
					}
					else
					{
						response.sendRedirect(request.getContextPath()+"/index.jsp?no=2&ATT=3");
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in UserLogin Servlet................."+e);
			out.println("Error in UserLogin Servlet.................");
		}
	}
}