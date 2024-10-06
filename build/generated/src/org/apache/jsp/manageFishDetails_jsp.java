package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageFishDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Manage Fish Details</title>\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/adminFish.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container_admin\">\n");
      out.write("            <div id=\"db-wrapper\">\n");
      out.write("                <div id=\"sidebar_admin\"></div>\n");
      out.write("                <header id=\"header\"></header>\n");
      out.write("                <div class=\"right-navbar-admin-manage\"> \n");
      out.write("                    <!-- Main Content Section -->\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <div class=\"header\">\n");
      out.write("                            <h2>Fish Details</h2>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"fish-container\">\n");
      out.write("                            <form>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"fishId\">Fish ID:</label>\n");
      out.write("                                    <p id=\"fishId\">#PD12387</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group d-flex align-items-start\">\n");
      out.write("                                    <img id=\"fishImage\" src=\"https://i.pinimg.com/originals/6e/a6/f8/6ea6f87bd1266879a59c6d133d861616.png\" alt=\"Tranquil Waters\" class=\"img-fluid fish-image\" />\n");
      out.write("                                    <div class=\"fish-details\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"fishName\">Fish Name:</label>\n");
      out.write("                                            <p id=\"fishName\" class=\"fish-detail\">Tranquil Waters</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"age\">Age:</label>\n");
      out.write("                                            <p id=\"age\" class=\"fish-detail\">5 years</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"length\">Length:</label>\n");
      out.write("                                            <p id=\"length\" class=\"fish-detail\">75 cm</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"weight\">Weight:</label>\n");
      out.write("                                            <p id=\"weight\" class=\"fish-detail\">10 kg</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"gender\">Gender:</label>\n");
      out.write("                                            <p id=\"gender\" class=\"fish-detail\">Male</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"origin\">Origin:</label>\n");
      out.write("                                            <p id=\"origin\" class=\"fish-detail\">Japan</p>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <label for=\"description\">Description:</label>\n");
      out.write("                                            <p id=\"description\" class=\"fish-detail\">This is a beautiful Koi fish known for its vibrant colors and graceful swimming.</p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-secondary\" onclick=\"window.location.href = 'manageFish.jsp'\">Back</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $('#header').load('utils.jsp #header_admin', () => {\n");
      out.write("                $.getScript('./assets/js/utilsAdmin.js');\n");
      out.write("            });\n");
      out.write("            $('#sidebar_admin').load('utils.jsp #sidebar_manager');\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
