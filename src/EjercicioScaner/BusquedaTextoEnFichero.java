package EjercicioScaner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BusquedaTextoEnFichero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = sc.nextLine();

        System.out.print("Ingrese el texto a buscar: ");
        String textoBuscado = sc.nextLine();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            int numeroLinea = 1;
            boolean encontrado = false;

            System.out.println("Archivo: " + nombreArchivo);
            System.out.println("Texto a buscar: " + textoBuscado);

            while ((linea = reader.readLine()) != null) {
                if (linea.contains(textoBuscado)) {
                    encontrado = true;
                    System.out.println("Linea " + numeroLinea + ": " + linea);
                }
                numeroLinea++;
            }

            if (!encontrado) {
                System.out.println(textoBuscado + " no se ha encontrado en el archivo");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el lector: " + e.getMessage());
                }
            }
        }
    }
}
