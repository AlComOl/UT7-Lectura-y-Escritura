

package Refactorizacion;
/**
 *
 * @author alvaro
 * En esta refactorización, se descompuso el código original al convertir las variables en clases 
 * separadas que se llaman entre sí. Esta estructura clarifica el código al evitar el uso excesivo 
 * de instrucciones condicionales como if-else. Además, se introdujo una interfaz común que todas las 
 * clases implementan, lo que simplifica aún más la estructura y la hace más visualmente comprensible. 
 * Esta refactorización se centra en mejorar el orden y la organización del código, haciéndolo más fácil
 *  de entender y mantener en el futuro.

*/

public class TestMetro {

    public static void main(String[] args) {
        Metro m = new Metro();
        System.out.println("Estado = " + m.print());
        m.cambiaEstado();
        System.out.println("Estado = " + m.print());
        m.cambiaEstado();
        System.out.println("Estado = " + m.print());
        m.cambiaEstado();
        System.out.println("Estado = " + m.print());
        m.cambiaEstado();
        System.out.println("Estado = " + m.print());
    }
}
