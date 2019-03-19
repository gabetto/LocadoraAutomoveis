
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Modelo</title>
    </head>
    <body>
        <%@ include file="../master/menu.jsp" %>
        <h2>Modelo lido com sucesso!</h2>
        <table>
            <tr><td>Id: </td><td><input value="${modelo.id}" type="text" disabled="true"/></td></tr>
            <tr><td>Nome: </td><td><input value="${modelo.nome}" type="text" disabled="true"/></td></tr>
            <tr><td>Marca: </td><td><input value="${modelo.marca.nome}" type="text" disabled="true"/></td></tr>

        </table>
    </body>
</html>
