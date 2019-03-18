<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>CRUD modelo</title>
  </head>
  <body>
    <div>
      <h1>Modelo</h1>
      <div>
        <table class="tableCrud">
          <thead>
            <th>
              Id:
            </th>
            <th>
              Nome:
            </th>
            <th>
              Excluir
            </th>
          </thead>
          <tbody>
            <c:forEach items="${modelos}" var="modelo">
              <tr>
                <td><c:out value="${modelo.id}"/></td>
                <td><c:out value="${modelo.nome}"/></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <form
        action="FrontController?action=CadastroModelo"
        method="post"
      >
        <input type="submit" value="Cadastrar novo" />
      </form>
      <form action="modeloPages/procurarModelo.jsp" method="post">
          <input type="submit" value="Procurar" />
        </form>
        <form
        action="modeloPages/excluirModelo.jsp"
        method="post"
      >
        <input type="submit" value="Excluir" />
      </form>
    </div>
</html>
