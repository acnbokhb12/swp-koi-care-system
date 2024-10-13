<%-- 
    Document   : profilePage
    Created on : Sep 30, 2024, 10:35:47 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" /> 
    <!-- Font gg family -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
        rel="stylesheet"> 
    <!-- Font icon --> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/profilePerson.css">
</head>
<body class="body-profile-page-big" >
    <!-- start header -->
         <div id="header"></div>
        <!-- end header -->
    <div class="container">
        <div class="content">
            <!-- Header -->
             
            <!-- User Info Section -->
            <div class="inside__img_per">
                <div class="profile-container">
                    <!-- User Profile Image and Name -->
                    <div class="custom-container">
                        <div class="img_profile">
                            <img src="${sessionScope.userAccount.profileImage}" class="profile-img" alt="User Profile Image">
                        </div>
                        <h1 class="user_name">Welcome ${sessionScope.userAccount.fullName}</h1>
                        <a href="MainController?action=editProfileJsp" class="infor">EDIT INFORMATION</a>
                        <a href="MainController?action=logout" class="infor">SIGN OUT</a>
                    </div>
            
                    <!-- Profile Details Section -->
                    <div class="profile-details">
                        <h1>Profile Details</h1>
                        <div class="row">
                            <div class="profile-item col-6 top">
                                <h3>Name</h3>
                                <p>${sessionScope.userAccount.fullName}</p>
                            </div>
                            <div class="profile-item col-6 top">
                                <h3>Email</h3>
                                <p>${sessionScope.userAccount.email}</p>
                            </div>
                            <div class="profile-item col-6 under">
                                <h3>Phone Number</h3>
                                <p>${sessionScope.userAccount.phoneNumber}</p>
                            </div>
                            <div class="profile-item col-6 under">
                                <h3>Address</h3>
                                <p>${sessionScope.userAccount.address}</p>
                            </div>
                            <!-- Add more profile details as needed -->
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
        <!-- footer -->
        <div id="footer"></div>
</body>
  <script>
    $('#header').load('utils.jsp #header__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
    $('#footer').load('utils.jsp #footer__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
</script>

</html>