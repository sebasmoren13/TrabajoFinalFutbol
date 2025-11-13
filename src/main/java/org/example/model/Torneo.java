package org.example.model;

public class Torneo {
    private int id;
    private String nombre;
    private String pais;
    private int anio;

    public Torneo() {}

    // Constructor principal (coincide con la BD)
    public Torneo(int id, String nombre, String pais, int anio) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.anio = anio;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", anio=" + anio +
                '}';
    }
}
