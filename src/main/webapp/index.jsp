<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Registration form</h2>

<form method="post" action="regform">
    <%--TODO fix when input invalid login after not unique field--%>
    <p>
        <c:if test="${not empty sessionScope.invalidData.login }">
            <c:out value="Поле не валідне ${sessionScope.invalidData.login}"/>
        </c:if>

    <p>
        <c:if test="${not empty sessionScope.notUniqueData.login }">
            <c:out value="Вказаний логін ${sessionScope.notUniqueData.login} уже використовується іншим користувачем "/>
        </c:if>

    <p><b>Login</b><br>
        <input required type="text" size="40" name="login" id="login">
    </p>


    <p><b>Role</b><br>
        <input required type="radio" size="40" name="role" id="moderator" value="MODERATOR"> MODERATOR
        <input type="radio" size="40" name="role" id="speaker" value="SPEAKER"> SPEAKER
        <input type="radio" size="40" name="role" id="visitor" value="VISITOR"> VISITOR
        <input type="radio" size="40" name="role" id="unknown" value="UNKNOWN"> UNKNOWN
    </p>

    <p>
        <c:if test="${not empty sessionScope.invalidData.nameUa }">
            <c:out value="Поле не валідне ${sessionScope.invalidData.nameUa}"/>
        </c:if>

    <p><b>Ukrainian name</b><br>
        <input required type="text" size="40" name="nameUa" id="nameUa">
    </p>

    <p>
        <c:if test="${not empty sessionScope.invalidData.surnameUa }">
            <c:out value="Поле не валідне ${sessionScope.invalidData.surnameUa}"/>
        </c:if>

    <p><b>Ukrainian surname</b><br>
        <input required type="text" size="40" name="surNameUa" id="surNameUa">
    </p>

    <p>
        <c:if test="${not empty sessionScope.invalidData.nameEng }">
            <c:out value="Поле не валідне ${sessionScope.invalidData.nameEng}"/>
        </c:if>

    <p><b>English name</b><br>
        <input required type="text" size="40" name="nameEng" id="nameEng">
    </p>

    <p>
        <c:if test="${not empty sessionScope.invalidData.surnameEng }">
            <c:out value="Поле не валідне ${sessionScope.invalidData.surnameEng}"/>
        </c:if>

    <p><b>English surname</b><br>
        <input required type="text" size="40" name="surNameEng" id="surNameEng">
    </p>

    <p>
        <c:if test="${not empty sessionScope.invalidData.email }">
            <c:out value="Поле не валідне ${sessionScope.notUniqueData.email}"/>
        </c:if>

    <p>
        <c:if test="${not empty sessionScope.notUniqueData.email }">
            <c:out value="Вказана електронна пошта ${sessionScope.notUniqueData.email} уже використовується іншим користувачем"/>
        </c:if>

    <p><b>Email</b><br>
        <input required type="email" size="40" name="email" id="email">
    </p>

    <p>
        <c:if test="${not empty sessionScope.invalidData.password }">
            <c:out value="Поле не валідне ${sessionScope.invalidData.password}"/>
        </c:if>

    <p><b>Password</b><br>
        <input required type="password" size="40" name="password" id="password">
    </p>

    <input class="button" type="submit" value="Submit">
</form>

<b>
    <form action="signin">
        <p><b>Login</b><br>
            <input required type="text" size="40" name="login" id="oldlogin">
        </p>

        <p><b>Password</b><br>
            <input required type="password" size="40" name="password" id="oldpassword">
        </p>

        <input class="button" type="submit" value="Submit">

    </form>

</b>


</body>
</html>
