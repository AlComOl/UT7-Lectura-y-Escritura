

package Refactorizacion;
/**
 *
 * @author alvaro
 */
public class Parado implements Estado {
// Por eficiencia, implementamos ya el patrón singleton

    private static final Parado instance = new Parado();

    public static Parado getInstance() {
        return instance;
    }

    private Parado() {
    }

    public Estado siguiente() {
        return Arrancando.getInstance();
    }

    public String print() {
        return "Parado";
    }
}
