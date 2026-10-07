<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alke Wallet</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        text-align: center;
        padding-top: 60px;
    }

    .wallet {
        background-color: white;
        width: 350px;
        margin: auto;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 0 10px #cccccc;
    }

    .saldo {
        font-size: 28px;
        margin: 20px;
    }

    input {
        padding: 10px;
        width: 80%;
        margin-bottom: 15px;
    }

    button {
        padding: 10px 20px;
        margin: 5px;
        cursor: pointer;
    }

    .mensaje {
        margin-top: 20px;
    }
</style>

</head>

<body>

<div class="wallet">

    <h1>Alke Wallet</h1>

    <h3>Saldo disponible</h3>

    <div class="saldo">
        $${saldo}
    </div>

    <form action="${pageContext.request.contextPath}/wallet" method="post">

        <input type="number"
               name="monto"
               step="0.01"
               min="0.01"
               placeholder="Ingrese un monto"
               required>

        <br>

        <button type="submit" name="accion" value="depositar">
            Depositar
        </button>

        <button type="submit" name="accion" value="retirar">
            Retirar
        </button>

    </form>

    <div class="mensaje">
        ${mensaje}
    </div>

</div>

</body>
</html>