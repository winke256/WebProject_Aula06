<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Cliente" %>
<html>
<head>
    <title>Cliente Information</title>
</head>
<body>

    <% Cliente c = (Cliente)request.getAttribute("Cliente"); %>
    <%= c.getName() %><br>
    <%= c.getFone() %><br>
    <%= c.getMail() %>

</body>
</html>
