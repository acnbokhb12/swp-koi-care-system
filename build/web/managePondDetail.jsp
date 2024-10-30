<%-- 
    Document   : managePondDetail
    Created on : 29/10/2024, 1:48:03 AM
    Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Pond Details</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminPond.css">
    </head>
    <body>
        <div class="container_admin">
            <div id="db-wrapper">
                <div id="sidebar_admin"></div>
                <header id="header"></header>
                <div class="right-navbar-admin-manage"> 
                    <div class="content">
                        <div class="header">
                            <h2>Manage Pond Details</h2>
                            <div class="actions"> 
                                <a href="ManagerPondController?acid=${pond.accID}" class="btn btn-primary">Back to Pond List</a> 
                            </div>
                        </div>
                        <c:if test="${not empty pond}">
                            <div class="pond-detail-container">
                                <h3 class="text-center">Pond Details</h3>
                                <div class="row">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <img id="pondImage" src="${pond.image}" alt="Pond Image" class="img-fluid pond-image" />
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="pondID">Pond ID:</label>
                                                        <p id="pondId">${pond.pondID}</p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="pondName">Pond Name:</label>
                                                        <p id="pondName">${pond.name}</p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="descriptionPond">Description:</label>
                                                        <p id="descriptionPond">${pond.descriptionPond}</p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="volume">Volume:</label>
                                                        <fmt:formatNumber value="${pond.volume}" pattern="0.0" var="formattedVolume" />
                                                        <p id="volume">${formattedVolume} <span class="sub_span-highlight">(l)</span></p>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="depth">Depth:</label>
                                                        <fmt:formatNumber value="${pond.depth}" pattern="0.0" var="formattedDepth" />
                                                        <p id="depth">${formattedDepth} <span class="sub_span-highlight">(m)</span></p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="pumpPower">Pump Power:</label>
                                                        <fmt:formatNumber value="${pond.pumpPower}" pattern="0.0" var="formattedPumpPower" />
                                                        <p id="pumpPower">${formattedPumpPower} <span class="sub_span-highlight">(l/h)</span></p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="drainCount">Drain Count:</label>
                                                        <p id="drainCount">${pond.drainCount} <span class="sub_span-highlight">pieces</span></p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="skimmer">Skimmer:</label>
                                                        <p id="skimmer">${pond.skimmer} <span class="sub_span-highlight">pieces</span></p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="numberOfFish">Number of Fish:</label>
                                                <p id="numberOfFish">${pond.numberOfFish} <span class="sub_span-highlight">fish(s)</span></p>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                $('#header').load('utils.jsp #header_admin', () => {
                    $.getScript('./assets/js/utilsAdmin.js');
                });
                $('#sidebar_admin').load('utils.jsp #sidebar_manager');
            </script>
    </body>
</html>
