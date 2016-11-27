package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.nitin.utility.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.6.4.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/login.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<title>.:: ATT ::.</title>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    history.forward();\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type = \"text/javascript\" >\r\n");
      out.write("function changeHashOnLoad() \r\n");
      out.write("{\r\n");
      out.write(" window.location.href += \"#\";\r\n");
      out.write(" setTimeout(\"changeHashAgain()\", \"50\"); \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function changeHashAgain() \r\n");
      out.write("{\r\n");
      out.write(" window.location.href += \"1\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var storedHash = window.location.hash;\r\n");
      out.write("window.setInterval(function () \r\n");
      out.write("{\r\n");
      out.write("\tif (window.location.hash != storedHash)\r\n");
      out.write("    {\r\n");
      out.write("     \twindow.location.hash = storedHash;\r\n");
      out.write("\t}\r\n");
      out.write("}, 50);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function check()\r\n");
      out.write("{\r\n");
      out.write("\tif(document.f1.code.value.length!=5)\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"Only 5 Characters Of Captcha is Allowed!\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" </script>\r\n");
      out.write("</head>\r\n");
      out.write("\t\r\n");
      out.write("<body onload=\"startTimer();changeHashOnLoad();\">\r\n");
      out.write("<div class=\"logo\">\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/Images/header.jpg\"></img>\r\n");
      out.write("</div>\r\n");
      out.write("\t<div class=\"login\">\r\n");
      out.write("\t\r\n");
      out.write("\t   <a href=\"javascript:toggle('admin_login')\">&nbsp;&nbsp;Admin Login</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("       <a href=\"javascript:toggle('user_login')\">&nbsp;&nbsp;User Login</a>\r\n");
      out.write("    </div>   \r\n");
      out.write("        <div id=\"admin_login\" class=\"links\" style=\"display: none;\">\r\n");
      out.write("           <form id=\"login\" method=\"post\" name=\"frm\" action=\"");
      out.print(request.getContextPath() );
      out.write("/AdminLogin\">\r\n");
      out.write("           Admin Login\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td>Username:</td>\r\n");
      out.write("\t\t\t<td><input  class=\"field\" type=\"text\" name=\"username\" required=\"yes\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td>Password:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"password\" name=\"password\" required=\"yes\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr><td></td><td><input class=\"submit\" type=\"submit\" value=\"Submit\" name=\"submit\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t<div id=\"admin_msg\"></div>\t\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <div id=\"user_login\" class=\"links\" style=\"display: none;\">\r\n");
      out.write("           <form name=\"f1\" id=\"login\" method=\"post\" name=\"frm\" action=\"");
      out.print(request.getContextPath() );
      out.write("/Login\">\r\n");
      out.write("           User Login\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Username:</td>\r\n");
      out.write("\t\t\t\t<td><input placeholder=\"UserID\" class=\"field\" type=\"text\" name=\"username\" required=\"yes\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Password:</td>\r\n");
      out.write("\t\t\t\t<td><input placeholder=\"Password\" class=\"field\" type=\"password\" name=\"password\" required=\"yes\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				if(Utility.parse(request.getParameter("ATT"))==3)
				{
					Vector v=Utility.GetATT();
					Vector code=new Vector();
		    
      out.write("\t\t\r\n");
      out.write("\t\t           <tr>\r\n");
      out.write("\t\t           <td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t     ");
       	
					for(int i=0;i<5;i++)
					{
			 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t    \t\t\r\n");
      out.write("\t\t\t\t\t\t<img height=\"50\" width=\"50\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/Images/ATT/");
      out.print(v.get(i) );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t \t\r\n");
      out.write("\t\t\t");
  		code.add(v.get(i));
					}	
		     		session.setAttribute("code",code);
			
      out.write("\r\n");
      out.write("\t\t\t         </td>\r\n");
      out.write("\t\t\t         </tr>\r\n");
      out.write("\t\t\t         \r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"3\" align=\"center\"><input placeholder=\"Enter Above Code\" type=\"text\" name=\"code\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"submit\" type=\"submit\" value=\"Submit\" onclick=\"return check();\" class=\"submit\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"submit\" value=\"ATT\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t");

				}
				else
				{
			
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Trusted User :</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input  class=\"field\" type=\"checkbox\" name=\"chk\" value=\"YES\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"submit\" type=\"submit\" value=\"Submit\" class=\"submit\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"submit\" value=\"ATT_NOT_REQUIRED\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t<div id=\"user_msg\"></div>\t\r\n");
      out.write("        </div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");

		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
      out.write("\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tjavascript:toggle('admin_login')\r\n");
      out.write("\t\t\tdocument.getElementById(\"admin_msg\").innerHTML=\"<div style='color:red;text-align:center;border:1px solid red;'>Invalid userid or password....! </div>\";\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t");
}
		else if(no==2)
		{
      out.write("\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tjavascript:toggle('user_login')\r\n");
      out.write("\t\t\tdocument.getElementById(\"user_msg\").innerHTML=\"<div style='color:red;text-align:center;border:1px solid red;'>Invalid userid or password....! </div>\";\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t");
}
		else if(no==4)
		{
      out.write("\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tjavascript:toggle('user_login')\r\n");
      out.write("\t\t\tdocument.getElementById(\"user_msg\").innerHTML=\"<div style='color:red;text-align:center;border:1px solid red;'>Invalid ATT Code....! </div>\";\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t");
}
		else if(no==5)
		{
      out.write("\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tjavascript:toggle('user_login')\r\n");
      out.write("\t\t\tdocument.getElementById(\"user_msg\").innerHTML=\"<div style='color:red;text-align:center;border:1px solid red;'>Opps,Something Went Wrong,Try Again!!!!!</div>\";\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t");
}
		else if(no==0)
		{
      out.write("\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tjavascript:toggle('user_login')\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
