<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
    <title>Procurar Categoria</title>
  </head>
  <body>
    <h1>Procurar Categoria</h1>
    <form action="../FrontController?action=LerCategoria" method="post">
      <table>
        <tr>
          <td>Entre com o nome da categoria</td>
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
