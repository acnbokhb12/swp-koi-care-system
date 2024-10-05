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
    <title>Account Detail</title>
    <title>Manager Page</title>
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
     <link rel="stylesheet" href="./assets/css/manageAccoutVTwo.css">
  </head>
  <body>
     
    <div class="container_admin">
        <div id="db-wrapper">
             <!-- start-sidebar -->
             <div id="sidebar_admin"></div>
             <!-- start header -->
             <header id="header"></header>

             <div class="right-navbar-admin-manage">
                <div class="content" style="padding: 20px;">
                    <div class="header_ac-detail d-flex ">
                        <h1>Account Detail</h1>  
                        <div>
                            <a href="manageUpdateAccount.jsp" class="link_update-account" >Update Account</a>
                            <a href="" class="link_delete-account" >Delete Account</a>
                        </div>
                    </div>
                    <div class="content-from-container">
                        <!-- Account Detail Section --> 
                         <div class="row m-0" > 
                          <div class="col-lg-8" id="accountDetail"> 
                          <p><strong>Account ID:</strong> <span id="accountId">1</span></p>
                          <p><strong>Email:</strong> <span >acnbo@gmail.com</span></p>
                          <p><strong>Name:</strong> <span id="accountName">Khanh huynh ngoc</span></p>
                          <p><strong>Address:</strong> <span id="accountAddress">Tam phu, Tp.Thu Duc, Hcm city</span></p> 
                          <p><strong>Gender:</strong> <span id="accountGender">Man</span></p>
                          <p><strong>Phone Number:</strong> <span id="accountPhone">0123456789</span></p>
                          <p><strong>Role:</strong> <span id="accountPosition">Admin</span></p>
                          </div>
                          <div class="col-lg-4">
                            <div class="img-accout-detail">
                                <img src="https://scontent.fsgn2-3.fna.fbcdn.net/v/t1.6435-9/120846118_1393138717744114_5343318628172679837_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=1d70fc&_nc_ohc=HRW0w38pbEQQ7kNvgF_Y1rD&_nc_ht=scontent.fsgn2-3.fna&_nc_gid=ARzB8qdQeV6A2gtFkV7lUga&oh=00_AYDhskM-yEdWNkPKeY4tujMz6Vwn07AZEpNMCJn3qOn-hA&oe=67242460" alt="">
                            </div>
                            
                          </div>
                        </div>

                    </div>  
                </div>
             </div>
        </div>

    </div>
      <!-- Main Content Section -->
      
  </body>
  <style>
    body{
        background: url(https://static.wikia.nocookie.net/0dfbc1cb-6311-45e0-8b74-fc965ca9afc7);
        background-color: #e3e3e3;
        background-position: center;
 
    }

  </style>
  <script>
    $('#header').load('utils.jsp #header_admin', ()=>{
       $.getScript('./assets/js/utilsAdmin.js');
   });
   $('#sidebar_admin').load('utils.jsp  #sidebar_admin');
   const deleteAccount = document.querySelector('.link_delete-account');
    deleteAccount.addEventListener('click',(e)=>{
        const isConfirmed = confirm('Are you sure you want Delete this Account?');
        if(!isConfirmed){
            e.preventDefault();
        }
    });
</script>
</html>



