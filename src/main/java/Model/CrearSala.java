/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
import java.util.List;
/**
 *Esta clase es para definir los atributos de una sala de juego
 * @author gabri
 */
public class CrearSala {
    
    private String Pin ;
    private String nombreSala;
    private String Categoria;
    private int maxJugadores;
    private int cantidadPreguntas;
    private int tiempoPorPregunta;//segudos Minitps da iguak
    private String estadoSala;//si esta en espero , jugando o si ya termino
    private List<Jugador> jugadores;
    private List<Pregunta> preguntas;
    public CrearSala() {
        this.jugadores = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.estadoSala = "ESPERANDO";
    }

    public CrearSala(String Pin, String nombreSala, String Categoria, int maxJugadores, int cantidadPreguntas, int tiempoPorPregunta, String estadoSala, List<Jugador> jugadores, List<Pregunta> preguntas) {
        this.Pin = Pin;
        this.nombreSala = nombreSala;
        this.Categoria = Categoria;
        this.maxJugadores = maxJugadores;
        this.cantidadPreguntas = cantidadPreguntas;
        this.tiempoPorPregunta = tiempoPorPregunta;
        this.estadoSala = "Esperando";
        this.jugadores = new ArrayList<>();
        this.preguntas =new ArrayList<>();
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public int getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public void setCantidadPreguntas(int cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
    }

    public int getTiempoPorPregunta() {
        return tiempoPorPregunta;
    }

    public void setTiempoPorPregunta(int tiempoPorPregunta) {
        this.tiempoPorPregunta = tiempoPorPregunta;
    }

    public String getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(String estadoSala) {
        this.estadoSala = estadoSala;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
