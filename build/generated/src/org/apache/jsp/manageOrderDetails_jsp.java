package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageOrderDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Manager Order Page</title>\n");
      out.write("        <!-- link logo img page -->\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("        <!-- Font Google family -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script> \n");
      out.write("        <!-- CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/adminOrder.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container_admin\">\n");
      out.write("            <div id=\"db-wrapper\">\n");
      out.write("                <!-- Sidebar -->\n");
      out.write("                <div id=\"sidebar_admin\"></div>\n");
      out.write("                <!-- Header -->\n");
      out.write("                <header id=\"header\"></header>\n");
      out.write("                <!-- Main Section -->\n");
      out.write("                <div class=\"right-navbar-admin-manage\">\n");
      out.write("                    <!-- Main Content Section -->\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <h2>Order Details</h2>\n");
      out.write("                        <div class=\"order-info\">\n");
      out.write("                            <p><strong>Order ID:</strong> #OD12345</p>\n");
      out.write("                            <p><strong>Order Date:</strong> 2024-10-03</p>\n");
      out.write("                            <p><strong>Status:</strong> Processing</p>\n");
      out.write("                            <p><strong>Address:</strong> 123 Main St, Springfield</p>\n");
      out.write("                            <p><strong>Phone:</strong> +1-234-567-890</p>\n");
      out.write("                        </div>\n");
      out.write("                        <h3>Product List</h3>\n");
      out.write("                        <table>\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Product Name</th>\n");
      out.write("                                    <th>Image</th>\n");
      out.write("                                    <th>Category</th>\n");
      out.write("                                    <th>Price</th>\n");
      out.write("                                    <th>Quantity</th>\n");
      out.write("                                    <th>Total</th>\n");
      out.write("                                    <th>Action</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Product A</td>\n");
      out.write("                                    <td><img class=\"order-details-image\" src=\"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp\" alt=\"Product A\"></td>\n");
      out.write("                                    <td>Category A</td>\n");
      out.write("                                    <td>$10.00</td>\n");
      out.write("                                    <td>2</td>\n");
      out.write("                                    <td>$20.00</td>\n");
      out.write("                                    <td class=\"button-cell\"><a class=\"details-btn\" href=\"manageProductDetails.jsp?productId=1\">View Details</a></td> <!-- Added class here -->\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Product B</td>\n");
      out.write("                                    <td><img class=\"order-details-image\" src=\"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp\" alt=\"Product B\"></td>\n");
      out.write("                                    <td>Category B</td>\n");
      out.write("                                    <td>$15.00</td>\n");
      out.write("                                    <td>1</td>\n");
      out.write("                                    <td>$15.00</td>\n");
      out.write("                                    <td class=\"button-cell\"><a class=\"details-btn\" href=\"manageProductDetails.jsp?productId=2\">View Details</a></td> <!-- Added class here -->\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Product C</td>\n");
      out.write("                                    <td><img class=\"order-details-image\" src=\"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp\" alt=\"Product C\"></td>\n");
      out.write("                                    <td>Category C</td>\n");
      out.write("                                    <td>$8.00</td>\n");
      out.write("                                    <td>3</td>\n");
      out.write("                                    <td>$24.00</td>\n");
      out.write("                                    <td class=\"button-cell\"><a class=\"details-btn\" href=\"manageProductDetails.jsp?productId=3\">View Details</a></td> <!-- Added class here -->\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                        <div class=\"back-container\">\n");
      out.write("                            <div class=\"total-price\">\n");
      out.write("                                Total Amount: $59.00\n");
      out.write("                            </div>\n");
      out.write("                            <a class=\"back-button\" href=\"manageOrder.jsp\">Back</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        $('#header').load('utils.jsp #header_admin', () => {\n");
      out.write("            $.getScript('./assets/js/utilsAdmin.js');\n");
      out.write("        });\n");
      out.write("        $('#sidebar_admin').load('utils.jsp #sidebar_manager');\n");
      out.write("    </script>\n");
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
