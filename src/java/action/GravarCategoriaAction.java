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
import model.Categoria;
import model.StateFactory;
import persistence.CategoriaDAO;
import persistence.ModeloDAO;

/**
 *
 * @author mathe
 */
public class GravarCategoriaAction implements Action{
     @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("textNome");
        
        try {
            Categoria categoria = new Categoria(id, nome);
            CategoriaDAO.getInstance().save(categoria);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GravarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
