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


<h2>Update User Info</h2>


<FORM ACTION="user/update" method="get">

    <fieldset>
        <legend>Select Volunteer</legend>
        <select name="userId">
            <c:forEach var="user" items="${users}">
                <option value="${user.id}">${user.firstName} ${user.lastName}</option>
            </c:forEach>
        </select>
    </fieldset>

    <br>

    <fieldset>
        <legend>Action</legend>
        <input type="submit" name="submit" value="Update">
        <input type="submit" name="submit" value="Delete">
    </fieldset>


</form>

<BR>

<A HREF="../admin">Back to admin home page</A>


</body>
</html>

