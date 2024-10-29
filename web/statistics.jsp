<%-- 
    Document   : statistics
    Created on : Oct 29, 2024, 11:44:11 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h2>pH & kH & gH</h2>
                    <div id="chart-ph" style="width: 100%; height: 380px;"></div>
                </div>
                <div class="col-md-6 mb-5 ">
                    <h2>Temperature & OutdoorTemp</h2>
                    <div id="chart_mgl" style="width: 100%; height: 380px;"></div>
                </div>
            </div>
        </div>
    </div> 
    <!-- footer -->
    <div id="footer"></div>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js')
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
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
                data: ['salt']
            },
            xAxis: {
                type: 'category',
                data: ['20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26'],
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
                {
                    name: 'salt',
                    type: 'line',
                    data: [120, 132, 101, 134, 90, 230, 210]
                }
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
                data: ['Temperature', 'Outdoor temp']
            },
            xAxis: {
                type: 'category',
                data: ['20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26'],
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
                {
                    name: 'Temperature',
                    type: 'line',
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: 'Outdoor temp',
                    type: 'line',
                    data: [220, 182, 191, 234, 290, 330, 310]
                }
            ]
        };
        charttemp.setOption(option);


    </script>
    <!-- ph -->
    <script>
        var myChartph = echarts.init(document.getElementById('chart-ph'));

        var option1 = {
            title: {

            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['pH', 'kH', 'gH']
            },
            xAxis: {
                type: 'category',
                data: ['20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26'],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: 'pH',
                    type: 'line',
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: 'kH',
                    type: 'line',
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: 'gH',
                    type: 'line',
                    data: [150, 232, 201, 154, 190, 330, 410]
                }
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
                data: ['NH4', 'NO2', 'PO4', 'NO3', 'O2', 'Ammount fed', 'Co2']
            },
            xAxis: {
                type: 'category',
                data: ['20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26', '20/10/2024 13:26'],
                axisLabel: {
                    rotate: 30,
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: 'NH4',
                    type: 'line',
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: 'NO2',
                    type: 'line',
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: 'PO4',
                    type: 'line',
                    data: [150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name: 'NO3',
                    type: 'line',
                    data: [320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name: 'O2',
                    type: 'line',
                    data: [820, 932, 901, 934, 1290, 1330, 1320]
                },
                {
                    name: 'Ammount fed',
                    type: 'line',
                    data: [620, 732, 701, 734, 1090, 1130, 1120]
                },
                {
                    name: 'Co2',
                    type: 'line',
                    data: [720, 832, 801, 834, 1190, 1230, 1220]
                }
            ]
        };

        myChart.setOption(option1);

    </script>
</body>

</html>