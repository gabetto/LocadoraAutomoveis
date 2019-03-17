/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gabriel
 */
public class CarroEstadoEmManutencao implements CarroEstado {

    @Override
    public boolean alugar(Carro carro) {
        return false;
    }

    @Override
    public boolean disponibilizar(Carro carro) {
        carro.setEstado(new CarroEstadoDisponivel());
        return true;
    }

    @Override
    public boolean paraManutencao(Carro carro) {
        return false;
    }

}
