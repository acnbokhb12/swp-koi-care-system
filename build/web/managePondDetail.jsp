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
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
    <link rel="stylesheet" href="./assets/css/pondDetail.css"> <!-- Bạn có thể thêm CSS của riêng mình nếu cần -->
</head>
<body>
    <div class="container">
        <h2>Pond Details</h2>
        <c:if test="${not empty pond}">
            <div class="pond-detail-container">
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
                    <p id="drainCount">${pond.drainCount}</p>
                </div>
                <div class="form-group">
                    <label for="skimmer">Skimmer:</label>
                    <p id="skimmer">${pond.skimmer}</p>
                </div>
                <div class="form-group">
                    <label for="numberOfFish">Number of Fish:</label>
                    <p id="numberOfFish">${pond.numberOfFish}</p>
                </div>
            </div>
        </c:if>
        <c:if test="${empty pond}">
            <p>This pond does not exist or has not been assigned any fish.</p>
        </c:if>
        <div class="actions">
            <a href="ManagePondController" class="btn btn-primary">Back to Pond List</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        // Load any additional scripts if necessary
    </script>
</body>
</html>
