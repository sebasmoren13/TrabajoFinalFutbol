package org.example.dao;

import org.example.model.Entrenador;
import java.util.List;

public interface EntrenadorDAO {
    void crear(Entrenador entrenador);
    Entrenador obtenerPorId(int id);
    void actualizar(Entrenador entrenador);
    void eliminar(int id);
    List<Entrenador> listar();
}
