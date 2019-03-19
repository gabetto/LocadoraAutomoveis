<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Procurar Carro</title>
    </head>
    <body>
        <%@ include file="../master/menu.jsp" %>
        <h1>Procurar Carro</h1>
        <form action="../FrontController?action=LerCarro" method="post">
            <table>
                <tr>
                    <td>Informe a placa do carro</td>
                    <td><input type="text" name="textPlaca"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Procurar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
