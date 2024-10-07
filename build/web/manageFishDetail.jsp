<%-- 
    Document   : manageFishDetail
    Created on : Oct 7, 2024, 12:58:43 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                            <h2>Fish Details</h2>
                        </div>
                        <div class="fish-container">
                            <form>
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label for="fishId">Fish ID:</label>
                                        <p id="fishId">#PD12387</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="customerName">Customer Name:</label>
                                        <p id="customerName" class="fish-detail">John Doe</p>
                                    </div>
                                </div>
                                <div class="form-group d-flex align-items-start">
                                    <img id="fishImage" src="https://i.pinimg.com/originals/6e/a6/f8/6ea6f87bd1266879a59c6d133d861616.png" alt="Tranquil Waters" class="img-fluid fish-image" />
                                    <div class="fish-details">
                                        <div class="form-group">
                                            <label for="fishName">Fish Name:</label>
                                            <p id="fishName" class="fish-detail">Tranquil Waters</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Description:</label>
                                            <p id="description" class="fish-detail">This is a beautiful Koi fish known for its vibrant colors and graceful swimming.</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="age">Age:</label>
                                            <p id="age" class="fish-detail">5 years</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="length">Length:</label>
                                            <p id="length" class="fish-detail">75 cm</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="weight">Weight:</label>
                                            <p id="weight" class="fish-detail">10 kg</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="gender">Gender:</label>
                                            <p id="gender" class="fish-detail">Male</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="origin">Origin:</label>
                                            <p id="origin" class="fish-detail">Japan</p>
                                        </div>

                                    </div>
                                </div>
                                 
                            </form>
                        </div>
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
