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
public class CarroEstadoDisponivel implements CarroEstado{

    @Override
    public boolean alugar(Carro carro) {
        carro.setEstado(new CarroEstadoAlugado());
        return true;
    }

    @Override
    public boolean disponibilizar(Carro carro) {
        return false;
    }

    @Override
    public boolean paraManutencao(Carro carro) {
        carro.setEstado(new CarroEstadoEmManutencao());
        return true;
    }
    
    @Override
    public String toString(){
        return "Disponivel";
    }
    
}
