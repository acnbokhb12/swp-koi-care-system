<%-- 
    Document   : checkout
    Created on : Oct 4, 2024, 9:39:51 PM
    Author     : Khanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Checkout</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- font anwsome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <!-- <link rel="stylesheet" href="./assets/css/bootstrap.min.css"> -->
        <!-- jquery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <!-- css -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/cart.css">

    </head>

    <body style="background-color: #f1f5f9;">
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->

        <div class="checkout-page-main container">
            <header class="checkout-page-main-introheader">
                <h2 class="checkout-page-main-header col-12">Checkout form</h2>
                <p class="text-intro-checkout col-12">Complete the form with your billing and shipping information.
                    Double-check your details before submitting.</p>
            </header>


            <div class="row form__checkout-main">
                <div class="form__checkout-infor-cast col-md-5 order-md-2 ">
                    <h4 class="checkout-infor-cast-title">
                        <span>Your Cart</span>
                        <span><a href="cart.jsp">Edit Cart</a></span>
                    </h4>
                    <ul class="list__product">
                        <!-- sua tu khuc nay -->
                        <c:set var="TotalProduct" value="0"></c:set>
                        <c:forEach items="${sessionScope.cart}" var="odi"> 
                            <li class="list-group-item">
                                <div class="item-detail-desc">
                                    <div class="contain-img-product">
                                        <img src="${odi.product.imgProduct}"
                                             alt="${odi.product.nameProduct}">
                                    </div>
                                    <div class="description-product">
                                        <h4 class="description-product-name">${odi.product.nameProduct}</h4>
                                        <h4 class="description-product-type">Qty : <span style="margin-left: 7px;">${odi.quantity}</span></h4>

                                        <h4 class="price-item-checkout">
                                            <fmt:formatNumber value="${odi.unitPrice}" pattern="#,###"/> đ
                                        </h4>
                                    </div>
                                </div>
                                <div class="subtotal-item">
                                    <h4 class="name-price-subtotal">the total amount:</h4>
                                    <h4 class="price-subtotal">
                                        <fmt:formatNumber value="${odi.totalPrice}" pattern="#,###"/> đ
                                    </h4>
                                        <c:set var="TotalProduct" value="${TotalProduct + odi.totalPrice   }" />
                                </div>
                            </li>
                        </c:forEach>



                    </ul>

                    <div class="list-group-item-total">
                        <h5 style="color: #FFA500;">Order total:</h5>
                        <span class="price-item-checkout">
                               <h3 id="subtotal-quantity-price-item"><fmt:formatNumber value="${TotalProduct}" pattern="#,###"/> đ </h3>
                        </span>
                    </div>

                </div>
                <div class="form__checkout-infor-customer col-md-7 order-md-1">
                    <h4>Add a new address</h4>
                    <div class="form__checkout-infor-desc">
                        <form action="CheckOutController" method="post">
                            <div class="form__checkout-name form-simple">
                                <label for="fullname">
                                    Full name (First and Last name)
                                </label>
                                <input name="cusname" id="fullname" type="text" value="${sessionScope.userAccount.fullName}" required>
                            </div>
                            <div class="form__checkout-phone form-simple">
                                <label for="phonenumber">
                                    Phone number
                                </label>
                                <input name="phone" id="phonenumber" type="text" value="${sessionScope.userAccount.phoneNumber}" required>
                            </div>
                            <div class="form__checkout-address-street form-simple">
                                <label for="address-street-checkout">
                                    Address
                                </label>
                                <input name="address" id="address-street-checkout" type="text" value="${sessionScope.userAccount.address}" placeholder="Street address">
                            </div>

                            <div class="form__checkout-payment-method">
                                <h4>Payment method</h4>
                                <div class="container-brn-pay">
                                    <div class="custom-radio">
                                        <input type="radio" id="radio-1" class="card-tick-cash-byhand" name="tabs"
                                               checked="">
                                        <label class="radio-label" for="radio-1">
                                            <div class="radio-circle"></div>
                                            <span class="radio-text"><i class="fa-solid fa-money-bill"></i>Cash before
                                                shipment</span>
                                        </label>

                                    </div>
                                </div>
                            </div>
                            <button class="form__checkout-btn" type="submit">Complete</button>
                        </form>
                    </div>
                </div>
            </div>

            <footer class="footer-checkout">
                <p class="">2024-2025 Kahof Makede</p>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Privacy</a></li>
                    <li class="list-inline-item"><a href="#">Terms</a></li>
                    <li class="list-inline-item"><a href="#">Support</a></li>
                </ul>
            </footer>

        </div>
        <!-- footer -->
        <div id="footer"></div>
        <script>

        </script>

    </body>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
    </script>

</html>