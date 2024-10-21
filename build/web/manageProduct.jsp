<%-- 
    Document   : productManagement
    Created on : Oct 3, 2024, 3:47:08 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> >
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
            <div id="db-wrapper" class="flex-column">                
                <!-- start-sidebar -->
                <div id="sidebar_admin"></div>
                <!-- start header -->
                <header id="header"> </header>
                <!-- right -->
                <div class="right-navbar-admin-manage"> 

                    <!-- Main Content Section -->
                    <div class="content">
                        <!-- Header with actions -->
                        <div class="header">
                            <h2>Product List</h2>
                            <div class="actions"> 
                                <button id="createNewProduct">Create New Product</button> 
                            </div>
                        </div>
                        <!--  -->
                        <div class="row row-user-main"> 
                            <div class="col-auto">
                                <div class="form-toggle-buttons" style="margin-bottom: 5px">
                                    <button type="button" onclick="showSearchByName()">Search by Product Name</button>
                                    <button type="button" onclick="showSearchByCategory()">Search by Category</button>
                                </div>
                                <form id="searchByNameForm" action="ManagerSearchProductNameController" method="POST" class="table-search-form row gx-1 align-items-center">
                                    <div class="col-auto contain-btn-search-order" style="display: flex;">
                                        <input type="text" name="searchInput" class="search-order" placeholder="Search Product by Name"  
                                               value="${OldSearch}" style="margin-right: 10px; flex: 1;">
                                        <button class="btn-submit-search-order" type="submit">Search</button>
                                    </div>
                                </form>
                                <!-- Form for searching by Category -->
                                <form id="searchByCategoryForm" action="ManagerSearchCategoryController" method="POST" class="table-search-form row gx-1 align-items-center" style="display: none;">
                                    <div class="col-auto contain-btn-select-order" style="display: flex;">
                                        <select class="contain-btn-select-search" name="categoryID" id="categoryID" required style="margin-right: 10px;">
                                            <option value="" disabled selected>Select a Category</option>
                                            <c:forEach var="category" items="${ListC}">
                                                <option value="${category.categoryID}">${category.categoryName}</option>
                                            </c:forEach>
                                        </select>
                                        <button class="btn-submit-search-order" type="submit">Search</button>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <!-- Product Table -->
                        <div class="table-container" id="productTableContainer">
                            <table id="productTable">
                                <thead>
                                    <tr>
                                        <th>Product ID</th>
                                        <th>Name</th>
                                        <th>Image</th> 
                                        <th>Category</th> 
                                        <th>Price</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ListP}" var="p">  
                                        <tr>
                                            <td>${p.productID}</td>
                                            <td>${p.nameProduct}</td>
                                            <td>
                                                <img src="${p.imgProduct}" alt="Image of ${p.nameProduct}" />
                                            </td> 
                                            <td>${p.categoryP.categoryName}</td> 
                                            <td>
                                                <fmt:formatNumber value="${p.price}" pattern="#,###"/>
                                            </td>
                                            <td> 
                                                <a href="MainController?action=productinformation&pid=${p.productID}" class="edit-btn">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                                <a href="MainController?action=productdelete&pid=${p.productID}" class="delete-btn" onclick="return confirm('Are you sure you want to delete this product ?');">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                            <!-- Footer and Pagination -->
                            <div class="footer">
                                <ul class="pagination">
                                    <c:choose>
                                        <c:when test="${not empty OldSearch}">
                                            <!-- Previous Button for product name search -->
                                            <c:if test="${tag > 1}">
                                                <li class="page-item">
                                                    <a href="ManagerSearchProductNameController?index=${tag - 1}&searchInput=${OldSearch}" class="page-link text-dark">
                                                        <i class="fa-solid fa-chevron-left"></i>
                                                    </a>
                                                </li>
                                            </c:if>

                                            <!-- Display all available pages -->
                                            <c:forEach begin="1" end="${endPage}" var="i">
                                                <li class="page-item ${tag == i ? 'active' : ''}">
                                                    <a href="ManagerSearchProductNameController?index=${i}&searchInput=${OldSearch}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
                                                        ${i}
                                                    </a>
                                                </li>
                                            </c:forEach>

                                            <!-- Next Button -->
                                            <c:if test="${tag < endPage}">
                                                <li class="page-item">
                                                    <a href="ManagerSearchProductNameController?index=${tag + 1}&searchInput=${OldSearch}" class="page-link text-dark">
                                                        <i class="fa-solid fa-chevron-right"></i>
                                                    </a>
                                                </li>
                                            </c:if>
                                        </c:when>
                                        <c:when test="${not empty cateID}">
                                            <!-- Previous Button for category search -->
                                            <c:if test="${tag > 1}">
                                                <li class="page-item">
                                                    <a href="ManagerSearchCategoryController?index=${tag - 1}&categoryID=${cateID}" class="page-link text-dark">
                                                        <i class="fa-solid fa-chevron-left"></i>
                                                    </a>
                                                </li>
                                            </c:if>

                                            <c:forEach begin="1" end="${endPage}" var="i">
                                                <li class="page-item ${tag == i ? 'active' : ''}">
                                                    <a href="ManagerSearchCategoryController?index=${i}&categoryID=${cateID}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
                                                        ${i}
                                                    </a>
                                                </li>
                                            </c:forEach>

                                            <!-- Next Button -->
                                            <c:if test="${tag < endPage}">
                                                <li class="page-item">
                                                    <a href="ManagerSearchCategoryController?index=${tag + 1}&categoryID=${cateID}" class="page-link text-dark">
                                                        <i class="fa-solid fa-chevron-right"></i>
                                                    </a>
                                                </li>
                                            </c:if>
                                        </c:when>
                                        <c:otherwise>
                                            <!-- Previous Button for normal case -->
                                            <c:if test="${tag > 1}">
                                                <li class="page-item">
                                                    <a href="ManageProductController?index=${tag - 1}" class="page-link text-dark">
                                                        <i class="fa-solid fa-chevron-left"></i>
                                                    </a>
                                                </li>
                                            </c:if>

                                            <c:set var="startPage" value="${tag - 2 < 1 ? 1 : tag - 2}"/>
                                            <c:set var="endPage" value="${startPage + 5 > endPage ? endPage : startPage + 5}"/>

                                            <c:forEach begin="${startPage}" end="${endPage}" var="i">
                                                <li class="page-item ${tag == i ? 'active' : ''}">
                                                    <a href="ManageProductController?index=${i}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
                                                        ${i}
                                                    </a>
                                                </li>
                                            </c:forEach>

                                            <!-- Next Button -->
                                            <c:if test="${tag < endPage}">
                                                <li class="page-item">
                                                    <a href="ManageProductController?index=${tag + 1}" class="page-link text-dark">
                                                        <i class="fa-solid fa-chevron-right"></i>
                                                    </a>
                                                </li>
                                            </c:if>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Table adn new product -->
        <div class="container_main-add">
            <div class="contain_add-detail">
                <form action="MainController?action=productcreatenew" id="form_fill-add" method="post" enctype="multipart/form-data">
                    <div class="row row-add-detail">
                        <div class="col-4">
                            <div class="img-add-submit">
                                <div class="img-info-add">
                                    <img id="imagePreview" src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp" alt="Koi Pond">
                                </div>
                                <div class="add-img-detail">
                                    <input id="imageInput" type="file" name="product_image" accept="image/*" required>
                                </div>
                            </div>
                        </div>
                        <div class="col-8 edit-info">
                            <div class="text-right">
                                <button type="button" class="btn-close-add">
                                    <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                                </button>
                            </div>
                            <h2 class="text-center">Create New Product</h2>
                            <div class="row row-edit-info-detail">
                                <div class="col-md-6 add-item-detail">
                                    <label for="name_p">Product Name: </label>
                                    <input id="name_p" name="product_name" type="text" value="" placeholder="Enter name" required />
                                </div>
                                <div class="col-md-6 add-item-detail">
                                    <label for="desc_p">Description: </label>
                                    <input id="desc_p" name="product_description" type="text" value="" placeholder="Description" required />
                                </div>
                                <div class="col-md-6 add-item-detail">
                                    <label for="category_p">Category: </label>
                                    <select id="category_p" name="product_category" class="add-item-detail-select">
                                        <c:forEach var="category" items="${ListC}">
                                            <option value="${category.categoryID}">${category.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6 add-item-detail">
                                    <label for="price_p">Product Price: </label>
                                    <input id="price_p" name="product_price" type="number" value="" placeholder="Enter price" required />
                                </div>
                            </div>
                            <div class="text-center mt-3">
                                <button type="submit" class="add-btn-utils blue-btn" style="margin-top: 10px">
                                    Confirm
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script>
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp  #sidebar_manager');

        const imageInput = document.getElementById('imageInput');
        const imagePreview = document.getElementById('imagePreview');

        imageInput.addEventListener('change', function () {
            const file = this.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    imagePreview.src = e.target.result;
                    imagePreview.style.display = 'block'; // Hiện ảnh khi file được chọn
                };
                reader.readAsDataURL(file);
            } else {
                imagePreview.style.display = 'none'; // Ẩn ảnh nếu không có file nào được chọn
            }
        });
        const formAddProduct = document.getElementById('form_fill-add');
        formAddProduct.addEventListener('submit', (e) => {
            const isConfirmed = confirm('Are you sure you want to submit this news?');
            if (!isConfirmed) {
                event.preventDefault();
            }
        });
        const btnCreatPr = document.getElementById('createNewProduct');
        const containerAdd = document.querySelector('.container_main-add');
        const closeContainerAdd = document.querySelector('.btn-close-add');
        const subContainerAdd = document.querySelector('.contain_add-detail')
                ;
        btnCreatPr.addEventListener('click', (e) => {
            containerAdd.classList.add('open');
            e.stopPropagation();
        });
        closeContainerAdd.addEventListener('click', () => {
            containerAdd.classList.remove('open');
        });
        subContainerAdd.addEventListener('click', (e) => {
            e.stopPropagation();
        });
        document.addEventListener('click', () => {
            containerAdd.classList.remove('open');

        });

        function showSearchByName() {
            document.getElementById("searchByNameForm").style.display = "block";
            document.getElementById("searchByCategoryForm").style.display = "none";
        }
        function showSearchByCategory() {
            document.getElementById("searchByCategoryForm").style.display = "block";
            document.getElementById("searchByNameForm").style.display = "none";
        }
        document.addEventListener("DOMContentLoaded", function () {
            showSearchByName();
        });

    </script>
</html>
