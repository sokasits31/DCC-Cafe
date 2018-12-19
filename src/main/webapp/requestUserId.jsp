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

<P>To get a logon id, please contact...
<br><br>
${firstName} ${lastName} at ${email}
<br><br>
Once you receive your Id and password, you will be about to take register simulator test that track your progress.
<br>
Thanks for your interest!
</P>

<footer>
    <%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>
</body>

</html>
