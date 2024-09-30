<%-- 
    Document   : about
    Created on : Sep 30, 2024, 12:21:25 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About</title>
    <!-- link logo img page -->
    <link rel="icon" href="./assets/img/logo/logoSignin.jpg" type="image/x-icon" />
    <!-- Font icon -->
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- <link rel="stylesheet" href="./assets/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/navHeader-Footer.css">
	<link rel="stylesheet" href="./assets/css/about_contact.css">

	<title>About us</title>
</head>
<body>
    <script src="./assets/js/headernav.js"></script>
	 <!-- slider -->
	<div class="img-aboutus" >
		 
		<div class="container-img-aboutus">
			<img src="https://d267qvt8mf7rfa.cloudfront.net/restaurant/61/mainImage.jpg" alt="">
		</div>
		 
		<div class="container-intro-aboutus">
				<div class="post-entry-aboutus">
					<h1 class="">About Us</h1>
					<p>Welcome to our website! We are a leading company in Kahof, committed to providing the highest quality products and services to our customers. With a team of experienced and dedicated experts, we are constantly striving to develop and improve, to meet all your needs. Come explore and experience the best things with us!</p>
				</div>
				<div class="contain-btn-about">
					<button class="btn-main-about">
						<a href="#main-intro-aboutus">Discover more</a>
						<div class="icon-1">
						  <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" viewBox="0 0 208.52 511.88" xmlns:xlink="http://www.w3.org/1999/xlink"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path class="fil-leaf-1" d="M121.86 141.25c16.73,2.91 65.77,9.16 77.74,-14.94 14.49,-29.19 12.6,-56.91 -15.12,-69.09 -11.3,-4.96 -22.28,-7.7 -32.28,-9.66 -24.58,24.72 -41.22,75.51 -43.83,83.82 4.31,3.56 8.81,6.86 13.49,9.87zm-17.26 41.05c2.87,7.92 8.26,29.59 7.63,79.7 -0.16,12.74 -0.48,25.41 -0.81,38.43 -1.4,55.59 -2.96,117.52 7.12,210.69l-7.09 0.75c-10.12,-93.56 -8.56,-155.77 -7.15,-211.61 0.33,-13.06 0.65,-25.77 0.81,-38.35 0.53,-42.42 -3.06,-63.29 -5.69,-72.77 -7.55,8.48 -18.48,15.07 -34.33,16.54 -26.77,2.47 -43.19,-16.99 -52.84,-36.58 16.49,-8.49 65.65,-32.22 98.27,-31.47 1.86,1.42 3.76,2.8 5.69,4.13 -0.15,5.56 -1.43,24.61 -11.62,40.53zm-41.18 -148.65c-0.32,0.84 1.68,9.87 -6.19,10.71 -7.87,0.84 -3.26,-5.14 -6.82,-7.98 -3.57,-2.84 -9.97,-14.59 1.99,-15.96 11.97,-1.37 11.02,13.23 11.02,13.23zm124.63 55.54c0,0 -3.89,14.8 -10.18,18.69 -6.3,3.88 -22.78,7.24 -28.87,0.11 -6.09,-7.14 -1.57,-31.71 17.64,-30.45 19.21,1.26 22.68,8.4 21.42,11.65zm-101.53 67.51c0,0 5.88,5.56 5.46,9.87 -0.42,4.3 -5.78,19.21 -14.07,20.05 -8.29,0.84 -24.15,-6.82 -21.84,-17.53 2.31,-10.71 10.5,-11.34 12.6,-10.6 2.1,0.74 3.36,2.1 17.85,-1.78zm61.49 -109.94c-12.74,-2.33 -23.63,-3.69 -31.15,-7.4 0,0 -2.41,15.22 -4.51,19.74 -2.1,4.51 -6.3,17.32 -14.8,21.1 -8.5,3.78 -9.87,-28.14 4.62,-45.15 0,0 -10.13,-4.4 -22.34,-9.92 -11.47,31.21 -7.3,64.58 -7.28,64.68l-0.48 0.06c9.73,14.77 20.76,28.04 33.37,39.01 3.68,-11.43 19.48,-57.46 42.58,-82.12zm-71.44 -23.1c-16.59,-7.55 -35.59,-16.58 -38.25,-19.47 -1.97,-2.14 -4.87,-3.72 -7.63,-4.2 9.11,27.4 20.23,54.59 34.36,78.62 1.13,1.92 2.28,3.82 3.45,5.7 -0.66,-11.21 -0.85,-36.56 8.07,-60.65zm-49.59 -23.57c-2.34,0.66 -4.05,2.62 -4.09,6.41 -0.1,9.45 -9.03,35.38 -9.03,35.38 0,0 33.07,14.91 22.99,23.1 -10.08,8.19 -25.41,-8.5 -26.35,-9.34 0,0 -5.94,16.24 -8.44,35.85 11.53,-1.14 38.81,-2.11 72.53,8.35 -4.45,-6.19 -8.65,-12.68 -12.61,-19.42 -14.44,-24.56 -25.77,-52.36 -35.01,-80.32zm-25.33 95.01c-0.61,6.01 -0.86,12.26 -0.49,18.39 0,0 56.17,-9.87 57.33,8.71 1.15,18.58 -58.48,9.45 -58.48,9.45 0,0 2.71,16.68 10.73,34.23 16.07,-8.25 62.14,-30.45 95.29,-31.76l-1.75 -1.5 0.01 -0.03c-9.54,-8.13 -18.2,-17.54 -26.08,-27.89l-0.01 0.04c-36.16,-12.16 -65.36,-10.82 -76.53,-9.63z"></path></g></svg>
						</div>
						<div class="icon-2">
						  <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" viewBox="0 0 420.62 554.38" xmlns:xlink="http://www.w3.org/1999/xlink"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path class="fil-leaf-2" d="M1.57 554.38c-0.01,-0.44 -2.46,-153.75 -1.23,-217.01 0.74,-38.16 6.99,-96.57 32.48,-148.36 17.72,-36 44.66,-68.8 85.37,-89.54l32.28 -4.39c21.9,-6.8 39.46,-7.7 45.04,-7.81 4.32,4.98 10.37,12.18 17.72,21.54 -0.39,10.62 -6.13,113.86 -82.32,208.5 -31.36,-18.46 -51.28,-57.42 -51.28,-57.42 52.13,-30.97 58.88,-51.52 69.61,-68.07 10.73,-16.56 2.45,-44.16 -11.65,-26.06 -14.11,18.09 -65.01,68.07 -65.01,68.07 -12.27,-87.7 33.12,-110.39 33.12,-110.39l0.34 -0.64c-27.64,18.92 -47.12,44.59 -60.77,72.35 -24.37,49.53 -30.35,105.69 -31.07,142.44 -1.22,63.07 1.22,216.14 1.23,216.58l-13.85 0.22zm216.49 -439.34c17.47,22.75 40.96,56.05 66.08,99.4 0.27,13.62 0.62,100.64 -33.48,153.85 -24.85,-9.4 -40.14,-15.03 -40.14,-15.03 12.57,-11.04 46.61,-87.09 23.3,-91.68 -23.3,-4.6 -47.99,84.63 -47.99,84.63 -21.55,-10.35 -42.58,-21.94 -50.33,-26.28 68.93,-86.04 80.61,-179.05 82.56,-204.89zm71.3 108.53c28.78,50.84 59.27,114.6 85.02,190.51 -4.31,0.96 -8.4,-1.03 -8.4,-1.03 -42.77,-17.04 -82,-32.13 -110.36,-42.88 29.72,-47.26 33.46,-119.21 33.74,-146.6zm106.95 70.68c0,0 -16.4,-14.1 -20.54,-22.84 -4.14,-8.74 -15.18,-3.68 -13.95,4.29 1.23,7.97 11.5,45.69 12.27,51.21 0.77,5.52 20.08,6.13 21,-1.99 0.92,-8.13 2.76,-23.61 1.23,-30.66zm-88.46 28.98c0,0 -8.43,4.29 -7.51,15.49 0.92,11.19 10.89,28.36 18.09,30.66 7.21,2.3 18.7,-25.14 -10.58,-46.15zm-109.42 -240.52c15.35,-63.34 56.21,-82.7 93.65,-82.7 38.33,0 65.31,22.23 65.31,22.23 0,0 -11.65,13.03 -33.42,13.95 -21.77,0.92 -28.52,11.65 -28.98,16.41 -0.46,4.75 1.53,16.25 32.35,18.24 30.82,1.99 55.19,-25.14 55.19,-25.14 16.95,23.84 26.52,45.94 31.83,64.51 -16.87,6.83 -73.84,22.75 -197.04,-4.57 -8.01,-10.2 -14.48,-17.86 -18.9,-22.93zm217.3 32.51c7.8,30.68 3.91,50.53 3.91,50.53 -55.65,4.45 -56.73,-5.98 -77.73,-6.59 -21,-0.61 -22.69,28.06 14.41,34.19 37.1,6.13 63.01,-1.99 63.01,-1.99 -1.13,20.07 -2.53,38.3 -4.11,54.87 -17.3,-0.51 -66.77,-6.48 -137.23,-52.73l-0.13 0.2c-21.09,-34.73 -40.52,-62.06 -55.57,-81.67 118.17,25.28 175.11,10.36 193.44,3.2zm-1.01 136.18c-10.45,105.02 -28.21,141.06 -31.88,153.37 -0.95,3.17 -2.29,5.35 -3.82,6.82 -27.16,-79.89 -59.57,-146.38 -89.72,-198.56l-0.02 -0.57 -0.3 0.01c-1.8,-3.11 -3.59,-6.18 -5.38,-9.19 66.28,41.51 113.43,47.51 131.12,48.12z"></path></g></svg>
						</div>
						<div class="icon-3">
						  <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" viewBox="0 0 313.64 405.79" xmlns:xlink="http://www.w3.org/1999/xlink"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path class="fil-leaf-3" d="M268.76 135.61c0,0 -22.17,11.9 -50.23,28.92 -21.12,-5.52 -82.36,-27.74 -81.95,-100.04l-0.14 -0.02c3.32,-12.49 5.48,-21.39 6.11,-24.05 10.61,-20.2 38.05,-50.12 105.57,-37.36 98.73,18.65 57.69,95.74 53.71,98.23 -3.98,2.49 -21.39,6.71 -72.86,-30.59 0,0 -18.15,-14.17 -21.88,12.68 -3.73,26.86 48.99,48.99 61.68,52.23zm-6.57 270.17c-0.06,-0.43 -20.14,-148.39 -56.4,-233.41 -9.42,5.88 -19.19,12.19 -28.79,18.69 0,0 -17.41,-10.44 -27.6,-29.59 -10.2,-19.15 -5.22,-21.76 -13.43,-22.26 -8.21,-0.5 -5.1,34.69 19.52,64.78 0,0 -13.7,11.34 -26.34,23.33 -5.68,-9.69 -18.35,-34.11 -23.43,-66.68l-0.05 -0.01c0.31,-0.8 0.62,-1.59 0.93,-2.38 10.57,-26.8 19.85,-57.53 26.36,-81.01 6.01,61.39 57.45,83.42 80.65,90.27 37.09,86.22 59.66,236.37 59.72,236.8l-11.15 1.45zm-136.16 -175.46c-7.88,7.66 -14.84,15.23 -17.05,19.93 0,0 -7.21,-23.75 -14.42,-18.65 -7.21,5.1 2.11,32.08 2.11,36.8 0,0 -17.66,31.83 -20.89,34.57 -0.83,0.7 -1.66,1.24 -2.49,1.6 -0.23,-13.47 2.61,-34.23 7.4,-57.21 5.42,-26.02 13.33,-54.79 22.1,-79.02 5.96,30.61 18.04,53.25 23.24,61.99zm-56.93 74.37c-0.87,-0.37 -1.72,-1.02 -2.52,-1.97 -2.74,-3.23 -15.17,-25.61 -15.17,-25.61 0,0 6.22,-19.03 15.17,-32.95 8.95,-13.93 -5.84,-15.67 -10.82,-7.21 -4.97,8.46 -12.56,24.74 -12.56,24.74 0,0 -6.31,-12.32 -13.32,-27.52 29.11,-16 53.59,-43.62 66.24,-59.59 -7.75,22.68 -14.67,48.42 -19.56,71.93 -4.83,23.18 -7.69,44.25 -7.46,58.19zm-40.98 -74.37c-7.17,-15.81 -14.58,-33.78 -16.38,-44.11 0,0 40.04,-13.68 46.01,-27.11 5.97,-13.43 -12.68,-19.4 -51.23,4.48 0,0 -7.71,-17.19 -6.37,-43.78 66.5,2.13 113.04,-29.91 128.31,-42.15 -6.46,23.16 -15.53,53 -25.8,79.07 -0.57,1.44 -1.13,2.91 -1.7,4.39 -5.54,7.86 -35.3,48.46 -72.84,69.21zm-27.68 -114.74c0.71,-8.36 2.33,-17.55 5.34,-27.35 0,0 47.75,5.84 50.36,-10.57 2.61,-16.41 -41.28,-5.84 -41.28,-5.84 0,0 25.99,-35.56 60.3,-33.82 28.82,1.46 52.37,13.88 59.18,17.82 -1.11,4.27 -2.41,9.2 -3.89,14.62 -5.75,5.22 -54.72,47.49 -130.01,45.14z"></path></g></svg>
						</div>
						<div class="icon-4">
						  <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" viewBox="0 0 359.65 724.72" xmlns:xlink="http://www.w3.org/1999/xlink"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path class="fil-leaf-4" d="M251.9 132.52c5.01,7.69 14.83,26.38 10.9,50 12.23,19.64 25.84,44.23 37.91,76.21 15.43,40.91 28.34,93.9 32.59,164.05 8.43,139.15 26.3,300.52 26.36,300.99l-8.9 0.95c-0.05,-0.47 -17.95,-162.05 -26.39,-301.41 -4.19,-69.11 -16.87,-121.23 -32.03,-161.42 -10.46,-27.74 -22.12,-49.81 -32.97,-67.87 -11.69,25.15 -46.54,32.88 -60.3,31.22 0,0 7.39,-21.36 26.38,-35.61 18.99,-14.24 -34.02,-32.18 -48.79,33.5 0,0 -17.36,-0.38 -44.69,-16.34 11.21,-15.23 54.9,-71.68 91.8,-79.27 13.37,2.8 23.04,4.3 28.14,5zm-123.8 71.95c-11.63,-7.19 -24.9,-17.14 -39.29,-30.93 0,0 33.76,-24 51.43,-32.18 3.94,-1.82 6.23,-3.74 7.22,-5.53 0.4,-0.74 0.59,-1.45 0.57,-2.14 -0.14,-5.14 -11.54,-8.37 -24.93,-3.67 -19.52,6.86 -41.67,17.93 -50.64,27.17 0,0 -14.95,-14.16 -27.28,-30.46 13.73,-5.9 46.68,-16.9 105.36,-19.32 1.37,0.46 2.74,0.91 4.09,1.36 23.42,7.71 43.79,13.08 60.01,16.77 -36.68,13.59 -76.29,64.98 -86.55,78.94zm-85.63 -81.43c-0.55,-0.76 -1.08,-1.53 -1.61,-2.3 -3.4,-4.95 -6.39,-9.96 -8.49,-14.72 0,0 8.59,-1.25 17.61,-3.44 10.4,-2.52 21.36,-6.28 20.37,-10.8 -0.81,-3.7 -4.42,-6.8 -10.79,-8.26 -8.15,-1.86 -20.83,-1.06 -38,4.57 0,0 -20.04,-38.77 -21.36,-44.84 -0.46,-2.1 -0.09,-3.88 0.82,-5.27 21.98,13.27 43.46,24.73 64.03,34.61 26.53,12.75 51.57,22.88 74.23,30.91 -53.49,3.36 -83.97,13.91 -96.81,19.53zm-37.55 -87.92c1.59,-0.53 3.43,-0.65 5.29,-0.31 5.8,1.06 22.42,11.6 51.17,8.44 0,0 5.79,9.17 11.47,13.81 1.59,1.3 3.18,2.25 4.62,2.54 5.68,1.14 7.25,-7.71 1.67,-15.07 -0.9,-1.18 -1.98,-2.33 -3.26,-3.39 0,0 2.1,-0.44 5.61,-1.29 3.8,-0.92 9.25,-2.33 15.46,-4.19 14.66,33.07 29.11,52.04 37.62,61.42 -20.84,-7.6 -43.57,-16.96 -67.53,-28.47 -19.97,-9.59 -40.81,-20.68 -62.13,-33.48zm96.34 -0.79c8.37,-2.65 17.67,-6.03 26.06,-10.07 0,0 7.91,43.25 34.29,54.07 0,0 0.41,0.11 1.05,0.18 3.11,0.38 11.59,0.1 4.32,-16.31l-0.1 -0.23c-8.97,-20.04 -20.57,-40.88 -21.36,-45.89 0,0 15.49,-6.72 36.74,-11.5l1.33 -0.3c2.14,70.96 19.13,103.97 27.19,115.76 -15.3,-3.61 -33.91,-8.65 -55,-15.61 -1.04,-0.34 -2.1,-0.69 -3.15,-1.05l0.05 -0.46 -6.39 -1.7 -1.85 -0.64c-3.65,-3.1 -23.05,-20.99 -43.18,-66.26zm86.77 -30.97c8.74,-1.72 18.24,-3.02 27.9,-3.37 0,0 -7.65,53.01 14.24,63.3 0,0 17.41,7.91 6.33,-60.93 0,0 48,6.33 46.95,59.34 -0.91,45.76 -25.8,62.44 -32.59,66.14 -5.12,-0.73 -13.59,-2.1 -24.84,-4.43l-0.01 -0.77 -7.74 -0.89 -0.69 -0.15c-4.02,-4.5 -27.19,-33.99 -29.55,-118.24z"></path></g></svg>
						</div>
						<div class="icon-5">
						  <svg xmlns="http://www.w3.org/2000/svg" xml:space="preserve" version="1.1" style="shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd; clip-rule:evenodd" viewBox="0 0 513.57 1042.57" xmlns:xlink="http://www.w3.org/1999/xlink"><defs></defs><g id="Layer_x0020_1"><metadata id="CorelCorpID_0Corel-Layer"></metadata><path class="fil-leaf-5" d="M207.74 252.52c0,0 -3.36,127.53 94.31,130.89 0,0 36.92,0.67 66.79,-32.89 0,0 -39.94,-10.4 -50.01,-47.99 -10.07,-37.59 63.1,-27.52 82.23,3.36 0,0 17.47,-34.44 35.17,-77.24 -60.5,-36.51 -169.57,-35.65 -182.77,-35.4 -16.15,16.52 -28.62,31.28 -37.69,42.91l-0 -0c-3.79,4.86 -6.98,9.18 -9.61,12.86l0.02 -0.03c-0.48,0.66 -0.93,1.31 -1.37,1.93l-0.05 0.08 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.7 1 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07 -0.05 0.07c1.63,-0.35 3.25,-0.73 4.87,-1.16zm202.05 -202.04c0,0 -10.74,-24.5 15.1,-37.92 25.84,-13.42 40.95,2.68 38.93,7.72 -2.01,5.03 -36.92,38.6 -54.03,30.21zm41.95 28.86c0,0 3.69,-24.84 23.16,-20.14 19.47,4.7 -2.35,24.16 -6.71,25.51 -4.36,1.34 -17.79,3.36 -16.45,-5.37zm-13.33 143.98c6.34,-15.57 12.61,-32.08 18.03,-48.32 0,0 -14.77,-5.71 -43.63,-9.06 -28.86,-3.36 -48.67,-8.06 -47.99,-20.47 0.67,-12.42 19.47,-12.42 31.21,-12.08 11.75,0.34 44.3,9.4 65.45,21.48 0,0 6.06,-15.02 14,-34.26 -13.59,-6.7 -55.53,-24.2 -111.04,-17.16 -44.54,28.56 -79.28,58.2 -105.29,84.07 26.84,-0.04 122.78,2.26 179.27,35.82zm39.24 -107.98c11.26,-27.2 25.32,-60.47 31.48,-72.24 2.59,-4.94 4.04,-8.91 4.44,-12.19l-0.07 0.03c-7.86,2.78 -15.55,5.64 -23.08,8.58l-0.06 0.03c-43.75,17.09 -81.99,36.73 -115.12,57.12 50.7,-3.62 88.86,12.06 102.42,18.68zm-266.36 117.31l-0 0 0.19 -0.24c1.61,-2.06 3.33,-4.22 5.15,-6.47l0.6 -0.74c1.8,-2.22 3.71,-4.51 5.72,-6.89l0.53 -0.62c0.65,-0.77 1.31,-1.54 1.99,-2.33l0.45 -0.53c0.8,-0.93 1.62,-1.87 2.44,-2.82l-0.47 -0.16c26.43,-78.83 20.84,-169.24 18.14,-197.94 -29.06,6.17 -63.45,14.58 -92.65,24.81 0,0 -10.74,27.18 -8.73,47.66 2.01,20.47 10.4,39.6 17.79,47.99 7.38,8.39 -4.03,19.8 -14.1,11.08 -10.07,-8.73 -33.9,-27.86 -31.88,-85.58 0,0 -51.69,29.87 -54.37,96.99 -2.41,60.36 60.31,104.42 124.22,99.27 -29.57,40.64 -52.99,92.96 -71.11,145.44 -34.37,99.52 -49.74,199.84 -51.89,221.41 -1.69,16.94 -9.22,61.56 -18.01,108.82 -8.48,45.59 -18.12,93.5 -24.81,121.32 -13.86,57.6 -20.46,188.53 -20.47,188.9l11.37 0.54c0.02,-0.37 6.56,-130.3 20.16,-186.81 6.77,-28.15 16.45,-76.26 24.95,-121.9 8.84,-47.51 16.42,-92.5 18.15,-109.76 2.13,-21.29 17.32,-120.37 51.32,-218.82 17.84,-51.67 40.86,-103.1 69.86,-142.81 3.19,-7.16 11.12,-24.22 15.49,-29.83zm25.46 -30.01c1.38,-1.51 2.8,-3.04 4.25,-4.58l0.29 -0.31c0.84,-0.89 1.69,-1.8 2.55,-2.7l0.67 -0.7c2.7,-2.84 5.52,-5.73 8.45,-8.67l0.65 -0.65c0.97,-0.98 1.96,-1.96 2.96,-2.95l0.38 -0.38c3.13,-3.09 6.39,-6.23 9.77,-9.41l0.58 -0.54c4.62,-4.35 9.48,-8.77 14.57,-13.25l0.68 -0.6c3.78,-3.32 7.7,-6.68 11.74,-10.06l0.29 -0.24c5.54,-4.63 11.33,-9.29 17.36,-13.99l0.57 -0.44c6.07,-4.71 12.39,-9.44 18.97,-14.18l0.24 -0.17c4.93,-3.55 10.01,-7.1 15.23,-10.64l0.24 -0.16c4.13,-2.8 8.36,-5.6 12.68,-8.38 1.65,-4.78 23.49,-68.56 28.59,-99.33 -14.9,-0.31 -31.83,-0.37 -51.18,-0.15 0,0 -12.75,35.24 -9.73,54.03 3.02,18.79 9.73,34.9 -0.34,37.25 -10.07,2.35 -31.21,-20.47 -17.79,-89.27 0,0 -24.82,3.76 -57.81,10.6 2.58,27.06 8.08,112.25 -14.87,189.88zm130.78 -107.89l1.53 -0.95 0.35 -0.22c7.57,-4.71 15.41,-9.39 23.53,-14l0.16 -0.09c6.06,-3.44 12.27,-6.86 18.63,-10.22l0.29 -0.16c8.49,-4.49 17.26,-8.91 26.3,-13.23l0.6 -0.29c6.76,-3.22 13.68,-6.39 20.75,-9.5l0.12 -0.05c2.34,-1.03 4.7,-2.05 7.07,-3.06l0.5 -0.21c7,-2.98 14.15,-5.89 21.45,-8.74l1.17 -0.46c2.38,-0.92 4.78,-1.84 7.19,-2.75l0.09 -0.03c5.13,-1.93 10.34,-3.82 15.61,-5.68l0.07 -0.03c-2.61,-6.39 -11.96,-9.39 -26.62,-13.87 -18.07,-5.52 -44.02,-9.54 -92.15,-10.8 -4.31,26.52 -20.49,76.07 -26.62,94.33z"></path></g></svg>
						</div>
					  </button>
				</div>
		 
		</div>
	</div>

	<!-- 2 intro -->
	<div id="main-intro-aboutus" class="main-intro">
		<div class="container">
			<div class="item-desc-intro">
				<div class="img-first"  data-aos="fade-in" data-aos-delay="100">
					<img src="https://www.countryandtownhouse.com/wp-content/uploads/2019/07/Mirazur-@-Anthony-Lanneretonne-2015-7.png" alt="">
				</div>
				<div class="text-desc">
					<h2 class="">Bistrot Dupont</h2>
					<p class=" ">Le Bistrot DuPont, repris en 2006 par le chef Yves Brouillet, propose une cuisine bistrot où les abats, les produits du terroir et les anciennes recettes sont remises au goût du jour.</p>
					<p><a href="error.html" class="btn-read btn btn-outline-secondary py-2">Read more</a></p>
				</div>
			</div>

			<div class="item-desc-intro">
				<div class="img-first img-first-secondchild"  data-aos="fade-in" data-aos-delay="100"  >
					<img src="https://www.langhe-experience.it/46678-zoom_default/osteria-dell039enoteca.jpg?t=1654699931" alt="">
				</div>
				<div class="text-desc text-first-secondchild">
					<h2  >TUSCAN CUISINE</h2 >
					<p>A refined Tuscan menu prepared with fresh, local ingredients brought to you by Chef Nicola Chiappi, paired to our carefully curated wine selection.</p>
					<p><a href="error.html" class="btn-read btn btn-outline-secondary py-2">Read more</a></p>
				</div>
			</div>
		</div>

	</div>

	<!-- potential  -->
	<div class="section sec-features" >
		<div class="container">
			<div class="row g-5">
				<div class="col-12 col-sm-6 col-md-6 col-lg-4" data-aos="fade-up" data-aos-delay="0">
					<div class="feature d-flex">
						<span class="icon-potential"><i class="fa-solid fa-bowl-food"></i></span>
						<div class="desc-potential">
							<h3>Delicious Food </h3>
							<p> Enjoy excellent dishes with rich, attractive flavors. We are proud to bring you dishes, not only delicious but also beautiful.</p>
						</div>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-md-6 col-lg-4" data-aos="fade-up" data-aos-delay="100">
					<div class="feature d-flex">
						<span class="icon-potential"><i class="fa-solid fa-truck"></i></span>
						<div class="desc-potential">
							<h3>Fast shipping</h3>
							<p>We are committed to delivering goods to you as quickly as possible. With professional and flexible delivery service.</p>
						</div>
					</div>
				</div>
				<div class="col-12 col-sm-6 col-md-6 col-lg-4" data-aos="fade-up" data-aos-delay="200">
					<div class="feature d-flex">
						<span class="icon-potential"><i class="fa-solid fa-money-bill"></i></span>
						<div class="desc-potential">
							<h3>Good price</h3>
							<p>We always bring you delicious food at affordable prices. Enjoy quality meals without worrying about price.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- team member -->
	<div class="section" style="background:url('https://phantom-elmundo.unidadeditorial.es/7205581f96b6229f2055cc5f98001d01/crop/0x66/3071x2109/resize/1200/f/webp/assets/multimedia/imagenes/2023/10/17/16975564023530.jpg') no-repeat center; background-size: cover; object-fit: cover;">
		<div class="container">
			
			<div class="row item-first">
				<div class="col-lg-12  title-heading" data-aos="fade-up">
					<h2 class="">Our Team</h2>
					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
				</div>
			</div>

			<div class="row row-contain-team">
				
				<div class="card">
					<div class="content">
					  <div class="back">
						<div class="back-content">
						  <svg stroke="#ffffff" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" height="50px" width="50px" fill="#ffffff">
				  
						  <g stroke-width="0" id="SVGRepo_bgCarrier"></g>
				  
						  <g stroke-linejoin="round" stroke-linecap="round" id="SVGRepo_tracerCarrier"></g>
				  
						  <g id="SVGRepo_iconCarrier">
				  
						  <path d="M20.84375 0.03125C20.191406 0.0703125 19.652344 0.425781 19.21875 1.53125C18.988281 2.117188 18.5 3.558594 18.03125 4.9375C17.792969 5.636719 17.570313 6.273438 17.40625 6.75C17.390625 6.796875 17.414063 6.855469 17.40625 6.90625C17.398438 6.925781 17.351563 6.949219 17.34375 6.96875L17.25 7.25C18.566406 7.65625 19.539063 8.058594 19.625 8.09375C22.597656 9.21875 28.351563 11.847656 33.28125 16.78125C38.5 22 41.183594 28.265625 42.09375 30.71875C42.113281 30.761719 42.375 31.535156 42.75 32.84375C42.757813 32.839844 42.777344 32.847656 42.78125 32.84375C43.34375 32.664063 44.953125 32.09375 46.3125 31.625C47.109375 31.351563 47.808594 31.117188 48.15625 31C49.003906 30.714844 49.542969 30.292969 49.8125 29.6875C50.074219 29.109375 50.066406 28.429688 49.75 27.6875C49.605469 27.347656 49.441406 26.917969 49.25 26.4375C47.878906 23.007813 45.007813 15.882813 39.59375 10.46875C33.613281 4.484375 25.792969 1.210938 22.125 0.21875C21.648438 0.0898438 21.234375 0.0078125 20.84375 0.03125 Z M 16.46875 9.09375L0.0625 48.625C-0.09375 48.996094 -0.00390625 49.433594 0.28125 49.71875C0.472656 49.910156 0.738281 50 1 50C1.128906 50 1.253906 49.988281 1.375 49.9375L40.90625 33.59375C40.523438 32.242188 40.222656 31.449219 40.21875 31.4375C39.351563 29.089844 36.816406 23.128906 31.875 18.1875C27.035156 13.34375 21.167969 10.804688 18.875 9.9375C18.84375 9.925781 17.8125 9.5 16.46875 9.09375 Z M 17 16C19.761719 16 22 18.238281 22 21C22 23.761719 19.761719 26 17 26C15.140625 26 13.550781 24.972656 12.6875 23.46875L15.6875 16.1875C16.101563 16.074219 16.550781 16 17 16 Z M 31 22C32.65625 22 34 23.34375 34 25C34 25.917969 33.585938 26.730469 32.9375 27.28125L32.90625 27.28125C33.570313 27.996094 34 28.949219 34 30C34 32.210938 32.210938 34 30 34C27.789063 34 26 32.210938 26 30C26 28.359375 26.996094 26.960938 28.40625 26.34375L28.3125 26.3125C28.117188 25.917969 28 25.472656 28 25C28 23.34375 29.34375 22 31 22 Z M 21 32C23.210938 32 25 33.789063 25 36C25 36.855469 24.710938 37.660156 24.25 38.3125L20.3125 39.9375C18.429688 39.609375 17 37.976563 17 36C17 33.789063 18.789063 32 21 32 Z M 9 34C10.65625 34 12 35.34375 12 37C12 38.65625 10.65625 40 9 40C7.902344 40 6.960938 39.414063 6.4375 38.53125L8.25 34.09375C8.488281 34.03125 8.742188 34 9 34Z"></path>
				  
						  </g>
				  
						  </svg>
						  <strong>TEAM MEMBER</strong>
						</div>
					  </div>
					  <div class="front">
						
						<div class="img">
						   <img src="https://scontent.fsgn5-5.fna.fbcdn.net/v/t1.6435-9/40358200_107268636894376_6141089452665077760_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=d3tAEeVYaMgQ7kNvgFFruQs&_nc_ht=scontent.fsgn5-5.fna&oh=00_AYAthdatXpZtR8WQEwORIyoluJmj4t-QjTKf0K8hG9fk8w&oe=66A66FAD" alt="" style="width: 100%; height: 100%; background-position: center; background-size: cover; object-fit: cover; background-repeat: no-repeat;">
						</div>
				  
						<div class="front-content">
						  <small class="badge">Backend</small>
						  <div class="description">
							<div class="title">
							  <p class="title">
								<strong>DAO NGOC HOANG</strong>
							  </p>
							  <svg fill-rule="nonzero" height="15px" width="15px" viewBox="0,0,256,256" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g style="mix-blend-mode: normal" text-anchor="none" font-size="none" font-weight="none" font-family="none" stroke-dashoffset="0" stroke-dasharray="" stroke-miterlimit="10" stroke-linejoin="miter" stroke-linecap="butt" stroke-width="1" stroke="none" fill-rule="nonzero" fill="#20c997"><g transform="scale(8,8)"><path d="M25,27l-9,-6.75l-9,6.75v-23h18z"></path></g></g></svg>
							</div>
							<p class="card-footer">
							  30 Mins &nbsp; | &nbsp; 1 Serving
							</p>
						  </div>
						</div>
					  </div>
					</div>
				  </div>
				  <!-- <div class="space-betw"></div> -->
				 

				  <div class="card">
					<div class="content">
					  <div class="back">
						<div class="back-content">
						  <svg stroke="#ffffff" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" height="50px" width="50px" fill="#ffffff">
				  
						  <g stroke-width="0" id="SVGRepo_bgCarrier"></g>
				  
						  <g stroke-linejoin="round" stroke-linecap="round" id="SVGRepo_tracerCarrier"></g>
				  
						  <g id="SVGRepo_iconCarrier">
				  
						  <path d="M20.84375 0.03125C20.191406 0.0703125 19.652344 0.425781 19.21875 1.53125C18.988281 2.117188 18.5 3.558594 18.03125 4.9375C17.792969 5.636719 17.570313 6.273438 17.40625 6.75C17.390625 6.796875 17.414063 6.855469 17.40625 6.90625C17.398438 6.925781 17.351563 6.949219 17.34375 6.96875L17.25 7.25C18.566406 7.65625 19.539063 8.058594 19.625 8.09375C22.597656 9.21875 28.351563 11.847656 33.28125 16.78125C38.5 22 41.183594 28.265625 42.09375 30.71875C42.113281 30.761719 42.375 31.535156 42.75 32.84375C42.757813 32.839844 42.777344 32.847656 42.78125 32.84375C43.34375 32.664063 44.953125 32.09375 46.3125 31.625C47.109375 31.351563 47.808594 31.117188 48.15625 31C49.003906 30.714844 49.542969 30.292969 49.8125 29.6875C50.074219 29.109375 50.066406 28.429688 49.75 27.6875C49.605469 27.347656 49.441406 26.917969 49.25 26.4375C47.878906 23.007813 45.007813 15.882813 39.59375 10.46875C33.613281 4.484375 25.792969 1.210938 22.125 0.21875C21.648438 0.0898438 21.234375 0.0078125 20.84375 0.03125 Z M 16.46875 9.09375L0.0625 48.625C-0.09375 48.996094 -0.00390625 49.433594 0.28125 49.71875C0.472656 49.910156 0.738281 50 1 50C1.128906 50 1.253906 49.988281 1.375 49.9375L40.90625 33.59375C40.523438 32.242188 40.222656 31.449219 40.21875 31.4375C39.351563 29.089844 36.816406 23.128906 31.875 18.1875C27.035156 13.34375 21.167969 10.804688 18.875 9.9375C18.84375 9.925781 17.8125 9.5 16.46875 9.09375 Z M 17 16C19.761719 16 22 18.238281 22 21C22 23.761719 19.761719 26 17 26C15.140625 26 13.550781 24.972656 12.6875 23.46875L15.6875 16.1875C16.101563 16.074219 16.550781 16 17 16 Z M 31 22C32.65625 22 34 23.34375 34 25C34 25.917969 33.585938 26.730469 32.9375 27.28125L32.90625 27.28125C33.570313 27.996094 34 28.949219 34 30C34 32.210938 32.210938 34 30 34C27.789063 34 26 32.210938 26 30C26 28.359375 26.996094 26.960938 28.40625 26.34375L28.3125 26.3125C28.117188 25.917969 28 25.472656 28 25C28 23.34375 29.34375 22 31 22 Z M 21 32C23.210938 32 25 33.789063 25 36C25 36.855469 24.710938 37.660156 24.25 38.3125L20.3125 39.9375C18.429688 39.609375 17 37.976563 17 36C17 33.789063 18.789063 32 21 32 Z M 9 34C10.65625 34 12 35.34375 12 37C12 38.65625 10.65625 40 9 40C7.902344 40 6.960938 39.414063 6.4375 38.53125L8.25 34.09375C8.488281 34.03125 8.742188 34 9 34Z"></path>
				  
						  </g>
				  
						  </svg>
						  <strong>TEAM MEMBER</strong>
						</div>
					  </div>
					  <div class="front">
						
						<div class="img">
						   <img src="https://scontent.fsgn5-10.fna.fbcdn.net/v/t1.6435-9/120846118_1393138717744114_5343318628172679837_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=1d70fc&_nc_ohc=prvkm_vxokIQ7kNvgF0gsqw&_nc_ht=scontent.fsgn5-10.fna&oh=00_AYCjBTU0oatrqhiC5twX0bx_X0W76dXvPee0a4502-OL9g&oe=66A67560" alt="" style="width: 100%; background-position: center; background-size: cover; object-fit: cover; background-repeat: no-repeat;">
						</div>
				  
						<div class="front-content">
						  <small class="badge">Backend-Frontend</small>
						  <div class="description">
							<div class="title">
							  <p class="title">
								<strong>HUYNH NGOC KHANH</strong>
							  </p>
							  <svg fill-rule="nonzero" height="15px" width="15px" viewBox="0,0,256,256" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g style="mix-blend-mode: normal" text-anchor="none" font-size="none" font-weight="none" font-family="none" stroke-dashoffset="0" stroke-dasharray="" stroke-miterlimit="10" stroke-linejoin="miter" stroke-linecap="butt" stroke-width="1" stroke="none" fill-rule="nonzero" fill="#20c997"><g transform="scale(8,8)"><path d="M25,27l-9,-6.75l-9,6.75v-23h18z"></path></g></g></svg>
							</div>
							<p class="card-footer">
							  30 Mins &nbsp; | &nbsp; 1 Serving
							</p>
						  </div>
						</div>
					  </div>
					</div>
				  </div>
			</div>

		</div>
	</div>
     
	<script src="./assets/js/footer.js"></script>
	<style>
	button {
		position: relative;
		padding: 4px 10px;
		background: #f5ddb7;
		font-size: 17px;
		font-weight: 900;
		color: #181818;
		border: none;
		border-radius: 8px;
		box-shadow: 2px 2px 5px #18181869, inset 2px 2px 10px #ffffffb0;
		transition: all .3s ease-in-out;
	  }
	  
	  .icon-1 {
		position: absolute;
		top: 10%;
		left: 50%;
		transform: translate(-50%, 0);
		width: 0px;
		height: auto;
		transition: all .5s ease-in-out;
		z-index: -1;
	  }
	  
	  .icon-2 {
		position: absolute;
		top: 10%;
		left: 50%;
		transform: translate(-50%, 0);
		width: 0px;
		height: auto;
		transition: all .5s ease-in-out;
		z-index: -2;
	  }
	  
	  .icon-3 {
		position: absolute;
		top: 10%;
		left: 50%;
		transform: translate(-50%, 0);
		width: 0px;
		height: auto;
		transition: all .5s ease-in-out;
		z-index: -2;
	  }
	  
	  .icon-4 {
		position: absolute;
		top: 10%;
		left: 50%;
		transform: translate(-50%, 0);
		width: 0px;
		height: auto;
		transition: all .5s ease-in-out;
		z-index: -2;
	  }
	  
	  .icon-5 {
		position: absolute;
		top: 10%;
		left: 50%;
		transform: translate(-50%, 0);
		width: 0px;
		height: auto;
		transition: all .5s ease-in-out;
		z-index: -2;
	  }
	  
	  button:hover {
		/* padding: 13px 25px; */
		border-radius: 8px 8px 24px 24px;
	  }
	  
	  button:hover .icon-1 {
		top: -250%;
		left: 50%;
		transform: translate(-50%, 0);
		width: 50px;
		height: auto;
		animation: inIcon1 1s ease .45s forwards;
	  }
	  
	  @keyframes inIcon1 {
		0% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  
		25% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(5deg);
		}
	  
		50% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(1deg);
		}
	  
		65% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(3deg);
		}
	  
		100% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  }
	  
	  button:hover .icon-2 {
		position: absolute;
		top: -200%;
		left: 90%;
		transform: translate(-50%, 0);
		width: 75px;
		height: auto;
		animation: inIcon2 1s ease .45s forwards;
	  }
	  
	  @keyframes inIcon2 {
		0% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  
		35% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(10deg);
		}
	  
		50% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(4deg);
		}
	  
		80% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(5deg);
		}
	  
		100% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  }
	  
	  button:hover .icon-3 {
		position: absolute;
		top: -130%;
		left: 20%;
		transform: translate(-50%, 0);
		width: 60px;
		height: auto;
		animation: inIcon3 1s ease .45s forwards;
	  }
	  
	  @keyframes inIcon3 {
		0% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  
		35% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(-2deg);
		}
	  
		100% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  }
	  
	  button:hover .icon-4 {
		position: absolute;
		top: -300%;
		left: 10%;
		transform: translate(-50%, 0);
		width: 85px;
		height: auto;
		animation: inIcon4 1s ease .45s forwards;
	  }
	  
	  @keyframes inIcon4 {
		0% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  
		40% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(-3deg);
		}
	  
		100% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  }
	  
	  button:hover .icon-5 {
		position: absolute;
		top: -350%;
		left: 90%;
		transform: translate(-50%, 0);
		width: 85px;
		height: auto;
		animation: inIcon5 1s ease .45s forwards;
	  }
	  
	  @keyframes inIcon5 {
		0% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  
		35% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(-3deg);
		}
	  
		100% {
		  transform-origin: 0 100%;
		  transform: translate(-50%, 0) rotate(0deg);
		}
	  }
	  
	  .fil-leaf-1 {
		fill: #7B9B3A
	  }
	  
	  .fil-leaf-2 {
		fill: #556729;
		fill-rule: nonzero
	  }
	  
	  .fil-leaf-3 {
		fill: #556729
	  }
	  
	  .fil-leaf-4 {
		fill: #3C4819
	  }
	  
	  .fil-leaf-5 {
		fill: #3C4819
	  }


	  .card {
  overflow: visible;
  width: 260px;
  height: 360px;
}

.content {
  width: 100%;
  height: 100%;
  transform-style: preserve-3d;
  transition: transform 300ms;
  box-shadow: 0px 0px 10px 1px #000000ee;
  border-radius: 5px;
}

.front, .back {
  background-color: #151515;
  position: absolute;
  width: 100%;
  height: 100%;
  backface-visibility: hidden;
  -webkit-backface-visibility: hidden;
  border-radius: 5px;
  overflow: hidden;
}

.back {
  width: 100%;
  height: 100%;
  justify-content: center;
  display: flex;
  align-items: center;
  overflow: hidden;
}

.back::before {
  position: absolute;
  content: ' ';
  display: block;
  width: 160px;
  height: 160%;
  background: linear-gradient(90deg, transparent, #ff9966, #ff9966, #ff9966, #ff9966, transparent);
  animation: rotation_481 5000ms infinite linear;
}

.back-content {
  position: absolute;
  width: 99%;
  height: 99%;
  background-color: #151515;
  border-radius: 5px;
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 30px;
}

.card:hover .content {
  transform: rotateY(180deg);
}

@keyframes rotation_481 {
  0% {
    transform: rotateZ(0deg);
  }

  0% {
    transform: rotateZ(360deg);
  }
}

.front {
  transform: rotateY(180deg);
  color: white;
}

.front .front-content {
  position: absolute;
  width: 100%;
  height: 100%;
  padding: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.front-content .badge {
  background-color: #00000055;
  padding: 2px 10px;
  border-radius: 10px;
  backdrop-filter: blur(2px);
  width: fit-content;
  font-size: 1.4rem;
}

.description {
  box-shadow: 0px 0px 10px 5px #00000088;
  width: 100%;
  padding: 10px;
  background-color: #00000099;
  backdrop-filter: blur(5px);
  border-radius: 5px;
}

.title {
  font-size: 11px;
  max-width: 100%;
  display: flex;
  justify-content: space-between;
}

.title p {
  width: 50%;
}

.card-footer {
  color: #ffffff88;
  /* margin-top: 5px; */
  font-size: 13px;
  padding-left: 0;
}

.front .img {
  position: absolute;
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: center;
}

.circle {
  width: 90px;
  height: 90px;
  border-radius: 50%;
  background-color: #ffbb66;
  position: relative;
  filter: blur(15px);
  animation: floating 2600ms infinite linear;
}

#bottom {
  background-color: #ff8866;
  left: 50px;
  top: 0px;
  width: 150px;
  height: 150px;
  animation-delay: -800ms;
}

#right {
  background-color: #ff2233;
  left: 160px;
  top: -80px;
  width: 30px;
  height: 30px;
  animation-delay: -1800ms;
}

@keyframes floating {
  0% {
    transform: translateY(0px);
  }

  50% {
    transform: translateY(10px);
  }

  100% {
    transform: translateY(0px);
  }
}
	  </style>
    
  </body>
  </html>

