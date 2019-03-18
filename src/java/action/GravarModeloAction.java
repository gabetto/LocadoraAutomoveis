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
import model.Modelo;
import model.StateFactory;
import persistence.CategoriaDAO;
import persistence.MarcaDAO;
import persistence.ModeloDAO;
import persistence.ModeloDAO;

/**
 *
 * @author mathe
 */
public class GravarModeloAction implements Action{
     @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        //int id = Integer.parseInt(request.getParameter("id"));
        int marca = Integer.parseInt(request.getParameter("optMarca"));
        String nome = request.getParameter("textNome");
        int categoria = Integer.parseInt(request.getParameter("optCategoria"));
        
        try {
            Modelo modelo = new Modelo(MarcaDAO.getInstance().getMarca(marca), nome, CategoriaDAO.getInstance().getCategoria(categoria) );
            ModeloDAO.getInstance().save(modelo);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GravarModeloAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
