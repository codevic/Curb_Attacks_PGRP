/**
 * 
 */
package com.nitin.utility;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Utility
{
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Integer.parseInt(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	
	public static String parseString(String str) 
	{ 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		return str; 
	}
	public static String parse1(Object str) 
	{ 
		String p=""; 
		if(str==null) 
		{ 
			str=""; 
		} 
		else if(str.equals("")) 
		{ 
			str=""; 
		} 
		try
		{ 
			p=(String)str; 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse1(String str) "+e);
		} 
		return p; 
	}
	public static Object parse2(Object str) 
	{ 
		Object obj=null;
		if(str!=null) 
			return str;
		else
			return obj; 
	}
	public static String getPro(String str) 
	{
		String pro="";
		try
		{
			java.security.ProtectionDomain pd =	Utility.class.getProtectionDomain();
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\Config.properties");
			property.load(in);
			pro=property.getProperty(str);
			System.out.println("Property to return : "+pro);
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}
	public static String getDate()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
			date = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDate( ): "+ e);
		}
		return date;
	}
	public static String getTime()
	{
		String time="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			time = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getTime( ): "+ e);
		}
		return time;
	}
	public static String getDay()
	{
		String day="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			int no=currentDate.get(Calendar.DAY_OF_WEEK);
			if(no==1)
				day="Sunday";
			else if(no==2)
				day="Monday";
			else if(no==3)
				day="TUESDAY";
			else if(no==4)
				day="WEDNESDAY";
			else if(no==5)
				day="THURSDAY";
			else if(no==6)
				day="FRIDAY";
			else if(no==7)
				day="SATURDAY";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	
	public static void getMAC()
	{
		try {
		      String a = "ipconfig/all > C://WINDOWS//b.txt";
		      byte[] buf = a.getBytes();
		      OutputStream outs = new FileOutputStream(new File("C://WINDOWS//run.bat"));
		      for (int i = 0; i < buf.length; i++)
		      {
		        outs.write(buf[i]);
		      }
		      outs.close();
//		      System.out.println("Batch File Created");
		      Runtime.getRuntime().exec("C://WINDOWS//run.bat");
//		      System.out.println("Batch File Executed Sucessfully\n");
		      

//		      System.out.println("\nReading b.txt File Content....");
		      String macAddress = null;
		      FileInputStream bstream = new FileInputStream("C://WINDOWS//b.txt");
		      DataInputStream bn = new DataInputStream(bstream);
		      BufferedReader br = new BufferedReader(new InputStreamReader(bn));
		      while (true) {
		        String line = br.readLine();
		        if (line == null)
		          break;
		        Pattern p = Pattern.compile(".*Physical Address.*: (.*)");
		        Matcher m = p.matcher(line);
		        if (m.matches()) {
		          macAddress = m.group(1);
		        }
		      }
		      bn.close();
		      br.close();
		      System.out.println("MAC---->" + macAddress);

		      
		    }
		    catch (Exception e)
		    {
		      System.out.println(e);
		    }
	}
	public static Vector GetATT()
	{
		Vector v=new Vector();
		try
		{					
					v.add("a.jpg");
					v.add("b.jpg");
					v.add("c.jpg");
					v.add("d.jpg");
					v.add("e.jpg");
					v.add("f.jpg");
					v.add("g.jpg");
					v.add("h.jpg");
					v.add("i.jpg");
					v.add("j.jpg");
					v.add("k.jpg");
					v.add("l.jpg");
					v.add("m.jpg");
					v.add("n.jpg");
					v.add("o.jpg");
					v.add("p.jpg");
					v.add("q.jpg");
					v.add("r.jpg");
					v.add("s.jpg");
					v.add("t.jpg");
					v.add("u.jpg");
					v.add("v.jpg");
					v.add("w.jpg");
					v.add("x.jpg");
					v.add("y.jpg");
					v.add("z.jpg");
					v.add("1.jpg");
					v.add("2.jpg");
					v.add("3.jpg");
					v.add("4.jpg");
					v.add("5.jpg");
					v.add("6.jpg");
					v.add("7.jpg");
					v.add("8.jpg");
					v.add("9.jpg");
					v.add("0.jpg");
					Collections.shuffle(v);Collections.shuffle(v);Collections.shuffle(v);Collections.shuffle(v);
					Collections.shuffle(v);Collections.shuffle(v);Collections.shuffle(v);Collections.shuffle(v);
					Collections.shuffle(v);Collections.shuffle(v);Collections.shuffle(v);Collections.shuffle(v);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return v;
	}
	
	
/* Getting The IP Address (Starts) */	
	
	public static String getIpAddress()
	{
		String ipAddress = "";
		InetAddress ip;
		  try 
		  {
	 
			ip = InetAddress.getLocalHost();
			ipAddress = ip.getHostAddress();
			System.out.println("Current IP address : " + ip.getHostAddress());
	 
		  }
		  catch (UnknownHostException e)
		  {
	        System.out.println("Opps,Exception In Utility==>getIpAddress() : ");
			e.printStackTrace();
		  }
	   return ipAddress;	  
	}
	
/* Getting The IP Address (Ends) */		
	
	public static void main(String asdf[])
	{
		
	}
}
