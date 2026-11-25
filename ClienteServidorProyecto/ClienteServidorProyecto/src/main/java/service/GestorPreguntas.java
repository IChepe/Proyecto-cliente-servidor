package service;
import java.util.ArrayList;
import model.Pregunta;

/**
 *
 * @author AOV
 */
public class GestorPreguntas {
  private ArrayList<Pregunta> preguntas;
    private ArrayList<String> categorias;

    public GestorPreguntas() {
        preguntas = new ArrayList<>();
        categorias = new ArrayList<>();
        categorias.add("General");
        categorias.add("Tecnologia");
        categorias.add("Deportes");
        cargarPreguntas();
    }

    private void cargarPreguntas() {

        preguntas.add(new Pregunta(
                "Capital de Costa Rica",
                "San Jose", "Heredia", "Cartago", "Alajuela",
                "A", "General"));

        preguntas.add(new Pregunta(
                "Capital de Urugay",
                "Buenos Aires", "Santiago", "Montevideo", "Cordoba",
                "C", "General"));

        preguntas.add(new Pregunta(
                "Planeta rojo",
                "Tierra", "Marte", "Venus", "Jupiter",
                "B", "General"));

        preguntas.add(new Pregunta(
                "Cuantos huesos tiene el cuerpo humano",
                "310", "189", "206", "213",
                "C", "General"));

        preguntas.add(new Pregunta(
                "Lenguaje del curso",
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
                "Puntos por un partido ganado en Futbol",
                "3", "1", "2", "4",
                "A", "Deportes"));

        preguntas.add(new Pregunta(
                "Cuantos aros tiene una cancha de basket",
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

    public boolean editarPregunta(Pregunta vieja, Pregunta nueva) {

        // la nueva se valida al agregarla y despues se quita la vieja xd
        if (!agregarPregunta(nueva)) {
            return false;
        }

        preguntas.remove(vieja);
        return true;
    }

    public boolean eliminarPregunta(Pregunta pregunta) {
        return preguntas.remove(pregunta);
    }

    public ArrayList<Pregunta> buscarPreguntas(
            String categoria, String texto) {

        ArrayList<Pregunta> encontradas = new ArrayList<>();

        if (texto == null) {
            return encontradas;
        }

        for (Pregunta pregunta : preguntas) {

            if ((categoria == null
                    || pregunta.getCategoria().equalsIgnoreCase(categoria))
                    && pregunta.getEnunciado().toLowerCase().contains(
                            texto.toLowerCase())) {

                encontradas.add(pregunta);
            }
        }

        return encontradas;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public boolean agregarCategoria(String categoria) {

        if (categoria == null || categoria.trim().isEmpty()) {
            return false;
        }

        for (String existente : categorias) {

            if (existente.equalsIgnoreCase(categoria.trim())) {
                return false;
            }
        }

        categorias.add(categoria.trim());
        return true;
    }

    public boolean eliminarCategoria(String categoria) {

        if (categoria == null || contarPreguntas(categoria) > 0) {
            return false;
        }

        return categorias.remove(categoria);
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
// AOV.