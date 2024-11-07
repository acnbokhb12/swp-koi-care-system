<%-- 
    Document   : saltCalculator
    Created on : Nov 6, 2024, 12:53:51 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    <link rel="stylesheet" href="./assets/css/caculation.css">
</head>
<body class="body-cacaulation">
    <!-- start header -->
    <div id="header"></div>
    <div class="container main_caculation-food">
        <div class="tilte-caculation">
            <h1>Salt Caculator</h1>
        </div>
        <div class="container_caculation mt-4">
             <div class="row mb-5">
                <div class="col-lg-6">
                    <div class="body_caculator_detail">
                        <form action="SaltCalculatorDetailController" method="post" id="saltForm">
                            <div class="select_option-pond text-center  d-flex align-items-center flex-column">
                                <div class="select_option-pond-detail mb-4 ">
                                    <h3>Choose Pond</h3>
                                    <select name="pondInFor" id="volumePond" class="mb-3" onchange="showVolumePond()">
                                        <c:forEach items="${listPond}" var="pItem"> 
                                            <option value="${pItem.pondID}-${pItem.volume}" ${pondId!=null && pondId==pItem.pondID ? 'selected' : '' } >${pItem.name}</option> 
                                        </c:forEach>
                                    </select> 
                                    <div class="slider-container mb-3">
                                        <div class="desc-pond-detail">
                                            <div class="d-flex justify-content-between">
                                                <h2>Pond Volume:</h2>
                                                <div class="d-flex">
                                                    <h2 class="font-weight-bold show_volume">
                                                        0
                                                    </h2>
                                                    <h2 class="ml-2">
                                                        l
                                                    </h2>
                                                </div>

                                            </div>
                                            <div class="">
                                                <label for="currentConcentration" class="d-flex justify-content-between">
                                                    <h2>Current Concentration:</h2> <h2 id="currentConcentrationValue" class="font-weight-bold">${currentConcentration != null ? currentConcentration : 0}  %</h2>
                                                </label>
                                            </div>
                                        </div>
                                        <div class="slider-container d-flex align-items-center justify-content-between">
                                            <h4 class="m-0">0%</h4> <input type="range" name="currentConcentration" id="currentConcentration" min="0" max="0.75" step="0.05" value="${currentConcentration != null ? currentConcentration : 0}"> <h4 class="m-0">0.75%</h4>
                                             
                                        </div>    
                                    </div> 
                                </div>
                                <div class="select_option-pond-detail mb-4  ">  
                                    <div class="slider-container mb-3">
                                        <div class="desc-pond-detail"> 
                                            <div class="">
                                                <label for="desiredConcentration" class="d-flex justify-content-between m-0">
                                                    <h2>Desired Concentration:</h2> <h2 class="font-weight-bold" id="desiredConcentrationValue">${desiredConcentration != null ? desiredConcentration : 0}%</h2>
                                                 </label>
                                            </div>
                                        </div>
                                        <div class="slider-container d-flex align-items-center justify-content-between">
                                            <h4 class="m-0">0%</h4> <input type="range" name="desiredConcentration" id="desiredConcentration" min="0" max="0.75" step="0.05" value="${desiredConcentration != null ? desiredConcentration : 0}"> <h4 class="m-0">0.75%</h4>
                                             
                                        </div>    
                                    </div>
                                     
                                </div>
                                <div class="select_option-pond-detail  ">  
                                    <div class="slider-container mb-3">
                                        <div class="desc-pond-detail"> 
                                            <div class="">
                                                <label for="waterChange" class="d-flex justify-content-between m-0">
                                                    <h2>Water Change:</h2>
                                                    <h2 id="waterChangeValue">${waterChange != null ? waterChange : 0}%</h2></h2>
                                                 </label>
                                            </div>
                                        </div>
                                        <div class="slider-container d-flex align-items-center justify-content-between">
                                            <h4 class="m-0">0%</h4>
                                            <input type="range" name="waterChange" id="waterChange" min="0" max="100" step="5" value="${waterChange != null ? waterChange : 0}">
                                            <h4 class="m-0">100%</h4>
                                             
                                        </div>    
                                    </div>
                                     
                                </div>
                                
                                <div class="contain-btn-confirm text-center mt-4">
                                    <button type="submit">Start calculate</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6 d-flex">
                    <div class="body-desc-infor-caculator m-auto">
                        <h2 class="font-weight-bold">Disclaimer</h2> 
                        <p>Only add pure salt without iodine to the water! Too high of a salt concentration can be damaging to the koi. If you are unsure, please talk to a veterinarian. For fighting diseases and algae or for taking precautions a concentration of 0.5% is recommended.</p>
                        
                        <p class="pl-2 pr-2 pt-2 pb-2 m-0 text-white font-weight-bold d-inline-block" style="font-size: 1.4rem; background-color: #ff0b0b; border-radius: 8px;">Current concentration can not be greater than desired concentration</p>
                    </div>
                </div>
             </div>
             <div class="row row-recommened flex-column">
                <div class="item-recommened d-flex justify-content-between pt-2 pb-2">
                    <h3 class="m-0 text-light" >Amount of Salt</h3>
                    <h3 class="m-0 text-light" >
                         <c:if test="${amountOfSalt!=null}">  
                            <fmt:formatNumber value=" ${amountOfSalt}" pattern="0.0" var="formatAmountOfSalt" />
                        </c:if>
                        ${formatAmountOfSalt!=null ? formatAmountOfSalt : '0'} kg
                    </h3>
                </div>
                <div class="item-recommened d-flex justify-content-between pt-2 pb-2">
                    <h3 class="m-0 text-light" >Per water change (refill)</h3>
                    <h3 class="m-0 text-light" >
                        <c:if test="${perWaterChange!=null}">  
                            <fmt:formatNumber value=" ${perWaterChange}" pattern="0.0" var="formatWaterChange" />
                        </c:if>
                        ${formatWaterChange!=null ? formatWaterChange : '0'} kg</h3>
                </div> 
                
            </div>
        </div>   
    </div>    
     
    <style>
       
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
    </script>
    <script>
        // Function to update the displayed value for each slider
        function updateSliderValue(sliderId, displayId, unit) {
            const slider = document.getElementById(sliderId);
            const display = document.getElementById(displayId);
            slider.addEventListener("input", function() {
                display.textContent = slider.value + unit;
            });
        }
        
    
        // Initialize sliders with display update
        updateSliderValue("currentConcentration", "currentConcentrationValue", "%");
        updateSliderValue("desiredConcentration", "desiredConcentrationValue", "%");
        updateSliderValue("waterChange", "waterChangeValue", "%"); 
        
        const volumeWithIdReal = document.getElementById('volumePond').value;
        const arrayVolumeReal = volumeWithIdReal.split("-");
        let volumeReal = parseFloat(arrayVolumeReal[1]);
        const showVolume = document.querySelector('.show_volume');
        showVolume.innerText = volumeReal;
        
        function showVolumePond(){
            const volumeWithId = document.getElementById('volumePond').value;
            const arrayVolume = volumeWithId.split("-");
            let volume = parseFloat(arrayVolume[1]);
            const showVolume = document.querySelector('.show_volume');

            showVolume.innerText = volume;
        }
         
       document.getElementById('saltForm').addEventListener('submit',(e)=>{
            const currentSalt = parseFloat(document.getElementById('currentConcentration').value);
            const desiredSalt = parseFloat(document.getElementById('desiredConcentration').value);
            if(currentSalt > desiredSalt){
                alert('Current concentration should not be greater than desired concentration');
                e.preventDefault();
                
            }
        });
    </script>
</body>
</html>