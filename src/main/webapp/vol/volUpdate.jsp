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
            </ul>
        </div>
        <div class="col-10">
            <h4>Current user profile:</h4>

            <FORM ACTION= "vol/dataBaseStatus" method="post">

                <br>
                <fieldset>
                    <legend>Current Info</legend>

                    Id:<br>
                    <input type="text" name="userId" value="${users[0].id}" readonly > <br>

                    Email Address:<br>
                    <input type="text" name="emailAddress" value="${users[0].emailAddress}"><br>

                    First Name:<br>
                    <input type="text" name="firstName" value="${users[0].firstName}"><br>

                    Last Name:<br>
                    <input type="text" name="lastName" value="${users[0].lastName}"><br>

                    Skill Level:<br>
                    <input type="text" name="skillLevel" value="${users[0].skillLevel}" readonly><br>

                    User Name:<br>
                    <input type="text" name="userName" value="${users[0].userName}"><br>

                </fieldset>

                <input type="submit" name="submit" value="Update">
            </FORM>
        </div>

<br>


<footer>
<%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>


</body>
</html>

