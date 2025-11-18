<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head><title>Novo Produto</title></head>
<body>

<h1>Cadastro de Produto</h1>

<form action="/produto" method="post">
    Nome: <input type="text" name="nome"><br><br>
    Peso: <input type="text" name="peso"><br><br>

    <button type="submit">Salvar</button>
</form>

</body>
</html>
