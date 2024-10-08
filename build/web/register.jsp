<%-- 
    Document   : register
    Created on : Sep 30, 2024, 10:07:48 AM
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />

        <!-- Font family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <!-- Font icon -->
        <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"> -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/signIn_Up.css">
    </head>

    <body>
        <div class="screen__info__user  ">

            <div class="container__screen__img_signup  " style="width: 40%;">
                <div class="screen__img-detail_signup">
                    <img class="img-detail-item_signup"
                         src="https://i.pinimg.com/originals/26/db/71/26db713c96975fd76257800965c0b19f.jpg" alt="">
                    <img class="img-detail-item_signup"
                         src="https://i.pinimg.com/564x/d8/ad/50/d8ad5040b549e8dc49fe1aac3098f239.jpg" alt="">
                    <img class="img-detail-item_signup"
                         src="https://images.rawpixel.com/image_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvbHIvdjczMy10YW5nLTEzYl8xLmpwZw.jpg"
                         alt="" style="float: left;">
                    <img class="img-detail-item_signup"
                         src="https://www.shutterstock.com/image-vector/asian-background-oriental-japanese-style-260nw-1978654823.jpg"
                         alt="">
                </div>
            </div>
            <!-- Sign up -->
            <div class="info__user-container-up  ">
                <div id="sign-in-form" class="container__sigup-form form-container">
                    <div class="user-re-container">
                        <header class="header__screen-log">
                            <!-- <h1 class="signin-header-title">Welcome back!</h1> -->
                            <a href="home.jsp" class="header__img-log">
                                <img src="./assets/img/logo/logoSignin.jpg" alt="">
                            </a>
                            <p class="header-desc" style="font-size: 2.6rem; text-align: center;">Create an account</p>
                        </header>
                        <div class="signup-user-body">
                            <form action="MainController?action=register" class="form" id="form-1" method="post">
                                <div class="row row__form"> 
                                    <!-- Email -->
                                    <div class="form-group col-md-6 ">
                                        <label for="email" class="form-label"> <i class="fa-solid fa-envelope  icon-signup"></i>
                                            Email</label> 
                                        <input type="email" id="email" name="txtemail" class="input__form"
                                               placeholder="email@domain.com">
                                        <span class="form-message"></span>
                                        <c:if test="${emailExists != null}">
                                            <span class="form-message-error-bk">${emailExists}</span>
                                        </c:if>
                                    </div> 
                                    <!-- UserName -->
                                    <div class="form-group col-md-6 ">
                                        <label for="fullname" class="form-label"><i class="fa-solid fa-user icon-signup"></i>
                                            Name</label>

                                        <input type="text" id="fullname" name="txtusername" class="input__form"
                                               placeholder="UserName" />
                                        <span class="form-message"></span>
                                    </div> 
                                    <!-- password -->
                                    <div class="form-group col-md-6   "> 
                                        <label for="password" class="form-label"><i
                                                class="fa-solid fa-lock icon-signup"></i> Password</label>
                                        <input type="password" id="password" name="txtpassword"
                                               class="input__form " placeholder="Password" />
                                        <span class="form-message"></span>
                                    </div> 
                                    <!-- pass wordd again -->
                                    <div class="form-group col-md-6 ">
                                        <label for="password_confirmation" class="form-label"><i class="fa-solid fa-lock icon-signup"></i> Confirm
                                            password</label>
                                        <input type="password" id="password_confirmation" name="txtconfirmpassword" class="input__form"
                                               placeholder="Confirm password" />
                                        <span class="form-message"></span>
                                    </div>
                                    <!-- Phone -->
                                    <div class="form-group col-md-6">
                                        <label for="phoneNumber" class="form-label"> <i class="fa-solid fa-phone icon-signup"></i> Phone
                                            number</label>
                                        <input type="text" id="phoneNumber" name="txtphone" class="input__form"
                                               placeholder="Phone number" />
                                        <span class="form-message"> </span>
                                        <c:if test="${phoneExists != null}">
                                            <span class="form-message-error-bk">${phoneExists}</span>
                                        </c:if>
                                    </div>
                                    <!-- Gender -->
                                    <div class="form-group col-md-6">
                                        <label for="" class="form-label">Choose Gender:</label>
                                        <select name="choice-gender" id="" class="input__form ">
                                            <option value="Man">Man</option>
                                            <option value="Woman">Woman</option>
                                            <option value="Orther">Other</option>
                                        </select>
                                    </div>

                                    <button class="btn btn-info btn-signin-acc" type="submit">Sign Up</button><br>
                                </div>
                                <!-- Submit -->
                            </form>
                            <p class="footer__screen__acc_according">
                                Already have an account?<a href="login.jsp" class="signup-btn-link" id="come-signup">Sign
                                    In</a>
                            </p>
                        </div>
                        <footer class="user-signup-footer">
                        </footer>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="./assets/js/validator.js"></script>
    <script>
        Validator({
            form: '#form-1',
            errorSelector: '.form-message',
            rules: [
                Validator.isEmail('#email', 'Please fill true email'),
                Validator.isRequired('#fullname', 'Please fill your full name'),
                Validator.minLength('#password', 6),
                Validator.isRequired('#password_confirmation'),
                Validator.isConfirmed('#password_confirmation', () => {
                    return document.querySelector('#form-1 #password').value;
                }, 'Password confirm not exactly'),
                Validator.isPhoneNumber('#phoneNumber', 'Phone number at least 10 number'),
            ],
            // onSubmit: (data)=>{
            //     console.log(data)
            // }
        });
    </script>

</html>