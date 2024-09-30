<%-- 
    Document   : pondInfor
    Created on : Sep 30, 2024, 10:45:05 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pond Information</title>
    <!-- Font gg family -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
        rel="stylesheet">

    <!-- Font icon -->
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/pondkoi.css">
</head>

<body class="pond-background">
    <script src="./assets/js/headernav.js"></script>
    <div class="container container_pond">
        <div class="tilte-ponds"> 
            <h1>Koi Fish Pond Information</h1>
            <div class="text-right">
                <a href="Fish.html" class="back-btn">Back to List</a>
                <a href="#" class="delete-btn-fish">Delete</a>
                <button class="edit-btn-out">
                    Edit Information
                </button>
            </div>
        </div>
         
        <div class="row mt-4">
            <div class="col-4 pond-img-info">
                
                <img src="https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg" alt="Koi Pond">
            </div>
    
            <div class="col-8 info">      
                <div class="info-item">
                    <span class="label">Pond Name:</span> <span class="value">Tranquil Waters</span>
                </div>
                <div class="info-item">
                    <span class="label">Size:</span> <span class="value">10m x 5m</span>
                </div>
                <div class="info-item">
                    <span class="label">Depth:</span> <span class="value">1.5m</span>
                </div>
                <div class="info-item">
                    <span class="label">Volume:</span> <span class="value">30,000 liters</span>
                </div>
                <div class="info-item">
                    <span class="label">Drain Count:</span> <span class="value">2</span>
                </div>
                <div class="info-item">
                    <span class="label">Pump Power:</span> <span class="value">5HP</span>
                </div>
            </div>
        </div>
    </div>
    
    <div class="container container-fish">
        <h1>List Of Koi Fishes</h1>
        <div class="container-list-arrow">
        <div class="swiper container-list-fish">         
            <div class="swiper-wrapper row-list-fish">
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
                <a href="#" class="fish-item swiper-slide">
                   <div class="fish-item-img">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="">
                        <div class="fish-item-desc">
                            <p>Koi sdffa ds fasdf sdf dsfsdaf asf sdfas  dsfasdfa sdfsd fads</p>
                        </div>
                    </div> 
                   
                </a>
             
                 
            </div>
            <div class="contain__btn-arrow">

                <button class="prev-btn"><i class="fa-solid fa-arrow-left"></i></button>
                <button class="next-btn"><i class="fa-solid fa-arrow-right"></i></button>
            </div>
        </div>

        </div>

    </div>
<!-- TABLE EDIT -->
    <div class="container__infor__pond">
        <div class="infor__pond-detail">
            <div class="row row-pond-detail">
                <div class="col-4" style="padding: 0;">
                    <div class="img-edit-submit">
                        <div class="pond-img-info-edit">
                            <img src="https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg" alt="Koi Pond" > 
                        </div>
                        <div class="pond-edit-img-detail">
                            <form action="" class="form-edit-img-pond">
                                <input type="file">
                                <button type="submit">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-8 edit-info">
                    <div class="text-right">
                        <button
                        class="btn-close-pond"><i class="fa-solid fa-xmark close-navbar-icon-btn-pond"></i></button>
                        
                    </div>
                    <h2>Edit card</h2>
                    <form>
                        <div class="row row-edit-info-detail">
                            <div class="col-md-6 edit-item-detail">
                                <span>Pond Name: </span>
                                <input type="text">
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Pond Name: </span>
                                <input type="text">
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Pond Name: </span>
                                <input type="text">
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Pond Name: </span>
                                <input type="text">
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Pond Name: </span>
                                <input type="text">
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Pond Name: </span>
                                <input type="text">
                            </div>
                        </div>
                        <div class="text-center">
                            <button class="edit-btn" style="margin-top: 10px; ">
                                Confirm
                            </button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
    <script src="./assets/js/footer.js"></script>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/11.0.5/swiper-bundle.min.js"></script>
<script>
    const btnClose = document.querySelector('.btn-close-pond'); 
    const tableEdit = document.querySelector('.container__infor__pond');
    const btnOutOpen = document.querySelector('.edit-btn-out');
    const subTable = document.querySelector('.infor__pond-detail');

    btnOutOpen.addEventListener('click',function(e){
        tableEdit.classList.add('open');
        e.stopPropagation();
    });
    btnClose.addEventListener('click',()=>{
        tableEdit.classList.remove('open');
    });
    subTable.addEventListener('click',(e)=>{
        e.stopPropagation();
    });
    document.addEventListener('click',()=>{
       
            tableEdit.classList.remove('open'); 
    });
    var swiper = new Swiper(".container-list-fish", {
        spaceBetween: 20,
        loop: true,
        centeredSlides: true,
        autoplay: {
            delay: 5500,
            disableOnineraction: false
        },
        navigation: {
            nextEl: ".next-btn",
            prevEl: ".prev-btn"
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