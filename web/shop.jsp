<%-- 
    Document   : shop
    Created on : Sep 30, 2024, 10:30:54 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <!-- Font icon -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/shopPage.css">
    </head>

    <body> 
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->
        <div id="content__shop">
            <header class="swiper shop__intro-container">
                <div class="swiper-wrapper shop__intro-list">
                    <div class="shop__intro-item swiper-slide">
                        <div class="shop__intro-img-contain">
                            <img
                                src="https://images.squarespace-cdn.com/content/v1/4f6c8d6ae4b08696a7443c8b/1507179367867-OWRWE4GMFOVYGOCR7PXJ/Koi_feeding%2C_National_Arboretum.jpg"
                                alt="">
                        </div>
                        <div class="shop__intro-item-text">
                            <h1>TinySalt Shop</h1>
                            <p>Explore our menu's signature dishes, from premium cuts of beef to fresh seafood dishes, all prepared with
                                love and flair.</p>
                            <a href=""></a>
                        </div>
                    </div>
                    <div class="shop__intro-item swiper-slide">
                        <div class="shop__intro-img-contain">
                            <img src="https://hoyafilter.com/uploads/images/catalog/product/HD_nano_Mk_II/pl_03_2.jpg?1642011742638"
                                 alt="">
                        </div>
                        <div class="shop__intro-item-text">
                            <h1>TinySalt Shop</h1>
                            <p>Explore our menu's signature dishes, from premium cuts of beef to fresh seafood dishes, all prepared with
                                love and flair.</p>
                            <a href=""></a>
                        </div>
                    </div>
                    <div class="shop__intro-item swiper-slide">
                        <div class="shop__intro-img-contain">
                            <img src="https://blog.japanwondertravel.com/wp-content/uploads/2021/11/Koi.jpg" alt="">
                        </div>
                        <div class="shop__intro-item-text">
                            <h1>TinySalt Shop</h1>
                            <p>Explore our menu's signature dishes, from premium cuts of beef to fresh seafood dishes, all prepared with
                                love and flair.</p>
                            <a href=""></a>
                        </div>
                    </div>

                </div>
            </header>
            <!-- Product here -->
            <div id="container__page_shop" class="container__shop_product ">
                <div class="shop_product-title ">
                    <h1>Shop</h1> 
                    <div class="shop__ultities-sort">
                        <div class="shop__ultities-sort-dertail">
                            <form action="">
                                <select name="" id="" class="shop__ultities-sort-select-list">
                                    <option value="" selected>Default Sorting</option>
                                    <option value="">Sort by popularity</option>
                                    <option value="">Sort by latest</option>
                                    <option value="">Sort by price: low to high</option>
                                    <option value="">Sort by price: high to low</option>
                                </select>
                            </form>
                            <p><i class="fa-solid fa-chevron-down"></i></p>
                        </div>
                    </div>
                </div>
                <div class="container__shop_utilities container">

                </div>
                <div class="grid grid-container-shop">
                    <div class="row row__shop">
                        <!-- row categories -->
                        <div class="col-sm-3 col-cate">  
                            <div class="shop__ultiliites-search">
                                <form action="SearchProductController" method="get" class="shop__product_form">
                                    <input type="text" class="shop__product_search-input" name="productName" value="${OldSearch}" placeholder="Search">
                                    <button type="submit" class="shop__product_search-submit"><i class="fas fa-search"></i> </button>
                                </form>
                            </div> 
                            <nav class="category__shop">
                                <h3 class="category__shop-heading">
                                    <a href="ManageShopController?action=shop">
                                        <i class="category__shop-heading-icon fa-solid fa-list"></i> Categories
                                    </a>
                                </h3>
                                <ul class="category-list row"> 
                                    <c:forEach items="${ListC}" var="ct"> 
                                        <li class="category-item col-lg-12 col-custom-cate ${TagsCate == ct.categoryID ? 'category-item--active' : ''} ">
                                            <a href="ProductCateController?cateID=${ct.categoryID}" class="category-item__link">${ct.categoryName} </a>
                                        </li>
                                    </c:forEach> 
                                </ul>
                            </nav>
                        </div>
                        <div class="col-sm-9 ">
                            <div class="shop__product__lists">
                                <!-- row chua element  -->
                                <div class=" row "> 
                                    <c:forEach items="${ListP}" var="p">  
                                        <div class="col-lg-3 col-md-4   col-6 product-item">
                                            <a href="productDetail.jsp" class="home-product-item__link">
                                                <div class="shop__product_item-desc">
                                                    <div class="create__blank"></div>
                                                    <!-- product item -->
                                                    <div class="shop__product__img">
                                                        <img src="${p.imgProduct}" alt="">
                                                    </div>
                                                    <div class="shop__product__des-detail">
                                                        <!-- title -->
                                                        <h4 class="shop__product-name">${p.nameProduct}</h4>
                                                        <!-- descript -->
                                                        <p class="shop__product-description">
                                                            ${p.description}
                                                        </p>
                                                        <!-- price- category -->
                                                        <div class="contain-cat-price ">
                                                            <h5 class="shop__product-price ">${p.price}</h5>
                                                            <h5 class="shop__product-category-list ">
                                                                <p class="shop__product-category-item">
                                                                    ${p.categoryP.categoryName}
                                                                </p>
                                                            </h5>
                                                        </div> 
                                                    </div> 
                                                </div> 
                                            </a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="pagincontainer"> 
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination"> 
                                        <c:choose>
                                            <c:when test="${cateID != null}">
                                                 <c:if test="${tag > 1}"> 
                                                    <li class="page-item"><a class="page-link" href="ProductCateController?index=${tag-1}&cateID=${cateID}"><i class="fa-solid fa-chevron-left"></i></a></li>
                                                </c:if>
                                                <c:forEach begin="1" end="${endPage}" var="i">
                                                    <li class="page-item"><a class="page-link ${tag == i ? "active__page" : ""}" href="ProductCateController?index=${i}&cateID=${cateID}">${i}</a></li>
                                                </c:forEach> 
                                                <c:if test="${tag < endPage }"> 
                                                    <li class="page-item"><a class="page-link" href="ProductCateController?index=${tag+1}&cateID=${cateID}"><i class="fa-solid fa-chevron-right"></i></a></li>
                                                </c:if> 
                                            </c:when>
                                            <c:otherwise>
                                                <c:if test="${tag > 1}"> 
                                                    <li class="page-item"><a class="page-link" href="ManageShopController?index=${tag-1}"><i class="fa-solid fa-chevron-left"></i></a></li>
                                                </c:if>
                                                <c:forEach begin="1" end="${endPage}" var="i">
                                                    <li class="page-item"><a class="page-link ${tag == i ? "active__page" : ""}" href="ManageShopController?index=${i}">${i}</a></li>
                                                </c:forEach> 
                                                <c:if test="${tag < endPage }"> 
                                                    <li class="page-item"><a class="page-link" href="ManageShopController?index=${tag+1}"><i class="fa-solid fa-chevron-right"></i></a></li>
                                                </c:if> 
                                            </c:otherwise>
                                        </c:choose>  
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!-- footer -->
        <div id="footer"></div>
    </body>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/11.0.5/swiper-bundle.min.js"></script>

    <script>
        var swiperFadeShop = new Swiper(".shop__intro-container", {
            effect: 'fade', // Sử dụng hiệu ứng fade cho mỗi lần chuyển slide
            fadeEffect: {
                crossFade: false// Bật cross fade để các ảnh mờ dần vào nhau
            },
            loop: true, // Để slide lặp lại liên tục
            autoplay: {
                delay: 6000, // Thay đổi slide sau mỗi 5.5 giây
                disableOnInteraction: false // Để nó tự động ngay cả khi người dùng tương tác
            },
            allowTouchMove: false, // Không cho phép kéo slide bằng tay
            navigation: false, // Không có nút điều hướng
            slidesPerView: 1, // Chỉ hiển thị 1 slide tại một thời điểm
            speed: 1000 // Tốc độ chuyển đổi giữa các slide (1 giây)
        });

        // tien vnd
        const priceElements = document.querySelectorAll('.shop__product-price');
        priceElements.forEach(function (element) {
            let price = parseInt(element.innerText);
            let formattedAmount = price.toLocaleString('vi-VN', {style: 'currency', currency: 'VND'});
            element.innerText = formattedAmount;
        });

    </script>
    <script>

    </script>

</html>