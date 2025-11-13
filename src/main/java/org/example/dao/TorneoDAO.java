package org.example.dao;

import org.example.model.Torneo;
import java.util.List;

public interface TorneoDAO {
    void crear(Torneo torneo);
    Torneo obtenerPorId(int id);
    void actualizar(Torneo torneo);
    void eliminar(int id);
    List<Torneo> listar();
}
