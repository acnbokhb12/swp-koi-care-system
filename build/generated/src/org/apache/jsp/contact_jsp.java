package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Document</title>\n");
      out.write("        <!-- Font icon -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\">\n");
      out.write("        <!-- bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- style css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/main.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/about_contact.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <!-- start header -->\n");
      out.write("            <div id=\"header\"></div>\n");
      out.write("            <!-- end header -->\n");
      out.write("            <div class=\"main-contact\">\n");
      out.write("                <div class=\"container-infor-contact\">\n");
      out.write("                    <!-- img -->\n");
      out.write("                    <div class=\"img-contact-intro\">\n");
      out.write("                        <img src=\"https://podbaranem.com/wp-content/uploads/2017/05/IMG_2724.jpg\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <!-- desc - fill in -->\n");
      out.write("                    <div class=\"contact-detail-dest\">\n");
      out.write("                        <h2>Contact us</h2>\n");
      out.write("                        <div class=\"row fill-description-map\">\n");
      out.write("                            <div class=\"col-md-12 col-lg-6 fill-infor-self\">\n");
      out.write("                                <h2>Get In Touch</h2>\n");
      out.write("                                <p>Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.</p>\n");
      out.write("                                <div class=\"contain-form-contact\">\n");
      out.write("                                    <form action=\"\" method=\"post\">\n");
      out.write("                                        <div class=\"item-contact\">\n");
      out.write("                                            <label>First Name</label><br>\n");
      out.write("                                            <input type=\"text\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"item-contact\">\n");
      out.write("                                            <label>E-Mail</label><br>\n");
      out.write("                                            <input type=\"email\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"item-contact\">\n");
      out.write("                                            <label>Message</label><br>\n");
      out.write("                                            <textarea type=\"text\" class=\"\"></textarea>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <span>\n");
      out.write("                                            <button type=\"submit\" class=\"btn-sub-contact\">SEND NOW</button>\n");
      out.write("                                        </span>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-12 col-lg-6 img-map-our\">\n");
      out.write("                                <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.6100105370224!2d106.8073080748579!3d10.84112758931161!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752731176b07b1%3A0xb752b24b379bae5e!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBGUFQgVFAuIEhDTQ!5e0!3m2!1svi!2s!4v1719624859782!5m2!1svi!2s\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- footer -->\n");
      out.write("            <div id=\"footer\"></div>\n");
      out.write("            <script>\n");
      out.write("                $('#header').load('utils.jsp #header__nav', () => {\n");
      out.write("                    $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("                });\n");
      out.write("                $('#footer').load('utils.jsp #footer__nav', () => {\n");
      out.write("                    $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("                });\n");
      out.write("            </script>\n");
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
