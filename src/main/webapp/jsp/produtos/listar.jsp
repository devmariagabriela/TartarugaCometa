<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>Lista de Produtos</title></head>
<body>

<h1>Produtos</h1>

<a href="formulario.jsp">Novo Produto</a>
<br><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Peso</th>
    </tr>

    <c:forEach var="produto" items="${produtos}">
        <tr>
            <td>${produto.id}</td>
            <td>${produto.nome}</td>
            <td>${produto.peso}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
