package org.example.dao;

import org.example.model.Equipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAOimpl implements EquipoDAO {

    private final Connection connection;

    public EquipoDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Equipo equipo) {
        String sql = "INSERT INTO equipos (nombre, ciudad) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getCiudad());
            stmt.executeUpdate();
            System.out.println(" Equipo agregado correctamente.");
        } catch (SQLException e) {
            System.err.println(" Error al crear equipo: " + e.getMessage());
        }
    }

    @Override
    public Equipo obtenerPorId(int id) {
        String sql = "SELECT * FROM equipos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Equipo(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("ciudad")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println(" Error al obtener equipo: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizar(Equipo equipo) {
        String sql = "UPDATE equipos SET nombre = ?, ciudad = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getCiudad());
            stmt.setInt(3, equipo.getId());
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Equipo actualizado correctamente.");
            } else {
                System.out.println(" No se encontró el equipo con ID " + equipo.getId());
            }
        } catch (SQLException e) {
            System.err.println(" Error al actualizar equipo: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM equipos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Equipo eliminado correctamente.");
            } else {
                System.out.println("️ No se encontró el equipo con ID " + id);
            }
        } catch (SQLException e) {
            System.err.println(" Error al eliminar equipo: " + e.getMessage());
        }
    }

    @Override
    public List<Equipo> listar() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipos";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                equipos.add(new Equipo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ciudad")
                ));
            }
        } catch (SQLException e) {
            System.err.println(" Error al listar equipos: " + e.getMessage());
        }
        return equipos;
    }
}
