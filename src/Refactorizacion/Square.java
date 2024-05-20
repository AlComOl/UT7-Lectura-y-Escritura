/*
 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Refactorizacion;
/**
 *
 * @author alvaro
 */
public class Square extends Shape {

    public Square(double size) {
        super(size);
    }

    public double area() {
        double size = getSize();
        return size * size;
    }
}
