<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head><title>Nova Entrega</title></head>
<body>

<h1>Cadastrar Entrega</h1>

<form action="/entrega" method="post">

    Remetente (ID): <input type="text" name="remetente"><br><br>
    Destinatário (ID): <input type="text" name="cliente"><br><br>
    Status: <input type="text" name="status"><br><br>

    <button type="submit">Salvar</button>
</form>

</body>
</html>
