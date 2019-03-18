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
import model.Carro;
import model.CarroEstado;
import model.Categoria;
import model.Marca;
import model.Modelo;
import model.StateFactory;

/**
 *
 * @author Gabriel
 */
public class CarroDAO {

    private static CarroDAO instance = new CarroDAO();

    public static CarroDAO getInstance() {
        return instance;
    }

    public ArrayList<Carro> getCarros() throws ClassNotFoundException, SQLException {
        ArrayList<Carro> carros = new ArrayList<Carro>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select carro.*, modelo.*, marca.*, categoria.* from carro "
                    + "INNER JOIN modelo ON carro.modelo_id = modelo.id "
                    + "INNER JOIN categoria ON modelo.categoria_id = categoria.id "
                    + "INNER JOIN marca ON modelo.marca_id = marca.id;");
            while (rs.next()) {
                Marca marca = new Marca(rs.getInt("marca.id"), rs.getString("marca.nome"));
                Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
                Modelo modelo = new Modelo(marca, rs.getString("modelo.nome"), categoria);
                Carro carro = new Carro(rs.getInt("carro.id"), modelo, rs.getString("carro.placa"), StateFactory.create(rs.getString("carro.estado")));
                carros.add(carro);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return carros;

    }

    public Carro getCarro(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Carro carro = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select carro.*, modelo.*, marca.* from carro "
                    + "INNER JOIN modelo ON carro.modelo_id = modelo.id "
                    + "INNER JOIN categoria ON modelo.categoria_id = categoria.id "
                    + "INNER JOIN marca ON modelo.marca_id = marca.id WHERE carro.id = " + id + ";");
            rs.first();
            Marca marca = new Marca(rs.getInt("marca.id"), rs.getString("marca.nome"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            Modelo modelo = new Modelo(marca, rs.getString("modelo.nome"), categoria);
            carro = new Carro(rs.getInt("carro.id"), modelo, rs.getString("carro.placa"), StateFactory.create(rs.getString("carro.estado")));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return carro;
    }
    
    public Carro getCarro(String placa) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        Carro carro = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select carro.*, modelo.*, marca.* from carro "
                    + "INNER JOIN modelo ON carro.id_modelo = modelo.id "
                    + "INNER JOIN categoria ON modelo.id_categoria = categoria.id "
                    + "INNER JOIN marca ON modelo.id_marca = marca.id WHERE carro.placa = " + placa + ";");
            rs.first();
            Marca marca = new Marca(rs.getInt("marca.id"), rs.getString("marca.nome"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            Modelo modelo = new Modelo(marca, rs.getString("modelo.nome"), categoria);
            carro = new Carro(rs.getInt("carro.id"), modelo, rs.getString("carro.placa"), StateFactory.create(rs.getString("carro.estado")));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return carro;
    }

    public void update(Carro carro) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update carro set id_modelo = '" + carro.getModelo().getId()+ "', placa = '" + 
                    carro.getPlaca() +"', estado = '" + carro.getEstado().toString() + " where id = " + 
                    carro.getId() + ";");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("delete from carro where id =" + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public void delete(String placa) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("delete from carro where placa =" + placa + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Carro carro) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into carro (id_modelo, placa, estado)"
                    + " values ('" + carro.getModelo().getId()+ "', '" + carro.getPlaca() + "', "
                            + "'" + carro.getEstado().toString() + "');");
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
