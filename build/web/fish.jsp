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
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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
                                    <a href="MainController?action=fishinfor&fid=${f.fishID}" class="link__to-fish-detail">${f.fishName}</a>
                                    <p>${f.descriptionKoi}</p>
                                    <a class="link-delete-fish" data-fishid="${f.fishID}" data-fishname="${f.fishName}" data-pondid="${f.pondID}" data-toggle="modal" data-target="#myModal">Delete</a>

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
        <form action="FishCreateNewController" method="post" enctype="multipart/form-data" id="form_fill-news">  
            <div class="row row-fish-detail">
                <div class="col-4" style="padding: 0">
                    <div class="img-edit-submit">
                        <div class="fish-img-info-edit mb-4">
                            <img id="imagePreview" src="https://plus.unsplash.com/premium_photo-1723672584731-52b5f1a67543?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8a29pJTIwZmlzaHxlbnwwfHwwfHx8MA%3D%3D" alt="Koi Pond"> 
                        </div>
                        <div class="fish-edit-img-detail"> 
                            <input id="imageInput" name="fileimg" type="file" accept="image/*" > 
                        </div>
                    </div>
                </div>
                <div class="col-8 edit-info">
                    <div class="text-right">
                        <button class="btn-close-fish">
                            <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                        </button>
                    </div>
                    <h2>Add New Fish</h2> 
                    <div class="row row-edit-info-detail">
                        <div class="col-md-6 edit-item-detail">
                            <span>Fish Name </span>
                            <input type="text" name="fishName" placeholder="Enter fish name" required/>
                        </div>
                        <div class="col-md-6 edit-item-detail">
                            <span>Body Shape</span>
                            <select name="bodyShape" style="width: 100%; padding: 4px; border: 1px solid #000;">  
                                <option value="Slim" selected>Slim</option>
                                <option value="Fat">Fat</option>
                                <option value="Long">Long</option>
                                <option value="Short">Short</option>
                                <option value="Large">Large</option>
                                <option value="Small">Small</option>
                            </select>
                        </div>
                        <div class="col-md-6 edit-item-detail">
                            <span>Age <span style="color: red; font-weight:bold;">(year(s))</span></span>
                            <input type="number" name="age" step="0.1" min="0.1" max="1000" placeholder="Enter age" required />
                        </div>
                        <div class="col-md-6 edit-item-detail">
                            <span>Length <span style="color: red; font-weight:bold;">(cm)</span></span>
                            <input type="number" name="length" step="0.1" max="10000" placeholder="Enter length in cm" required />
                        </div>
                        <div class="col-md-6 edit-item-detail">
                            <span>Weight <span style="color: red; font-weight:bold;">(kg)</span></span>
                            <input type="number" name="weight" step="0.1" min="0.1" max="1000"  placeholder="Enter weight in kg" required />
                        </div>
                        <div class="col-md-6 edit-item-detail">
                            <span>Gender</span>
                            <select name="gender" style="width: 100%; padding: 4px; border: 1px solid #000;"> 
                                <option selected value="Male">Male</option>
                                <option value="Female">Female</option>
                            </select>
                        </div>
                        <div class="col-md-6 edit-item-detail">
                            <span>Description</span>
                            <input type="text" name="descriptionKoi" placeholder="Enter description" required/>
                        </div>
                        <div class="col-md-6 edit-item-detail">
                            <span>Pond</span>
                            <select name="pondkoi" style="width: 100%; padding: 4px; border: 1px solid #000;">
                                <option value="0" selected>Unassigned</option>
                                <c:if test="${ListPond != null}">                                    
                                    <c:forEach items="${ListPond}" var="pd">
                                        <option value="${pd.pondID}">${pd.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                    </div>
                    <div class="text-center">
                        <button class="edit-btn blue-btn" type="submit" style="margin-top: 10px">
                            Confirm
                        </button>                    
                    </div> 
                </div>
            </div>
        </form>      
    </div>
</div>

        <!-- Modal Delete -->
        <div id="myModal" class="modal-confirm-delete" style="display: none;">
            <div class="modal-confirm">
                <div class="modal-content">
                    <div class="modal-header flex-column">
                        <div class="icon-box">
                            <i class="material-icons">&#xE5CD;</i>
                        </div>
                        <h4 class="modal-title w-100">Are you sure?</h4>
                        <button type="button" class="close-confirm-delete close" data-dismiss="modal" aria-hidden="true" style="font-size: 30px; color: #000">&times;</button>
                    </div>
                    <div class="modal-body">
                        <p  style="font-size: 16px; color: #000;">Do you really want to delete <span style="color: #000; font-weight: 600; background-color: #ff5656; padding: 4px 10px; border-radius: 4px;" id="fishNameDisplay"></span> ? This process cannot be undone.</p>
                    </div>
                    <div class="modal-footer justify-content-center">
                        <button type="button" class="btn-cancel-delete btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <form id="deleteForm" action="MainController?action=fishdelete" method="post">
                            <input type="hidden" name="fishID" id="fishIDToDelete">
                            <input type="hidden" name="pondID" id="pondIDToCaculate">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Toast -->
        <c:if test="${toastMessage != null}"> 
        <div id="toast">  
            <div class="toast_main row ${toastMessage.equals('success') ? 'toast--success' : 'toast--error' }">
                <div class="toast__icon">
                    <i class="fa-solid ${toastMessage.equals('success') ? 'fa-circle-check' : 'fa-times-circle' }"></i>
                </div>
                <div class="toast_body">
                    <h3 class="toast__title">${toastMessage.equals('success') ? 'Success' : 'Error' }</h3>
                    <p class="toast__msg">${message}</p>
                </div>
                <div class="toast__close">
                    <i class="fas fa-times"></i>
                </div>
            </div>
        </div>
        </c:if>

        <!-- footer -->
        <div id="footer"></div> 
        <style>
            .link-delete-fish:hover{
                cursor: pointer;
            }
            
            .link__to-fish-detail:hover{
                text-decoration: underline;
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
    <script src="./assets/js/utils.js"></script> 
    <script src="assets/js/notification.js"></script>
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
    <script>
        $(document).ready(function () {
            $('#myModal').hide();
            $('.link-delete-fish').on('click', function () {
                const fishID = $(this).data('fishid');
                const pondID = $(this).data('pondid');
                const fishName = $(this).data('fishname');
                $('#fishIDToDelete').val(fishID);
                $('#pondIDToCaculate').val(pondID); 
                $('#fishNameDisplay').text(fishName); 
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
</html>