<%-- 
    Document   : productManagement
    Created on : Oct 3, 2024, 3:47:08 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <link rel="stylesheet" href="assets/css/product.css" />
    <title>Manager Page</title>
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
            <p class="welcome-message">Welcome back</p>
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
      <div class="content">
        <!-- Header with actions -->
        <div class="header">
          <h2>Product List</h2>
          <div class="actions">
            <a href="newProduct.jsp" class="create-new-product-button">
              <button id="createNewProduct">Create New Product</button>
            </a>
          </div>
        </div>
        <!-- Product Table -->
        <div class="table-container" id="productTableContainer">
          <table id="productTable">
            <thead>
              <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Description</th>
                <th>Category</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>#PD12387</td>
                <td>Example Product</td>
                <td>
                  <img
                    src="https://placehold.co/50x50"
                    alt="Image of Example Product"
                  />
                </td>
                <td>Sample description of the product.</td>
                <td>Category Name</td>
                <td>10</td>
                <td>$19.99</td>
                <td>
                  <button
                    class="details-btn"
                    onclick="window.location.href='productDetailsManagement.jsp'"
                  >
                    <i class="fas fa-info-circle"></i>
                  </button>
                  <button
                    class="edit-btn"
                    onclick="window.location.href='productUpdate.jsp'"
                  >
                    <i class="fas fa-edit"></i>
                  </button>
                  <button class="delete-btn">
                    <i class="fas fa-trash"></i>
                  </button>
                </td>
              </tr>
            </tbody>
          </table>

          <!-- Footer and Pagination -->
          <div class="footer">
            <p>Showing 1 of 1 entry</p>
            <div class="pagination">
              <button>Previous</button>
              <button>1</button>
              <button>Next</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
