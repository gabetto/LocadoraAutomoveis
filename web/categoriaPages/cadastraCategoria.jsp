<%@page contentType="text/html" pageEncoding="windows-1252"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
    <title>Cadastra Categoria</title>
  </head>
  <body>
    <h2>CADASTRAR</h2>
    <form action="../FrontController?action=GravarCategoria" method="post">
      <table>
        <!--
        <tr>
          <td>Entre com seu id</td>
          <td><input type="text" name="id"/></td>
        </tr>
        -->
        <tr>
          <td>Entre com o nome</td>
          <td><input type="text" name="textNome" /></td>
        </tr>
        <tr>
          <td><input type="submit" value="Cadastrar"/></td>
        </tr>
      </table>
    </form>
    <a href="index.jsp">Inicial</a>
  </body>
</html>
