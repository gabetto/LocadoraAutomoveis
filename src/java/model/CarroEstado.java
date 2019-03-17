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
public interface CarroEstado {
    
    public boolean alugar(Carro carro);
    public boolean disponibilizar(Carro carro);
    public boolean paraManutencao(Carro carro);
    
}
