<%-- 
    Document   : statistics
    Created on : Oct 29, 2024, 11:44:11 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Statistic</title>
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
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- echart js -->
    <script src="https://cdn.jsdelivr.net/npm/echarts/dist/echarts.min.js"></script>

    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/waterParameterSalt.css">
</head>

<body class="body-water">
    <!-- start header -->
    <div id="header"></div>
    <div class="container main_statistics">
        <div class="tilte-water">
            <h1>Statistics</h1>
            <div class="contain-form-choose-pond">
                <form action="StatisticsSearchPondByIdController" method="post">
                    <select class="contain-select-choose-pond" name="pondId">
                        <c:forEach items="${listMyPond}" var="pond"> 
                            <option value="${pond.pondID}" ${tagPondId != null && tagPondId == pond.pondID ? 'selected' : ''}>${pond.name}</option>  
                        </c:forEach>
                    </select>
                    <button class="btn-confirm_pond">Confirm</button>
                </form>
            </div>
        </div>
        
        <div class="container_statistics-water">
            <div class="row">
                <div class="col-md-6 mb-5 ">
                    <h2>Salt</h2>
                    <div id="chart-salt" style="width: 100%; height: 380px;"></div>
                </div>
                <div class="col-md-6 mb-5 ">
                    <h2>Temperature & OutdoorTemp</h2>
                    <div id="chart-temperature" style="width: 100%; height: 380px;"></div>
                </div>
                <div class="col-md-6 mb-5 ">
                    <h2> kH & gH</h2>
                    <div id="chart-dh" style="width: 100%; height: 380px;"></div>
                </div>
                <div class="col-md-6 mb-5 ">
                    <h2>Temperature & OutdoorTemp</h2>
                    <div id="chart_mgl" style="width: 100%; height: 380px;"></div>
                </div>
                <div class="col-md-6 mb-5 ">
                    <h2>pH</h2>
                    <div id="chart_pH" style="width: 100%; height: 380px;"></div>
                </div>
                <div class="col-md-6 mb-5 ">
                    <h2>Amount fed</h2>
                    <div id="chart_Amount_fed" style="width: 100%; height: 380px;"></div>
                </div>
            </div>
        </div>
    </div> 
                <div id="modal-logout-confirm"></div> 
                <style>
                    .btn-confirm_pond,
                    .contain-select-choose-pond{
                        font-size: 1.6rem;
                        padding: 0.4rem 1.2rem;
                        font-weight: 500;
                    }
                    .btn-confirm_pond{
                        border: none; 
                        background-color: var(--bs-orange);
                    }
                </style>
    <!-- footer -->
    <div id="footer"></div>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js')
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js')
        });
        $('#modal-logout-confirm').load('utils.jsp #modal-logout-confirm_nav', () => {
               $.getScript('./assets/js/utilsCustomer.js')
        });
    </script>
    <!-- Salt -->
    <script>
        var chart = echarts.init(document.getElementById('chart-salt'));
        var option = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: [
                     <c:forEach items="${listStatisticsWithUnitPercent}" var="percent" varStatus="status">         
                    '${percent.name}'
                        <c:if test="${!status.last}">,</c:if>
                    </c:forEach>
                ]
            },
            xAxis: {
                type: 'category',
                data: [
                    <c:forEach items="${listDateStatistics}" var="dateStatistics" varStatus="status">
                            <c:set var="orderDate" value="${dateStatistics.measurementDate}" />
                           <c:set var="formattedDate" value="${fn:substring(orderDate, 0, 10)}" />
                           <c:set var="formattedTime" value="${fn:substring(orderDate, 11, 19)}" />
                            '${formattedDate} ${formattedTime}' <c:if test="${!status.last}">,</c:if>
                        </c:forEach>
                ],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold',


                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} %'
                }
            },
            series: [
                <c:forEach items="${listStatisticsWithUnitPercent}" var="percent" varStatus="status">
        {
            name: '${percent.name}',
            type: 'line',
            data: [
               <c:forEach items="${percent.listWaterParameterDetail}" var="valuepercent" varStatus="status">
                        ${valuepercent.value} <c:if test="${!status.last}">,</c:if>
                    </c:forEach>   
            ]
        }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
            ]
        };
        chart.setOption(option);

    </script>
    <!-- Temperature -->
    <script>
        var charttemp = echarts.init(document.getElementById('chart-temperature'));
        var option = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: [
                    <c:forEach items="${listStatisticsWithUnitTemp}" var="temperature" varStatus="status">         
                    '${temperature.name}'
                        <c:if test="${!status.last}">,</c:if>
                    </c:forEach>
                ]
            },
            xAxis: {
                type: 'category',
                data: [
                    <c:forEach items="${listDateStatistics}" var="dateStatistics" varStatus="status">
                            <c:set var="orderDate" value="${dateStatistics.measurementDate}" />
                           <c:set var="formattedDate" value="${fn:substring(orderDate, 0, 10)}" />
                           <c:set var="formattedTime" value="${fn:substring(orderDate, 11, 19)}" />
                            '${formattedDate} ${formattedTime}' <c:if test="${!status.last}">,</c:if>
                        </c:forEach>
                ],
                axisLabel: {
                    rotate: 30, // Xoay nhãn trục x 45 độ
                    fontSize: 10, // Tùy chỉnh kích thước chữ nếu cần
                    fontWeight: 'bold', // Làm đậm chữ nếu muốn

                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} °C'
                }
            },
            series: [
                 <c:forEach items="${listStatisticsWithUnitTemp}" var="temperature" varStatus="status">
        {
            name: '${temperature.name}',
            type: 'line',
            data: [
               <c:forEach items="${temperature.listWaterParameterDetail}" var="valueTemp" varStatus="status">
                        ${valueTemp.value} <c:if test="${!status.last}">,</c:if>
                    </c:forEach>   
            ]
        }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
            ]
        };
        charttemp.setOption(option);


    </script>
    <!-- chart-dh -->
    <script>
        var myChartph = echarts.init(document.getElementById('chart-dh'));

        var option1 = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: [
                    <c:forEach items="${listStatisticsWithUnitDH}" var="dh" varStatus="status"> 
                    '${dh.name}'
                    <c:if test="${!status.last}">,</c:if>
            </c:forEach>
                ]
            },
            xAxis: {
                type: 'category',
                data: [
                      <c:forEach items="${listDateStatistics}" var="dateStatistics" varStatus="status">
                            <c:set var="orderDate" value="${dateStatistics.measurementDate}" />
                           <c:set var="formattedDate" value="${fn:substring(orderDate, 0, 10)}" />
                           <c:set var="formattedTime" value="${fn:substring(orderDate, 11, 19)}" />
                            '${formattedDate} ${formattedTime}' <c:if test="${!status.last}">,</c:if>
                        </c:forEach>
                ],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} °dH'
                }
            },
            series: [
                <c:forEach items="${listStatisticsWithUnitDH}" var="dh" varStatus="status">
        {
            name: '${dh.name}',
            type: 'line',
            data: [
               <c:forEach items="${dh.listWaterParameterDetail}" var="valuedh" varStatus="status">
                        ${valuedh.value} <c:if test="${!status.last}">,</c:if>
                    </c:forEach>   
            ]
        }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
            ]
        };

        myChartph.setOption(option1);
    </script>
    <!-- mg/l -->
    <script>
        var myChart = echarts.init(document.getElementById('chart_mgl'));

        var option1 = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: [
            <c:forEach items="${listStatisticsWithUnitMgl}" var="mgl" varStatus="status">
                            
                    '${mgl.name}'
                    <c:if test="${!status.last}">,</c:if>
            </c:forEach>
                ]
            },
            xAxis: {
                type: 'category',
                data: [
                        <c:forEach items="${listDateStatistics}" var="dateStatistics" varStatus="status">
                            <c:set var="orderDate" value="${dateStatistics.measurementDate}" />
                           <c:set var="formattedDate" value="${fn:substring(orderDate, 0, 10)}" />
                           <c:set var="formattedTime" value="${fn:substring(orderDate, 11, 19)}" />
                            '${formattedDate} ${formattedTime}' <c:if test="${!status.last}">,</c:if>
                        </c:forEach>
                   
              ],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} mg/l'
                }
            },
            series: [
              <c:forEach items="${listStatisticsWithUnitMgl}" var="mgl" varStatus="status">
        {
            name: '${mgl.name}',
            type: 'line',
            data: [
               <c:forEach items="${mgl.listWaterParameterDetail}" var="mgl" varStatus="status">
                        ${mgl.value} <c:if test="${!status.last}">,</c:if>
                    </c:forEach>   
            ]
        }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
            ]
        };

        myChart.setOption(option1);

    </script>
    
     <script>
        var myChart = echarts.init(document.getElementById('chart_pH'));

        var option1 = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: [
            <c:forEach items="${listStatisticsWithUnitEmpty}" var="mgl" varStatus="status">
                            
                    '${mgl.name}'
                    <c:if test="${!status.last}">,</c:if>
            </c:forEach>
                ]
            },
            xAxis: {
                type: 'category',
                data: [
                        <c:forEach items="${listDateStatistics}" var="dateStatistics" varStatus="status">
                            <c:set var="orderDate" value="${dateStatistics.measurementDate}" />
                           <c:set var="formattedDate" value="${fn:substring(orderDate, 0, 10)}" />
                           <c:set var="formattedTime" value="${fn:substring(orderDate, 11, 19)}" />
                            '${formattedDate} ${formattedTime}' <c:if test="${!status.last}">,</c:if>
                        </c:forEach>
                   
              ],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} mg/l'
                }
            },
            series: [
              <c:forEach items="${listStatisticsWithUnitEmpty}" var="mgl" varStatus="status">
        {
            name: '${mgl.name}',
            type: 'line',
            data: [
               <c:forEach items="${mgl.listWaterParameterDetail}" var="mgl" varStatus="status">
                        ${mgl.value} <c:if test="${!status.last}">,</c:if>
                    </c:forEach>   
            ]
        }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
            ]
        };

        myChart.setOption(option1);

    </script>
    <script>
        var myChart = echarts.init(document.getElementById('chart_Amount_fed'));

        var option1 = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: [
            <c:forEach items="${listStatisticsWithUnitGram}" var="mgl" varStatus="status">
                            
                    '${mgl.name}'
                    <c:if test="${!status.last}">,</c:if>
            </c:forEach>
                ]
            },
            xAxis: {
                type: 'category',
                data: [
                        <c:forEach items="${listDateStatistics}" var="dateStatistics" varStatus="status">
                            <c:set var="orderDate" value="${dateStatistics.measurementDate}" />
                           <c:set var="formattedDate" value="${fn:substring(orderDate, 0, 10)}" />
                           <c:set var="formattedTime" value="${fn:substring(orderDate, 11, 19)}" />
                            '${formattedDate} ${formattedTime}' <c:if test="${!status.last}">,</c:if>
                        </c:forEach>
                   
              ],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    formatter: '{value} g'
                }
            },
            series: [
              <c:forEach items="${listStatisticsWithUnitGram}" var="mgl" varStatus="status">
        {
            name: '${mgl.name}',
            type: 'line',
            data: [
               <c:forEach items="${mgl.listWaterParameterDetail}" var="mgl" varStatus="status">
                        ${mgl.value} <c:if test="${!status.last}">,</c:if>
                    </c:forEach>   
            ]
        }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
            ]
        };

        myChart.setOption(option1);

    </script>
</body>

</html>