<%-- 
    Document   : managePond
    Created on : 29/10/2024, 1:31:10 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manage Pond</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminPond.css">
        <link rel="stylesheet" href="./assets/css/adminFish.css">

    </head>

    <body>

        <div class="container_admin">
            <div id="db-wrapper">
                <div id="sidebar_admin"></div>
                <header id="header"></header>
                <div class="right-navbar-admin-manage"> 

                    <!-- Main Content Section -->
                    <div class="content">
                        <div class="header">
                            <h2>Manage Pond List</h2>
                            <div class="actions"> 
                                <a href="MainController?action=accountfishmanage" class="btn btn-primary">Back to Account List</a> 
                            </div>
                        </div>
                        <div class="table-container" id="pondTableContainer">
                            <table id="productTable">
                                <thead>
                                    <tr>
                                        <th>Pond ID</th> 
                                        <th>Image</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Volume (l)</th>
                                        <th>Depth (m)</th>
                                        <th>Pump Power (l/h)</th>
                                        <th>Drain Count</th>
                                        <th>Skimmer</th>
                                        <th>Number of Fish</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="pond" items="${listPond}">
                                        <tr>
                                            <td>${pond.pondID}</td>
                                            <td>
                                                <img src="${pond.image}" alt="Image of ${pond.name}" />
                                            </td>
                                            <td>${pond.name}</td> 
                                            <td>${pond.descriptionPond}</td>

                                            <td><fmt:formatNumber value="${pond.volume}" pattern="0.0" /> (l)</td>

                                            <td><fmt:formatNumber value="${pond.depth}" pattern="0.0" /> (m)</td> 
                                            <td><fmt:formatNumber value="${pond.pumpPower}" pattern="0" /> (l/h)</td> 
                                            <td>${pond.drainCount}</td> 
                                            <td>${pond.skimmer}</td>
                                            <td>${pond.numberOfFish}</td>
                                            <td>
                                                <button class="edit-btn" onclick="window.location.href = 'ManagerPondDetailsController?pid=${pond.pondID}'">
                                                    <i class="fas fa-edit"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>



                                </tbody>                            
                            </table>
                            <!-- Pagination : Pond - 10  -->
                            <div class="footer">
                                <ul class="pagination">
                                    <!-- Previous Button -->
                                    <c:if test="${tag > 1}">
                                        <li class="page-item">
                                            <a href="ManagerPondController?index=${tag-1}" class="page-link text-dark">
                                                <i class="fa-solid fa-chevron-left"></i> Previous
                                            </a>
                                        </li>
                                    </c:if>

                                    <c:forEach var="i" begin="1" end="${endPage}" step="1">
                                        <c:if test="${i <= 3 || i >= endPage - 2 || (i >= tag - 1 && i <= tag + 1)}">
                                            <li class="page-item ${tag == i ? 'active' : ''}">
                                                <a href="ManagerPondController?index=${i}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
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

                                    <!-- Next Button -->
                                    <c:if test="${tag < endPage}">
                                        <li class="page-item">
                                            <a href="ManagerPondController?index=${tag + 1}" class="page-link text-dark">
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
        </div>

        <script>
            $('#header').load('utils.jsp #header_admin', () => {
                $.getScript('./assets/js/utilsAdmin.js');
            });
            $('#sidebar_admin').load('utils.jsp  #sidebar_manager');
        </script>
    </body>
</html>
