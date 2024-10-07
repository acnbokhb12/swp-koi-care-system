<%-- 
    Document   : manageProduct
    Created on : Oct 3, 2024
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
                    <!-- Main Content -->
                    <div class="content">
                        <div class="header">
                            <h2>Order List</h2>
                        </div>
                        <div class="table-container" id="orderTableContainer">
                            <div class="table-container" id="orderTableContainer">
                                <table id="orderTable">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>Customer Name</th>
                                            <th>Order Date</th>
                                            <th>Status</th>
                                            <th>Total Money</th>
                                            <th>Actions</th>
                                            <th>Order Confirm</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- Example Order Row -->
                                        <tr>
                                            <td>#ORD12345</td>
                                            <td>John Doe</td>
                                            <td>2024-10-06</td>
                                            <td>Delivered</td>
                                            <td>$100.00</td>
                                            <td>
                                                <button class="edit-btn" onclick="window.location.href = 'manageOrderDetails.jsp'">
                                                    <i class="fas fa-edit"></i>
                                                </button>
                                                <button class="delete-btn">
                                                    <a href="#" class="text-danger">
                                                        <i class="fas fa-trash"></i>
                                                    </a>
                                                </button>
                                            </td>
                                            <td>
                                                <button class="confirm-btn" onclick="confirmOrder('#ORD12345')">
                                                    <i class="fas fa-check"></i> Confirm
                                                </button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <!-- Footer and Pagination -->
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
    </body>
    <script>
        // Loading header and sidebar
        $('#header').load('utils.jsp #header_admin', () => {
            $.getScript('./assets/js/utilsAdmin.js');
        });
        $('#sidebar_admin').load('utils.jsp #sidebar_manager');
        function confirmOrder(orderId) {
            if (confirm("Are you sure you want to confirm this order: " + orderId + "?")) {
                // Logic to handle the order confirmation
                // Example: AJAX request or redirection to the server-side confirmation process
                alert("Order " + orderId + " has been confirmed!");
            } else {
                alert("Order confirmation canceled.");
            }
        }
    </script>
</html>
