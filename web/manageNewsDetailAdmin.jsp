<%-- 
    Document   : manageNewsDetailAdmin
    Created on : Oct 4, 2024, 2:05:04 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>News Detail</title>
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
     <!-- Jquery -->
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
     <!-- css -->  
     <link rel="stylesheet" href="./assets/css/base.css"> 
     <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
     <link rel="stylesheet" href="./assets/css/history.css">
</head>
<body>
    <div class="container_admin">
        <div id="db-wrapper">
             <!-- start-sidebar -->
             <div id="sidebar_admin"></div>
             <!-- start header -->
             <header id="header">  </header>
             <!-- right -->
             <div class="right-navbar-admin-manage">
                <div class="content">
                     <!-- Title -->
                     <div class="header d-flex "> 
                        <h1>News Detail</h1>  
                        <div>
                            <a id="delete_news" class="btn-utils" href="#" style="background-color: rgb(235, 75, 75); border-color: rgb(235, 75, 75);">Delete News</a>
                        </div>
                    </div>
                    <div class="container_desc-all-news">
                        <h1>Koi: Learn About The Living Jewels of Portland Japanese Garden</h1>
                        <div class="desc_short-detail">
                            <h2 class="user_post">Posted by <span>Khanh</span>  on May 23, 2024</h2>
                            <h2 class="cate_news">Enviroment</h2>
                        </div>
                        <div class="desc_img-news">
                            <img src="https://wpmedia.japanesegarden.org/cb:An8z.2f0c8/w:788/h:525/q:mauto/ig:avif/id:aed028b992871073ff9301d84d87b332/http://live-japanesegarden.pantheonsite.io/Late-Spring-Early-Summer-by-Mike-Centioli-2017-05-31-Portland-Japanese-Garden-May-2017-28.jpg" alt="">
                        </div>
                        <div class="desc-all-infor">
                            <!-- place de info -->
                            In Portland, Oregon, sunshine is often more of a memory than a presence. Yet, while overcast skies may be thought of as gloomy in some spaces, in Portland Japanese Garden this kind of weather elevates the vivid colors present throughout its grounds. On a gray May day, the azaleas and rhododendrons showcase their lush purples and pinks, moss on stone and tree limb almost looks like it’s in motion with a kinetic green. However, there may be no element of the Garden’s landscape that truly comes alive against the cloud cover than its koi.
                        </div>
                    </div>
                </div>
             </div>
        </div>
    </div>
</body>

<script>
    $('#header').load('utils.jsp #header_admin', ()=>{
       $.getScript('./assets/js/utilsAdmin.js');
   });
   $('#sidebar_admin').load('utils.jsp  #sidebar_admin');

   const btnDelete = document.getElementById('delete_news');
   btnDelete.addEventListener('click',(e)=>{
        const sure = confirm('Are you sure you want delete this new ?');
        if(!sure){
            e.preventDefault();
        }
   });
</script>
</html>