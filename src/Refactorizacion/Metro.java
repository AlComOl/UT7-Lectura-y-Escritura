/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Refactorizacion;
/**
 *
 * @author alvaro
 */
public class Metro {

    private Estado estado;

    public Metro() {
        estado = Parado.getInstance();
    }

    public String print() {
        return estado.print();
    }

    public void cambiaEstado() {
        estado = estado.siguiente();
    }
}
