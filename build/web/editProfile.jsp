<%-- 
    Document   : editProfile
    Created on : Sep 30, 2024, 10:37:01 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/profilePerson.css">
</head>
<body>
    <script src="./assets/js/headernav.js"></script>
    <div class="container container-edit-profile">
 
        <hr class="mt-0 mb-4">
        <div class="row row-edit-profile">
            <div class="col-xl-4">
                <!-- Profile picture card-->
                <div class="card mb-4 mb-xl-0">
                    <div class="card-header">Profile Picture</div>
                    <div class="card-body text-center">
                        <!-- Profile picture image-->
                        <img class="img-account-profile rounded-circle " src="https://scontent.fsgn2-3.fna.fbcdn.net/v/t1.6435-9/120846118_1393138717744114_5343318628172679837_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=1d70fc&_nc_ohc=s00All9Oy78Q7kNvgGgjhgI&_nc_ht=scontent.fsgn2-3.fna&_nc_gid=AncTZXupFrf-o0ojlYJ35Do&oh=00_AYDL1aMB6bRtX3F00r62cVpdpmDynHn-A5Zx_F1i3Jtl6g&oe=670DF320" alt="">
                        <!-- Profile picture help block-->
                        <div class="desc-img">
                            <p>
                                JPG or PNG no larger than 5 MB</div> 
                            </p>    
                        <!-- Profile picture upload button-->
                        <button class="btn btn-edit-img-profile" type="button">Upload new image</button>
                    </div>
                </div>
            </div>
            <div class="col-xl-8">
                <!-- Account details card-->
                <div class="card mb-4">
                    <div class="card-header">Account Details</div>
                    <div class="card-body">
                        <form action="#" class="form" id="form-1" method="post">
                            <div class="row row-form-edit">

                                <!-- Form Group (email address)-->
                                <div class="col-md-6">
                                    <label class="label-profile-edit" for="email">Email address</label>
                                    <input class="form-control" id="email" type="email" placeholder="Enter your email address" value="name@example.com">
                                   <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                 
                                    <span class="form-message"></span>
                                     <span class="error__bk">Email is exist</span>   

                                </div>
                                <!-- Form Group (username)-->
                                <div class="col-md-6 ">
                                    <label class="label-profile-edit" for="inputUsername">Name</label>
                                    <input class="form-control" id="fullname" type="text" placeholder="Enter your username" value="username">
                                   <!-- dung co ma cham vo form-message , cai nay do js lam roi -->
                                 
                                    <span class="form-message"></span>
                                    
                                </div>
                            </div>
                            <!-- Form Row-->
                            <div class="row  row-form-edit ">
                                <!-- Form Group (old pw)-->
                                <div class="col-md-6">
                                    <label class="label-profile-edit" for="inputFirstName">Old Password</label>
                                    <input class="form-control" id="password_old" type="password" placeholder="Enter your first name" value="123456">
                                   <!-- dung co ma cham vo form-message , cai nay do js lam roi -->
                                    <span class="form-message"></span>
                                    <span class="error__bk">Password is not correct</span>   

                                    
                                </div>
                                <!-- Form Group (new pw)-->
                                <div class="col-md-6">
                                    <label class="label-profile-edit" for="inputLastName">New Password</label>
                                    <input class="form-control" id="password_new" type="password" placeholder="Enter your last name" value="123456">
                                   <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                    
                                    <span class="form-message"></span>
                                </div>
                            </div>    
                            <!-- Form Row-->
                            <div class="row  ">
                                <!-- Form Group (phone number)-->
                                <div class="col-md-6">
                                    <label class="label-profile-edit" for="inputPhone">Phone number</label>
                                    <input class="form-control" id="phoneNumber" type="tel" placeholder="Enter your phone number" value="555-123-4567">
                                   <!-- dung co ma cham vo form-message , cai nay do js lam roi -->                                   
                                    <span class="form-message"></span> <!-- dont touch --> 
                                    
                                </div>
                                <!-- Form Group (birthday)-->
                                <div class="col-md-6">
                                    <label class="label-profile-edit" for="inputBirthday">Birthday</label>
                                    <select name="choice-gender" id="" class="input__form ">
                                        <option value="Man">Man</option>
                                        <option value="Woman">Woman</option>
                                        <option value="Orther">Orther</option>
                                    </select>
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
    <script src="./assets/js/footer.js" ></script>
</body>
<script src="./assets/js/validator.js"></script>
<script>
    Validator({
        form: '#form-1',
        errorSelector:'.form-message',
        rules: [
            Validator.isEmail('#email', 'Please fill true email'),
            Validator.isRequired('#fullname', 'Please fill your full name'),
            Validator.isRequired('#password_old', 'Please fill your old password'),
            Validator.minLength('#password_new', 6),
            Validator.isPhoneNumber('#phoneNumber','Phone number at least 10 number')
        ]
    });
</script>
</html>