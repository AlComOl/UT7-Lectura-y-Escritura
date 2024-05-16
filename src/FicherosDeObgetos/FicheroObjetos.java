package FicherosDeObgetos;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
/***
 * 
 * Ficheros de Objetos
 * 
 * 
 *  Escritura y Lectura usando ObjectOutputStream y ObjectInputStream:
 */
class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}

public class FicheroObjetos {
    public static void main(String[] args) {
        String rutaArchivo = "archivoObjetos.obj";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        // Escribir en el fichero
        Persona persona1 = new Persona("Juan", 25);
        Persona persona2 = new Persona("Ana", 30);

        try {
            fos = new FileOutputStream(rutaArchivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(persona1);
            oos.writeObject(persona2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Leer del fichero
        try {
            fis = new FileInputStream(rutaArchivo);
            ois = new ObjectInputStream(fis);
            Persona p1 = (Persona) ois.readObject();
            Persona p2 = (Persona) ois.readObject();
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
