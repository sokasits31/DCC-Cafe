<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">



<h1>Update User</h1>


<FORM ACTION= "admin/userUpdate/select/status">

    <fieldset>
    <legend>Update User Info</legend>
        Id:<br>
        ${id} <br>

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

    <input type="submit" name="submit" value="update">

</form>

<BR>

<A HREF="../admin">Back to admin home page</A>


</body>
</html>

