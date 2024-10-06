package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class productUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Update Product</title>\n");
      out.write("        <!-- link logo img page -->\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("        <!-- Font gg family -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <!-- font awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("\n");
      out.write("        <!-- bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Jquery -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
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
      out.write("                <header id=\"header\"></header>\n");
      out.write("                <div class=\"right-navbar-admin-manage\">\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <div class=\"header-information\">\n");
      out.write("                            <h2>Update Product Information</h2>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"update-product-section\">\n");
      out.write("                            <div class=\"product-container\">\n");
      out.write("                                <div class=\"product-details\">\n");
      out.write("                                    <div class=\"form-container\">\n");
      out.write("                                        <div class=\"form-wrapper\">\n");
      out.write("                                            <form action=\"uploadProductImageServlet\" method=\"POST\" enctype=\"multipart/form-data\" class=\"form-image-upload\">\n");
      out.write("                                                <div class=\"product-image-upload\">\n");
      out.write("                                                    <img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdTvpksqwVza-WmPCNDXK-T00gAIh3cSUIYg&s\" \n");
      out.write("                                                         alt=\"Product Image\" \n");
      out.write("                                                         class=\"product-image-update\"/> \n");
      out.write("                                                    <div class=\"img-detail-field\">\n");
      out.write("                                                        <h3>Upload New Image</h3>\n");
      out.write("                                                        <div class=\"file-upload-container\">\n");
      out.write("                                                            <input type=\"file\" id=\"fishImage\" name=\"fishImage\" accept=\"image/*\" required style=\"width: 100%;\" />\n");
      out.write("                                                            <button type=\"submit\" class=\"btn btn-upload\">Submit</button>  \n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </form>\n");
      out.write("                                            <form action=\"updateProductServlet\" method=\"POST\" class=\"form-update-details\">\n");
      out.write("                                                <div class=\"details-wrapper\">\n");
      out.write("                                                    <div class=\"detail-field\">\n");
      out.write("                                                        <h1>Product ID</h1>\n");
      out.write("                                                        <input type=\"text\" id=\"productID\" name=\"productID\" value=\"12345\" readonly style=\"width: 100%;\" />\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"detail-field\">\n");
      out.write("                                                        <h1>Product Name:</h1>\n");
      out.write("                                                        <input type=\"text\" id=\"productName\" name=\"productName\" value=\"Koi Food\" required style=\"width: 100%;\" />\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"detail-field\">\n");
      out.write("                                                        <h1>Description:</h1>\n");
      out.write("                                                        <textarea id=\"productDescription\" name=\"productDescription\" class=\"description-text\" required style=\"width: 100%; height: 100px;\"></textarea>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"detail-field\">\n");
      out.write("                                                        <h1>Category:</h1>\n");
      out.write("                                                        <input type=\"text\" id=\"productCategory\" name=\"productCategory\" value=\"Food\" required style=\"width: 100%;\" />\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"detail-field\">\n");
      out.write("                                                        <h1>Product Price:</h1>\n");
      out.write("                                                        <input type=\"text\" id=\"productPrice\" name=\"productPrice\" value=\"$20.00\" required style=\"width: 100%;\" />\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"action-buttons\">\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-save\">Submit</button>\n");
      out.write("                                                    <a href=\"manageProductDetails.jsp\" class=\"btn btn-cancel\">Cancel</a>\n");
      out.write("                                                </div>\n");
      out.write("                                            </form>\n");
      out.write("                                        </div> \n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <script>\n");
      out.write("                $('#header').load('utils.jsp #header_admin', () => {\n");
      out.write("                    $.getScript('./assets/js/utilsAdmin.js');\n");
      out.write("                });\n");
      out.write("                $('#sidebar_admin').load('utils.jsp  #sidebar_manager');\n");
      out.write("            </script>\n");
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
