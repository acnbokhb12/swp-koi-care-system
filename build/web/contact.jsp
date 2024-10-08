<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 
    Document   : contact
    Created on : Oct 8, 2024, 1:07:30 PM
    Author     : ASUS
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contact Page</title>
        <!-- Font icon -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Style CSS -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/main.css">
        <link rel="stylesheet" href="./assets/css/about_contact.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        <div id="main">
            <!-- Start header -->
            <div id="header"></div>
            <!-- End header -->
            <div class="main-contact">
                <div class="container-infor-contact">
                    <!-- Image -->
                    <div class="img-contact-intro">
                        <img src="https://podbaranem.com/wp-content/uploads/2017/05/IMG_2724.jpg" alt="">
                    </div>
                    <!-- Description -->
                    <div class="contact-detail-dest">
                        <h2>Contact Us</h2>
                        <div class="row fill-description-map">
                            <div class="col-md-12 col-lg-6 fill-infor-self">
                                <h2>Get In Touch</h2>
                                <p>We are here to assist you with the care and management of your Koi pond. If you have any questions regarding our products and advice on Koi care techniques, please fill out the form below. Our team of experts will get back to you as soon as possible.</p>
                                <div class="contain-form-contact">
                                    <form action="" method="post">
                                        <div class="item-contact">
                                            <label>First Name</label><br>
                                            <input type="text" name="firstName" required>
                                        </div>
                                        <div class="item-contact">
                                            <label>E-Mail</label><br>
                                            <input type="email" name="email" required>
                                        </div>
                                        <div class="item-contact">
                                            <label>Message</label><br>
                                            <textarea name="message" class="" required></textarea>
                                        </div>

                                        <span>
                                            <button type="submit" class="btn-sub-contact">SEND NOW</button>
                                        </span>
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-12 col-lg-6 img-map-our">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.6100105370224!2d106.8073080748579!3d10.84112758931161!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752731176b07b1%3A0xb752b24b379bae5e!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBGUFQgVFAuIEhDTQ!5e0!3m2!1svi!2s!4v1719624859782!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>  
        </div>  
        <div id="footer"></div>
        <script>
            $(document).ready(function () {
                $('#header').load('utils.jsp #header__nav', function () {
                    $.getScript('./assets/js/utilsCustomer.js');
                });
                $('#footer').load('utils.jsp #footer__nav', function () {
                    $.getScript('./assets/js/utilsCustomer.js');
                });
            });
        </script>
    </body>
</html>
