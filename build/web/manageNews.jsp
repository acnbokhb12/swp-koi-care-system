<%-- 
    Document   : manageNews
    Created on : Oct 4, 2024, 2:00:56 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage News</title>
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
        <!-- Jquery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
        <!-- css -->  
        <link rel="stylesheet" href="./assets/css/base.css"> 
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminUser.css">
    </head>
    <body>
        <div class="container_admin">
            <div id="db-wrapper">
                <!-- start-sidebar -->
                <div id="sidebar_admin"></div>
                <!-- start header -->
                <header id="header">  </header>
                <!-- right -->
                <div class="right-navbar-admin-manage">
                    <div class="content">
                        <!-- Your code here -->
                        <!-- Title -->
                        <div class="header d-flex "> 
                            <h1 style="font-size: 3rem;">News List</h1>  
                            <div>
                                <a  class="link_add-account" href="MainController?action=newsInforCreate">Add News</a>
                            </div>
                        </div>
                        <!-- Search by Title -->
                        <div class="row row-user-main"> 
                            <div class="col-auto">
                                <!-- Toggle Buttons -->
                                <div class="form-toggle-buttons" style="margin-bottom: 5px">
                                    <button class="btn-edit-search" type="button" onclick="showSearchByTitle()">Search by Title</button>
                                    <button class="btn-edit-search" type="button" onclick="showSearchByCategory()">Search by Category</button>
                                </div>

                                <!-- Form for searching by Title -->
                                <form id="searchByTitleForm" action="AdminSearchNewsTitleController" method="get" class="table-search-form row gx-1 align-items-center" >
                                    <div class="col-auto contain-btn-search-order" style="display: flex;">
                                        <input type="text" name="newsTitle" class="search-order" placeholder="Search by title..." 
                                               value="${OldSearch}" style="margin-right: 10px; flex: 1;">
                                        <button class="btn-submit-search-order" type="submit">Search</button>
                                    </div>
                                </form>

                                <!-- Form for searching by Category -->
                                <form id="searchByCategoryForm" action="AdminSearchNewsCateController" method="get" class="table-search-form row gx-1 align-items-center" style="display: none;">
                                    <div class="col-auto contain-btn-select-order" style="display: flex; margin-left: 15px; ">
                                        <select class="contain-btn-select-search  " name="newsCategory" id="searchCategory" required style="margin-right: 10px; flex: 1; padding-left: 6px;">
                                            <option value="" disabled selected>Select a Category</option>
                                            <!-- Loop through each category -->
                                            <c:forEach  var="nct" items="${listNC}"  >
                                                <option value="${nct.id}" ${TagsNewsCate!=null && TagsNewsCate==nct.id ? 'selected' : ''}>${nct.name}</option>
                                            </c:forEach>
                                        </select>
                                        <button class="btn-submit-search-order" type="submit">Search</button>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <!-- List -->
                        <div class="table-container" id="accountTableContainer">

                            <table id="accountTable">
                                <thead>
                                    <tr>
                                        <th>News ID</th> 
                                        <th>Title</th>  
                                        <th>Category</th> 
                                        <th>Date</th>  
                                        <th>View</th> 
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${ListN}" var="newsItem">
                                        <tr>
                                            <td>${newsItem.newsID}</td> 
                                            <td class="address__acc">${newsItem.title}</td>
                                            <td>${newsItem.newsCategory.name}</td>
                                            <td> 
                                                <fmt:formatDate value="${newsItem.newsDate}" pattern="dd-MM-yyyy hh:mm" />
                                            </td>  
                                            <td class="text-center">
                                                <a class="p-0" href="MainController?action=adminNewsDetail&id=${newsItem.newsID}"> 
                                                    <button class="edit-btn"><i class="fas fa-edit"></i></button> 
                                                </a> 
                                                <a href="#" id="btn-delete-acc"  class="btn-delete-acc text-danger"> 
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>  
                                    </c:forEach>

                                </tbody>
                            </table>

                            <div class="pagination">
                                <ul class="pagination-list">
                                    <c:choose>
                                        <c:when test="${not empty OldSearch}">
                                            <c:if test="${tag > 1}">
                                                <li>
                                                    <a href="AdminSearchNewsTitleController?newsTitle=${OldSearch}&index=${tag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                                </li>
                                            </c:if>
                                            <c:forEach begin="1" end="${endPage}" var="i">
                                                <li>
                                                    <a class="${tag == i ? "active-page" : ""}" href="AdminSearchNewsTitleController?newsTitle=${OldSearch}&index=${i}">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${tag < endPage}">
                                                <li>
                                                    <a href="AdminSearchNewsTitleController?newsTitle=${OldSearch}&index=${tag + 1}"><i class="fa-solid fa-chevron-right"></i></a>
                                                </li>
                                            </c:if>
                                        </c:when>  
                                        
                                        <c:when test="${not empty OldSearchNewsCate}">
                                            <c:if test="${tag > 1}">
                                                <li>
                                                    <a href="AdminSearchNewsCateController?newsCategory=${OldSearchNewsCate}&index=${tag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                                </li>
                                            </c:if>
                                            <c:forEach begin="1" end="${endPage}" var="i">
                                                <li>
                                                    <a class="${tag == i ? "active-page" : ""}" href="AdminSearchNewsCateController?newsCategory=${OldSearchNewsCate}&index=${i}">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${tag < endPage}">
                                                <li>
                                                    <a href="AdminSearchNewsCateController?newsCategory=${OldSearchNewsCate}&index=${tag + 1}"><i class="fa-solid fa-chevron-right"></i></a>
                                                </li>
                                            </c:if>
                                        </c:when>          
                                                
                                        <c:otherwise>
                                            <c:if test="${tag > 1}">
                                                <li>
                                                    <a href="AdminManageNewsController?index=${tag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                                </li>
                                            </c:if>
                                            <c:forEach begin="1" end="${endPage}" var="i">
                                                <li>
                                                    <a class="${tag == i ? "active-page" : ""}" href="AdminManageNewsController?index=${i}">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <c:if test="${tag < endPage}">
                                                <li>
                                                    <a href="AdminManageNewsController?index=${tag + 1}"><i class="fa-solid fa-chevron-right"></i></a>
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
        <script>
            function toggleDateOptions() {
            const searchChoice = document.getElementById('searchChoice').value;
            const dateOptions = document.getElementById('dateOptions');
            if (searchChoice === 'date') {
            dateOptions.style.display = 'block';
            } else {
            dateOptions.style.display = 'none';
            }
            }
        </script>
    </body>
    <script>
        $('#header').load('utils.jsp #header_admin', () => {
        $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp  #sidebar_admin');
    </script>

    <script>
        // JavaScript functions to toggle forms
        function showSearchByTitle() {
        document.getElementById('searchByTitleForm').style.display = 'flex';
        document.getElementById('searchByCategoryForm').style.display = 'none'; 
        }

        function showSearchByCategory() {
        document.getElementById('searchByTitleForm').style.display = 'none';
        document.getElementById('searchByCategoryForm').style.display = 'flex';
        }
        
        window.onload = function() {
        var formStatus = "${tagSearch}";
        if (formStatus === 'category') {
            showSearchByCategory();
        } else {
            showSearchByTitle();
        }
    };
    </script>
    <script src="./assets/js/notification.js"></script>
    <script src="./assets/js/utils.js"></script>
</html>