<%-- 
    Document   : manageOrderDetails
    Created on : Oct 6, 2024, 12:17:49 PM
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
                    <!-- Main Content Section -->
                    <div class="content">
                        <h2>Order Details</h2>
                        <div class="order-info">
                            <c:if test="${not empty order}">
                                <p><strong>Order ID:</strong> #${order.id}</p>
                                <p><strong>Order Date:</strong> ${fn:substring(order.orderDate, 0, 10)}</p> <!-- Hiển thị ngày -->
                                <p><strong>Status:</strong> ${order.orderS.orderStatusName}</p> <!-- Có thể cần phải chuyển đổi mã trạng thái sang tên -->
                                <p><strong>Address:</strong> ${order.addressOrder}</p>
                                <p><strong>Phone:</strong> ${order.phone}</p>
                                <p><strong>Total Amount:</strong> <fmt:formatNumber value="${order.total}" pattern="#,###"/> đ</p>
                            </c:if>
                        </div>
                        <h3>Product List</h3>
                        <table>
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Image</th>
                                    <th>Category</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${orderItems}">
                                    <c:if test="${not empty item.product.nameProduct}">
                                        <tr>
                                            <td>${item.product.nameProduct}</td>
                                            <td><img class="order-details-image" src="${item.product.imgProduct}" alt="${item.product.nameProduct}"></td>
                                            <td>${item.product.categoryP.categoryName}</td>
                                            <td><fmt:formatNumber value="${item.unitPrice}" pattern="#,###"/> đ</td>
                                            <td>${item.quantity}</td>
                                            <td><fmt:formatNumber value="${item.unitPrice * item.quantity}" pattern="#,###"/> đ</td>
                                            <td class="button-cell">
                                                <a class="details-btn" href="MainController?action=productinformation&pid=${item.product.productID}">View Details</a>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${not empty orderItems && itemCount > 0}">
                            <ul class="pagination">
                                <c:if test="${tag > 1}">
                                    <li class="page-item">
                                        <a href="ManageOrderDetailsController?orderId=${order.id}&index=${tag - 1}" class="page-link text-dark">
                                            <i class="fa-solid fa-chevron-left"></i>
                                        </a>
                                    </li>
                                </c:if>

                                <!-- Page Links -->
                                <c:forEach begin="1" end="${endPage}" var="i">
                                    <li class="page-item ${tag == i ? 'active' : ''}">
                                        <a href="ManageOrderDetailsController?orderId=${order.id}&index=${i}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
                                            ${i}
                                        </a>
                                    </li>
                                </c:forEach>

                                <!-- Next Button -->
                                <c:if test="${tag < endPage}">
                                    <li class="page-item">
                                        <a href="ManageOrderDetailsController?orderId=${order.id}&index=${tag + 1}" class="page-link text-dark">
                                            <i class="fa-solid fa-chevron-right"></i>
                                        </a>
                                    </li>
                                </c:if>
                            </ul>
                        </c:if>
                        <div class="back-container">
                            <div class="total-price">
                                <c:if test="${not empty order}">
                                    Total Amount: <fmt:formatNumber value="${order.total}" pattern="#,###"/> đ
                                </c:if>
                            </div>
                            <a class="back-button" href="MainController?action=managerordermanage">Back</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp #sidebar_manager');
    </script>
</html>
