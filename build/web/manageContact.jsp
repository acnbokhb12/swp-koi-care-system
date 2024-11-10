<%-- 
    Document   : manageContact
    Created on : Nov 8, 2024, 3:38:51 PM
    Author     : Khanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contact Management</title>
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
        <!-- css -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminUser.css">
    </head>

    <body style="background-color: #f1f5f9;">
        <div class="container_admin">
            <div id="db-wrapper">
                <!-- start-sidebar -->
                <div id="sidebar_admin"></div>
                <!-- start header -->
                <header id="header"></header>
                <div class="right-navbar-admin-manage">
                    <div class="content">
                        <div class="header d-flex ">
                            <h1>Contact List</h1>
                            <div>
                                <button class="link_add-account">Add New Account</button>
                            </div>
                        </div>
                        <div class="table-container" id="accountTableContainer"> 
                            <table id="accountTable">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>First Name</th>
                                        <th>Email</th>
                                        <th>Message</th> 
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach var="contact" items="${listContact}">
                                        <tr>
                                            <td>${contact.id}</td>
                                            <td>${contact.name}</td>
                                            <td>${contact.email}</td>
                                            <td class="address__acc">${contact.message}</td> 
                                            <td class="text-center">
                                                <a href="MainController?action=adminContactDetail&contactID=${contact.id}" style="text-decoration: none;">
                                                    <button class="edit-btn"><i class="fas fa-edit"></i></button>
                                                </a>

                                                <a href="MainController?action=adminDeleteAccContact&contactID=${contact.id}" id="btn-delete-acc" class="btn-delete-acc text-danger">
                                                    <i class="fas fa-trash"></i>
                                                </a>

                                            </td>
                                        </tr>
                                    </c:forEach>



                                </tbody>
                            </table>

                            <!--                            <p>Showing 1 of 1 entry</p>-->
                            <div class="pagination">
                                <ul class="pagination-list">
                                    <c:if test="${tag > 1}">
                                        <a href="AdminManageContactController?index=${tag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                        </c:if>

                                    <c:forEach var="i" begin="1" end="${endPage}">
                                        <a href="AdminManageContactController?index=${i}" 
                                           class="${i == tag ? 'active' : ''}">
                                            ${i}
                                        </a>
                                    </c:forEach>

                                    <c:if test="${tag < endPage}">
                                        <a href="AdminManageContactController?index=${tag + 1}"><i class="fa-solid fa-chevron-right"></i></a>
                                        </c:if>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${toastMessage != null}"> 
            <div id="toast" style="z-index: 10">  
                <div class="toast_main row ${toastMessage.equals('success') ? 'toast--success' : 'toast--error' }" style="display:flex">
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
        <style>
            .pagination-list li.active-page{
                background-color: orange;
            }
            .btn-edit-search{
                background-color: #edfdf6;
                padding: 6px 12px;
                font-size: 1.4rem;
                font-weight: 600;
                margin: 0 6px 10px 0;
                border: 1px solid #000;

            }
            .btn-edit-search:hover{
                background-color: #15a362;
                color: #fff;
            }
        </style>

    </body>
    <script>
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp  #sidebar_admin');

        const btnDeleteList = document.querySelectorAll('.btn-delete-acc');
        btnDeleteList.forEach(btn => {
            btn.addEventListener('click', (e) => {
                const sure = confirm('Are you sure you want to delete this account contact?');
                if (!sure) {
                    e.preventDefault(); // Ngăn không cho thực hiện hành động nếu người dùng chọn "Cancel"
                }
            });
        });
    </script>
    <script src="./assets/js/notification.js"></script>
    <script src="./assets/js/utils.js"></script>
</html>
