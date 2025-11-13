package org.example.model;

public class Entrenador {
    private int id;
    private String nombre;
    private String nacionalidad;
    private int edad;

    public Entrenador() {}

    public Entrenador(int id, String nombre, String nacionalidad, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }

    public Entrenador(String nombre, String nacionalidad, int edad) {
        this(0, nombre, nacionalidad, edad);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                '}';
    }
}
