<%-- 
    Document   : productDetail
    Created on : Sep 30, 2024, 10:40:19 AM
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
    <!-- Font gg family -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
      rel="stylesheet">
    <!-- Font icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/shopPage.css">
</head>
<body class="body__shop">
    <!-- start header -->
         <div id="header"></div>
        <!-- end header -->
    <!-- product -->
    <div class="product__content__detail-main">
        <div class="product__content__detail-container container">
          <div class="product__content_grid">
            <div class="row">
              <!-- info img -->
              <div class="product__content__detail-info-img col-md-6">
                <div class="product__detail-img"> 
                    <img
                    src="${Product.imgProduct}"
                    alt="">
                </div>
              </div>
              <!-- info product detail  -->
              <div class="product__content__detail-sumary col-md-6">
                <h1 class="product__content__detail-title">${Product.nameProduct}</h1>
                <div class="product__content__detail-rating">
                   
    
                  <div class="product__content__detail-rating-customer">
                     <h2 class="title_cate_pd">
                        ${Product.categoryP.categoryName}
                    </h2>
                  </div>
                </div>
                <div class="product__content__detail-desc">
                  <p>
                     ${Product.description}
                  </p>
                </div>
                <p class="product__content__detail-price">
                  <span id="product__detail-price-id" class="product__detail-price">${Product.price}</span>
                </p>
                <!-- quantity buy product -->
                <div class="product__content__detail-form">
                  <form action="AddProductToCartController" method="post">
                    <div class="product__detail-form-desc">
                      <h1>Quantity</h1>
                      <div class="product__detail-quantity-btn">
                          <input type="hidden" value="${Product.productID}" name="idProduct"> 
                        <button type="button" class="minus-btn-quantity"><i class="fa-solid fa-minus"></i></button>
                        <input type="number" min="1" id="quantity-input" name="quantityP" value="1">
                        <button type="button" class="plus-btn-quantity"><i class="fa-solid fa-plus"></i></button>
                      </div>
                      <!-- submit buy product -->
                      <div class="product__btnbuy-ing-pro">
                        <button type="submit" name="acction" class="product__detail-buybtn ">
                          <i class="fa-solid fa-cart-shopping"></i> Add product to cart
                        </button> 
                      </div>
                    </div>
                  </form>
                </div>
                
                <!-- extra  -->
                <div class="product__content__extra">
                  <div class="product__content__extra-info">
                    <ul class="product__content__extra-info-list">
                      <li>Free global shipping on all orders</li>
                      <li>30 days easy returns if you change your mind</li>
                      <li>Order before noon for same day dispatch</li>
                    </ul>
                  </div>
                  <div class="product__content__extra-brand">
                    <h5>Guaranteed Safe Checkout</h5>
                    <img src="./assets/img/content/brand.png" alt="">
                  </div> 
                </div>
              </div>
            </div>
          </div>
          
        </div>
      </div>
    <!-- Toast -->
        <c:if test="${toastMessage != null}"> 
        <div id="toast">  
            <div class="toast_main row ${toastMessage.equals('success') ? 'toast--success' : 'toast--error' }">
                <div class="toast__icon">
                    <i class="fa-solid ${toastMessage.equals('success') ? 'fa-circle-check' : 'fa-times-circle' }"></i>
                </div>
                <div class="toast_body">
                    <h3 class="toast__title">${toastMessage.equals('success') ? 'Success' : 'Error' }</h3>
                    <p class="toast__msg">${message}</p>
                </div>
                <div class="toast__close">
                    <i class="fas fa-times"></i>
                </div>
            </div>
        </div>
        </c:if>
    <!-- footer -->
        <div id="footer"></div>
</body>
  <script>
    $('#header').load('utils.jsp #header__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
    $('#footer').load('utils.jsp #footer__nav', ()=>{
        $.getScript('./assets/js/utilsCustomer.js');
    });
</script>
    <script src="assets/js/notification.js"></script>

<script>
    const minusBtn = document.querySelector('.minus-btn-quantity');
      const plusBtn = document.querySelector('.plus-btn-quantity');
      const quantityInput = document.getElementById('quantity-input');

      minusBtn.addEventListener('click', function () {
        let currentValue = parseInt(quantityInput.value);
        if (currentValue > 1) {
          quantityInput.value = currentValue - 1;
        }
      });

      plusBtn.addEventListener('click', function () {
        let currentValue = parseInt(quantityInput.value);
        quantityInput.value = currentValue + 1;

      });
      
      let amount = parseInt(document.getElementById('product__detail-price-id').innerText);
      let formattedAmount = amount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
      document.getElementById('product__detail-price-id').innerText = formattedAmount;
</script>
<style>
    .title_cate_pd{
    background-color: var(--bs-orange);
    padding: 0.4rem 1.2rem;
    color: var(--white-color);
    border-radius: 8px;
 }
</style>
</html>