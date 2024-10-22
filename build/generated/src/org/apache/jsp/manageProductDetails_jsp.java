package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageProductDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Manager Page</title>\n");
      out.write("        <!-- link logo img page -->\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("        <!-- Font gg family -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("        <!-- font awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("\n");
      out.write("        <!-- bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Jquery -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script> \n");
      out.write("        <!-- css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/adminProduct.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container_admin\">\n");
      out.write("            <div id=\"db-wrapper\">\n");
      out.write("                <div id=\"sidebar_admin\"></div>\n");
      out.write("                <header id=\"header\"> </header>\n");
      out.write("                <div class=\"right-navbar-admin-manage\">\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <div class=\"header-information\">\n");
      out.write("                            <h2>Product Information</h2>\n");
      out.write("                            <div class=\"button-group\">\n");
      out.write("                                <a href=\"manageProductUpdate.jsp\" class=\"btn btn-primary\" id=\"updateButton\">Update Product</a>\n");
      out.write("                                <a href=\"#\" class=\"btn btn-danger\" id=\"deleteButton\">Delete</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"details-section\">\n");
      out.write("                            <div class=\"product-wrapper row\">\n");
      out.write("                                <div class=\"col-lg-6 pt-4\">\n");
      out.write("                                    <img\n");
      out.write("                                    src=\"https://mazuri.com/cdn/shop/files/727613004804-center-1.jpg?v=1714180786\"\n");
      out.write("                                    alt=\"Product Image\"\n");
      out.write("                                    class=\"product-img  \"\n");
      out.write("                                    />\n");
      out.write("                                </div>\n");
      out.write("                               \n");
      out.write("                                <div class=\"product-info-block col-lg-6 pt-4\">\n");
      out.write("                                    <div class=\"info-field\">\n");
      out.write("                                        <label for=\"productID\">Product ID:</label>\n");
      out.write("                                        <span id=\"productID\">12345</span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"info-field\">\n");
      out.write("                                        <label for=\"productName\">Product Name:</label>\n");
      out.write("                                        <span id=\"productName\">Koi Food</span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"info-field\">\n");
      out.write("                                        <div class=\"info-item\">\n");
      out.write("                                            <label for=\"productDescription\">Description:</label>\n");
      out.write("                                            <span id=\"productDescription\" class=\"description-text\">\n");
      out.write("                                                High-quality food for Koi fish, packed with essential nutrients.\n");
      out.write("                                            </span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"info-field\">\n");
      out.write("                                        <label for=\"productCategory\">Category:</label>\n");
      out.write("                                        <span id=\"productCategory\">Food</span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"info-field\">\n");
      out.write("                                        <label for=\"productPrice\">Product Price:</label>\n");
      out.write("                                        <span id=\"product__detail-price-id\">20000</span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            $('#header').load('utils.jsp #header_admin', () => {\n");
      out.write("                $.getScript('./assets/js/utilsAdmin.js');\n");
      out.write("            });\n");
      out.write("            $('#sidebar_admin').load('utils.jsp  #sidebar_manager');\n");
      out.write("\n");
      out.write("            let amount = parseInt(document.getElementById('product__detail-price-id').innerText);\n");
      out.write("      let formattedAmount = amount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })\n");
      out.write("      document.getElementById('product__detail-price-id').innerText = formattedAmount;\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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
