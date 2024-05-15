package Excepciones2;

/***
 * @author Álvaro Comenge
 * @fecha 15/05/24
 ****/
import java.io.*;
import java.util.Vector; // Importa la clase Vector

public class MyClass {
    // Declarar una variable de instancia para almacenar el tamaño
    private int size;

    // Declarar una variable de instancia para almacenar el vector
    private Vector<String> miVector;

    // Constructor para inicializar size y miVector
    public MyClass(int size) {
        this.size = size;
        this.miVector = new Vector<String>(size); // Inicializa el vector con el tamaño especificado
    }

    public void writeList() throws FileNotFoundException {
        PrintStream pStr = null;
        try {
            System.out.println("Entrando en la Sentencia try");
            // Abre el archivo "OutFile.txt" para escribir en él
            pStr = new PrintStream(new BufferedOutputStream(new FileOutputStream("OutFile.txt")));
            for (int i = 0; i < size; i++) {
                // Agrega un elemento al vector
                miVector.add("Value at: " + i);
                // Imprime el elemento en el archivo
                pStr.println("Value at: " + i + " = " + miVector.elementAt(i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (pStr != null) {
                System.out.println("Cerrando PrintStream");
                pStr.close();
            } else {
                System.out.println("PrintStream no está abierto");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Crear una instancia de MyClass con un tamaño especificado
        MyClass myObj = new MyClass(10);
        // Llamar al método writeList() para escribir en el archivo
        myObj.writeList();
    }
}
