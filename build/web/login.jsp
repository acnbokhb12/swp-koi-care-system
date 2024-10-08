<%-- 
    Document   : login
    Created on : Sep 30, 2024, 10:07:04 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign In</title>
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

            <div class="container__screen__img  ">
                <div class="screen__img-detail">
                    <img class="img-detail-item" src="https://i.pinimg.com/564x/45/9c/9a/459c9a813fde9996be8f00895a7c68d4.jpg" alt="">
                </div>

            </div>
            <!-- SIGNIN -->
            <div class="info__user-container  ">
                <div id="sign-in-form" class="container__sigin-form form-container">
                    <div class="user-sign-container">

                        <header class="header__screen-log">
                            <!-- <h1 class="signin-header-title">Welcome back!</h1> -->
                            <a href="home.jsp" class="header__img-log">
                                <img src="./assets/img/logo/logoSignin.jpg" alt="">
                            </a>
                            <p class="header-desc">Sign In to manage your Koi Care System</p>
                        </header>
                        <div class="body__input-container">
                            <form action="MainController?action=login" class="form" id="form1" method="post">
                                <!-- username --> 
                                <div class="form-group" style="margin-bottom: 0;">  
                                    <input type="email" id="email-log" name="txtemail" class="input__form"
                                           placeholder="E-mail address or koicare ID" value="${oldEmail!=null ? oldEmail : ''}" required><br>
                                </div>
                                <!-- password -->
                                <div class="form-group">
                                    <input type="password" id="password-title-signin" name="txtpassword"
                                           class="input__form mt-4 last-child" placeholder=" Enter your password" required /><br>
                                </div>
                                <!-- take error something --> 
                                <div class="wrong__acc mt-2">
                                    <c:if test = "${error != null}">
                                        <span id="wrongNameOrPass" class="">${error}</span>
                                    </c:if>
                                </div>
                                <div class="link-forgot-acc">
                                    <a href="#" class="">Forgot password?</a><br>
                                </div>

                                <button class="btn btn-info btn-signin-acc ">Sign In</button><br>
                            </form>
                            <p class="footer__screen__acc_according">
                                Don't have an account?<a href="register.jsp" class="signup-btn-link" id="come-signup">Sign
                                    Up</a>
                            </p>
                        </div>
                        <footer class="footer__screen__acc">
                            <div class="policy__service-more">
                                <p>This site is protected by reCAPTCHA Enterprise and the Google 
                                    <a href="https://policies.google.com/privacy" target="_blank">Privacy Policy</a>
                                    and <a href="https://policies.google.com/terms" target="_blank">Terms of Service</a> apply</p>
                            </div>
                        </footer>

                    </div>
                </div>
            </div>
            <div class="container__screen__img  ">
                <div class="screen__img-detail">
                    <img class="img-detail-item" src="https://i.pinimg.com/564x/ed/5c/50/ed5c502b3b22b3ab15102e9fbb4efd85.jpg" alt="">
                </div>

            </div>

        </div>

    </body>

</html>