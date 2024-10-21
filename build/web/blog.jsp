
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Blogs</title>
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">

        <!-- Font icon -->
        <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"> -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css"> 
        <link rel="stylesheet" href="./assets/css/news_blogs.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <body style="background-color: #EDEFF4;">
        <div id="header"></div>

        <div class="container container-blog">
            <div class="row">
                <div class="main-content col-md-8">
                    <h2 class="text-dark">Forum Posts</h2>
                    <c:forEach items="${ListB}" var="b">

                        <div class="post">
                            <div href="MainController?action=blog&bid=${b.blogID}">
                                <div class="post-header">
                                    <img src="${b.account.profileImage}" alt="">
                                    <div>
                                        <span style="color: #ee4d2d; font-weight: bold;">${b.account.fullName}</span>
                                        <span>${b.blogDate}</span>
                                        <span>${b.blogCategory.nameCategory}</span>
                                    </div>
                                    <form action="MainController?action=deleteBlog&blogID=${b.blogID}" method="POST" style="display:inline;">
                                        <button type="button" class="btn btn-danger btn-sm delete-button" data-id="${b.blogID}" data-title="${b.title}" data-toggle="modal" data-target="#myModal">Delete</button>
                                    </form> 
                                </div>
                                <div class="post-title mb-4 text-danger" style="font-size: 28px; display: block;">${b.title}</div>
                                <c:if test="${not empty b.blogImage}">
                                    <div class="post-image">
                                        <img src="${b.blogImage}" alt="Blog Image">
                                    </div>
                                </c:if>
                                <div class="post-body">
                                    <p>${b.content}</p>
                                </div>
                                <div class="post-footer">
                                    <div><i class="fas fa-fire"></i> 24 Likes</div>
                                    <div><i class="fas fa-comment"></i> 12 Comments</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="pagination">
                        <ul class="pagination-list">
                            <c:choose>
                                <c:when test="${blogCateId != null}">
                                    <c:if test="${tag > 1}">
                                        <li>
                                            <a href="BlogCateController?index=${tag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                        </li>
                                    </c:if>
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                        <li><a class="${tag == i ? "active-page" : ""}" href="BlogCateController?index=${i}">${i}</a></li>
                                        </c:forEach>
                                        <c:if test="${tag < endPage}">
                                        <li><a href="BlogCateController?index=${tag + 1}"><i class="fa-solid fa-chevron-right"></i></a></li>
                                            </c:if>
                                        </c:when>
                                        <c:otherwise>
                                            <c:if test="${tag > 1}">
                                        <li>
                                            <a href="ManageBlogController?index=${tag - 1}"><i class="fa-solid fa-chevron-left"></i></a>
                                        </li>
                                    </c:if>
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                        <li><a class="${tag == i ? "active-page" : ""}" href="ManageBlogController?index=${i}">${i}</a></li>
                                        </c:forEach>
                                        <c:if test="${tag < endPage}">
                                        <li><a href="ManageBlogController?index=${tag + 1}"><i class="fa-solid fa-chevron-right"></i></a></li>
                                            </c:if>
                                        </c:otherwise>
                                    </c:choose>
                        </ul>
                    </div>
                </div>
                <div class="sidebar col-md-4">
                    <div class="create-sidebar">
                        <div class="create-post">
                            <form action="MainController?action=createNewBlog" method="post" enctype="multipart/form-data">  
                                <h2 class="text-dark">Create New Post</h2>
                                <input type="text" placeholder="Title" name="title">
                                <textarea placeholder="Content" name="content"></textarea>
                                <!-- <div class="upload-image">Upload Image<br>PNG, JPG, GIF up to 10MB</div> -->
                                <c:if test="${not empty blogImage}">
                                    <img id="imagePreview" class="img_to_upload" src="${blogImage}" alt="Uploaded Image">
                                </c:if>
                                <input id="imageInput" type="file" accept="img/*" name="fileimg" >

                                <h5>Select a category</h5>
                                <select name="blogCateId"> 
                                    <c:forEach var="category" items="${ListBC}">
                                        <option value="${category.id}">${category.nameCategory}</option>
                                    </c:forEach>
                                </select>  

                                <button type="submit">
                                    <h4>Create Post</h4>
                                </button>
                            </form>
                        </div>
                        <div class="categories">
                            <h1 class="text-dark">Categories</h1>
                            <ul>
                                <c:forEach items="${ListBC}" var="bc">
                                    <li>
                                        <a href="MainController?action=getBlogCid&cid=${bc.id}">
                                            <h5>${bc.nameCategory}</h5>
                                        </a>
                                    </li>
                                </c:forEach> 
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal Delete-->
        <div id="myModal" class="modal-confirm-delete" style="display: none;">
            <div class="modal-confirm">
                <div class="modal-content">
                    <div class="modal-header flex-column">
                        <div class="icon-box">
                            <i class="material-icons">&#xE5CD;</i>
                        </div>
                        <h4 class="modal-title w-100">Are you sure?</h4>
                        <button type="button" class="close-confirm-delete close" data-dismiss="modal" aria-hidden="true" style="font-size: 30px; color: #000">&times;</button>
                    </div>
                    <div class="modal-body">
                        <p style="font-size: 16px; color: #000;">Do you really want to delete <span style="color: #000; font-weight: 600; background-color: #ff5656; padding: 4px 10px; border-radius: 4px;" id="blogTitleDisplay"></span> ? This process cannot be undone.</p>
                    </div>
                    <div class="modal-footer justify-content-center">
                        <button type="button" class="btn-cancel-delete btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <form id="deleteForm" action="MainController?action=deleteBlog" method="post">
                            <input type="hidden" name="blogID" id="blogIDToDelete">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Toast -->
        <c:if test="${toastMessage != null}"> 
            <div id="toast" style="z-index: 10">  
                <div class="toast_main row ${toastMessage.equals('success') ? 'toast--success' : 'toast--error' }" style="display:flex">
                    <div class="toast__icon">
                        <i class="fa-solid ${toastMessage.equals('success') ? 'fa-circle-check' : 'fa-times-circle' }"></i>
                    </div>
                    <div class="toast_body">
                        <h3 class="toast__title">${toastMessage.equals('success') ? 'Success' : 'Error' }</h3>
                        <p class="toast__msg">${message}</p>
                    </div>
                    <div class="toast__close">
                        <i class="fas fa-times"></i>
                    </div>
                </div>
            </div>
        </c:if>
        <div id="footer"></div>
        <style>
            .pagination-list li .active-page{
                background-color: orange;
            }
        </style>
    </body>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
    </script>
    <script>


        const imageInput = document.getElementById('imageInput');
        const imagePreview = document.getElementById('imagePreview');

        imageInput.addEventListener('change', function () {
            const file = this.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    imagePreview.src = e.target.result;
                    imagePreview.style.display = 'block'; // Hiện ảnh khi file được chọn
                };
                reader.readAsDataURL(file);
            } else {
                imagePreview.style.display = 'none'; // Ẩn ảnh nếu không có file nào được chọn
            }
        });
    </script>
    <script>
        $(document).ready(function () {
            $('#myModal').hide();


            $('.delete-button').on('click', function () {
                const blogID = $(this).data('id');
                const blogTitle = $(this).data('title');


                $('#blogIDToDelete').val(blogID);
                $('#blogTitleDisplay').text(blogTitle);


                $('#myModal').show();
            });


            $('.close-confirm-delete, .btn-cancel-delete').on('click', function () {
                $('#myModal').hide();
            });


            $(window).on('click', function (event) {
                if (event.target.id === 'myModal') {
                    $('#myModal').hide();
                }
            });
        });
    </script>
    <script src="./assets/js/notification.js"></script>
    <script src="./assets/js/utils.js"></script>
</html>