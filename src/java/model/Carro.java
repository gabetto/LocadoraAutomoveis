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
public class Carro {
    
    private int id;
    private Modelo modelo;
    private String placa;
    private CarroEstado estado;
    

    public Carro(int id, Modelo modelo, String placa, CarroEstado estado) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.estado = estado;
    }
    
    public Carro(Modelo modelo, String placa, CarroEstado estado) {
        this.estado = estado;
        this.placa = placa;
        this.modelo = modelo;
    }
    
    public Carro(Modelo modelo, String placa) {
        this.estado = new CarroEstadoDisponivel();
        this.placa = placa;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public CarroEstado getEstado() {
        return estado;
    }

    public void setEstado(CarroEstado estado) {
        this.estado = estado;
    }
    
    
}
