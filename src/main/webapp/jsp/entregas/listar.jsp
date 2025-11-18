<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>Lista de Entregas</title></head>
<body>

<h1>Entregas</h1>

<a href="formulario.jsp">Nova Entrega</a>
<br><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Remetente</th>
        <th>Destinatário</th>
        <th>Status</th>
    </tr>

    <c:forEach var="entrega" items="${entregas}">
        <tr>
            <td>${entrega.id}</td>
            <td>${entrega.remetente.nomeRazaoSocial}</td>
            <td>${entrega.cliente.nomeRazaoSocial}</td>
            <td>${entrega.status}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
