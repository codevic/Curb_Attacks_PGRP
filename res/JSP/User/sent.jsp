<%@ page import="com.nitin.utility.*" %>
<%@ page import="com.nitin.dao.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
	<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
	<%
		ResultSet rs=UserDAO.getInstance().sent(request.getParameter("user"));
	%>
</head>
<body onload="startTimer()">
	<h3>Sent Items</h3>
	<hr>
	<form method="post" id="frm" action="<%=request.getContextPath() %>/SendMail">
	<input type="hidden" value="<%=request.getParameter("user") %>" name="user">
	<table id="my" title="Sent Items" width="600">
	<tr>
		<th>No</th>
		<th>Subject</th>
		<th>Message</th>
		<th>To</th>
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
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getDate(6) %> & <%=rs.getTime(6) %></td>
		</tr>
		<%}
	%>
	</table>
	<div id="process_msg"></div>
	</form>
<%
int no=Utility.parse(request.getParameter("no"));
if(no==1)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Invalid Receiver ID....! </div>";
	</script>
<%}
if(no==2)
{%>
	<script type="text/javascript">
	document.getElementById("process_msg").innerHTML="<div style='color:green;text-align:center;border:1px solid green;'>Message Sent Successfully....! </div>";
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