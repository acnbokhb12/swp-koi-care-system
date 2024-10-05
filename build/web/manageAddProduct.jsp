<%-- 
    Document   : newProduct
    Created on : Oct 3, 2024, 3:52:48 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
    <link
        href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
        rel="stylesheet"
    />
    <title>Add New Product</title>
</head>
<body>
    <div class="container">
        <!-- Sidebar Section -->
        <div class="sidebar">
            <div class="profile">
                <img
                    src="https://placehold.co/50x50"
                    alt="Profile picture of the user"
                />
                <div>
                    <h4>Manager</h4>
                </div>
            </div>
            <ul class="menu">
                <li>
                    <a href="orderManagement.jsp"
                        ><i class="fas fa-shopping-cart"></i> Order Management</a
                    >
                </li>
                <li>
                    <a href="productManagement.jsp"
                        ><i class="fas fa-box"></i> Product Management</a
                    >
                </li>
                <li>
                    <a href="customerFish.jsp"><i class="fas fa-fish"></i> Customer Fish</a>
                </li>
                <li>
                    <a href="customerWaterParameter.jsp"
                        ><i class="fas fa-water"></i> Customer Water Parameter</a
                    >
                </li>
            </ul>
        </div>

        <!-- Main Content Section -->
        <div class="main-content">
            <!-- Header -->
            <div class="content-header">
                <h2>Add New Product</h2>
            </div>

            <!-- Product Form Section -->
            <div class="form-section">
                <form id="newProductForm">
                    <div class="form-group">
                        <label for="productID">Product ID:</label>
                        <input type="text" id="productID" required />
                    </div>
                    <div class="form-group">
                        <label for="productName">Product Name:</label>
                        <input type="text" id="productName" required />
                    </div>
                    <div class="form-group">
                        <label for="productDescription">Description:</label>
                        <textarea id="productDescription" rows="4" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="productCategory">Category:</label>
                        <input type="text" id="productCategory" required />
                    </div>
                    <div class="form-group">
                        <label for="productQuantity">Quantity:</label>
                        <input type="number" id="productQuantity" required />
                    </div>
                    <div class="form-group">
                        <label for="productPrice">Product Price:</label>
                        <input type="text" id="productPrice" required />
                    </div>
                    <button type="submit" class="submit-button">Add Product</button>
                    <button type="button" class="cancel-button" onclick="location.href='productManagement.jsp'">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

