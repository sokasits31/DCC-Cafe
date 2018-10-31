<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<h1>Add new User</h1>

<FORM ACTION= "dataBaseStatus" method="get">
    <fieldset>
    <legend>New User Info</legend>

        Email Address:<br>
        <input type="text" name="emailAddress" ><br>

        First Name:<br>
        <input type="text" name="firstName" ><br>

        Last Name:<br>
        <input type="text" name="lastName"><br>

        Skill Level:<br>
        <input type="text" name="skillLevel" ><br>

        User Name:<br>
        <input type="text" name="userName" ><br>

        User Role:<br>
        <input type="radio" name="role" value="admin">Admin
        <input type="radio" name="role" value="vol">Volunteer

    </fieldset>
    <input type="submit" name="submit" value="Insert">


</form>

<BR>

<A HREF="../../admin">Back to admin home page</A>


</body>
</html>

