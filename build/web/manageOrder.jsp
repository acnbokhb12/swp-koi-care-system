<%-- 
    Document   : manageProduct
    Created on : Oct 3, 2024
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manager Order Page</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font Google family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
        <!-- CSS -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminOrder.css">
    </head>

    <body>

        <div class="container_admin">
            <div id="db-wrapper">
                <!-- Sidebar -->
                <div id="sidebar_admin"></div>
                <!-- Header -->
                <header id="header"></header>
                <!-- Main Section -->
                <div class="right-navbar-admin-manage"> 
                    <!-- Main Content -->
                    <div class="content">
                        <div class="header">
                            <h2>Order List</h2>
                        </div>
                        <!--                        Search-->
                        <div class="row row-user-main"> 
                            <div class="col-auto">
                                <div class="form-toggle-buttons" style="margin-bottom: 5px">
                                    <button type="button" onclick="showSearchByCustomerName()">Search by Customer Name</button>
                                    <button type="button" onclick="showSearchByOrderDate()">Search by Order Date</button>
                                    <button type="button" onclick="showSearchByStatus()">Search by Status</button>
                                </div>  

                                <!-- Form for searching by Customer Name -->
                                <form id="searchByCustomerNameForm" action="ManagerSearchOrderByCustomerNameController" method="POST" class="table-search-form row gx-1 align-items-center">
                                    <div class="contain-btn-search-order">
                                        <select name="customerName" class="search-order" required>
                                            <c:forEach var="customer" items="${ListCN}">
                                                <option value="${customer}">${customer}</option>
                                            </c:forEach>
                                        </select>
                                        <button class="btn-submit-search-order" type="submit">Search</button>
                                    </div>
                                </form>
                                <!-- Form for searching by Order Date -->
                                <form id="searchByOrderDateForm" action="ManagerSearchOrderDateController" method="POST" class="table-search-form row gx-1 align-items-center" style="display: none;">
                                    <div class="date-range-form">
                                        <label for="startDate">Start Date</label>
                                        <input type="date" id="startDate" name="startDate" class="search-order" required>

                                        <label for="endDate">End Date</label>
                                        <input type="date" id="endDate" name="endDate" class="search-order" required>

                                        <button class="btn-submit-search-order" type="submit">Search</button>
                                    </div>
                                </form>

                                <!-- Form for searching by Status -->
                                <form id="searchByStatusForm" action="ManagerSearchStatusController" method="POST" class="table-search-form row gx-1 align-items-center" style="display: none;">
                                    <div class="contain-btn-select-order">
                                        <select class="contain-btn-select-search" name="status" id="status" required>
                                            <c:forEach var="status" items="${ListS}">
                                                <option value="${status.orderStatusID}">${status.orderStatusName}</option>
                                            </c:forEach>
                                        </select>
                                        <button class="btn-submit-search-order" type="submit">Search</button>
                                    </div>
                                </form>

                            </div>
                        </div>

                        <div class="table-container" id="orderTableContainer">
                            <div class="table-container" id="orderTableContainer">
                                <table id="orderTable">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Customer Name</th>
                                            <th>Order Date</th>
                                            <th>Order Time</th>
                                            <th>Status</th>
                                            <th>Total Money</th>
                                            <th>Actions</th>
                                            <th>Order Confirm</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="order" items="${ListO}">
                                            <tr>
                                                <td>#${order.id}</td>
                                                <td>${order.customerName}</td>
                                                <td>
                                                    <c:set var="orderDate" value="${order.orderDate}" />
                                                    <c:set var="formattedDate" value="${fn:substring(orderDate, 0, 10)}" />
                                                    ${formattedDate}
                                                </td>
                                                <td>
                                                    <c:set var="orderDate" value="${order.orderDate}" />
                                                    <c:set var="formattedTime" value="${fn:substring(orderDate, 11, 19)}" />
                                                    ${formattedTime} 
                                                </td>

                                                <td class="order-status 
                                                    ${order.orderS.orderStatusID == 1 ? 'order-pending' : 
                                                      order.orderS.orderStatusID == 2 ? 'order-processing' : 
                                                      order.orderS.orderStatusID == 3 ? 'order-completed' : ''}">
                                                        ${order.orderS.orderStatusName}
                                                    </td>

                                                    <td>    
                                                        <fmt:formatNumber value="${order.total}" pattern="#,###"/> đ
                                                    </td>
                                                    <td>
                                                        <a href="MainController?action=managerorderdetails&orderId=${order.id}" class="edit-btn">
                                                            <i class="fas fa-edit"></i>
                                                        </a>
                                                        <a href="MainController?action=managerorderdelete&orderId=${order.id}" 
                                                           class="text-danger delete-btn" 
                                                           onclick="return confirmDelete();">
                                                            <i class="fas fa-trash"></i>
                                                        </a>
                                                    </td>
                                                    <td>
                                                        <form action="ManagerChangeOrderStatusController" method="POST">
                                                            <input type="hidden" name="orderId" value="${order.id}">
                                                            <input type="hidden" name="index" value="${tag}">
                                                            <input type="hidden" name="newStatus" 
                                                                   value="${order.orderS.orderStatusID == 1 ? 2 : (order.orderS.orderStatusID == 2 ? 3 : '')}">
                                                            <button type="submit" class="confirm-btn" 
                                                                    ${order.orderS.orderStatusID == 3 ? 'disabled' : ''}>
                                                                <i class="fas fa-check"></i> Confirm
                                                            </button>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <!-- Footer and Pagination -->
                                    <div class="footer">
                                        <ul class="pagination">
                                            <c:if test="${tag > 1}">
                                                <li class="page-item">
                                                    <a href="ManagerOrderManageController?index=${tag - 1}" class="page-link text-dark">
                                                        <i class="fa-solid fa-chevron-left"></i>
                                                    </a>
                                                </li>
                                            </c:if>

                                            <c:set var="startPage" value="${tag - 1 < 1 ? 1 : tag - 1}" />
                                            <c:set var="lastPage" value="${tag + 1 > endPage ? endPage : tag + 1}" />

                                            <c:forEach begin="${startPage}" end="${lastPage}" var="i">
                                                <li class="page-item ${tag == i ? 'active' : ''}">
                                                    <a href="ManagerOrderManageController?index=${i}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
                                                        ${i}
                                                    </a>
                                                </li>
                                            </c:forEach>

                                            <c:if test="${tag < endPage}">
                                                <li class="page-item">
                                                    <a href="ManagerOrderManageController?index=${tag + 1}" class="page-link text-dark">
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
            </div>
        </body>
        <script>
            // Loading header and sidebar
            $('#header').load('utils.jsp #header_admin', () => {
                $.getScript('./assets/js/utilsAdmin.js');
            });
            $('#sidebar_admin').load('utils.jsp #sidebar_manager');

            function confirmDelete() {
                return confirm("Are you sure you want to delete this order?");
            }

            function showSearchByCustomerName() {
                document.getElementById('searchByCustomerNameForm').style.display = 'block';
                document.getElementById('searchByOrderDateForm').style.display = 'none';
                document.getElementById('searchByStatusForm').style.display = 'none';
            }

            function showSearchByOrderDate() {
                document.getElementById('searchByCustomerNameForm').style.display = 'none';
                document.getElementById('searchByOrderDateForm').style.display = 'block';
                document.getElementById('searchByStatusForm').style.display = 'none';
            }

            function showSearchByStatus() {
                document.getElementById('searchByCustomerNameForm').style.display = 'none';
                document.getElementById('searchByOrderDateForm').style.display = 'none';
                document.getElementById('searchByStatusForm').style.display = 'block';
            }
        </script>
    </html>
