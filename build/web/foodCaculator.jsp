<%-- 
    Document   : foodCaculator
    Created on : Oct 29, 2024, 11:45:17 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food Caculator</title>
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

        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/caculation.css">
    </head>

    <body class="body-cacaulation">
        <!-- start header -->
        <div id="header"></div>

        <div class="container main_caculation-food">
            <div class="tilte-caculation">
                <h1>Food Caculator</h1>
            </div>
            <div class="container_caculation mt-4">
                <div class="row mb-5">
                    <div class="col-lg-6">
                        <div class="body_caculator_detail">
                            <form action="">
                                <div class="select_option-fish text-center mb-4">
                                    <h3>Choose fish</h3>
                                    <select name="" id="">
                                        <c:forEach items="${listFish}" var="fitem">                                       
                                            <option value="${fitem.weight}">${fitem.fishName}</option> 
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="check-box-level mb-4">
                                    <div class="selection-group-radio d-flex flex-column align-items-center">
                                        <h3 class="mb-3">Desired Growth</h3>
                                        <div class="row_radio-btn d-flex justify-content-between ">
                                            <c:set var="count" value="0" />
                                            <c:forEach items="${listGrowthMode}" var="grMode"  > 
                                                <c:set var="count" value="${count+1}"/>
                                                <label for="${grMode}-btn">
                                                    <input id="${grMode}-btn"  type="radio" name="growth" value="${grMode}" ${count == 1 ? 'checked' : ''} hidden>
                                                    <div class="radio-item p-3">
                                                        <h2 class="text-center font-weight-bold">${grMode}</h2>
                                                        <p class=" d-flex justify-content-center">
                                                            <c:forEach var="i" begin="0" end="${count-1}" > 
                                                                <i class="fa fa-circle"></i>
                                                            </c:forEach>
                                                        </p>
                                                    </div>
                                                </label> 
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="check-box-level mb-4">
                                    <div class="selection-group-radio d-flex flex-column align-items-center">
                                        <h3 class="mb-3">Water Temperature</h3>
                                        <div class="row_radio-btn d-flex justify-content-between ">
                                            <c:set var="countTemp" value="0"/>
                                            <c:forEach items="${temperatureList}" var="temp" begin="0" end="0"> 
                                                <label for="${temp.temperatureMax}-btn">
                                                    <input id="${temp.temperatureMax}-btn" type="radio" name="temperature" value="9" checked hidden>
                                                    <div class="radio-item p-3">
                                                        <h2 class="text-center font-weight-bold"><i class="fa-solid fa-less-than-equal"></i>${temp.temperatureMax}°</h2>
                                                        <p class=" d-flex justify-content-center">
                                                            <i class="fa fa-circle"></i>
                                                        </p>
                                                    </div>
                                                </label>
                                            </c:forEach>
                                            <c:forEach items="${temperatureList}" var="temp" begin="1" end="${size-2}"> 
                                                <label for="${temp.temperatureMax}-btn">
                                                    <input id="${temp.temperatureMax}-btn" type="radio" name="temperature" value="9" hidden>
                                                    <div class="radio-item p-3">
                                                        <h2 class="text-center font-weight-bold">${temp.temperatureMin}°-${temp.temperatureMax}°</h2>
                                                        <p class=" d-flex justify-content-center">
                                                            <i class="fa fa-circle"></i>
                                                            <i class="fa fa-circle"></i> 
                                                        </p>
                                                    </div>
                                                </label>
                                            </c:forEach>
                                            <c:forEach items="${temperatureList}" var="temp" begin="${size-1}" end="${size-1}"> 
                                                <label for="${temp.temperatureMax}-btn">
                                                    <input id="${temp.temperatureMax}-btn" type="radio" name="temperature" value="9" hidden>
                                                    <div class="radio-item p-3">
                                                        <h2 class="text-center font-weight-bold">${temp.temperatureMin}°<i class="fa-solid fa-less-than-equal"></i></h2>
                                                        <p class=" d-flex justify-content-center">
                                                            <i class="fa fa-circle"></i>
                                                            <i class="fa fa-circle"></i>
                                                            <i class="fa fa-circle"></i>

                                                        </p>
                                                    </div>
                                                </label>
                                            </c:forEach>

                                        </div>
                                    </div>
                                </div>
                                <div class="contain-btn-confirm text-center">
                                    <button type="submit">Confirm</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="body-desc-infor-caculator">
                            <h2>Feeding information</h2>
                            <p>The recommended amount of food should be split evenly into <span class="font-weight-bold">4-8
                                    feedings per day.</span> This way the koi will ingest the food better.</p>
                            <h4 class="warm_infor-temp font-weight-bold">Feeding is not recommended at a temperature above
                                28°C!</h4>
                            <p>Please note that the displayed amount of food and the number of feedings are approximations.
                                Therefore, only feed as much as your koi can actually ingest. In general, it is recommended
                                to split the total amount of food into as many feedings as possible. The growth mode "low"
                                is suitable for ponds with fish over 6 years of age. The mode "medium" is suitable for fish
                                over 4 years and "high" for fish up to 4 years of age</p>
                        </div>
                    </div>
                </div>
                <div class="row row-recommened align-items-center justify-content-between">
                    <div class="item-recommened">
                        <h2 class="m-0" >Recommended amount</h2>
                    </div>
                    <div class="item-recommened d-flex flex-column">
                        <h1 class="m-0 font-weight-bold">121g</h1>
                        <p class="m-0">per day</p>
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
    </body>

</html>