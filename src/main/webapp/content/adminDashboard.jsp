<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<h1>Admin Dashboard</h1>
<br>
<H3>Test Taken my Volunteers</H3>
<div class="container-fluid">
    <c:choose>

        <c:when test = "${userTests[0].id > 0}">
            <table border="2" cellpadding="2">
                <tr>
                    <th>ID</th>
                    <th>User ID</th>
                    <th>Test Date</th>
                    <th>Test Level</th>
                    <th>Menu ID Tested</th>
                    <th>Response Time</th>
                    <th>Test Scores</th>

                </tr>

                <c:forEach var="userTest" items="${userTests}">
                    <tr>
                        <td>${userTest.id}</td>
                        <td>${userTest.userId}</td>
                        <td>${userTest.testDate}</td>
                        <td>${userTest.testLevel}</td>
                        <td>${userTest.menuIdTested}</td>
                        <td>${userTest.responseTimeInSeconds}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <c:otherwise>
            <H4>No User Data Found....   Go back and try again</H4>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>

