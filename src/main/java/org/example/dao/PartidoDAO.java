package org.example.dao;

import org.example.model.Partido;
import java.util.List;

public interface PartidoDAO {
    void crear(Partido partido);
    Partido obtenerPorId(int id);
    void actualizar(Partido partido);
    void eliminar(int id);
    List<Partido> listar();
}
