<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <% out.println(((Exception)request.getAttribute("Exception")).getMessage());
       out.println(((Exception)request.getAttribute("Exception")).getStackTrace());
    %>
</body>
</html>
