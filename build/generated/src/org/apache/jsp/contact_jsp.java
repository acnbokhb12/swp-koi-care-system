package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Contact Page</title>\n");
      out.write("        <!-- Font icon -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\">\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Style CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/main.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/about_contact.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("        <!-- jQuery -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <!-- Start header -->\n");
      out.write("            <div id=\"header\"></div>\n");
      out.write("            <!-- End header -->\n");
      out.write("            <div class=\"main-contact\">\n");
      out.write("                <div class=\"container-infor-contact\">\n");
      out.write("                    <!-- Image -->\n");
      out.write("                    <div class=\"img-contact-intro\">\n");
      out.write("                        <img src=\"https://podbaranem.com/wp-content/uploads/2017/05/IMG_2724.jpg\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Description -->\n");
      out.write("                    <div class=\"contact-detail-dest\">\n");
      out.write("                        <h2>Contact Us</h2>\n");
      out.write("                        <div class=\"row fill-description-map\">\n");
      out.write("                            <div class=\"col-md-12 col-lg-6 fill-infor-self\">\n");
      out.write("                                <h2>Get In Touch</h2>\n");
      out.write("                                <p>We are here to assist you with the care and management of your Koi pond. If you have any questions regarding our products and advice on Koi care techniques, please fill out the form below. Our team of experts will get back to you as soon as possible.</p>\n");
      out.write("                                <div class=\"contain-form-contact\">\n");
      out.write("                                    <form action=\"MainController?action=contact\" method=\"post\">\n");
      out.write("                                        <div class=\"item-contact\">\n");
      out.write("                                            <label for=\"firstName\">First Name</label><br>\n");
      out.write("                                            <input type=\"text\" id=\"firstName\" name=\"firstName\" required>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"item-contact\">\n");
      out.write("                                            <label>E-Mail</label><br>\n");
      out.write("                                            <input type=\"email\" name=\"email\" required>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"item-contact\">\n");
      out.write("                                            <label>Message</label><br>\n");
      out.write("                                            <textarea name=\"message\" required maxlength=\"500\"></textarea>\n");
      out.write("                                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        </div>\n");
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
      out.write("            </div>  \n");
      out.write("        </div>  \n");
      out.write("        <div id=\"footer\"></div>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#header').load('utils.jsp #header__nav', function () {\n");
      out.write("                    $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("                });\n");
      out.write("                $('#footer').load('utils.jsp #footer__nav', function () {\n");
      out.write("                    $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("                });\n");
      out.write("            });\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                <span class=\"text-danger\" style=\"font-size: 1.2rem;\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
