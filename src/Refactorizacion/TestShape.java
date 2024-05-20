/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Refactorizacion;

/**
 *
 * @author alvaro
 * @descripcion En esta modificación, se amplió el número de clases al introducir una clase base 
 * llamada "Shape" (Forma), que sirve como plantilla para las distintas figuras geométricas.
 *  Las figuras geométricas específicas heredan de esta clase base y obtienen automáticamente 
 *  sus métodos, lo que significa que se evita escribir los mismos métodos repetidamente para 
 *  cada figura individual. Esto reduce la cantidad de código necesario y elimina la redundancia,
 *   al tiempo que facilita la gestión y la extensión del código en el futuro.
 * 
 */
import java.util.*;

public class TestShape {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        final int CUADRADO = 1;
        final int CIRCULO = 2;
        final int TRIANGULO = 3;
        int shape;
        double size;
        do {
            System.out.print("Indique su figura(1=CUADRADO, 2=CIRCULO,3=TRIANGULO RECTANGULO): ");
            shape = tec.nextInt();
            System.out.print("Indique su tamaño: ");
            size = tec.nextByte();
        } while (shape != CUADRADO && shape != CIRCULO && shape != TRIANGULO);
        Shape figura = null;
        switch (shape) {
            case CUADRADO:
                figura = new Square(size);
                break;
            case CIRCULO:
                figura = new Circle(size);
                break;
            case TRIANGULO:
                figura = new Triangle(size);
                break;
        }
        System.out.println("Area=" + figura.area());
    }
}
