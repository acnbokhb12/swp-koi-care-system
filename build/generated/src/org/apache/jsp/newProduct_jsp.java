package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <link\n");
      out.write("        rel=\"stylesheet\"\n");
      out.write("        href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\n");
      out.write("    />\n");
      out.write("    <link\n");
      out.write("        href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap\"\n");
      out.write("        rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <title>Add New Product</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- Sidebar Section -->\n");
      out.write("        <div class=\"sidebar\">\n");
      out.write("            <div class=\"profile\">\n");
      out.write("                <img\n");
      out.write("                    src=\"https://placehold.co/50x50\"\n");
      out.write("                    alt=\"Profile picture of the user\"\n");
      out.write("                />\n");
      out.write("                <div>\n");
      out.write("                    <h4>Manager</h4>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <ul class=\"menu\">\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"orderManagement.jsp\"\n");
      out.write("                        ><i class=\"fas fa-shopping-cart\"></i> Order Management</a\n");
      out.write("                    >\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"productManagement.jsp\"\n");
      out.write("                        ><i class=\"fas fa-box\"></i> Product Management</a\n");
      out.write("                    >\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"customerFish.jsp\"><i class=\"fas fa-fish\"></i> Customer Fish</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"customerWaterParameter.jsp\"\n");
      out.write("                        ><i class=\"fas fa-water\"></i> Customer Water Parameter</a\n");
      out.write("                    >\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Main Content Section -->\n");
      out.write("        <div class=\"main-content\">\n");
      out.write("            <!-- Header -->\n");
      out.write("            <div class=\"content-header\">\n");
      out.write("                <h2>Add New Product</h2>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Product Form Section -->\n");
      out.write("            <div class=\"form-section\">\n");
      out.write("                <form id=\"newProductForm\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"productID\">Product ID:</label>\n");
      out.write("                        <input type=\"text\" id=\"productID\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"productName\">Product Name:</label>\n");
      out.write("                        <input type=\"text\" id=\"productName\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"productDescription\">Description:</label>\n");
      out.write("                        <textarea id=\"productDescription\" rows=\"4\" required></textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"productCategory\">Category:</label>\n");
      out.write("                        <input type=\"text\" id=\"productCategory\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"productQuantity\">Quantity:</label>\n");
      out.write("                        <input type=\"number\" id=\"productQuantity\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"productPrice\">Product Price:</label>\n");
      out.write("                        <input type=\"text\" id=\"productPrice\" required />\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"submit-button\">Add Product</button>\n");
      out.write("                    <button type=\"button\" class=\"cancel-button\" onclick=\"location.href='productManagement.jsp'\">Cancel</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
