
<FORM ACTION= "dataBaseStatus" method="get">

    <fieldset>
        <legend>Update User Info</legend>

        Id:<br>
        <input type="text" name="userId" value="${userId}" readonly > <br>

        Email Address:<br>
        <input type="text" name="emailAddress" value="${emailAddress}"><br>

        First Name:<br>
        <input type="text" name="firstName" value="${firstName}"><br>

        Last Name:<br>
        <input type="text" name="lastName" value="${lastName}"><br>

        Phone Number:<br>
        <input type="text" name="phoneNumber" value="${phoneNumber}"><br>
    </fieldset>
    <input type="submit" name="submit" value="Update">
</FORM>
