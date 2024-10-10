<%-- 
    Document   : createPassword
    Created on : Oct 10, 2024, 5:32:15 PM
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
</head>

<body>
    <div class="main_container_create">
        <div class="contain-img-page">

        </div>
        <div class="form-create_pw"> 
            <form action="CreateAccountWithGoogleController" method="post" class="form" id="form-1">
                <p class="form-title">Create Account</p>
                <div class="input-container form-group">
                    <input type="email" placeholder="${sessionScope.VirturalAcc.email}" readonly> 
                </div>
                <div class="input-container form-group"> 
                    <input type="password" id="password" name="txtpassword" placeholder="Enter password">
                    <span class="form-message"> </span>
                </div>
                <div class="input-container form-group"> 
                    <input type="password" id="password_confirmation" placeholder="Confirm password">
                    <span class="form-message"> </span> 
                </div>
                <button type="submit" class="submit mt-4" >
                    Confirm
                </button>
 
            </form>

        </div>
    </div>
    <style>
        .main_container_create {
            position: relative;
        }

        .contain-img-page {
            background: url('https://www.yourcentralvalley.com/wp-content/uploads/sites/54/2023/09/Koi-Fish-Show-returns-to-Fresno-at-Woodward-Park.jpeg?w=2560&h=1440&crop=1') no-repeat;
            width: 100%;
            height: 100vh;
            background-size: cover;
            filter: brightness(0.6);
        }
        .form-create_pw{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
        }
        /* From Uiverse.io by nathann09 */
        .form {
            background-color: #fff;
            display: block;
            padding: 2rem;
            width: 100%;
            /* max-width: 350px; */
            border-radius: 0.5rem;
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
        }

        .form-title {
            font-size: 2.4rem;
            line-height: 1.75rem;
            font-weight: 600;
            text-align: center;
            color: #000;
            margin-bottom: 3rem;
        }

        .input-container {
            position: relative;
            /* margin: 2rem 0; */
        }

        .input-container input,
        .form button {
            outline: none;
            border: 1px solid #e5e7eb; 
            margin-bottom: 0.4rem;
        }

        .input-container input {
            background-color: #fff;
            padding: 1rem;
            padding-right: 3rem;
            font-size:1.6rem;
            line-height: 1.25rem;
            width: 300px;
            border-radius: 0.5rem;
            box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
        }

        .submit {
            display: block;
            padding: 1rem 1.2rem;
            background-color: var(--bs-orange);
            color: #ffffff;
            font-size: 1.6rem;
            line-height: 1.25rem;
            font-weight: 500;
            width: 100%;
            border-radius: 0.5rem;
            text-transform: uppercase; 
        }

        .signup-link {
            color: #6B7280;
            font-size: 0.875rem;
            line-height: 1.25rem;
            text-align: center;
        }

        .signup-link a {
            text-decoration: underline;
        }
        
        .form-message{
            display: block;
            color: red;
            font-size: 1.4rem;
            padding-left: 1rem;
        }
    </style>
    <script src="./assets/js/validator.js"></script>
    <script>
        Validator({
            form: '#form-1',
            errorSelector:'.form-message',
            rules: [ 
                Validator.minLength('#password', 6),
                Validator.isRequired('#password_confirmation'),
                Validator.isConfirmed('#password_confirmation',()=>{
                    return document.querySelector('#form-1 #password').value;
                },'Password confirm not exactly')
            ],
            // onSubmit: (data)=>{
            //     console.log(data)
            // }
        });
    </script>
</body>

</html>