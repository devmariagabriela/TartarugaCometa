<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Cliente</title>
</head>
<body>
<h1> Formulario de Cliente</h1>
<form action = "cliente" method="post">
    Nome /Razão Social<input type ="text" name="nomerazaoSocial"><br><br>
    CPF / CNPJ: <input type = "text" name ="cpfCnpj"><br><br>
    Tipo de Pessoa:
    <select name="tipoPessoa">
        <option value = "Fisicac"> Fisica</option>
        <option vlaue = "Juridica">Juridica</option>
    </select><br></br>
    <inpout type ="sumit" value = "Salvar"></inpout>
</form>
<a href="listar.jsp">Voltar à lista</a>
</body>
</html>