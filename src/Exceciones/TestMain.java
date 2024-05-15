package Exceciones;
import java.util.*;
/*
 * @autor Álvaro Comenge 
 * 
 * 
 *@fecha 15/05/24 
 */


public class TestMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        Sensor s = new Sensor();
        GestorSensor gs = new GestorSensor(s);
        double dato = 0;

        try{
           System.out.println("Introduce un valor");
           dato=sc.nextDouble();
           // Ejemplo de asignación de valor
            gs.enviaDatoAlSensor(dato);
            System.out.println("Dato enviado correctamente.");
        } catch (SensorNoDisponible ex) {
            System.out.println("Error: no se ha podido enviar al sensor: " + ex.valor());
        }
    }
}
