/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Refactorizacion;

/**
 *
 * @author alvaro
 */
public class Arrancando implements Estado {
// Por eficiencia, implementamos ya el patrón 

    private static final Arrancando instance = new Arrancando();

    public static Arrancando getInstance() {
        return instance;
    }

    private Arrancando() {
    }

    public Estado siguiente() {
        return EnMarcha.getInstance();
    }

    public String print() {
        return "Arrancando";
    }
}
