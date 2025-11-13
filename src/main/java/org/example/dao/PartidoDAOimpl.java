package org.example.dao;

import org.example.model.Partido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartidoDAOimpl implements PartidoDAO {
    private final Connection connection;

    public PartidoDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Partido partido) {
        String sql = "INSERT INTO partidos (fecha, equipoLocalId, equipoVisitanteId, marcadorLocal, marcadorVisitante, torneoId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(partido.getFecha()));
            stmt.setInt(2, partido.getEquipoLocalId());
            stmt.setInt(3, partido.getEquipoVisitanteId());
            stmt.setInt(4, partido.getMarcadorLocal());
            stmt.setInt(5, partido.getMarcadorVisitante());
            stmt.setInt(6, partido.getTorneoId());
            stmt.executeUpdate();
            System.out.println(" Partido agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partido obtenerPorId(int id) {
        String sql = "SELECT * FROM partidos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Partido(
                        rs.getInt("id"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("equipoLocalId"),
                        rs.getInt("equipoVisitanteId"),
                        rs.getInt("marcadorLocal"),
                        rs.getInt("marcadorVisitante"),
                        rs.getInt("torneoId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Partido partido) {
        String sql = "UPDATE partidos SET fecha = ?, equipoLocalId = ?, equipoVisitanteId = ?, marcadorLocal = ?, marcadorVisitante = ?, torneoId = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(partido.getFecha()));
            stmt.setInt(2, partido.getEquipoLocalId());
            stmt.setInt(3, partido.getEquipoVisitanteId());
            stmt.setInt(4, partido.getMarcadorLocal());
            stmt.setInt(5, partido.getMarcadorVisitante());
            stmt.setInt(6, partido.getTorneoId());
            stmt.setInt(7, partido.getId());
            stmt.executeUpdate();
            System.out.println(" Partido actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM partidos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Partido eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Partido> listar() {
        List<Partido> partidos = new ArrayList<>();
        String sql = "SELECT * FROM partidos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                partidos.add(new Partido(
                        rs.getInt("id"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("equipoLocalId"),
                        rs.getInt("equipoVisitanteId"),
                        rs.getInt("marcadorLocal"),
                        rs.getInt("marcadorVisitante"),
                        rs.getInt("torneoId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }
}
