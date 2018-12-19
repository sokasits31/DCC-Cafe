<table border="1" cellpadding="1">
    <!-- row 1 data -->
    Current Info on System...

    <tr>
        <td>Description</td>
        <th>Alt Description</th>
        <th>Short Hand</th>
        <th>Response Time(sec)</th>
        <th>Status</th>
        <th>Time Tested</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:forEach var="testItem" items="${user.testItems}">
            <tr>
                <td>${testItem.description}</td>
                <td>${testItem.altDescription}</td>
                <td>${testItem.shortHand}</td>
                <td>${testItem.responseTimeInSec}</td>
                <td>${testItem.responseStatus}</td>
                <td>${testItem.questionStartTime}</td>
            </tr>
        </c:forEach>


    </c:forEach>
</table>
