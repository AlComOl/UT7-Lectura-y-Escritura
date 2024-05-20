/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Refactorizacion;
/**
 *
 * @author alvaro
 */
public class Parando implements Estado {
// Por eficiencia, implementamos ya el patrón

    private static final Parando instance = new Parando();

    public static Parando getInstance() {
        return instance;
    }

    private Parando() {
    }

    public Estado siguiente() {
        return Parado.getInstance();
    }

    public String print() {
        return "Parando";
    }
}
