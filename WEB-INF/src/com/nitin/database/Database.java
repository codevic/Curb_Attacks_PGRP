/**
 * 
 */
package com.nitin.database;

import java.sql.Connection;

import java.sql.DriverManager;

import com.nitin.utility.*;


/**
 * @author Nitin Gudle
 *Apr 7, 2012 4:11:29 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.nitin.database
 *File:-Database.java
 */
public class Database 
{
	private static Database database = null;
	private Database(){}
	public static Database getInstance()
	{
		if(database==null)
			return new Database();
		else
			return null;
	}
	public Connection connector()
	{
		Connection con=null;
		try {
			Class.forName(Utility.getPro("Driver"));  // Type 4
			System.out.println("Driver has loaded");
			con = DriverManager.getConnection(Utility.getPro("URL"),Utility.getPro("User"), Utility.getPro("Pass"));
			System.out.println("Connected" + con);

		} catch (Exception e) {
			System.out.println("Opp's Error is in connector()......."+ e);
		}
		return con;
	}
}
