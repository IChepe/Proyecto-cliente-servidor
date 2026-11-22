/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.HashMap;
import java.util.Random;
import model.Sala;
/**
 *
 * @author striv
 */
public class GestorSalas {
 

    private HashMap<String, Sala> salas;
    private Random aleatorio;

    public GestorSalas() {
        salas = new HashMap<>();
        aleatorio = new Random();
    }

    public Sala crearSala(String nombre, String categoria,
            int cantidadPreguntas, int capacidad) {

        if (nombre == null || nombre.trim().isEmpty()
                || categoria == null || categoria.trim().isEmpty()
                || cantidadPreguntas < 1 || capacidad < 2) {

            return null;
        }

        String codigo;

        do {
            codigo = "" + (aleatorio.nextInt(9000) + 1000);
        } while (salas.containsKey(codigo));

        Sala sala = new Sala(codigo, nombre, categoria,
                cantidadPreguntas, capacidad);

        salas.put(codigo, sala);

        return sala;
    }

    public Sala buscarSala(String codigo) {

        if (codigo == null) {
            return null;
        }

        return salas.get(codigo);
    }

    public boolean eliminarSala(String codigo) {

        if (!salas.containsKey(codigo)) {
            return false;
        }

        salas.remove(codigo);
        return true;
    }
}