<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
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

        #register {
            width: 800px;
            border: 1px solid black;
        }

        #categories {
            display: inline;
            border: 2px solid black;
            width: 250px;
            float: left;
        }

        #items {
            display: inline;
            border: 2px solid black;
            overflow: hidden;
        }

    </style>
</head>

<body>

<H2>Test Simulator</H2>

<div id="register">

    <div id="categories">
    <table>
        <form action="testSimulator/1" method="get">
        <c:forEach begin="1" end="10" varStatus="loop">
        <tr>
            <c:forEach var="category" items="${menuCategories}">
                <c:if test = "${loop.count == category.rowPosition && fn:trim(category.columnPosition) == 'A'}">
                    <c:choose>
                        <c:when test="${fn:trim(category.categoryDescription) == 'Open'}">
                            <td><input name="submit" value="${category.categoryDescription}" type="hidden"></td>
                        </c:when>
                        <c:when test="${fn:trim(category.categoryDescription) != 'Open'}">
                            <td><input name="submit" value="${category.categoryDescription}" type="submit"></td>
                        </c:when>
                    </c:choose>
                </c:if>
                <c:if test = "${loop.count == category.rowPosition && fn:trim(category.columnPosition) == 'B'}">
                    <td><input name="submit" value="${category.categoryDescription}" type="submit"></td>
                </c:if>
            </c:forEach>
        </tr>
        </c:forEach>
    </form>
    </table>
    </div>


    <div id="items">
    <form>
           <table>
                <c:forEach var="category" items="${menuCategories}">
                    <c:if test="${category.id == 1}">
                        <c:forEach begin="1" end="10" varStatus="loop">
                            <tr>
                                <c:forEach var="menuItem" items="${category.menuItems}">
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'C'}">
                                        <td><input name="submit" value="${menuItem.description}" type="submit"></td>
                                    </c:if>
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'D'}">
                                        <td><input name="submit" value="${menuItem.description}" type="submit"></td>
                                    </c:if>
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'E'}">
                                        <td><input name="submit" value="${menuItem.description}" type="submit"></td>
                                    </c:if>
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'F'}">
                                        <td><input name="submit" value="${menuItem.description}" type="submit"></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </table>
    </form>
    </div>

</div>


<A HREF="../">Back to Home</A>

</body>
</html>

