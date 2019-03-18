/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class PreparaMarcaAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            ArrayList<Marca> marcas = MarcaDAO.getInstance().getMarcas();
            request.setAttribute("marcas", marcas);
            RequestDispatcher view = request.getRequestDispatcher("marcaPages/marca.jsp");
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (ServletException ex) {
            
        }
    }
}
