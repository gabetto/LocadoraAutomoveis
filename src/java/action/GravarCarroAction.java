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
import model.Carro;
import model.StateFactory;
import persistence.CarroDAO;
import persistence.DatabaseLocator;
import persistence.ModeloDAO;

/**
 *
 * @author mathe
 */
public class GravarCarroAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        //int id = Integer.parseInt(request.getParameter("id"));
        int modelo = Integer.parseInt(request.getParameter("optModelo"));
        String placa = request.getParameter("textPlaca");
        //estado inicia disponivel
        //String estado = request.getParameter("optEstado");
        
        try {
            Carro carro = new Carro(ModeloDAO.getInstance().getModelo(modelo), placa);
            CarroDAO.getInstance().save(carro);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            response.sendRedirect("erro.jsp");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GravarCarroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
