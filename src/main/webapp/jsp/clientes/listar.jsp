<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>Lista de Clientes</title></head>
<body>

<h1>Clientes</h1>

<a href="formulario.jsp">Novo Cliente</a>
<br><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome / Razão Social</th>
        <th>CPF/CNPJ</th>
        <th>Tipo Pessoa</th>
    </tr>

    <c:forEach var="cliente" items="${clientes}">
        <tr>
            <td>${cliente.id}</td>
            <td>${cliente.nomeRazaoSocial}</td>
            <td>${cliente.cpfCnpj}</td>
            <td>${cliente.tipoPessoa}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
