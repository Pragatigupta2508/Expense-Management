<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Expenses</title>
</head>
<body>
<h1>Expense Management</h1>

<h2>Add Expense</h2>
<form action="/expenses" method="post">
    Amount: <input type="number" step="0.01" name="amount" required>
    Description: <input type="text" name="description" required>
    <button type="submit">Add</button>
</form>

<h2>All Expenses</h2>
<ul>
    <c:forEach var="expense" items="${expenses}">
        <li>
            ${expense.description}: $${expense.amount}
            <a href="/expenses/delete/${expense.id}">[Delete]</a>
        </li>
    </c:forEach>
</ul>

</body>
</html>
