<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>CRUD Marca</title>
    </head>
    <body>
        <div>
            <%@ include file="../master/menu.jsp" %>
            <h2>Marcas</h2>

            <div>
                <table class="tableCrud">
                    <thead>
                    <th>
                        Id:
                    </th>
                    <th>
                        Nome:
                    </th>
                    </thead>
                    <tbody>
                        <c:forEach items="${marcas}" var="marca">
                            <tr>
                                <td><c:out value="${marca.id}"/></td>
                                <td><c:out value="${marca.nome}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form
                action="marcaPages/cadastraMarca.jsp"
                method="post"
                >
                <input type="submit" value="Cadastrar" />
            </form>
            <form action="marcaPages/procurarMarca.jsp" method="post">
                <input type="submit" value="Procurar" />
            </form>
            <form
                action="marcaPages/excluirMarca.jsp"
                method="post"
                >
                <input type="submit" value="Excluir" />
            </form>
        </div>
</html>
