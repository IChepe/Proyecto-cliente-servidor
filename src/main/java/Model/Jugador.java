/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
import java.util.List;
/**
 *esta clase es para definir los atributos 
 * @author gabri
 */
public class Jugador {
    private String IDJ;//id jugador
    private String Nick;
    private String Rol;
    private String Estado;
    private int Puntuaje;//puntuaje 
    private boolean Conectado; 

    public Jugador() {
    }

    public Jugador(String IDJ, String Nick, String Rol, String Estado, int Puntuaje, boolean Conectado) {
        this.IDJ = IDJ;
        this.Nick = Nick;
        this.Rol = Rol;
        this.Estado = "Esperando";//cuando se una este en esperando para confirmar 
        this.Puntuaje = 0;//que el puntuje de todos los jugadores inicie en 0 
        this.Conectado = Conectado;
    }

    //manejo de set an get 
    public String getIDJ() {
        return IDJ;
    }

    public void setIDJ(String IDJ) {
        this.IDJ = IDJ;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getPuntuaje() {
        return Puntuaje;
    }

    public void setPuntuaje(int Puntuaje) {
        this.Puntuaje = Puntuaje;
    }

    public boolean isConectado() {
        return Conectado;
    }

    public void setConectado(boolean Conectado) {
        this.Conectado = Conectado;
    }
    
    
    
    
    
}
