/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Model.Jugador;
import Model.Pregunta;
import Model.CrearSala;
import Exception.ConexionException;
import Exception.SalaException;
import Exception.ValidacionException;
import java.util.HashMap;
import java.util.Map;
//imports necesarios 

/**aca se manejara toda la logica del juego
 *
 * @author gabri
 */
public class GestorJuego {
    private final Map<String, CrearSala> salas = new HashMap<>();
    //vemos si esta vacio 
    public boolean esVacio(String s) {
        return s == null || s.trim().isEmpty();
    }
    
    //verificamos que nick no sea null y que no tenga un nombre tan extravotico 
    public void validarNick(String nick) throws ValidacionException {
        if (esVacio(nick)) {
            throw new ValidacionException("Debe ingresar un nombre o nick (no puede estar vacio)");
        }//fin if 
        if (nick.trim().length() > 20) {
            throw new ValidacionException("El nick no puede tener mas de 20 caracteres");
        }//fin iff
    
    }//fin de valida
    
    public void validarPin(String Pin) throws ValidacionException {
        if(esVacio(Pin)) {//en caso que el pin
            throw new ValidacionException("Debe ingresar el PIN de la sala");
        }//if 
        if (Pin.trim().length() != 6) {
        throw new ValidacionException("El PIN debe tener exactamente 6 numeros ");
        }//fin if 
        
    }//fin validar pint
    
    //metodo para validar las salas
    public void validarSala(CrearSala sala) throws ValidacionException {
        if (sala == null) {
            throw new ValidacionException("Los datos de la sala no pueden ser nulos");
        }
        if (esVacio(sala.getNombreSala())) {
            throw new ValidacionException("Debe ingresar el nombre de la sala");
        }
        if (esVacio(sala.getCategoria())) {
            throw new ValidacionException("Debe ingresar una categoria");
        }
        if (sala.getMaxJugadores() < 2 || sala.getMaxJugadores() > 8) {//esta puede variar
            throw new ValidacionException("La cantidad maxima de jugadores debe estar entre 2 y 8");
        }
        if (sala.getCantidadPreguntas() < 1 || sala.getCantidadPreguntas() > 8) {//limite a las preguntas para que no sea tan largo
            throw new ValidacionException("La cantidad de preguntas debe estar entre 1 y 8");
        }
        if (sala.getTiempoPorPregunta() <= 0 || sala.getTiempoPorPregunta() >= 300) {//ni modo que eeste media hora para responder una pregunta
            throw new ValidacionException("El tiempo por pregunta debe ser mayor a 0 segundos y menor a 5 minutos ");
        }
        
    }//fin de metodo para validar las salss 
    
    //metodo para Validar las preguntas
    public void validarPregunta(Pregunta pregunta) throws ValidacionException {
        if (pregunta == null) {
            throw new ValidacionException("La pregunta no puede ser null");
            
        }
        if (esVacio(pregunta.getEnunciado())) {
            throw new ValidacionException("Debe ingresar el enunciado de la pregunta");
        }
        if (esVacio(pregunta.getOpcionA()) || esVacio(pregunta.getOpcionB())
                || esVacio(pregunta.getOpcionC()) || esVacio(pregunta.getOpcionD())) {
            throw new ValidacionException("Debe completar las cuatro opciones (A, B, C y D).");
        }
        if (esVacio(pregunta.getRespuestaCorrecta())) {
            throw new ValidacionException("Debe indicar cual es la respuesta correcta.");
        }
    
    }//fin de metodo para validar Preguntas
    
    
    
    
    //este es para generar un pin unico 
    private String GenerarPinUnico() {
        String pin;
        do {
            int num = (int) (Math.random() * 900000) + 100000;//itulizamsos random para generar un codigo inico 
            pin = String.valueOf(num);
        } while (salas.containsKey(pin));
        return pin;
    }
    
    
    
    
}
