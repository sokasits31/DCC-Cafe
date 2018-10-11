<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<h1>Admin Dashboard</h1>
<br>
<H3>Test Taken my Volunteers</H3>
<div class="container-fluid">
    <c:choose>



        <c:when test = "${users[0].id > 0}">
            <table border="2" cellpadding="2">
                <tr>
                    <th>ID</th>
                    <th>Role</th>
                    <th>Email Address</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Skill Level</th>
                    <th>Test Scores</th>

                </tr>

                <td>${users.id}</td>
                <td>${users.role}</td>
                <td>${users.emailAddress}</td>
                <td>${users.firstName}</td>
                <td>${users.lastName}</td>
                <td>${users.skillLevel}</td>

                <td>
                <c:forEach var="test" items="${testScores}">
                    <tr>
                        <td>${test.testDate}</td>
                        <td>${test.menuIdTested}</td>
                        <td>${test.responseTimeInSeconds}</td>
                    </tr>
                </c:forEach>
                </td>
            </table>
        </c:when>

        <c:otherwise>
            <H4>No User Data Found....   Go back and try again</H4>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
