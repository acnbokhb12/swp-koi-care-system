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
                            

        <style>

            .content .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }

            .content .header h2 {
                margin: 0;
                font-size: 3rem;
                font-weight: bold;
            }

            .content .header .actions {
                display: flex;
                align-items: center;
            }

            .content .header .actions button {
                margin-left: 10px;
                padding: 8px 12px;
                background-color: #007bff;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 14px;
                transition: background-color 0.3s ease;
            }

            .content .header .actions button:hover {
                background-color: #0056b3;
            }

            /*End Content*/


            /*Start Button*/
            .btn {
                background-color: orange;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
            }

            /* Để Fish và Pond nằm ngang trên cùng một dòng */
            .fish-pond-form {
                display: flex;
                width: 100%;
                justify-content: space-between;
                padding: 20px;
                background: #fff;
                border: 1px solid #ddd;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            .fish-container,
            .pond-container {
                width: 48%;
                padding: 15px;
            }

            .fish-image
            {
                max-width: 150px;
                height: auto;
                margin-right: 15px;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            }
            .pond-image {
                max-width: 150px;
                height: auto;
                margin-right: 15px;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            }

            .form-group {
                margin-bottom: 15px;
            }

            h3 {
                font-size: 1.5em;
                font-weight: bold;
                color: #444;
                border-bottom: 2px solid #ddd;
                padding-bottom: 10px;
                margin-bottom: 15px;
            }

            @media (max-width: 768px) {
                .fish-pond-form {
                    flex-direction: column;
                    align-items: center; 
                }

                .fish-container,
                .pond-container {
                    width: 100%; 
                    margin-bottom: 20px; 
                }
            }


            /*Star Fish*/
            .form-group {
                margin-bottom: 15px;
            }

            .form-group {
                display: flex;
                align-items: center;
                margin-bottom: 15px;
            }


            .fish-container {
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .fish-container h3 {
                font-size: 3rem;
                color: #333;
                margin-bottom: 15px;
                border-bottom: 2px solid #ddd;
                padding-bottom: 5px;
                text-align: center;
            }

            .fish-image { 
                max-width: 325px;
                width: 100%;
                border-radius: 10px;
                display: block;
                margin: 0 auto;
            }

            @media (max-width: 768px) {
                .form-horizontal {
                    flex-direction: column;
                }

                .fish-image {
                    max-width: 100%;
                    margin-bottom: 20px;
                }
            }



            /*Start Pond*/
            .pond-container {
                background-color: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }



            .pond-container h3 {
                font-size: 3rem;
                color: #333;
                margin-bottom: 15px;
                border-bottom: 2px solid #ddd;
                padding-bottom: 5px;
                text-align: center;
            }


            .pond-image {
                max-width: 500px; 
                width: 100%;
                border-radius: 10px;
                display: block;
                margin: 0 auto;
            }


            @media (max-width: 768px) {
                .pond-details-container {
                    flex-direction: column;
                }

                .pond-image {
                    max-width: 100%;
                    margin-bottom: 20px;
                }
            }
            /*Đơn vị thông số*/
            span{
                font-size: 2rem;
                color: red;
            }
            h4{
                font-size: 2rem;    
            }
            .sub_span-highlight{
                color: red;
                font-weight: 500;
            }

            .summary {
                border-bottom: 2px solid #007bff; 
                padding-bottom: 10px;
                margin-bottom: 15px; 
            }                  
        </style>                       
        <script>
            $('#header').load('utils.jsp #header_admin', () => {
                $.getScript('./assets/js/utilsAdmin.js');
            });
            $('#sidebar_admin').load('utils.jsp #sidebar_manager'); 
        </script>
    </body>
</html>
