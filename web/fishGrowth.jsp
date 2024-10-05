<%-- 
    Document   : fishGrowth
    Created on : Oct 1, 2024, 8:52:03 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Fish Growth Information</title>
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
        <!-- css -->
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/fishE.css">
    </head>
    <body class="body-fish"> 
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->
        <div id="main-growth">
            <section class="growth_deatiail-main">
                <div class="container container-growth">
                    <div class="tilte-fish">
                        <h1>Fish Growth Chart</h1>
                        <div class="text-right">
                            <a href="fishinfor.html" class="back-btn" style="margin-right: 10px;">Back to Koi</a>

                            <button class="edit-btn-out">Add New Information</button>
                        </div>
                    </div>
                    <div class="row mt-4 row-growth_fish">
                        <div class="col-md-9 item_grow_fish">
                            <div id="koiGrowthChart_length" style="width: 100%; height: 500px;"></div>
                        </div>
                        <div class="col-md-3 item_grow_fish-detail">
                            <h2>Search statistics </h2>
                            <form action="" id="date_growth-length">
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="">From Date:</label>
                                    <input id="input_date_length_from" class="input_form-date lastweek_growth-input" type="date" name="" id="">
                                </div>
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="">To Date:</label>
                                    <input id="input_date_length_to" class="input_form-date today_growth-input" type="date" name="" id="">
                                </div>
                                <button class="btn-submit-search-date" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                    <div class="row mt-4 row-growth_fish">
                        <div class="col-md-9 item_grow_fish">
                            <div id="koiGrowthChart_weight" style="width: 100%; height: 500px;"></div>
                        </div>
                        <div class="col-md-3 item_grow_fish-detail">
                            <h2>Search statistics </h2>
                            <form action="#" id="date_growth-weight">
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="">From Date:</label>
                                    <input id="input_date_weight_from" class="input_form-date lastweek_growth-input" type="date" name="" id="">
                                </div>
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="">To Date:</label>
                                    <input id="input_date_weight_to" class="input_form-date today_growth-input" type="date" name="" id="">
                                </div>
                                <button class="btn-submit-search-date" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </div> 
        <div class="container__infor__fish">
            <div class="infor__fish-detail">
                <div class="row row-fish-detail">
                    <div class="col-4  " style="padding: 0">
                        <div class="img-edit-submit">
                            <div class="fish-img-info-edit">
                                <img src="https://www.thesprucepets.com/thmb/tucFN5e5O9-vbhr0jhbeL8zkFLY=/3572x0/filters:no_upscale():strip_icc()/GettyImages-1148621267-fbe7fcc9e0eb41078b0ee63bc3edc2b3.jpg" alt="Koi Pond" > 
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
                        <form action="#"  id="">
                            <div class="row row-edit-info-detail"> 
                                <div class="col-12 edit-item-detail">
                                    <span>Weight(Gram) </span>
                                    <input type="number" value="" placeholder="Enter age" required/>
                                </div>
                                <div class="col-12 edit-item-detail">
                                    <span>Length (cm) </span>
                                    <input
                                        type="number"
                                        step="0.1"
                                        value=""
                                        placeholder="Enter length in cm"
                                        required
                                        />
                                </div>
                                <div class="col-12 edit-item-detail">
                                    <span>Date </span>
                                    <input
                                        type="date"
                                        step="0.1"
                                        value=""
                                        placeholder="Enter length in cm"
                                        required
                                        />
                                </div>  


                            </div>
                            <div class="text-center">
                                <button class="edit-btn blue-btn" type="submit" style="margin-top: 10px" >
                                    Confirm
                                </button>                    
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="./assets/js/footer.js"></script>
    </body>
    <style>
        .infor__fish-detail{
            width: 50%;
        }
        .fish-img-info-edit{
            height: 100%;
        }
    </style>
    <script>
        var chart = echarts.init(document.getElementById('koiGrowthChart_length'));

        option = {
            title: {
                text: 'Length of fish 2024'

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
                    data: ['01/09', '02/09', '03/09', '04/09', '05/09', '06/09', '07/09', '09/09', '09/09', '09/09', '09/09', '09/09', '09/09'],
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
                    data: [10, 52, 200, 334, 390, 330, 320, 400, 200, 100, 320, 220, 500]
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
    <!-- weight -->
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
            legend: {
                itemWidth: 50,
                itemHeight: 12,
                itemStyle: {
                    color: '#d29763'
                },
                textStyle: {
                    color: '#000',
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
    <script>
        const formNews = document.getElementById('fomr_fill-news');
        formNews.addEventListener('submit', (e) => {
            const isConfirmed = confirm('Are you sure you want to submit this news?');
            if (!isConfirmed) {
                e.preventDefault();
            }
        });

        document.getElementById('date_growth-weight').addEventListener('submit', (e) => {
            e.preventDefault();
            const fromDate = new Date(document.getElementById('input_date_weight_from').value);
            const toDate = new Date(document.getElementById('input_date_weight_to').value);

            if (isNaN(fromDate.getTime()) || isNaN(toDate.getTime())) {
                alert('Please Choose From Date and To Date.');
                return;
            }
            if (fromDate > toDate) {
                alert('From Date can not larger than To Date');
                return;
            }
            const timeDifference = toDate.getTime() - fromDate.getTime();
            const dayDifference = timeDifference / (1000 * 3600 * 24);

            console.log(dayDifference)
            if (dayDifference < 1) {
                alert('The gap between From Date and To Date must be at least 1 day.');
            } else if (dayDifference > 12) {
                alert('The gap between From Date and To Date cannot be more than 12 days.');
            } else {
                e.target.submit();
            }
        });

        document.getElementById('date_growth-length').addEventListener('submit', (e) => {
            e.preventDefault();
            const fromDate = new Date(document.getElementById('input_date_length_from').value);
            const toDate = new Date(document.getElementById('input_date_length_to').value);

            if (isNaN(fromDate.getTime()) || isNaN(toDate.getTime())) {
                alert('Please Choose From Date and To Date.');
                return;
            }
            if (fromDate > toDate) {
                alert('From Date can not larger than To Date');
                return;
            }
            const timeDifference = toDate.getTime() - fromDate.getTime();
            const dayDifference = timeDifference / (1000 * 3600 * 24);

            console.log(dayDifference)
            if (dayDifference < 1) {
                alert('The gap between From Date and To Date must be at least 1 day.');
            } else if (dayDifference > 12) {
                alert('The gap between From Date and To Date cannot be more than 12 days.');
            } else {
                e.target.submit();
            }
        });
        const btnClose = document.querySelector(".btn-close-fish");
        const tableEdit = document.querySelector(".container__infor__fish");
        const btnAddNew = document.querySelector(".edit-btn-out");
        const subTable = document.querySelector(".infor__fish-detail");

        btnAddNew.addEventListener("click", function (e) {
            tableEdit.classList.toggle("open");
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

</html>