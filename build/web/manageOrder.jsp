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
                        <div class="header mb-3">
                            <h2 class="font-weight-bold ">Order List</h2>
                        </div>
                        <!--   Search-->
                        <div class="mb-4">
                            <form class="table-search-form row gx-1 align-items-center" action="ManagerOrderSearchController" method="POST">
                                <div class="col-auto ">
                                    <input  type="text" class="search-order m-0 pl-4 pr-4" placeholder="Search..." id="searchInput" name="searchInput" value="${param.searchInput}">
                                </div>
                                <div class="col-auto contain-btn-select-order">
                                    <select class="contain-btn-select-search m-0 pl-5 pr-5 " name="searchChoice" id="searchChoice">
                                        <option value="name" ${param.searchChoice == 'name' ? 'selected' : ''}>Name</option>
                                        <option value="phone" ${param.searchChoice == 'phone' ? 'selected' : ''}>Phone</option>
                                        <option value="address" ${param.searchChoice == 'address' ? 'selected' : ''}>Address</option>
                                    </select>
                                </div>
                                <div class="col-auto contain-btn-search-order">
                                    <button class="btn-submit-search-order" type="submit">Search</button>
                                </div>
                            </form>
                        </div> 

                        <div class="table-container overflow-auto" id="orderTableContainer"> 
                            <div class="row row-order-processing m-0 mb-3">
                                <a class="link-processing-order col-3 ${TagStatusId == null ? 'active' : ''}" href="MainController?action=managerordermanage">All</a>
                                <c:forEach var="statusId" items="${ListS}">
                                    <a class="link-processing-order col-3 ${TagStatusId==statusId.orderStatusID ? 'active' : ''}" href="ManagerOrderSearchByOrderStatusController?status=${statusId.orderStatusID}">${statusId.orderStatusName}</a> 
                                </c:forEach>
                            </div>    
                            <table id="orderTable">
                                <thead>
                                    <tr>
                                        <th>Order ID</th>
                                        <th>Customer Name</th>
                                        <th>Order Date</th>
                                        <th>Order Time</th>
                                        <th>Status</th>
                                        <th>Total Money</th>
                                        <th>Detail</th>
                                        <th>Delete</th>
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
                                                </td>
                                                <td>
                                                    <form action="MainController?action=managerorderdelete" method="POST" onsubmit="return confirmDelete();">
                                                        <input type="hidden" name="orderId" value="${order.id}">
                                                        <input type="hidden" name="index" value="${tag}">
                                                        <input type="hidden" name="statusId" value="${TagStatusId != null ? TagStatusId : ''}">
                                                        <button type="submit" class="text-danger delete-btn">
                                                            <i class="fas fa-trash"></i>
                                                        </button>
                                                    </form>
                                                </td>
                                                <td>
                                                    <form action="ManagerChangeOrderStatusController" method="POST" onsubmit="return confirmBeforeConfirm();">
                                                        <input type="hidden" name="orderId" value="${order.id}">
                                                        <input type="hidden" name="index" value="${tag}">
                                                        <input type="hidden" name="newStatus" 
                                                               value="${order.orderS.orderStatusID == 1 ? 2 : (order.orderS.orderStatusID == 2 ? 3 : '')}">
                                                        <input type="hidden" name="statusId" value="${TagStatusId != null ? TagStatusId : ''}">
                                                        <button type="submit" class="confirm-btn font-weight-bold ${order.orderS.orderStatusID == 3 ? 'd-none' : ''}" >
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
                                        <c:choose>
                                            <c:when test="${not empty searchChoice}">
                                                <c:if test="${tag > 1}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="ManagerOrderSearchController?searchInput=${param.searchInput}&searchChoice=${param.searchChoice}&index=${tag - 1}">
                                                            <i class="fa-solid fa-chevron-left"></i>
                                                        </a>
                                                    </li>
                                                </c:if>

                                                <c:forEach begin="${tag - 1 < 1 ? 1 : tag - 1}" end="${tag + 1 > endPage ? endPage : tag + 1}" var="i">
                                                    <li class="page-item ${tag == i ? 'active' : ''}">
                                                        <a class="page-link ${tag == i ? 'active__page' : ''}" href="ManagerOrderSearchController?searchInput=${param.searchInput}&searchChoice=${param.searchChoice}&index=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>

                                                <c:if test="${tag < endPage}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="ManagerOrderSearchController?searchInput=${param.searchInput}&searchChoice=${param.searchChoice}&index=${tag + 1}">
                                                            <i class="fa-solid fa-chevron-right"></i>
                                                        </a>
                                                    </li>
                                                </c:if>
                                            </c:when>
                                            <c:when test="${not empty TagStatusId}">
                                                <c:if test="${tag > 1}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="ManagerOrderSearchByOrderStatusController?status=${TagStatusId}&index=${tag - 1}">
                                                            <i class="fa-solid fa-chevron-left"></i>
                                                        </a>
                                                    </li>
                                                </c:if>

                                                <c:forEach begin="${tag - 1 < 1 ? 1 : tag - 1}" end="${tag + 1 > endPage ? endPage : tag + 1}" var="i">
                                                    <li class="page-item ${tag == i ? 'active' : ''}">
                                                        <a class="page-link ${tag == i ? 'active__page' : ''}" href="ManagerOrderSearchByOrderStatusController?status=${TagStatusId}&index=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>

                                                <c:if test="${tag < endPage}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="ManagerOrderSearchByOrderStatusController?status=${TagStatusId}&index=${tag + 1}">
                                                            <i class="fa-solid fa-chevron-right"></i>
                                                        </a>
                                                    </li>
                                                </c:if>
                                            </c:when>

                                            <c:otherwise>
                                                <c:if test="${tag > 1}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="ManagerOrderManageController?index=${tag - 1}">
                                                            <i class="fa-solid fa-chevron-left"></i>
                                                        </a>
                                                    </li>
                                                </c:if>

                                                <c:set var="startPage" value="${tag - 1 < 1 ? 1 : tag - 1}" />
                                                <c:set var="lastPage" value="${tag + 1 > endPage ? endPage : tag + 1}" />

                                                <c:forEach begin="${startPage}" end="${lastPage}" var="i">
                                                    <li class="page-item ${tag == i ? 'active' : ''}">
                                                        <a class="page-link ${tag == i ? 'active__page' : ''}" href="ManagerOrderManageController?index=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>

                                                <c:if test="${tag < endPage}">
                                                    <li class="page-item">
                                                        <a class="page-link" href="ManagerOrderManageController?index=${tag + 1}">
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

            <!--        Thong bao-->
            <c:if test="${not empty sessionScope.toastMessage}">
                <div id="toast" style="z-index: 10">  
                    <div class="toast_main row ${sessionScope.toastMessage == 'success' ? 'toast--success' : 'toast--error' }" style="display:flex">
                        <div class="toast__icon">
                            <i class="fa-solid ${sessionScope.toastMessage == 'success' ? 'fa-circle-check' : 'fa-times-circle' }"></i>
                        </div>
                        <div class="toast_body">
                            <h3 class="toast__title">${sessionScope.toastMessage == 'success' ? 'Success' : 'Error' }</h3>
                            <p class="toast__msg">${sessionScope.message}</p>
                        </div>
                        <div class="toast__close">
                            <i class="fas fa-times"></i>
                        </div>
                    </div>
                </div>
                <!-- Remove the toast message and message attributes after displaying them -->
                <c:remove var="toastMessage" scope="session"/>
                <c:remove var="message" scope="session"/>
            </c:if>

            <style>
                #toast{
                    top: 6.2rem;
                }
                .btn-submit-search-order{
                    background-color: #78bf4d;
                    color: #000;
                    padding: 8px 20px;
                }
                .btn-submit-search-order:hover{
                    background-color: #15a362;
                    color: #fff;
                }
                .row-order-processing{
                    background: #fff;
                    padding: 0;
                    margin-bottom: 2.4rem;
                }
                .link-processing-order{
                    color: #5d6778;
                    text-decoration: none;
                    text-align: center;
                    font-size: 1.6rem;
                    font-weight: 700;
                    padding: 0.8rem 1.6rem;
                }
                .link-processing-order:hover{
                    color: var(--color-word);
                    background: #edfdf6;
                    text-decoration: none;
                }
                .link-processing-order.active{
                    color: var(--color-word);
                    border-bottom: 2px solid var(--color-word);
                }
                
            </style>
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
            function confirmBeforeConfirm() {
                return confirm("Are you sure you want to confirm this order?");
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

            document.getElementById("searchByOrderDateForm").addEventListener("submit", function (event) {
                const startDate = document.getElementById("startDate").value;
                const endDate = document.getElementById("endDate").value;

                const start = new Date(startDate);
                const end = new Date(endDate);

                if (start > end) {
                    event.preventDefault();
                    alert("From Date should be earlier than or the same as End Date.");
                }
            });
        </script>
        <script src="./assets/js/notification.js"></script> 
    </html>
