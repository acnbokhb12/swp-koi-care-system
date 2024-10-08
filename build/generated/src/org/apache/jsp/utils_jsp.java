package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class utils_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Document</title>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Start Admin -->\n");
      out.write("        <div id=\"sidebar_admin\">\n");
      out.write("            <div class=\"left-navbar-admin-manage  vh-100 simplebar-scrollable-y \"> \n");
      out.write("                <div class=\"sidebar\">\n");
      out.write("                    <div class=\"img-header\">\n");
      out.write("                        <div class=\"contain__img-desc\">\n");
      out.write("                            <a href=\"#\" class=\"img-page-admin_link\">\n");
      out.write("                                <img src=\"./assets/img/logo/logoSignin-removebg-preview.png\" alt=\"picture page\"> \n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"desc-img-admin\">\n");
      out.write("                                <p>Koi Care System</p> \n");
      out.write("                            </div>\n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                    <ul class=\"menu\">\n");
      out.write("                        <li><a href=\"#\"><i class=\"fas fa-tachometer-alt\"></i> Dashboard</a></li> \n");
      out.write("                        <li><a href=\"manageUser.jsp\"><i class=\"fas fa-users\"></i> Account Management</a></li> \n");
      out.write("                        <li><a href=\"manageNews.jsp\"><i class=\"fas fa-user-friends\"></i> News Manager</a></li>   \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"header_admin\">\n");
      out.write("            <div class=\"topbar d-flex align-items-center\">\n");
      out.write("                <nav class=\"navbar navbar-expand gap-3\">\n");
      out.write("                    <!-- search -->\n");
      out.write("                    <div class=\"form-control-admin position-relative   \">\n");
      out.write("                        <form action=\"\">\n");
      out.write("                            <input type=\"text\" class=\"search-control-admin\" placeholder=\"Search\">\n");
      out.write("                            <span >\n");
      out.write("                                <i class=\"fas fa-search\"></i>\n");
      out.write("                            </span>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- list icon moon -->\n");
      out.write("                    <div class=\"top-menu mr-3 ml-auto\">\n");
      out.write("                        <ul class=\"navbar-nav align-items-center gap-1\">\n");
      out.write("                            <li class=\"nav-item mobile-search-icon d-flex \">\n");
      out.write("                                <a href=\"#\" class=\"nav-link dark-mode-icon\">\n");
      out.write("                                    <i class=\"fa-regular fa-moon\"></i>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- avatar -->\n");
      out.write("                    <div class=\"manager-box dropdown gap-3 px-3\">\n");
      out.write("                        <a href=\"#\" class=\"d-flex align-items-center nav-link click_btn-subnav  gap-3   \">\n");
      out.write("                            <img src=\"https://scontent.fsgn2-3.fna.fbcdn.net/v/t1.6435-9/120846118_1393138717744114_5343318628172679837_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=1d70fc&_nc_ohc=HRW0w38pbEQQ7kNvgF_Y1rD&_nc_ht=scontent.fsgn2-3.fna&_nc_gid=ARzB8qdQeV6A2gtFkV7lUga&oh=00_AYDhskM-yEdWNkPKeY4tujMz6Vwn07AZEpNMCJn3qOn-hA&oe=67242460\" class=\"manage-img\" alt=\"\">\n");
      out.write("                            <div class=\"manage-info\">\n");
      out.write("                                <!-- name manage - admin -->\n");
      out.write("                                <p class=\"manage-name mb-0\">Khanh Huynh</p>\n");
      out.write("                                <!-- role -->\n");
      out.write("                                <p class=\"role designattion mb-0\">Admin</p>    \n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"col-auto app-box-admin\">\n");
      out.write("                            <div class=\"box-admin\">\n");
      out.write("                                <!-- <div class=\"welcome-admin\" style=\"display: none;\">\n");
      out.write("                                <i class=\"fa-solid fa-user\"></i> Khanhhn\n");
      out.write("                                </div> -->\n");
      out.write("                                <div class=\"modal-more-info\">\n");
      out.write("                                    <ul class=\"modal-more-info-list\">\n");
      out.write("                                        <li class=\"modal-more-info-items\">\n");
      out.write("                                            <a href=\"#\">Profile</a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"modal-more-info-items\">\n");
      out.write("                                            <a href=\"#\">Log out</a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- End Admin -->\n");
      out.write("\n");
      out.write("        <!-- Sidebar admin -->\n");
      out.write("        <div id=\"sidebar_manager\"> \n");
      out.write("            <div class=\"left-navbar-admin-manage  vh-100 simplebar-scrollable-y \"> \n");
      out.write("                <div class=\"sidebar\">\n");
      out.write("                    <div class=\"img-header\">\n");
      out.write("                        <div class=\"contain__img-desc\">\n");
      out.write("                            <a href=\"#\" class=\"img-page-admin_link\">\n");
      out.write("                                <img src=\"./assets/img/logo/logoSignin-removebg-preview.png\" alt=\"picture page\"> \n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"desc-img-admin\">\n");
      out.write("                                <p>Koi Care System</p> \n");
      out.write("                            </div>\n");
      out.write("                        </div> \n");
      out.write("                    </div>\n");
      out.write("                    <ul class=\"menu\">\n");
      out.write("                        <li><a href=\"#\"><i class=\"fas fa-tachometer-alt\"></i> Dashboard</a></li>\n");
      out.write("                        <li><a href=\"manageCategory.jsp\"><i class=\"fa-solid fa-tags\"></i> Category Manager</a></li>\n");
      out.write("                        <li><a href=\"manageProduct.jsp\"><i class=\"fa-solid fa-warehouse\"></i> Product Manager</a></li> \n");
      out.write("                        <li><a href=\"manageOrder.jsp\"><i class=\"fa-solid fa-cart-shopping\"></i> Order Manager</a></li>  \n");
      out.write("                        <li><a href=\"manageFish.jsp\"><i class=\"fa-solid fa-fish\"></i>Fish Management</a></li>   \n");
      out.write("                        <li><a href=\"#\"><i class=\"fa-solid fa-water\"></i>Water Parameter Management</a></li>   \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Start Customer -->\n");
      out.write("        <header id=\"header__nav\">\n");
      out.write("            <!-- section-1 sub_header -->\n");
      out.write("            <section class=\"sub__header-top\">\n");
      out.write("                <div class=\"container__header-top\">\n");
      out.write("                    <div class=\"container__iner-fi\">\n");
      out.write("                        <div class=\"row row__sub_header_top\">\n");
      out.write("                            <div class=\"col-6 padding__top-header\">\n");
      out.write("                                <div class=\"left__content\">\n");
      out.write("                                    <!-- phone - email of web -->\n");
      out.write("                                    <ul class=\"left__content-infor-list\">\n");
      out.write("                                        <li class=\"left__content-infor-item\">\n");
      out.write("                                            <i class=\"fa-solid fa-phone\"></i>0987654321\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"left__content-infor-item \">\n");
      out.write("                                            <i class=\"fa-solid fa-envelope\"></i>acnbokhb12@gmail.com\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-6  padding__top-header\">\n");
      out.write("                                <div class=\"right-content\">\n");
      out.write("                                    <!-- List icon follow -->\n");
      out.write("                                    <ul class=\"right__content-icon-list\">\n");
      out.write("                                        <li class=\"right__content-icon-item\">\n");
      out.write("                                            <p>\n");
      out.write("                                                Folow us:\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"right__content-icon-item\">\n");
      out.write("                                            <a href=\"#\"><i class=\"fa-brands fa-facebook-f\"></i></a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"right__content-icon-item\">\n");
      out.write("                                            <a href=\"#\"><i class=\"fa-brands fa-instagram\"></i></a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"right__content-icon-item\">\n");
      out.write("                                            <a href=\"#\"><i class=\"fa-brands fa-x-twitter\"></i></a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"right__content-icon-item\">\n");
      out.write("                                            <a href=\"#\"><i class=\"fa-brands fa-pinterest\"></i></a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"right__content-icon-item\">\n");
      out.write("                                            <a href=\"#\"><i class=\"fa-brands fa-discord\"></i></a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"right__content-icon-item\">\n");
      out.write("                                            <a href=\"#\"><i class=\"fa-brands fa-youtube\"></i></a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("            <!-- section-2 main_header -->\n");
      out.write("            <section class=\"main__header-bottom\">\n");
      out.write("                <div class=\"containers  padding__top-header\">\n");
      out.write("                    <div class=\"container__iner-se\">\n");
      out.write("                        <div class=\"row row__iner-se\">\n");
      out.write("                            <!-- Logo -->\n");
      out.write("                            <a href=\"home.html\" class=\"col-lg-2 link_logo-home\">\n");
      out.write("                                <img src=\"./assets/img/logo/Logo_Koi_Care.png\" alt=\"Logo_System\">\n");
      out.write("                            </a>\n");
      out.write("                            <!-- button for responsive -->\n");
      out.write("                            <button class=\"hamburger__icon-btn\">\n");
      out.write("                                <i class=\"fa-solid fa-bars\"></i>\n");
      out.write("                            </button>\n");
      out.write("                            <!-- task main common -->\n");
      out.write("                            <div class=\"col-lg-10 header__right__task nav-bar-menu\">\n");
      out.write("                                <span class=\"close__navbar-header\"><i class=\"fa-solid fa-xmark close-navbar-icon-btn\"></i></span>\n");
      out.write("                                <div class=\"contain__list-nav\">\n");
      out.write("                                    <ul class=\"contain__list-nav-detail\">\n");
      out.write("                                        <li class=\"contain__item-nav\">\n");
      out.write("                                            <a href=\"home.jsp\" class=\"contain__item-nav-link\">\n");
      out.write("                                                <span>Home</span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"contain__item-nav\">\n");
      out.write("                                            <a href=\"about.jsp\" class=\"contain__item-nav-link\">\n");
      out.write("                                                <span>About</span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"contain__item-nav\">\n");
      out.write("                                            <a href=\"shop.jsp\" class=\"contain__item-nav-link\">\n");
      out.write("                                                <span>Shop</span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"contain__item-nav contain__item-nav-open\">\n");
      out.write("                                            <a href=\"news.jsp\" class=\"contain__item-nav-link\">\n");
      out.write("                                                <span>News <i class=\"fa-solid fa-chevron-down ml-1\"></i></span>\n");
      out.write("                                            </a>\n");
      out.write("                                            <div class=\"contain__sub-item_nav-link\">\n");
      out.write("                                                <ul class=\"contain__sub-item_nav-list\">\n");
      out.write("                                                    <li class=\"contain__sub-item_nav-items\">\n");
      out.write("                                                        <a href=\"blogs.jap\">Blogs</a>\n");
      out.write("                                                    </li>\n");
      out.write("                                                    <li class=\"contain__sub-item_nav-items\">\n");
      out.write("                                                        <a href=\"news.jsp\">News</a>\n");
      out.write("                                                    </li>\n");
      out.write("\n");
      out.write("                                                </ul>\n");
      out.write("                                            </div>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class=\"contain__item-nav\">\n");
      out.write("                                            <a href=\"contact.jsp\" class=\"contain__item-nav-link\">\n");
      out.write("                                                <span>Contact</span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li> \n");
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- task user -->\n");
      out.write("                                <div class=\"contain__task-user\">\n");
      out.write("                                    <div class=\"header__task-right\">\n");
      out.write("                                        <a href=\"#\" class=\"header__link-task d-flex align-end\">\n");
      out.write("                                            <span class=\"header__link-task-icon\"><i\n");
      out.write("                                                    class=\"fa-regular fa-bell\"></i></span>\n");
      out.write("                                            <span class=\"text-label text-uppercase\">Alerts</span> \n");
      out.write("                                        </a>\n");
      out.write("                                        <a href=\"cart.jsp\" class=\"header__link-task d-flex align-end\">\n");
      out.write("                                            <span class=\"header__link-task-icon\"><i\n");
      out.write("                                                    class=\"fa-solid fa-bag-shopping\"></i></span>\n");
      out.write("                                            <span class=\"text-label text-uppercase \">Cart</span>\n");
      out.write("                                        </a>\n");
      out.write("                                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("            </section>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <footer id=\"footer__nav\">\n");
      out.write("            <div class=\"container__img-footer-main\">\n");
      out.write("                <div class=\"container__img-pd\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"container__footer-desc-area row\">\n");
      out.write("                            <div class=\"footer-desc-item col-sm-6 col-lg-4\">\n");
      out.write("                                <a href=\"#\" class=\"footer-desc-item-img\">\n");
      out.write("                                    <img src=\"./assets/img/logo/Logo_Koi_Care.png\" alt=\"\">\n");
      out.write("                                </a>\n");
      out.write("                                <p class=\"desc-footer-infor\">\n");
      out.write("                                    <i class=\"fa-solid fa-location-dot\"></i>  Student Culture House, 643 dien Bien Phu, Phuong 1, Quan 3, HCM\n");
      out.write("                                </p>\n");
      out.write("                                <p class=\"desc-footer-infor\">\n");
      out.write("                                    <i class=\"fa-solid fa-phone\" style=\"margin-right: 0.4rem;\"></i> +84 1234 567 890\n");
      out.write("                                </p>\n");
      out.write("                                <p class=\"desc-footer-infor\">\n");
      out.write("                                    <i class=\"fa-solid fa-envelope\"style=\"margin-right: 0.4rem;\"></i> acnbokhb12@gmail.com\n");
      out.write("\n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"footer-desc-item col-sm-6 col-lg-3\">\n");
      out.write("                                <h2>Opening time</h2>\n");
      out.write("                                <div class=\"footer-desc-item-time\">\n");
      out.write("                                    Monday- Tuesday\n");
      out.write("                                    <span>\n");
      out.write("                                        <i>10:10</i> am - <i>11:00</i> pm\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"footer-desc-item-time\">\n");
      out.write("                                    <p class=\"\">Monday- Tuesday</p>\n");
      out.write("                                    <span>\n");
      out.write("                                        <i>10:10</i> am - <i>11:00</i> pm\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"footer-desc-item col-sm-6 col-lg-2\">\n");
      out.write("                                <h2>Menu</h2>\n");
      out.write("                                <a href=\"\" class=\"link__footer-nav\">Home</a>\n");
      out.write("                                <a href=\"\" class=\"link__footer-nav\">About</a>\n");
      out.write("                                <a href=\"\" class=\"link__footer-nav\">Shop</a>\n");
      out.write("                                <a href=\"\" class=\"link__footer-nav\">Contact</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"footer-desc-item col-sm-6 col-lg-3\">\n");
      out.write("                                <h2>Intagram feed</h2>\n");
      out.write("                                <p>Don’t miss any updates all the astonishing offers we bring for you.</p>\n");
      out.write("                                <div class=\"footer-desc-item-mess\">\n");
      out.write("                                    <form action=\"\">\n");
      out.write("                                        <input type=\"text\" placeholder=\"E-mail\" required>\n");
      out.write("                                        <button type=\"submit\">Subcribe</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"container__footer-desc-bottom\">\n");
      out.write("                            <div class=\"footer-desc-bottom-left\">\n");
      out.write("                                <p>© 2024 Service is powered by <i>Koi Care System</i>. The property of their owners.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"footer-desc-bottom-right\">\n");
      out.write("                                <ul class=\"list__icon__footer\">\n");
      out.write("                                    <li class=\"item__con__footer\">\n");
      out.write("                                        <a href=\"#\"><i class=\"fa-brands fa-instagram\"></i></a>\n");
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"item__con__footer\">\n");
      out.write("                                        <a href=\"#\"><i class=\"fa-brands fa-google\"></i></a>\n");
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"item__con__footer\">\n");
      out.write("                                        <a href=\"#\"><i class=\"fa-brands fa-discord\"></i></a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"item__con__footer\">\n");
      out.write("                                        <a href=\"#\"><i class=\"fa-brands fa-twitch\"></i></a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"item__con__footer\">\n");
      out.write("                                        <a href=\"#\"><i class=\"fa-brands fa-youtube\"></i></a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <!-- End Customer -->\n");
      out.write("    </body>     \n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty sessionScope.customer}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <a href=\"login.jsp\" class=\"header__link-task d-flex align-end\">\n");
        out.write("                                                <span class=\"header__link-task-icon\"><i class=\"fa-regular fa-user\"></i></span>\n");
        out.write("                                                <span class=\"text-label text-uppercase\">Sign in</span>\n");
        out.write("                                            </a>\n");
        out.write("                                        ");
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty sessionScope.customer}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <div class=\"header__link-account d-flex align-end\">\n");
        out.write("                                                <div class=\"header__link-task-img-acc\">\n");
        out.write("                                                    <img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.customer.profileImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" alt=\"User Profile Image\">\n");
        out.write("                                                    <div class=\"header__link-task-description\">\n");
        out.write("                                                        <div class=\"header__link-task-container\">\n");
        out.write("                                                            <div class=\"welcome__acc-header\">\n");
        out.write("                                                                <p class=\"dddssd\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.customer.fullName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                                                                <a href=\"profilePage.jsp\" class=\"view__detail_acc\">\n");
        out.write("                                                                    <i class=\"fa-solid fa-file-invoice\"></i> My Account\n");
        out.write("                                                                </a>\n");
        out.write("                                                            </div>\n");
        out.write("                                                            <div class=\"welcome__acc-body\">\n");
        out.write("                                                                <ul class=\"body__link-acount-list-item\"> \n");
        out.write("                                                                    <li class=\"body__link-acount-detail-item\">\n");
        out.write("                                                                        <a href=\"fish.jsp\">\n");
        out.write("                                                                            <i class=\"fa-solid fa-fish\"></i> My Koi\n");
        out.write("                                                                        </a>\n");
        out.write("                                                                    </li>\n");
        out.write("                                                                    <li class=\"body__link-acount-detail-item\">\n");
        out.write("                                                                        <a href=\"pond.jsp\">\n");
        out.write("                                                                            <i class=\"fa-regular fa-circle\"></i> My Pond\n");
        out.write("                                                                        </a>\n");
        out.write("                                                                    </li>\n");
        out.write("                                                                    <li class=\"body__link-acount-detail-item\">\n");
        out.write("                                                                        <a href=\"#\">\n");
        out.write("                                                                            <i class=\"fa-solid fa-droplet\"></i> Water Parameters\n");
        out.write("                                                                        </a>\n");
        out.write("                                                                    </li>\n");
        out.write("                                                                    <li class=\"body__link-acount-detail-item\">\n");
        out.write("                                                                        <a href=\"purchaseHistory.jsp\">\n");
        out.write("                                                                            <i class=\"fa-solid fa-receipt\"></i> Purchase History\n");
        out.write("                                                                        </a>\n");
        out.write("                                                                    </li>\n");
        out.write("\n");
        out.write("                                                                </ul>\n");
        out.write("                                                            </div>\n");
        out.write("                                                            <div class=\"welcome__acc-footer\">\n");
        out.write("                                                                <ul class=\"footer__link-acount-list-item\">\n");
        out.write("                                                                    <li class=\"footer__link-acount-detail-item\">\n");
        out.write("                                                                        <a href=\"#\">\n");
        out.write("                                                                            <i class=\"fas fa-sign-out\"></i> Log out\n");
        out.write("                                                                        </a>\n");
        out.write("                                                                    </li>\n");
        out.write("\n");
        out.write("                                                                    <li class=\"footer__link-acount-detail-item\">\n");
        out.write("                                                                        <a href=\"#\">\n");
        out.write("                                                                            <i class=\"fa-regular fa-circle-question\"></i> Support\n");
        out.write("                                                                        </a>\n");
        out.write("                                                                    </li>\n");
        out.write("                                                                </ul>\n");
        out.write("                                                            </div>\n");
        out.write("                                                        </div>\n");
        out.write("                                                    ");
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
}
