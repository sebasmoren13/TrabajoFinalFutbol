package org.example.model;

import java.time.LocalDate;

public class Partido {
    private int id;
    private int equipoLocalId;
    private int equipoVisitanteId;
    private LocalDate fecha;
    private int torneoId;
    private int marcadorLocal;
    private int marcadorVisitante;

    public Partido() {}

    // Constructor completo que usa los mismos parámetros que tu DAO
    public Partido(int id, LocalDate fecha, int marcadorLocal, int marcadorVisitante,
                   int equipoLocalId, int equipoVisitanteId, int torneoId) {
        this.id = id;
        this.fecha = fecha;
        this.marcadorLocal = marcadorLocal;
        this.marcadorVisitante = marcadorVisitante;
        this.equipoLocalId = equipoLocalId;
        this.equipoVisitanteId = equipoVisitanteId;
        this.torneoId = torneoId;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEquipoLocalId() { return equipoLocalId; }
    public void setEquipoLocalId(int equipoLocalId) { this.equipoLocalId = equipoLocalId; }

    public int getEquipoVisitanteId() { return equipoVisitanteId; }
    public void setEquipoVisitanteId(int equipoVisitanteId) { this.equipoVisitanteId = equipoVisitanteId; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public int getTorneoId() { return torneoId; }
    public void setTorneoId(int torneoId) { this.torneoId = torneoId; }

    public int getMarcadorLocal() { return marcadorLocal; }
    public void setMarcadorLocal(int marcadorLocal) { this.marcadorLocal = marcadorLocal; }

    public int getMarcadorVisitante() { return marcadorVisitante; }
    public void setMarcadorVisitante(int marcadorVisitante) { this.marcadorVisitante = marcadorVisitante; }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", equipoLocalId=" + equipoLocalId +
                ", equipoVisitanteId=" + equipoVisitanteId +
                ", fecha=" + fecha +
                ", torneoId=" + torneoId +
                ", marcadorLocal=" + marcadorLocal +
                ", marcadorVisitante=" + marcadorVisitante +
                '}';
    }
}
