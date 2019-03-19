<%@page contentType="text/html" pageEncoding="windows-1252"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
    <title>Cadastra Carro</title>
  </head>
  <body>
    <%@ include file="../master/menu.jsp" %>
    <h2>Cadastrar</h2>
    <form action="./FrontController?action=GravarCarro" method="post">
      <table>
        <tr>
          <td>Modelo do veículo</td>
          <td>
              <select name="optModelo">
                <c:forEach items="${modelos}" var="modelo">
                    <option value="${modelo.id}">${modelo.marca.nome} ${modelo.nome}</option>  
                </c:forEach>
            </select>
          </td>
        </tr>
        <tr>
          <td>Placa</td>
          <td><input type="text" name="textPlaca" /></td>
        </tr>
          <tr>
          <td><input type="submit" value="Cadastrar"/></td>
        </tr>
      </table>
    </form>
  </body>
</html>
