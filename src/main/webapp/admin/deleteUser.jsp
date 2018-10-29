<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<h3>Please Select Volunteer you would like to remove from the database</h3>


<FORM ACTION="userUpdateStatus">

    <select name="removeUserId">
        <c:forEach var="user" items="${users}">
            <option value="${user.id}">${user.firstName} ${user.lastName}</option>
        </c:forEach>
    </select>

    <input type="submit" name="submit" value="delete">

</form>

<BR>

<A HREF="../admin">Back to admin home page</A>


</body>
</html>

