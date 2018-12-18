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

<div class="container-fluid">
    <!-- Page Content goes here -->
    <div class="row">

        <div class="col-2">
            Links:
            <br>
            <ul>
            <li><A HREF="vol/simulatorScores">My Simulator Scores</A></li>
            <li><A HREF="simulator/settings">Start New Simulator</A></li>
            <li><A HREF="vol/update">Update My Infor</A></li>
            </ul>
        </div>
        <div class="col-10">
            <%@ include file="/vol/content/home.jsp"%>
        </div>
    </div>

<br>


<footer>
<%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>


</body>
</html>

