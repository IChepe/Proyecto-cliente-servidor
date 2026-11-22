/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;
import java.util.Scanner;
import model.Jugador;
import model.Pregunta;
import model.Sala;
import service.GestorPreguntas;
import service.GestorSalas;

/**
 *
 * @author striv
 */
public class PruebaJuego {
    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        GestorPreguntas gestorPreguntas = new GestorPreguntas();
        GestorSalas gestorSalas = new GestorSalas();

        Sala sala = gestorSalas.crearSala(
                "Sala de prueba", "General", 2, 2);

        Jugador jugador1 = new Jugador("Ana");
        Jugador jugador2 = new Jugador("Luis");

        sala.agregarJugador(jugador1);
        sala.agregarJugador(jugador2);

        sala.marcarListo("Ana");
        sala.marcarListo("Luis");

        System.out.println("Sala creada, PIN: " + sala.getCodigo());

        if (sala.iniciarJuego(
                gestorPreguntas.obtenerPreguntas("General", 2))) {

            while (sala.isIniciada()) {

                Pregunta pregunta = sala.getPreguntaActual();

                System.out.println("\nRonda "
                        + (sala.getRonda() + 1));

                System.out.println(pregunta.getEnunciado());
                System.out.println("A: " + pregunta.getOpcionA());
                System.out.println("B: " + pregunta.getOpcionB());
                System.out.println("C: " + pregunta.getOpcionC());
                System.out.println("D: " + pregunta.getOpcionD());

                for (Jugador jugador : sala.getJugadores()) {

                    while (!jugador.isRespondio()) {

                        System.out.println("Respuesta de "
                                + jugador.getNombre() + ":");

                        String respuesta = teclado.nextLine().trim();

                        System.out.println(sala.responder(
                                jugador.getNombre(), respuesta));
                    }
                }

                System.out.println("Respuesta correcta: "
                        + pregunta.getRespuestaCorrecta());

                System.out.println(sala.mostrarPuntos());

                sala.siguienteRonda();
            }

            System.out.println("Ganador: "
                    + sala.obtenerGanador());

        } else {
            System.out.println("No fue posible iniciar la partida");
        }

        teclado.close();
    }
}

