<%-- 
    Document   : manageUpdateAccount
    Created on : Oct 4, 2024, 11:24:27 PM
--%>


<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Account</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <!-- font awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Jquery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/manageAccoutVTwo.css"> 
    </head>
    <body>
        <div class="container_admin">
            <div id="db-wrapper">
                <!-- start-sidebar -->
                <div id="sidebar_admin"></div>
                <!-- start header -->
                <header id="header"></header>

                <div class="right-navbar-admin-manage">
                    <div class=" ">
                        <div id="editAccountForm">
                            <h3 id="formTitle">Edit Account</h3>

                            <!-- Check if update was successful and display a message -->
                            <c:if test="${not empty isUpdated}">
                                <div class="alert alert-success">
                                    <strong>Success!</strong> The account was updated successfully.
                                </div>
                            </c:if>
                            <c:if test="${empty isUpdated}">
                                <div class="alert alert-danger">
                                    <strong>Error!</strong> There was an issue updating the account.
                                </div>
                            </c:if>

                            <form id="accountForm" action="adminAccountUpdate" method="POST">
                                <label for="accountId">Account ID:</label>
                                <input type="text" id="accountId" name="accoutId" value="${account.userID}" readonly><br>

                                <label for="accountEmail">Email:</label>
                                <input type="text" id="accountEmail" name="accountEmail" value="${account.email}" readonly><br>

                                <label for="accountName">Full Name:</label>
                                <input type="text" id="accountName" name="accountName" value="${account.fullName}" required><br>

                                <label for="accountAddress">Address:</label>
                                <input type="text" id="accountAddress" name="accountAddress" value="${account.address}" required><br>

                                <label for="accountGender">Gender:</label>
                                <select id="accountGender" name="accountGender" required>
                                    <option value="male" ${account.gender == 'male' ? 'selected' : ''}>Male</option>
                                    <option value="female" ${account.gender == 'female' ? 'selected' : ''}>Female</option>
                                </select><br> 

                                <label for="accountPhone">Phone Number:</label>
                                <input type="text" id="accountPhone" name="accountPhone" value="${account.phoneNumber}" required><br>

                                <label for="accountRole">Role:</label>
                                <select id="accountRole" name="accountRole" required>
                                    <option value="customer" ${account.userRole == 'customer' ? 'selected' : ''}>Customer</option>
                                    <option value="admin" ${account.userRole == 'admin' ? 'selected' : ''}>Admin</option>
                                    <option value="manager" ${account.userRole == 'manager' ? 'selected' : ''}>Manager</option> <!-- Added Manager Role -->
                                </select><br>


                                <label for="accountImage">Profile Image:</label>
                                <input type="file" id="imageInput" accept="image/*"><br>

                                <!-- Image Preview -->
                                <img id="imagePreview" class="mb-4" style="display: none; width: 100px; height: auto; margin-top: 10px;" />
                                <div class="buttons">
                                    <button type="submit">Save Changes</button> 
                                    <a href="MainController?action=adminAccountInformation&accid=${account.userID}" class="btn btn-cancel">Cancel</a>

                                </div>
                            </form>
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
        $('#sidebar_admin').load('utils.jsp  #sidebar_admin');

        const imageInput = document.getElementById('imageInput');
        const imagePreview = document.getElementById('imagePreview');

        imageInput.addEventListener('change', function () {
            const file = this.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    imagePreview.src = e.target.result;
                    imagePreview.style.display = 'block'; // Show image when file is selected
                };
                reader.readAsDataURL(file);
            } else {
                imagePreview.style.display = 'none'; // Hide image if no file is selected
            }
        });

        const formUpdateAcc = document.getElementById('accountForm');
        formUpdateAcc.addEventListener('submit', (e) => {
            const isConfirmed = confirm('Are you sure you want to submit this form?');
            if (!isConfirmed) {
                e.preventDefault();
            }
        });
    </script>

</html>
