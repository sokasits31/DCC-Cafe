<div id="question">
    <h3>Order # ${question}:  ${currentTestMenuItem}</H3>
</div>


<div class="container-fluid" id="register">

    <div class="row">

            <div id="categories">
                <br>
                <H3 align="center">Categories</H3>
                <br>
                <table id="categoriesTable">
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

            <div id="filler"></div>

            <div id="items">
                <Br>
                <H3 align="center">Menu Items</H3>
                <Br>
                <table id="itemTable">
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


            <div id="notes">
                <H2>Welcome to the Register Simulator!</H2>
                <br>
                Directions:  Based on ORDER(in yellow) please select correct Menu Item.  If you need a hint, select/click any Menu Item.

            </div>



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

