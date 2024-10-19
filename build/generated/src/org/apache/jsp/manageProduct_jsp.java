package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_end_begin.release();
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
      out.write(" >\n");
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
      out.write("\n");
      out.write("        <div class=\"container_admin\">\n");
      out.write("            <div id=\"db-wrapper\">\n");
      out.write("                <!-- start-sidebar -->\n");
      out.write("                <div id=\"sidebar_admin\"></div>\n");
      out.write("                <!-- start header -->\n");
      out.write("                <header id=\"header\"> </header>\n");
      out.write("                <!-- right -->\n");
      out.write("                <div class=\"right-navbar-admin-manage\"> \n");
      out.write("\n");
      out.write("                    <!-- Main Content Section -->\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <!-- Header with actions -->\n");
      out.write("                        <div class=\"header\">\n");
      out.write("                            <h2>Product List</h2>\n");
      out.write("                            <div class=\"actions\"> \n");
      out.write("                                <button id=\"createNewProduct\">Create New Product</button> \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!--  -->\n");
      out.write("                        <div class=\"row row-user-main\"> \n");
      out.write("                            <div class=\"col-auto\">\n");
      out.write("                                <form class=\"table-search-form row gx-1 align-items-center\" action=\"\">\n");
      out.write("                                    <div class=\"col-auto\">\n");
      out.write("                                        <input type=\"text\" class=\"search-order\" placeholder=\"Search...\" id=\"searchInput\" required>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-auto contain-btn-select-order\">\n");
      out.write("                                        <select class=\"contain-btn-select-search\" name=\"searchChoice\" id=\"searchChoice\" onchange=\"handleSearchChoice()\">\n");
      out.write("                                            <option value=\"name\" selected>Product Name</option>\n");
      out.write("                                            <option value=\"category\">Category</option>\n");
      out.write("                                            <option value=\"price\">Price</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Các trường Min và Max Price được hiển thị kế bên khi chọn \"Price\" -->\n");
      out.write("                                    <div class=\"col-auto contain-price-range\" id=\"priceRange\" style=\"display:none;\">\n");
      out.write("                                        <input type=\"number\" class=\"search-order\" id=\"minPrice\" placeholder=\"Min Price\" name=\"minPrice\">\n");
      out.write("                                        <input type=\"number\" class=\"search-order\" id=\"maxPrice\" placeholder=\"Max Price\" name=\"maxPrice\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-auto contain-btn-search-order\">\n");
      out.write("                                        <button class=\"btn-submit-search-order\" type=\"submit\">Search</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Product Table -->\n");
      out.write("                        <div class=\"table-container\" id=\"productTableContainer\">\n");
      out.write("                            <table id=\"productTable\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Product ID</th>\n");
      out.write("                                        <th>Name</th>\n");
      out.write("                                        <th>Image</th> \n");
      out.write("                                        <th>Category</th> \n");
      out.write("                                        <th>Price</th>\n");
      out.write("                                        <th>Actions</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>#PD12387</td>\n");
      out.write("                                        <td>Example Product</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <img src=\"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp\" alt=\"Image of Example Product\" />\n");
      out.write("                                        </td> \n");
      out.write("                                        <td>Category Name</td> \n");
      out.write("                                        <td>$19.99</td>\n");
      out.write("                                        <td> \n");
      out.write("                                            <button class=\"edit-btn\" onclick=\"window.location.href = 'manageProductDetails.jsp'\">\n");
      out.write("                                                <i class=\"fas fa-edit\"></i>\n");
      out.write("                                            </button>\n");
      out.write("                                            <button class=\"delete-btn\">\n");
      out.write("                                                <i class=\"fas fa-trash\"></i>\n");
      out.write("                                            </button>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>#PD12387</td>\n");
      out.write("                                        <td>Example Product</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <img src=\"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp\" alt=\"Image of Example Product\" />\n");
      out.write("                                        </td> \n");
      out.write("                                        <td>Category Name</td> \n");
      out.write("                                        <td>$19.99</td>\n");
      out.write("                                        <td> \n");
      out.write("                                            <button class=\"edit-btn\" onclick=\"window.location.href = 'manageProductDetails.jsp'\">\n");
      out.write("                                                <i class=\"fas fa-edit\"></i>\n");
      out.write("                                            </button>\n");
      out.write("                                            <button class=\"delete-btn\">\n");
      out.write("                                                <a href=\"#\"  class=\"text-danger\"> \n");
      out.write("                                                    <i class=\"fas fa-trash\"></i>\n");
      out.write("                                                </a>\n");
      out.write("                                            </button>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("                            <!-- Footer and Pagination -->\n");
      out.write("                            <div class=\"footer\">\n");
      out.write("                                <div class=\"pagination\" >\n");
      out.write("                                    <button><a href=\"\" class=\"text-dark\">Previous</a></button>\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    <button><a href=\"\" class=\"text-dark\">Next</a></button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Table adn new product -->\n");
      out.write("        <div class=\"container_main-add\">\n");
      out.write("            <div class=\"contain_add-detail\">\n");
      out.write("                <form action=\"\" id=\"fomr_fill-add\">\n");
      out.write("                    <div class=\"row row-add-detail\"> \n");
      out.write("                        <div class=\"col-4 \" >\n");
      out.write("                            <div class=\"img-add-submit\">\n");
      out.write("                                <div class=\"img-info-add\">\n");
      out.write("                                    <img id=\"imagePreview\" src=\"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp\" alt=\"Koi Pond\" > \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"add-img-detail\"> \n");
      out.write("                                    <input id=\"imageInput\" type=\"file\" required> \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-8 edit-info\">\n");
      out.write("                            <div class=\"text-right\">\n");
      out.write("                                <button  class=\"btn-close-add\">\n");
      out.write("                                    <i class=\"fa-solid fa-xmark close-navbar-icon-btn-fish\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                            <h2 class=\"text-center\">Create New Product</h2>\n");
      out.write("                            <form action=\"\" class=\"fomr_fill-add\">\n");
      out.write("                                <div class=\"row row-edit-info-detail\">\n");
      out.write("                                    <div class=\"col-md-6 add-item-detail\">\n");
      out.write("                                        <label for=\"name_p\" >Product Name: </label >\n");
      out.write("                                        <input id=\"name_p\" type=\"text\" value=\"\" placeholder=\"Enter name\" required />\n");
      out.write("                                    </div> \n");
      out.write("                                    <div class=\"col-md-6 add-item-detail\">\n");
      out.write("                                        <label for=\"price_p\" >Product Price: </label >\n");
      out.write("                                        <input id=\"price_p\" type=\"number\" value=\"\" placeholder=\"Enter price\" required/>\n");
      out.write("                                    </div>  \n");
      out.write("                                    <div class=\"col-md-6 add-item-detail\">\n");
      out.write("                                        <label for=\"\" >Category </label >\n");
      out.write("                                        <select class=\"add-item-detail-select\"> \n");
      out.write("                                            <option selected value=\"\">Food</option>\n");
      out.write("                                            <option value=\"\">Medicine</option>\n");
      out.write("                                            <option value=\"\">Machine</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div> \n");
      out.write("                                    <div class=\"col-md-6 add-item-detail\">\n");
      out.write("                                        <label for=\"desc_p\">Description: </label>\n");
      out.write("                                        <input id=\"desc_p\" type=\"text\" value=\"\" placeholder=\"Description\" required /> \n");
      out.write("                                    </div>  \n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"text-center mt-3\">\n");
      out.write("                                    <button type=\"submit\" class=\"add-btn-utils blue-btn\" style=\"margin-top: 10px\">\n");
      out.write("                                        Confirm\n");
      out.write("                                    </button>                    \n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form> \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        $('#header').load('utils.jsp #header_admin', () => {\n");
      out.write("            $.getScript('./assets/js/utilsAdmin.js');\n");
      out.write("        });\n");
      out.write("        $('#sidebar_admin').load('utils.jsp  #sidebar_manager');\n");
      out.write("\n");
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
      out.write("        const formAddProduct = document.getElementById('fomr_fill-add');\n");
      out.write("        formAddProduct.addEventListener('submit', (e) => {\n");
      out.write("            const isConfirmed = confirm('Are you sure you want to submit this news?');\n");
      out.write("            if (!isConfirmed) {\n");
      out.write("                event.preventDefault();\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        const btnCreatPr = document.getElementById('createNewProduct');\n");
      out.write("        const containerAdd = document.querySelector('.container_main-add');\n");
      out.write("        const closeContainerAdd = document.querySelector('.btn-close-add');\n");
      out.write("        const subContainerAdd = document.querySelector('.contain_add-detail')\n");
      out.write("                ;\n");
      out.write("        btnCreatPr.addEventListener('click', (e) => {\n");
      out.write("            containerAdd.classList.add('open');\n");
      out.write("            e.stopPropagation();\n");
      out.write("        });\n");
      out.write("        closeContainerAdd.addEventListener('click', () => {\n");
      out.write("            containerAdd.classList.remove('open');\n");
      out.write("        });\n");
      out.write("        subContainerAdd.addEventListener('click', (e) => {\n");
      out.write("            e.stopPropagation();\n");
      out.write("        });\n");
      out.write("        document.addEventListener('click', () => {\n");
      out.write("            containerAdd.classList.remove('open');\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        function handleSearchChoice() {\n");
      out.write("            const searchChoice = document.getElementById(\"searchChoice\").value;\n");
      out.write("            const priceRange = document.getElementById(\"priceRange\");\n");
      out.write("\n");
      out.write("            if (searchChoice === \"price\") {\n");
      out.write("                priceRange.style.display = \"flex\"; // Hiện các trường Min và Max Price kế bên\n");
      out.write("            } else {\n");
      out.write("                priceRange.style.display = \"none\"; // Ẩn khi không chọn \"Price\"\n");
      out.write("            }\n");
      out.write("        }\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setBegin(1);
    _jspx_th_c_forEach_0.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${endPage}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_0.setVar("i");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                        <button><a href=\"\"  class=\"text-dark\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${endPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></button>\n");
          out.write("                                    ");
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
      _jspx_tagPool_c_forEach_var_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
