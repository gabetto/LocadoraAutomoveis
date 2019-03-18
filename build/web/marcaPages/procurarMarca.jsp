<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
    <title>Procurar Marca</title>
  </head>
  <body>
    <h1>Procurar Marca</h1>
    <form action="../FrontController?action=LerMarca" method="post">
      <table>
        <tr>
          <td>Entre com o nome da marca</td>
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
