<%@ page import="com.nitin.utility.*" %>
<%@ page import="com.nitin.dao.*" %>
<%@ page import="java.sql.*" %>
<html>
<head>
	<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
</head>
<%
	String id=request.getParameter("select");
	if(id==null)
		response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/edit.jsp?no=1");
	ResultSet rs=AdminDAO.getInstance().users(id);
	if(rs!=null)
	while(rs.next())
	{
%>
<body id="login" style="border: thick;padding-left: 300px;">
	<form method="post" action="<%=request.getContextPath() %>/UpdateUser">
	<input type="hidden" name="id" value="<%=id %>"></input>
	<table title="Create New User">
		<tr>
			<td>User Name:</td>
			<td><input class="field" type="text" name="uname" required="yes" value="<%=rs.getString(4) %>"></input></td>
		</tr>
		<tr>
			<td>UserID:</td>
			<td><input class="field" type="text" name="uid" required="yes" value="<%=rs.getString(2) %>" readonly></input></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input class="field" type="password" name="upass" required="yes" value="<%=rs.getString(3) %>"></input></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input class="field" type="text" name="city" required="yes" value="<%=rs.getString(5) %>"></input></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input class="field" type="text" name="state" required="yes" value="<%=rs.getString(6) %>"></input></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input class="field" type="email" name="email" required="yes" value="<%=rs.getString(7) %>"></input></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" class="submit" value="Update User"></input></td>
		</tr>
	<div id="process_msg"></div>	
	</table>
	</form>
<%}
	int no=Utility.parse(request.getParameter("no"));
	if(no==3)
	{%>
		<script type="text/javascript">
		document.getElementById("process_msg").innerHTML="<div style='color:red;text-align:center;border:1px solid red;'>Opp's Somthing Went Wrong....! </div>";
		</script>
	<%}
%>		
</body>
</html>