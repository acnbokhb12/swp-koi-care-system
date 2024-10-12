<%-- 
    Document   : editProfile
    Created on : Sep 30, 2024, 10:37:01 AM
    Author     : DELL
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <div class="container container-edit-profile">

            <hr class="mt-0 mb-4">
            <div class="row row-edit-profile"> 
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form action="MainController?action=informationprofile" class="form" id="form-1" method="post">
                                <input type="hidden" name="accID" id="accID" value="${sessionScope.userAccount.userID}">
                                <div class="row row-form-edit">
                                    <!-- Form Group (email address) -->
                                    <div class="col-md-6">
                                        <label class="label-profile-edit" for="email">Email address</label>
                                        <input class="form-control" id="email" name="email" type="email" value="${sessionScope.userAccount.email}" readonly>
                                        <!-- Dung co ma cham vo form-message , cai nay do js lam roi -->                                 
                                        <span class="form-message"></span>   
                                    </div>
                                    <!-- Conditional rendering for KoiCareId -->
                                    <c:if test="${sessionScope.userAccount.koiCareID == null}">
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="KoiCareId">KoiCareId</label>
                                            <input class="form-control" name="KoiCareId" id="KoiCareId" type="text" placeholder="Enter your KoiCareId" value="">
                                            <span class="form-message"></span>
                                            <c:if test="${KoiIdExist != null}">
                                                <span class="error__bk">${KoiIdExist}</span>
                                            </c:if>
                                        </div>
                                    </c:if>
                                    <c:if test="${sessionScope.userAccount.koiCareID != null}">
                                        <div class="col-md-6">
                                            <label class="label-profile-edit" for="KoiCareId">KoiCareId</label>
                                            <input class="form-control" id="KoiCareId" type="text" placeholder="Enter your KoiCareId" 
                                                   value="${sessionScope.userAccount.koiCareID}" readonly>
                                            <span class="form-message"></span>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="row  row-form-edit ">
                                    <!-- Form Group (username)-->
                                    <div class="col-md-6 ">
                                        <label class="label-profile-edit" for="inputUsername">Name</label>
                                        <input class="form-control" id="fullname" name="fullname" type="text" placeholder="Enter your username" value="${sessionScope.userAccount.fullName}" required>
                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi --> 
                                        <span class="form-message"></span> 
                                    </div> 
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="label-profile-edit" for="inputPhone">Phone number</label>
                                        <input class="form-control" id="phoneNumber" name="phoneNumber" type="tel" placeholder="Enter your phone number" value="${sessionScope.userAccount.phoneNumber}" required>
                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                   
                                        <span class="form-message"></span> <!-- dont touch --> 
                                        <c:if test="${PhoneNumberExist != null}">
                                            <span class="error__bk">${PhoneNumberExist}</span>
                                        </c:if>
                                    </div>
                                </div> 
                                <!-- Form Row-->
                                <div class="row  ">
                                    <div class="col-md-6 ">
                                        <label class="label-profile-edit" for="address">Address</label>
                                        <input class="form-control" id="address" name="address" type="text" placeholder="Enter your address" value="${sessionScope.userAccount.address}" required accept-charset >
                                        <span class="form-message"></span>
                                    </div> 
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="label-profile-edit" for="inputBirthday">Gender</label>
                                        <select name="choice-gender" id="" class="input__form ">
                                            <option value="Man" <c:if test="${sessionScope.userAccount.gender == 'Man'}">selected</c:if>>Man</option>
                                            <option value="Woman" <c:if test="${sessionScope.userAccount.gender == 'Woman'}">selected</c:if>>Woman</option>
                                            <option value="Other" <c:if test="${sessionScope.userAccount.gender == 'Other'}">selected</c:if>>Other</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Save changes button-->
                                    <button class="btn btn-edit-img-profile" type="submit">Save changes</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4">
                        <!-- Profile picture card-->
                        <div class="card mb-4 mb-xl-0">
                            <div class="card-header">Profile Picture</div>
                            <div class="card-body text-center">
                                <!-- Profile picture image-->
                                <div class="text-center d-flex justify-content-center">

                                    <img id="imagePreview" class="img-account-profile rounded-circle " src="${sessionScope.userAccount.profileImage}" alt="">
                            </div>
                            <!-- Profile picture help block-->
                            <div class="desc-img">
                                <p>
                                    JPG or PNG no larger than 5 MB 
                                </p>    
                            </div>
                            <!-- Profile picture upload button-->
                            <form action=""> 
                                <input id="imageInput" class="choose-edit-img-profile" type="file" accept="image/*">
                                <button class="btn btn-edit-img-profile" type="button">Upload new image</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Edit Password</div>
                        <div class="card-body">
                            <form action="MainController?action=passwordprofile" class="form" id="form-2" method="post"> 
                                <input type="hidden" name="accID" id="accID" value="${sessionScope.userAccount.userID}">
                                <!-- Form Row-->
                                <div class="row  row-form-edit ">
                                    <!-- Form Group (old pw)-->
                                    <div class="col-md-6">
                                        <label class="label-profile-edit" for="inputFirstName">Old Password</label>
                                        <input class="form-control" name="password_old" id="password_old" type="password" placeholder="Enter your old password" >
                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->
                                        <span class="form-message"></span>
                                        <c:if test="${WrongPassword != null}">
                                            <span class="error__bk">${WrongPassword}</span>   
                                        </c:if>
                                    </div>
                                    <!-- Form Group (new pw)-->
                                    <div class="col-md-6">
                                        <label class="label-profile-edit" for="inputLastName">New Password</label>
                                        <input class="form-control" id="password_new" name="password_new" type="password" placeholder="Enter your new password" >
                                        <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                    
                                        <span class="form-message"></span>
                                    </div>
                                </div>     
                                <!-- Save changes button-->
                                <button class="btn btn-edit-img-profile" type="submit">Save changes</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
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
                Validator.isPhoneNumber('#phoneNumber', 'Phone number at least 10 number'),
            ]
        })
        Validator({
            form: '#form-2',
            errorSelector: '.form-message',
            rules: [
                Validator.minLength('#password_new', 6),
            ]
        })
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
                event.preventDefault();
            }
        })
    </script>
</html>