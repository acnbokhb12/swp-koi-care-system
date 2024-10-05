<%-- 
    Document   : manageAccount
    Created on : Oct 5, 2024, 2:35:49 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Account Management</title> 
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
                    <div class="header d-flex ">
                        <h1>Account List</h1>  
                        <div>
                            <button class="link_add-account" >Add New Account</button>
                        </div>
                    </div>
                    <!--  -->
                    <div class="row row-user-main"> 
                        <div class="col-auto">
                            <form class="table-search-form row gx-1 align-items-center" action="">
                                <div class="col-auto ">
                                    <input type="text" class="search-order" placeholder="Search..." id="searchInput" required>
                                </div>
                                <div class="col-auto contain-btn-select-order">
                                    <select class="contain-btn-select-search" name="searchChoice" id="searchChoice">
                                        <option value="email" selected>Email</option>
                                        <option value="phone">Phone</option>
                                        <option value="phone">FullName</option>
                                    </select>
                                </div>
                                <div class="col-auto contain-btn-search-order">
                                    <button class="btn-submit-search-order" type="submit">Search</button>
                                </div>
                            </form>
                        </div>
                    </div>

            <!-- Toggle Account Table Visibility -->
            <!-- <button id="toggleAccountTable">Show Account List</button>  -->

                    <div class="table-container" id="accountTableContainer">
                         <div class="d-flex row-processing">
                            <a class="link-processing active " href="">All</a>
                            <a class="link-processing  " href="">Active</a>
                            <a class="link-processing  " href="">Deactived</a>
                            <a class="link-processing  " href="">Suspended</a>
                            <a class="link-processing  " href="">Deleted</a>
                        </div>
                        <table id="accountTable">
                    <thead>
                        <tr>
                            <th>Account ID</th> 
                            <th>Email</th> 
                            <th>Full Name</th>  
                            <th>Address</th> 
                            <th>Phone Number</th> 
                            <th>Role</th> 
                            <th>Status</th> 
                            <th>Status</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>acnbo@gmail.com</td>
                            <td>Hồ Thị Thanh Ngân</td> 
                            <td class="address__acc">155-157 Đường Quốc Thảo, Quận 3, Hồ Chí Minh dsajhsdjf jkdfkj ajkadsj  dsafads fasd dsa jfsdkj sdfjgjfds jhhj dhjsdf hj</td>
                            <td>0926737168</td>
                            <td>Customer</td> 
                            <td>Ative</td> 
                            <td class="text-center">
                                <a href="manageProfileAccount.jsp" style="text-decoration: none;"> 
                                    <button class="edit-btn"><i class="fas fa-edit"></i></button> 
                                </a>
                                
                                    <a href="#" id="btn-delete-acc"  class="btn-delete-acc text-danger"> 
                                        <i class="fas fa-trash"></i>
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
    <!-- Table adn new product -->
    <div class="container_main-add">
        <div class="contain_add-detail">
            <form action="" id="fomr_fill-add">
            <div class="row row-add-detail"> 
                <div class="col-4 " >
                    <div class="img-add-submit">
                        <div class="img-info-add">
                            <img id="imagePreview" src="https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lq2v9pw1pdci29.webp" alt="Koi Pond" > 
                        </div>
                        <div class="add-img-detail"> 
                            <input id="imageInput" type="file" required> 
                        </div>
                    </div>
                </div>
                <div class="col-8 edit-info">
                    <div class="text-right">
                      <button  class="btn-close-add">
                        <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                      </button>
                    </div>
                    <h1 class="text-center mb-4">Create New Accout</h1>
                    <form action="" class="fomr_fill-add">
                      <div class="row row-edit-info-detail">
                        <div class="col-md-6 add-item-detail">
                          <label for="name_p" >Email: </label >
                          <input id="name_p" type="text" value="" placeholder="Enter name" required />
                        </div> 
                        <div class="col-md-6 add-item-detail">
                          <label for="name_a" >FullName </label >
                          <input id="name_a" type="text" value="" placeholder="Enter name" required />
                        </div> 
                        <div class="col-md-6 add-item-detail">
                          <label for="pw_a" >Password: </label >
                          <input id="pw_a" type="password" value="" placeholder="Enter price" required/>
                        </div>  
                        <div class="col-md-6 add-item-detail">
                            <label for="" >Role </label >
                            <select class="add-item-detail-select"> 
                              <option selected value="">Customer</option>
                              <option value="">Manager</option>
                              <option value="">Admin</option>
                            </select>
                          </div>  
                         
                      </div>
                      <div class="text-center mt-3">
                          <button type="submit" class="add-btn-utils blue-btn" style="margin-top: 10px">
                              Confirm
                          </button>                    
                      </div>
                    </form>
                  </div>
            </div>
            </form> 
        </div>
    </div>
</body>
<script>
    $('#header').load('utils.jsp #header_admin', ()=>{
        $.getScript('./assets/js/utilsAdmin.js');
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
    const formAddProduct = document.getElementById('fomr_fill-add');
    formAddProduct.addEventListener('submit',(e)=>{
        const isConfirmed = confirm('Are you sure you want to submit this news?');
        if(!isConfirmed){
            e.preventDefault();
        }
    });
    const btnCreatPr = document.querySelector('.link_add-account');
    const containerAdd = document.querySelector('.container_main-add');
    const closeContainerAdd = document.querySelector('.btn-close-add');
    const subContainerAdd = document.querySelector('.contain_add-detail');

    btnCreatPr.addEventListener('click', (e)=>{
        containerAdd.classList.add('open');
        e.stopPropagation();
    });
    closeContainerAdd.addEventListener('click',()=>{
        containerAdd.classList.remove('open');
    });
    subContainerAdd.addEventListener('click',(e)=>{
        e.stopPropagation();
    });
    document.addEventListener('click',()=>{
        containerAdd.classList.remove('open');
    });

    const deleteAccount = document.querySelector('.btn-delete-acc');
    deleteAccount.addEventListener('click',(e)=>{
        const isConfirmed = confirm('Are you sure you want Delete this Account?');
        if(!isConfirmed){
            e.preventDefault();
        }
    });
</script>
 


</html>

