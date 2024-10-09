<%-- 
    Document   : editProfile
    Created on : Sep 30, 2024, 10:37:01 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" /> 
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
        <link rel="stylesheet" href="./assets/css/profilePerson.css">
    </head>
    <body>
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->
        <!-- slider -->
        <div class="container container-edit-profile">

            <hr class="mt-0 mb-4">
            <div class="row row-edit-profile">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle " src="${UserAccount.profileImage}" alt="Customer Image">
                            <!-- Profile picture help block-->
                            <div class="desc-img">
                                <p>
                                    JPG or PNG no larger than 5 MB 
                                </p>  
                            </div> 
                            <!-- Profile picture upload button-->
                            <form action="" method="post" enctype="multipart/form-data"> 
                                <input id="imageInput" class="choose-edit-img-profile" type="file" accept="image/*">
                                <button class="btn btn-edit-img-profile" type="button">Upload new image</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <c:if test="${not empty UserAccount}">
                                <form action="MainController?action=editprofile" class="form" id="form-1" method="post">
                                    <div class="row row-form-edit">
                                        <!-- Form Group (email address) -->
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="email">Email address</label>
                                            <input class="form-control" id="email" name="email" type="email" placeholder="Enter your email address" value="${UserAccount.email}" required>
                                            <span class="form-message"></span>
                                            <c:if test="${not empty emailExists}">
                                                <span class="error__bk">${emailExists}</span>
                                            </c:if>
                                        </div>
                                        <!-- Form Group (username) -->
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="fullname">Name</label>
                                            <input class="form-control" id="fullname" name="fullname" type="text" placeholder="Enter your username" value="${UserAccount.fullName}" required>
                                            <span class="form-message"></span>
                                        </div>
                                    </div>
                                    <div class="row row-form-edit">
                                        <!-- Form Group (old pw) -->
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="password_old">Old Password</label>
                                            <input class="form-control" id="password_old" name="password_old" type="password" placeholder="Enter your old password" value="" required>
                                            <span class="form-message"></span>
                                            <c:if test="${not empty wrongPassword}">
                                                <span class="error__bk">${wrongPassword}</span>
                                            </c:if>
                                        </div>
                                        <!-- Form Group (new pw) -->
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="password_new">New Password</label>
                                            <input class="form-control" id="password_new" name="password_new" type="password" placeholder="Enter your new password" value="">
                                            <span class="form-message"></span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <!-- Form Group (phone number) -->
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="phoneNumber">Phone number</label>
                                            <input class="form-control" id="phoneNumber" name="phoneNumber" type="tel" placeholder="Enter your phone number" value="${UserAccount.phoneNumber}" required>
                                            <span class="form-message"></span>
                                        </div>
                                        <!-- Form Group (address) -->
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="address">Address</label>
                                            <input class="form-control" id="address" name="address" type="text" placeholder="Enter your address" value="${UserAccount.address}" required>
                                            <span class="form-message"></span>
                                        </div>
                                        <!-- Form Group (gender) -->
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="choice-gender">Gender</label>
                                            <select name="choice-gender" class="input__form">
                                                <option value="Man" <c:if test="${UserAccount.gender == 'Man'}">selected</c:if>>Man</option>
                                                <option value="Woman" <c:if test="${UserAccount.gender == 'Woman'}">selected</c:if>>Woman</option>
                                                <option value="Other" <c:if test="${UserAccount.gender == 'Other'}">selected</c:if>>Other</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- Save changes button -->
                                        <button class="btn btn-edit-img-profile" type="submit">Save changes</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                </c:if>
            </div>
        </div>
        <div id="footer"></div>
    </body>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
    </script>
    <script src="./assets/js/validator.js"></script>
    <script>
        Validator({
            form: '#form-1',
            errorSelector: '.form-message',
            rules: [
                Validator.isEmail('#email', 'Please fill true email'),
                Validator.isRequired('#fullname', 'Please fill your full name'),
                Validator.isRequired('#password_old', 'Please fill your old password'),
                Validator.minLength('#password_new', 6),
                Validator.isPhoneNumber('#phoneNumber', 'Phone number at least 10 number')
            ]
        });
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
        const formEditProfile = document.getElementById('form-1');
        formEditProfile.addEventListener('submit', (e) => {
            const isConfirmed = confirm('Are you sure you want to submit this news?');
            if (!isConfirmed) {
                e.preventDefault();
            }
        });
    </script>
</html>