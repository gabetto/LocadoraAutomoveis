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
import model.CarroEstado;
import model.StateFactory;
import persistence.CarroDAO;

/**
 *
 * @author Gabriel
 */
public class MudarEstadoCarroAction implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String placa = request.getParameter("p");
        int estado = Integer.parseInt(request.getParameter("e"));
        boolean trocouEstado = false;

        try {
            Carro carro = CarroDAO.getInstance().getCarro(placa);
            if (estado == 1) {
                trocouEstado = carro.getEstado().alugar(carro);
            } else if (estado == 2) {
                trocouEstado = carro.getEstado().disponibilizar(carro);
            } else if (estado == 3) {
                trocouEstado = carro.getEstado().paraManutencao(carro);
            }
            CarroDAO.getInstance().update(carro);
            if (trocouEstado) {
                request.setAttribute("mensagemEstado", "O estado do veículo foi alterado");
            } else {
                request.setAttribute("mensagemEstado", "O estado do veículo não pode ser alterado");
            }
            request.setAttribute("carro", carro);
            RequestDispatcher view = request.getRequestDispatcher("modeloPages/exibirCarro.jsp");
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
