package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\n");
      out.write("    />\n");
      out.write("    <link\n");
      out.write("      href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <title>Manager Page</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <!-- Sidebar Section -->\n");
      out.write("      <div class=\"sidebar\">\n");
      out.write("        <div class=\"profile\">\n");
      out.write("          <img\n");
      out.write("            src=\"https://placehold.co/50x50\"\n");
      out.write("            alt=\"Profile picture of the user\"\n");
      out.write("          />\n");
      out.write("          <div>\n");
      out.write("            <h4>Manager</h4>\n");
      out.write("            <p class=\"welcome-message\">Welcome back</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <ul class=\"menu\">\n");
      out.write("          <li>\n");
      out.write("            <a href=\"orderManagement.jsp\"\n");
      out.write("              ><i class=\"fas fa-shopping-cart\"></i> Order Management</a\n");
      out.write("            >\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"productManagement.jsp\"\n");
      out.write("              ><i class=\"fas fa-box\"></i> Product Management</a\n");
      out.write("            >\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"customerFish.jsp\"><i class=\"fas fa-fish\"></i> Customer Fish</a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"customerWaterParameter.jsp\"\n");
      out.write("              ><i class=\"fas fa-water\"></i> Customer Water Parameter</a\n");
      out.write("            >\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <!-- Main Content Section -->\n");
      out.write("      <div class=\"content\">\n");
      out.write("        <!-- Header with actions -->\n");
      out.write("        <div class=\"header\">\n");
      out.write("          <h2>Product List</h2>\n");
      out.write("          <div class=\"actions\">\n");
      out.write("            <a href=\"newProduct.jsp\" class=\"create-new-product-button\">\n");
      out.write("              <button id=\"createNewProduct\">Create New Product</button>\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Product Table -->\n");
      out.write("        <div class=\"table-container\" id=\"productTableContainer\">\n");
      out.write("          <table id=\"productTable\">\n");
      out.write("            <thead>\n");
      out.write("              <tr>\n");
      out.write("                <th>Product ID</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Image</th>\n");
      out.write("                <th>Description</th>\n");
      out.write("                <th>Category</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("                <th>Actions</th>\n");
      out.write("              </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("              <tr>\n");
      out.write("                <td>#PD12387</td>\n");
      out.write("                <td>Example Product</td>\n");
      out.write("                <td>\n");
      out.write("                  <img\n");
      out.write("                    src=\"https://placehold.co/50x50\"\n");
      out.write("                    alt=\"Image of Example Product\"\n");
      out.write("                  />\n");
      out.write("                </td>\n");
      out.write("                <td>Sample description of the product.</td>\n");
      out.write("                <td>Category Name</td>\n");
      out.write("                <td>10</td>\n");
      out.write("                <td>$19.99</td>\n");
      out.write("                <td>\n");
      out.write("                  <button\n");
      out.write("                    class=\"details-btn\"\n");
      out.write("                    onclick=\"window.location.href='productDetailsManagement.jsp'\"\n");
      out.write("                  >\n");
      out.write("                    <i class=\"fas fa-info-circle\"></i>\n");
      out.write("                  </button>\n");
      out.write("                  <button\n");
      out.write("                    class=\"edit-btn\"\n");
      out.write("                    onclick=\"window.location.href='productUpdate.jsp'\"\n");
      out.write("                  >\n");
      out.write("                    <i class=\"fas fa-edit\"></i>\n");
      out.write("                  </button>\n");
      out.write("                  <button class=\"delete-btn\">\n");
      out.write("                    <i class=\"fas fa-trash\"></i>\n");
      out.write("                  </button>\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("            </tbody>\n");
      out.write("          </table>\n");
      out.write("\n");
      out.write("          <!-- Footer and Pagination -->\n");
      out.write("          <div class=\"footer\">\n");
      out.write("            <p>Showing 1 of 1 entry</p>\n");
      out.write("            <div class=\"pagination\">\n");
      out.write("              <button>Previous</button>\n");
      out.write("              <button>1</button>\n");
      out.write("              <button>Next</button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
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
