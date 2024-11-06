<%-- 
    Document   : purchaseHistory
    Created on : Oct 2, 2024, 10:52:17 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Salt Caculator</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <!-- Font icon -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- jquery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/about_contact.css">
    </head>

    <body style="background-color: #ccc">
        <!-- start header -->
        <div id="header"></div>
        <div class="main-order">
            <div class="container container-order-history">
                <div class="row row-title-order" style="padding: 0px 24px;">
                    <h1>Purchase history</h1>
                </div>
                <div class="row">
                    <div class="col-xxl-8 col-12">
                        <!-- card -->
                        <div class="card" style="border-radius: 8px;">
                            <!-- card body-->
                            <div class="card-body">
                                <div class="mb-6 title-order-history">
                                    <h4 class="mb-0">Your Order</h4>
                                    <p>Check the status of recent orders, manage returns, and discover similar products.</p>
                                </div>
                                 
                                <!-- mb-8 o day la nhung mon order trong 1 ngay cu the -->
                                <c:forEach items="${listPurchaseHistory}" var="ord"> 
                                    
                                    <div class="mb-8" style="margin-bottom: 10px;">
                                        <!-- text -->
                                        
                                        <div class="row border-bottom mb-3 pb-3 d-lg-flex align-items-center justify-content-between">
                                            <div class="col-6 name-order-date d-flex align-items-center">
                                                <h5 class="mb-0">Order ${ord.id}</h5>
                                                <span class="ms-2">
                                                    <c:set var="formattedDate" value="${fn:substring(ord.orderDate, 0, 10)}" />
                                                    ${formattedDate}
                                                </span>
                                            </div>    
                                             <div class="col-6 d-flex align-items-center justify-content-end "> 
                                                <h1 class="m-0">Status: </h1>
                                                <h2 class="m-0 ml-2  ${ord.orderStatusId == 1 ? 'badge badge-secondary' : (ord.orderStatusId == 2 ? 'badge badge-warning"badge badge-warning' : 'badge badge-success') }" style="padding: 6px 10px; font-size: 1.6rem; ">${ord.orderS.orderStatusName}</h2>
                                            </div> 
                                        </div>
                                        <c:set var="TotalProduct" value="0"></c:set>
                                        <c:forEach items="${ord.orderItems}" var="item">             
                                            <!-- row -->
                                            <div class="row justify-content-between align-items-center mb-3">
                                                <!-- col -->
                                                <div class="col-lg-8 col-12">
                                                    <div class="d-md-flex">
                                                        <div class="cotain-img-order-detail">
                                                            <!-- img -->
                                                            <img src="${item.product.imgProduct}"
                                                                 alt="" class="img-4by3-xl rounded" style="height: 160px;">
                                                        </div>
                                                        <div class="contain-description-order-detail ms-md-4 mt-2 mt-lg-0">
                                                            <!-- heading -->
                                                            <h5 class="mb-1">
                                                                ${item.product.nameProduct}
                                                            </h5>
                                                            <!-- text -->

                                                            <span>Type: <span class="contain-type-qty text-dark"
                                                                              style="text-transform: capitalize;"> ${item.product.categoryP.categoryName}
                                                                </span>,
                                                                Qty:<span class="contain-type-qty text-dark">${item.quantity}</span>
                                                            </span>
                                                            <!-- text -->
                                                            <div class="contain-price-order-detail">
                                                                <h4 class="price-detail-product"> 
                                                                    <fmt:formatNumber value=" ${item.unitPrice}" pattern="#,###"/> đ
                                                                </h4>
                                                            </div>
                                                        </div>   
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 contain-subtotal-order-detail ml-0"> 
                                                    <h5 class="detail-subtotal-order-detail">
                                                        <c:set var="TotalProduct" value="${TotalProduct + item.totalPrice   }" />
                                                        <fmt:formatNumber value=" ${item.totalPrice}" pattern="#,###"/> đ
                                                    </h5>
                                                </div>
                                                <!-- button -->
                                                <div class="col-lg-2 col-12 d-grid"> 
                                                    <button class="btn-buy-again">
                                                        <a href="MainController?action=productDetail&pid=${item.productID}">Buy again</a>
                                                    </button>
                                                </div>
                                            </div>
                                            <hr class="my-3">
                                        </c:forEach>  
                                        <!-- row -->
                                        <div class="grand-total-order">
                                            <div class="grand-total-order-detail">
                                                <h1 class="grand-total-title">Grand total:</h1>
                                                <h1 class="grand-total-price">
                                                   <h2 id="subtotal-quantity-price-item"><fmt:formatNumber value="${TotalProduct}" pattern="#,###"/> đ </h2>
                                                </h1>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
        <style> 

            .contain-type-qty {
                text-transform: capitalize; 

            }

            .contain-price-order-detail {
                margin-top: 20px;
            }

            .contain-price-order-detail>h4 {
                font-size: 2rem;
            }

            .contain-subtotal-order-detail{
                margin-left: 5rem;
                display: flex;
                flex-direction: column;
                justify-content: space-around;

            }
            .contain-subtotal-order-detail h5{
                font-size: 2rem
            }
            /* nut */
            .grand-total-order-detail{
                display: flex;
                justify-content: flex-end;
                align-items: center;
            }
            .grand-total-order-detail h1:first-child {
                margin-right: 10px;
                background-color: #00BFA6;
                padding: 4px 10px;
                border-radius: 8px;
                color: #fff;
            }
            @media screen and (max-width:992px) {
                .contain-status-order-detail{
                    justify-content: flex-start;
                    margin-top: 10px;   
                }
                .btn-buy-again{
                    margin-top: 12px;
                }
            }

            @media screen and (max-width:768px) {
                .post-entry-aboutus h1{
                    font-size: 5rem;
                }
                .post-entry-aboutus p{
                    font-size: 1.4rem;
                }
                .item-desc-intro{
                    flex-direction: column;
                }
                .space-betw{
                    display: block;
                    width: 100%;
                    height: 30px;
                }
                .img-first{
                    width: 100%;
                    height: 450px;
                }
                .text-desc{
                    width: 100%;
                    padding: 30px;
                }
                .img-first-secondchild{
                    order: 1;
                }
                .text-first-secondchild{
                    order: 2;
                }
                .contain-description-order-detail {
                    margin-left: 0;
                }    
                .contain-status-order-detail{
                    margin-left: 0;
                }
                .contain-subtotal-order-detail{
                    margin-left: 0;
                    flex-direction: row;
                    justify-content: flex-start;
                }
                .contain-subtotal-order-detail h5:last-child{
                    margin-left: 10px;

                }
            }
        </style>
            <script src="./assets/js/notification.js"></script>

        <script>
            $('#header').load('utils.jsp #header__nav', () => {
                $.getScript('./assets/js/utilsCustomer.js');
            });
            $('#footer').load('utils.jsp #footer__nav', () => {
                $.getScript('./assets/js/utilsCustomer.js');
            });
        </script>
    </body>

</html>