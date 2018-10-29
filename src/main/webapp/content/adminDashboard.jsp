<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<h1>Admin Dashboard</h1>

<br>

<H3>Good morning Heather, what would you like to do?</H3>


<H3>Volunteer List Maintenance</H3>
<ul>
    <li><A HREF="deleteUser">Remove a Volunteer</A></li>
    <li><A HREF="updateUser">View Volunteer Info</A></li>
    <li><A HREF="insertUser">View Volunteer Test Scores</A></li>
    <li><A HREF="changeUser">Update your user profile</A></li>
</ul>

<H3>Volunteer Info</H3>
<ul>
    <li><A HREF="deleteUser">View All Volunteer Info</A></li>
    <li><A HREF="updateUser">View Volunteer training progression</A></li>
</ul>






    <c:choose>

            <c:when test = "${users[0].id > 0}">
                <table border="2" cellpadding="2">
                    <!-- row 1 data -->
                    <tr>
                        <td>ID</td>
                        <th>Role</th>
                        <th>Email Address</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Skill Level</th>
                        <th>Test Scores</th>
                    </tr>

                    <!-- row 2 and more data-->
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
</div>

</body>
</html>

