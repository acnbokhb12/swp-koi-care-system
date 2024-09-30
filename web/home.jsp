<%-- 
    Document   : home
    Created on : Sep 30, 2024, 9:20:28 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!-- link logo img page -->
    <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
    <!-- Font gg family -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
        rel="stylesheet">
    <!-- Font icon --> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/mainPage.css">
</head>

<body>
    <div id="main">
        <!-- header -->
         <script src="./assets/js/headernav.js"></script> 
         
        <!-- content intro -->
        <section class="content__intro">
            <div class="content__intro-img-script">
                <div class="container__content_intro-main">
                    <div class="contain__content__intro-list">
                        <div class="content__intro-item">
                            <div class="intro-item-img">
                                <img src="https://images.saatchiart.com/saatchi/1198499/art/8482916/7547048-HSC00001-7.jpg"
                                    alt="">
                            </div>
                        </div>
                        <div class="content__intro-item">
                            <div class="intro-item-img">
                                <img src="https://i.pinimg.com/736x/1d/43/42/1d434241aeba343f94a2d90da415a8b2.jpg"
                                    alt="">
                            </div>
                        </div>
                        <div class="content__intro-item">
                            <div class="intro-item-img">
                                <img src="https://i.pinimg.com/736x/09/3e/3d/093e3d9e487d000a4dcbce5da36f3b38.jpg"
                                    alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container_content_intro_script">
                    <div class="content_intro-title">
                        <h1 class="text-capitalize text-center">welcome to koi care system at home</h1>
                    </div>
                    <div class="content_intro_script-detail">
                        <p class="text-center">Our Koi Care System at Home provides a comprehensive solution for
                            managing your koi pond effortlessly. From monitoring water quality to ensuring proper
                            feeding schedules, we help you take the best care of your koi.</p>
                    </div>
                    <div class="content_intro_link">
                        <a href="#lead__to_discover">Discover more <i class="fa-solid fa-chevron-down"></i></a>
                    </div>
                </div>
            </div>
        </section>
        <!-- content - news -->
        <section id="lead__to_discover" class="content__latest-news">
            <div class="content__latest-news-title text-center">
                <h1 class="text-capitalize">The latest blogs</h1>
                <p>
                <p>Explore the latest insights, tips, and expert advice on maintaining a healthy Koi pond system right
                    at home</p>
                </p>
            </div>
            <div class="container__content__lates-news ">
                <button id="prev" class="swiper-button-prev carousel-btn left-btn">
                    <i class="fa-solid fa-chevron-left"></i>
                </button>
                <div class="swiper latest__news-card-wrapper">
                    <div class="swiper-wrapper news-card-list">
                        <div class="swiper-slide news-card-item">
                            <a href="#" class="news-card-link">
                                <img src="https://images.squarespace-cdn.com/content/v1/4f6c8d6ae4b08696a7443c8b/1548090687880-RY1LAPWKOHJI1CVZKQVN/koi-feeding.jpg"
                                    alt="" class="news-card-img">
                                <div class="news-card-more-info">
                                    <h3><i class="fa-solid fa-calendar-days"></i> 2024-12-01</h3>
                                </div>
                                <div class="news-card-desc">
                                    <h2 class="news-card-title text-capitalize text-center">Koi Fish Feeding Tips </h2>
                                    <p class="news-card-subtitle text-uppercase text-center">Food</p>
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide news-card-item">
                            <a href="#" class="news-card-link">
                                <img src="https://wpmedia.japanesegarden.org/cb:An8z.2f0c8/w:788/h:525/q:mauto/ig:avif/https://japanesegarden.org/wp-content/uploads/2024/05/Koi-Release-2013-2013-08-28-RS11704_koi-release-2013-018.jpg"
                                    alt="" class="news-card-img">
                                <div class="news-card-more-info">
                                    <h3><i class="fa-solid fa-calendar-days"></i> 2024-12-01</h3>
                                </div>
                                <div class="news-card-desc">
                                    <h2 class="news-card-title text-capitalize text-center">Improvements Made to Protect
                                        the Koi</h2>
                                    <p class="news-card-subtitle text-uppercase text-center">Improve</p>
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide news-card-item">
                            <a href="#" class="news-card-link">
                                <img src="https://d7fcfvvxwoz9e.cloudfront.net/dom43635/wp-content/uploads/2022/11/pond-cleaning.png"
                                    alt="" class="news-card-img">
                                <div class="news-card-more-info">
                                    <h3><i class="fa-solid fa-calendar-days"></i> 2024-12-01</h3>
                                </div>
                                <div class="news-card-desc">
                                    <h2 class="news-card-title text-capitalize text-center">How To Keep Your Koi Fish
                                        Safe in Winter </h2>
                                    <p class="news-card-subtitle text-uppercase text-center">Clean</p>
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide news-card-item">
                            <a href="#" class="news-card-link">
                                <img src="https://japan-forward.com/wp-content/uploads/2017/05/%E5%A4%A7%E7%A9%BA%E6%B3%B3%E3%81%90%E9%9D%92%E3%81%84%E3%81%93%E3%81%84%E3%81%AE%E3%81%BC%E3%82%8A.jpg"
                                    alt="" class="news-card-img">
                                <div class="news-card-more-info">
                                    <h3><i class="fa-solid fa-calendar-days"></i> 2024-12-01</h3>
                                </div>
                                <div class="news-card-desc">
                                    <h2 class="news-card-title text-capitalize text-center">Kamo Koinobori Festival 2025
                                        for Koi</h2>
                                    <p class="news-card-subtitle text-uppercase text-center">Festival</p>
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide news-card-item">
                            <a href="#" class="news-card-link">
                                <img src="https://i.pinimg.com/736x/90/8b/01/908b014e638f285b536742fb416b7985.jpg"
                                    alt="" class="news-card-img">
                                <div class="news-card-more-info">
                                    <h3><i class="fa-solid fa-calendar-days"></i> 2024-12-01</h3>
                                </div>
                                <div class="news-card-desc">
                                    <h2 class="news-card-title text-capitalize text-center">Types of Koi Varieties</h2>
                                    <p class="news-card-subtitle text-uppercase text-center">Knowledge</p>
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide news-card-item">
                            <a href="#" class="news-card-link">
                                <img src="https://koithienduong.com/wp-content/uploads/2021/04/kham-pha-chi-tiet-cau-tao-va-loi-ich-cua-may-suc-oxy..jpg"
                                    alt="" class="news-card-img">
                                <div class="news-card-more-info">
                                    <h3><i class="fa-solid fa-calendar-days"></i> 2024-12-01</h3>
                                </div>
                                <div class="news-card-desc">
                                    <h2 class="news-card-title text-capitalize text-center">Oxygen Generator And Its
                                        Uses That Cannot Be Ignored</h2>
                                    <p class="news-card-subtitle text-uppercase text-center">Tool</p>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>
                <button id="next" class="swiper-button-next carousel-btn right-btn">
                    <i class="fa-solid fa-chevron-right"></i>
                </button>
            </div>
        </section>
        <!-- content - introduce shop system -->
        <section class="content__shop">
            <div class="container__content__shop  ">
                <div class="row row__content__shop">
                    <div class="col-md-3">
                        <div class="contain__shop__intro-img">
                            <img src="https://caverta.matchthemes.com/wp-content/uploads/2018/06/welcome-1.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="contain__shop-description-main">
                            <h4 class="text-uppercase text-center "><i class="fa-solid fa-minus"></i> Koi Care System <i
                                    class="fa-solid fa-minus"></i></h4>
                            <h1 class="text-center">Your One-Stop Shop for Koi Care</h1>
                            <p class="text-center">At KOI CARE STORE, we understand the art of maintaining a beautiful
                                Koi pond at home. Our range of top-quality products is carefully curated to ensure the
                                health and beauty of your Koi. From water conditioners to high-nutrition food, we
                                provide everything you need for the perfect Koi care experience. Visit us to explore our
                                collection and transform your pond into a serene oasis</p>
                            <div class="shop__link-to-intro ">
                                <a href="">SHOP NOW</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="contain__shop__intro-img ">
                            <img src="https://caverta.matchthemes.com/wp-content/uploads/2018/06/welcome-2.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- sort conent intro web -->
        <section class="sort__content__intro-page-img">
            <div class="sort__content__intro-page-script">
                <h4 class="text-uppercase"><i class="fa-solid fa-minus"></i> DISCOVER THE BEST <i
                        class="fa-solid fa-minus"></i></h4>
                <h1>Crafting Beautiful Koi Habitats</h1>
            </div>
        </section>
        <!-- intro service our system -->
        <section class="container__intro-service-web">
            <div class="container__intro-service-main">
                <div class="intro__service-header">
                    <h1 class="text-center text-capitalize">Professional Koi Care Services at Home</h1>
                    <p class="text-center">We provide comprehensive Koi pond care services, including water quality
                        checks, pond cleaning, fish health monitoring, and filtration system maintenance. Our team of
                        experts is ready to ensure a healthy and thriving environment for your Koi right at your home.
                    </p>
                </div>
                <div class="cont ainer">


                    <div class="swiper intro__service-container-cart ">
                        <button class="move-prev btn-move-prev-service" style="left: 1rem;">
                            <i class="fa-solid fa-chevron-left"></i>
                        </button>
                        <div class="swiper-wrapper  intro__service-list-cart">
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home fadsfhj dsj jhds daf sdf dsf adf sd fadsf ds
                                    </h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home</h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home</h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home</h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home</h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home</h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home</h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                            <div class="intro__service-item swiper-slide ">
                                <div class="intro__service-header-img">
                                    <img src="https://astfilters.com/aquatic-systems/wp-content/uploads/sites/3/2015/12/bbf-xf20000-on-koi-pond.jpg"
                                        alt="">
                                </div>
                                <div class="intro__service-body-script">
                                    <h4>Service cleaning pond Koi at home</h4>
                                    <p>Our professional team offers comprehensive Koi pond cleaning services at your
                                        home, ensuring a healthy and pristine environment for your Koi. From debris
                                        removal to water quality testing, we take care of every detail to maintain your
                                        pond in optimal condition.</p>
                                </div>
                                <div class="intro__service-footer-link">
                                    <a href="">View More</a>
                                </div>
                            </div>
                        </div>  
                        <button class="move-next btn-move-next-service" style="right: 1rem;">
                            <i class="fa-solid fa-chevron-right"></i>
                        </button>

                    </div>
                </div>
            </div>
        </section>
        <!-- sort conent intro web -->
        <section class="sort__content__intro-page-img text-center" style="background: url('https://images2.alphacoders.com/128/1288731.jpg') no-repeat; object-fit: cover; background-attachment: fixed;">
            <div class="sort__content__intro-page-script" >
                <h4 class="text-uppercase"><i class="fa-solid fa-minus"></i> DISCOVER THE BEST <i
                        class="fa-solid fa-minus"></i></h4>
                <h1>Comprehensive Koi Care System at Home</h1>
                
            </div>
        </section>
        
        <!-- footer -->
         <script src="./assets/js/footer.js"></script>
                    
        
    </div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/11.0.5/swiper-bundle.min.js"></script>
<script>
     var swiper = new Swiper(".latest__news-card-wrapper", {
        spaceBetween: 20,
        loop: true,
        centeredSlides: true,
        autoplay: {
            delay: 5500,
            disableOnineraction: false,
        },
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
        breakpoints: {
            0: {
                slidesPerView: 1,
            },
            450: {
                slidesPerView: 2,
            },
            768: {
                slidesPerView: 3,
            },
            1024: {
                slidesPerView: 4,
            },
        },
    });
    var swiper2 = new Swiper(".intro__service-container-cart", {
        spaceBetween: 20,
        loop: true,
        centeredSlides: true, 
        autoplay: {
            delay: 5500,
            disableOnineraction: false,
        },
        navigation: {
            nextEl: ".move-next",
            prevEl: ".move-prev",
        },
        breakpoints: {
            0: {
                slidesPerView: 1,
            },
            450: {
                slidesPerView: 2,
            },
            768: {
                slidesPerView: 3,
            },
            1024: {
                slidesPerView: 4,
            },
            1240: {
                slidesPerView: 5,
            },

        },
    });
</script>
    

</html>