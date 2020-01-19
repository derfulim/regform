<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registered users</title>

    <%--todo fill list with registered users--%>

    <div>
        <table class="table">
            <caption>Registered users</caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Ім'я</th>
                <th>Прізвище</th>
                <th>Name</th>
                <th>Surname</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach var="user" items="${usersList}" varStatus="usersLoop">
                <tr>
                    <td>${usersLoop.count}</td>
                    <td>${user.login}</td>
                    <td>${user.nameUa}</td>
                    <td>${user.surnameUa}</td>
                    <td>${user.nameEng}</td>
                    <td>${user.surnameEng}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>


</head>
<body>

</body>
</html>
