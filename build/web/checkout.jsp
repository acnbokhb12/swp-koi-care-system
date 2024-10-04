<%-- 
    Document   : checkout
    Created on : Oct 4, 2024, 9:39:51 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Check Out</title>
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
    <link rel="stylesheet" href="./assets/css/money.css">
    </head>
    <body>
        <script src="./assets/js/headernav.js"></script>
    <div class="container container-checkout">
        <div class="checkout-container">
            <div class="form-section">
                <div class="checkout">
                    <h2>Checkout</h2>
                </div>
                <h3>Shipping Information</h3>
                <div class="form-group">
                    <label for="fullname"><h5>Full name *</h5></label>
                    <input type="text" id="fullname" placeholder="Enter your full-name">
                </div>
                <div class="form-group">
                    <label for="email"><h5>Email address *</h5></label>
                    <input type="email" id="email" placeholder="Enter email address">
                </div>
                <div class="form-group">
                    <label for="phone"><h5>Phone number *</h5></label>
                        <input type="text" id="phone" placeholder="Enter phone number" style="flex: 1;">
                </div>
                <div class="form-group-checkbox">
                    <input type="checkbox" id="terms">
                    <label for="terms"><h4>I have read and agree to the Terms and Conditions.</h4></label>
                </div>
            </div>
            <div class="cart-section">
                <h3>Review your cart</h3>
                <div class="cart-item">
                    <img src="https://product.hstatic.net/200000164479/product/cam_ca_king_feed_01_160e77157c83487eb3ad7e5f617fcc66.jpg" alt="A DuoComfort Sofa Premium">
                    <div class="cart-item-details">
                        <h4>DuoComfort Sofa Premium</h4>
                        <h4>Quantity: 1</h4>
                    </div>
                    <div class="cart-item-price">VND</div>
                </div>
                <div class="summary">
                    <div>
                        <span>Subtotal</span>
                        <span>VND</span>
                    </div>
                    <div>
                        <span>Shipping</span>
                        <span>VND</span>
                    </div>
                    <div class="total">
                        <span>Total</span>
                        <span>VND</span>
                    </div>
                </div>
                <button class="pay-now">Pay Now</button>
            </div>
        </div>
    </div>
    <script src="./assets/js/footer.js"></script>
    </body>
</html>
