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
public class Modelo {
    
    private int id;
    private Marca marca;
    private String nome;
    private Categoria categoria;

    public Modelo(int id, Marca marca, String nome, Categoria categoria) {
        this.id = id;
        this.marca = marca;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Modelo(Marca marca, String nome, Categoria categoria) {
        this.marca = marca;
        this.nome = nome;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
