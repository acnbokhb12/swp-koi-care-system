<%-- 
    Document   : fishInfor
    Created on : Sep 30, 2024, 10:38:17 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home</title>
        <!-- link logo img page -->
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <!-- Font gg family -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap"
              rel="stylesheet">
        <!-- Font icon -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- echart js -->
        <script src="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <!-- css -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/fishE.css">
    </head>

    <body class="body-fish">
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->
        <section class="container container_fish">
            <div class="tilte-fish">
                <h1>Fish Information</h1>
                <div class="text-right">
                    <a href="MainController?action=fish" class="back-btn">Back to List</a>
                    <a href="MainController?action=fishdelete&fishID=${fish.fishID}" class="delete-btn-fish">Delete</a>                
                    <button class="edit-btn-out">Edit Information</button>
                </div>
            </div>
            <div class="row mt-4 row-infor-fish-detail">
                <div class="col-4 fish-img-info">
                    <!-- Assuming you have an image URL in the fish object -->
                    <img src="${fish.fishImage}"  alt="${fish.fishName}" style="object-fit: unset;" />
                </div>

                <div class="col-8 info"> 
                    <div class="info-item">
                        <span class="label label-witdh">Fish Name:</span>
                        <span class="value span-witdh">${fish.fishName}  </span> 
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Body Shape:</span>
                        <span class="value span-witdh">${fish.bodyShape}</span>
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Age:</span>
                        <span class="value span-witdh">${fish.age} <span class="sub_span-highlight">(Years)</span> </span> 
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Length:</span>
                        <span class="value span-witdh">${fish.length} <span class="sub_span-highlight">(Cm)</span></span> 
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Weight:</span>
                        <span class="value span-witdh">${fish.weight} <span class="sub_span-highlight">(Kg)</span> </span> 
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Gender:</span>
                        <span class="value span-witdh">${fish.gender}</span> 
                    </div>
                    <div class="info-item">
                        <span class="label label-witdh">Description:</span> 
                        <span class="value span-witdh">${fish.descriptionKoi}</span>
                    </div>

                </div>
            </div>
        </section>

        <!-- growth -->
        <section class="growth-container container">
            <div class="tilte-fish-growth"> 
                <h1>Fish Growth</h1>
                <div class="text-right">
                    <a href="fishGrowth.jsp" class="back-btn grow__detail-btn">View Growth Detail</a> 
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-md-6 item_grow_fish">
                    <div id="koiGrowthChart_length" style="width: 100%; height: 400px;"></div>
                </div>
                <div class="col-md-6 item_grow_fish">
                    <div id="koiGrowthChart_weight" style="width: 100%; height: 400px;"></div>
                </div>
            </div>
        </section>


        <!-- Go to pond -->
        <section class="container container-pond-fish "> 
            <div class="pond-item  ">
                <div class="tilte-fish-growth  "> 
                    <h1>The pond of this fish</h1>
                    <div class="text-right">
                        <a href="pondinfor.html" class="back-btn grow__detail-btn">View Pond Detail</a> 
                    </div>
                </div>
                <div class="pond-item-img mt-4">
                    <div href="#">
                        <img src="https://animals.sandiegozoo.org/sites/default/files/2016-11/Koi.jpg" alt="Pond" />
                    </div>
                    <div class="pond-item-desc">
                        <p>
                            Tranquil Waters Pond Tranquil Waters Pond Tranquil Waters Pond
                        </p>
                    </div>
                </div>

            </div>

        </section>
        <!-- TABLE EDIT --> 
        <!-- Fish Information Edit Page -->
        <div class="container__infor__fish">
            <div class="infor__fish-detail">
                <div class="row row-fish-detail">
                    <div class="col-4" style="padding: 0">
                        <div class="img-edit-submit">
                            <div class="fish-img-info-edit">
                                <img id="imagePreview" src="${fish.fishImage}" alt="${fish.fishName}" style="max-height: 350px; object-fit: unset;" />
                            </div>
                            <div class="fish-edit-img-detail">
                                <form action="MainController?action=fishimageupdate" class="form-edit-img-fish" enctype="multipart/form-data" method="post">
                                    <input type="hidden" name="fishID" value="${fish.fishID}">
                                    <input id="imageInput" name="fileimg" type="file" accept="image/*" required>
                                    <button type="submit">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="col-8 edit-info">
                        <div class="text-right">
                            <button class="btn-close-fish">
                                <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                            </button>
                        </div>
                        <h2>New Information</h2>

                        <form action="MainController?action=fishinformationupdate" method="POST">
                            <div class="row row-edit-info-detail">
                                <input type="hidden" name="fishID" value="${fish.fishID}" />

                                <div class="col-md-6 edit-item-detail">
                                    <span>Fish Name </span>
                                    <input type="text" name="fishName" value="${fish.fishName}" placeholder="Enter fish name" required />
                                </div>

                                <div class="col-md-6 edit-item-detail">
                                    <span>Body Shape</span>
                                    <select name="bodyShape" style="width: 100%; padding: 4px; border: 1px solid #000;">  
                                        <option value="Slim" ${fish.bodyShape.equals("Slim") ? 'selected' : ''}>Slim</option>
                                        <option value="Fat" ${fish.bodyShape.equals("Fat") ? 'selected' : ''}>Fat</option>
                                        <option value="Long" ${fish.bodyShape.equals("Long") ? 'selected' : ''}>Long</option>
                                        <option value="Short" ${fish.bodyShape.equals("Short") ? 'selected' : ''}>Short</option>
                                        <option value="Large" ${fish.bodyShape.equals("Large") ? 'selected' : ''}>Large</option>
                                        <option value="Small" ${fish.bodyShape.equals("Small") ? 'selected' : ''}>Small</option>
                                    </select>
                                </div>

                                <div class="col-md-6 edit-item-detail">
                                    <span>Age </span>
                                    <input type="number" name="age" value="${fish.age}" placeholder="Enter age" required min="0" />
                                </div>

                                <div class="col-md-6 edit-item-detail">
                                    <span>Length (cm) </span>
                                    <input type="number" name="length" value="${fish.length}" step="0.1" placeholder="Enter length in cm" required min="0" />
                                </div>

                                <div class="col-md-6 edit-item-detail">
                                    <span>Weight (kg) </span>
                                    <input type="number" name="weight" value="${fish.weight}" step="0.1" placeholder="Enter weight in kg" required min="0" />
                                </div>

                                <div class="col-md-6 edit-item-detail">
                                    <span style="display: block;">Gender </span>
                                    <select name="gender" style="width: 100%; padding:0.4rem; border:1px solid #ccc" required>
                                        <option value="Male" <c:if test="${fish.gender == 'Female'}">selected</c:if>>Male</option>
                                        <option value="Female" <c:if test="${fish.gender == 'Female'}">selected</c:if>>Female</option>
                                        </select>
                                    </div>


                                    <div class="col-md-6 edit-item-detail">
                                        <span>Description </span>
                                        <input type="text" name="descriptionKoi" value="${fish.descriptionKoi}" placeholder="Enter description" required />
                                </div>
                                <div class="col-md-6 edit-item-detail">
                                    <span>Pond</span>
                                    <select name="pondkoi" style="width: 100%; padding: 4px; border: 1px solid #000;">
                                        <option value="0">Unassigned</option>
                                        <c:if test="${ListPond != null}">                                    
                                            <c:forEach items="${ListPond}" var="pd">
                                                <option value="${pd.pondID}" ${fish.pondID == pd.pondID ? 'selected' : ''}>${pd.name}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>

                            <div class="text-center">
                                <button type="submit" class="edit-btn blue-btn" style="margin-top: 10px">Confirm</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- footer -->

        <div id="footer"></div>
        <script src="./assets/js/utils.js"></script> 
    </body>
    <style>
        .label-witdh{
            width: 30%;
            color: blue;
        }
        .span-witdh{
            width: 70%;
            display: block;
            color: #000;
        }
        .sub_span-highlight{
            color: red;
            font-weight: 500;
        }
    </style>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
    </script>
    <script>
        const btnClose = document.querySelector(".btn-close-fish");
        const tableEdit = document.querySelector(".container__infor__fish");
        const btnOutOpen = document.querySelector(".edit-btn-out");
        const subTable = document.querySelector(".infor__fish-detail");
        const confirmBtn = document.querySelector(".edit-btn");

        btnOutOpen.addEventListener("click", function (e) {
            tableEdit.classList.add("open");
            e.stopPropagation();
        });

        btnClose.addEventListener("click", () => {
            tableEdit.classList.remove("open");
        }); 
        subTable.addEventListener("click", (e) => {
            e.stopPropagation();
        });

        document.addEventListener("click", () => {
            tableEdit.classList.remove("open");
        });
    </script>
    <script>
        var chart = echarts.init(document.getElementById('koiGrowthChart_length'));

        option = {
            title: {
                text: 'Length of fish 2024',

            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                itemWidth: 50,
                itemHeight: 12,
                textStyle: {
                    fontSize: 16, // Tăng kích thước chữ
                    fontWeight: 'bold' // Làm đậm chữ nếu muốn
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['01/09', '02/09', '03/09', '04/09', '05/09', '06/09', '07/09'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    axisLabel: {
                        formatter: '{value} Cm'
                    }
                }
            ],
            series: [
                {
                    name: 'Cm',
                    type: 'bar',
                    barWidth: '60%',
                    data: [10, 52, 200, 334, 390, 330, 320]
                            // ,
                            // itemStyle:{
                            //   color : function(param){
                            //     return '#000';
                            //   }
                            // }
                }
            ]
        };

        chart.setOption(option);
    </script>
    <script>
        var chart = echarts.init(document.getElementById('koiGrowthChart_weight'));

        option = {
            title: {
                text: 'Weight of fish 2024',
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: ['01/09', '02/09', '03/09', '04/09', '05/09', '06/09', '07/09'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    axisLabel: {
                        formatter: '{value} Gram'
                    }
                }
            ],
            series: [
                {
                    name: 'Gram',
                    type: 'bar',
                    barWidth: '60%',
                    data: [10, 52, 200, 334, 390, 330, 320]
                    ,
                    itemStyle: {
                        color: function (param) {
                            return '#d29763';
                        }
                    }
                }
            ]
        };

        chart.setOption(option);
    </script>

</html>