package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Sign In</title>\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" /> \n");
      out.write("        <!-- Font family -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("        <!-- Font icon -->\n");
      out.write("        <!-- <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\"> -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("        <!-- bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/signIn_Up.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"screen__info__user  \">\n");
      out.write("\n");
      out.write("            <div class=\"container__screen__img  \">\n");
      out.write("                <div class=\"screen__img-detail\">\n");
      out.write("                    <img class=\"img-detail-item\" src=\"https://i.pinimg.com/564x/45/9c/9a/459c9a813fde9996be8f00895a7c68d4.jpg\" alt=\"\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- SIGNIN -->\n");
      out.write("            <div class=\"info__user-container  \">\n");
      out.write("                <div id=\"sign-in-form\" class=\"container__sigin-form form-container\">\n");
      out.write("                    <div class=\"user-sign-container\">\n");
      out.write("\n");
      out.write("                        <header class=\"header__screen-log\">\n");
      out.write("                            <!-- <h1 class=\"signin-header-title\">Welcome back!</h1> -->\n");
      out.write("                            <a href=\"home.jsp\" class=\"header__img-log\">\n");
      out.write("                                <img src=\"./assets/img/logo/logoSignin.jpg\" alt=\"\">\n");
      out.write("                            </a>\n");
      out.write("                            <p class=\"header-desc\">Sign In to manage your Koi Care System</p>\n");
      out.write("                        </header>\n");
      out.write("                        <div class=\"body__input-container\">\n");
      out.write("                            <form action=\"MainController?action=login\" class=\"form\" id=\"form1\" method=\"post\">\n");
      out.write("                                <!-- username --> \n");
      out.write("                                <div class=\"form-group\" style=\"margin-bottom: 0;\">  \n");
      out.write("                                    <input type=\"email\" id=\"email-log\" name=\"txtemail\" class=\"input__form\"\n");
      out.write("                                           placeholder=\"E-mail address or koicare ID\" required><br>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- password -->\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"password\" id=\"password-title-signin\" name=\"txtpassword\"\n");
      out.write("                                           class=\"input__form mt-4 last-child\" placeholder=\" Enter your password\" required /><br>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- take error something --> \n");
      out.write("                                <div class=\"wrong__acc mt-2\">\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"link-forgot-acc\">\n");
      out.write("                                    <a href=\"#\" class=\"\">Forgot password?</a><br>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <button class=\"btn btn-info btn-signin-acc \">Sign In</button><br>\n");
      out.write("                            </form>\n");
      out.write("                            <p class=\"footer__screen__acc_according\">\n");
      out.write("                                Don't have an account?<a href=\"register.jsp\" class=\"signup-btn-link\" id=\"come-signup\">Sign\n");
      out.write("                                    Up</a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <footer class=\"footer__screen__acc\">\n");
      out.write("                            <div class=\"policy__service-more\">\n");
      out.write("                                <p>This site is protected by reCAPTCHA Enterprise and the Google \n");
      out.write("                                    <a href=\"https://policies.google.com/privacy\" target=\"_blank\">Privacy Policy</a>\n");
      out.write("                                    and <a href=\"https://policies.google.com/terms\" target=\"_blank\">Terms of Service</a> apply</p>\n");
      out.write("                            </div>\n");
      out.write("                        </footer>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container__screen__img  \">\n");
      out.write("                <div class=\"screen__img-detail\">\n");
      out.write("                    <img class=\"img-detail-item\" src=\"https://i.pinimg.com/564x/ed/5c/50/ed5c502b3b22b3ab15102e9fbb4efd85.jpg\" alt=\"\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <span id=\"wrongNameOrPass\" class=\"\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                    ");
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
