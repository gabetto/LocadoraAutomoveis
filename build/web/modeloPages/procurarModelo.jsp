<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
    <title>Procurar Modelo</title>
  </head>
  <body>
    <h1>Procurar Modelo</h1>
    <form action="../FrontController?action=LerModelo" method="post">
      <table>
        <tr>
          <td>Entre com o nome da modelo</td>
          <td><input type="text" name="textNome"/></td>
        </tr>
        <tr>
          <td><input type="submit" value="Procurar"/></td>
        </tr>
      </table>
    </form>
    <a href="../index.jsp">Inicial</a>
  </body>
</html>
