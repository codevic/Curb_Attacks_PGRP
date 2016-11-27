<%@ page import="com.nitin.utility.*" %>
<html>
<head>
	<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
</head>
<body onload="startTimer()" id="login" style="border: thick;padding-left: 300px;">
	<form method="post" action="<%=request.getContextPath() %>/CreateUser">
	<table title="Create New User">
		<tr>
			<td>User Name:</td>
			<td><input class="field" type="text" name="uname" required="yes"></input></td>
		</tr>
		<tr>
			<td>UserID:</td>
			<td><input class="field" type="text" name="uid" required="yes"></input></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input class="field" type="password" name="upass" required="yes"></input></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input class="field" type="text" name="city" required="yes"></input></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input class="field" type="text" name="state" required="yes"></input></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input class="field" type="email" name="email" required="yes"></input></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" class="submit" value="Create User"></input></td>
		</tr>
	<div id="process_msg"></div>	
	</table>
	</form>
<%
int no=Utility.parse(request.getParameter("no"));
if(no==1)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>This UserID Already Exist....! </div>";
	</script>
<%}
if(no==2)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:green;text-align:center;border:1px solid green;'>User Created Successfully....! </div>";
	</script>
<%}
if(no==3)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Opp's Somthing Went Wrong....! </div>";
	</script>
<%}
%>		
</body>
</html>