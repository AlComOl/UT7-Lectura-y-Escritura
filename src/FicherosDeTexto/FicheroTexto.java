package FicherosDeTexto;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
/*
 * Escritura y Lectura usando BufferedWriter y BufferedReader:
 * 
 * 
 */
public class FicheroTexto {
    public static void main(String[] args) {
        String rutaArchivo = "archivoTexto2.txt";
        FileWriter fw = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        BufferedReader br = null;

        // Escribir en el fichero
        try {
            fw = new FileWriter(rutaArchivo);
            bw = new BufferedWriter(fw);
            bw.write("Primera línea de texto");
            bw.newLine();
            bw.write("Segunda línea de texto");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Leer del fichero
        try {
            fr = new FileReader(rutaArchivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
