package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nitin.utility.*;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.6.4.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/login.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\" id=\"login\" style=\"border: thick;padding-left: 300px;\">\r\n");
      out.write("\t<form method=\"post\" action=\"");
      out.print(request.getContextPath() );
      out.write("/CreateUser\">\r\n");
      out.write("\t<table title=\"Create New User\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>User Name:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"uname\" required=\"yes\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>UserID:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"uid\" required=\"yes\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Password:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"password\" name=\"upass\" required=\"yes\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>City:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"city\" required=\"yes\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>State:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"state\" required=\"yes\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Email:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"email\" name=\"email\" required=\"yes\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t<td><input type=\"submit\" class=\"submit\" value=\"Create User\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t<div id=\"process_msg\"></div>\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");

int no=Utility.parse(request.getParameter("no"));
if(no==1)
{
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tdocument.getElementById(\"process_msg\").innerHTML=\"<div style='color:red;text-align:center;border:1px solid red;'>This UserID Already Exist....! </div>\";\r\n");
      out.write("\t</script>\r\n");
}
if(no==2)
{
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tdocument.getElementById(\"process_msg\").innerHTML=\"<div style='color:green;text-align:center;border:1px solid green;'>User Created Successfully....! </div>\";\r\n");
      out.write("\t</script>\r\n");
}
if(no==3)
{
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tdocument.getElementById(\"process_msg\").innerHTML=\"<div style='color:red;text-align:center;border:1px solid red;'>Opp's Somthing Went Wrong....! </div>\";\r\n");
      out.write("\t</script>\r\n");
}

      out.write("\t\t\r\n");
      out.write("</body>\r\n");
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
