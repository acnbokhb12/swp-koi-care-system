<%-- 
    Document   : manageProductUpdate
    Created on : Oct 7, 2024, 12:55:06 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Update Product</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <!-- font awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
                <header id="header"></header>
                <div class="right-navbar-admin-manage">
                    <div class="content">
                        <div class="header-information">
                            <h2>Update Product Information</h2>
                        </div>
                        <div class="update-product-section">
                            <div class="product-container">
                                <div class="product-details">
                                    <div class="form-container">
                                        <div class="form-wrapper">
                                            <div class="product-image-upload">
                                                <img src="${Product.imgProduct}" 
                                                     alt="${Product.nameProduct}" 
                                                     class="product-image-update"/> 
                                                <div class="img-detail-field">
                                                    <h3>Upload New Image</h3>
                                                    <div class="file-upload-container">
                                                        <form action="uploadProductImageServlet" method="POST" enctype="multipart/form-data" class="form-image-upload">
                                                            <input type="file" id="fishImage" name="fishImage" accept="image/*" required style="width: 100%;" />
                                                            <button type="submit" class="btn btn-upload">Submit</button>  
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <form action="MainController?action=productupdate" method="POST" class="form-update-details">
                                                <div class="details-wrapper">
                                                    <div class="detail-field">
                                                        <h1>Product ID</h1>
                                                        <input type="text" id="productID" name="productID" value="${Product.productID}" readonly style="width: 100%;" />
                                                    </div>
                                                    <div class="detail-field">
                                                        <h1>Product Name:</h1>
                                                        <input type="text" id="productName" name="productName" value="${Product.nameProduct}" required style="width: 100%;" />
                                                    </div>
                                                    <div class="detail-field">
                                                        <h1>Description:</h1>
                                                        <input type="text" id="productDescription" name="productDescription" value="${Product.description}" required style="width: 100%;" />
                                                    </div>
                                                    <div class="detail-field">
                                                        <h5>Select a category</h5>
                                                        <select id="productCategory" name="productCategory" required style="width: 100%;">
                                                            <c:forEach items="${ListC}" var="ct">
                                                                <option value="${ct.categoryID}" ${Product.categoryP.categoryID == ct.categoryID ? 'selected' : ''}>
                                                                    ${ct.categoryName}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="detail-field">
                                                        <h1>Product Price:</h1>
                                                        <input type="text" id="productPrice" name="productPrice" value="${Product.price}" required style="width: 100%;" />
                                                    </div>
                                                </div>
                                                <div class="action-buttons">
                                                    <button type="submit" class="btn btn-save">Submit</button>
                                                    <a href="MainController?action=productinformation&pid=${Product.productID}" class="btn btn-cancel">Cancel</a>
                                                </div>
                                            </form>
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
                    $('#sidebar_admin').load('utils.jsp #sidebar_manager');
                </script>
            </div>
        </div>
    </body>
</html>