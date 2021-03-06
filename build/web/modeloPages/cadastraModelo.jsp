<%@page contentType="text/html" pageEncoding="windows-1252"%> <%@ taglib
    uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
            <title>Cadastra Modelo</title>
        </head>
        <body>
            <%@ include file="../master/menu.jsp" %>
            <h2>Cadastrar</h2>
            <form action="./FrontController?action=GravarModelo" method="post">
                <table>
                    <tr>
                        <td>Informe o nome</td>
                        <td><input type="text" name="textNome" /></td>
                    </tr>
                    <tr>
                        <td>Escolha a marca</td>
                        <td>
                            <select name="optMarca">
                                <c:forEach items="${marcas}" var="marca">
                                    <option value="${marca.id}">${marca.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Escolha a Categoria</td>
                        <td>
                            <select name="optCategoria">
                                <c:forEach items="${categorias}" var="categoria">
                                    <option value="${categoria.id}">${categoria.nome}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Cadastrar"/></td>
                    </tr>
                </table>
            </form>
        </body>
    </html>
