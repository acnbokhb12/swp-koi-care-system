package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Document</title>\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" /> \n");
      out.write("        <!-- Font gg family -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Font icon -->\n");
      out.write("        <!-- <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css\"> -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("        <!-- bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/profilePerson.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- start header -->\n");
      out.write("        <div id=\"header\"></div>\n");
      out.write("        <!-- end header -->\n");
      out.write("        <div class=\"container container-edit-profile\">\n");
      out.write("\n");
      out.write("            <hr class=\"mt-0 mb-4\">\n");
      out.write("            <div class=\"row row-edit-profile\"> \n");
      out.write("                <div class=\"col-xl-8\">\n");
      out.write("                    <!-- Account details card-->\n");
      out.write("                    <div class=\"card mb-4\">\n");
      out.write("                        <div class=\"card-header\">Account Details</div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <form action=\"MainController?action=informationprofile\" class=\"form\" id=\"form-1\" method=\"post\">\n");
      out.write("                                <div class=\"row row-form-edit\">\n");
      out.write("\n");
      out.write("                                    <!-- Form Group (email address)-->\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"email\">Email address</label>\n");
      out.write("                                        <input class=\"form-control\" id=\"email\" name=\"email\" type=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly>\n");
      out.write("                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                 \n");
      out.write("                                        <span class=\"form-message\"></span>   \n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Form Group (username)-->\n");
      out.write("                                    <div class=\"col-md-6 \">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"inputUsername\">KoiCareId</label>\n");
      out.write("                                        <input class=\"form-control\" id=\"KoiCareId\" name=\"KoiCareId\" type=\"text\" placeholder=\"Enter your KoiCareId\"\n");
      out.write("                                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.koiCareID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                               ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write(" required >                                        \n");
      out.write("                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->\n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row  row-form-edit \">\n");
      out.write("                                    <!-- Form Group (username)-->\n");
      out.write("                                    <div class=\"col-md-6 \">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"inputUsername\">Name</label>\n");
      out.write("                                        <input class=\"form-control\" id=\"fullname\" name=\"fullname\" type=\"text\" placeholder=\"Enter your username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi --> \n");
      out.write("                                        <span class=\"form-message\"></span> \n");
      out.write("                                    </div> \n");
      out.write("                                    <!-- Form Group (phone number)-->\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"inputPhone\">Phone number</label>\n");
      out.write("                                        <input class=\"form-control\" id=\"phoneNumber\" name=\"phoneNumber\" type=\"tel\" placeholder=\"Enter your phone number\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.phoneNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                   \n");
      out.write("                                        <span class=\"form-message\"></span> <!-- dont touch --> \n");
      out.write("                                        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div> \n");
      out.write("                                <!-- Form Row-->\n");
      out.write("                                <div class=\"row  \">\n");
      out.write("                                    <div class=\"col-md-6 \">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"address\">Address</label>\n");
      out.write("                                        <input class=\"form-control\" id=\"address\" name=\"address\" type=\"text\" placeholder=\"Enter your address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required accept-charset >\n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                    </div> \n");
      out.write("                                    <!-- Form Group (birthday)-->\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"inputBirthday\">Gender</label>\n");
      out.write("                                        <select name=\"choice-gender\" id=\"\" class=\"input__form \">\n");
      out.write("                                            <option value=\"Man\" ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write(">Man</option>\n");
      out.write("                                            <option value=\"Woman\" ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write(">Woman</option>\n");
      out.write("                                            <option value=\"Other\" ");
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write(">Other</option>\n");
      out.write("                                            </select>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Save changes button-->\n");
      out.write("                                    <button class=\"btn btn-edit-img-profile\" type=\"submit\">Save changes</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xl-4\">\n");
      out.write("                        <!-- Profile picture card-->\n");
      out.write("                        <div class=\"card mb-4 mb-xl-0\">\n");
      out.write("                            <div class=\"card-header\">Profile Picture</div>\n");
      out.write("                            <div class=\"card-body text-center\">\n");
      out.write("                                <!-- Profile picture image-->\n");
      out.write("                                <div class=\"text-center d-flex justify-content-center\">\n");
      out.write("\n");
      out.write("                                    <img id=\"imagePreview\" class=\"img-account-profile rounded-circle \" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.profileImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <!-- Profile picture help block-->\n");
      out.write("                            <div class=\"desc-img\">\n");
      out.write("                                <p>\n");
      out.write("                                    JPG or PNG no larger than 5 MB \n");
      out.write("                                </p>    \n");
      out.write("                            </div>\n");
      out.write("                            <!-- Profile picture upload button-->\n");
      out.write("                            <form action=\"\"> \n");
      out.write("                                <input id=\"imageInput\" class=\"choose-edit-img-profile\" type=\"file\" accept=\"image/*\">\n");
      out.write("                                <button class=\"btn btn-edit-img-profile\" type=\"button\">Upload new image</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-xl-8\">\n");
      out.write("                    <!-- Account details card-->\n");
      out.write("                    <div class=\"card mb-4\">\n");
      out.write("                        <div class=\"card-header\">Edit Password</div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <form action=\"MainController?action=passwordprofile\" class=\"form\" id=\"form-2\" method=\"post\"> \n");
      out.write("                                <input type=\"hidden\" name=\"accID\" id=\"accID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.userID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                <!-- Form Row-->\n");
      out.write("                                <div class=\"row  row-form-edit \">\n");
      out.write("                                    <!-- Form Group (old pw)-->\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"inputFirstName\">Old Password</label>\n");
      out.write("                                        <input class=\"form-control\" name=\"password_old\" id=\"password_old\" type=\"password\" placeholder=\"Enter your old password\" >\n");
      out.write("                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->\n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                        ");
      if (_jspx_meth_c_if_6(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Form Group (new pw)-->\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <label class=\"label-profile-edit\" for=\"inputLastName\">New Password</label>\n");
      out.write("                                        <input class=\"form-control\" id=\"password_new\" name=\"password_new\" type=\"password\" placeholder=\"Enter your new password\" >\n");
      out.write("                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                    \n");
      out.write("                                        <span class=\"form-message\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>     \n");
      out.write("                                <!-- Save changes button-->\n");
      out.write("                                <button class=\"btn btn-edit-img-profile\" type=\"submit\">Save changes</button>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- footer -->\n");
      out.write("        <div id=\"footer\"></div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        $('#header').load('utils.jsp #header__nav', () => {\n");
      out.write("            $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("        });\n");
      out.write("        $('#footer').load('utils.jsp #footer__nav', () => {\n");
      out.write("            $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("    <script src=\"./assets/js/validator.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        Validator({\n");
      out.write("            form: '#form-1',\n");
      out.write("            errorSelector: '.form-message',\n");
      out.write("            rules: [\n");
      out.write("                Validator.isPhoneNumber('#phoneNumber', 'Phone number at least 10 number'),\n");
      out.write("            ]\n");
      out.write("        })\n");
      out.write("        Validator({\n");
      out.write("            form: '#form-2',\n");
      out.write("            errorSelector: '.form-message',\n");
      out.write("            rules: [\n");
      out.write("                Validator.minLength('#password_new', 6),\n");
      out.write("            ]\n");
      out.write("        })\n");
      out.write("        const imageInput = document.getElementById('imageInput');\n");
      out.write("        const imagePreview = document.getElementById('imagePreview');\n");
      out.write("\n");
      out.write("        imageInput.addEventListener('change', function () {\n");
      out.write("            const file = this.files[0];\n");
      out.write("            if (file) {\n");
      out.write("                const reader = new FileReader();\n");
      out.write("                reader.onload = function (e) {\n");
      out.write("                    imagePreview.src = e.target.result;\n");
      out.write("                    imagePreview.style.display = 'block'; // Hiện ảnh khi file được chọn\n");
      out.write("                };\n");
      out.write("                reader.readAsDataURL(file);\n");
      out.write("            } else {\n");
      out.write("                imagePreview.style.display = 'none'; // Ẩn ảnh nếu không có file nào được chọn\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        const formEditProfile = document.getElementById('form-1');\n");
      out.write("        formEditProfile.addEventListener('submit', (e) => {\n");
      out.write("            const isConfirmed = confirm('Are you sure you want to submit this news?');\n");
      out.write("            if (!isConfirmed) {\n");
      out.write("                event.preventDefault();\n");
      out.write("            }\n");
      out.write("        })\n");
      out.write("    </script>\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.koiCareID != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                   readonly\n");
        out.write("                                               ");
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${KoiIdExist != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <span class=\"error__bk\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${KoiIdExist}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PhoneNumberExist != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <span class=\"error__bk\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PhoneNumberExist}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.gender == 'Man'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.gender == 'Woman'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userAccount.gender == 'Other'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent(null);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${WrongPassword != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <span class=\"error__bk\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${WrongPassword}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>   \n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }
}
