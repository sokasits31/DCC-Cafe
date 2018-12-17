<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!doctype html>
<html lang="en">
<head>
    <%@ include file="/jsp/head-tag.jsp"%>

    <style>

        input[type=button], input[type=submit] {
            background-color: white;
            height: 60px;
            width: 100px;
            color: black;
            padding: 5px 5px;
            margin: 4px 2px;
            white-space:normal;
        }

        input[type=button], input[name=filler] {
            background-color: transparent;
            border: transparent;
            height: 60px;
            width: 100px;
            color: black;
            padding: 5px 5px;
            margin: 4px 2px;
            white-space:normal;

        }


        #categories {
           border: 1px solid black;

        }


        #items {
            border: 1px solid black;

        }


    </style>


</head>

<body>

<header>
    <%@ include file="/jsp/header.jsp"%>
</header>


<H2>Test Simulator</H2>
User Name = ${users[0].firstName}
<P>
Directions:  Based on order please select correct Menu Item.  If you need a hint, select/click any Menu Item.
</P>
<div>
    <h3>Order # ${question}:  ${currentTestMenuItem}</H3>
</div>


<div class="container-fluid">
    <div class="row">
    <div class="col-1"></div>
    <div id="categories" class="col-3">
    <br>
    <H3 align="center">Categories</H3>
    <br>
    <table>
        <form action="continue" method="post">
        <c:forEach begin="1" end="10" varStatus="loop">
        <tr>
            <c:forEach var="category" items="${menuCategories}">
                <c:if test = "${loop.count == category.rowPosition && fn:trim(category.columnPosition) == 'A'}">
                    <c:choose>
                        <c:when test="${fn:trim(category.categoryDescription) == 'Open'}">
                            <td><input name="filler" type="button" disabled="disabled"></td>
                        </c:when>
                        <c:otherwise>
                            <td><input name="submit" value="${category.categoryDescription}" type="submit"
                            <c:if test = "${category.rowPosition == categoryRow && category.columnPosition == categoryColumn}"> style="background-color: yellow;" </c:if></td>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <c:if test = "${loop.count == category.rowPosition && fn:trim(category.columnPosition) == 'B'}">
                    <c:choose>
                        <c:when test="${fn:trim(category.categoryDescription) == 'Open'}">
                            <td><input name="filler" type="button" disabled="disabled"></td>
                        </c:when>
                        <c:otherwise>
                            <td><input name="submit" value="${category.categoryDescription}" type="submit"></td>
                            <c:if test = "${category.rowPosition == categoryRow && category.columnPosition == categoryColumn}"> style="background-color: yellow;" </c:if></td>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:forEach>
        </tr>
        </c:forEach>
    </form>
    </table>
    </div>
    <div id="items" class="col-6">
        <Br>
        <H3 align="center">Menu Items</H3>
        <Br>
        <table>
            <form action="answer" method="post">
                <c:forEach var="category" items="${menuCategories}">
                    <c:if test="${category.id == categoryId}">
                        <c:forEach begin="1" end="10" varStatus="loop">
                            <tr>
                                <c:forEach var="menuItem" items="${category.menuItems}">
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'C'}">
                                        <c:choose>
                                            <c:when test="${fn:trim(menuItem.description) == 'Open'}">
                                                <td><input name="filler" type="button" disabled="disabled" ></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><input name="submit" value="${menuItem.description}" type="submit" ></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'D'}">
                                        <c:choose>
                                            <c:when test="${fn:trim(menuItem.description) == 'Open'}">
                                                <td><input name="filler" type="button" disabled="disabled"></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><input name="submit" value="${menuItem.description}" type="submit" ></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'E'}">
                                        <c:choose>
                                            <c:when test="${fn:trim(menuItem.description) == 'Open'}">
                                                <td><input name="filler" type="button" disabled="disabled"></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><input name="submit" value="${menuItem.description}" type="submit" ></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                    <c:if test = "${menuItem.rowPosition == loop.count && fn:trim(menuItem.columnPosition) == 'F'}">
                                        <c:choose>
                                            <c:when test="${fn:trim(menuItem.description) == 'Open'}">
                                                <td><input name="filler" type="button" disabled="disabled"></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><input name="submit" value="${menuItem.description}" type="submit" ></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </table>
        </form>
    </div>
    <div class="col-1"></div>
    </div>
</div>


<c:choose>
    <c:when test="${fn:trim(answerStatus) == 'CORRECT'}">
        <script>
            window.alert("Correct!!!")
        </script>
    </c:when>
    <c:when test="${fn:trim(answerStatus) == 'INCORRECT'}">
        <script>
            window.alert("Sorry Incorrect...Hint: Found on ${currentTestMenuCategory} Menu");
        </script>
    </c:when>
</c:choose>


<footer>
    <%@ include file="/jsp/footer.jsp"%>
</footer>

<%@ include file="/jsp/bootstrampJavaScript.jsp"%>

</body>
</html>

