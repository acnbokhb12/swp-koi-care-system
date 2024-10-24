<%-- 
    Document   : forgetpassword
    Created on : Oct 24, 2024, 11:19:29 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Forget Password</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        body {
            background-color: #eee;
            font-family: "Rubik", Helvetica, Arial, sans-serif;
            color: #505050;
            font-size: 14px;
        }

        .forgot {
            background-color: #fff;
            padding: 20px;
            border: 1px solid #dfdfdf;
        }

        .padding-bottom-3x {
            padding-bottom: 72px !important;
        }

        .card-footer {
            background-color: #fff;
        }

        .form-control:focus {
            border-color: #76b7e9;
            box-shadow: none;
        }

        .container {
            margin-top: 50px;
        }

        .btn {
            font-size: 13px;
        }

        .btn-success {
            margin-right: 10px;
        }
    </style>
</head>
<body oncontextmenu="return false" class="snippet-body">
    <div class="container padding-bottom-3x mb-2 mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-8 col-md-10">
                <div class="forgot">
                    <h2>Forgot your password?</h2>
                    <p>Change your password in three easy steps. This will help you to secure your account!</p>
                    <ol class="list-unstyled">
                        <li><span class="text-primary text-medium">1.</span> Enter your email below.</li>
                        <li><span class="text-primary text-medium">2.</span> We will send you an OTP to your email.</li>
                        <li><span class="text-primary text-medium">3.</span> Enter the OTP on the next page.</li>
                    </ol>
                </div>
                <c:if test="${not empty message}">
                    <div class="alert alert-danger">
                        ${message}
                    </div>
                </c:if>
                <form class="card mt-4" action="MainController?action=forgetpassword" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="email-for-pass">Enter your email address</label>
                            <input class="form-control" type="email" name="email" id="email-for-pass" required>
                            <small class="form-text text-muted">Enter your registered email address. We will send an OTP to this email.</small>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-success" type="submit">Get New Password</button>
                        <a href="login.jsp" class="btn btn-danger">Back to Login</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
</body>
</html>