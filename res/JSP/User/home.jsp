<%@ page import="com.nitin.dao.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/login.js"></script>
<link href="<%=request.getContextPath() %>/res/CSS/login.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/style.css" rel="stylesheet" type="text/css" />
<title>.:: ATT ::.</title>
</head>
	
<body onload="startTimer()">
<div class="logo1">
	<img src="<%=request.getContextPath() %>/res/Images/header.jpg"></img>
</div>
<div class="logout">
	You have loged in as <i><u><%=request.getAttribute("user") %></u></i> <a href="<%=request.getContextPath() %>">[Logout]</a>
	&nbsp;&nbsp;&nbsp;Inbox Messages[<%=UserDAO.getInstance().inbox(request.getAttribute("user").toString()) %>]
</div>
<div style="border:2px solid #666; width:150px;">
	<ul class="menu">
        <li><a href="javascript:toggle('compose')">&nbsp;&nbsp;Compose Mail</a></li>
        <ul id="compose" class="links">
            <li><a href="<%=request.getContextPath() %>/res/JSP/User/write.jsp?user=<%=request.getAttribute("user") %>" target="right">Write Mail</a></li>
        </ul>
	    <li><a href="javascript:toggle('inbox')">&nbsp;&nbsp;Mail Inbox</a></li>
        <ul id="inbox" class="links" style="display:none;">
            <li><a href="<%=request.getContextPath() %>/res/JSP/User/inbox.jsp?user=<%=request.getAttribute("user") %>" target="right">Received Mails</a></li>
            <li><a href="<%=request.getContextPath() %>/res/JSP/User/deletei.jsp?user=<%=request.getAttribute("user") %>" target="right">Delete Inbox Items</a></li>
        </ul>
        <li><a href="javascript:toggle('sent')">&nbsp;&nbsp;Sent Messages</a></li>
        <ul id="sent" class="links" style="display:none;">
            <li><a href="<%=request.getContextPath() %>/res/JSP/User/sent.jsp?user=<%=request.getAttribute("user") %>" target="right">Sent Mails</a></li>
            <li><a href="<%=request.getContextPath() %>/res/JSP/User/deletes.jsp?user=<%=request.getAttribute("user") %>" target="right">Delete Sent Items</a></li>
        </ul>
		<li><a href="javascript:toggle('vbnet')">&nbsp;&nbsp;Settings</a></li>
        	<ul id="vbnet" class="links" style="display:none;">
                <li><a href="<%=request.getContextPath() %>/res/JSP/User/change.jsp?user=<%=request.getAttribute("user") %>" target="right">Change Password</a></li>
                <li><a href="<%=request.getContextPath() %>">Log-Out</a></li>
            </ul>
		</ul>            
</div>
<div class="right">
	<iframe src="<%=request.getContextPath() %>/res/JSP/User/inbox.jsp?user=<%=request.getAttribute("user") %>" name="right" height="550" width="780" frameborder="0"></iframe>
</div>
</body>
</html>
