<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Procurar Modelo</title>
    </head>
    <body>
        <%@ include file="../master/menu.jsp" %>
        <h2>Procurar Modelo</h2>
        <form action="../FrontController?action=LerModelo" method="post">
            <table>
                <tr>
                    <td>Informe o nome da modelo</td>
                    <td><input type="text" name="textNome"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Procurar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
