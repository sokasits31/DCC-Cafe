<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<!--
<FORM ACTION= "select/status" method="get">
-->

<FORM ACTION= "dataBaseStatus" method="get">
<c:choose>

    <c:when test = "${action == 'Update'}">
    <h1>Update User</h1>
    <br>

    <fieldset>
    <legend>Update User Info</legend>

        Id:<br>
        <input type="text" name="userId" value="${userId}" readonly > <br>

        Email Address:<br>
        <input type="text" name="emailAddress" value="${emailAddress}"><br>

        First Name:<br>
        <input type="text" name="firstName" value="${firstName}"><br>

        Last Name:<br>
        <input type="text" name="lastName" value="${lastName}"><br>

        Skill Level:<br>
        <input type="text" name="skillLevel" value="${skillLevel}"><br>

        User Name:<br>
        <input type="text" name="userName" value="${userName}"><br>
    </fieldset>
    <input type="submit" name="submit" value="Update">
    </c:when>


    <c:when test = "${action == 'Delete'}">

        <h1>Delete User</h1>
        <br>

        <fieldset>
            <legend>User to Delete</legend>

            Id:<br>
            <input type="text" name="userId" value="${userId}" readonly > <br>

            Email Address:<br>
            <input type="text" name="emailAddress" value="${emailAddress}" readonly><br>

            First Name:<br>
            <input type="text" name="firstName" value="${firstName}" readonly><br>

            Last Name:<br>
            <input type="text" name="lastName" value="${lastName}" readonly><br>

            Skill Level:<br>
            <input type="text" name="skillLevel" value="${skillLevel}" readonly><br>

            User Name:<br>
            <input type="text" name="userName" value="${userName}" readonly><br>
        </fieldset>
        <input type="submit" name="submit" value="Delete">
    </c:when>

    <c:otherwise>
        <H4>Error!!!! </H4>
    </c:otherwise>

</c:choose>


</form>

<BR>

<A HREF="../../admin">Back to admin home page</A>


</body>
</html>

