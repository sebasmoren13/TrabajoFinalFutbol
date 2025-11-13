package org.example.dao;

import org.example.model.Estadistica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadisticaDAOimpl implements EstadisticaDAO {
    private final Connection connection;

    public EstadisticaDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Estadistica estadistica) {
        String sql = "INSERT INTO estadisticas (jugadorID, goles, asistencias, amarillas, rojas) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, estadistica.getJugadorID());
            stmt.setInt(2, estadistica.getGoles());
            stmt.setInt(3, estadistica.getAsistencias());
            stmt.setInt(4, estadistica.getAmarillas());
            stmt.setInt(5, estadistica.getRojas());
            stmt.executeUpdate();
            System.out.println(" Estadística agregada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estadistica obtenerPorId(int id) {
        String sql = "SELECT * FROM estadisticas WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estadistica(
                        rs.getInt("id"),
                        rs.getInt("jugadorID"),
                        rs.getInt("goles"),
                        rs.getInt("asistencias"),
                        rs.getInt("amarillas"),
                        rs.getInt("rojas")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Estadistica estadistica) {
        String sql = "UPDATE estadisticas SET jugadorID=?, goles=?, asistencias=?, amarillas=?, rojas=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, estadistica.getJugadorID());
            stmt.setInt(2, estadistica.getGoles());
            stmt.setInt(3, estadistica.getAsistencias());
            stmt.setInt(4, estadistica.getAmarillas());
            stmt.setInt(5, estadistica.getRojas());
            stmt.setInt(6, estadistica.getId());
            stmt.executeUpdate();
            System.out.println(" Estadística actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM estadisticas WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Estadística eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Estadistica> listar() {
        List<Estadistica> estadisticas = new ArrayList<>();
        String sql = "SELECT * FROM estadisticas";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estadisticas.add(new Estadistica(
                        rs.getInt("id"),
                        rs.getInt("jugadorID"),
                        rs.getInt("goles"),
                        rs.getInt("asistencias"),
                        rs.getInt("amarillas"),
                        rs.getInt("rojas")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadisticas;
    }
}
