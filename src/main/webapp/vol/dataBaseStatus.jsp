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


<h1>Database Status</h1>

Status of request: ${status}
<br><br>
<a href="/doorCreekCafe/vol">Back to Volunteer Dashboard</a>


<footer>
    <%@ include file="/jsp/footer.jsp"%>
</footer>
<%@ include file="/jsp/bootstrampJavaScript.jsp"%>


</body>
</html>

