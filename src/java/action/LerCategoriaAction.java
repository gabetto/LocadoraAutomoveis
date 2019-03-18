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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carro;
import persistence.CarroDAO;

/**
 *
 * @author mathe
 */
public class LerCategoriaAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String placa = request.getParameter("placa");

        try {
            Carro carro = CarroDAO.getInstance().getCarro(placa);

            request.setAttribute("carro", carro);
            RequestDispatcher view = request.getRequestDispatcher("/exibirCarro.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerCarroAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerCarroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
