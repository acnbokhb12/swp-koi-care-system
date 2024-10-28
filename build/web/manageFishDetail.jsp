<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manage Fish Details</title>
        <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css">
        <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
        <link rel="stylesheet" href="./assets/css/adminFish.css">
    </head>
    <body>
        <div class="container_admin">
            <div id="db-wrapper">
                <div id="sidebar_admin"></div>
                <header id="header"></header>
                <div class="right-navbar-admin-manage">
                    <!-- Main Content Section -->
                    <div class="content">
                        <div class="header">
                            <h2>Manage Fish and Pond Details</h2>
                               <div class="actions"> 
                                 <a href="ManageFishController?acid=${fish.accID}" class="btn btn-primary">Back to Fish List</a> 
                            </div>
                        </div>
                        <form class="fish-pond-form">
                            <!-- Fish Information Section (Left) -->
                            <div class="fish-container">
                                <h3>Fish Information</h3>
                                <div class="form-group">
                                    <label for="fishId">Fish ID:</label>
                                    <p id="fishId">${fish.fishID}</p>
                                </div>
                                <div class="form-group d-flex align-items-start">
                                    <img id="fishImage" src="${fish.fishImage}" alt="${fish.fishName}" class="img-fluid fish-image" />
                                    <div class="fish-details">
                                        <div class="form-group">
                                            <label for="fishName">Fish Name:</label>
                                            <p id="fishName" class="fish-detail">${fish.fishName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Description:</label>
                                            <p id="description" class="fish-detail">${fish.descriptionKoi}</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="age">Age:</label>
                                            <p id="age" class="fish-detail">${fish.age} <span class="sub_span-highlight">year(s)</span></p>
                                        </div>
                                        <div class="form-group">
                                            <label for="length">Length:</label>
                                            <p id="length" class="fish-detail">${fish.length} <span class="sub_span-highlight">cm</span> </p>
                                        </div>
                                        <div class="form-group">
                                            <label for="weight">Weight:</label>
                                            <p id="weight" class="fish-detail">${fish.weight} <span class="sub_span-highlight">kg</span></p>
                                        </div>
                                        <div class="form-group">
                                            <label for="gender">Gender:</label>
                                            <p id="gender" class="fish-detail">${fish.gender}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Pond Information Section -->
                            <div class="pond-container">
                                <h3>Pond Information</h3>
                                <c:if test="${not empty pond}">
                                    <div class="form-group">
                                        <label for="pondID">Pond ID:</label>
                                        <p id="pondId" class="pond-detail">${pond.pondID}</p>
                                    </div>
                                    <div class="form-group d-flex align-items-start">
                                        <img id="pondImage" src="${pond.image}" alt="${pond.name}" class="img-fluid pond-image" />
                                        <div class="pond-details">
                                            <div class="form-group">
                                                <label for="pondName">Pond Name:</label>
                                                <p id="pondName" class="pond-detail">${pond.name}</p>
                                            </div>
                                            <div class="form-group">
                                                <label for="descriptionPond">Description:</label>
                                                <p id="descriptionPond" class="pond-detail">${pond.descriptionPond}</p>
                                            </div>
                                            <div class="form-group">
                                                <label for="volume">Volume:</label>
                                                <fmt:formatNumber value="${pond.volume}" pattern="0.0" var="formattedVolume" />
                                                <p id="volume" class="pond-detail highlight">${formattedVolume} <span class="sub_span-highlight"> (l)</span></p>
                                            </div>
                                            <div class="form-group">
                                                <label for="depth">Depth:</label>
                                                <fmt:formatNumber value="${pond.depth}" pattern="0.0" var="formattedDepth" />
                                                <p id="depth" class="pond-detail highlight">${formattedDepth} <span class="sub_span-highlight">(m)</span></p>
                                            </div>
                                            <div class="form-group">
                                                <label for="pumpPower">Pump Power:</label>
                                                <fmt:formatNumber value="${pond.pumpPower}" pattern="0.0" var="formattedPumpPower" />
                                                <p id="pumpPower" class="pond-detail highlight">${formattedPumpPower} <span class="sub_span-highlight">(l/h)</span></p>
                                            </div>
                                            <div class="form-group">
                                                <label for="drainCount">Drain Count:</label>
                                                <p id="drainCount" class="pond-detail">${pond.drainCount}</p>
                                            </div>
                                            <div class="form-group">
                                                <label for="skimmer">Skimmer:</label>
                                                <p id="skimmer" class="pond-detail">${pond.skimmer}</p>
                                            </div>
                                            <div class="form-group">
                                                <label for="numberOfFish">Number of Fish:</label>
                                                <p id="numberOfFish" class="pond-detail">${pond.numberOfFish}</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${empty pond}">
                                    <p class="pond-detail">This fish has not been assigned to any pond yet.</p>
                                </c:if>
                            </div>
                        </form>
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
