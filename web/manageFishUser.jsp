<%-- 
    Document   : manageFishUser
    Created on : Oct 7, 2024, 12:57:36 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                            <h2>User List</h2>
                            <div class="actions"> 
                            </div>
                        </div>
                        <div class="table-container" id="fishTableContainer">
                            <table id="productTable">
                                <thead>
                                    <tr>
                                        <th>User ID</th>
                                        <th>User Name</th>
                                        <th>Image</th>  
                                        <th>View</th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>#PD12387</td>
                                        <td>Acum</td>
                                        <td>
                                            <img src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp" alt="Image of Tranquil Waters" />
                                        </td> 
                                        <td>
                                            <button class="edit-btn" onclick="window.location.href = 'manageFish.jsp'">
                                                <i class="fas fa-edit"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="footer">
                                <div class="pagination">
                                    <button><a href="" class="text-dark">Previous</a></button>
                                    <button><a href="" class="text-dark">1</a></button>
                                    <button><a href="" class="text-dark">Next</a></button>
                                </div>
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
