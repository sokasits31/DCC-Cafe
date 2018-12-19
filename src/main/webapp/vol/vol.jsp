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

            <div class="col-4">
                Welcome ${userName}!
                <br>
                <br>
                <ul>
                    <li><A HREF="./vol/responseTimes">View Menu Item Response Times</A></li>
                    <br>
                    <li><A HREF="simulator/settings">Start a New Simulator test</A></li>
                    <br>
                    <li><A HREF="vol/update">Update Info</A></li>
                </ul>
            </div>
            <div class="col-8">
                <%@ include file="/vol/content/home.jsp"%>
            </div>
            <a class="nav-link active" href="/doorCreekCafe/vol">vol home page</A>
        </div>
    </div>
</div>

<br>

<footer>
<%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>


</body>
</html>

