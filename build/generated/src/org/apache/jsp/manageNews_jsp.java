package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageNews_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Manage News</title>\n");
      out.write("     <!-- link logo img page -->\n");
      out.write("     <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("     <!-- Font gg family -->\n");
      out.write("     <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\"\n");
      out.write("         rel=\"stylesheet\">\n");
      out.write("     <!-- Font icon -->\n");
      out.write("     <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("     <!-- bootstrap -->\n");
      out.write("     <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("         integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("     <!-- Jquery -->\n");
      out.write("     <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script> \n");
      out.write("     <!-- css -->  \n");
      out.write("     <link rel=\"stylesheet\" href=\"./assets/css/base.css\"> \n");
      out.write("     <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("     <link rel=\"stylesheet\" href=\"./assets/css/adminUser.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container_admin\">\n");
      out.write("        <div id=\"db-wrapper\">\n");
      out.write("            <!-- start-sidebar -->\n");
      out.write("            <div id=\"sidebar_admin\"></div>\n");
      out.write("            <!-- start header -->\n");
      out.write("            <header id=\"header\">  </header>\n");
      out.write("            <!-- right -->\n");
      out.write("            <div class=\"right-navbar-admin-manage\">\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    <!-- Your code here -->\n");
      out.write("                     <!-- Title -->\n");
      out.write("                    <div class=\"header d-flex \"> \n");
      out.write("                        <h1>News List</h1>  \n");
      out.write("                        <div>\n");
      out.write("                            <a  class=\"link_add-account\" href=\"manageAddNews.jsp\">Add News</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Search -->\n");
      out.write("                    <div class=\"row row-user-main\"> \n");
      out.write("                        <div class=\"col-auto\">\n");
      out.write("                            <form class=\"table-search-form row gx-1 align-items-center\" action=\"\">\n");
      out.write("                                <div class=\"col-auto \">\n");
      out.write("                                    <input type=\"text\" class=\"search-order\" placeholder=\"Search...\" id=\"searchInput\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-auto contain-btn-select-order\">\n");
      out.write("                                    <select class=\"contain-btn-select-search\" name=\"searchChoice\" id=\"searchChoice\">\n");
      out.write("                                        <option value=\"email\" selected>Title</option>\n");
      out.write("                                        <option value=\"phone\">Name</option>\n");
      out.write("                                        <option value=\"phone\">Category</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-auto contain-btn-search-order\">\n");
      out.write("                                    <button class=\"btn-submit-search-order\" type=\"submit\">Search</button>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- List -->\n");
      out.write("                    <div class=\"table-container\" id=\"accountTableContainer\">\n");
      out.write("                         \n");
      out.write("                       <table id=\"accountTable\">\n");
      out.write("                   <thead>\n");
      out.write("                       <tr>\n");
      out.write("                           <th>News ID</th> \n");
      out.write("                           <th>Title</th>  \n");
      out.write("                           <th>Category</th> \n");
      out.write("                           <th>Date</th> \n");
      out.write("                           <th>Status</th> \n");
      out.write("                           <th>View</th> \n");
      out.write("                       </tr>\n");
      out.write("                   </thead>\n");
      out.write("                   <tbody>\n");
      out.write("                       <tr>\n");
      out.write("                           <td>1</td> \n");
      out.write("                           <td class=\"address__acc\">Top Japanese Koi Variety Identification Video</td>\n");
      out.write("                           <td>Fish news</td>\n");
      out.write("                           <td>20-01-2004</td> \n");
      out.write("                           <td>Ative</td> \n");
      out.write("                           <td class=\"text-center\">\n");
      out.write("                               <a href=\"manageNewsDetailAdmin.jsp\"> \n");
      out.write("                                   <button class=\"edit-btn\"><i class=\"fas fa-edit\"></i></button> \n");
      out.write("                               </a>\n");
      out.write("                           </td>\n");
      out.write("                       </tr>  \n");
      out.write("                   </tbody>\n");
      out.write("                       </table>\n");
      out.write("                       <div class=\"footer\">\n");
      out.write("                           <p>Showing 1 of 1 entry</p> \n");
      out.write("                           <div class=\"pagination\">\n");
      out.write("                               <button>Previous</button> \n");
      out.write("                               <button>1</button>\n");
      out.write("                               <button>Next</button> \n");
      out.write("                           </div>\n");
      out.write("                       </div>\n");
      out.write("                   </div>\n");
      out.write("                </div>\n");
      out.write("           </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("<script>\n");
      out.write("     $('#header').load('utils.jsp #header_admin', ()=>{\n");
      out.write("        $.getScript('./assets/js/utilsAdmin.js');\n");
      out.write("    });\n");
      out.write("    $('#sidebar_admin').load('utils.jsp  #sidebar_admin');\n");
      out.write("</script>\n");
      out.write(" \n");
      out.write("</html>");
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
