package org.example.dao;

import org.example.model.Jugador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAOimpl implements JugadorDAO {
    private final Connection connection;

    public JugadorDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Jugador jugador) {
        String sql = "INSERT INTO jugadores (nombre, posicion, edad, equipoID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getPosicion());
            stmt.setInt(3, jugador.getEdad());
            stmt.setInt(4, jugador.getEquipoID());
            stmt.executeUpdate();
            System.out.println(" Jugador agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Jugador obtenerPorId(int id) {
        String sql = "SELECT * FROM jugadores WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Jugador(rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("posicion"), rs.getInt("edad"), rs.getInt("equipoID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Jugador jugador) {
        String sql = "UPDATE jugadores SET nombre=?, posicion=?, edad=?, equipoID=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getPosicion());
            stmt.setInt(3, jugador.getEdad());
            stmt.setInt(4, jugador.getEquipoID());
            stmt.setInt(5, jugador.getId());
            stmt.executeUpdate();
            System.out.println(" Jugador actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM jugadores WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println(" Jugador eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Jugador> listar() {
        List<Jugador> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM jugadores";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                jugadores.add(new Jugador(
                        rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("posicion"), rs.getInt("edad"), rs.getInt("equipoID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }
}
