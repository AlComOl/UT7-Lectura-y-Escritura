/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Refactorizacion;
/**
 *
 * @author alvaro
 */
public class EnMarcha implements Estado {
// Por eficiencia, implementamos ya el patrón singleton

    private static final EnMarcha instance = new EnMarcha();

    public static EnMarcha getInstance() {
        return instance;
    }

    private EnMarcha() {
    }

    public Estado siguiente() {
        return Parando.getInstance();
    }

    public String print() {
        return "EnMarcha";
    }
}
