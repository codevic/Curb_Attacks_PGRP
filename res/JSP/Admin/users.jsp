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
	<h3>List Of User</h3>
	<hr>
	<form id="frm">
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
			<td><%=count++ %></td>	
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(6) %></td>
			<td><%=rs.getString(7) %></td>
			</tr>
		<%}
	%>
	</table>
	</form>
<hr>
</body>
</html>