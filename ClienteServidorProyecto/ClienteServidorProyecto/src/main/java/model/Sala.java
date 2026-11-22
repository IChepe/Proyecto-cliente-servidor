/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author striv
 */
public class Sala {

 private String codigo;
    private String nombre;
    private String categoria;
    private int cantidadPreguntas;
    private int capacidad;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntasPartida;
    private int ronda;
    private boolean iniciada;
    private boolean finalizada;

    public Sala(String codigo, String nombre, String categoria,
            int cantidadPreguntas, int capacidad) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidadPreguntas = cantidadPreguntas;
        this.capacidad = capacidad;

        jugadores = new ArrayList<>();
        preguntasPartida = new ArrayList<>();
        ronda = 0;
        iniciada = false;
        finalizada = false;
    }

    public boolean agregarJugador(Jugador jugador) {

        if (jugador == null || jugador.getNombre() == null
                || jugador.getNombre().trim().isEmpty()
                || iniciada || finalizada
                || jugadores.size() >= capacidad) {
            return false;
        }

        if (buscarJugador(jugador.getNombre()) != null) {
            return false;
        }

        jugadores.add(jugador);
        return true;
    }

    public Jugador buscarJugador(String nombreJugador) {

        if (nombreJugador == null) {
            return null;
        }

        for (Jugador jugador : jugadores) {

            if (jugador.getNombre().equalsIgnoreCase(
                    nombreJugador.trim())) {
                return jugador;
            }
        }

        return null;
    }

    public boolean quitarJugador(String nombreJugador) {

        if (iniciada) {
            return false;
        }

        Jugador jugador = buscarJugador(nombreJugador);

        if (jugador == null) {
            return false;
        }

        jugadores.remove(jugador);
        return true;
    }

    public boolean marcarListo(String nombreJugador) {

        Jugador jugador = buscarJugador(nombreJugador);

        if (jugador == null || iniciada || finalizada) {
            return false;
        }

        jugador.setListo(true);
        return true;
    }

    public boolean todosListos() {

        if (jugadores.size() < 2) {
            return false;
        }

        for (Jugador jugador : jugadores) {

            if (!jugador.isListo()) {
                return false;
            }
        }

        return true;
    }

    public boolean iniciarJuego(ArrayList<Pregunta> preguntas) {

        if (iniciada || finalizada || !todosListos()
                || preguntas == null
                || preguntas.size() != cantidadPreguntas) {
            return false;
        }

        preguntasPartida = preguntas;
        ronda = 0;
        iniciada = true;

        for (Jugador jugador : jugadores) {
            jugador.reiniciarPuntos();
            jugador.setRespondio(false);
        }

        return true;
    }

    public Pregunta getPreguntaActual() {

        if (!iniciada || ronda >= preguntasPartida.size()) {
            return null;
        }

        return preguntasPartida.get(ronda);
    }

    public String responder(String nombreJugador, String respuesta) {

        if (!iniciada) {
            return "Partida no iniciada";
        }

        Jugador jugador = buscarJugador(nombreJugador);

        if (jugador == null) {
            return "Jugador no encontrado";
        }

        if (jugador.isRespondio()) {
            return "Ya respondio esta ronda";
        }

        if (respuesta == null
                || (!respuesta.equalsIgnoreCase("A")
                && !respuesta.equalsIgnoreCase("B")
                && !respuesta.equalsIgnoreCase("C")
                && !respuesta.equalsIgnoreCase("D"))) {

            return "Respuesta invalida";
        }

        jugador.setRespondio(true);

        if (getPreguntaActual().verificarRespuesta(respuesta)) {
            jugador.sumarPuntos(10);
            return "Correcta, gana 10 puntos";
        }

        return "Incorrecta";
    }

    public boolean todosRespondieron() {

        if (!iniciada) {
            return false;
        }

        for (Jugador jugador : jugadores) {

            if (!jugador.isRespondio()) {
                return false;
            }
        }

        return true;
    }

    public boolean siguienteRonda() {

        if (!todosRespondieron()) {
            return false;
        }

        ronda++;

        if (ronda >= preguntasPartida.size()) {
            iniciada = false;
            finalizada = true;

        } else {

            for (Jugador jugador : jugadores) {
                jugador.setRespondio(false);
            }
        }

        return true;
    }

    public String mostrarPuntos() {

        String resultado = "";

        for (Jugador jugador : jugadores) {

            resultado += jugador.getNombre() + ": "
                    + jugador.getPuntos() + " puntos\n";
        }

        return resultado;
    }

    public String obtenerGanador() {

        if (!finalizada || jugadores.isEmpty()) {
            return "Partida no finalizada";
        }

        int mayor = -1;
        String ganador = "";
        boolean empate = false;

        for (Jugador jugador : jugadores) {

            if (jugador.getPuntos() > mayor) {
                mayor = jugador.getPuntos();
                ganador = jugador.getNombre();
                empate = false;

            } else if (jugador.getPuntos() == mayor) {
                empate = true;
            }
        }

        if (empate) {
            return "Empate";
        }

        return ganador;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getRonda() {
        return ronda;
    }

    public boolean isIniciada() {
        return iniciada;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}