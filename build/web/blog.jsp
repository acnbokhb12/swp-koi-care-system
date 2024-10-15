
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
                        <form action="deleteBlog" method="POST" style="display:inline;">
                            <input type="hidden" name="postId" value="1"> 
                            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                        </form>
                    </div>
                            <a href="MainController?action=blog&bid=${b.blogID}" class="post-title mb-4 text-danger" style="font-size: 28px; display: block; ">${b.title}</a>
                    <div class="post-image">
                        <img src="${b.blogImage}" alt="">
                    </div>
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
                        <form action=""  enctype="multipart/form-data"> 
                        <h2 class="text-dark">Create New Post</h2>
                        <input type="text" placeholder="Title">
                        <textarea placeholder="Content"></textarea>
                        <!-- <div class="upload-image">Upload Image<br>PNG, JPG, GIF up to 10MB</div> -->
                        <img id="imagePreview" class="img_to_upload" src="https://t4.ftcdn.net/jpg/05/75/48/57/360_F_575485756_WSQ6ZzqMhD0JnPcEupxyKikKKCE5p5jo.jpg" alt="">
                        <input id="imageInput" type="file" accept="img/*" >
                        <h5>Select a category</h5>
                        <select> 
                            
                            <option>Koi Pond Maintenance</option>
                            <option>Koi Fish Health</option>
                            <option>Koi Breeding</option>
                            <option>Koi Varieties and Selection</option>
                            <option>Koi Competitions and Exhibitions</option>
                            <option>Koi Pond DIY Projects</option>
                            <option>Personal Koi Stories</option>
                            <option>Koi Culture and History</option>
                        </select>
                        <button  type="submit">
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
    <div id="footer"></div>
     <style>
        .pagination-list li .active-page{
            background-color: orange;
        }
    </style>
</body>
<script>
    $('#header').load('utils.jsp #header__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
    $('#footer').load('utils.jsp #footer__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
</script>
<script>
     

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
</script>
</html>