<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="by.vsu.epam.domain.Role"%>
<%@page import="by.vsu.epam.domain.User"%>
<%
    User user = (User)request.getAttribute("user");
    if(user == null) {
        user = new User();
        user.setLogin("");
    }
    String title;
    if(user.getId() != null) {
        title = "Редактирование данных пользователя";
    } else {
        title = "Добавление нового пользователя";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><%=title%></title>
        <link href="../main.css" rel="stylesheet">
    </head>
    <body>
        <h1>Банк «Рога и копыта»</h1>
        <h2><%=title%></h2>
        <form action="save.html" method="post">
            <%
                if(user.getId() != null) {
            %>
            <input name="id" value="<%=user.getId()%>" type="hidden">
            <%
                }
            %>
            <label for="login">Имя пользователя:</label>
            <input id="login" name="login" value="<%=user.getLogin()%>">
            <label for="role">Роль:</label>
            <select id="role" name="role">
                <%
                    Role[] roles = (Role[])request.getAttribute("roles");
                    String selected;
                    for(Role role : roles) {
                        if(role == user.getRole()) {
                            selected = "selected";
                        } else {
                            selected = "";
                        }
                %>
                <option value="<%=role.getId()%>" <%=selected%>><%=role.getName()%></option>
                <%
                    }
                %>
            </select>
            <button class="save">Сохранить</button>
            <%
                if(user.getId() != null) {
                    String disabled = (boolean)request.getAttribute("userCanBeDeleted") ? "" : "disabled";
            %>
            <button class="delete" formaction="delete.html" formmethod="post" <%=disabled%>>Удалить</button>
            <%
                }
            %>
            <a class="back" href="list.html">Отменить</a>
        </form>
    </body>
</html>