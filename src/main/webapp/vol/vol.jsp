<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <%@ include file="/jsp/head-tag.jsp"%>
</head>

<body>

<header>
    <%@ include file="/jsp/header.jsp"%>
</header>

<h1>Volunteer Dashboard</h1>

<div class="container-fluid ">
    <!-- Page Content goes here -->
    <div class="row">

        <div class="row">

            <div class="col-2">
                Welcome ${userName}!
                <br>
                Links:
                <br>
                <ul>
                    <li><A HREF="vol/simulatorScores">View Simulator Response Times</A></li>
                    <li><A HREF="simulator/settings">Start a New Simulator test</A></li>
                    <li><A HREF="vol/simulator/settings">Start a New Simulator test</A></li>
                </ul>
            </div>
            <div class="col-10 center-pill">
                Welcome ${}
                <%@ include file="/vol/content/responseTimes.jsp"%>
            </div>
        </div>


        <br>


<footer>
<%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>


</body>
</html>

