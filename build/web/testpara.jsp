<%-- 
    Document   : testpara
    Created on : Nov 6, 2024, 1:13:19 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="water__parameter-list row  mt-4">
                <!-- Foreach water parameter -->
                <!-- foreach -->
                <!-- <c:foreach item="listPara" var="parItem" -->
                <div class="waterParameter_item_stand col_custom  col-md-6  ">
                    <div class="water-parameter-item">
                        <div class="water-item-detail">
                            <div class="item__component d-flex justify-content-between">
                                <div class="item_s align-items-center">
                                    <div class="item_title namepond">Main Pond adsfdasf dsfads fasd sfad</div>
                                </div>
                                <div class="item_s">
                                    <div class="item_title">29.05.2025</div>
                                </div>
                            </div>
                            <div class="row m-0">
                                <!-- Foreach list waterParameterDetail -->
                                <!-- Foreach Water Parameter Description -->
                                 <!-- <c:foreach items="${parItem.ListParaDetail}" var="itemDetail"  > -->
                                <div class="item_s col-6 p-0">
                                    <div class="item_name-value pr-2"><!--${itemDetail.watDesc.name}--> (NO2):</div>
                                    <div class="item_value">
                                        <span class="value_water-parameter" data-param="NO2">0.21</span>
                                        <span class="unit_value">mg/l</span>
                                    </div>
                                </div> 
                                <!-- <c:/> -->
                                <!--  -->
                            </div> 
                            <div class="item_note-desc">
                                <p> About the nhiet di thi can dc thay doi, phai mua them dung cu cho ho nhu thuoc , toy ,
                                    basuc music, and some thdsfkjádkf ksdhfhádhf sdhkfk hádhf sadhk fh sdh sdkjfjadsb hj ádf
                                    hds fhbsdahbfhsadbfhsdbh</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- <c:/> -->

            </div>
        </div>
        <!-- Modal Add more -->
        <div class="container__infor__water-parameter">
            <div class="infor__water-parameter-detail">
                <form action="">
                    <div class="place_btn-r-a">
                        <button type="button" class="btn btn-item-handle btn-close-modal"><i
                                class="fas fa-times"></i></button>
                        <button type="submit" class="btn btn-item-handle btn-accept-form"><i
                                class="fa-solid fa-check"></i></button>
                    </div>
                    <div class="water-parameter-from">
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label class="color-value" for="">Pond:</label>
                                <select name="" id="">
                                    <option value="">1</option>
                                    <option value="">2</option>
                                    <option value="">3</option>
                                </select>
                            </div>
                            <div class="item_input-detail">
                                <label class="color-value" for="">Date & time</label>
                                <input type="datetime-local" id="datetime">
                            </div>
                        </div>
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label for="">Nitrite(NO<sub>2</sub>):</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" data-param="NO2" type="number" step="0.1" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">mg/l</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="item_input-detail">
                                <label for="">Oxygen(O<sub>2</sub>):</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" data-param="O2" type="number" step="0.1" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">mg/l</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label for="">Nitrate(NO<sub>3</sub>):</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" step="0.1" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">mg/l</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="item_input-detail">
                                <label for="">Temperature:</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">°C </span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label for="">Phosphate(PO<sub>4</sub>):</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" step="0.1" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">mg/l</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="item_input-detail">
                                <label for="">pH-Value:</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" step="0.1" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block"> </span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label for="">Ammonium(NH<sub>4</sub>):</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">mg/l</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="item_input-detail">
                                <label for="">Carbon. hardn. (KH):</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" step="0.1" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">°dH</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label for="">Hardness: (GH)</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" step="0.1" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">°dH</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="item_input-detail">
                                <label for="">CO<sub>2</sub>:</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">mg/l</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label for="">Salt:</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">%</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="item_input-detail">
                                <label for="">Amount fed:</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number" min="0">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">g</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item_input-var d-flex justify-content-between">
                            <div class="item_input-detail">
                                <label for="">Outdoor temp:</label>
                                <div class="contain_input_a-infor">
                                    <input class="input_value-parameter" type="number">
                                    <div class="signal-input-detail d-flex align-items-center">
                                        <span class="d-block">°C</span>
                                        <i class="fa-solid fa-circle-info"></i>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="input-note_desc">
                            <label for="">Note:</label>
                            <textarea name="" id=""></textarea>
                        </div>
                    </div>
                </form>
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
                        <h3>5 - 35 mg/l</h3>
                    </div>
                    <div class="infor__description-body mb-3">
                        <p>The CO2 concentration in the water depends on both the pH value and the carbonate hardness (KH).
                            Thus, CO2 does not need to be measured and can be calculated automatically by KoiControl. If the
                            pH value and the KH value are good, then this is also true for the CO2 concentration. Moving a
                            lot of CO2 out of the water (e.q)</p>
                    </div>
                    <div class="infor__description-footer text-right">
                        <h4 class="bnt_okay-infor-suggest">OKAY</h4>
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
        <script>
            $('#header').load('utils.html #header__nav', () => {
                $.getScript('./assets/js/utilsCustomer.js')
            });
            $('#footer').load('utils.html #footer__nav', () => {
                $.getScript('./assets/js/utilsCustomer.js')
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
        <!-- read value from inout -->
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
                    span.style.color = color;    // change unit        
                }
                if (icon) {
                    icon.style.color = color;      // change infor        
                }

            }
            function setColorV2(itemParent, color) {
                // const elementDivColorChange =
                itemParent.style.color = color;
            }

            function checkValue(value, range) {
                const buffer = (range.max - range.min) * 0.1;  // Giới hạn "gần tới" (10% của khoảng)

                if (value >= range.min && value <= range.max) {
                    return '#048155';  // bs-green
                } else if ((value >= range.min - buffer && value < range.min) || (value > range.max && value <= range.max + buffer)) {
                    return '#fd7e14'; // bs-orange
                }
                return '#f34747';    // bs-red
            }
            const optimalRange = {
                NO2: {min: 0, max: 0.25},
                O2: {min: 6.5, max: 12},
                CO2: {min: 10, max: 30},
                NH3: {min: 0.2, max: 1.0},
                pH: {min: 6.5, max: 8.5},
                NO3: {min: 0, max: 1},
            }


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
