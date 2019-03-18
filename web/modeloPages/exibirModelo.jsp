
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Modelo</title>
    </head>
    <body>
        <h1>Modelo lido com sucesso!</h1>
        <table>
            <tr><td>Id: </td><td><input value="${modelo.id}" type="text" disabled="true"/></td></tr>
            <tr><td>Nome: </td><td><input value="${modelo.nome}" type="text" disabled="true"/></td></tr>
        </table>
        <a href="index.jsp">Inicial</a>
    </body>
</html>
