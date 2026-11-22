/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author striv
 */
public class Pregunta {
  private String enunciado;
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private String respuestaCorrecta;
    private String categoria;

    public Pregunta(String enunciado, String opcionA, String opcionB,
            String opcionC, String opcionD, String respuestaCorrecta,
            String categoria) {

        this.enunciado = enunciado;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.respuestaCorrecta = respuestaCorrecta;
        this.categoria = categoria;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public boolean verificarRespuesta(String respuesta) {

        if (respuesta == null) {
            return false;
        }

        return respuestaCorrecta.equalsIgnoreCase(respuesta.trim());
    }
}