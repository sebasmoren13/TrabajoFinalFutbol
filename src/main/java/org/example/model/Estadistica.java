package org.example.model;

public class Estadistica {
    private int id;
    private int jugadorID;
    private int partidoID;
    private int goles;
    private int asistencias;
    private int amarillas;
    private int rojas;

    public Estadistica(int id, int jugadorID, int partidoID, int goles, int asistencias, int amarillas, int rojas) {
        this.id = id;
        this.jugadorID = jugadorID;
        this.partidoID = partidoID;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
    }

    public Estadistica(int jugadorID, int partidoID, int goles, int asistencias, int amarillas, int rojas) {
        this.jugadorID = jugadorID;
        this.partidoID = partidoID;
        this.goles = goles;
        this.asistencias = asistencias;
        this.amarillas = amarillas;
        this.rojas = rojas;
    }

    public int getId() {
        return id;
    }

    public int getJugadorID() {
        return jugadorID;
    }

    public int getPartidoID() {
        return partidoID;
    }

    public int getGoles() {
        return goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getAmarillas() {
        return amarillas;
    }

    public int getRojas() {
        return rojas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJugadorID(int jugadorID) {
        this.jugadorID = jugadorID;
    }

    public void setPartidoID(int partidoID) {
        this.partidoID = partidoID;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public void setAmarillas(int amarillas) {
        this.amarillas = amarillas;
    }

    public void setRojas(int rojas) {
        this.rojas = rojas;
    }

    @Override
    public String toString() {
        return "Estadistica{" +
                "id=" + id +
                ", jugadorID=" + jugadorID +
                ", partidoID=" + partidoID +
                ", goles=" + goles +
                ", asistencias=" + asistencias +
                ", amarillas=" + amarillas +
                ", rojas=" + rojas +
                '}';
    }
}
