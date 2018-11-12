<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<H2>Test Simulator</H2>
<
<style>
    input[type=button], input[type=submit] {
        background-color: #4CAF50;
        height: 50px;
        width: 100px;
        color: white;
        padding: 5px 5px;
        margin: 4px 2px;
        white-space:normal;
    }


    #two {
        display: none;
        float: left;
    }

    #menuCategories {
        display: inline;
    }

    #one {
        display: inline;
        float: left;
    }
</style>
</head>
<body>
    <H2>Test Simulator</H2>
    <


<form>
<!-- Page Layout table -->
<table border="1">
    <tr>

        <!-- Display Menu Categories 2x10-->
        <td>
        <table>
            <c:forEach var="category" items="${menuCategories}" varStatus="row">
                <tr>
                    <c:if test = "${row.count == category.rowPosition && fn:trim(category.columnPosition) == 'A'}">
                        <td>${category.categoryDescription}</td>
                    </c:if>
                    <c:if test = "${row.count == category.rowPosition && fn:trim(category.columnPosition) == 'B'}">
                        <td>${category.categoryDescription}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        </td>

        <!-- Display Menu Items -->
        <td>
        <table>
            <c:forEach var="category" items="${menuCategories}">
                <c:if test="${category.id == 1}">
                    <c:forEach begin="1" end="10" varStatus="loop">
                        <tr>
                            <c:forEach var="menuItem" items="${category.menuItems}">

                                <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'C'}">
                                    <td>${menuItem.description}</td>
                                </c:if>
                                <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'D'}">
                                    <td>${menuItem.description}</td>
                                </c:if>
                                <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'E'}">
                                    <td>${menuItem.description}</td>
                                </c:if>
                                <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'F'}">
                                    <td>${menuItem.description}</td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </table>
        </td>
    </tr>
</table>


</body>

</html>


















</form>


<BR>
<A HREF="../">Back to Home</A>

</body>
</html>

