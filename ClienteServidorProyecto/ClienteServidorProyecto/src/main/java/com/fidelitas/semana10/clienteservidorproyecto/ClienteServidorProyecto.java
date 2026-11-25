/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fidelitas.semana10.clienteservidorproyecto;

import service.GestorPreguntas;
import service.GestorSalas;
import ui.VentanaInicio;

/**
 *
 * @author gabri
 */
public class ClienteServidorProyecto {

    public static void main(String[] args) {
        /* ejemplo profesor 
        //  Instanciamos el gestor (que ya trae los datos precargados)
        GestorEstudiante gestor = new GestorEstudiante();
        
        //  Instanciamos la ventana principal pasándole el gestor
        MainFrane mf = new MainFrane(gestor);
        
        //  Centramos el frame en la pantalla
        mf.setLocationRelativeTo(null); 
        
        // 4 Lanzamos la interfaz gráfica en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> mf.setVisible(true));
        */

        //  Instanciamos los gestores (GestorPreguntas ya trae las preguntas precargadas)
        GestorSalas gestorSalas = new GestorSalas();
        GestorPreguntas gestorPreguntas = new GestorPreguntas();

        //  Instanciamos la ventana principal pasándole los gestores
        VentanaInicio vi = new VentanaInicio(gestorSalas, gestorPreguntas);

        //  Centramos el frame en la pantalla
        vi.setLocationRelativeTo(null);

        //  Lanzamos la interfaz gráfica en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> vi.setVisible(true));

    }//de aca se llama a todo
}
