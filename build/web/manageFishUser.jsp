<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Manage User Accounts</title>
    <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
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
                        <h2>User List</h2>
                        <div class="actions"> 
                            <a href="addUser.jsp" class="btn btn-primary">Add User</a> <!-- Button to add a new user -->
                        </div>
                    </div>
                    <div class="table-container" id="userTableContainer">
                        <table id="productTable" class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>User ID</th>
                                    <th>User Name</th>
                                    <th>Image</th>  
                                    <th>Action</th>  
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Check if there are any accounts -->
                                <c:if test="${not empty listAccounts}">
                                    <!-- Use JSTL loop to display the account list -->
                                    <c:forEach var="account" items="${listAccounts}">
                                        <tr>
                                            <td>${account.userID}</td>
                                            <td>${account.fullName}</td>
                                            <td>
                                                <img src="${account.profileImage}" alt="User Image" style="width: 50px; height: 50px;"/>
                                            </td> 
                                            <td>
                                                <button class="edit-btn" onclick="window.location.href='MainController?action=fishuserlist&userfishid=${account.userID}'">
                                                    <i class="fas fa-edit"></i> <!-- Edit button -->
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty listAccounts}">
                                    <tr>
                                        <td colspan="4" class="text-center">No accounts found.</td> <!-- Message if no accounts are found -->
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                        <div class="footer">
                            <div class="pagination">
                                <button><a href="#" class="text-dark">Previous</a></button>
                                <button><a href="#" class="text-dark">1</a></button>
                                <button><a href="#" class="text-dark">Next</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        // Load header and sidebar from utils.jsp
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js'); // Load additional scripts for admin functionality
        });
        $('#sidebar_admin').load('utils.jsp #sidebar_manager'); // Load sidebar
    </script>
</body>
</html>
