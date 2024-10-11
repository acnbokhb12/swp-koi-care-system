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
                            <a href="home.html" class="header__img-log">
                                <img src="./assets/img/logo/logoSignin.jpg" alt="">
                            </a>
                            <p class="header-desc" style="font-size: 2.6rem; text-align: center;">Create an account</p>
                        </header>
                        <div class="signup-user-body">
                            <form action="MainController?action=register" class="form" id="form-1" method="post">
                                <div class="row row__form"> 
                                    <!-- KoiCareId -->
                                    <div class="form-group col-md-6 ">
                                        <label for="kcid" class="form-label"> <i class="fa-solid fa-envelope  icon-signup"></i>
                                            KoiCareId</label> 
                                        <input type="kcid" id="txt" name="txtid" class="input__form"
                                               placeholder="KoiCareId">
                                        <span class="form-message"></span>
                                        <c:if test="${idExists != null}">
                                            <span class="form-message-error-bk">${idExists}</span>
                                        </c:if>
                                    </div> 
                                    <!-- UserName -->
                                    <div class="form-group col-md-6 ">
                                        <label for="fullname" class="form-label"><i class="fa-solid fa-user icon-signup"></i>
                                            Full Name</label>

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
                                    <button class="btn btn-info btn-signin-acc" type="submit">Sign Up</button><br>
                                </div>
                                <!-- Submit -->

                            </form>
                            <p class="footer__screen__acc_according">
                                Already have an account?<a href="login.jsp" class="signup-btn-link" id="come-signup">Sign
                                    In</a>
                            </p>
                            <p class="text-center" style="font-size: 16px;">Or With</p>
                            <div class="flex-row">
                                <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri=http://localhost:8082/com.swp.koiCareSystem/LoginGoogleController&response_type=code&client_id=826453818267-omsh2s4t4ab4rs6eijvgop9bokm52v9q.apps.googleusercontent.com&approval_prompt=force" class="btn google btn-google">
                                    <svg version="1.1" width="20" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
                                    <path style="fill:#FBBB00;" d="M113.47,309.408L95.648,375.94l-65.139,1.378C11.042,341.211,0,299.9,0,256
                                          c0-42.451,10.324-82.483,28.624-117.732h0.014l57.992,10.632l25.404,57.644c-5.317,15.501-8.215,32.141-8.215,49.456
                                          C103.821,274.792,107.225,292.797,113.47,309.408z"></path>
                                    <path style="fill:#518EF8;" d="M507.527,208.176C510.467,223.662,512,239.655,512,256c0,18.328-1.927,36.206-5.598,53.451
                                          c-12.462,58.683-45.025,109.925-90.134,146.187l-0.014-0.014l-73.044-3.727l-10.338-64.535
                                          c29.932-17.554,53.324-45.025,65.646-77.911h-136.89V208.176h138.887L507.527,208.176L507.527,208.176z"></path>
                                    <path style="fill:#28B446;" d="M416.253,455.624l0.014,0.014C372.396,490.901,316.666,512,256,512
                                          c-97.491,0-182.252-54.491-225.491-134.681l82.961-67.91c21.619,57.698,77.278,98.771,142.53,98.771
                                          c28.047,0,54.323-7.582,76.87-20.818L416.253,455.624z"></path>
                                    <path style="fill:#F14336;" d="M419.404,58.936l-82.933,67.896c-23.335-14.586-50.919-23.012-80.471-23.012
                                          c-66.729,0-123.429,42.957-143.965,102.724l-83.397-68.276h-0.014C71.23,56.123,157.06,0,256,0
                                          C318.115,0,375.068,22.126,419.404,58.936z"></path> 
                                    </svg> 
                                    Google  
                                </a> 
                            </div>
                        </div>

                        <footer class="user-signup-footer">

                        </footer>

                    </div>
                </div>
            </div>


        </div>

    </body>
    <style>
        .btn-google {
            margin-top: 10px;
            width: 100%;
            height: 50px;
            border-radius: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            font-weight: 500;
            gap: 10px;
            border: 1px solid #cecece;
            background-color: white;
            cursor: pointer;
            transition: 0.2s ease-in-out;
            margin-bottom: 2rem;
            margin-top: 2rem;
        }

        .btn-google:hover {
            border: 1px solid #2d79f3;
            ;
        }
    </style>
    <script src="./assets/js/validator.js"></script>
    <script>
        Validator({
            form: '#form-1',
            errorSelector: '.form-message',
            rules: [
                Validator.minLength('#password', 6),
                Validator.isRequired('#password_confirmation'),
                Validator.isConfirmed('#password_confirmation', () => {
                    return document.querySelector('#form-1 #password').value;
                }, 'Password confirm not exactly')
            ],
            // onSubmit: (data)=>{
            //     console.log(data)
            // }
        });
    </script>

</html>