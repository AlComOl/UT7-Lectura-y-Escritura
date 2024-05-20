/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Refactorizacion;
/**
 *
 * @author alvaro
 */
public abstract class Shape {

    private double size;

    public Shape(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public abstract double area();
}
