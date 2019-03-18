<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>CRUD categoria</title>
  </head>
  <body>
    <div>
      <h1>Categoria</h1>
      
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
            <c:forEach items="${categorias}" var="categoria">
              <tr>
                <td><c:out value="${categoria.id}"/></td>
                <td><c:out value="${categoria.nome}"/></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <form
        action="categoriaPages/cadastraCategoria.jsp"
        method="post"
      >
        <input type="submit" value="Cadastrar novo" />
      </form>
      <form action="categoriaPages/procurarCategoria.jsp" method="post">
          <input type="submit" value="Procurar" />
        </form>
        <form
        action="categoriaPages/excluirCategoria.jsp"
        method="post"
      >
        <input type="submit" value="Excluir" />
      </form>
    </div>
</html>
