<%-- 
    Document   : manageAddNews
    Created on : Oct 4, 2024, 2:03:39 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MangeNews</title>
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
    <script src="https://cdn.tiny.cloud/1/bdl5a6d586obijv13gt41s21ynmqy7nwf7bbd1qdorf5hzjy/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
     
    <!-- css --> 
    
    <link rel="stylesheet" href="./assets/css/base.css"> 
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/history.css">

</head>
<body>
    <script>
        tinymce.init({
          selector: '#mytextarea-news',
          plugins: [
            // Core editing features
            'anchor', 'autolink', 'charmap', 'codesample', 'emoticons', 'image', 'link', 'lists', 'media', 'searchreplace', 'table', 'visualblocks', 'wordcount',
            // Your account includes a free trial of TinyMCE premium features
            // Try the most popular premium features until Oct 17, 2024:
            'checklist', 'mediaembed', 'casechange', 'export', 'formatpainter', 'pageembed', 'a11ychecker', 'tinymcespellchecker', 'permanentpen', 'powerpaste', 'advtable', 'advcode', 'editimage', 'advtemplate', 'ai', 'mentions', 'tinycomments', 'tableofcontents', 'footnotes', 'mergetags', 'autocorrect', 'typography', 'inlinecss', 'markdown',
          ],
          toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck typography | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
          tinycomments_mode: 'embedded',
          tinycomments_author: 'Author name',
          mergetags_list: [
            { value: 'First.Name', title: 'First Name' },
            { value: 'Email', title: 'Email' },
          ],
          ai_request: (request, respondWith) => respondWith.string(() => Promise.reject('See docs to implement AI Assistant')),
        });
      </script>
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
                    <div class="content__news-main">
                        <h1>Fill yours news Here</h1>
                        <form action="" method="post" id="fomr_fill-news" enctype="multipart/form-data">
                            <div class="desc-tile-news"> 
                                <label for="">Title: </label>
                                <input type="text" required>
                            </div>
                            <div class="desc-tile-news"> 
                                <label for="">Image : </label>
                                <input type="file" id="imageInput" accept="image/*" required>
                            </div>
                            <img id="imagePreview"  src="" alt="" >
                            <div class="desc-tile-news"> 
                                <label for="">Category : </label>
                                <select name="" id="">
                                    <option selected value="Hot">Hot</option>
                                    <option value="Medicine">Medicine</option>
                                    <option value="Share knowledge">Share knowledge</option>
                                    <option value="Use pro">Use pro</option>
                                </select>
                            </div>
                             <textarea id="mytextarea-news">Hello, World!</textarea>
                            <button id="btn-submit-news" type="submit">Submit</button>
                        </form>
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
    const formNews = document.getElementById('fomr_fill-news');
    formNews.addEventListener('submit',(e)=>{
        const isConfirmed = confirm('Are you sure you want to submit this news?');
        if(!isConfirmed){
            event.preventDefault();
        }
    });
</script>
</html>
