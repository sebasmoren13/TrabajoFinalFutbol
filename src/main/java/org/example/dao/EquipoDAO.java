package org.example.dao;

import org.example.model.Equipo;
import java.util.List;

public interface EquipoDAO {
    void crear(Equipo equipo);
    Equipo obtenerPorId(int id);
    void actualizar(Equipo equipo);
    void eliminar(int id);
    List<Equipo> listar();
}
