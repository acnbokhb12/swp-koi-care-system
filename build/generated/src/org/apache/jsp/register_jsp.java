package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Sign Up</title>\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("\n");
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
      out.write("            <div class=\"container__screen__img_signup  \" style=\"width: 40%;\">\n");
      out.write("                <div class=\"screen__img-detail_signup\">\n");
      out.write("                    <img class=\"img-detail-item_signup\"\n");
      out.write("                         src=\"https://i.pinimg.com/originals/26/db/71/26db713c96975fd76257800965c0b19f.jpg\" alt=\"\">\n");
      out.write("                    <img class=\"img-detail-item_signup\"\n");
      out.write("                         src=\"https://i.pinimg.com/564x/d8/ad/50/d8ad5040b549e8dc49fe1aac3098f239.jpg\" alt=\"\">\n");
      out.write("                    <img class=\"img-detail-item_signup\"\n");
      out.write("                         src=\"https://images.rawpixel.com/image_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvbHIvdjczMy10YW5nLTEzYl8xLmpwZw.jpg\"\n");
      out.write("                         alt=\"\" style=\"float: left;\">\n");
      out.write("                    <img class=\"img-detail-item_signup\"\n");
      out.write("                         src=\"https://www.shutterstock.com/image-vector/asian-background-oriental-japanese-style-260nw-1978654823.jpg\"\n");
      out.write("                         alt=\"\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Sign up -->\n");
      out.write("            <div class=\"info__user-container-up  \">\n");
      out.write("                <div id=\"sign-in-form\" class=\"container__sigup-form form-container\">\n");
      out.write("                    <div class=\"user-re-container\">\n");
      out.write("                        <header class=\"header__screen-log\">\n");
      out.write("                            <!-- <h1 class=\"signin-header-title\">Welcome back!</h1> -->\n");
      out.write("                            <a href=\"home.jsp\" class=\"header__img-log\">\n");
      out.write("                                <img src=\"./assets/img/logo/logoSignin.jpg\" alt=\"\">\n");
      out.write("                            </a>\n");
      out.write("                            <p class=\"header-desc\" style=\"font-size: 2.6rem; text-align: center;\">Create an account</p>\n");
      out.write("                        </header>\n");
      out.write("                        <div class=\"signup-user-body\">\n");
      out.write("                            <form action=\"MainController?action=register\" class=\"form\" id=\"form-1\" method=\"post\">\n");
      out.write("                                <div class=\"row row__form\"> \n");
      out.write("                                    <!-- Email -->\n");
      out.write("                                    <div class=\"form-group col-md-6 \">\n");
      out.write("                                        <label for=\"email\" class=\"form-label\"> <i class=\"fa-solid fa-envelope  icon-signup\"></i>\n");
      out.write("                                            Email</label> \n");
      out.write("                                        <input type=\"email\" id=\"email\" name=\"txtemail\" class=\"input__form\"\n");
      out.write("                                               placeholder=\"email@domain.com\">\n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                        <span class=\"form-message-error-bk\">Email is exist</span>\n");
      out.write("                                    </div> \n");
      out.write("                                    <!-- UserName -->\n");
      out.write("                                    <div class=\"form-group col-md-6 \">\n");
      out.write("                                        <label for=\"fullname\" class=\"form-label\"><i class=\"fa-solid fa-user icon-signup\"></i>\n");
      out.write("                                            Name</label>\n");
      out.write("\n");
      out.write("                                        <input type=\"text\" id=\"fullname\" name=\"txtusername\" class=\"input__form\"\n");
      out.write("                                               placeholder=\"UserName\" />\n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                    </div> \n");
      out.write("                                    <!-- password -->\n");
      out.write("                                    <div class=\"form-group col-md-6   \"> \n");
      out.write("                                        <label for=\"password\" class=\"form-label\"><i\n");
      out.write("                                                class=\"fa-solid fa-lock icon-signup\"></i> Password</label>\n");
      out.write("                                        <input type=\"password\" id=\"password\" name=\"txtpassword\"\n");
      out.write("                                               class=\"input__form \" placeholder=\"Password\" />\n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                    </div> \n");
      out.write("                                    <!-- pass wordd again -->\n");
      out.write("                                    <div class=\"form-group col-md-6 \">\n");
      out.write("                                        <label for=\"password_confirmation\" class=\"form-label\"><i class=\"fa-solid fa-lock icon-signup\"></i> Confirm\n");
      out.write("                                            password</label>\n");
      out.write("                                        <input type=\"password\" id=\"password_confirmation\" name=\"txtconfirmpassword\" class=\"input__form\"\n");
      out.write("                                               placeholder=\"Confirm password\" />\n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Phone -->\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <label for=\"phoneNumber\" class=\"form-label\"> <i class=\"fa-solid fa-phone icon-signup\"></i> Phone\n");
      out.write("                                            number</label>\n");
      out.write("                                        <input type=\"text\" id=\"phoneNumber\" name=\"txtphone\" class=\"input__form\"\n");
      out.write("                                               placeholder=\"Phone number\" />\n");
      out.write("                                        <span class=\"form-message\"> </span>\n");
      out.write("                                        <span class=\"form-message-error-bk\">Phone is exist</span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Gender -->\n");
      out.write("                                    <div class=\"form-group col-md-6\">\n");
      out.write("                                        <label for=\"\" class=\"form-label\">Choose Gender:</label>\n");
      out.write("                                        <select name=\"choice-gender\" id=\"\" class=\"input__form \">\n");
      out.write("                                            <option value=\"Man\">Man</option>\n");
      out.write("                                            <option value=\"Woman\">Woman</option>\n");
      out.write("                                            <option value=\"Orther\">Other</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <button class=\"btn btn-info btn-signin-acc\" type=\"submit\">Sign Up</button><br>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Submit -->\n");
      out.write("                            </form>\n");
      out.write("                            <p class=\"footer__screen__acc_according\">\n");
      out.write("                                Already have an account?<a href=\"login.jsp\" class=\"signup-btn-link\" id=\"come-signup\">Sign\n");
      out.write("                                    In</a>\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                        <footer class=\"user-signup-footer\">\n");
      out.write("                        </footer>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script src=\"./assets/js/validator.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        Validator({\n");
      out.write("            form: '#form-1',\n");
      out.write("            errorSelector: '.form-message',\n");
      out.write("            rules: [\n");
      out.write("                Validator.isEmail('#email', 'Please fill true email'),\n");
      out.write("                Validator.isRequired('#fullname', 'Please fill your full name'),\n");
      out.write("                Validator.minLength('#password', 6),\n");
      out.write("                Validator.isRequired('#password_confirmation'),\n");
      out.write("                Validator.isConfirmed('#password_confirmation', () => {\n");
      out.write("                    return document.querySelector('#form-1 #password').value;\n");
      out.write("                }, 'Password confirm not exactly'),\n");
      out.write("                Validator.isPhoneNumber('#phoneNumber', 'Phone number at least 10 number'),\n");
      out.write("            ],\n");
      out.write("            // onSubmit: (data)=>{\n");
      out.write("            //     console.log(data)\n");
      out.write("            // }\n");
      out.write("        });\n");
      out.write("    </script>\n");
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
}
