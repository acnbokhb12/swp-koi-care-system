<%-- 
    Document   : manageNews
    Created on : Oct 4, 2024, 2:00:56 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage News</title>
     <!-- link logo img page -->
     <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
     <!-- Font gg family -->
     <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
         rel="stylesheet">
     <!-- Font icon -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
     <!-- bootstrap -->
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
         integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <!-- Jquery -->
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
     <!-- css -->  
     <link rel="stylesheet" href="./assets/css/base.css"> 
     <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
     <link rel="stylesheet" href="./assets/css/adminUser.css">
</head>
<body>
    <div class="container_admin">
        <div id="db-wrapper">
            <!-- start-sidebar -->
            <div id="sidebar_admin"></div>
            <!-- start header -->
            <header id="header">  </header>
            <!-- right -->
            <div class="right-navbar-admin-manage">
                <div class="content">
                    <!-- Your code here -->
                     <!-- Title -->
                    <div class="header d-flex "> 
                        <h1>News List</h1>  
                        <div>
                            <a  class="link_add-account" href="manageAddNews.jsp">Add News</a>
                        </div>
                    </div>
                    <!-- Search -->
                    <div class="row row-user-main"> 
                        <div class="col-auto">
                            <form class="table-search-form row gx-1 align-items-center" action="">
                                <div class="col-auto ">
                                    <input type="text" class="search-order" placeholder="Search..." id="searchInput">
                                </div>
                                <div class="col-auto contain-btn-select-order">
                                    <select class="contain-btn-select-search" name="searchChoice" id="searchChoice">
                                        <option value="email" selected>Title</option>
                                        <option value="phone">Name</option>
                                        <option value="phone">Category</option>
                                    </select>
                                </div>
                                <div class="col-auto contain-btn-search-order">
                                    <button class="btn-submit-search-order" type="submit">Search</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- List -->
                    <div class="table-container" id="accountTableContainer">
                         
                       <table id="accountTable">
                   <thead>
                       <tr>
                           <th>News ID</th> 
                           <th>Title</th>  
                           <th>Category</th> 
                           <th>Date</th> 
                           <th>Status</th> 
                           <th>View</th> 
                       </tr>
                   </thead>
                   <tbody>
                       <tr>
                           <td>1</td> 
                           <td class="address__acc">Top Japanese Koi Variety Identification Video</td>
                           <td>Fish news</td>
                           <td>20-01-2004</td> 
                           <td>Ative</td> 
                           <td class="text-center">
                               <a href="manageNewsDetailAdmin.jsp"> 
                                   <button class="edit-btn"><i class="fas fa-edit"></i></button> 
                               </a>
                           </td>
                       </tr>  
                   </tbody>
                       </table>
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
        </div>
    </div>
</body>
<script>
     $('#header').load('utils.jsp #header_admin', ()=>{
        $.getScript('./assets/js/utilsAdmin.js');
    });
    $('#sidebar_admin').load('utils.jsp  #sidebar_admin');
</script>
 
</html>