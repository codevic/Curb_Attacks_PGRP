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

</head>
	
<body onload="startTimer()">
<div class="logout" style="position: relative;top: 10px;letter-spacing: 3px">
	You have loged in as <i><u><%=request.getAttribute("admin") %></u></i> <a href="<%=request.getContextPath() %>">[Logout]</a>
</div>
<div class="logo">
	<img src="<%=request.getContextPath() %>/res/Images/header.jpg"></img>
</div>
<div style="border:2px solid #666; width:150px;">
	<ul class="menu">
        <li><a href="javascript:toggle('compose')">&nbsp;&nbsp;User List</a></li>
        <ul id="compose" class="links">
        	<li><a href="<%=request.getContextPath() %>/res/JSP/Admin/users.jsp" target="right">Users List</a></li>
            <li><a href="<%=request.getContextPath() %>/res/JSP/Admin/create.jsp" target="right">Create New</a></li>
            <li><a href="<%=request.getContextPath() %>/res/JSP/Admin/delete.jsp" target="right">Delete User</a></li>
            <li><a href="<%=request.getContextPath() %>/res/JSP/Admin/edit.jsp" target="right">Edit User</a></li>
        </ul>
	    <li><a href="javascript:toggle('inbox')">&nbsp;&nbsp;Transactions</a></li>
        <ul id="inbox" class="links" style="display:none;">
            <li><a href="<%=request.getContextPath() %>/res/JSP/Admin/inbox.jsp" target="right">Received Mails</a></li>
            <li><a href="<%=request.getContextPath() %>/res/JSP/Admin/sent.jsp" target="right">Sent Mails</a></li>
        </ul>
		<li><a href="javascript:toggle('vbnet')">&nbsp;&nbsp;Settings</a></li>
        	<ul id="vbnet" class="links" style="display:none;">
                <li><a href="<%=request.getContextPath() %>/res/JSP/Admin/change.jsp?user=<%=request.getAttribute("admin") %>" target="right">Change Password</a></li>
                <li><a href="<%=request.getContextPath() %>">Log-Out</a></li>
            </ul>
		</ul>            
</div>
<div class="right" style="padding-top: 50px">
	<iframe src="" name="right" height="500" width="780" frameborder="0"></iframe>
</div>
</body>
</html>
