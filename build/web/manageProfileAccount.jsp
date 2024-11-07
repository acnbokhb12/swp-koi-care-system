<%-- 
    Document   : manageProfileAccount
    Created on : Oct 4, 2024, 11:24:49 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Account Detail</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/manageAccoutVTwo.css">
    </head>
    <body>

        <div class="container_admin">
            <div id="db-wrapper">
                <div id="sidebar_admin"></div>
                <header id="header"></header>

                <div class="right-navbar-admin-manage">
                    <div class="content" style="padding: 20px;">
                        <div class="header_ac-detail d-flex justify-content-between align-items-center">
                            <h1>Account Detail</h1>  
                            <div>
                                <a href="AdminUpdateInformationAccountController?accid=${account.userID}" class="link_update-account">Update Account</a>
                                <a href="AdminDeleteAccountController?accid=${account.userID}" class="link_delete-account">Delete Account</a>
                            </div>
                        </div>
                        <div class="content-from-container">
                            <div class="row m-0"> 
                                <div class="col-lg-8" id="accountDetail"> 
                                    <p><strong>Account ID:</strong> <span id="accountId" class="text-danger">${account.userID}</span></p>
                                    <p><strong>Role:</strong> <span id="accountPosition" class="text-danger">${account.userRole}</span></p>

                                    <p><strong>Email:</strong> <span>${account.email}</span></p>
                                    <p><strong>Name:</strong> <span id="accountName">${account.fullName}</span></p>
                                    <p><strong>Address:</strong> <span id="accountAddress">${account.address}</span></p> 
                                    <p><strong>Gender:</strong> <span id="accountGender">${account.gender}</span></p>
                                    <p><strong>Phone Number:</strong> <span id="accountPhone">${account.phoneNumber}</span></p>
                                </div>
                                <div class="col-lg-4">
                                    <div class="img-account-detail">
                                        <img src="${account.profileImage}" alt="Profile Image" class="img-fluid rounded-circle">
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
        </div>

        <style>
            body {
                background: url(https://static.wikia.nocookie.net/0dfbc1cb-6311-45e0-8b74-fc965ca9afc7) no-repeat center center fixed;
                background-size: cover;
                background-color: #e3e3e3;
            }
        </style>

        <script>
            $(document).ready(function () {
                $('#header').load('utils.jsp #header_admin', () => {
                    $.getScript('./assets/js/utilsAdmin.js');
                });
                $('#sidebar_admin').load('utils.jsp #sidebar_admin');

                const deleteAccount = document.querySelector('.link_delete-account');
                deleteAccount.addEventListener('click', (e) => {
                    const isConfirmed = confirm('Are you sure you want to delete this account?');
                    if (!isConfirmed) {
                        e.preventDefault();
                    }
                });
            });
        </script>
    </body>
</html>
