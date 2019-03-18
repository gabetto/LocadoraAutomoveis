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
import model.Marca;
import model.StateFactory;
import persistence.MarcaDAO;
import persistence.ModeloDAO;

/**
 *
 * @author mathe
 */
public class GravarMarcaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        //int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("textNome");

        try {
            Marca marca = new Marca(nome);
            MarcaDAO.getInstance().save(marca);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GravarMarcaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
