<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Cliente" %>
<html>
<head>
    <title>Cliente Information</title>
    <script type="text/javascript">
        function voltar(){
            window.location.href='index.jsp';
        }
    </script>
</head>
<body>
    <h3>Information</h3>
    <% String acao = (String)request.getAttribute("Acao");
       Cliente cliente = (Cliente)request.getAttribute("Cliente");
        switch(acao){
            case "Cadastrar":
                out.println("Cliente cadastrado com sucesso.");
                out.println("ID: "+cliente.getId());
                break;
        }
    %>

    <br>

    <input type="button" name="Home" value="Home" onclick="voltar()">


</body>
</html>
