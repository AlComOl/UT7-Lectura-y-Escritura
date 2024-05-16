package FicherosDeDatos;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * Ficheros de Datos
 * Escritura y Lectura usando DataOutputStream y DataInputStream:
 */
public class FicheroDatos {
    public static void main(String[] args) {
        String rutaArchivo = "archivoDatos.dat";
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        FileInputStream fis = null;
        DataInputStream dis = null;

        // Escribir en el fichero
        try {
            fos = new FileOutputStream(rutaArchivo);
            dos = new DataOutputStream(fos);
            dos.writeInt(42);
            dos.writeDouble(3.14159);
            dos.writeUTF("Hola, mundo");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
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
            dis = new DataInputStream(fis);
            int numero = dis.readInt();
            double decimal = dis.readDouble();
            String texto = dis.readUTF();
            System.out.println("Número: " + numero);
            System.out.println("Decimal: " + decimal);
            System.out.println("Texto: " + texto);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
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