<%-- 
    Document   : manageAddAccount
    Created on : Oct 4, 2024, 11:24:03 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <title>Create New Account</title>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <div class="profile">
                <img src="https://placehold.co/50x50" alt="Profile picture of the user">
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
        <!-- New/Edit Account Form -->
        <div id="container-form">
            <div id="newAccountForm">
                <h3 id="formTitle">Create New Account</h3>
                <button id="backToAccountManager" onclick="window.location.href='account.html'">Back to Account Manager</button>
                <form id="accountForm">
                    <label for="accountId">Account ID:</label>
                    <input type="text" id="accountId" required>

                    <label for="accountName">Full Name:</label>
                    <input type="text" id="accountName" required>

                    <label for="accountAddress">Address:</label>
                    <input type="text" id="accountAddress" required>

                    <label for="accountDob">Date of Birth:</label>
                    <input type="date" id="accountDob" required>

                    <label for="accountGender">Gender:</label>
                    <select id="accountGender" required>
                        <option value="" disabled selected>Select your gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>

                    <label for="accountPhone">Phone Number:</label>
                    <input type="text" id="accountPhone" required>

                    <label for="accountPosition">Position:</label>
                    <input type="text" id="accountPosition" required>

                    <!-- New Image Upload Field -->
                    <label for="accountImage">Profile Image:</label>
                    <input type="file" id="accountImage" accept="image/*" required>

                    <div class="form-actions">
                        <button type="submit">Save Changes</button>
                        <button type="button" onclick="cancelEdit()">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

