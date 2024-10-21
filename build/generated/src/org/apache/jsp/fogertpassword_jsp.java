package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fogertpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Forget password</title>\n");
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
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main_container_create\">\n");
      out.write("            <div class=\"contain-img-page\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-create_pw\"> \n");
      out.write("                <form action=\"ForgetPasswordController\" method=\"post\" class=\"form\" id=\"form-1\">\n");
      out.write("                    <p class=\"form-title\">Change your password with email</p>\n");
      out.write("                    <div class=\"input-container form-group\">\n");
      out.write("                        <input type=\"email\" name=\"email\" placeholder=\"Your email\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-container form-group\">\n");
      out.write("                        <input type=\"password\" id=\"password\" name=\"new_password\" placeholder=\"Enter new password\">\n");
      out.write("                        <span class=\"form-message\"> </span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-container form-group\">\n");
      out.write("                        <input type=\"password\" id=\"password_confirmation\" placeholder=\"Confirm password\">\n");
      out.write("                        <span class=\"form-message\"> </span>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"submit mt-4\">\n");
      out.write("                        Confirm\n");
      out.write("                    </button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <style>\n");
      out.write("            .main_container_create {\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .contain-img-page {\n");
      out.write("                background: url('https://www.yourcentralvalley.com/wp-content/uploads/sites/54/2023/09/Koi-Fish-Show-returns-to-Fresno-at-Woodward-Park.jpeg?w=2560&h=1440&crop=1') no-repeat;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 100vh;\n");
      out.write("                background-size: cover;\n");
      out.write("                filter: brightness(0.6);\n");
      out.write("            }\n");
      out.write("            .form-create_pw{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                left: 50%;\n");
      out.write("                transform: translate(-50%,-50%);\n");
      out.write("            }\n");
      out.write("            /* From Uiverse.io by nathann09 */\n");
      out.write("            .form {\n");
      out.write("                background-color: #fff;\n");
      out.write("                display: block;\n");
      out.write("                padding: 2rem;\n");
      out.write("                width: 100%;\n");
      out.write("                /* max-width: 350px; */\n");
      out.write("                border-radius: 0.5rem;\n");
      out.write("                box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-title {\n");
      out.write("                font-size: 2.4rem;\n");
      out.write("                line-height: 1.75rem;\n");
      out.write("                font-weight: 600;\n");
      out.write("                text-align: center;\n");
      out.write("                color: #000;\n");
      out.write("                margin-bottom: 3rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-container {\n");
      out.write("                position: relative;\n");
      out.write("                /* margin: 2rem 0; */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-container input,\n");
      out.write("            .form button {\n");
      out.write("                outline: none;\n");
      out.write("                border: 1px solid #e5e7eb; \n");
      out.write("                margin-bottom: 0.4rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-container input {\n");
      out.write("                background-color: #fff;\n");
      out.write("                padding: 1rem;\n");
      out.write("                padding-right: 3rem;\n");
      out.write("                font-size:1.6rem;\n");
      out.write("                line-height: 1.25rem;\n");
      out.write("                width: 300px;\n");
      out.write("                border-radius: 0.5rem;\n");
      out.write("                box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .submit {\n");
      out.write("                display: block;\n");
      out.write("                padding: 1rem 1.2rem;\n");
      out.write("                background-color: var(--bs-orange);\n");
      out.write("                color: #ffffff;\n");
      out.write("                font-size: 1.6rem;\n");
      out.write("                line-height: 1.25rem;\n");
      out.write("                font-weight: 500;\n");
      out.write("                width: 100%;\n");
      out.write("                border-radius: 0.5rem;\n");
      out.write("                text-transform: uppercase; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .signup-link {\n");
      out.write("                color: #6B7280;\n");
      out.write("                font-size: 0.875rem;\n");
      out.write("                line-height: 1.25rem;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .signup-link a {\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-message{\n");
      out.write("                display: block;\n");
      out.write("                color: red;\n");
      out.write("                font-size: 1.4rem;\n");
      out.write("                padding-left: 1rem;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"./assets/js/validator.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            Validator({\n");
      out.write("                form: '#form-1',\n");
      out.write("                errorSelector: '.form-message',\n");
      out.write("                rules: [\n");
      out.write("                    Validator.minLength('#password', 6),\n");
      out.write("                    Validator.isRequired('#password_confirmation'),\n");
      out.write("                    Validator.isConfirmed('#password_confirmation', () => {\n");
      out.write("                        return document.querySelector('#form-1 #password').value;\n");
      out.write("                    }, 'Password confirm not exactly')\n");
      out.write("                ],\n");
      out.write("                // onSubmit: (data)=>{\n");
      out.write("                //     console.log(data)\n");
      out.write("                // }\n");
      out.write("            });\n");
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
