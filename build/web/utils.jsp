<%-- 
    Document   : utils
    Created on : Oct 3, 2024, 3:22:36 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        <!-- Start Admin -->
        <div id="sidebar_admin">
            <div class="left-navbar-admin-manage  vh-100 simplebar-scrollable-y "> 
                <div class="sidebar">
                    <div class="img-header">
                        <div class="contain__img-desc">
                            <a href="MainController?action=dashboardAdmin" class="img-page-admin_link">
                                <img src="./assets/img/logo/logoSignin-removebg-preview.png" alt="picture page"> 
                            </a>
                            <div class="desc-img-admin">
                                <p>Koi Care System</p> 
                            </div>
                        </div> 
                    </div>
                    <ul class="menu">
                        <li><a href="MainController?action=dashboardAdmin"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li> 
                        <li><a href="MainController?action=adminAccount"><i class="fas fa-users"></i> Account Management</a></li> 
                        <li><a href="MainController?action=adminNews"><i class="fa-solid fa-newspaper"></i>News Management</a></li>   
                        <li><a href="MainController?action=adminManageContact"><i class="fa-solid fa-clipboard"></i>Contact Management</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="header_admin">
            <div class="topbar d-flex align-items-center">
                <nav class="navbar navbar-expand gap-3">
                    <!-- search -->
                    <div class="form-control-admin position-relative   ">
                        <form action="">
                            <input type="text" class="search-control-admin" placeholder="Search">
                            <span >
                                <i class="fas fa-search"></i>
                            </span>
                        </form>
                    </div>
                    <!-- list icon moon -->
                    <div class="top-menu mr-3 ml-auto">
                        <ul class="navbar-nav align-items-center gap-1">
                            <li class="nav-item mobile-search-icon d-flex ">
                                <a href="MainController?action=home" class="nav-link dark-mode-icon">
                                    <i class="fa-solid fa-house"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- avatar -->
                    <div class="manager-box dropdown gap-3 px-3">
                        <a href="#" class="d-flex align-items-center nav-link click_btn-subnav  gap-3   ">
                            <img src="${sessionScope.userAccount.profileImage}" class="manage-img" alt="">
                            <div class="manage-info">
                                <!-- name manage - admin -->
                                <p class="manage-name mb-0">${sessionScope.userAccount.fullName}</p>
                                <!-- role -->
                                <p class="role designattion mb-0">${sessionScope.userAccount.userRole}</p>    
                            </div>
                        </a>
                        <div class="col-auto app-box-admin">
                            <div class="box-admin">
                                <!-- <div class="welcome-admin" style="display: none;">
                                    <i class="fa-solid fa-user"></i> Khanhhn
                                </div> -->
                                <div class="modal-more-info">
                                    <ul class="modal-more-info-list">
                                        <li class="modal-more-info-items">
                                            <a href="profilePage.jsp">Profile</a>
                                        </li>
                                        <li class="modal-more-info-items">
                                            <a href="MainController?action=logout">Log out</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>

            </div>

        </div>
        <!-- End Admin -->


        <!-- Start Customer --> 

        <!-- Sidebar Manager -->
        <div id="sidebar_manager"> 
            <div class="left-navbar-admin-manage  vh-100 simplebar-scrollable-y "> 
                <div class="sidebar">
                    <div class="img-header">
                        <div class="contain__img-desc">
                            <a href="MainController?action=dashboardManager" class="img-page-admin_link">
                                <img src="./assets/img/logo/logoSignin-removebg-preview.png" alt="picture page"> 
                            </a>
                            <div class="desc-img-admin">
                                <p>Koi Care System</p> 
                            </div>
                        </div> 
                    </div>
                    <ul class="menu">
                        <li><a href="MainController?action=dashboardManager"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li> 
                        <li><a href="MainController?action=productmanage"><i class="fa-solid fa-warehouse"></i> Product Manager</a></li> 
                        <li><a href="MainController?action=managerordermanage"><i class="fa-solid fa-cart-shopping"></i> Order Manager</a></li>  
                        <li><a href="MainController?action=accountfishmanage"><i class="fa-solid fa-fish"></i>Aquarium Management</a></li>   
                    </ul>
                </div>
            </div>
        </div>

        <!-- Start Customer -->
        <header id="header__nav">
            <!-- section-1 sub_header -->
            <section class="sub__header-top">
                <div class="container__header-top">
                    <div class="container__iner-fi">
                        <div class="row row__sub_header_top">
                            <div class="col-6 padding__top-header">
                                <div class="left__content">
                                    <!-- phone - email of web -->
                                    <ul class="left__content-infor-list">
                                        <li class="left__content-infor-item">
                                            <i class="fa-solid fa-phone"></i>0987654321
                                        </li>
                                        <li class="left__content-infor-item ">
                                            <i class="fa-solid fa-envelope"></i>acnbokhb12@gmail.com
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-6  padding__top-header">
                                <div class="right-content">
                                    <!-- List icon follow -->
                                    <ul class="right__content-icon-list">
                                        <li class="right__content-icon-item">
                                            <p>
                                                Folow us:
                                            </p>
                                        </li>
                                        <li class="right__content-icon-item">
                                            <a href="#"><i class="fa-brands fa-facebook-f"></i></a>
                                        </li>
                                        <li class="right__content-icon-item">
                                            <a href="#"><i class="fa-brands fa-instagram"></i></a>
                                        </li>
                                        <li class="right__content-icon-item">
                                            <a href="#"><i class="fa-brands fa-x-twitter"></i></a>
                                        </li>
                                        <li class="right__content-icon-item">
                                            <a href="#"><i class="fa-brands fa-pinterest"></i></a>
                                        </li>
                                        <li class="right__content-icon-item">
                                            <a href="#"><i class="fa-brands fa-discord"></i></a>
                                        </li>
                                        <li class="right__content-icon-item">
                                            <a href="#"><i class="fa-brands fa-youtube"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
            <!-- section-2 main_header -->
            <section class="main__header-bottom">
                <div class="containers  padding__top-header">
                    <div class="container__iner-se">
                        <div class="row row__iner-se">
                            <!-- Logo -->
                            <a href="MainController?action=home" class="col-lg-2 link_logo-home">
                                <img src="./assets/img/logo/Logo_Koi_Care.png" alt="Logo_System">
                            </a>
                            <!-- button for responsive -->
                            <button class="hamburger__icon-btn">
                                <i class="fa-solid fa-bars"></i>
                            </button>
                            <!-- task main common -->
                            <div class="col-lg-10 header__right__task nav-bar-menu">
                                <span class="close__navbar-header"><i class="fa-solid fa-xmark close-navbar-icon-btn"></i></span>
                                <div class="contain__list-nav">
                                    <ul class="contain__list-nav-detail">
                                        <li class="contain__item-nav">
                                            <a href="MainController?action=home" class="contain__item-nav-link">
                                                <span>Home</span>
                                            </a>
                                        </li>
                                        <li class="contain__item-nav">
                                            <a href="about.jsp" class="contain__item-nav-link">
                                                <span>About</span>
                                            </a>
                                        </li>
                                        <li class="contain__item-nav">
                                            <a href="MainController?action=shop" class="contain__item-nav-link">
                                                <span>Shop</span>
                                            </a>
                                        </li>
                                        <li class="contain__item-nav contain__item-nav-open">
                                            <a  class="contain__item-nav-link">
                                                <span>News <i class="fa-solid fa-chevron-down ml-1"></i></span>
                                            </a>
                                            <div class="contain__sub-item_nav-link">
                                                <ul class="contain__sub-item_nav-list">
                                                    <li class="contain__sub-item_nav-items">
                                                        <a href="MainController?action=blog">Blogs</a>
                                                    </li>
                                                    <li class="contain__sub-item_nav-items">
                                                        <a href="MainController?action=news">News</a>
                                                    </li>

                                                </ul>
                                            </div>
                                        </li>
                                        <li class="contain__item-nav">
                                            <a href="contact.jsp" class="contain__item-nav-link">
                                                <span>Contact</span>
                                            </a>
                                        </li> 

                                    </ul>
                                </div>
                                <!-- task user -->
                                <div class="contain__task-user">
                                    <div class="header__task-right">
                                        <c:if test="${sessionScope.userAccount.userRole == 'admin'}">
                                            <a href="MainController?action=dashboardAdmin" class="header__link-task d-flex align-end">
                                                <span class="header__link-task-icon"><i class="fa-solid fa-house"></i></span>
                                                <span class="text-label text-uppercase">Dashboard</span> 
                                            </a>
                                        </c:if>

                                        <c:if test="${sessionScope.userAccount.userRole == 'manager'}">
                                            <a href="MainController?action=dashboardManager" class="header__link-task d-flex align-end">
                                                <span class="header__link-task-icon"><i class="fa-solid fa-house"></i></span>
                                                <span class="text-label text-uppercase">Dashboard</span> 
                                            </a>
                                        </c:if> 
                                        <a href="cart.jsp" class="header__link-task d-flex align-end">
                                            <span class="header__link-task-icon"><i
                                                    class="fa-solid fa-bag-shopping"></i></span>
                                            <span class="text-label text-uppercase ">Cart</span>
                                        </a>
                                        <c:if test="${empty sessionScope.userAccount}">
                                            <a href="login.jsp" class="header__link-task d-flex align-end">
                                                <span class="header__link-task-icon"><i class="fa-regular fa-user"></i></span>
                                                <span class="text-label text-uppercase">Sign in</span>
                                            </a>
                                        </c:if>
                                        <c:if test="${not empty sessionScope.userAccount}">
                                            <div class="header__link-account d-flex align-end">
                                                <div class="header__link-task-img-acc">
                                                    <img src="${sessionScope.userAccount.profileImage}" alt="User Profile Image">
                                                    <div class="header__link-task-description">
                                                        <div class="header__link-task-container">
                                                            <div class="welcome__acc-header">
                                                                <p class="dddssd">${sessionScope.userAccount.fullName}</p>
                                                                <a href="MainController?action=profileJsp" class="view__detail_acc">
                                                                    <i class="fa-solid fa-file-invoice"></i> My Account
                                                                </a>
                                                            </div>
                                                            <div class="welcome__acc-body">
                                                                <ul class="body__link-acount-list-item"> 
                                                                    <li class="body__link-acount-detail-item">
                                                                        <a href="MainController?action=fish">
                                                                            <i class="fa-solid fa-fish"></i> My Koi
                                                                        </a>
                                                                    </li>
                                                                    <li class="body__link-acount-detail-item">
                                                                        <a href="MainController?action=pond">
                                                                            <i class="fa-regular fa-circle"></i> My Pond
                                                                        </a>
                                                                    </li>
                                                                    <li class="body__link-acount-detail-item">
                                                                        <a href="MainController?action=waterparametersmanage">
                                                                            <i class="fa-solid fa-droplet"></i> Water Parameters
                                                                        </a>
                                                                    </li>
                                                                    <li class="body__link-acount-detail-item">
                                                                        <a href="MainController?action=statistics">
                                                                            <i class="fa-solid fa-chart-simple"></i> Statistic
                                                                        </a>
                                                                    </li>
                                                                    <li class="body__link-acount-detail-item">
                                                                        <a href="MainController?action=purchaseHistory">
                                                                            <i class="fa-solid fa-receipt"></i> Purchase History
                                                                        </a>
                                                                    </li>
                                                                    <li class="body__link-acount-detail-item">
                                                                        <a href="MainController?action=foodCalculator">
                                                                            <i class="fa-solid fa-calculator"></i> Food Calculator
                                                                        </a>
                                                                    </li>
                                                                    <li class="body__link-acount-detail-item">
                                                                        <a href="MainController?action=saltCalculator">
                                                                            <i class="fa-solid fa-calculator"></i> Salt Calculator
                                                                        </a>
                                                                    </li>

                                                                </ul>
                                                            </div>
                                                            <div class="welcome__acc-footer">
                                                                <ul class="footer__link-acount-list-item">
                                                                    <li class="footer__link-acount-detail-item">
                                                                        <a id="btn-logout" style="cursor: pointer;">
                                                                            <i class="fas fa-sign-out"></i> Log out
                                                                        </a>
                                                                    </li> 
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </section>
        </header>


        <footer id="footer__nav">
            <div class="container__img-footer-main">
                <div class="container__img-pd">
                    <div class="container">
                        <div class="container__footer-desc-area row">
                            <div class="footer-desc-item col-sm-6 col-lg-4">
                                <a href="MainController?action=home" class="footer-desc-item-img">
                                    <img src="./assets/img/logo/Logo_Koi_Care.png" alt="">
                                </a>
                                <p class="desc-footer-infor">
                                    <i class="fa-solid fa-location-dot"></i>  FPT University, Tp Thu Duc, HCM
                                </p>
                                <p class="desc-footer-infor">
                                    <i class="fa-solid fa-phone" style="margin-right: 0.4rem;"></i> +84 1234 567 890
                                </p>
                                <p class="desc-footer-infor">
                                    <i class="fa-solid fa-envelope"style="margin-right: 0.4rem;"></i> acnbokhb12@gmail.com

                                </p>
                            </div>
                            <div class="footer-desc-item col-sm-6 col-lg-3">
                                <h2>Opening time</h2>
                                <div class="footer-desc-item-time">
                                    Monday- Tuesday
                                    <span>
                                        <i>10:10</i> am - <i>11:00</i> pm
                                    </span>
                                </div>
                                <div class="footer-desc-item-time">
                                    <p class="">Monday- Tuesday</p>
                                    <span>
                                        <i>10:10</i> am - <i>11:00</i> pm
                                    </span>
                                </div>

                            </div>
                            <div class="footer-desc-item col-sm-6 col-lg-2">
                                <h2>Menu</h2>
                                <a href="MainController?action=home" class="link__footer-nav">Home</a>
                                <a href="about.jsp" class="link__footer-nav">About</a>
                                <a href="MainController?action=shop" class="link__footer-nav">Shop</a>
                                <a href="contact.jsp" class="link__footer-nav">Contact</a>
                            </div>
                            <div class="footer-desc-item col-sm-6 col-lg-3">
                                <h2>Intagram feed</h2>
                                <p>Don’t miss any updates all the astonishing offers we bring for you.</p>
                                <div class="footer-desc-item-mess">
                                    <form action="">
                                        <input type="text" placeholder="E-mail" required>
                                        <button type="submit">Subcribe</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="container__footer-desc-bottom">
                            <div class="footer-desc-bottom-left">
                                <p>© 2024 Service is powered by <i>Koi Care System</i>. The property of their owners.</p>
                            </div>
                            <div class="footer-desc-bottom-right">
                                <ul class="list__icon__footer">
                                    <li class="item__con__footer">
                                        <a href="#"><i class="fa-brands fa-instagram"></i></a>

                                    </li>
                                    <li class="item__con__footer">
                                        <a href="#"><i class="fa-brands fa-google"></i></a>

                                    </li>
                                    <li class="item__con__footer">
                                        <a href="#"><i class="fa-brands fa-discord"></i></a>
                                    </li>
                                    <li class="item__con__footer">
                                        <a href="#"><i class="fa-brands fa-twitch"></i></a>
                                    </li>
                                    <li class="item__con__footer">
                                        <a href="#"><i class="fa-brands fa-youtube"></i></a>
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </div>
                </div>  
            </div>
        </footer>
        <!-- End Customer -->
        <div id="modal-logout-confirm_nav" class="modal_confirm-logout justify-content-center align-items-center"  >
            <div class="modal_container_confirm-logout  ">
                <div class="modal-content ">
                    <div class="modal-header d-flex justify-content-between align-items-center">
                        <h4 class="font-weight-bold m-0">Please confirm</h4>
                        <button class="btn-close-logout"><i class="fas fa-times"></i></button>
                    </div>
                    <div class="modal-body">
                        <h4>Are you sure you want to LOGOUT?</h4>
                    </div>
                    <div class="modal-footer"> 
                        <button class="btn-confirm-logout" type=""><a href="MainController?action=logout">CONFIRM</a></button>
                    </div>
                </div>
            </div>
        </div>  
    </body>     
</html>