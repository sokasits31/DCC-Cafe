<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<h2>Delete User Info</h2>


<FORM ACTION="userDelete/Status">

    <fieldset>
        <legend>Select Volunteer</legend>
        <select name="userId">
            <c:forEach var="user" items="${users}">
                <option value="${user.id}">${user.firstName} ${user.lastName}</option>
            </c:forEach>
        </select>
    </fieldset>

    <br>

    <input type="submit" name="submit" value="Delete">

</form>

<BR>

<A HREF="../admin">Back to admin home page</A>


</body>
</html>

