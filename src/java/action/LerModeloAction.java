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
import model.Modelo;
import persistence.ModeloDAO;

/**
 *
 * @author mathe
 */
public class LerModeloAction implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nome = request.getParameter("textNome");

        try {
            Modelo modelo = ModeloDAO.getInstance().getModelo(nome);

            request.setAttribute("modelo", modelo);
            RequestDispatcher view = request.getRequestDispatcher("modeloPages/exibirModelo.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerModeloAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerModeloAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
