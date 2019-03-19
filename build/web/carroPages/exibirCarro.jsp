
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Carro</title>
    </head>
    <body>
        <%@ include file="../master/menu.jsp" %>


        <h1><c:if test="${mensagemEstado != null}">
            ${mensagemEstado}
        </c:if></h1>
        <table>
            <tr><td>Marca: </td><td><input value="${carro.modelo.marca.nome}" type="text" disabled="true"/></td></tr>
            <tr><td>Nome: </td><td><input value="${carro.modelo.nome}" type="text" disabled="true"/></td></tr>
            <tr><td>Placa: </td><td><input value="${carro.placa}" type="text" disabled="true"/></td></tr>
            <tr><td>Estado: </td><td><input value="${carro.estado.toString()}" type="text" disabled="true"/></td></tr>
        </table>

        <form action="./FrontController?action=AlugarCarro&p=${carro.placa}" method="post">
            <input type="submit" value="Alugar" />
        </form>
        <form action="./FrontController?action=DisponilizarCarro&p=${carro.placa}" method="post">
            <input type="submit" value="Liberar" />
        </form>
        <form action="./FrontController?action=EmManutencaoCarro&p=${carro.placa}" method="post">
            <input type="submit" value="Fazer manutencao" />
        </form>
    </body>
</html>
