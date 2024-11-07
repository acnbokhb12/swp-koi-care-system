<%-- 
    Document   : manageAccount
    Created on : Oct 5, 2024, 2:35:49 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Account Management</title> 
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="./assets/css/base.css"> 
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminUser.css">
    </head>

    <body> 
        <div class="container_admin">
            <div id="db-wrapper"> 
                <div id="sidebar_admin"></div>
                <header id="header"></header>

                <div class="right-navbar-admin-manage"> 
                    <div class="content">
                        <div class="header d-flex">
                            <h1>Account List</h1>  
                            <button type="button" class="link_add-account">Add New Account</button>
                        </div>

                        <form class="table-search-form row gx-1 align-items-center" method="get" action="AdminAccountController">
                            <input type="text" class="search-order" placeholder="Search..." id="searchInput" name="searchInput" required>
                            <select class="contain-btn-select-search" name="searchChoice" id="searchChoice">
                                <option value="email" selected>Email</option>
                                <option value="phone">Phone</option>
                                <option value="fullname">Full Name</option>
                            </select>
                            <button class="btn-submit-search-order" type="submit">Search</button>
                        </form>

                        <div class="table-container overflow-auto"> 
                            <div class="row row-order-processing m-0 mb-3">
                                <a class="link-processing" href="MainController?action=adminAccount">All</a>
                                <c:forEach var="statusId" items="${listAccS}">
                                    <a class="link-processing" href="MainController?action=adminAccountStatus&status=${statusId.statusID}">
                                        ${statusId.statusName}
                                    </a>
                                </c:forEach>
                            </div>  
                        </div> 

                        <div class="table-container">
                            <table id="accountTable" class="table">
                                <thead>
                                    <tr>
                                        <th>Account ID</th> 
                                        <th>Email</th> 
                                        <th>Full Name</th>  
                                        <th>Address</th> 
                                        <th>Phone Number</th> 
                                        <th>Role</th> 
                                        <th>Status</th>
                                        <th>Actions</th> 
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="acc" items="${listAcc}">
                                        <tr>
                                            <td>${acc.userID}</td>
                                            <td>${acc.email}</td>
                                            <td>${acc.fullName}</td>
                                            <td class="address__acc">${acc.address}</td>
                                            <td>${acc.phoneNumber}</td>
                                            <td>${acc.userRole}</td>
                                            <td>${acc.accstatus.statusName}</td>
                                            <td class="text-center">
                                                <a href="MainController?action=adminAccountInformation&accid=${acc.userID}" class="edit-btn"><i class="fas fa-edit"></i></a>
                                                <a href="MainController?action=adminAccountDelete&accid=${acc.userID}" class="delete-btn" id="delete-${acc.userID}">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="footer">
                                <ul class="pagination">
                                    <!-- Nút Previous -->

                                    <!--                                    Thêm Pagging cho status nữa cái đó bà tham khảo tự làm-->
                                    <c:if test="${tag > 1}">
                                        <li class="page-item">
                                            <a href="AdminAccountController?index=${tag-1}" class="page-link text-dark">
                                                <i class="fa-solid fa-chevron-left"></i> Previous
                                            </a>
                                        </li>
                                    </c:if>

                                    <c:forEach var="i" begin="1" end="${endPage}" step="1">
                                        <c:if test="${i <= 3 || i >= endPage - 2 || (i >= tag - 1 && i <= tag + 1)}">
                                            <li class="page-item ${tag == i ? 'active' : ''}">
                                                <a href="AdminAccountController?index=${i}" class="page-link text-dark">
                                                    ${i}
                                                </a>
                                            </li>
                                        </c:if>

                                        <c:if test="${i == 3 && tag > 4}">
                                            <li class="page-item disabled">
                                                <span class="page-link">...</span>
                                            </li>
                                        </c:if>

                                        <c:if test="${i == endPage - 2 && tag < endPage - 3}">
                                            <li class="page-item disabled">
                                                <span class="page-link">...</span>
                                            </li>
                                        </c:if>
                                    </c:forEach>

                                    <!-- Nút Next -->
                                    <c:if test="${tag < endPage}">
                                        <li class="page-item">
                                            <a href="AdminAccountController?index=${tag + 1}" class="page-link text-dark">
                                                Next <i class="fa-solid fa-chevron-right"></i>
                                            </a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container_main-add">
                <div class="contain_add-detail">
                    <form action="MainController?action=adminAccountCreate" id="form_fill-add" method="post" enctype="multipart/form-data">
                        <div class="row row-add-detail">
                            <div class="col-4">
                                <div class="img-add-submit">
                                    <div class="img-info-add">
                                        <img id="imagePreview" src="https://i.pinimg.com/564x/bc/43/98/bc439871417621836a0eeea768d60944.jpg" alt="account_image" class="account-image">
                                    </div>
                                    <input id="imageInput" type="file" name="fileimg" accept="image/*" required>
                                </div>
                            </div>
                            <div class="col-8 edit-info">
                                <button type="button" class="btn-close-add"><i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i></button>
                                <h1 class="text-center mb-4">Create New Account</h1>
                                <div class="row row-edit-info-detail">
                                    <div class="col-md-6 add-item-detail">
                                        <label>Email:</label>
                                        <input type="email" name="email" placeholder="Enter email" required />
                                    </div> 
                                    <div class="col-md-6 add-item-detail">
                                        <label>Full Name:</label>
                                        <input type="text" name="fullName" placeholder="Enter full name" required />
                                    </div> 
                                    <div class="col-md-6 add-item-detail">
                                        <label>Password:</label>
                                        <input type="password" name="password" placeholder="Enter password" required />
                                    </div>  
                                    <div class="col-md-6 add-item-detail">
                                        <label>Address:</label>
                                        <input type="text" name="address" placeholder="Enter address" required />
                                    </div> 
                                    <div class="col-md-6 add-item-detail">
                                        <label>Phone Number:</label>
                                        <input type="text" name="phoneNumber" placeholder="Enter phone number" required />
                                    </div>
                                    <div class="col-md-6 add-item-detail">
                                        <label>Gender:</label>
                                        <select name="gender" required class="form-control">
                                            <option value="Man" selected>Man</option>
                                            <option value="Woman">Woman</option>
                                            <option value="Other">Other</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6 add-item-detail">
                                        <label>Role:</label>
                                        <select name="role" required class="form-control">
                                            <option value="customer" selected>Customer</option>
                                            <option value="manager">Manager</option>
                                            <option value="admin">Admin</option>
                                        </select>
                                    </div>
                                </div>
                                <button type="submit" class="add-btn-utils blue-btn">Confirm</button>                    
                            </div>
                        </div>
                    </form> 
                </div>
            </div>

            <!-- Scripts -->
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script>
                $('#header').load('utils.jsp #header_admin', function () {
                    $.getScript('./assets/js/utilsAdmin.js');
                });
                $('#sidebar_admin').load('utils.jsp #sidebar_admin', function () {
                    $.getScript('./assets/js/utilsAdmin.js');
                });

                $(document).on('click', '.link_add-account', function () {
                    $('.container_main-add').css('display', 'flex');
                });

                $(document).on('click', '.btn-close-add', function () {
                    $('.container_main-add').css('display', 'none');
                });

                $('#imageInput').change(function () {
                    const file = this.files[0];
                    const reader = new FileReader();
                    reader.onload = function (e) {
                        $('#imagePreview').attr('src', e.target.result);
                    }
                    reader.readAsDataURL(file);
                });

                document.querySelectorAll('.delete-btn').forEach(button => {
                    button.addEventListener('click', function (event) {
                        if (!confirm('Are you sure you want to delete this account?')) {
                            event.preventDefault();
                        }
                    });
                });
            </script>
        </div>
    </body>
</html>
