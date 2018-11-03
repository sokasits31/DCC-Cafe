<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<H2>Test Simulator</H2>

<c:forEach var="category" items="${menuCategories}">
    ${category.id}...  ${category.categoryDescription}... ${category.cellPosition}
    ${category.menuItems}
</c:forEach>


<form>

    <table>





    <!-- Display row 1 in Registser -->
    <tr>
        <c:forEach var="category" items="${menuCategories}">

            <c:if test = "${category.cellPosition == 'A1'}">
                <td>${category.categoryDescription}</td>
            </c:if>

            <c:if test = "${category.cellPosition == 'B1'}">
                <td>${category.categoryDescription}</td>
            </c:if>

            <c:forEach var="menuItem" items="${category.menuItems}">
                <c:if test = "${menuItem.cellPosition== 'C1'}">
                    <td>${menuItem.description}</td>
                </c:if>

                <c:if test = "${menuItem.cellPosition == 'D1'}">
                    <td>${menuItem.description}</td>
                </c:if>

                <c:if test = "${menuItem.cellPosition == 'E1'}">
                    <td>${menuItem.description}</td>
                </c:if>

                <c:if test = "${menuItem.cellPosition == 'F1'}">
                    <td>${menuItem.description}</td>
                </c:if>
            </c:forEach>

        </c:forEach>

    </tr>


    </table>

</form>


<BR>
<A HREF="../">Back to HOme</A>

</body>
</html>

