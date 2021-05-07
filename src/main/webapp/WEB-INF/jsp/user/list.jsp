<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="by.vsu.epam.domain.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Список пользователей</title>
        <link href="../main.css" rel="stylesheet">
    </head>
    <body>
        <h1>Банк «Рога и копыта»</h1>
        <h2>Список пользователей</h2>
        <table>
            <tr>
                <th>Имя пользователя</th>
                <th>Роль</th>
                <td>&nbsp;</td>
            </tr>
            <%
                @SuppressWarnings("unchecked")
                List<User> users = (List<User>)request.getAttribute("users");
                for(User user : users) {
            %>
            <tr>
                <td class="content"><%=user.getLogin()%></td>
                <td class="content"><%=user.getRole().getName()%></td>
                <td class="empty"><a href="edit.html?id=<%=user.getId()%>" class="edit"></a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="edit.html" class="add-button">Добавить</a>
    </body>
</html>