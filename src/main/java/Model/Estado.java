/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Model;

/**
 *esta clase es para definir el estado de los jugares si son creadores de la sala o si se une por codigo
 * @author gabri
 */
public enum Estado {
    Admin,Jugador;
    
    @Override
    public String toString() {
        return name();
    }
    
}
