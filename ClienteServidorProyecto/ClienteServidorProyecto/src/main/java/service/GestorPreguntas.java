/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import model.Pregunta;

/**
 *
 * @author striv
 */
public class GestorPreguntas {
  private ArrayList<Pregunta> preguntas;

    public GestorPreguntas() {
        preguntas = new ArrayList<>();
        cargarPreguntas();
    }

    private void cargarPreguntas() {

        preguntas.add(new Pregunta(
                "Capital de Costa Rica",
                "San Jose", "Heredia", "Cartago", "Alajuela",
                "A", "General"));

        preguntas.add(new Pregunta(
                "Dias de una semana",
                "5", "6", "7", "8",
                "C", "General"));

        preguntas.add(new Pregunta(
                "Planeta rojo",
                "Tierra", "Marte", "Venus", "Jupiter",
                "B", "General"));

        preguntas.add(new Pregunta(
                "Cuantos meses tiene un año",
                "10", "11", "12", "13",
                "C", "General"));

        preguntas.add(new Pregunta(
                "Lenguaje del proyecto",
                "Python", "Java", "HTML", "PHP",
                "B", "Tecnologia"));

        preguntas.add(new Pregunta(
                "Estructura para guardar varios elementos",
                "if", "ArrayList", "return", "break",
                "B", "Tecnologia"));

        preguntas.add(new Pregunta(
                "Palabra para crear un objeto",
                "new", "void", "int", "else",
                "A", "Tecnologia"));

        preguntas.add(new Pregunta(
                "Tipo de dato para verdadero o falso",
                "String", "double", "boolean", "char",
                "C", "Tecnologia"));

        preguntas.add(new Pregunta(
                "Jugadores de un equipo de futbol en cancha",
                "10", "11", "9", "12",
                "B", "Deportes"));

        preguntas.add(new Pregunta(
                "Deporte que usa raqueta",
                "Natacion", "Atletismo", "Tenis", "Ciclismo",
                "C", "Deportes"));

        preguntas.add(new Pregunta(
                "Puntos por un tiro libre de baloncesto",
                "1", "2", "3", "4",
                "A", "Deportes"));

        preguntas.add(new Pregunta(
                "Cuantos aros tiene una cancha de baloncesto",
                "1", "2", "3", "4",
                "B", "Deportes"));
    }

    public boolean agregarPregunta(Pregunta pregunta) {

        if (pregunta == null || pregunta.getEnunciado() == null
                || pregunta.getEnunciado().trim().isEmpty()
                || pregunta.getCategoria() == null
                || pregunta.getCategoria().trim().isEmpty()) {

            return false;
        }

        preguntas.add(pregunta);
        return true;
    }

    public int contarPreguntas(String categoria) {

        int cantidad = 0;

        if (categoria == null) {
            return 0;
        }

        for (Pregunta pregunta : preguntas) {

            if (pregunta.getCategoria().equalsIgnoreCase(categoria)) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public ArrayList<Pregunta> obtenerPreguntas(
            String categoria, int cantidad) {

        ArrayList<Pregunta> seleccionadas = new ArrayList<>();

        if (cantidad < 1 || categoria == null) {
            return seleccionadas;
        }

        for (Pregunta pregunta : preguntas) {

            if (pregunta.getCategoria().equalsIgnoreCase(categoria)
                    && seleccionadas.size() < cantidad) {

                seleccionadas.add(pregunta);
            }
        }

        return seleccionadas;
    }
}