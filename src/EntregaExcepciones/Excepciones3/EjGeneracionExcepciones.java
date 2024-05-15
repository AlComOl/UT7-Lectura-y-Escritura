package Excepciones3;
/**
 * @autor Álvaro Comenge 
 * 
 * @fecha 15/05/24
 * 
 * 
 * 
 */
import java.util.ArrayList;

public class EjGeneracionExcepciones {
    
    public static void main(String[] args) {
        ArrayList<ClaseGeneradora> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Se crea generadora con nombre: Nombre generador " + i);
            try {
                al.add(new ClaseGeneradora("Nombre generador " + i));
            } catch (NoPosibleMasGeneradores e) {
                System.out.println("Excedido el cupo de generadores al pasar de " + ClaseGeneradora.numero);
            }
        }
    }
}

class ClaseGeneradora {
    public static int numero = 0;
    
    public ClaseGeneradora(String nombre) throws NoPosibleMasGeneradores {
        if (numero >= 5) {
            throw new NoPosibleMasGeneradores("Se ha excedido el límite de generadores");
        } else {
            numero++;
            System.out.println("Creando generador: " + nombre);
        }
    }
}

class NoPosibleMasGeneradores extends Exception {
    public NoPosibleMasGeneradores(String mensaje) {
        super(mensaje);
    }
}