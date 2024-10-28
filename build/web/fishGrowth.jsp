<%-- 
    Document   : fishGrowth
    Created on : Oct 1, 2024, 8:52:03 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <div id="main-growth">
            <section class="growth_deatiail-main">
                <div class="container container-growth">
                    <div class="tilte-fish">
                        <h1>Fish Growth Chart</h1>
                        <div class="text-right">    
                            <a href="MainController?action=fishinfor&fid=${fishInfo.fishID}" class="back-btn" style="margin-right: 10px;">Back to Koi</a>
                            <button class="edit-btn-out">Add New Fish Growth</button>
                            <button class="update-btn-out" onclick="openModal()">Update</button>
                            <button class="delete-btn-out">Delete</button>
                        </div>
                    </div>
                    <div class="row mt-4 row-growth_fish">
                        <div class="col-md-9 item_grow_fish">
                            <div id="koiGrowthChart_length" style="width: 100%; height: 500px;"></div>
                        </div>
                        <div class="col-md-3 item_grow_fish-detail">
                            <h2>Search statistics </h2>
                            <form action="MainController?action=fishgrowthchartsearchlength" method="post" id="date_growth-length">
                                <input type="hidden" name="fishID" value="${fishInfo.fishID}"/>
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="input_date_length_from">From Date:</label>
                                    <input 
                                        id="input_date_length_from" 
                                        class="input_form-date lastweek_growth-input" 
                                        type="date" 
                                        name="fromDate" 
                                        value="${oldFromDateLength}" 
                                        required>
                                </div>
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="input_date_length_to">To Date:</label>
                                    <input 
                                        id="input_date_length_to" 
                                        class="input_form-date today_growth-input" 
                                        type="date" 
                                        name="toDate" 
                                        value="${oldToDateLength}" 
                                        required>
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
                            <form action="MainController?action=fishgrowthchartsearchweight" method="post" id="date_growth-weight">
                                <input type="hidden" name="fishID" value="${fishInfo.fishID}"/>
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="input_date_weight_from">From Date:</label>
                                    <input 
                                        id="input_date_weight_from" 
                                        class="input_form-date lastweek_growth-input" 
                                        type="date" 
                                        name="fromDate" 
                                        value="${oldFromDateWeight}" 
                                        required>
                                </div>
                                <div class="form-date-input-growth">
                                    <label class="lable_form-date" for="input_date_weight_to">To Date:</label>
                                    <input 
                                        id="input_date_weight_to" 
                                        class="input_form-date today_growth-input" 
                                        type="date" 
                                        name="toDate" 
                                        value="${oldToDateWeight}" 
                                        required>
                                </div>
                                <button class="btn-submit-search-date" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </div> 

        <!-- New Growth-->
        <div class="container__infor__fish">
            <div class="infor__fish-detail">
                <div class="row row-fish-detail">
                    <div class="col-4  " style="padding: 0">
                        <div class="img-edit-submit">
                            <div class="fish-img-info-edit">
                                <img src="${fishInfo.fishImage}" alt="${fishInfo.fishName}" />
                            </div>
                        </div>
                    </div>
                    <div class="col-8 edit-info">
                        <div class="text-right">
                            <button class="btn-close-fish">
                                <i class="fa-solid fa-xmark close-navbar-icon-btn-fish"></i>
                            </button>
                        </div>
                        <h2>New Growth</h2>
                        <form action="MainController?action=fishgrowthchartcreate" method="post" id="form_fill-news">
                            <div class="row row-edit-info-detail">
                                <input type="hidden" name="fishID" value="${fishInfo.fishID}" />
                                <div class="col-12 edit-item-detail">
                                    <span>Weight (Gram)</span>
                                    <input type="number" name="weight" value="" placeholder="Enter your fish weight in grams" required />
                                </div>
                                <div class="col-12 edit-item-detail">
                                    <span>Length (cm)</span>
                                    <input type="number" name="length" step="0.1" value="" placeholder="Enter length in cm" required />
                                </div>
                                <div class="col-12 edit-item-detail">
                                    <span>Date</span>
                                    <input type="date" name="date" required />
                                    <c:if test="${not empty dateExist}">
                                        <div class="alert alert-danger">
                                            <strong>${dateExist}</strong>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="text-center">
                                <button class="edit-btn blue-btn" type="submit" style="margin-top: 10px">
                                    Confirm
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Update -->
        <div class="modal" id="modalDelete">
            <div class="modal-content">
                <span class="close" onclick="closeModal('modalDelete')">&times;</span>
                <form action="MainController?action=fishgrowthchartdelete" method="post" id="form_delete-growth">
                    <input type="hidden" name="fishID" value="${fishInfo.fishID}" />
                    <div class="edit-item-detail">
                        <span>Select Update Date</span>
                        <select id="deleteUpdateDateSelect" name="updateDate">
                            <option value="">-- Select Update Date --</option>
                            <c:forEach var="dev" items="${fishdevelop}">
                                <option value="${dev.updateDate}">${dev.updateDate}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="text-center">
                        <button class="edit-btn red-btn" type="submit" style="margin-top: 10px">
                            Delete
                        </button>
                        <button class="edit-btn cancel-btn" type="button" style="margin-top: 10px" onclick="closeModal('modalDelete')">
                            Cancel
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <!--            Delete-->
        <form action="MainController?action=fishgrowthchartdelete" method="post" id="form_delete-growth">
            <input type="hidden" name="fishID" value="${fishInfo.fishID}" />
            <div class="edit-item-detail">
                <span>Select Update Date</span>
                <select id="deleteUpdateDateSelect">
                    <option value="">-- Select Update Date --</option>
                    <c:forEach var="dev" items="${fishdevelop}">
                        <option value="${dev.updateDate}">${dev.updateDate}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="text-center">
                <button class="edit-btn red-btn" type="submit" style="margin-top: 10px">
                    Delete
                </button>
            </div>
        </form>

        <script src="./assets/js/footer.js"></script>
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
        const btnAddNew = document.querySelector(".edit-btn-out");
        const subTable = document.querySelector(".infor__fish-detail");

        btnAddNew.addEventListener("click", function (e) {
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
        var lengthData = [];
        var dateLabels = [];

        <c:choose>
            <c:when test="${not empty fishDevelopmentsLength}">
                <c:forEach var="development" items="${fishDevelopmentsLength}">
        lengthData.push(parseFloat(${development.updateLength}));
        dateLabels.push('${development.updateDate}');
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach var="development" items="${fishdevelop}">
        lengthData.push(parseFloat(${development.updateLength}));
        dateLabels.push('${development.updateDate}');
                </c:forEach>
            </c:otherwise>
        </c:choose>

        var option = {
            title: {
                text: 'Length of Fish'
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
                    fontSize: 16,
                    fontWeight: 'bold'
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
                    data: dateLabels,
                    axisTick: {
                        alignWithLabel: true
                    },
                    axisLabel: {
                        rotate: 45,
                        fontSize: 12,
                        fontWeight: 'bold',
                        margin: 20
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
                    data: lengthData
                }
            ]
        };

        chart.setOption(option);
    </script>
    <!-- weight -->
    <script>
        var chartWeight = echarts.init(document.getElementById('koiGrowthChart_weight'));

        var weightData = [];
        var weightDateLabels = [];

        <c:choose>
            <c:when test="${not empty fishDevelopmentsWeight}">
                <c:forEach var="development" items="${fishDevelopmentsWeight}">
        weightData.push(parseFloat(${development.updateWeight}));
        weightDateLabels.push('${development.updateDate}');
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach var="develop" items="${fishdevelop}">
        weightData.push(parseFloat(${develop.updateWeight}));
        weightDateLabels.push('${develop.updateDate}');
                </c:forEach>
            </c:otherwise>
        </c:choose>

        var option = {
            title: {
                text: 'Weight of Fish',
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
                    color: '#000',
                    fontSize: 16,
                    fontWeight: 'bold'
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
                    data: weightDateLabels,
                    axisTick: {
                        alignWithLabel: true
                    },
                    axisLabel: {
                        rotate: 45,
                        fontSize: 12,
                        fontWeight: 'bold',
                        margin: 20
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
                    data: weightData,
                    itemStyle: {
                        color: '#d29763'
                    }
                }
            ]
        };

        chartWeight.setOption(option);
    </script>
    <script>
        const formNews = document.getElementById('form_fill-news'); // Corrected ID

        if (formNews) { // Check if formNews is not null
            formNews.addEventListener('submit', (e) => {
                const isConfirmed = confirm('Are you sure you want to submit this news?');
                if (!isConfirmed) {
                    e.preventDefault(); // Prevent form submission if the user cancels
                }
            });
        } else {
            console.error("Form with ID 'form_fill-news' not found.");
        }

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
            } else if (dayDifference > 11) {
                alert('The gap between From Date and To Date cannot be more than 11 days.');
            } else {
                e.target.submit();
            }
        });

        document.addEventListener("DOMContentLoaded", function () {
            if ("${oldFromDateWeight}" && "${oldToDateWeight}") {
                const chartSection = document.getElementById("koiGrowthChart_weight");
                chartSection?.scrollIntoView({behavior: "smooth"}
                );
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
            } else if (dayDifference > 11) {
                alert('The gap between From Date and To Date cannot be more than 11 days.');
            } else {
                e.target.submit();
            }
        });
    </script>
    <script>
        function openModal() {
            document.getElementById('modal').style.display = 'block';
        }

        function closeModal() {
            document.getElementById('modal').style.display = 'none';
        }

        window.onclick = function (event) {
            const modal = document.getElementById('modal');
            if (event.target === modal) {
                closeModal();
            }
        }
    </script>