<%-- 
    Document   : productUpdate
    Created on : Oct 5, 2024, 12:21:29 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manager Page</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <!-- font awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Jquery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
        <!-- css -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminProduct.css">
    </head>

    <body>
        <div class="container_admin">
            <div id="db-wrapper">
                <div id="sidebar_admin"></div>
                <header id="header"> </header>
                <div class="right-navbar-admin-manage">
                    <div class="content">
                        <div class="header-information">
                            <h2>Product Information</h2>
                            <div class="button-group">
                                <a href="productUpdate.jsp" class="btn btn-primary" id="updateButton">Update Product</a>
                                <a href="#" class="btn btn-danger" id="deleteButton">Delete</a>
                            </div>
                        </div>
                        <div class="details-section">
                            <div class="product-wrapper">
                                <img
                                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdTvpksqwVza-WmPCNDXK-T00gAIh3cSUIYg&s"
                                    alt="Product Image"
                                    class="product-img"
                                    />
                                <div class="product-info-block">
                                    <div class="info-field">
                                        <label for="productID">Product ID:</label>
                                        <span id="productID">12345</span>
                                    </div>
                                    <div class="info-field">
                                        <label for="productName">Product Name:</label>
                                        <span id="productName">Koi Food</span>
                                    </div>
                                    <div class="info-field">
                                        <div class="info-item">
                                            <label for="productDescription">Description:</label>
                                            <span id="productDescription" class="description-text">
                                                High-quality food for Koi fish, packed with essential nutrients.
                                            </span>
                                        </div>
                                    </div>
                                    <div class="info-field">
                                        <label for="productCategory">Category:</label>
                                        <span id="productCategory">Food</span>
                                    </div>
                                    <div class="info-field">
                                        <label for="productPrice">Product Price:</label>
                                        <span id="productPrice">$20.00</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $('#header').load('utils.jsp #header_admin', () => {
                $.getScript('./assets/js/utilsAdmin.js');
            });
            $('#sidebar_admin').load('utils.jsp  #sidebar_manager');
        </script>
    </body>
</html>