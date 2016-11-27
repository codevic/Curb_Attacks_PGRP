/**
 * 
 */
package com.nitin.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import com.nitin.database.Database;
import com.nitin.utility.Utility;


public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO()
	{
		
	}
	public static UserDAO getInstance()
	{
		if(userDAO == null)
		{
			userDAO= new UserDAO();
		}
		return userDAO;
	}
	
	public boolean loginCheck(String username,String password)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_user='"+username+"' and u_pass='"+password+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->loginCheck(String user,String pass): "+ e);
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
			int i = statement.executeUpdate("update m_user set u_pass='"+npass+"' where u_user='"+id+"' and u_pass='"+opass+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->changePass(): "+ e);
		}
		return flag;
	}
	
	public boolean loginCheck(String user)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_user='"+user+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->loginCheck(String user): "+ e);
		}
		return flag;
	}
	
	public int trackLogin(String user,String ip)
	{
		int count=1000;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select count from m_track where m_user='"+user+"' and m_ip='"+ip+"'");
			while(resultSet.next())
			{
				count=resultSet.getInt(1);
			}
			System.out.println("User Login Track : "+count);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->trackLogin(String user,String pass): "+ e);
		}
		return count;
   }
	
	public boolean trackIT(String user,String ip)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_track (m_user,m_ip,m_track.count,date) values ('"+user+"','"+ip+"','1',NOW())");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Login Track Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->trackIT(String user,String pass): "+ e);
		}
		return flag;
	}
	public boolean trackIncrement(String user,String ip)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_track set m_track.count=m_track.count+1 where m_user='"+user+"' and m_ip='"+ip+"' and m_track.count<'"+Utility.getPro("limit")+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Login Track Increment Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->trackIT(String user,String pass): "+ e);
		}
		return flag;
	}
	public boolean sendMail(String user,String to,String sub,String msg)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into m_msg (m_from,m_to,m_sub,m_msg,m_date) values('"+user+"','"+to+"','"+sub+"','"+msg+"',Now())");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Send Mail Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->sendMail(String user,String pass): "+ e);
		}
		return flag;
	}
	public ResultSet sent(String user)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_msg where m_from='"+user+"' and s_delete='0'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->sent(String user): "+ e);
		}
		return resultSet;
	}
	public ResultSet Inbox(String user)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_msg where m_to='"+user+"' and i_delete='0'");
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->sent(String user): "+ e);
		}
		return resultSet;
	}
	public int inbox(String user)
	{
		int count=0;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_msg where m_to='"+user+"' and m_delete='0'");
			while(resultSet.next())
			{
				count++;
			}
			System.out.println("User Message Count : "+count);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->inbox(String user): "+ e);
		}
		return count;
	}
	
	public boolean deleteI(String id)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_msg set i_delete='1' where m_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Delete Mail Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->deleteI(): "+ e);
		}
		return flag;
	}
	public boolean deleteS(String id)
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i = statement.executeUpdate("update m_msg set s_delete='1' where m_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Delete Mail Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->deleteI(): "+ e);
		}
		return flag;
	}
	
	
	
/* Tracking The User Login In Table(table_w) (Starts) */	
	public boolean trackUserIn_W(String username,String ip)
	{
		boolean flag = false;
		String sql = "";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select * from table_w where username='"+username+"' and ip_address='"+ip+"'";
			System.out.println("*********** Track User Login Info Table_W***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag = true;
			}
			System.out.println("User Login Track[(ip,un)in W ] : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->trackUserIn_W(String username,String ip) : ");
			e.printStackTrace();
		}
		return flag;
   }
/* Tracking The User Login In Table(table_w) (Ends) */	
	
/* Tracking The Failed Attempt In Table(table_fS) (Starts) */	
	public int getFS(String username,String ip)
	{
		int failedAttempt=0;
		String sql = "";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select failed_attempt from table_fs where username='"+username+"' and ip_address='"+ip+"'";
			System.out.println("*********** Getting The Failed Attempt From Table_FS ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				failedAttempt = resultSet.getInt(1);
			}
			System.out.println("Failed Attempt["+username+"] : "+failedAttempt);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getFS(String username,String ip) : ");
			e.printStackTrace();
		}
		return failedAttempt;
   }
/* Tracking The Failed Attempt In Table(table_fS)(Ends) */	
	
/* Tracking The Failed Attempt In Table(table_fS) (Starts) */	
	public boolean checkExistanceInFS(String username,String ip)
	{
		boolean flag = false;
		String sql = "";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select * from table_fs where username='"+username+"' and ip_address='"+ip+"'";
			System.out.println("*********** Checking The Existence In Table Table_FS ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag = true;
			}
			System.out.println("Existance Status  : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkExistanceInFS(String username,String ip) : ");
			e.printStackTrace();
		}
		return flag;
   }
/* Tracking The Failed Attempt In Table(table_fS)(Ends) */			
	
/* Tracking The Failed Attempt In Table(table_ft) (Starts) */	
	public int getFT(String username)
	{
		int failedAttempt=0;
		String sql = "";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select failed_attempt from table_ft where username='"+username+"'";
			System.out.println("*********** Getting The Failed Attempt From Table_Ft ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				failedAttempt = resultSet.getInt(1);
			}
			System.out.println("Failed Attempt["+username+"] : "+failedAttempt);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getFT(String username) : ");
			e.printStackTrace();
		}
		return failedAttempt;
   }
/* Tracking The Failed Attempt In Table(table_ft)(Ends) */
	
	
/* Tracking The Failed Attempt In Table(table_ft) (Starts) */	
	public boolean checkFT(String username)
	{
		boolean flag = false;
		String sql = "";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			sql = "select * from table_ft where username='"+username+"'";
			System.out.println("*********** Getting The Failed Attempt From Table_Ft ***********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag = true;
			}
			System.out.println("User Existence Status In FT : " + flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getFT(String username) : ");
			e.printStackTrace();
		}
		return flag;
   }
/* Tracking The Failed Attempt In Table(table_ft)(Ends) */		

/* Inserting In Table_W(Starts) */
public boolean mapW(String username,String ip)
{
	boolean flag=false;
	String sql = "";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "insert into table_w(ip_address,username) values('"+ip+"','"+username+"')";
		System.out.println("*********** Inserting The Record In Table Table_W  Info ***********");
		System.out.println(sql);
		int i = statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Mapping(i.e Adding) Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->mapW(String username,String ip) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Inserting In Table_W(Ends) */

/* Inserting In Table_W(Starts) */
public boolean mapFS(String username,String ip)
{
	boolean flag=false;
	int failedAttempt = 0;
	String sql = "";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "insert into table_fs(ip_address,username,failed_attempt) values('"+ip+"','"+username+"','"+failedAttempt+"')";
		System.out.println("*********** Inserting The Record In Table Table_FS  Info ***********");
		System.out.println(sql);
		int i = statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Mapping(i.e Adding) Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->mapFS(String username,String ip) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Inserting In Table_W(Ends) */

/* Inserting In Table_FT(Starts) */
public boolean mapFT(String username)
{
	boolean flag=false;
	int failedAttempt = 0;
	String sql = "";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "insert into table_fT(username,failed_attempt) values('"+username+"','"+failedAttempt+"')";
		System.out.println("*********** Inserting The Record In Table Table_FT  Info ***********");
		System.out.println(sql);
		int i = statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Mapping(i.e Adding) Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->mapFT(String username) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Inserting In Table_FT(Ends) */

/* Incrementing Table_FS Failed Attempt Count (Starts) */
public boolean trackIncrementFS(String username,String ip)
{
	boolean flag=false;
	String sql = "";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "update table_fs set failed_attempt=failed_attempt+1 where username='"+username+"' and ip_address='"+ip+"'";
		System.out.println("*********** Track Increment For Table_FS Info **********");
		System.out.println(sql);
		int i = statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("User Login Track Increment Status[Table_FS] : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->trackIncrementFS(String username,String ip) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Incrementing Table_FS Failed Attempt Count (Ends) */

/* Incrementing Table_FT Failed Attempt Count (Starts) */
public boolean trackIncrementFT(String username)
{
	boolean flag=false;
	String sql = "";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "update table_fT set failed_attempt=failed_attempt+1 where username='"+username+"'";
		System.out.println("*********** Track Increment For Table_FT Info **********");
		System.out.println(sql);
		int i = statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("User Login Track Increment Status[Table_FT] : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->trackIncrementFT(String username) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Incrementing Table_FT Failed Attempt Count (Ends) */

public boolean checkValidUser(String username)
{
	boolean flag=false;
	String sql = "";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "select * from m_user where u_user='"+username+"'";
		System.out.println("********** Authenticate For Valid User **********");
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		while(resultSet.next())
		{
			flag=true;
		}
		System.out.println("User Validity Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->checkValidUser(String username) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Making The Table_FS Failed Attempt Count is equal to 0 (Starts) */
public boolean initFStoDefault(String username,String ip)
{
	boolean flag=false;
	String sql = "";
	int deault = 0;
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "update table_fs set failed_attempt='"+deault+"' where username='"+username+"' and ip_address='"+ip+"'";
		System.out.println("*********** Initializing Failed Attempt In Table_FS To 0 Info **********");
		System.out.println(sql);
		int i = statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Initialize To Default Status[Table_FS] : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->initFStoDefault(String username,String ip) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Making The Table_FS Failed Attempt Count is equal to 0 (Starts) */


/* Making The Table_FT Failed Attempt Count is equal to 0 (Starts) */
public boolean initFTtoDefault(String username)
{
	boolean flag=false;
	String sql = "";
	int deault = 0;
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "update table_ft set failed_attempt='"+deault+"' where username='"+username+"'";
		System.out.println("*********** Initializing Failed Attempt In Table_FT To 0 Info **********");
		System.out.println(sql);
		int i = statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Initialize To Default Status[Table_FT] : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->initFTtoDefault(String username) : ");
		e.printStackTrace();
	}
	return flag;
}

/* Making The Table_FT Failed Attempt Count is equal to 0 (Starts) */

/* Getting The User Email ID(Starts) */
public String getUserEmailId(String username)
{
	String emailId = "";
	String sql = "";
	try
	{
		Database database=Database.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		sql = "select u_email from m_user where u_user='"+username+"'";
		System.out.println("*********** Getting The User Email ID **********");
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		while(resultSet.next())
		{
			emailId = resultSet.getString(1);
		}
		System.out.println("EmailId ["+username+"]: "+emailId);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO-->getUserEmailId(String username) : ");
		e.printStackTrace();
	}
	return emailId;
}

/* Getting The User Email ID(Starts) */


}
