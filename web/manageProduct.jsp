<%-- 
    Document   : productManagement
    Created on : Oct 3, 2024, 3:47:08 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> >
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
                                <form class="table-search-form row gx-1 align-items-center" action="">
                                    <div class="col-auto">
                                        <input type="text" class="search-order" placeholder="Search..." id="searchInput" required>
                                    </div>
                                    <div class="col-auto contain-btn-select-order">
                                        <select class="contain-btn-select-search" name="searchChoice" id="searchChoice" onchange="handleSearchChoice()">
                                            <option value="name" selected>Product Name</option>
                                            <option value="category">Category</option>
                                            <option value="price">Price</option>
                                        </select>
                                    </div>
                                    <!-- Các trường Min và Max Price được hiển thị kế bên khi chọn "Price" -->
                                    <div class="col-auto contain-price-range" id="priceRange" style="display:none;">
                                        <input type="number" class="search-order" id="minPrice" placeholder="Min Price" name="minPrice">
                                        <input type="number" class="search-order" id="maxPrice" placeholder="Max Price" name="maxPrice">
                                    </div>
                                    <div class="col-auto contain-btn-search-order">
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
                                            <td>${p.price}</td>
                                            <td> 
                                                <a href="MainController?action=productinformation&pid=${p.productID}" class="edit-btn">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                                <a href="MainController?action=productdelete&pid=${p.productID}" class="delete-btn" onclick="return confirm('Are you sure you want to delete this product?');">
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
                                    <!-- Previous Button -->
                                    <c:if test="${tag > 1}">
                                        <li class="page-item">
                                            <a href="ManageProductController?index=${tag-1}" class="page-link text-dark">
                                                <i class="fa-solid fa-chevron-left"></i>
                                            </a>
                                        </li>
                                    </c:if>

                                    <!-- Display current page and next two pages (4, 5, 6) -->
                                    <c:forEach begin="${tag}" end="${tag + 2}" var="i">
                                        <c:if test="${i <= endPage - 3}">
                                            <li class="page-item ${tag == i ? 'active' : ''}">
                                                <a href="ManageProductController?index=${i}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
                                                    ${i}
                                                </a>
                                            </li>
                                        </c:if>
                                    </c:forEach>

                                    <!-- Display "..." if there is a gap between page 6 and (endPage - 3) -->
                                    <c:if test="${tag + 2 < endPage - 2}">
                                        <li class="page-item disabled">
                                            <span class="page-link">...</span>
                                        </li>
                                    </c:if>

                                    <!-- Always show the last 3 pages (8, 9, 10) -->
                                    <c:forEach begin="${endPage - 2}" end="${endPage}" var="i">
                                        <li class="page-item ${tag == i ? 'active' : ''}">
                                            <a href="ManageProductController?index=${i}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
                                                ${i}
                                            </a>
                                        </li>
                                    </c:forEach>

                                    <!-- Next Button -->
                                    <c:if test="${tag < endPage}">
                                        <li class="page-item">
                                            <a href="ManageProductController?index=${tag+1}" class="page-link text-dark">
                                                <i class="fa-solid fa-chevron-right"></i>
                                            </a>
                                        </li>
                                    </c:if>
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
                <form action="" id="fomr_fill-add">
                    <div class="row row-add-detail"> 
                        <div class="col-4 " >
                            <div class="img-add-submit">
                                <div class="img-info-add">
                                    <img id="imagePreview" src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp" alt="Koi Pond" > 
                                </div>
                                <div class="add-img-detail"> 
                                    <input id="imageInput" type="file" required> 
                                </div>
                            </div>
                        </div>
                        <div class="col-8 edit-info">
                            <div class="text-right">
                                <button  class="btn-close-add">
                                    <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                                </button>
                            </div>
                            <h2 class="text-center">Create New Product</h2>
                            <form action="" class="fomr_fill-add">
                                <div class="row row-edit-info-detail">
                                    <div class="col-md-6 add-item-detail">
                                        <label for="name_p" >Product Name: </label >
                                        <input id="name_p" type="text" value="" placeholder="Enter name" required />
                                    </div> 
                                    <div class="col-md-6 add-item-detail">
                                        <label for="price_p" >Product Price: </label >
                                        <input id="price_p" type="number" value="" placeholder="Enter price" required/>
                                    </div>  
                                    <div class="col-md-6 add-item-detail">
                                        <label for="" >Category </label >
                                        <select class="add-item-detail-select"> 
                                            <option selected value="">Food</option>
                                            <option value="">Medicine</option>
                                            <option value="">Machine</option>
                                        </select>
                                    </div> 
                                    <div class="col-md-6 add-item-detail">
                                        <label for="desc_p">Description: </label>
                                        <input id="desc_p" type="text" value="" placeholder="Description" required /> 
                                    </div>  

                                </div>
                                <div class="text-center mt-3">
                                    <button type="submit" class="add-btn-utils blue-btn" style="margin-top: 10px">
                                        Confirm
                                    </button>                    
                                </div>
                            </form>
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
        const formAddProduct = document.getElementById('fomr_fill-add');
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

        function handleSearchChoice() {
            const searchChoice = document.getElementById("searchChoice").value;
            const priceRange = document.getElementById("priceRange");

            if (searchChoice === "price") {
                priceRange.style.display = "flex"; // Hiện các trường Min và Max Price kế bên
            } else {
                priceRange.style.display = "none"; // Ẩn khi không chọn "Price"
            }
        }


    </script>
</html>
