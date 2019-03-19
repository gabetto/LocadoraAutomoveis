
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Categoria</title>
    </head>
    <body>
        <%@ include file="../master/menu.jsp" %>
        <h1>Categoria lido com sucesso!</h1>
        <table>
            <tr><td>Id: </td><td><input value="${categoria.id}" type="text" disabled="true"/></td></tr>
            <tr><td>Nome: </td><td><input value="${categoria.nome}" type="text" disabled="true"/></td></tr>
        </table>
    </body>
</html>
