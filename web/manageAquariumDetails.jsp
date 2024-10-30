<%-- 
Document   : manageAquariumDetails
Created on : 28/10/2024, 10:35:53 PM
Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manage Fish Details</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminAquarium.css">
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
                            <h2>Management Aquarium Details</h2>
                        </div>

                        <form class="fish-pond-form">
                            <!-- Fish Information Section -->
                            <div class="fish-container">
                                <h3>Fish Information</h3>
                                <div class="form-group image-container">
                                    <img src="https://plus.unsplash.com/premium_photo-1723672584731-52b5f1a67543?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8a29pJTIwZmlzaHxlbnwwfHwwfHx8MA%3D%3D" alt="Image Fish" class="img-fluid fish-image" />
                                </div>
                                <div class="summary">
                                    <h4>Total Fishs: <span>${fishCount}</span></h4>
                                </div>
                                <h4 class="note">Management of Koi Fish Information</h4>
                                <button type="button" class="btn btn-primary" onclick="location.href = 'ManageFishController?acid=${acid}'">Manage List Fish</button>
                            </div>

                            <!-- Pond Information Section -->
                            <div class="pond-container">
                                <h3>Pond Information</h3>
                                <div class="form-group image-container">
                                    <img src="https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg" alt="Image Pond" class="img-fluid pond-image" />
                                </div>
                                <div class="summary">
                                    <h4>Total Ponds: <span>${pondCount}</span></h4>
                                </div>
                                <h4 class="note">Management of Koi Pond Information</h4>
                                <button type="button" class="btn btn-secondary" onclick="location.href = 'ManagerPondController?acid=${acid}'">Manage List Pond</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script>
            $('#header').load('utils.jsp #header_admin', () => {
                $.getScript('./assets/js/utilsAdmin.js');
            });
            $('#sidebar_admin').load('utils.jsp #sidebar_manager');
        </script>
    </body>
</html>
