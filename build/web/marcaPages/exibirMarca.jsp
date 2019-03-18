
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Marca</title>
    </head>
    <body>
        <h1>Marca lido com sucesso!</h1>
        <table>
            <tr><td>Id: </td><td><input value="${marca.id}" type="text" disabled="true"/></td></tr>
            <tr><td>Nome: </td><td><input value="${marca.nome}" type="text" disabled="true"/></td></tr>
        </table>
        <a href="index.jsp">Inicial</a>
    </body>
</html>
