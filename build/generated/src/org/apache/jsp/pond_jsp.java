package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pond_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Koi Fish Ponds</title>\n");
      out.write("        <!-- link logo img page -->\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("        <!-- Font gg family -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\"\n");
      out.write("              rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n");
      out.write("        <!-- Font icon --> \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("        <!-- bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/pondkoi.css\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"pond-background\">\n");
      out.write("        <!-- start header -->\n");
      out.write("        <div id=\"header\"></div>\n");
      out.write("        <!-- end header -->\n");
      out.write("        <div class=\"container container_pond\">\n");
      out.write("            <div class=\"tilte-ponds\"> \n");
      out.write("                <h1>Koi Fish Ponds</h1>\n");
      out.write("                <div class=\"button-container\"> \n");
      out.write("                    <button class=\"btn edit-btn-out\">Add New Pond</button>\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            <div class=\"row pond-list\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- TABLE EDIT -->\n");
      out.write("        <div class=\"container__infor__pond\">\n");
      out.write("            <div class=\"infor__pond-detail\">\n");
      out.write("                <form action=\"MainController?action=newpond\" method=\"post\" enctype=\"multipart/form-data\" id=\"fomr_fill-news\" > \n");
      out.write("                    <div class=\"row row-pond-detail\">\n");
      out.write("                        <div class=\"col-4\" style=\"padding: 0;\">\n");
      out.write("                            <div class=\"img-edit-submit\">\n");
      out.write("                                <div class=\"pond-img-info-edit\">\n");
      out.write("                                    <img id=\"imagePreview\" src=\"https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg\" alt=\"Koi Pond\" > \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"pond-edit-img-detail\" > \n");
      out.write("                                    <input id=\"imageInput\" name=\"fileimg\" type=\"file\" accept=\"image/*\" required> \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-8 edit-info\">\n");
      out.write("                            <div class=\"text-right\">\n");
      out.write("                                <button\n");
      out.write("                                    class=\"btn-close-pond\"><i class=\"fa-solid fa-xmark close-navbar-icon-btn-pond\"></i>\n");
      out.write("                                </button>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <h2>Add new pond</h2>\n");
      out.write("                            <div class=\"row row-edit-info-detail\">\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Pond Name: </span>\n");
      out.write("                                    <input type=\"text\" class=\"pond-name\" name=\"pondName\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Depth (m): </span>\n");
      out.write("                                    <input type=\"number\" class=\"pond-depth\" name=\"depth\" step=\"0.1\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Volume (l): </span>\n");
      out.write("                                    <input type=\"number\" class=\"pond-volume\" name=\"volume\" min=\"0\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Drain Count: </span>\n");
      out.write("                                    <input type=\"number\" class=\"drain-count\" name=\"drainCount\" min=\"1\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Pump Power (l/h): </span>\n");
      out.write("                                    <input type=\"number\" class=\"pump-power\" name=\"pumpPower\" min=\"1\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Quantity of Fish: </span>\n");
      out.write("                                    <input type=\"number\" class=\"quantity-fish\" name=\"numberOfFish\" min=\"0\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Description: </span>\n");
      out.write("                                    <input type=\"text\" class=\"pond-description\" name=\"descriptionPond\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 edit-item-detail\">\n");
      out.write("                                    <span>Skimmer: </span>\n");
      out.write("                                    <input type=\"number\" class=\"skimmer\" name=\"skimmer\" min=\"0\" placeholder=\"Enter skimmer quantity\" required>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                        <button class=\"edit-btn\" type=\"submit\" style=\"margin-top: 10px; \">\n");
      out.write("                            Confirm\n");
      out.write("                        </button>\n");
      out.write("                    </div> \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("<!-- Modal Delete -->\n");
      out.write("<div id=\"myModal\" class=\"modal-confirm-delete\">\n");
      out.write("    <div class=\"modal-confirm\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header flex-column\">\n");
      out.write("                <div class=\"icon-box\">\n");
      out.write("                    <i class=\"material-icons\">&#xE5CD;</i>\n");
      out.write("                </div>\n");
      out.write("                <h4 class=\"modal-title w-100\">Are you sure?</h4>\n");
      out.write("                <button type=\"button\" class=\"close-confirm-delete close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <p>Do you really want to delete this pond? This process cannot be undone.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer justify-content-center\">\n");
      out.write("                <button type=\"button\" class=\"btn-cancel-delete btn btn-secondary\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("                <form id=\"deleteForm\" action=\"MainController?action=ponddelete\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"pondID\" id=\"pondIDToDelete\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-danger\">Delete</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div id=\"footer\"></div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("<script>\n");
      out.write("    $('#header').load('utils.jsp #header__nav', () => {\n");
      out.write("        $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("    });\n");
      out.write("    $('#footer').load('utils.jsp #footer__nav', () => {\n");
      out.write("        $.getScript('./assets/js/utilsCustomer.js');\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("    const btnClose = document.querySelector('.btn-close-pond');\n");
      out.write("    const tableEdit = document.querySelector('.container__infor__pond');\n");
      out.write("    const btnOutOpen = document.querySelector('.edit-btn-out');\n");
      out.write("    const subTable = document.querySelector('.infor__pond-detail');\n");
      out.write("\n");
      out.write("    btnOutOpen.addEventListener('click', function (e) {\n");
      out.write("        tableEdit.classList.add('open');\n");
      out.write("        e.stopPropagation();\n");
      out.write("    });\n");
      out.write("    btnClose.addEventListener('click', () => {\n");
      out.write("        tableEdit.classList.remove('open');\n");
      out.write("    });\n");
      out.write("    subTable.addEventListener('click', (e) => {\n");
      out.write("        e.stopPropagation();\n");
      out.write("    });\n");
      out.write("    document.addEventListener('click', () => {\n");
      out.write("\n");
      out.write("        tableEdit.classList.remove('open');\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function () {\n");
      out.write("        $('#myModal').hide();\n");
      out.write("        $('.link-delete-pond').on('click', function () {\n");
      out.write("            const pondID = $(this).data('pondid');\n");
      out.write("            $('#pondIDToDelete').val(pondID);\n");
      out.write("            $('#myModal').show();\n");
      out.write("        });\n");
      out.write("        $('.close-confirm-delete, .btn-cancel-delete').on('click', function () {\n");
      out.write("            $('#myModal').hide();\n");
      out.write("        });\n");
      out.write("        $(window).on('click', function (event) {\n");
      out.write("            if (event.target.id === 'myModal') {\n");
      out.write("                $('#myModal').hide();\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("<script src=\"./assets/js/utils.js\"></script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listPonds}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("po");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <div class=\"col-md-4 col-sm-6\"> \n");
          out.write("                        <div class=\"pond-item\">\n");
          out.write("                            <div class=\"pond-item-detail\">\n");
          out.write("                                <div class=\"pond-img-detail\">\n");
          out.write("                                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${po.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${po.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                </div>\n");
          out.write("                                <div class=\"pond-info\">\n");
          out.write("                                    <a href=\"PondInforController?pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${po.pondID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"link__to-pond-detail\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${po.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                                    <p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${po.descriptionPond}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                    <a href=\"#\" class=\"link-delete-pond\" data-pondid=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${po.pondID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" data-toggle=\"modal\" data-target=\"#myModal\">Delete</a>\n");
          out.write("                                </div>\n");
          out.write("                            </div>\n");
          out.write("                        </div>\n");
          out.write("                    </div>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
