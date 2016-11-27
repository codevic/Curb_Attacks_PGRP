package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nitin.utility.*;
import com.nitin.dao.*;
import java.sql.*;

public final class edit1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");

	String id=request.getParameter("select");
	if(id==null)
		response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/edit.jsp?no=1");
	ResultSet rs=AdminDAO.getInstance().users(id);
	if(rs!=null)
	while(rs.next())
	{

      out.write("\r\n");
      out.write("<body id=\"login\" style=\"border: thick;padding-left: 300px;\">\r\n");
      out.write("\t<form method=\"post\" action=\"");
      out.print(request.getContextPath() );
      out.write("/UpdateUser\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("\t<table title=\"Create New User\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>User Name:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"uname\" required=\"yes\" value=\"");
      out.print(rs.getString(4) );
      out.write("\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>UserID:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"uid\" required=\"yes\" value=\"");
      out.print(rs.getString(2) );
      out.write("\" readonly></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Password:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"password\" name=\"upass\" required=\"yes\" value=\"");
      out.print(rs.getString(3) );
      out.write("\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>City:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"city\" required=\"yes\" value=\"");
      out.print(rs.getString(5) );
      out.write("\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>State:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"text\" name=\"state\" required=\"yes\" value=\"");
      out.print(rs.getString(6) );
      out.write("\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>Email:</td>\r\n");
      out.write("\t\t\t<td><input class=\"field\" type=\"email\" name=\"email\" required=\"yes\" value=\"");
      out.print(rs.getString(7) );
      out.write("\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr><td>&nbsp;</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t<td><input type=\"submit\" class=\"submit\" value=\"Update User\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t<div id=\"process_msg\"></div>\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
}
	int no=Utility.parse(request.getParameter("no"));
	if(no==3)
	{
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tdocument.getElementById(\"process_msg\").innerHTML=\"<div style='color:red;text-align:center;border:1px solid red;'>Opp's Somthing Went Wrong....! </div>\";\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t");
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
