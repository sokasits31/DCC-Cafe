<table border="1" cellpadding="1">
    <!-- row 1 data -->
    Current Info on System...

    <tr>
        <td>ID</td>
        <th>Email Address</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Skill Level</th>
        <th>Primary Phone Number</th>
        <th>User ID</th>
        <th>Role</th>
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
                <c:forEach var="role" items="${user.roles}">
                    ${role.roleName}
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>