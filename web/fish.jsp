<%-- 
    Document   : fish
    Created on : Sep 30, 2024, 10:26:34 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Koi Fish</title>
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>    
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/fishE.css">
    </head>
    <body class="body-fish">
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->
        <div class="container container_fish">
            <div class="tilte-fish"> 
                <h1>Koi Fish</h1>
                <div class="button-container"> 
                    <button class="btn">Add New Fish</button>
                </div>
            </div>
            <div class="fish-list row mt-4">
                <c:forEach items="${listFish}" var="f">
                    <div class="fish-item-d col-lg-3 col-md-4 col-sm-6">    
                        <div class="fish-item">
                            <div class="fish-item-detail">
                                <div class="fish-img-detail">
                                    <img src="${f.fishImage}" alt="${f.fishName}">
                                </div>
                                <div class="fish-info">
                                    <a href="FishInforController?fid=${f.fishID}" class="link__to-fish-detail">${f.fishName}</a>
                                    <p>${f.descriptionKoi}</p>
                                    <a href="deleteFish?fishID=${f.fishID}" class="link-delete-fish">Delete</a> 
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>



        <!-- TABLE NEW -->
        <div class="container__infor__fish">
            <div class="infor__fish-detail">
                <div class="row row-fish-detail">
                    <div class="col-4  " style="padding: 0">
                        <div class="img-edit-submit">
                            <div class="fish-img-info-edit">
                                <img src="https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg" alt="Koi Pond" > 
                            </div>
                            <div class="fish-edit-img-detail">
                                <form action="" class="form-edit-img-fish">
                                    <input type="file">
                                    <button type="submit">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-8 edit-info">
                        <div class="text-right">
                            <button class="btn-close-fish">
                                <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                            </button>
                        </div>
                        <h2>New Information</h2>
                        <form>
                            <div class="row row-edit-info-detail">
                                <div class="col-md-6 edit-item-detail">
                                    <span>Fish Name </span>
                                    <input type="text" value="" placeholder="Enter fish name" />
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <span>Body Shape </span>
                                    <input type="text" value="" placeholder="Enter body shape" />
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <span>Age </span>
                                    <input type="number" value="" placeholder="Enter age" />
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <span>Length (cm) </span>
                                    <input
                                        type="number"
                                        step="0.1"
                                        value=""
                                        placeholder="Enter length in cm"
                                        />
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <span>Weight (kg) </span>
                                    <input
                                        type="number"
                                        step="0.1"
                                        value=""
                                        placeholder="Enter weight in kg"
                                        />
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <span>Gender </span>
                                    <select> 
                                        <option selected value="M">Male</option>
                                        <option value="F">Female</option>
                                    </select>
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <span>Origin </span>
                                    <input type="text" value="" placeholder="Enter origin" />
                                </div>
                            </div>
                            <div class="text-center">
                                <button class="edit-btn blue-btn" style="margin-top: 10px">
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
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
    </script>
    <script>
        const btnClose = document.querySelector(".btn-close-fish");
        const tableEdit = document.querySelector(".container__infor__fish");
        const btnAddNew = document.querySelector(".button-container button");
        const subTable = document.querySelector(".infor__fish-detail");

        btnAddNew.addEventListener("click", function (e) {
            tableEdit.classList.toggle("open");
            e.stopPropagation();
        });

        btnClose.addEventListener("click", () => {
            tableEdit.classList.remove("open");
        });

        subTable.addEventListener("click", (e) => {
            e.stopPropagation();
        });

        document.addEventListener("click", () => {
            tableEdit.classList.remove("open");
        });
    </script>
</html>