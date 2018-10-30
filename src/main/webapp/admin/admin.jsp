<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<h1>Admin Dashboard</h1>

<br>

<H3>Good morning Heather...</H3>

<h4>Current Administrators</h4>
<table border="1" cellpadding="1">
    <!-- row 1 data -->
    <tr>
        <td>ID</td>
        <th>Email Address</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Skill Level</th>
        <th>Primary Phone Number</th>
        <th>User ID</th>
    </tr>
    <c:forEach var="adminUser" items="${adminUsers}">
    <tr>
        <td>${adminUser.id}</td>
        <td>${adminUser.emailAddress}</td>
        <td>${adminUser.firstName}</td>
        <td>${adminUser.lastName}</td>
        <td>${adminUser.skillLevel}</td>
        <td>${adminUser.primaryPhoneNumber}</td>
        <td>${adminUser.userName}</td>
    </tr>
    </c:forEach>
</table>

<br>
<H3>User Maintenance</H3>
<ul>

    <li><A HREF="admin/userUpdate">Update User</A></li>
    <li><A HREF="admin/userDelete">Delete User</A></li>
    <li><A HREF="admin/userInsert">Insert New User</A></li>
    <li><A HREF="admin/userPasswordReset">Reset User Password</A></li>

</ul>

<!--
    <c:choose>

            <c:when test = "${users[0].id > 0}">
                <table border="2" cellpadding="2">

                    <tr>
                        <td>ID</td>
                        <th>Role</th>
                        <th>Email Address</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Skill Level</th>
                        <th>Test Scores</th>
                    </tr>


                    <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.emailAddress}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.skillLevel}</td>
                        <td>${user.primaryPhoneNumber}</td>
                        <td>${user.userName}</td>
                        <td>
                        <table>
                            <c:forEach var="testScore" items="${user.testScores}">
                                <tr>
                                    <td>${testScore.testDate}</td>
                                    <td>${testScore.testLevel}</td>
                                    <td>${testScore.menuIdTested}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        </td>
                    </tr>
                    </c:forEach>

                </table>
            </c:when>

        <c:otherwise>
            <H4>No User Data Found....   Go back and try again</H4>
        </c:otherwise>

    </c:choose>

-->


</body>
</html>

