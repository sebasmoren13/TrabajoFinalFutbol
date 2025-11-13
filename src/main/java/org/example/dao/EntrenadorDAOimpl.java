package org.example.dao;

import org.example.model.Entrenador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDAOimpl implements EntrenadorDAO {
    private final Connection connection;

    public EntrenadorDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Entrenador entrenador) {
        String sql = "INSERT INTO entrenadores (nombre, nacionalidad, edad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entrenador.getNombre());
            stmt.setString(2, entrenador.getNacionalidad());
            stmt.setInt(3, entrenador.getEdad());
            stmt.executeUpdate();
            System.out.println(" Entrenador agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Entrenador obtenerPorId(int id) {
        String sql = "SELECT * FROM entrenadores WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Entrenador(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("nacionalidad"), rs.getInt("edad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Entrenador entrenador) {
        String sql = "UPDATE entrenadores SET nombre = ?, nacionalidad = ?, edad = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, entrenador.getNombre());
            stmt.setString(2, entrenador.getNacionalidad());
            stmt.setInt(3, entrenador.getEdad());
            stmt.setInt(4, entrenador.getId());
            stmt.executeUpdate();
            System.out.println(" Entrenador actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM entrenadores WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Entrenador eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Entrenador> listar() {
        List<Entrenador> entrenadores = new ArrayList<>();
        String sql = "SELECT * FROM entrenadores";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                entrenadores.add(new Entrenador(
                        rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("nacionalidad"), rs.getInt("edad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entrenadores;
    }
}
