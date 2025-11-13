package org.example;

import org.example.dao.*;
import org.example.model.*;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = ConexionBD.obtenerConexion()) {
            if (connection == null) {
                System.out.println(" No se pudo obtener conexión. Revisa la clase ConexionBD.");
                return;
            }

            EntrenadorDAO entrenadorDAO = new EntrenadorDAOimpl(connection);
            EquipoDAO equipoDAO = new EquipoDAOimpl(connection);
            JugadorDAO jugadorDAO = new JugadorDAOimpl(connection);
            TorneoDAO torneoDAO = new TorneoDAOimpl(connection);
            PartidoDAO partidoDAO = new PartidoDAOimpl(connection);
            EstadisticaDAO estadisticaDAO = new EstadisticaDAOimpl(connection);

            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n===  MENÚ PRINCIPAL ===");
                System.out.println("1. Gestionar Entrenadores");
                System.out.println("2. Gestionar Equipos");
                System.out.println("3. Gestionar Jugadores");
                System.out.println("4. Gestionar Torneos");
                System.out.println("5. Gestionar Partidos");
                System.out.println("6. Gestionar Estadísticas");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> menuEntrenadores(sc, entrenadorDAO);
                    case 2 -> menuEquipos(sc, equipoDAO);
                    case 3 -> menuJugadores(sc, jugadorDAO);
                    case 4 -> menuTorneos(sc, torneoDAO);
                    case 5 -> menuPartidos(sc, partidoDAO);
                    case 6 -> menuEstadisticas(sc, estadisticaDAO);
                    case 0 -> System.out.println(" Saliendo del sistema...");
                    default -> System.out.println(" Opción no válida.");
                }
            } while (opcion != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ------------------ ENTRENADORES ------------------
    private static void menuEntrenadores(Scanner sc, EntrenadorDAO dao) {
        int op;
        do {
            System.out.println("\n---  GESTIÓN DE ENTRENADORES ---");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(sc.nextLine());
                    dao.crear(new Entrenador(0, nombre, nacionalidad, edad));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.obtenerPorId(Integer.parseInt(sc.nextLine())));
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Entrenador e = dao.obtenerPorId(id);
                    if (e != null) {
                        System.out.print("Nuevo nombre (" + e.getNombre() + "): ");
                        String n = sc.nextLine();
                        if (!n.isEmpty()) e.setNombre(n);
                        System.out.print("Nueva nacionalidad (" + e.getNacionalidad() + "): ");
                        String nac = sc.nextLine();
                        if (!nac.isEmpty()) e.setNacionalidad(nac);
                        System.out.print("Nueva edad (" + e.getEdad() + "): ");
                        String ed = sc.nextLine();
                        if (!ed.isEmpty()) e.setEdad(Integer.parseInt(ed));
                        dao.actualizar(e);
                    } else System.out.println(" Entrenador no encontrado.");
                }
                case 4 -> {
                    System.out.print("ID: ");
                    dao.eliminar(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> dao.listar().forEach(System.out::println);
            }
        } while (op != 0);
    }

    // ------------------ EQUIPOS ------------------
    private static void menuEquipos(Scanner sc, EquipoDAO dao) {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE EQUIPOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = sc.nextLine();
                    dao.crear(new Equipo(0, nombre, ciudad));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.obtenerPorId(Integer.parseInt(sc.nextLine())));
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Equipo eq = dao.obtenerPorId(id);
                    if (eq != null) {
                        System.out.print("Nuevo nombre (" + eq.getNombre() + "): ");
                        String n = sc.nextLine();
                        if (!n.isEmpty()) eq.setNombre(n);
                        System.out.print("Nueva ciudad (" + eq.getCiudad() + "): ");
                        String c = sc.nextLine();
                        if (!c.isEmpty()) eq.setCiudad(c);
                        dao.actualizar(eq);
                    } else System.out.println(" Equipo no encontrado.");
                }
                case 4 -> {
                    System.out.print("ID: ");
                    dao.eliminar(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> dao.listar().forEach(System.out::println);
            }
        } while (op != 0);
    }

    // ------------------ JUGADORES ------------------
    private static void menuJugadores(Scanner sc, JugadorDAO dao) {
        int op;
        do {
            System.out.println("\n---  GESTIÓN DE JUGADORES ---");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Posición: ");
                    String posicion = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(sc.nextLine());
                    System.out.print("ID del equipo: ");
                    int equipoID = Integer.parseInt(sc.nextLine());
                    dao.crear(new Jugador(0, nombre, posicion, edad, equipoID));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.obtenerPorId(Integer.parseInt(sc.nextLine())));
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Jugador j = dao.obtenerPorId(id);
                    if (j != null) {
                        System.out.print("Nuevo nombre (" + j.getNombre() + "): ");
                        String n = sc.nextLine();
                        if (!n.isEmpty()) j.setNombre(n);
                        System.out.print("Nueva posición (" + j.getPosicion() + "): ");
                        String p = sc.nextLine();
                        if (!p.isEmpty()) j.setPosicion(p);
                        dao.actualizar(j);
                    } else System.out.println(" Jugador no encontrado.");
                }
                case 4 -> {
                    System.out.print("ID: ");
                    dao.eliminar(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> dao.listar().forEach(System.out::println);
            }
        } while (op != 0);
    }

    // ------------------ TORNEOS ------------------
    private static void menuTorneos(Scanner sc, TorneoDAO dao) {
        int op;
        do {
            System.out.println("\n---  GESTIÓN DE TORNEOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("País: ");
                    String pais = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = Integer.parseInt(sc.nextLine());
                    dao.crear(new Torneo(0, nombre, pais, anio));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.obtenerPorId(Integer.parseInt(sc.nextLine())));
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Torneo t = dao.obtenerPorId(id);
                    if (t != null) {
                        System.out.print("Nuevo nombre (" + t.getNombre() + "): ");
                        String n = sc.nextLine();
                        if (!n.isEmpty()) t.setNombre(n);
                        dao.actualizar(t);
                    } else System.out.println(" Torneo no encontrado.");
                }
                case 4 -> {
                    System.out.print("ID: ");
                    dao.eliminar(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> dao.listar().forEach(System.out::println);
            }
        } while (op != 0);
    }

    // ------------------ PARTIDOS ------------------
    private static void menuPartidos(Scanner sc, PartidoDAO dao) {
        int op;
        do {
            System.out.println("\n---  GESTIÓN DE PARTIDOS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Actualizar marcador");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("ID equipo local: ");
                    int local = Integer.parseInt(sc.nextLine());

                    System.out.print("ID equipo visitante: ");
                    int visitante = Integer.parseInt(sc.nextLine());

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(sc.nextLine());

                    System.out.print("ID torneo: ");
                    int torneo = Integer.parseInt(sc.nextLine());

                    System.out.print("Goles equipo local: ");
                    int marcadorLocal = Integer.parseInt(sc.nextLine());

                    System.out.print("Goles equipo visitante: ");
                    int marcadorVisitante = Integer.parseInt(sc.nextLine());


                    Partido nuevo = new Partido(
                            0,
                            fecha,
                            marcadorLocal,
                            marcadorVisitante,
                            local,
                            visitante,
                            torneo
                    );
                    dao.crear(nuevo);
                    System.out.println(" Partido registrado correctamente.");
                }

                case 2 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Partido partido = dao.obtenerPorId(id);
                    if (partido != null)
                        System.out.println(partido);
                    else
                        System.out.println(" Partido no encontrado.");
                }

                case 3 -> {
                    System.out.print("ID del partido a actualizar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Partido p = dao.obtenerPorId(id);
                    if (p != null) {
                        System.out.print("Nuevo marcador local (" + p.getMarcadorLocal() + "): ");
                        String nuevoLocal = sc.nextLine();
                        if (!nuevoLocal.isEmpty()) p.setMarcadorLocal(Integer.parseInt(nuevoLocal));

                        System.out.print("Nuevo marcador visitante (" + p.getMarcadorVisitante() + "): ");
                        String nuevoVisitante = sc.nextLine();
                        if (!nuevoVisitante.isEmpty()) p.setMarcadorVisitante(Integer.parseInt(nuevoVisitante));

                        dao.actualizar(p);
                        System.out.println(" Marcador actualizado correctamente.");
                    } else {
                        System.out.println(" Partido no encontrado.");
                    }
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    dao.eliminar(id);
                    System.out.println(" Partido eliminado correctamente.");
                }

                case 5 -> {
                    System.out.println("\n Lista de partidos:");
                    dao.listar().forEach(System.out::println);
                }
            }
        } while (op != 0);
    }


    // ------------------ ESTADÍSTICAS ------------------
    private static void menuEstadisticas(Scanner sc, EstadisticaDAO dao) {
        int op;
        do {
            System.out.println("\n---  GESTIÓN DE ESTADÍSTICAS ---");
            System.out.println("1. Registrar");
            System.out.println("2. Consultar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("ID jugador: ");
                    int jugador = Integer.parseInt(sc.nextLine());
                    System.out.print("ID partido: ");
                    int partido = Integer.parseInt(sc.nextLine());
                    System.out.print("Goles: ");
                    int goles = Integer.parseInt(sc.nextLine());
                    System.out.print("Asistencias: ");
                    int asist = Integer.parseInt(sc.nextLine());
                    System.out.print("Amarillas: ");
                    int amar = Integer.parseInt(sc.nextLine());
                    System.out.print("Rojas: ");
                    int rojas = Integer.parseInt(sc.nextLine());
                    dao.crear(new Estadistica(0, jugador, partido, goles, asist, amar, rojas));
                }
                case 2 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.obtenerPorId(Integer.parseInt(sc.nextLine())));
                }
                case 3 -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Estadistica e = dao.obtenerPorId(id);
                    if (e != null) {
                        System.out.print("Nuevos goles (" + e.getGoles() + "): ");
                        String g = sc.nextLine();
                        if (!g.isEmpty()) e.setGoles(Integer.parseInt(g));
                        dao.actualizar(e);
                    } else System.out.println(" Estadística no encontrada.");
                }
                case 4 -> {
                    System.out.print("ID: ");
                    dao.eliminar(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> dao.listar().forEach(System.out::println);
            }
        } while (op != 0);
    }
}
