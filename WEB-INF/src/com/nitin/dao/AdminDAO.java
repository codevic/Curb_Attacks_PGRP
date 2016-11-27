/**
 * 
 */
package com.nitin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.nitin.database.*;




public class AdminDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO()
	{
		
	}
	public static AdminDAO getInstance()
	{
		if(adminDAO == null)
		{
			adminDAO= new AdminDAO();
		}
		return adminDAO;
	}
	
	public boolean loginCheck(String admin,String pass)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where m_admin='"+admin+"' and m_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->loginCheck(String admin,String pass): "+ e);
		}
		return flag;
	}
	
	public boolean loginCheck(String admin)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_user='"+admin+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User ID Check Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->loginCheck(String admin): "+ e);
		}
		return flag;
	}
	
	public ResultSet users()
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->users(): "+ e);
		}
		return resultSet;
	}
	
	public ResultSet users(String id)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->users(): "+ e);
		}
		return resultSet;
	}
	public ResultSet sent()
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_msg");
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->sent(): "+ e);
		}
		return resultSet;
	}
	public boolean createUser(String uname,String uid,String upass,String city,String state,String email)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_user (u_user,u_pass,u_name,u_city,u_state,u_email) values('"+uid+"','"+upass+"','"+uname+"','"+city+"','"+state+"','"+email+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->createUser(): "+ e);
		}
		return flag;
	}
	
	public boolean updateUser(String id,String uname,String uid,String upass,String city,String state,String email)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_user set u_user='"+uid+"',u_pass='"+upass+"',u_name='"+uname+"',u_city='"+city+"',u_state='"+state+"',u_email='"+email+"' where u_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->updateUser(): "+ e);
		}
		return flag;
	}
	
	public boolean changePass(String id,String opass,String npass)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_admin set m_pass='"+npass+"' where m_admin='"+id+"' and m_pass='"+opass+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->changePass(): "+ e);
		}
		return flag;
	}
	public boolean deleteUser(String id)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("delete from m_user where u_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO-->deleteUser(): "+ e);
		}
		return flag;
	}
}
