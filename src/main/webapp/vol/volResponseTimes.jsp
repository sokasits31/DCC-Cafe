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

<h1>Test Simulator Response Times</h1>

<div class="container-fluid">
    <!-- Page Content goes here -->
    <div class="row">

        <div class="col-12">
            <%@ include file="/vol/content/responseTimes.jsp"%>
        </div>
    </div>
    <Br><br>
    <a href="/doorCreekCafe/vol">Back to Volunteer Dashboard</a>

<br>


<footer>
<%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>


</body>
</html>

