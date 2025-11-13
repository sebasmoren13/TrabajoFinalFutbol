package org.example.dao;

import org.example.model.Estadistica;
import java.util.List;

public interface EstadisticaDAO {
    void crear(Estadistica estadistica);
    Estadistica obtenerPorId(int id);
    void actualizar(Estadistica estadistica);
    void eliminar(int id);
    List<Estadistica> listar();
}
