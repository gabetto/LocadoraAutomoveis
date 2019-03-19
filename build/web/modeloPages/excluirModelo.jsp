
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="../master/menu.jsp" %>
        <h2>Apagar</h2>
        <form action="../FrontController?action=ApagarModelo" method="post">
            <table>
                <tr><td>Informe o nome do modelo</td>
                    <td><input type="text" name="textNome"/></td></tr> 
                <tr><td> <input type="submit" value="Apagar"/></td></tr>
            </table>
        </form>
    </body>
</html>
