<%@ page import="com.nitin.utility.*" %>
<html>
<head>
	<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
</head>
<%
	String user=request.getParameter("user");
%>
<body onload="startTimer()" id="login" style="border: thick;padding-left: 300px;">
	<form method="post" action="<%=request.getContextPath() %>/ChangePass">
	<input type="hidden" name="user" value="<%=user %>">
	<table title="Create New User">
		<tr>
			<td>Current Password:</td>
			<td><input class="field" type="password" name="opass" required="yes"></input></td>
		</tr>
		<tr>
			<td>New Password:</td>
			<td><input class="field" type="password" name="npass" required="yes"></input></td>
		</tr>
		<tr>
			<td>Old Password:</td>
			<td><input class="field" type="password" name="cpass" required="yes"></input></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" class="submit" value="Change Password"></input></td>
		</tr>
	</table>
	<div id="process_msg"></div>
	</form>
	<%
int no=Utility.parse(request.getParameter("no"));
if(no==1)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Current Password is wrong....! </div>";
	</script>
<%}
if(no==2)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:green;text-align:center;border:1px solid green;'>Password Changed Successfully....! </div>";
	</script>
<%}
if(no==3)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Opp's Somthing Went Wrong....! </div>";
	</script>
<%}
if(no==4)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>New Password & Confirm Password is not Match....! </div>";
	</script>
<%}
%>	
</body>
</html>