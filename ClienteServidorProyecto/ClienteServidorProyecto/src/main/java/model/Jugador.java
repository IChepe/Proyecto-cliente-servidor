/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author striv
 */
public class Jugador {
 private String nombre;
    private int puntos;
    private boolean listo;
    private boolean respondio;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        listo = false;
        respondio = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean isListo() {
        return listo;
    }

    public boolean isRespondio() {
        return respondio;
    }

    public void setListo(boolean listo) {
        this.listo = listo;
    }

    public void setRespondio(boolean respondio) {
        this.respondio = respondio;
    }

    public void sumarPuntos(int cantidad) {
        puntos += cantidad;
    }

    public void reiniciarPuntos() {
        puntos = 0;
    }
}