/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Categoria;
import model.Marca;
import model.Modelo;

/**
 *
 * @author Gabriel
 */
public class ModeloDAO {

    private static ModeloDAO instance = new ModeloDAO();

    public static ModeloDAO getInstance() {
        return instance;
    }

    public ArrayList<Modelo> getModelos() throws ClassNotFoundException, SQLException {
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select modelo.*, marca.*, categoria.* from modelo "
                    + "INNER JOIN categoria ON modelo.id_categoria = categoria.id "
                    + "INNER JOIN marca ON modelo.id_marca = marca.id;");
            while (rs.next()) {
                Marca marca = new Marca(rs.getInt("marca.id"), rs.getString("marca.nome"));
                Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
                Modelo modelo = new Modelo(rs.getInt("modelo.id"), marca, rs.getString("modelo.nome"), categoria);
                modelos.add(modelo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return modelos;

    }

    public Modelo getModelo(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Modelo modelo = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select modelo.*, marca.*, categoria.* from modelo "
                    + "INNER JOIN categoria ON modelo.id_categoria = categoria.id "
                    + "INNER JOIN marca ON modelo.id_marca = marca.id WHERE modelo.id = '" + id + "';");
            rs.first();
            int idd = rs.getInt("marca.id");
            String nome = rs.getString("marca.nome");
            Marca marca = new Marca(rs.getInt("marca.id"), rs.getString("marca.nome"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            modelo = new Modelo(rs.getInt("modelo.id"), marca, rs.getString("modelo.nome"), categoria);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return modelo;

    }
    
    public Modelo getModelo(String nome) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Modelo modelo = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select modelo.*, marca.*, categoria.* from modelo "
                    + "INNER JOIN categoria ON modelo.id_categoria = categoria.id "
                    + "INNER JOIN marca ON modelo.id_marca = marca.id WHERE modelo.nome = '" + nome + "';");
            rs.first();
            Marca marca = new Marca(rs.getInt("marca.id"), rs.getString("marca.nome"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            modelo = new Modelo(rs.getInt("modelo.id"), marca, rs.getString("modelo.nome"), categoria);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return modelo;

    }


    public void update(Modelo modelo) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update modelo set id_marca = '" + modelo.getMarca().getId() + "', id_categoria = '"
                    + modelo.getCategoria().getId()+ "', nome = '" + modelo.getNome() + " where id = "
                    + modelo.getId() + ";");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(String nome) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
           st.executeUpdate("delete from modelo where nome ='" + nome + "';");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Modelo modelo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into modelo (id_marca, id_categoria, nome)"
                    + " values (" + modelo.getMarca().getId() + ", " + modelo.getCategoria().getId() + ", "
                    + "'" + modelo.getNome() + "');");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
    }

}
