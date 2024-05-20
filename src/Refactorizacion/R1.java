/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Refactorizacion;

/**
 *
 * @author alvaro
 * @descripcion Los dos puntos que veo mas claros en este programa, es 
 * el vector que almacena los Rate y la eliminacion de if else que son 
 * poco útiles.
 * 
 */
import java.util.*;

public class R1 {

    public static double basis(double base) {
        return base * 10; //40 horas * 10 dolares la hora
    }

    public static double extra(double base) {
        return (base - 40) * 10; // horas extras * 10 dolares la hora
    }
//Solución: tras refactorización

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        final byte TEXAS = 0;
        final byte OHIO = 1;
        final byte MAINE = 2;
        byte state;
        double rate, calc, amt,
                base = 40, //40 horas semanales
                points = 0; //punto conseguidos
        do {
            System.out.print("Indique su estado(0=TEXAS, 1=OHIO, 2=MAINE): ");
            state = tec.nextByte();
        } while (state != TEXAS && state != OHIO && state != MAINE);
            double [] rate_lookup = {0.9, 1, 1}; //cambio el rate de MN
            rate = rate_lookup[state];
            amt = base * rate;
            calc = 2 * basis(amt) + extra(amt) * 1.05;
        if (state == OHIO) {
            points = 2;
        }
        System.out.println("Sueldo=" + calc + " Puntos= " + points);
    }
}
