<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/22/18
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.


--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/head-tag.jsp"%>

<%@ include file="/header.jsp"%>
<body>

<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</body>


<%@ include file="/footer.jsp"%>
</body>
</html>
