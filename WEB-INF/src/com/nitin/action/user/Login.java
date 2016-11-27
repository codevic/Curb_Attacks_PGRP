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
import com.nitin.utility.CL_SendMail;
import com.nitin.utility.Utility;


public class Login extends HttpServlet 
{
	/* Send Mail Paarameters Starts */
	//private static String toEmailId="testmycvsprojects@gmail.com";
	private static String toEmailId="";
	private static  String subject="Your Account Info";
	private static  String message="Some One Tried To Access Your Account.";
	private static  String attachedFilePath="";
	private static  String fromEmailId="dhsinfoblr1@gmail.com";
	private static  String frompassword="dhsinfoblr2014";
	private static  String hostname="smtp.gmail.com";
	private static  String portnumber="465";
	/* Send Mail Paarameters Ends */
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = null;
		String ip = "",hostName="",username="",password="",trustedUser="NO",action="",userEmailId="",code1="";
		int k1=0,k2=0;
		UserDAO userDAO=UserDAO.getInstance();
		boolean flag = false,flag1=false,flag4=false;
		int flag2 =0,flag3 = 0;
		HttpSession session = request.getSession();
		try
		{
			ip=request.getLocalAddr();
			System.out.println("the local ip address "+ip);
			ip = request.getRemoteAddr();
			System.out.println("the ip address is"+ip);
			//ip = Utility.getIpAddress();
		    k1 = Integer.parseInt(Utility.getPro("k1"));
		    k2 = Integer.parseInt(Utility.getPro("k2"));
		    hostName = request.getRemoteHost();
		    System.out.println("the host name is "+hostname);
		    action = request.getParameter("submit");
		    
		    if(action.equals("ATT"))
		    {
		    	System.out.println("ATT Challange Is Required!!!!!!!");
		    	username=request.getParameter("username");
				password=request.getParameter("password");
		    	String code=Utility.parseString(request.getParameter("code"));
		    	
				boolean chk=false;
				Vector v=(Vector)request.getSession().getAttribute("code");
				if(v!=null)
				/*	
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
				*/
				for(int i=0;i<v.size();i++)
				{
					String c=(String)v.get(i);
					code1 +=c.charAt(0);
				}
				
				if(code.equals(code1))
				{
					chk = true;
				}
				System.out.println("-----------------------------------------");
				System.out.println("Capcha Value1 : " + code);
				System.out.println("Capcha Value2 : " + code1);
				System.out.println("Capcha Status : " +chk);
				
				System.out.println("-----------------------------------------");
				
				if(chk)
				{
					
					flag = userDAO.loginCheck(username,password);
					if(flag)
					{
						
						
						flag = userDAO.checkFT(username);
						if(flag)
						{
							userDAO.initFTtoDefault(username);
						}
						
						userDAO.initFStoDefault(username,ip);
						/*
						if(flag)
						{
							
							flag1 = userDAO.trackUserIn_W(username,ip);
							// Inserting The Record In Table Table_w
							if(!flag1)
							{
								userDAO.mapW(username, ip);
							}
							
							
							*/
							// Redirect To Home Page
							request.setAttribute("user",username);
							rd=request.getRequestDispatcher("/res/JSP/User/home.jsp");
							rd.forward(request,response);
					/*		
						}
						else
						{
							System.out.println("Opps,Invalid Username and Password!!!!!!");
							rd=request.getRequestDispatcher("index.jsp?no=2");
							rd.forward(request,response);
						}*/
					}
					else
					{
						System.out.println("Opps,Invalid Username and Password!!!!!!");
						rd=request.getRequestDispatcher("index.jsp?no=2");
						rd.forward(request,response);
					}
				}
				else
				{
					System.out.println("Opps,Invalid Capcha Code,Try Again!!!!");
					
					//Sending The Account Info Starts
					CL_SendMail.sendPersonalizedMail(userEmailId,fromEmailId,frompassword,subject,message,attachedFilePath,hostname,portnumber);
					//Sending The Account Info Ends
					
					rd=request.getRequestDispatcher("index.jsp?no=2&ATT=3");
					rd.forward(request,response);
				}
		    }
		    else
		    {
		    	System.out.println("ATT Challange Is NOT Required.");
		    	 // Step 1
				username=request.getParameter("username");
				password=request.getParameter("password");
				userEmailId = userDAO.getUserEmailId(username);
				String[] chk =request.getParameterValues("chk");
				if(chk != null)
				{
					trustedUser = chk[0];
				}
				
				System.out.println("*********** Login Info *********");
				System.out.println("Username : " + username);
				System.out.println("Password : " + password);
				System.out.println("IP Address : " + ip);
				System.out.println("K1 : " +k1);
				System.out.println("K2 : " +k2);
				System.out.println("Trusted User : " +trustedUser);
				
				// Step 2
				flag = userDAO.loginCheck(username,password);
				
				if(flag)// Step 2(Part1-Valid User)
				{
					// Step 3
					flag1 = userDAO.trackUserIn_W(username,ip);
					flag2 = userDAO.getFS(username,ip);
					flag3 = userDAO.getFT(username);
					if( ((flag1)&&(flag2<k1))  || (flag3<k2))
					{
						//If Trusted User
						//if(trustedUser.equals("YES"))
						if(trustedUser.equals("YES"))
						{
							System.out.println("The User Is Trusted.");
							// Redirect To Home Page
							
							//Enhancements STARTS
							flag1 = userDAO.trackUserIn_W(username,ip);
							// Inserting The Record In Table Table_w
							if(!flag1)
							{
								userDAO.mapW(username, ip);
								// Inserting The Record In Table Table_FS
								flag = userDAO.checkExistanceInFS(username, ip);
								if(!flag)
								{
									userDAO.mapFS(username, ip);
								}
								flag = userDAO.initFStoDefault(username,ip);
							}
							
							
							// mAKING fs = 0
							
							
							//Enhancements ENDS
							request.setAttribute("user",username);
							rd=request.getRequestDispatcher("/res/JSP/User/home.jsp");
							rd.forward(request,response);
							
							
						}
						else// Untrusted User
						{
							/*System.out.println("The User Is Untrusted.");
							
							// Inserting The Record In Table Table_w
							if(!flag1)
							{
								userDAO.mapW(username, ip);
							}
							// Inserting The Record In Table Table_FS
							flag = userDAO.checkExistanceInFS(username, ip);
							if(!flag)
							{
								userDAO.mapFS(username, ip);
							}
							
							*/
							// Redirect To Home Page
							// mAKING fs = 0
							
							// If username is not there in Table_FT Then Insert
							flag = userDAO.checkFT(username);
							if(!flag)
							{
								userDAO.mapFT(username);
							}
							else
							{
								userDAO.initFTtoDefault(username);
							}
							
						   flag = userDAO.initFStoDefault(username,ip);
							
							//If failed attempt of FT<3 redirect to
							request.setAttribute("user",username);
							rd=request.getRequestDispatcher("/res/JSP/User/home.jsp");
							rd.forward(request,response);
						}
						
						
					}
					else
					{
						// Redirect For ATT Challange
						System.out.println("Welcome To Step3 Else Part.");
						System.out.println("Now User Has To Pass The ATT Chalange!!!!!!!!!");
						
						//Sending The Account Info Starts
						CL_SendMail.sendPersonalizedMail(userEmailId,fromEmailId,frompassword,subject,message,attachedFilePath,hostname,portnumber);
						//Sending The Account Info Ends
						
						rd=request.getRequestDispatcher("index.jsp?no=2&ATT=3");
						rd.forward(request,response);
					}
				}
				else //Step 2(Part1-Invalid User) Go To Step 4
				{
					// Step 4
					
					flag1 = userDAO.trackUserIn_W(username,ip);
					flag2 = userDAO.getFS(username,ip);
					flag3 = userDAO.getFT(username);
					flag4 = userDAO.checkValidUser(username);
					if( ((flag1)&&(flag2<k1)) ) 
					{
						System.out.println("Step 4 : if Condition is true.");
						flag = userDAO.trackIncrementFS(username,ip);
						if(flag)
						{
							System.out.println("The Failed Attempt In Table Table_FS Incremented Successfully.....");
							//response.sendRedirect(request.getContextPath()+"/index.jsp?no=2");
							rd=request.getRequestDispatcher("index.jsp?no=2");
							rd.forward(request,response);
							
						}
						else
						{
							System.out.println("Opps,Something Went Wrong While Updating Increment In Table_FS!!!!!");
							rd=request.getRequestDispatcher("index.jsp?no=5");
							rd.forward(request,response);
						}
					}
					else if( ((flag4)&&(flag3<k2) && (!flag1)) )
					{
						// If username is not there in Table_FT Then Insert
						boolean myFlag = userDAO.checkFT(username);
						if(!myFlag)
						{
							userDAO.mapFT(username);
						}
						// Updating The Failed Attempt In Table_FT
						flag = userDAO.trackIncrementFT(username);
						
						if(flag)
						{
							System.out.println("The Failed Attempt In Table Table_FT Incremented Successfully.....");
							//response.sendRedirect(request.getContextPath()+"/index.jsp?no=2");
							rd=request.getRequestDispatcher("index.jsp?no=2");
							rd.forward(request,response);
							
						}
						else
						{
							System.out.println("Opps,Something Went Wrong While Updating Increment In Table_FS!!!!!");
							rd=request.getRequestDispatcher("index.jsp?no=5");
							rd.forward(request,response);
						}
					}
					else
					{
						System.out.println("Step 4 (Else Part) : if Condition is false.");
						System.out.println("Now User Has To Pass The ATT Chalange!!!!!!!!!");
						
						//Sending The Account Info Starts
						CL_SendMail.sendPersonalizedMail(userEmailId,fromEmailId,frompassword,subject,message,attachedFilePath,hostname,portnumber);
						//Sending The Account Info Ends
						
						rd=request.getRequestDispatcher("index.jsp?no=2&ATT=3");
						rd.forward(request,response);
					}
				}
		    }
		    
		   
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Login Servlet : ");
			e.printStackTrace();
			out.println("Error in Login Servlet : "+e);
		}
	}
}