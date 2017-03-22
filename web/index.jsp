<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Cliente MAIN</h3>
<form method="post" action="clienteInfo">

    ID: <input type="text" id="idCliente" name="clienteID" /><br/>
    Name: <input type="text" id="clienteName" name="clienteName"/><br/>
    Mail: <input type="text" id="clienteMail" name="clienteMail"/><br/>

    <input type="submit" name="oQueFazer" value="Cadastrar" />
</form>
</body>
</html>
