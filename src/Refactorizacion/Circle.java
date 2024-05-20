/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Refactorizacion;
/**
 *
 * @author alvaro
 */
public class Circle extends Shape {

    public Circle(double size) {
        super(size);
    }

    public double area() {
        double size = getSize();
        return Math.PI * size * size / 4.0;
    }
}
