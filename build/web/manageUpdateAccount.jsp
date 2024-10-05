<%-- 
    Document   : manageUpdateAccount
    Created on : Oct 4, 2024, 11:24:27 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Account</title>
    <!-- link logo img page -->
    <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
    <!-- Font gg family -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
        rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

     <!-- bootstrap -->
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
         integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <!-- Jquery -->
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
     <link rel="stylesheet" href="./assets/css/base.css">
     <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/tranAccount.css"> 
</head>
<body>
    <div class="container_admin">
        <div id="db-wrapper">
             <!-- start-sidebar -->
             <div id="sidebar_admin"></div>
             <!-- start header -->
             <header id="header"></header>

             <div class="right-navbar-admin-manage">
                <div class=" ">
                    <div id="editAccountForm">
                        <h3 id="formTitle">Edit Account</h3>
                        <form id="accountForm">
                            <label for="accountId">Account ID:</label>
                            <input type="text" id="accountId" readonly><br>
        
                            <label for="accountDob">Email:</label>
                            <input type="text" value="acnbok@gmail.com" id="accountDob" readonly><br>
        
                            <label for="accountName">Full Name:</label>
                            <input type="text" id="accountName" required><br>
        
                            <label for="accountAddress">Address:</label>
                            <input type="text" id="accountAddress" required><br>
        
                            <label for="accountGender">Gender:</label>
                            <select id="accountGender" required>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select><br> 
                            <label for="accountPhone">Phone Number:</label>
                            <input type="text" id="accountPhone" value="091234568" required><br>
        
                            <label for="accountGender">Role:</label>
                            <select id="accountGender" required>
                                <option value=" ">Customer</option>
                                <option value=" ">Admin</option>
                                <option value=" ">Admin</option>
                            </select><br>
        
                            <label for="accountImage">Profile Image:</label>
                            <input type="file" id="imageInput" accept="image/*"><br>
        
                            <!-- Image Preview -->
                            <img id="imagePreview" class="mb-4" style="display: none; width: 100px; height: auto; margin-top: 10px;" />
        
                            <div class="buttons">
                                <button type="submit">Save Changes</button> 
                            </div>
                        </form>
                    </div>
                </div>
             </div>

        </div>

        
    </div>
</body>
    <script>
          $('#header').load('utils.jsp #header_admin', ()=>{
       $.getScript('./assets/js/utilsAdmin.js')
   });
   $('#sidebar_admin').load('utils.jsp  #sidebar_admin');

   const imageInput = document.getElementById('imageInput');
    const imagePreview = document.getElementById('imagePreview');

    imageInput.addEventListener('change', function() {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                imagePreview.src = e.target.result;
                imagePreview.style.display = 'block'; // Hiện ảnh khi file được chọn
            };
            reader.readAsDataURL(file);
        } else {
            imagePreview.style.display = 'none'; // Ẩn ảnh nếu không có file nào được chọn
        }
    });

    const formUpdateAcc = document.getElementById('accountForm');
    formUpdateAcc.addEventListener('submit',(e)=>{
        const isConfirmed = confirm('Are you sure you want to submit this news?');
        if(!isConfirmed){
            e.preventDefault();
        }
    })
    </script>
</html>



