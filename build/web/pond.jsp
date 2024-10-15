<%-- 
    Document   : pond
    Created on : Sep 30, 2024, 10:43:57 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Koi Fish Ponds</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <!-- Font icon --> 
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
                <h1>Koi Fish Ponds</h1>
                <div class="button-container"> 
                    <button class="btn edit-btn-out">Add New Pond</button>
                </div>
            </div> 
            <div class="row pond-list">
                <c:forEach items="${listPonds}" var="po"  >
                    <div class="col-md-4 col-sm-6"> 
                        <div class="pond-item">
                            <div class="pond-item-detail">
                                <div class="pond-img-detail">
                                    <img src="${po.image}" alt="${po.name}">
                                </div>
                                <div class="pond-info">
                                    <a href="PondInforController?pid=${po.pondID}" class="link__to-pond-detail">${po.name}</a>
                                    <p>${po.descriptionPond}</p>
                                    <a href="#" class="link-delete-pond" data-pondid="${po.pondID}" data-toggle="modal" data-target="#myModal">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <!-- TABLE EDIT -->
        <div class="container__infor__pond">
            <div class="infor__pond-detail">
                <form action="MainController?action=newpond" method="post" enctype="multipart/form-data" id="fomr_fill-news" > 
                    <div class="row row-pond-detail">
                        <div class="col-4" style="padding: 0;">
                            <div class="img-edit-submit">
                                <div class="pond-img-info-edit">
                                    <img id="imagePreview" src="https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg" alt="Koi Pond" > 
                                </div>
                                <div class="pond-edit-img-detail" > 
                                    <input id="imageInput" name="fileimg" type="file" accept="image/*" required> 
                                </div>
                            </div>
                        </div>
                        <div class="col-8 edit-info">
                            <div class="text-right">
                                <button
                                    class="btn-close-pond"><i class="fa-solid fa-xmark close-navbar-icon-btn-pond"></i>
                                </button>
                            </div>
                            <h2>Add new pond</h2> 
                            <div class="row row-edit-info-detail">
                                <div class="row row-edit-info-detail">
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Pond Name: </span>
                                        <input type="text" class="pond-name" name="pondName" placeholder="Enter your pond name" required>
                                    </div>
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Depth (m): </span>
                                        <input type="number" class="pond-depth" name="depth" step="0.1" placeholder="Enter depth in meters" required>
                                    </div>
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Volume (l): </span>
                                        <input type="number" class="pond-volume" name="volume" min="0" placeholder="Enter volume in liters" required>
                                    </div>
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Drain Count: </span>
                                        <input type="number" class="drain-count" name="drainCount" min="1" placeholder="Enter number of drains" required>
                                    </div>
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Pump Power (l/h): </span>
                                        <input type="number" class="pump-power" name="pumpPower" min="1" placeholder="Enter pump power in liters per hour" required>
                                    </div>
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Quantity of Fish: </span>
                                        <input type="number" class="quantity-fish" name="numberOfFish" min="0" placeholder="Enter number of fish" required>
                                    </div>
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Description: </span>
                                        <input type="text" class="pond-description" name="descriptionPond" placeholder="Enter pond description" required>
                                    </div>
                                    <div class="col-md-6 edit-item-detail">
                                        <span>Skimmer: </span>
                                        <input type="number" class="skimmer" name="skimmer" min="0" placeholder="Enter skimmer quantity" required>
                                    </div>
                                </div>
                            </div>
                            <div class="text-center">
                                <button class="edit-btn" type="submit" style="margin-top: 10px; ">
                                    Confirm
                                </button>
                            </div> 
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- Modal Delete -->
        <div id="myModal" class="modal-confirm-delete" dísplay="none">
            <div class="modal-confirm">
                <div class="modal-content">
                    <div class="modal-header flex-column">
                        <div class="icon-box">
                            <i class="material-icons">&#xE5CD;</i>
                        </div>
                        <h4 class="modal-title w-100">Are you sure?</h4>
                        <button type="button" class="close-confirm-delete close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <p>Do you really want to delete this pond? This process cannot be undone.</p>
                    </div>
                    <div class="modal-footer justify-content-center">
                        <button type="button" class="btn-cancel-delete btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <form id="deleteForm" action="MainController?action=ponddelete" method="post">
                            <input type="hidden" name="pondID" id="pondIDToDelete">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
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
    </script>
    <script>
        $(document).ready(function () {
            $('#myModal').hide();
            $('.link-delete-pond').on('click', function () {
                const pondID = $(this).data('pondid');
                $('#pondIDToDelete').val(pondID);
                $('#myModal').show();
            });
            $('.close-confirm-delete, .btn-cancel-delete').on('click', function () {
                $('#myModal').hide();
            });
            $(window).on('click', function (event) {
                if (event.target.id === 'myModal') {
                    $('#myModal').hide();
                }
            });
        });
    </script>
    <script src="./assets/js/utils.js"></script>
</html>