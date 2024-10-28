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
                                                <td>
                                                    ${order.orderS.orderStatusName}
                                                </td>
                                                <td>    
                                                    <fmt:formatNumber value="${order.total}" pattern="#,###"/> đ
                                                </td>
                                                <td>
                                                    <button class="edit-btn" onclick="window.location.href = 'manageOrderDetails.jsp?orderId=${order.id}'">
                                                        <i class="fas fa-edit"></i>
                                                    </button>
                                                    <button class="delete-btn">
                                                        <a href="#" class="text-danger" onclick="deleteOrder(${order.id})">
                                                            <i class="fas fa-trash"></i>
                                                        </a>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="confirm-btn" onclick="confirmOrder('#${order.id}')">
                                                        <i class="fas fa-check"></i> Confirm
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
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
    </body>
    <script>
        // Loading header and sidebar
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp #sidebar_manager');
        function confirmOrder(orderId) {
            if (confirm("Are you sure you want to confirm this order: " + orderId + "?")) {
                // Logic to handle the order confirmation
                // Example: AJAX request or redirection to the server-side confirmation process
                alert("Order " + orderId + " has been confirmed!");
            } else {
                alert("Order confirmation canceled.");
            }
        }
    </script>
</html>
