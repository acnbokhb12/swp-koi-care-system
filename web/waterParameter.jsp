<%-- 
    Document   : waterParameter
    Created on : Oct 26, 2024, 12:42:41 PM
    Author     : DELL
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
                    <div class="waterParameter_item_stand col_custom col-lg-6">
                        <input type="hidden" class="selected-water-parameter-id" value="${waterParameter.waterParameterId}" />
                        <div class="water-parameter-item" style="cursor: pointer;" data-table-wt-id="${waterParameter.waterParameterId}" data-pond-id="${waterParameter.pondID}" data-date-update="${waterParameter.measurementDate}" data-note-update="${waterParameter.note}" >
                            <div class="water-item-detail">
                                <div class="item__component d-flex justify-content-between">
                                    <div class="item_s align-items-center">
                                        <div class="item_title namepond">
                                            ${waterParameter.pond.name}
                                        </div>
                                    </div>
                                    <div class="item_s"> 
                                        <div class="item_title"> 
                                            <c:out value="${fn:substringBefore(waterParameter.measurementDate, 'T')} ${fn:substringAfter(waterParameter.measurementDate, 'T')}" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row m-0">
                                    <!-- Loop over each waterParameterDetail in waterParameter -->
                                    <c:forEach items="${waterParameter.waterParameterDetails}" var="detail">
                                        <div class="item_s col-sm-6 p-0">
                                            <div class="item_name-value pr-2">
                                                ${detail.waterDesc.name}(${detail.waterDesc.symbol}):
                                            </div>
                                            <div class="item_value">
                                                <span class="value_water-parameter" data-param="${detail.waterDesc.waterParameterDescID}">
                                                    ${detail.value != 0.0 ? detail.value : '-' }
                                                </span>
                                                <span class="unit_value pl-1">
                                                    ${detail.value != 0.0 ? detail.waterDesc.unit : ''}
                                                </span>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="item_note-desc">   
                                    <p>${waterParameter.note}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- Modal Add more -->
            <div class="container__infor__water-parameter">
                <div class="infor__water-parameter-detail">
                    <form action="WaterParametersCreateNewController" method="post">
                        <div class="place_btn-r-a">
                            <button type="button" class="btn btn-item-handle btn-close-modal"><i
                                    class="fas fa-times"></i></button>
                            <button type="submit" class="btn btn-item-handle btn-accept-form"><i
                                    class="fa-solid fa-check"></i></button>
                        </div>
                        <div class="water-parameter-from row m-0">

                            <div class="item_input-detail  col-6 p-1">
                                <label class="color-value" for="">Pond:</label>
                                <select name="pond" class="pr-1" id="">
                                    <c:forEach var="pond" items="${listPond}">
                                        <option value="${pond.pondID}">${pond.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="item_input-detail  col-6 p-1">
                                <label class="color-value" for="">Date & time</label>
                                <input class="pr-1" type="datetime-local" id="datetime" name="datetimeMeasure" value="${formattedDateTime}">
                            </div>

                            <c:forEach items="${waterDescription}" var="wtdesc"> 
                                <div class="item_input-detail  col-6 p-1">
                                    <label for="">${wtdesc.name}(${wtdesc.symbol}):</label>
                                    <div class="contain_input_a-infor">
                                        <input class="input_value-parameter" name="waPara${wtdesc.waterParameterDescID}" data-param="${wtdesc.waterParameterDescID}" type="number" step="0.1" min="0">
                                        <div class="signal-input-detail d-flex align-items-center">
                                            <span class="d-block">${wtdesc.unit}</span>
                                            <i data-optimal-range="${wtdesc.optimalRange}" data-desc-parameter="${wtdesc.description}" class="fa-solid fa-circle-info"></i>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                            <div class="input-note_desc col-12 p-1">
                                <label for="">Note:</label>
                                <textarea name="noteNew" id=""></textarea>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!-- Modal Update and Delete more -->
            <!--hash map co name co symbol value la nguyen doi ttuong description key cua hash map la cai nao the . text dua len khung-->
            <div class="container__infor__water-parameter container__infor__water-parameter-update">
                <div class="infor__water-parameter-detail infor__water-parameter-detail-update">
                    <form action="WaterParametersCreateNewController" method="post">
                        <div class="place_btn-r-a">
                            <button type="button" class="btn btn-item-handle btn-close-modal"><i
                                    class="fas fa-times"></i></button>
                            <button type="submit" class="btn btn-item-handle btn-accept-form"><i
                                    class="fa-solid fa-check"></i></button>
                        </div>
                        <div class="water-parameter-from row m-0">

                            <div class="item_input-detail  col-6 p-1">
                                <label class="color-value" for="">Pond:</label>
                                <select name="pond" class="pr-1" id="pondUpdate">
                                    <c:forEach var="pond" items="${listPond}">
                                        <option value="${pond.pondID}">${pond.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="item_input-detail  col-6 p-1">
                                <label class="color-value" for="">Date & time</label>
                                <input class="pr-1" type="datetime-local" id="datetimeUpdate" name="datetimeMeasure" value="${formattedDateTime}">
                            </div>
                            <div class="col-12 p-0">
                                <div class="row m-0 row-input-update">
                                    <!-- Code for each-->
                                </div>
                            </div> 
                            <div class="input-note_desc col-12 p-1">
                                <label for="">Note:</label>
                                <textarea  name="" id="noteUpdate"></textarea>
                            </div>
                        </div>
                    </form>
                    <div class="d-flex justify-content-center mt-3">
                        <a href="deleteRecord?id=1" class="btn btn-item-handle btn-delete text-danger">
                            <i class="fa-solid fa-trash"></i> Delete
                        </a>
                    </div>
                </div>
            </div>

            <!-- Modal Inf -->
            <div class="container__infor__description">
                <div class="infor__description-detail">
                    <div class="infor__description-water-parameter">
                        <div class="infor__description-title mb-3">
                            <h2>Information</h2>
                        </div>
                        <div class="infor__description-range mb-3">
                            <h3>Optimal range:</h3>
                            <h3 class="optimalRange"></h3>
                        </div>
                        <div class="infor__description-body mb-3">
                            <p class="descriptionParameter"></p>
                        </div>
                        <div class="infor__description-footer text-right">
                            <h4 class="bnt_okay-infor-suggest">OKAY</h4>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container__infor__water-parameter" id="form-container" style="display: none;">
                <div class="infor__water-parameter-detail">


                    <div class="d-flex justify-content-center mt-3">
                        <a href="deleteRecord?id=1" class="btn btn-item-handle btn-delete">
                            <i class="fa-solid fa-trash"></i> Delete
                        </a>
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
        <div id="modal-logout-confirm"></div> 

        <!-- footer -->
        <div id="footer"></div>

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
            /*            .item_s:nth-child(odd) .item_value {
                            justify-content: flex-end;
                            display: flex;
                             Đảm bảo .item_value là flex container 
                        }*/
            @media screen and (max-width:576px) {
                .item_s{
                    justify-content: space-between;
                }
                .item_s:nth-child(even) {
                    justify-content:space-between;
                    /* display: flex; */
                }
            }
        </style>


        <script>
            $('#header').load('utils.jsp #header__nav', () => {
                $.getScript('./assets/js/utilsCustomer.js');
            });
            $('#footer').load('utils.jsp #footer__nav', () => {
                $.getScript('./assets/js/utilsCustomer.js');
            });
            $('#modal-logout-confirm').load('utils.jsp #modal-logout-confirm_nav', () => {
                $.getScript('./assets/js/utilsCustomer.js')
            });
        </script>
        <script src="assets/js/notification.js"></script>

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
            const optimalRangeEle = document.querySelector('.optimalRange');
            for (const openSuggest of inforSuggests) {
                openSuggest.addEventListener('click', function () {
                    const optimalRange = this.getAttribute("data-optimal-range");
                    const descriptionParameter = this.getAttribute("data-desc-parameter");
                    optimalRangeEle.innerText = optimalRange;
                    document.querySelector('.descriptionParameter').innerText = descriptionParameter;

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
            <c:forEach items="${waterDescription}" var="wtdesc">
                ${wtdesc.waterParameterDescID}: {min: ${wtdesc.minValue}, max: ${wtdesc.maxValue}},
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
                    const parentItem = item.closest('.item_s');

                    if (isNaN(valueParameter)) {
                        parentItem.style.color = '#000';
                    } else {
                        const param = item.getAttribute('data-param');
                        const range = optimalRange[param];
                        const colorv2 = checkValue(valueParameter, range);
                        setColorV2(parentItem, colorv2);

                    }
                }
            })

            const containerModalUpdate = document.querySelector('.container__infor__water-parameter-update');
            const subModalUpdate = document.querySelector('.infor__water-parameter-detail-update');
            const waterParameterTables = document.querySelectorAll('.water-parameter-item');

            const containerRowUpdate = document.querySelector('.row-input-update');
            for (const itemTableParameterOpen of waterParameterTables) {
                itemTableParameterOpen.addEventListener('click', function () {
                    const idWaterParameter = this.getAttribute('data-table-wt-id');
                    const dateMeasure = this.getAttribute('data-date-update');
                    const noteToUpdate = this.getAttribute('data-note-update');
                    const pondId = this.getAttribute('data-pond-id');
                    document.getElementById('datetimeUpdate').value = dateMeasure;
                    document.getElementById('noteUpdate').value = noteToUpdate;
                    const selectElement = document.getElementById('pondUpdate');

// Kiểm tra và chọn option tương ứng với pondId
                    for (const option of selectElement.options) {
                        if (option.value === pondId) {
                            option.selected = true;
                            break;
                        }
                    }
                    containerRowUpdate.innerHTML = '';
                    let updateHtmlWater = '';
            <c:forEach items="${waterParameters}" var="waterParameter">
                    if (${waterParameter.waterParameterId} == idWaterParameter) {
                <c:forEach items="${waterParameter.waterParameterDetails}" var="detail">
                        updateHtmlWater = `<div class="item_input-detail  col-6 p-1">
                                        <label for="">${detail.waterDesc.name}(${detail.waterDesc.symbol})</label>
                                        <div class="contain_input_a-infor">
                                            <input class="input_value-parameter-update input_value-parameter" name="" data-param="${detail.waterDesc.waterParameterDescID}" type="number" step="0.1" min="0" value="${detail.value != 0.0 ? detail.value : '' }">
                                            <div class="signal-input-detail d-flex align-item   s-center">
                                                <span class="d-block mr-1">${detail.value != 0.0 ? detail.waterDesc.unit : ''}</span>
                                                <i data-optimal-range="${detail.waterDesc.optimalRange}" data-desc-parameter="${detail.waterDesc.description}" class="btn-show-infor fa-solid fa-circle-info m-auto"></i>
                                            </div>
                                        </div>
                                    </div>`;
                        containerRowUpdate.innerHTML += updateHtmlWater;
                </c:forEach>
                    }


            </c:forEach>
                    containerModalUpdate.classList.add('open');
                    const abc = document.querySelectorAll('.input_value-parameter-update');
                    console.log(abc);
                    abc.forEach((input) => {
                        const param = input.getAttribute('data-param');
                        const value = parseFloat(input.value);
                        const range = optimalRange[param];

                        // Kiểm tra và áp dụng màu ngay lập tức cho giá trị sẵn có
                        if (input.value && range) {
                            const color = checkValue(value, range);
                            setColor(input, color);
                        } else {
                            setColor(input, '#000');
                        }

                        input.addEventListener('input', function () {
                            const param = this.getAttribute('data-param');
                            console.log(param);
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
                    const allIcons = containerRowUpdate.querySelectorAll('.btn-show-infor');
                    for (const openSuggest of allIcons) {
                        openSuggest.addEventListener('click', function () {
                            const optimalRange = this.getAttribute("data-optimal-range");
                            const descriptionParameter = this.getAttribute("data-desc-parameter");
                            optimalRangeEle.innerText = optimalRange;
                            document.querySelector('.descriptionParameter').innerText = descriptionParameter;

                            containerModalSuggest.classList.add('open');
                        });
                    }


                });
            }
            containerModalUpdate.addEventListener('click', () => {
                containerModalUpdate.classList.remove('open');
            })
            subModalUpdate.addEventListener("click", (e) => {
                e.stopPropagation();
            });

            // Move this part outside of any event listener

        </script>
        <script>


        </script>
    </body>

</html>