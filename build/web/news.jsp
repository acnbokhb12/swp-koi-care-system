<%-- 
    Document   : news
    Created on : Sep 30, 2024, 10:42:44 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>News</title>
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
        <link rel="stylesheet" href="./assets/css/news_blogs.css">
    </head>
    <body style="background-color: #EDEFF4;">
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->
        <div id="content-news" >
            <header class="swiper shop__intro-container " >
                <div class="swiper-wrapper shop__intro-list">
                    <div class="shop__intro-item swiper-slide">
                        <div class="shop__intro-img-contain">
                            <img
                                src="https://static.wixstatic.com/media/0fa26a_889e9808cb78401c944295c8a25929fd~mv2.jpeg/v1/fill/w_2500,h_1666,al_c/0fa26a_889e9808cb78401c944295c8a25929fd~mv2.jpeg"
                                alt="">
                        </div>
                        <div class="shop__intro-item-text">
                            <h1>Subscribe Today!</h1>
                            <p>Volume Five was released in June and is packed with fantastic koi content you simply can't get anywhere else. Exclusive interviews, in-depth articles</p>
                            <div class="link__goto-detail">
                                <a href="#">Discover more</a>
                            </div>

                        </div>

                    </div>
                    <div class="shop__intro-item swiper-slide">
                        <div class="shop__intro-img-contain">
                            <img src="https://static.wixstatic.com/media/0fa26a_810ff0760d484f4b8d2fe8fbf11099d1~mv2.jpg/v1/fill/w_1891,h_629,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/0fa26a_810ff0760d484f4b8d2fe8fbf11099d1~mv2.jpg"
                                 alt="">
                        </div>
                        <div class="shop__intro-item-text">
                            <h1>Major Awards - The Great British Koi Show '24</h1>
                            <p>It was the third year running for the GBKS, and (once again) they had worked to enhance what had gone before. The club had invested heavily in improvements.</p>
                            <div class="link__goto-detail">
                                <a href="#">Discover more</a>
                            </div>
                        </div>
                    </div>
                    <div class="shop__intro-item swiper-slide">
                        <div class="shop__intro-img-contain">
                            <img src="https://i.ytimg.com/vi/mRQ5X-ZaZss/maxresdefault.jpg" alt="">
                        </div>
                        <div class="shop__intro-item-text">
                            <h1>Koi pond box filter setup and a murky pond </h1>
                            <p>After building my new pond I went and had a look at the pond I look after for my mother. I had not cleaned the filter or the pond for a while and it was a little murkey.</p>
                            <div class="link__goto-detail">
                                <a href="#">Discover more</a>
                            </div>
                        </div>
                    </div>

                </div>
            </header>
            <div class="trending__area">
                <div class="container">
                    <div class="trending__main">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="trending-title">
                                    <strong>Trending now</strong>
                                    <p>Explore the latest tips on pond maintenance and top products for Koi health.</p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="trending-top">
                                    <c:forEach items="${newsListLatest}" var="latest" begin="0" end="0"> 
                                        <a href="MainController?action=viewNews&id=${latest.newsID}" class="trending-top-img">
                                            <img src="${latest.newsImage}" alt="">
                                            <div class="trending-top-cap">
                                                <span>${latest.newsCategory.name} </span>
                                                <h2>${latest.title}</h2>
                                            </div>
                                        </a>

                                    </c:forEach>

                                </div>
                                <div class="trending-bottom">
                                    <div class="row">
                                        <c:forEach var="latest" items="${newsListLatest}" varStatus="status">
                                            <c:if test="${status.index > 0 && status.index < 4}"> <!-- Chỉ lấy 3 bài báo -->
                                                <div class="col-sm-6 col-lg-4">
                                                    <a href="MainController?action=viewNews&id=${latest.newsID}" class="trending-bottom-single">
                                                        <div class="trending-bottom-img">
                                                            <img src="${latest.newsImage}" alt="">
                                                        </div>
                                                        <div class="trending-bottom-cap">
                                                            <span>${latest.newsCategory.name}</span>
                                                            <h4>${latest.title}</h4>
                                                        </div>
                                                    </a>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <!-- nhung the a nay tuong duong voi 1 bai bao -->
                                <c:forEach var="latest" items="${newsListLatest}" varStatus="status">
                                    <c:if test="${status.index >3 && status.index < 10}">
                                        <a href="MainController?action=viewNews&id=${latest.newsID}" class="trend-right-single d-flex">
                                            <div class="tren-right-img">
                                                <img src="${latest.newsImage}" alt="">
                                            </div>
                                            <div class="trend-rigth-cap">
                                                <span>${latest.newsCategory.name}</span>
                                                <h4>${latest.title}</h4>
                                            </div>
                                        </a>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="news__area mb-5">
                <div class="container">
                    <!-- news area take header main -->
                    <div class="news__area__main">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="news-title-section">
                                    <h4 class="m-0 text-uppercase">${titleNewsSpecialV1}</h4> 
                                </div>
                            </div>
                        </div>
                        <div class="container__news-main">
                            <div class="swiper container__news">
                                <div class="swiper-wrapper container__news-list">

                                    <c:forEach var="newsItem" items="${listNewsSpecialV1}" >

                                        <div class="container__news-item swiper-slide">
                                            <a href="MainController?action=viewNews&id=${newsItem.newsID}" class="container__news-item-desc">
                                                <img src="${newsItem.newsImage}" alt="">
                                                <div class="container__news-item-cap">
                                                    <div class="news-item-cap-detail">
                                                        <span>${newsItem.newsCategory.name}</span>
                                                        <p><fmt:formatDate value="${newsItem.newsDate}" pattern="dd-MM-yyyy" /></p>
                                                    </div>
                                                    <h4>${newsItem.title}</h4>
                                                </div>
                                            </a>
                                        </div>

                                    </c:forEach>   
                                </div>
                                <div class="news-title-btn">
                                    <button class="f_owl-prev"><i class="fa-solid fa-chevron-left"></i></button>
                                    <button class="f_owl-next"><i class="fa-solid fa-chevron-right"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="news__area__main">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="news-title-section">
                                    <h4 class="m-0 text-uppercase">${titleNewsSpecialV2}</h4> 
                                </div>
                            </div>
                        </div>
                        <div class="container__news-main">
                            <div class="swiper container__news">
                                <div class="swiper-wrapper container__news-list">
                                    <c:forEach var="newsItem" items="${listNewsSpecialV2}" >

                                        <div class="container__news-item swiper-slide">
                                            <a href="MainController?action=viewNews&id=${newsItem.newsID}" class="container__news-item-desc">
                                                <img src="${newsItem.newsImage}" alt="">
                                                <div class="container__news-item-cap">
                                                    <div class="news-item-cap-detail">
                                                        <span>${newsItem.newsCategory.name}</span>
                                                        <p><fmt:formatDate value="${newsItem.newsDate}" pattern="dd-MM-yyyy" /></p>
                                                    </div>
                                                    <h4>${newsItem.title}</h4>
                                                </div>
                                            </a>
                                        </div> 


                                    </c:forEach>
                                </div>
                                <div class="news-title-btn">
                                    <button class="f_owl-prev"><i class="fa-solid fa-chevron-left"></i></button>
                                    <button class="f_owl-next"><i class="fa-solid fa-chevron-right"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="news-title-section">
                                        <h4 class="m-0 text-uppercase">${titleNewsNormal}</h4> 
                                    </div>
                                </div>
                                <!-- col-lg-6 tuong duong voi 1 bai bao -->
                                <c:forEach var="normalNews" items="${listNormalNews}">
                                    <div class="col-lg-6">
                                        <a href="MainController?action=viewNews&id=${normalNews.newsID}" class="item__news__link position-relative">
                                            <img class="img-fluid w-100" src="${normalNews.newsImage}" alt="" style="height: 200px;">
                                            <div class="news-item-continuous bg-white border border-top-0 ">
                                                <div class="item-continuous-cate-date contain-cate-date">
                                                    <span class="span__for-cate">
                                                        ${normalNews.newsCategory.name}
                                                    </span>
                                                    <span class="span__for-date">
                                                        <fmt:formatDate value="${normalNews.newsDate}" pattern="dd-MM-yyyy" />
                                                    </span>
                                                </div>
                                                <h2 class="item-continuous-title">${normalNews.title}</h2>
                                            </div>
                                        </a> 
                                    </div>
                                </c:forEach> 

                            </div>
                            <div class="pagination mt-0">
                                <ul class="pagination-list justify-content-center">
                                    <!-- Link đến trang trước -->
                                    <c:if test="${tag > 1}">
                                        <li>
                                            <a href="ShowNewsController?index=${tag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                        </li>
                                    </c:if>
                                    <c:set var="startPage" value="${tag - 2 < 1 ? 1 : tag - 2}"/>
                                    <c:set var="endPage" value="${startPage + 5 > endPage ? endPage : startPage + 5}"/>
                                    <!-- Hiển thị 3 trang đầu tiên -->
                                    <c:forEach var="i" begin="${startPage}" end="${endPage}">
                                        <li>
                                            <a class="${i == tag ? 'active' : ''}" href="ShowNewsController?index=${i}">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <!-- Link đến trang kế tiếp -->
                                    <c:if test="${tag < endPage}">
                                        <li>
                                            <a href="ShowNewsController?index=${tag + 1}"><i class="fa-solid fa-chevron-right"></i></a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="mar-bt-16">
                                <div class="news-title-section m-0">
                                    <h4 class="m-0 text-uppercase">follow us</h4> 
                                </div>
                                <div class="bg-white border border-top-0 p-3">
                                    <a href="#" class="link-followus_new d-block w-100 text-white text-decoration-none mb-3" style="background: #39569E;">
                                        <i class="fab fa-facebook-f text-center " ></i>
                                        <span class="">12,345 Fans</span>
                                    </a>
                                    <a href="#" class="link-followus_new  d-block w-100 text-white text-decoration-none mb-3" style="background: #52AAF4;">
                                        <i class="fab fa-twitter text-center " ></i>
                                        <span class="">12,345 Followers</span>
                                    </a>
                                    <a href="#" class="link-followus_new  d-block w-100 text-white text-decoration-none mb-3" style="background: #0185AE;">
                                        <i class="fab fa-linkedin-in text-center " ></i>
                                        <span class="">12,345 Connects</span>
                                    </a>
                                    <a href="#" class="link-followus_new  d-block w-100 text-white text-decoration-none mb-3" style="background: #C8359D;">
                                        <i class="fab fa-instagram text-center " ></i>
                                        <span class="">12,345 Followers</span>
                                    </a>
                                    <a href="#" class="link-followus_new  d-block w-100 text-white text-decoration-none mb-3" style="background: #DC472E;">
                                        <i class="fab fa-youtube text-center " ></i>
                                        <span class="">12,345 Subscribers</span>
                                    </a>
                                    <a href="#" class="link-followus_new  d-block w-100 text-white text-decoration-none" style="background: #055570;">
                                        <i class="fab fa-vimeo-v text-center " ></i>
                                        <span class="">12,345 Followers</span>
                                    </a>
                                </div>
                            </div>

                            <div class="mar-bt-16">
                                <c:forEach var="random" items="${randomNews}">
                                    <div class="news-title-section m-0">
                                        <h4 class="m-0 text-uppercase">Advertisement</h4> 
                                    </div>

                                    <div class="bg-white text-center border border-top-0 p-3">
                                        <a href="MainController?action=viewNews&id=${random.newsID}">
                                            <img src="${random.newsImage}" alt="" style="max-height: 150px; width: 330px ">
                                        </a>
                                    </div>
                                </c:forEach> 
                            </div>

                            <div class="mar-bt-16">
                                <div class="news-title-section m-0">
                                    <h4 class="m-0 text-uppercase">Newsletter</h4> 
                                </div>
                                <div class="contain__send-email bg-white text-center border border-top-0 p-3">
                                    <p>Aliqu justo et labore at eirmod justo sea erat diam dolor diam vero kasd</p>
                                    <div class="input-group-send-email  ">
                                        <form action=""> 
                                            <div class="form__email" style="display: flex;"> 
                                                <input class="" type="text" placeholder="Your Email" required>

                                                <button class="btn btn-primary font-weight-bold " type="submit">Send</button>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- footer -->
        <div id="footer"></div>
        <style>
            .pagination-list li .dotdotdot:hover{
                background-color: #fff;
                color: #000;
            }

            .pagination-list li .active-page{
                background-color: orange;
            }
        </style>
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
                crossFade: false // Bật cross fade để các ảnh mờ dần vào nhau
            },
            loop: true, // Để slide lặp lại liên tục
            autoplay: {
                delay: 6000, // Thay đổi slide sau mỗi 5.5 giây
                disableOnInteraction: false // Để nó tự động ngay cả khi người dùng tương tác
            },
            allowTouchMove: false, // Không cho phép kéo slide bằng tay
            navigation: false, // Không có nút điều hướng
            slidesPerView: 1, // Chỉ hiển thị 1 slide tại một thời điểm
            speed: 1000// Tốc độ chuyển đổi giữa các slide (1 giây)
        });
        var swiperNews = new Swiper(".container__news", {
            spaceBetween: 30,
            loop: true,
            centeredSlides: true,
            autoplay: {
                delay: 5500,
                disableOnineraction: false
            },
            navigation: {
                nextEl: ".f_owl-next",
                prevEl: ".f_owl-prev"
            },
            breakpoints: {
                0: {
                    slidesPerView: 1
                },
                450: {
                    slidesPerView: 2
                },
                768: {
                    slidesPerView: 3
                },
                1024: {
                    slidesPerView: 4
                }

            }
        });
    </script>
</html>