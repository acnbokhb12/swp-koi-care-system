package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageCategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Manage Categories</title>\n");
      out.write("        <!-- link logo img page -->\n");
      out.write("        <link rel=\"icon\" href=\"./assets/img/logo/logoSignin.jpg\" type=\"image/x-icon\" />\n");
      out.write("        <!-- Font gg family -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <!-- font awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css\">\n");
      out.write("        <!-- bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Jquery -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("        <!-- css -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/base.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/navHeader-Footer.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./assets/css/adminCategory.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container_admin\">\n");
      out.write("            <div id=\"db-wrapper\">\n");
      out.write("                <!-- start-sidebar -->\n");
      out.write("                <div id=\"sidebar_admin\"></div>\n");
      out.write("                <!-- start header -->\n");
      out.write("                <header id=\"header\"></header>\n");
      out.write("                <!-- right -->\n");
      out.write("                <div class=\"right-navbar-admin-manage\">\n");
      out.write("                    <!-- Main Content Section -->\n");
      out.write("                    <div class=\"content\">\n");
      out.write("                        <!-- Header with actions -->\n");
      out.write("                        <div class=\"header\">\n");
      out.write("                            <h2>Category List</h2>\n");
      out.write("                            <div class=\"actions\">\n");
      out.write("                                <button id=\"createNewCategory\">Create New Category</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Category Table -->\n");
      out.write("                        <div class=\"table-container\" id=\"categoryTableContainer\">\n");
      out.write("                            <table id=\"categoryTable\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Category ID</th>\n");
      out.write("                                        <th>Category Name</th>\n");
      out.write("                                        <th>Actions</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>#CAT001</td>\n");
      out.write("                                        <td>Food</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <div class=\"actions\">\n");
      out.write("                                                <button class=\"edit-btn\">\n");
      out.write("                                                    <i class=\"fas fa-edit\"></i> Edit Category Name\n");
      out.write("                                                </button>\n");
      out.write("                                                <button class=\"delete-btn\">\n");
      out.write("                                                    <i class=\"fas fa-trash\"></i>\n");
      out.write("                                                </button>\n");
      out.write("                                            </div>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <!-- Footer and Pagination -->\n");
      out.write("                            <div class=\"footer\">\n");
      out.write("                                <div class=\"pagination\">\n");
      out.write("                                    <button><a href=\"\" class=\"text-dark\">Previous</a></button>\n");
      out.write("                                    <button><a href=\"\" class=\"text-dark\">1</a></button>\n");
      out.write("                                    <button><a href=\"\" class=\"text-dark\">Next</a></button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container_main-add\" style=\"display: none;\">\n");
      out.write("            <div class=\"contain_add-detail\">\n");
      out.write("                <form action=\"your-action-url-here\" method=\"POST\" id=\"form_fill-add\">\n");
      out.write("                    <div class=\"row row-add-detail\">\n");
      out.write("                        <div class=\"col-12 edit-info\">\n");
      out.write("                            <div class=\"text-right\">\n");
      out.write("                                <button type=\"button\" class=\"btn-close-add\" aria-label=\"Close\">\n");
      out.write("                                    <i class=\"fa-solid fa-xmark close-navbar-icon-btn-fish\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                            <h2 class=\"text-center\">Create New Category</h2>\n");
      out.write("                            <div class=\"row row-edit-info-detail\">\n");
      out.write("                                <div class=\"col-md-12 add-item-detail\">\n");
      out.write("                                    <label for=\"categoryName\">Category Name:</label>\n");
      out.write("                                    <input id=\"categoryName\" name=\"categoryName\" type=\"text\" placeholder=\"Enter category name\" required />\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"text-center mt-3\">\n");
      out.write("                                <button type=\"submit\" class=\"add-btn-utils blue-btn\">\n");
      out.write("                                    Confirm\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container_main-edit\" style=\"display: none;\">\n");
      out.write("            <div class=\"contain_edit-detail\">\n");
      out.write("                <form action=\"your-action-url-here\" method=\"POST\" id=\"form_fill-edit\">\n");
      out.write("                    <div class=\"row row-edit-detail\">\n");
      out.write("                        <div class=\"col-12 edit-info\">\n");
      out.write("                            <div class=\"text-right\">\n");
      out.write("                                <button type=\"button\" class=\"btn-close-edit\">\n");
      out.write("                                    <i class=\"fa-solid fa-xmark close-navbar-icon-btn-fish\"></i>\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                            <h2 class=\"text-center\">Edit Category</h2>\n");
      out.write("                            <div class=\"row row-edit-info-detail\">\n");
      out.write("                                <div class=\"col-md-12 edit-item-detail\">\n");
      out.write("                                    <label for=\"categoryID\">Category ID:</label>\n");
      out.write("                                    <input id=\"editCategoryID\" name=\"categoryID\" type=\"text\" value=\"123\" readonly />\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-12 edit-item-detail\">\n");
      out.write("                                    <label for=\"categoryName\">Category Name:</label>\n");
      out.write("                                    <input id=\"editCategoryName\" name=\"categoryName\" type=\"text\" placeholder=\"Enter category name\" required />\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"text-center mt-3\">\n");
      out.write("                                <button type=\"submit\" class=\"edit-btn-utils blue-btn\">\n");
      out.write("                                    Confirm\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $('#header').load('utils.jsp #header_admin', () => {\n");
      out.write("                $.getScript('./assets/js/utilsAdmin.js');\n");
      out.write("            });\n");
      out.write("            $('#sidebar_admin').load('utils.jsp #sidebar_manager');\n");
      out.write("\n");
      out.write("            // Add category form submission confirmation\n");
      out.write("            const formAddCategory = document.getElementById('form_fill-add');\n");
      out.write("            formAddCategory.addEventListener('submit', (e) => {\n");
      out.write("                const isConfirmed = confirm('Are you sure you want to submit this category?');\n");
      out.write("                if (!isConfirmed) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            // Open the add category modal\n");
      out.write("            const btnCreateCat = document.getElementById('createNewCategory');\n");
      out.write("            const containerAdd = document.querySelector('.container_main-add');\n");
      out.write("            const closeContainerAdd = document.querySelector('.btn-close-add');\n");
      out.write("\n");
      out.write("            btnCreateCat.addEventListener('click', (e) => {\n");
      out.write("                containerAdd.style.display = 'block';\n");
      out.write("                e.stopPropagation();\n");
      out.write("            });\n");
      out.write("            closeContainerAdd.addEventListener('click', () => {\n");
      out.write("                containerAdd.style.display = 'none';\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            // Open the edit category modal\n");
      out.write("            const containerEdit = document.querySelector('.container_main-edit');\n");
      out.write("            const closeContainerEdit = document.querySelector('.btn-close-edit');\n");
      out.write("\n");
      out.write("            document.querySelectorAll('.edit-btn').forEach(button => {\n");
      out.write("                button.addEventListener('click', (e) => {\n");
      out.write("                    const categoryID = e.target.closest('button').getAttribute('data-category-id');\n");
      out.write("                    const categoryName = e.target.closest('button').getAttribute('data-category-name');\n");
      out.write("                    document.getElementById('editCategoryID').value = categoryID;\n");
      out.write("                    document.getElementById('editCategoryName').value = categoryName;\n");
      out.write("                    containerEdit.style.display = 'block';\n");
      out.write("                    e.stopPropagation();\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            closeContainerEdit.addEventListener('click', () => {\n");
      out.write("                containerEdit.style.display = 'none';\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            // Close modals on document click\n");
      out.write("            document.addEventListener('click', () => {\n");
      out.write("                containerAdd.style.display = 'none';\n");
      out.write("                containerEdit.style.display = 'none';\n");
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
