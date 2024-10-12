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
    <link rel="stylesheet" href="./assets/css/blog.css">
</head>
<body>
    <div id="header"></div>
  
    <div class="container container-blog">
        <div class="row">
            <div class="main-content col-md-8">
                <h2>Forum Posts</h2>
                <div class="post">
                    <div class="post-header">
                        <img src="https://www.vietnamworks.com/hrinsider/wp-content/uploads/2023/12/anh-den-ngau.jpeg" alt="">
                        <div>
                            <span style="color: #ee4d2d; font-weight: bold;">John Doe</span>
                            <span>Posted on March 15, 2025</span>
                        </div>
                        <form action="deleteBlog" method="POST" style="display:inline;">
                            <input type="hidden" name="postId" value="1"> 
                            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                        </form>
                    </div>
                    <div class="post-title">Exciting New Technology Trends</div>
                    <div class="post-image">
                        <img src="https://blog.feedspot.com/wp-content/uploads/2019/08/koi_fish_blogs.jpg" alt="">
                    </div>
                    <div class="post-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                    <div class="post-footer">
                        <div><i class="fas fa-fire"></i> 24 Likes</div>
                        <div><i class="fas fa-comment"></i> 12 Comments</div>
                    </div>
                </div>
                <div class="post">
                    <div class="post-header">
                        <img src="https://kynguyenlamdep.com/wp-content/uploads/2022/06/avatar-cute-vui-nhon.jpg" alt="">
                        <div>
                            <span style="color: #ee4d2d; font-weight: bold;">John Doe</span>
                            <span>Posted on March 15, 2025</span>
                        </div>
                        <form action="deleteBlog" method="POST" style="display:inline;">
                            <input type="hidden" name="postId" value="1"> 
                            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                        </form>
                    </div>
                    <div class="post-title">Exciting New Technology Trends</div>
                    <div class="post-image">
                        <img src="https://blog.feedspot.com/wp-content/uploads/2019/08/koi_fish_blogs.jpg" alt="">
                    </div>
                    <div class="post-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                    </div>
                    <div class="post-footer">
                        <div><i class="fas fa-fire"></i> 24 Likes</div>
                        <div><i class="fas fa-comment"></i> 12 Comments</div>
                    </div>
                </div>
                <div class="pagination">
                    <ul class="pagination-list">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#" class="active">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
            </div>
            <div class="sidebar col-md-4">
                <div class="create-sidebar">
                    <div class="create-post">
                        <form action="" enctype="multipart/form-data"> 
                        <h2>Create New Post</h2>
                        <input type="text" placeholder="Title">
                        <textarea placeholder="Content"></textarea>
                        <!-- <div class="upload-image">Upload Image<br>PNG, JPG, GIF up to 10MB</div> -->
                        <img class="img_to_upload" src="https://cdn.shopify.com/s/files/1/1083/2612/files/koi2_480x480.jpg?v=1719301650" alt="">
                        <input type="file" accept="img/*" >
                        <label for="">Select a category</label>
                        <select> 
                            <option selected>Technology</option>
                            <option>Work</option>
                            <option>Lifestyle</option>
                            <option>Health</option>
                        </select>
                        <button type="submit">
                            <h4>Create Post</h4>
                        </button>
                        </form>
                    </div>
                    <div class="categories">
                        <h2>Categories</h2>
                        <ul>
                            <li>
                                <a href="#">
                                    <h5>Technology</h5>
                                </a>
                                <h5>42</h5>
                            </li>
                            <li>
                                <a href="#">
                                    <h5>Work</h5>
                                </a>
                                <h5>28</h5>
                            </li>
                            <li>
                                <a href="#">
                                    <h5>Lifestyle</h5>
                                </a>
                                <h5>35</h5>
                            </li>
                            <li>
                                <a href="#">
                                    <h5>Health</h5>
                                </a>
                                <h5>19</h5>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="footer"></div>

</body>

<script>
    $('#header').load('utils.html #header__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
    $('#footer').load('utils.html #footer__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
</script>
</html>