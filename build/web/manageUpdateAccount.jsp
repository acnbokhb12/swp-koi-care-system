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
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/manageAccoutVTwo.css">
        <style>

        </style>
    </head>
    <body>
        <div class="container_admin">
            <div id="db-wrapper">
                <div id="sidebar_admin"></div>
                <header id="header"></header>

                <div class="right-navbar-admin-manage">
                    <div class="form-container">
                        <!-- Left Section for Image Upload -->
                        <div class="left-section">
                            <h3 id="formTitle">Edit Account Image</h3>

                            <!-- Account Image Upload Section -->
                            <div class="img-edit-submit">
                                <div class="fish-img-info-edit">
                                    <img id="accountImagePreview" src="${account.profileImage}" alt="${account.fullName}" style="max-height: 200px; object-fit: unset;" />
                                </div>
                                <div class="fish-edit-img-detail">
                                    <form action="MainController?action=adminAccountUpdateImage" method="POST"  class="form-edit-img-account" enctype="multipart/form-data" onsubmit="return confirmSubmit('Are you sure you want to update product image');">>
                                        <input type="hidden" name="accountId" value="${account.userID}">
                                        <input id="imageInput" name="fileimg" type="file" accept="image/*" required>
                                        <!-- Image Preview -->
                                        <img id="imagePreview" class="mb-4" style="display: none; width: 100px; height: auto; margin-top: 10px;" />
                                        <button type="submit">Submit</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <!-- Right Section for Account Update Form -->
                        <div class="right-section">
                            <h3 id="formTitle">Edit Account</h3>

                            <!-- Account Update Form -->
                            <form id="accountForm" action="MainController?action=adminAccountUpdate" method="POST">
                                <label for="accountId">Account ID:</label>
                                <input type="text" id="accountId" name="accountId" value="${account.userID}" readonly><br>

                                <label for="accountEmail">Email:</label>
                                <input type="text" id="accountEmail" name="accountEmail" value="${account.email}" required><br>

                                <label for="accountName">Full Name:</label>
                                <input type="text" id="accountName" name="accountName" value="${account.fullName}" required><br>

                                <label for="accountAddress">Address:</label>
                                <input type="text" id="accountAddress" name="accountAddress" value="${account.address}" required><br>

                                <label for="accountGender">Gender:</label>
                                <select id="accountGender" name="accountGender" required>
                                    <option value="man" ${account.gender == 'Man' ? 'selected' : ''}>Man</option>
                                    <option value="woman" ${account.gender == 'Woman' ? 'selected' : ''}>Woman</option>
                                    <option value="other" ${account.gender == 'Other' ? 'selected' : ''}>Other</option>
                                </select><br>

                                <label for="accountPhone">Phone Number:</label>
                                <input type="text" id="accountPhone" name="accountPhone" value="${account.phoneNumber}" required><br>

                                <label for="accountRole">Role:</label>
                                <select id="accountRole" name="accountRole" required>
                                    <option value="customer" ${account.userRole == 'customer' ? 'selected' : ''}>Customer</option>
                                    <option value="admin" ${account.userRole == 'admin' ? 'selected' : ''}>Admin</option>
                                    <option value="manager" ${account.userRole == 'manager' ? 'selected' : ''}>Manager</option>
                                </select><br>

                                <div class="action-buttons">
                                    <button type="submit" class="btn btn-save">Submit</button>
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
        // Load the header and sidebar
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp #sidebar_admin');

        // Preview the image before uploading for Account Image
        const accountImageInput = document.getElementById('imageInput');
        const accountImagePreview = document.getElementById('imagePreview');

        accountImageInput.addEventListener('change', function () {
            const file = this.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    accountImagePreview.src = e.target.result;
                    accountImagePreview.style.display = 'block'; // Show image when file is selected
                };
                reader.readAsDataURL(file);
            } else {
                accountImagePreview.style.display = 'none'; // Hide image if no file is selected
            }
        });

        // Confirmation before submitting the form
        const formUpdateAcc = document.getElementById('accountForm');
        formUpdateAcc.addEventListener('submit', (e) => {
            const isConfirmed = confirm('Are you sure you want to submit this form?');
            if (!isConfirmed) {
                e.preventDefault();
            }
        });
    </script>

</html>
