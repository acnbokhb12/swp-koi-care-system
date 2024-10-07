<%-- 
    Document   : manageOrderDetails
    Created on : Oct 6, 2024, 12:17:49 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manager Order Page</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font Google family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
        <!-- CSS -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminOrder.css">
    </head>

    <body>

        <div class="container_admin">
            <div id="db-wrapper">
                <!-- Sidebar -->
                <div id="sidebar_admin"></div>
                <!-- Header -->
                <header id="header"></header>
                <!-- Main Section -->
                <div class="right-navbar-admin-manage">
                    <!-- Main Content Section -->
                    <div class="content">
                        <h2>Order Details</h2>
                        <div class="order-info">
                            <p><strong>Order ID:</strong> #OD12345</p>
                            <p><strong>Order Date:</strong> 2024-10-03</p>
                            <p><strong>Status:</strong> Processing</p>
                            <p><strong>Address:</strong> 123 Main St, Springfield</p>
                            <p><strong>Phone:</strong> +1-234-567-890</p>
                        </div>
                        <h3>Product List</h3>
                        <table>
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Image</th>
                                    <th>Category</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Product A</td>
                                    <td><img class="order-details-image" src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp" alt="Product A"></td>
                                    <td>Category A</td>
                                    <td>$10.00</td>
                                    <td>2</td>
                                    <td>$20.00</td>
                                    <td class="button-cell"><a class="details-btn" href="manageProductDetails.jsp?productId=1">View Details</a></td> <!-- Added class here -->
                                </tr>
                                <tr>
                                    <td>Product B</td>
                                    <td><img class="order-details-image" src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp" alt="Product B"></td>
                                    <td>Category B</td>
                                    <td>$15.00</td>
                                    <td>1</td>
                                    <td>$15.00</td>
                                    <td class="button-cell"><a class="details-btn" href="manageProductDetails.jsp?productId=2">View Details</a></td> <!-- Added class here -->
                                </tr>
                                <tr>
                                    <td>Product C</td>
                                    <td><img class="order-details-image" src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp" alt="Product C"></td>
                                    <td>Category C</td>
                                    <td>$8.00</td>
                                    <td>3</td>
                                    <td>$24.00</td>
                                    <td class="button-cell"><a class="details-btn" href="manageProductDetails.jsp?productId=3">View Details</a></td> <!-- Added class here -->
                                </tr>
                            </tbody>
                        </table>
                        <div class="back-container">
                            <div class="total-price">
                                Total Amount: $59.00
                            </div>
                            <a class="back-button" href="manageOrder.jsp">Back</a>
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
        $('#sidebar_admin').load('utils.jsp #sidebar_manager');
    </script>
</html>
