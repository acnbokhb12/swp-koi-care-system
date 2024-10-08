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
                    <a href="fish.jsp" class="back-btn">Back to List</a>
                    <a href="#" class="delete-btn-fish">Delete</a>
                    <button class="edit-btn-out">Edit Information</button>
                </div>
            </div>
            <div class="row mt-4 row-infor-fish-detail">
                <div class="col-4 fish-img-info">
                    <!-- Assuming you have an image URL in the fish object -->
                    <img
                        src="${fish.fishImage}" 
                        alt="${fish.fishName}" />
                </div>

                <div class="col-8 info">
                    <h2 class="info-title">Fish Details</h2>
                    <div class="info-item">
                        <span class="label">Fish Name:</span>
                        <span class="value">${fish.fishName}</span> 
                    </div>
                    <div class="info-item">
                        <span class="label">Body Shape:</span>
                        <span class="value">${fish.bodyShape}</span>
                    </div>
                    <div class="info-item">
                        <span class="label">Age:</span>
                        <span class="value">${fish.age} years</span> 
                    </div>
                    <div class="info-item">
                        <span class="label">Length:</span>
                        <span class="value">${fish.length} cm</span> 
                    </div>
                    <div class="info-item">
                        <span class="label">Weight:</span>
                        <span class="value">${fish.weight} </span> 
                    </div>
                    <div class="info-item">
                        <span class="label">Gender:</span>
                        <span class="value">${fish.gender}</span> 
                    </div>

                    <hr />
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
    <div class="container__infor__fish">
        <div class="infor__fish-detail">
            <div class="row row-fish-detail">
                <div class="col-4  " style="padding: 0">
                    <div class="img-edit-submit">
                        <div class="fish-img-info-edit">
                            <img
                                src="https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg"
                                alt="Koi Pond">
                        </div>
                        <div class="fish-edit-img-detail">
                            <form action="" class="form-edit-img-fish">
                                <input type="file">
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
                    <form>
                        <div class="row row-edit-info-detail">
                            <div class="col-md-6 edit-item-detail">
                                <span>Fish Name </span>
                                <input type="text" value="" placeholder="Enter fish name" />
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Body Shape </span>
                                <input type="text" value="" placeholder="Enter body shape" />
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Age </span>
                                <input type="number" value="" placeholder="Enter age" />
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Length (cm) </span>
                                <input type="number" step="0.1" value="" placeholder="Enter length in cm" />
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Weight (kg) </span>
                                <input type="number" step="0.1" value="" placeholder="Enter weight in kg" />
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Gender </span>
                                <select>
                                    <option selected value="M">Male</option>
                                    <option value="F">Female</option>
                                </select>
                            </div>
                            <div class="col-md-6 edit-item-detail">
                                <span>Origin </span>
                                <input type="text" value="" placeholder="Enter origin" />
                            </div>
                        </div>
                        <div class="text-center">
                            <button class="edit-btn blue-btn" style="margin-top: 10px">
                                Confirm
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <div id="footer"></div>
</body>
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

    confirmBtn.addEventListener("click", (e) => {
        e.preventDefault();
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