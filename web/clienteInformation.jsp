<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Cliente Information</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<!-- HEAD -->
<div class="container">
    <h1>Cliente information</h1>
</div>

<!-- BODY -->
<div class="container">
    <dl>
        <c:choose>
            <c:when test="${Acao == 'Cadastrar'}">
                <dt class="alert-success">Information:</dt>
                <dd>ID: ${Cliente.id}</dd>
                <dd>Name: ${Cliente.name}</dd>
            </c:when>
            <c:when test="${Acao == 'Deletar'}">
                <dt class="alert-success">Information:</dt>
                <dd>Cliente deletado com sucesso.</dd>
            </c:when>
            <c:when test="${Acao == 'Atualizar'}">
                <dt class="alert-success">Information:</dt>
                <dd>ID: ${Cliente.id}</dd>
                <dd>Name: ${Cliente.name}</dd>
                <dd>Mail: ${Cliente.mail}</dd>
            </c:when>
            <c:when test="${Acao == 'Obter'}">
                <dt class="alert-success">Information:</dt>
                <dd>ID: ${Cliente.id}</dd>
                <dd>Name: ${Cliente.name}</dd>
                <dd>Mail: ${Cliente.mail}</dd>
            </c:when>
            <c:otherwise>
                <dt class="alert-info">Information</dt>
                <dd>Dont have any information</dd>
            </c:otherwise>
        </c:choose>
    </dl>
</div>

<!-- FOOTER -->
<div class="container">
    <button type="button" class="btn-default" name="btHome" onclick="window.location.href='index.jsp'" > Home </button>
</div>

</body>
</html>
