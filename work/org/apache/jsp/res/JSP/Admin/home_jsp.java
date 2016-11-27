package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("</head>\r\n");
      out.write("\t\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<div class=\"logout\" style=\"position: relative;top: 10px;letter-spacing: 3px\">\r\n");
      out.write("\tYou have loged in as <i><u>");
      out.print(request.getAttribute("admin") );
      out.write("</u></i> <a href=\"");
      out.print(request.getContextPath() );
      out.write("\">[Logout]</a>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"logo\">\r\n");
      out.write("\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/Images/header.jpg\"></img>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"border:2px solid #666; width:150px;\">\r\n");
      out.write("\t<ul class=\"menu\">\r\n");
      out.write("        <li><a href=\"javascript:toggle('compose')\">&nbsp;&nbsp;User List</a></li>\r\n");
      out.write("        <ul id=\"compose\" class=\"links\">\r\n");
      out.write("        \t<li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/JSP/Admin/users.jsp\" target=\"right\">Users List</a></li>\r\n");
      out.write("            <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/JSP/Admin/create.jsp\" target=\"right\">Create New</a></li>\r\n");
      out.write("            <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/JSP/Admin/delete.jsp\" target=\"right\">Delete User</a></li>\r\n");
      out.write("            <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/JSP/Admin/edit.jsp\" target=\"right\">Edit User</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\t    <li><a href=\"javascript:toggle('inbox')\">&nbsp;&nbsp;Transactions</a></li>\r\n");
      out.write("        <ul id=\"inbox\" class=\"links\" style=\"display:none;\">\r\n");
      out.write("            <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/JSP/Admin/inbox.jsp\" target=\"right\">Received Mails</a></li>\r\n");
      out.write("            <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/JSP/Admin/sent.jsp\" target=\"right\">Sent Mails</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\t\t<li><a href=\"javascript:toggle('vbnet')\">&nbsp;&nbsp;Settings</a></li>\r\n");
      out.write("        \t<ul id=\"vbnet\" class=\"links\" style=\"display:none;\">\r\n");
      out.write("                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/res/JSP/Admin/change.jsp?user=");
      out.print(request.getAttribute("admin") );
      out.write("\" target=\"right\">Change Password</a></li>\r\n");
      out.write("                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("\">Log-Out</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\t\t</ul>            \r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"right\" style=\"padding-top: 50px\">\r\n");
      out.write("\t<iframe src=\"\" name=\"right\" height=\"500\" width=\"780\" frameborder=\"0\"></iframe>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
