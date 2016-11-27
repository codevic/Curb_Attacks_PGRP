<%@ page import="java.util.*"%>
<%@ page import="com.nitin.utility.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/style.css" rel="stylesheet" type="text/css" />
<title>.:: ATT ::.</title>

<script>
    history.forward();
</script>

<script type = "text/javascript" >
function changeHashOnLoad() 
{
 window.location.href += "#";
 setTimeout("changeHashAgain()", "50"); 
}

function changeHashAgain() 
{
 window.location.href += "1";
}

var storedHash = window.location.hash;
window.setInterval(function () 
{
	if (window.location.hash != storedHash)
    {
     	window.location.hash = storedHash;
	}
}, 50);


function check()
{
	if(document.f1.code.value.length!=5)
	{
		alert("Only 5 Characters Of Captcha is Allowed!");
		return false;
	}
}

 </script>
</head>
	
<body onload="startTimer();changeHashOnLoad();">
<div class="logo">
	<img src="<%=request.getContextPath() %>/res/Images/header.jpg"></img>
</div>
	<div class="login">
	
	   <a href="javascript:toggle('admin_login')">&nbsp;&nbsp;Admin Login</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <a href="javascript:toggle('user_login')">&nbsp;&nbsp;User Login</a>
    </div>   
        <div id="admin_login" class="links" style="display: none;">
           <form id="login" method="post" name="frm" action="<%=request.getContextPath() %>/AdminLogin">
           Admin Login
			<table>
			<tr>
			<td>Username:</td>
			<td><input  class="field" type="text" name="username" required="yes"/></td>
			</tr>
			<tr>
			<td>Password:</td>
			<td><input class="field" type="password" name="password" required="yes" /></td>
			</tr>
			<tr><td></td><td><input class="submit" type="submit" value="Submit" name="submit" /></td>
			</tr>
			</table>
			</form>
		<div id="admin_msg"></div>	
        </div>
        
        
        <div id="user_login" class="links" style="display: none;">
           <form name="f1" id="login" method="post" name="frm" action="<%=request.getContextPath() %>/Login">
           User Login
			<table>
			
			<tr>
				<td>Username:</td>
				<td><input placeholder="UserID" class="field" type="text" name="username" required="yes" /></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input placeholder="Password" class="field" type="password" name="password" required="yes" /></td>
			</tr>
			
			<%
				if(Utility.parse(request.getParameter("ATT"))==3)
				{
					Vector v=Utility.GetATT();
					Vector code=new Vector();
		    %>		
		           <tr>
		           <td colspan="3" align="center">
		     <%       	
					for(int i=0;i<5;i++)
					{
			 %>
						   
						    		
						<img height="50" width="50" src="<%=request.getContextPath() %>/res/Images/ATT/<%=v.get(i) %>">
						 	
			<%  		code.add(v.get(i));
					}	
		     		session.setAttribute("code",code);
			%>
			         </td>
			         </tr>
			         
					<tr>
							<td colspan="3" align="center"><input placeholder="Enter Above Code" type="text" name="code"/></td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input class="submit" type="submit" value="Submit" onclick="return check();" class="submit" />
							<input type="hidden" name="submit" value="ATT">
						</td>
					</tr>
					
			<%
				}
				else
				{
			%>
					<tr>
						<td>Trusted User :</td>
						<td><input  class="field" type="checkbox" name="chk" value="YES"/></td>
					</tr>
			
					<tr>
						<td colspan="2" align="center">
							<input class="submit" type="submit" value="Submit" class="submit" />
							<input type="hidden" name="submit" value="ATT_NOT_REQUIRED">
						</td>
					</tr>
			<%
				}
			%>
			
			
			</table>
			</form>
		<div id="user_msg"></div>	
        </div>
	
</body>
<%
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{%>
			<script type="text/javascript">
			javascript:toggle('admin_login')
			document.getElementById("admin_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Invalid userid or password....! </div>";
			</script>
		<%}
		else if(no==2)
		{%>
			<script type="text/javascript">
			javascript:toggle('user_login')
			document.getElementById("user_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Invalid userid or password....! </div>";
			</script>
		<%}
		else if(no==4)
		{%>
			<script type="text/javascript">
			javascript:toggle('user_login')
			document.getElementById("user_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Invalid ATT Code....! </div>";
			</script>
		<%}
		else if(no==5)
		{%>
			<script type="text/javascript">
			javascript:toggle('user_login')
			document.getElementById("user_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Opps,Something Went Wrong,Try Again!!!!!</div>";
			</script>
		<%}
		else if(no==0)
		{%>
			<script type="text/javascript">
			javascript:toggle('user_login')
			</script>
		<%}
	%>
</html>