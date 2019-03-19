<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>CRUD carro</title>
    </head>
    <body>
        <div>
            <%@ include file="../master/menu.jsp" %>
            <h1>Carro</h1>
            <div>
                <table class="tableCrud">
                    <thead>
                    <th>
                        Nome
                    </th>
                    <th>
                        Placa:
                    </th>
                    </thead>
                    <tbody>
                        <c:forEach items="${carros}" var="carro">
                            <tr>
                                <td><c:out value="${carro.modelo.marca.nome} ${carro.modelo.nome}"/></td>
                                <td><c:out value="${carro.placa}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form
                action="FrontController?action=CadastroCarro"
                method="post"
                >
                <input type="submit" value="Cadastrar" />
            </form>
            <form action="carroPages/procurarCarro.jsp" method="post">
                <input type="submit" value="Procurar" />
            </form>
            <form
                action="carroPages/excluirCarro.jsp"
                method="post"
                >
                <input type="submit" value="Excluir" />
            </form>
        </div>
</html>
