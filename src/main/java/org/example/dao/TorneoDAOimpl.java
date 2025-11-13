package org.example.dao;

import org.example.model.Torneo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TorneoDAOimpl implements TorneoDAO {

    private Connection conn;

    public TorneoDAOimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void crear(Torneo torneo) {
        String sql = "INSERT INTO torneos (nombre, pais, anio) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, torneo.getNombre());
            ps.setString(2, torneo.getPais());
            ps.setInt(3, torneo.getAnio());
            ps.executeUpdate();
            System.out.println(" Torneo agregado correctamente.");
        } catch (SQLException e) {
            System.out.println(" Error al agregar el torneo: " + e.getMessage());
        }
    }

    @Override
    public Torneo obtenerPorId(int id) {
        String sql = "SELECT * FROM torneos WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Torneo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("pais"),
                        rs.getInt("anio")
                );
            }
        } catch (SQLException e) {
            System.out.println(" Error al obtener el torneo: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizar(Torneo torneo) {
        String sql = "UPDATE torneos SET nombre = ?, pais = ?, anio = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, torneo.getNombre());
            ps.setString(2, torneo.getPais());
            ps.setInt(3, torneo.getAnio());
            ps.setInt(4, torneo.getId());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println(" Torneo actualizado correctamente.");
            } else {
                System.out.println(" No se encontró el torneo con ID: " + torneo.getId());
            }
        } catch (SQLException e) {
            System.out.println(" Error al actualizar el torneo: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM torneos WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Torneo eliminado correctamente.");
            } else {
                System.out.println(" No se encontró el torneo con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println(" Error al eliminar el torneo: " + e.getMessage());
        }
    }

    @Override
    public List<Torneo> listar() {
        List<Torneo> torneos = new ArrayList<>();
        String sql = "SELECT * FROM torneos";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Torneo t = new Torneo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("pais"),
                        rs.getInt("anio")
                );
                torneos.add(t);
            }
        } catch (SQLException e) {
            System.out.println(" Error al listar torneos: " + e.getMessage());
        }
        return torneos;
    }
}
