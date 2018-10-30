<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<H2>Current Volunteers</H2>

<form>

    <c:choose>

            <c:when test = "${users[0].id > 0}">
                <table border="2" cellpadding="2">
                    <!-- row 1 data -->
                    <tr>
                        <td>ID</td>
                        <th>Email Address</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Skill Level</th>
                        <th>Primary Phone Number</th>
                        <th>User ID</th>
                        <th>Select</th>
                    </tr>

                    <!-- row 2 and more data-->
                    <c:forEach var="user" items="${users}" varStatus="status">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.emailAddress}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.skillLevel}</td>
                        <td>${user.primaryPhoneNumber}</td>
                        <td>${user.userName}</td>
                        <td><input type="radio" name="radioButton" value="${status.count}">
                    </tr>
                    </c:forEach>
                </table>
                <input type="submit" name="submit" value="Update">
                <input type="submit" name="submit" value="Insert">
                <input type="submit" name="submit" value="Delete">

            </c:when>

        <c:otherwise>
            <H4>No User Data Found....   Go back and try again</H4>
        </c:otherwise>

    </c:choose>
</form>


<BR>
<A HREF="../admin">Back to Admin Home Page</A>

</body>
</html>

