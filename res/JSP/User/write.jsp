<%@ page import="com.nitin.utility.*" %>
<html>
<head>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
	<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
	
</head>
<body onload="startTimer()">
	<form method="post" id="frm" action="<%=request.getContextPath() %>/SendMail">
	<input type="hidden" value="<%=request.getParameter("user") %>" name="user">
	<table>
	<tr>
		<td>To</td>
		<td><input required="yes" class="to" type="text" name="to" placeholder="Name Of The Receiver...." style="width:250px;"></input></td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>Subject</td>
		<td><input required="yes" class="sub" type="text" name="sub" placeholder="Write The Subject...." style="width:450px;"></input></td>
	</tr>
	</table>
	<table>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>Message</td>
	</tr>
	<tr>
		<td><textarea required="yes" name="msg" class="msg" cols="80" rows="10" placeholder="Write Your Message Here...."></textarea></td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr><td><input type="submit" value="Send Mail" name=""></input></td></tr>
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
</body>
</html>