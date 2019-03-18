/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CarroDAO;

/**
 *
 * @author mathe
 */
public class ApagarCarroAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String placa = request.getParameter("textPlaca");

        try {
            CarroDAO.getInstance().delete(placa);
            response.sendRedirect("sucesso.jsp?acao=Apagar");
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp?acao=Apagar");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApagarCarroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
