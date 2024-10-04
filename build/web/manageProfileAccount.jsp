<%-- 
    Document   : manageProfileAccount
    Created on : Oct 4, 2024, 11:24:49 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="CSS/style.css">
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <title>Account Detail</title>
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
            <h4>Võ Trường</h4>
            <p class="welcome-message">Welcome back</p>
          </div>
        </div>
        <ul class="menu">
          <li><a href="dashBoard.html"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li>
          <li><a href="account.html"><i class="fas fa-users"></i> Account Management</a></li>
          <li><a href="news.html"><i class="fas fa-newspaper"></i> News Management</a></li>
        </ul>
      </div>

      <!-- Main Content Section -->
      <div class="content-from">
        <!-- Account Detail Section -->
        <div id="container-form">
          <h2>Account Detail</h2>
        <div id="accountDetail">
          <p><strong>Profile Image:</strong></p>
          <img id="accountImage" alt="Profile Image" style="width: 100px;" />

          <p><strong>Account ID:</strong> <span id="accountId"></span></p>
          <p><strong>Name:</strong> <span id="accountName"></span></p>
          <p><strong>Address:</strong> <span id="accountAddress"></span></p>
          <p><strong>Date of Birth:</strong> <span id="accountDob"></span></p>
          <p><strong>Gender:</strong> <span id="accountGender"></span></p>
          <p><strong>Phone Number:</strong> <span id="accountPhone"></span></p>
          <p><strong>Position:</strong> <span id="accountPosition"></span></p>
        </div>
      </div>


        <button onclick="goBack()">Back</button>
      </div>
  </body>
</html>
