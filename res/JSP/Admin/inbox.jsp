<%@ page import="com.nitin.utility.*" %>
<%@ page import="com.nitin.dao.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
	<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
	<%
		ResultSet rs=AdminDAO.getInstance().sent();
	%>
</head>
<body onload="startTimer()">
	<h3>All Incoming Messages </h3>
	<hr>
	<form method="post" id="frm" action="<%=request.getContextPath() %>/SendMail">
	<input type="hidden" value="<%=request.getParameter("user") %>" name="user">
	<table id="my" title="Inbox Items" width="600">
	<tr>
		<th>No</th>
		<th>Subject</th>
		<th>Message</th>
		<th>From</th>
		<th>Date & Time</th>
	</tr>
	<tr><td><hr></td><td><hr></td><td><hr></td><td><hr></td><td><hr></td></tr>
	<%
		int count=1;
		if(rs!=null)
		while(rs.next())
		{%>
		<tr>	
			<td><%=count++ %></td>	
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getDate(6) %> & <%=rs.getTime(6) %></td>
		</tr>
		<%}
	%>
	</table>
	
	</form>
<hr>
</body>
</html>