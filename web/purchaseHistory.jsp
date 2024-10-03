<%-- 
    Document   : purchaseHistory
    Created on : Oct 2, 2024, 10:52:17 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Profile</title>
  <!-- Font gg family -->
  <link
    href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
    rel="stylesheet"
  />
  <!-- Font icon -->
  <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"  />
  <!-- bootstrap -->
  <link  rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
    crossorigin="anonymous"
  />
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="./assets/css/base.css" />
  <link rel="stylesheet" href="./assets/css/navHeader-Footer.css" />
  <link rel="stylesheet" href="assets/css/history.css" />
</head>
<body class="body_history-order">
     <!-- start header -->
         <div id="header"></div>
        <!-- end header -->
  <div class="container">
    <div class="content">
      
      <div class="main-order">
        <div class="container">
          <div class="row row-title-order" >
            <h1> Order history </h1>
          </div>
          <!-- Dashboard Summary -->
          
          <div class="row">
            <div class="col-xxl-8 col-12">
              <div class="card">
                <div class="card-body">
                  <div class="mb-6 title-order-history">
                    <h1 class="mb-0">Your Order</h1>
                    <p>
                      Check the status of recent orders and discover similar
                      products and services.
                    </p>
                  </div>
                  <!-- Order Detail -->
                  <div class="mb-8" style="margin-bottom: 40px">
                    <!-- First Order -->
                    <div class="border-bottom mb-3 pb-3 d-lg-flex">
                      <div class="name-order-date d-flex">
                        <h5 class="mb-0">Order #GK00017</h5>
                        <span class="ms-2 order-date">On June 26, 2022</span>
                      </div>
                    </div>

                    <!-- First Product -->
                    <div class="row mb-3">
                      <div class="col-lg-8 col-12 d-md-flex">
                        <img
                          src="https://d3ulc7s3nchmqx.cloudfront.net/nv3hbr9u6blrgj7c7cg9bksce7hpsl8tda28fsvd7i7pemqfhrj1e_720.jpg"
                          alt="White & Red Nike Athletic Shoe"
                          class="img-4by3-xl rounded"
                        />
                        <div class="ms-md-4 mt-2 mt-lg-0">
                          <h5>White & Red Nike Athletic Shoe</h5>
                          <span class="description">
                            Type:
                            <span class="product-type">ingredients</span>,
                            Qty: <span>10</span>
                          </span>
                          <div>
                            <h4 class="price-detail-product">40000</h4>
                          </div>
                        </div>
                      </div>
                      <div class="col-lg-3 col-12 d-grid">
                        <button class="btn-buy-again">
                          <a href="#">BUY AGAIN</a>
                        </button>
                      </div>
                    </div>

                    <!-- Second Product -->
                    <div class="row mb-3">
                      <div class="col-lg-8 col-12 d-md-flex">
                        <img
                          src="https://d3ulc7s3nchmqx.cloudfront.net/nv3hbr9u6blrgj7c7cg9bksce7hpsl8tda28fsvd7i7pemqfhrj1e_720.jpg"
                          alt="Another Product"
                          class="img-4by3-xl rounded"
                        />
                        <div class="ms-md-4 mt-2 mt-lg-0">
                          <h5>Another Product</h5>
                          <span class="description">
                            Type: <span class="product-type">accessory</span>,
                            Qty: <span>5</span>
                          </span>
                          <div>
                            <h4 class="price-detail-product">30000</h4>
                          </div>
                        </div>
                      </div>
                      <div class="col-lg-3 col-12 d-grid">
                        <button class="btn-buy-again">
                          <a href="#">BUY AGAIN</a>
                        </button>
                      </div>
                    </div>
                    <hr class="hr-custom-spacing" />

                    <!-- Second Order -->
                    <div class="border-bottom mb-3 pb-3 d-lg-flex">
                      <div class="name-order-date d-flex">
                        <h5 class="mb-0">Order #GK00018</h5>
                        <span class="ms-2 order-date">On July 15, 2022</span>
                      </div>
                    </div>

                    <!-- Third Product -->
                    <div class="row mb-3">
                      <div class="col-lg-8 col-12 d-md-flex">
                        <img
                          src="https://d3ulc7s3nchmqx.cloudfront.net/nv3hbr9u6blrgj7c7cg9bksce7hpsl8tda28fsvd7i7pemqfhrj1e_720.jpg"
                          alt="Third Product"
                          class="img-4by3-xl rounded"
                        />
                        <div class="ms-md-4 mt-2 mt-lg-0">
                          <h5>Third Product</h5>
                          <span class="description">
                            Type: <span class="product-type">gadget</span>,
                            Qty: <span>7</span>
                          </span>
                          <div>
                            <h4 class="price-detail-product">50000</h4>
                          </div>
                        </div>
                      </div>
                      <div class="col-lg-3 col-12 d-grid">
                        <button class="btn-buy-again">
                          <a href="#">BUY AGAIN</a>
                        </button>
                      </div>
                    </div>

                    <!-- Fourth Product -->
                    <div class="row mb-3">
                      <div class="col-lg-8 col-12 d-md-flex">
                        <img
                          src="https://d3ulc7s3nchmqx.cloudfront.net/nv3hbr9u6blrgj7c7cg9bksce7hpsl8tda28fsvd7i7pemqfhrj1e_720.jpg"
                          alt="Fourth Product"
                          class="img-4by3-xl rounded"
                        />
                        <div class="ms-md-4 mt-2 mt-lg-0">
                          <h5>Fourth Product</h5>
                          <span class="description">
                            Type: <span class="product-type">homeware</span>,
                            Qty: <span>3</span>
                          </span>
                          <div>
                            <h4 class="price-detail-product">60000</h4>
                          </div>
                        </div>
                      </div>
                      <div class="col-lg-3 col-12 d-grid">
                        <button class="btn-buy-again">
                          <a href="#">BUY AGAIN</a>
                        </button>
                      </div>
                    </div>

                    <!-- Fifth Product -->
                    <div class="row mb-3">
                      <div class="col-lg-8 col-12 d-md-flex">
                        <img
                          src="https://d3ulc7s3nchmqx.cloudfront.net/nv3hbr9u6blrgj7c7cg9bksce7hpsl8tda28fsvd7i7pemqfhrj1e_720.jpg"
                          alt="Fifth Product"
                          class="img-4by3-xl rounded"
                        />
                        <div class="ms-md-4 mt-2 mt-lg-0">
                          <h5>Fifth Product</h5>
                          <span class="description">
                            Type: <span class="product-type">office</span>,
                            Qty: <span>2</span>
                          </span>
                          <div>
                            <h4 class="price-detail-product">25000</h4>
                          </div>
                        </div>
                      </div>
                      <div class="col-lg-3 col-12 d-grid">
                        <button class="btn-buy-again">
                          <a href="#">BUY AGAIN</a>
                        </button>
                      </div>
                    </div>
                    <hr class="my-3" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
    </div>
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
    <script>
      const priceElements = document.querySelectorAll(".price-detail-product");
      priceElements.forEach(function (element) {
        let price = parseInt(element.innerText);
        let formattedAmount = price.toLocaleString("vi-VN", {
          style: "currency",
          currency: "VND"
        });
        element.innerText = formattedAmount;
      });
    </script>
  
</html>
