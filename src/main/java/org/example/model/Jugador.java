package org.example.model;

public class Jugador {
    private int id;
    private String nombre;
    private String posicion;
    private int edad;
    private int equipoID;

    public Jugador() {}

    public Jugador(int id, String nombre, String posicion, int edad, int equipoID) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
        this.equipoID = equipoID;
    }

    public Jugador(String nombre, String posicion, int edad, int equipoID) {
        this(0, nombre, posicion, edad, equipoID);
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public int getEquipoID() { return equipoID; }
    public void setEquipoID(int equipoID) { this.equipoID = equipoID; }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", edad=" + edad +
                ", equipoID=" + equipoID +
                '}';
    }
}
