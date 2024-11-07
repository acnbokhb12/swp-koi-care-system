<%-- 
    Document   : waterParameter
    Created on : Oct 26, 2024, 12:42:41 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
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
        <link rel="stylesheet" href="./assets/css/waterParameterSalt.css">
    </head>

    <body class="body-water">
        <!-- start header -->
        <div id="header"></div>
        <!-- end header -->
        <!-- Content -->
        <div class="container container__waterparameter">
            <div class="tilte-water">
                <h1>Water Parameter</h1>
                <div class="button-container">
                    <button class="btn btn_add-infor-parameter"><i class="fa-solid fa-plus"></i></button>
                </div>
            </div>

            <div class="water__parameter-list row mt-4" id="water-parameter-list">
                <!-- Loop over each water parameter in waterParameters -->
                <c:forEach items="${waterParameters}" var="waterParameter">
                    <div class="waterParameter_item_stand col_custom col-md-6">
                        <input type="hidden" class="selected-water-parameter-id" value="${waterParameter.waterParameterId}" />
                        <div class="water-parameter-item">
                            <div class="water-item-detail">
                                <div class="item__component d-flex justify-content-between">
                                    <div class="item_s align-items-center">
                                        <div class="item_title namepond">
                                            ${waterParameter.pond.name}
                                        </div>
                                    </div>
                                    <div class="item_s">
                                        <div class="item_title">
                                            ${waterParameter.measurementDate}
                                        </div>
                                    </div>
                                </div>
                                <div class="row m-0">
                                    <!-- Loop over each waterParameterDetail in waterParameter -->
                                    <c:forEach items="${waterParameter.waterParameterDetails}" var="detail">
                                        <div class="item_s col-6 p-0">
                                            <div class="item_name-value pr-2">
                                                ${detail.waterDesc.name}:
                                            </div>
                                            <div class="item_value">
                                                <span class="value_water-parameter" data-param="${detail.waterDesc.symbol}">
                                                    <c:choose>
                                                        <c:when test="${detail.value != 0.0}">
                                                            ${detail.value}
                                                        </c:when>
                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <span class="unit_value">
                                                    <c:choose>
                                                        <c:when test="${detail.value != 0.0}">
                                                            ${detail.waterDesc.unit}
                                                        </c:when>
                                                    </c:choose>
                                                </span>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="item_note-desc">
                                    <c:choose>
                                        <c:when test="${waterParameter.note != null}">
                                            <p>${waterParameter.note}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p></p> 
                                        </c:otherwise>
                                    </c:choose>        
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- Modal Add more -->
            <div class="container__infor__water-parameter">
                <div class="infor__water-parameter-detail">
                    <form id="waterParameterForm" action="MainController?action=waterparametercreatenew" method="POST">
                        <div class="place_btn-r-a">
                            <button type="button" class="btn btn-item-handle btn-close-modal"><i class="fas fa-times"></i></button>
                            <button type="submit" class="btn btn-item-handle btn-accept-form"><i class="fa-solid fa-check"></i></button>
                        </div>
                        <div class="water-parameter-from">
                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label class="color-value" for="pond-select">Pond:</label>
                                    <select name="pond" id="pond-select" required>
                                        <c:forEach var="pond" items="${listPond}">
                                            <option value="${pond.pondID}">${pond.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="item_input-detail">
                                    <label class="color-value" for="datetime">Date & Time:</label>
                                    <input type="datetime-local" id="datetime" name="datetime" required>
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="NO2">Nitrite (NO<sub>2</sub>):</label>
                                    <input class="input_value-parameter" name="NO2" type="number" step="0.1" min="0">
                                </div>
                                <div class="item_input-detail">
                                    <label for="O2">Oxygen (O<sub>2</sub>):</label>
                                    <input class="input_value-parameter" name="O2" type="number" step="0.1" min="0">
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="NO3">Nitrate (NO<sub>3</sub>):</label>
                                    <input class="input_value-parameter" name="NO3" type="number" step="0.1" min="0">
                                </div>
                                <div class="item_input-detail">
                                    <label for="temperature">Temperature:</label>
                                    <input class="input_value-parameter" name="temperature" type="number" step="0.1" min="0">
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="PO4">Phosphate (PO<sub>4</sub>):</label>
                                    <input class="input_value-parameter" name="PO4" type="number" step="0.1" min="0">
                                </div>
                                <div class="item_input-detail">
                                    <label for="pH">pH-Value:</label>
                                    <input class="input_value-parameter" name="pH" type="number" step="0.1" min="0">
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="NH4">Ammonium (NH<sub>4</sub>):</label>
                                    <input class="input_value-parameter" name="NH4" type="number" min="0">
                                </div>
                                <div class="item_input-detail">
                                    <label for="KH">Carbon. hardness (KH):</label>
                                    <input class="input_value-parameter" name="KH" type="number" step="0.1" min="0">
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="GH">Hardness (GH):</label>
                                    <input class="input_value-parameter" name="GH" type="number" step="0.1" min="0">
                                </div>
                                <div class="item_input-detail">
                                    <label for="CO2">CO<sub>2</sub>:</label>
                                    <input class="input_value-parameter" name="CO2" type="number" min="0">
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="salt">Salt:</label>
                                    <input class="input_value-parameter" name="salt" type="number" min="0">
                                </div>
                                <div class="item_input-detail">
                                    <label for="fedAmount">Amount fed:</label>
                                    <input class="input_value-parameter" name="fedAmount" type="number" min="0">
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="outdoorTemp">Outdoor Temp:</label>
                                    <input class="input_value-parameter" name="outdoorTemp" type="number">
                                </div>
                            </div>
                            <div class="input-note_desc">
                                <label for="note">Note:</label>
                                <textarea name="note" id="note"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!-- Modal Update and Delete more -->
            <!--hash map co name co symbol value la nguyen doi ttuong description key cua hash map la cai nao the . text dua len khung-->


            <!-- Modal Inf -->
            <div class="container__infor__description">
                <div class="infor__description-detail">
                    <div class="infor__description-water-parameter">
                        <div class="infor__description-title mb-3">
                            <h2>Information</h2>
                        </div>
                        <c:forEach items="${waterDescription}" var="desc">
                            <div class="infor__description-range mb-3">
                                <h3>Optimal range:</h3>
                                <h3>${desc.optimalRange}</h3> 
                            </div>
                            <div class="infor__description-body mb-3">
                                <p></p> 
                            </div>
                        </c:forEach>
                        <div class="infor__description-footer text-right">
                            <h4 class="bnt_okay-infor-suggest">OKAY</h4>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container__infor__water-parameter" id="form-container" style="display: none;">
                <div class="infor__water-parameter-detail">
                    <form action="updateRecord" method="POST" id="updateForm">
                        <div class="place_btn-r-a">
                            <button type="button" class="btn btn-item-handle btn-close-modal" onclick="closeForm()">
                                <i class="fas fa-times"></i>
                            </button>
                            <button type="submit" class="btn btn-item-handle btn-accept-form">
                                <i class="fa-solid fa-check"></i>
                            </button>
                        </div>
                        <div class="water-parameter-form">
                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label class="color-value" for="pond-select">Pond:</label>
                                    <select name="pond" id="pond-select">
                                        <c:forEach var="pond" items="${listPond}">
                                            <option value="${pond.pondID}">${pond.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="item_input-detail">
                                    <label class="color-value" for="datetime">Date & Time</label>
                                    <input type="datetime-local" id="datetime" name="datetime">
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="nitrite">Nitrite (NO₂):</label>
                                    <div class="contain_input_a-infor">
                                        <input id="nitrite" class="input_value-parameter" data-param="NO2" type="number" step="0.1" min="0" name="nitrite">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">mg/l</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="item_input-detail">
                                    <label for="oxygen">Oxygen (O₂):</label>
                                    <div class="contain_input_a-infor">
                                        <input id="oxygen" class="input_value-parameter" data-param="O2" type="number" step="0.1" min="0" name="oxygen">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">mg/l</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="nitrate">Nitrate (NO₃):</label>
                                    <div class="contain_input_a-infor">
                                        <input id="nitrate" class="input_value-parameter" type="number" step="0.1" min="0" name="nitrate">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">mg/l</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="item_input-detail">
                                    <label for="temperature">Temperature:</label>
                                    <div class="contain_input_a-infor">
                                        <input id="temperature" class="input_value-parameter" type="number" name="temperature">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">°C</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="phosphate">Phosphate (PO₄):</label>
                                    <div class="contain_input_a-infor">
                                        <input id="phosphate" class="input_value-parameter" type="number" step="0.1" min="0" name="phosphate">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">mg/l</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="item_input-detail">
                                    <label for="phValue">pH-Value:</label>
                                    <div class="contain_input_a-infor">
                                        <input id="phValue" class="input_value-parameter" type="number" step="0.1" min="0" name="phValue">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block"></span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="ammonium">Ammonium (NH₄):</label>
                                    <div class="contain_input_a-infor">
                                        <input id="ammonium" class="input_value-parameter" type="number" min="0" name="ammonium">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">mg/l</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="item_input-detail">
                                    <label for="KH">Carbon Hardness (KH):</label>
                                    <div class="contain_input_a-infor">
                                        <input id="KH" class="input_value-parameter" type="number" step="0.1" min="0" name="KH">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">°dH</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="GH">Hardness (GH):</label>
                                    <div class="contain_input_a-infor">
                                        <input id="GH" class="input_value-parameter" type="number" step="0.1" min="0" name="GH">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">°dH</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="item_input-detail">
                                    <label for="CO2">CO₂:</label>
                                    <div class="contain_input_a-infor">
                                        <input id="CO2" class="input_value-parameter" type="number" min="0" name="CO2">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">mg/l</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="salt">Salt:</label>
                                    <div class="contain_input_a-infor">
                                        <input id="salt" class="input_value-parameter" type="number" min="0" name="salt">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">%</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="item_input-detail">
                                    <label for="amountFed">Amount Fed:</label>
                                    <div class="contain_input_a-infor">
                                        <input id="amountFed" class="input_value-parameter" type="number" min="0" name="amountFed">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">g</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item_input-var d-flex justify-content-between">
                                <div class="item_input-detail">
                                    <label for="outdoorTemp">Outdoor Temp:</label>
                                    <div class="contain_input_a-infor">
                                        <input id="outdoorTemp" class="input_value-parameter" type="number" name="outdoorTemp">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">°C</span>
                                            <i class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="input-note_desc">
                                <label for="note">Note:</label>
                                <textarea name="note" id="note"></textarea>
                            </div>
                        </div>
                    </form>

                    <div class="d-flex justify-content-center mt-3">
                        <a href="deleteRecord?id=1" class="btn btn-item-handle btn-delete">
                            <i class="fa-solid fa-trash"></i> Delete
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- footer -->
        <div id="footer"></div>
        <style>
            .item_s:nth-child(odd) .item_value {
                justify-content: flex-end;
                display: flex;
                /* Đảm bảo .item_value là flex container */
            }
        </style>


    </script>
    <script>
        $('#header').load('utils.jsp #header__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        $('#footer').load('utils.jsp #footer__nav', () => {
            $.getScript('./assets/js/utilsCustomer.js');
        });
        function setCurrentDateTime() {
            const now = new Date();
            const year = now.getFullYear();
            const month = String(now.getMonth() + 1).padStart(2, '0');
            const day = String(now.getDate()).padStart(2, '0');
            const hours = String(now.getHours()).padStart(2, '0');
            const minutes = String(now.getMinutes()).padStart(2, '0');
            // Định dạng theo kiểu YYYY-MM-DDTHH:MM
            const formattedDateTime = `${year}-${month}-${day}T${hours}:${minutes}`;
                    // Đặt giá trị cho input
                    document.getElementById('datetime').value = formattedDateTime;
                }
                // Gọi hàm để đặt ngày giờ hiện tại khi trang tải
                setCurrentDateTime();
    </script>
    <script>
        //Mở form cho update và delete
        document.getElementById('water-parameter-list').addEventListener('click', function (event) {
            if (event.target.closest('.water-parameter-item')) {
                openForm();
            }
        });

        function openForm() {
            document.getElementById('form-container').style.display = 'flex';
        }

        function closeForm() {
            document.getElementById('form-container').style.display = 'none';
        }

        window.addEventListener('click', function (event) {
            const formContainer = document.getElementById('form-container');
            if (formContainer.style.display === 'flex' && !event.target.closest('.infor__water-parameter-detail') && !event.target.closest('.water-parameter-item')) {
                closeForm();
            }
        });

        const waterParameterId = document.querySelector('.selected-water-parameter-id').value;

        fetch(`/WaterParametersInformationController?waterParameterID=${waterParameterId}`)
                .then(response => response.json())  // Chuyển đổi response sang JSON
                .then(data => {
                    document.querySelector("#pond-select").value = data.pond.pondID;
                    document.querySelector("#datetime").value = data.dateTime;
                    document.querySelector("#note").value = data.note;

                    data.details.forEach((detail, index) => {
                        const inputFields = document.querySelectorAll('.input_value-parameter');
                        const inputField = inputFields[index];
                        inputField.value = detail.value;
                    });
                    document.getElementById('form-container').style.display = 'block';
                })
                .catch(error => {
                    console.error('Error:', error);
                });


    </script>
    <script>
        const containerModalAdd = document.querySelector('.container__infor__water-parameter');
        const subModalAdd = document.querySelector('.infor__water-parameter-detail');
        const btnCloseModalAdd = document.querySelector('.btn-close-modal');
        const btnOpenAdd = document.querySelector('.btn_add-infor-parameter');
        btnOpenAdd.addEventListener('click', (e) => {
            containerModalAdd.classList.add('open');
        })

        btnCloseModalAdd.addEventListener('click', () => {
            containerModalAdd.classList.remove('open');
        })
        containerModalAdd.addEventListener("click", () => {
            containerModalAdd.classList.remove("open");
        });
        subModalAdd.addEventListener("click", (e) => {
            e.stopPropagation();
        });
        const containerModalSuggest = document.querySelector('.container__infor__description');
        const subModalSuggest = document.querySelector('.infor__description-detail');
        const inforSuggests = document.querySelectorAll('.signal-input-detail > i');
        const closeBtnOkaySuggest = document.querySelector('.bnt_okay-infor-suggest');
        for (const openSuggest of inforSuggests) {
            openSuggest.addEventListener('click', () => {
                containerModalSuggest.classList.add('open');
            });
        }
        closeBtnOkaySuggest.addEventListener('click', () => {
            containerModalSuggest.classList.remove('open');
        });
        containerModalSuggest.addEventListener("click", () => {
            containerModalSuggest.classList.remove('open');
        });
        subModalSuggest.addEventListener("click", (e) => {
            e.stopPropagation();
        });
    </script>
    <script>
        function setColor(input, color) {
            input.style.color = color;
            input.style.borderColor = color;
            const label = input.closest('.item_input-detail').querySelector('label');
            if (label) {
                label.style.color = color;
            }
            const span = input.closest('.contain_input_a-infor').querySelector('.signal-input-detail span');
            const icon = input.closest('.contain_input_a-infor').querySelector('.signal-input-detail i');
            if (span) {
                span.style.color = color; // change unit        
            }
            if (icon) {
                icon.style.color = color; // change infor        
            }

        }
        function setColorV2(itemParent, color) {
            // const elementDivColorChange =
            itemParent.style.color = color;
        }

        function checkValue(value, range) {
            const buffer = (range.max - range.min) * 0.1; // Giới hạn "gần tới" (10% của khoảng)

            if (value >= range.min && value <= range.max) {
                return '#048155'; // bs-green
            } else if ((value >= range.min - buffer && value < range.min) || (value > range.max && value <= range.max + buffer)) {
                return '#fd7e14'; // bs-orange
            }
            return '#f34747'; // bs-red
        }

        const optimalRange = {
        <c:forEach items="${waterParameters}" var="param">
            "${param.waterDesc.name}": {min: ${param.waterDesc.minValue}, max: ${param.waterDesc.maxValue}},
        </c:forEach>
        };
        document.querySelectorAll('.input_value-parameter').forEach((input) => {
            input.addEventListener('input', function () {
                const param = this.getAttribute('data-param');
                const value = parseFloat(this.value);
                const range = optimalRange[param];
                if (!this.value) {
                    setColor(this, '#000');
                } else if (range) {
                    const color = checkValue(value, range); // value : la tu input nhap vao , range la so sanh 2 cai min max neu tra ra tu obj
                    setColor(this, color);
                }
            })

        })

    </script>
    <!-- Read value from list water parameter from div -->
    <script>
        const itemValueWaterParameter = document.querySelectorAll('.value_water-parameter');
        itemValueWaterParameter.forEach((item) => {
            if (item) {
                const valueParameter = parseFloat(item.textContent.trim()); // Lấy giá trị số từ nội dung text của item
                const param = item.getAttribute('data-param');
                const range = optimalRange[param];
                const parentItem = item.closest('.item_s');
                if (!valueParameter) {
                    setColor(parentItem, "#000");
                } else {
                    const colorv2 = checkValue(valueParameter, range);
                    setColorV2(parentItem, colorv2);
                }
            }
        })

    </script>
    <style>
        .input_value:focus {
            border-color: inherit;
        }
        .item_s{
            justify-content: inherit;
        }
        .item_s:nth-child(even)  {
            justify-content: flex-end;
            /* display: flex; */
            /* Đảm bảo .item_value là flex container */
        }
    </style>

</body>

</html>