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

<div class="container-fluid">
    <!-- Page Content goes here -->
    <div class="row">

        <div>
             <FORM ACTION= "update/status" method="post">

                <br>
                <fieldset>
                    <legend>Current Info</legend>

                    Id:<br>
                    <input type="text" name="userId" value="${users[0].id}" readonly > <br>
                    <br>
                    Email Address:<br>
                    <input type="text" name="emailAddress" value="${users[0].emailAddress}"><br>
                    <br>
                    First Name:<br>
                    <input type="text" name="firstName" value="${users[0].firstName}"><br>
                    <br>
                    Last Name:<br>
                    <input type="text" name="lastName" value="${users[0].lastName}"><br>
                    <br>
                    Skill Level:<br>
                    <input type="text" name="skillLevel" value="${users[0].skillLevel}" readonly><br>
                    <br>
                    User Name:<br>
                    <input type="text" name="userName" value="${users[0].userName}"><br>

                </fieldset>

                <input type="submit" name="submit" value="Update">
            </FORM>

            <Br><br>
            <a href="/doorCreekCafe/vol">Back to Volunteer Dashboard</a>
        </div>

    </div>
</div>


<footer>
<%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>


</body>
</html>

