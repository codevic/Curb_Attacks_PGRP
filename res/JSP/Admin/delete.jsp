<%@ page import="com.nitin.utility.*" %>
<%@ page import="com.nitin.dao.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
	<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
	<%
		ResultSet rs=AdminDAO.getInstance().users();
	%>
</head>
<body onload="startTimer()">
	<h3>Select a User to Delete</h3>
	<hr>
	<form method="post" id="frm" action="<%=request.getContextPath() %>/DeleteUser">
	<input type="hidden" value="<%=request.getParameter("user") %>" name="user">
	<div id="process_msg"></div>
	<table id="my" title="List Of The Users" width="600">
	<tr>
		<th>No</th>
		<th>Name</th>
		<th>UserID</th>
		<th>City</th>
		<th>State</th>
		<th>Email</th>
	</tr>
	<tr><td><hr></td><td><hr></td><td><hr></td><td><hr></td><td><hr></td><td><hr></td></tr>
	<%
		int count=1;
		if(rs!=null)
		while(rs.next())
		{%>
			<tr>
			<td><%=count++ %><input type="checkbox" name="select" value="<%=rs.getInt(1) %>"></input></td>	
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(6) %></td>
			<td><%=rs.getString(7) %></td>
			</tr>
		<%}
	%>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input type="submit" value="Delete"></input></td></tr>
	</table>
	</form>
<%
int no=Utility.parse(request.getParameter("no"));
if(no==1)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Opp's Select Atleast One User To Delete....! </div>";
	</script>
<%}
if(no==2)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:green;text-align:center;border:1px solid green;'>User Deleted Successfully....! </div>";
	</script>
<%}
if(no==3)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Opp's Somthing Went Wrong....! </div>";
	</script>
<%}
%>	
<hr>
</body>
</html>