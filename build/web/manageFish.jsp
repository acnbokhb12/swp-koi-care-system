<%-- 
    Document   : manageFish
    Created on : Oct 6, 2024, 11:10:53 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manage Fish</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
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
                            <h2>Fish List</h2>
                            <div class="actions"> 
                            </div>
                        </div>
                        <div class="table-container" id="fishTableContainer">
                            <table id="productTable">
                                <thead>
                                    <tr>
                                        <th>Fish ID</th> 
                                        <th>Image</th>
                                        <th>Age</th>
                                        <th>Length</th>
                                        <th>Weight</th>
                                        <th>Gender</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="fish" items="${listFish}">
                                        <tr>
                                            <td>${fish.fishID}</td>
                                            <td>
                                                <img src="${fish.fishImage}" alt="Image of ${fish.fishName}" />
                                            </td>
                                            <td>${fish.age} years</td> 
                                            <td>${fish.length} cm</td>
                                            <td>${fish.weight} kg</td> 
                                            <td>${fish.gender}</td> 
                                            <td>
                                                <button class="edit-btn" onclick="window.location.href = 'manageFishDetail.jsp?fishID=${fish.fishID}'">
                                                    <i class="fas fa-edit"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>                            
                            </table>
                            <!-- Phân trang : Fish - 10  -->
                            <div class="footer">
                                <ul class="pagination">
                                    <!-- Nút Previous -->
                                    <c:if test="${tag > 1}">
                                        <li class="page-item">
                                            <a href="ManageFishController?index=${tag-1}&acid=${param.acid}" class="page-link text-dark">
                                                <i class="fa-solid fa-chevron-left"></i> Previous
                                            </a>
                                        </li>
                                    </c:if>

                                    <c:forEach var="i" begin="1" end="${endPage}" step="1">
                                        <c:if test="${i <= 3 || i >= endPage - 2 || (i >= tag - 1 && i <= tag + 1)}">
                                            <li class="page-item ${tag == i ? 'active' : ''}">
                                                <a href="ManageFishController?index=${i}&acid=${param.acid}" class="page-link text-dark ${tag == i ? 'active__page' : ''}">
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
                                            <a href="ManageFishController?index=${tag + 1}&acid=${param.acid}" class="page-link text-dark">
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

