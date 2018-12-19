<!doctype html>
<html lang="en">
<head>
    <%@ include file="/jsp/head-tag.jsp"%>
</head>

<body>
<header>
    <%@ include file="/jsp/header.jsp"%>
</header>

<div class="container-fluid">
    <!-- Page Content goes here -->
    <div class="row">

        <div class="col-2">


            Guest Links (no login required)
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="/doorCreekCafe/simulator/settings">Start Test Simulator</A>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="registerScreens">View Current Register Screens</A>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="menuItems">View Current Menu Items</A>
                </li>
            </ul>
        </div>


        <div class="col-4">
            Thanks for showing interest in volunteering to help out in the cafe.  To help with
            make you first day a success, please create a login id.  This logon id will allow the
            cafe manager access to your email and phone information.  It will also allow you
            to practice entering orders in on a register simulator.  The goal of the simulator
            is to to allow voluenteers to establish/refresh skills on the register.
        </div>

        <div class="col-6">
            <img src="images/cafeImage1.png" alt="picture of cafe" class="img-fluid rounded">
        </div>

    </div>
    <!-- Page Content goes here -->
</div>

<footer>
    <%@ include file="/jsp/footer.jsp"%>
</footer>

<%@ include file="/jsp/bootstrampJavaScript.jsp"%>

</body>

</html>
