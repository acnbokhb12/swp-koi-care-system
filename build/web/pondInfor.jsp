<%-- 
    Document   : pondInfor
    Created on : Sep 30, 2024, 10:45:05 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/pondkoi.css">
    </head>

    <body class="pond-background">
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->

        <div class="container container_pond">
            <div class="tilte-ponds"> 
                <h1>Koi Fish Pond Information</h1>
                <div class="text-right">
                    <a href="MainController?action=pond" class="back-btn">Back to List</a> 
                    <a href="DeletePondController?pondID=${pond.pondID}" class="delete-btn-fish">Delete</a>
                    <button class="edit-btn-out">
                        Edit Information
                    </button>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-4 pond-img-info">
                    <img src="${pond.image}" alt="${pond.name}">
                </div>

                <div class="col-8 info">
                    <div class="info-item">
                        <span class="label label-witdh">Pond Name:</span> 
                        <span class="value span-witdh">${pond.name}</span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Depth:</span> 
                        <span class="value span-witdh">${pond.depth}  <span class="sub_span-highlight">(m)</span></span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Volume:</span> 
                        <span class="value span-witdh">${pond.volume}  <span class="sub_span-highlight"> (l)</span></span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Drain Count:</span> 
                        <span class="value span-witdh">${pond.drainCount}</span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Pump Power:</span> 
                        <span class="value span-witdh">${pond.pumpPower}<span class="sub_span-highlight">(l/h)</span></span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Quantity fish   :</span> 
                        <span class="value span-witdh">${pond.numberOfFish}  </span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Description:</span> 
                        <span class="value span-witdh">${pond.descriptionPond}  </span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Skimmer:</span> 
                        <span class="value span-witdh">${pond.skimmer}  </span>
                    </div>
                </div>
            </div>
        </div>

        <div class="container container-fish">
            <h1>List Of Koi Fishes</h1>
            <div class="container-list-arrow">
                <div class="swiper container-list-fish">         
                    <div class="swiper-wrapper row-list-fish">
                        <!-- Use JSTL to iterate over the list of fish -->
                        <c:forEach var="fish" items="${listFish}">
                            <a href="FishInforController?fid=${fish.fishID}" class="fish-item swiper-slide">
                                <div class="fish-item-img">
                                    <img src="${fish.image}" alt="${fish.name}"> <!-- Use fish image -->
                                    <div class="fish-item-desc">
                                        <p>${fish.description}</p> <!-- Use fish description -->
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
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
                                <img src="${pond.image}" alt="${pond.name}" > 
                            </div>
                            <div class="pond-edit-img-detail">
                                <form action="MainController?action=pondimageupdate" class="form-edit-img-pond" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="pondID" value="${pond.pondID}">
                                    <input id="imageInput" name="fileimg" type="file" accept="image/*" >
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
                        <form action="MainController?action=pondinformationupdate" method="POST">
                            <div class="row row-edit-info-detail"> 
                                <input type="hidden" name="pondID" value="${pond.pondID}">

                                <div class="col-md-6 edit-item-detail">
                                    <label for="pondName">Pond Name</label>
                                    <input type="text" id="pondName" name="pondName" value="${pond.name}" required>
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <label for="depth">Depth (meters)</label>
                                    <input type="number" step="0.1" id="depth" name="depth" value="${pond.depth}" required>
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <label for="volume">Volume (liters)</label>
                                    <input type="number" step="0.1" id="volume" name="volume" value="${pond.volume}" required>
                                </div>                               
                                <div class="col-md-6 edit-item-detail">
                                    <label for="drainCount">Number of Drains</label>
                                    <input type="number" id="drainCount" name="drainCount" value="${pond.drainCount}" required>
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <label for="pumpPower">Pump Power (l/h)</label>
                                    <input type="number" id="pumpPower" name="pumpPower" value="${pond.pumpPower}" required>
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <label for="numberOfFish">Number of Fish</label>
                                    <input type="number" id="numberOfFish" name="numberOfFish" value="${pond.numberOfFish}" required>
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <label for="descriptionPond">Description</label>
                                    <input type="text" id="descriptionPond" name="descriptionPond" value="${pond.descriptionPond}" required>
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <label for="skimmer">Skimmer</label>
                                    <input type="number" id="skimmer" name="skimmer" value="${pond.skimmer}" required>
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

        <!-- footer -->
        <div id="footer"></div>
    </body>
    <style>
        .label-witdh{
            width: 30%;
            color: blue;
        }
        .span-witdh{
            width: 70%;
            display: block;
            color: #000;
        }
        .sub_span-highlight{
            color: red;
            font-weight: 500;
        }
    </style>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
    </script> 
    <script src="./assets/js/utils.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/11.0.5/swiper-bundle.min.js"></script>
    <script>
        const btnClose = document.querySelector('.btn-close-pond');
        const tableEdit = document.querySelector('.container__infor__pond');
        const btnOutOpen = document.querySelector('.edit-btn-out');
        const subTable = document.querySelector('.infor__pond-detail');

        btnOutOpen.addEventListener('click', function (e) {
            tableEdit.classList.add('open');
            e.stopPropagation();
        });
        btnClose.addEventListener('click', () => {
            tableEdit.classList.remove('open');
        });
        subTable.addEventListener('click', (e) => {
            e.stopPropagation();
        });
        document.addEventListener('click', () => {

            tableEdit.classList.remove('open');
        });

        const btnDelete = document.querySelector('.delete-btn-fish');
        btnDelete.addEventListener('click', (e) => {
            var isConfirm = confirm('Are you sure you want delete this pond ?');
            if (!isConfirm) {
                e.preventDefault();
            }
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
                },
            },
        });
    </script>
</html>