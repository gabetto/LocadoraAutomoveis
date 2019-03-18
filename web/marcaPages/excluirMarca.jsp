
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>APAGAR</h2>
        <form action="../FrontController?action=ApagarMarca" method="post">
            <table>
                <tr><td>Entre com o nome da marca</td>
                    <td><input type="text" name="textNome"/></td></tr> 
                <tr><td> <input type="submit" value="Apagar"/></td></tr>
            </table>
        </form>
          <a href="../index.jsp">Inicial</a>
    </body>
</html>
