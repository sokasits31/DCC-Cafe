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

<h1>Admin Dashboard</h1>

<br>

<H3>Good morning Heather...</H3>

<h4>Here's a list of current site users...</h4>
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

<br>
<H3>User Maintenance</H3>
<ul>

    <li><A HREF="admin/user">Update or Delete User</A></li>
    <li><A HREF="admin/user/insert">Add New User</A></li>
    <li><A HREF="admin/user/passwordReset">Reset User Password</A></li>

</ul>

<H3>Menu Maintenance</H3>
<ul>

    <li><A HREF="admin/menu">Update or Delete Menu Item</A></li>
    <li><A HREF="admin/menu/insert">Add Nem Menu Item</A></li>

</ul>



</body>
</html>

