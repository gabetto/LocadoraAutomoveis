/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;
import persistence.MarcaDAO;

/**
 *
 * @author mathe
 */
public class LerMarcaAction {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nome = request.getParameter("nome");

        try {
            Marca marca = MarcaDAO.getInstance().getMarca(nome);

            request.setAttribute("marca", marca);
            RequestDispatcher view = request.getRequestDispatcher("/exibirMarca.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerMarcaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerMarcaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
