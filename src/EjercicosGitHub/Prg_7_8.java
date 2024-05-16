package EjercicosGitHub;
/****
 * @author Álvaro Comenge 
 * @fecha 16-5-24
 * 
 * @descripcion 
 * Introduzca en ejercicios de temas anteriores una opción para leer los datos desde un 
 * archivo indicado por el usuario y otra para guardarlos en un archivo indicado por el 
 * usuario. Introduzca las opciones necesarias para que estén lo más completamente posible
 * desarrollados en cuanto a las operaciones de altas, bajas y modificaciones. 
 * 
 * Introduzco datos de alumnos y saco la media de su edad 
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Prg_7_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre;
        int edad;
        int numeroAsignaturas;
        String ciclo;

        while (true) {
            System.out.println("Introduce el nombre del Alumno (* para salir y mostrar datos):");
            nombre = sc.nextLine();
            if (nombre.equals("*")) {
                break;
            }

            System.out.println("Introduce la edad del Alumno:");
            edad = sc.nextInt();
            sc.nextLine();  

            System.out.println("Introduce el número de asignaturas:");
            numeroAsignaturas = sc.nextInt();
            sc.nextLine();  

            System.out.println("Introduce el ciclo:");
            ciclo = sc.nextLine();

            escribirFichero("alumnos.dat", nombre, edad, numeroAsignaturas, ciclo);
        }

        leerFichero("alumnos.dat");
        sc.close();
    }

    public static void escribirFichero(String fichero, String nombre, int edad, int numeroAsignaturas, String ciclo) {
        DataOutputStream dos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fichero, true);
            dos = new DataOutputStream(fos);

            dos.writeUTF(nombre);
            dos.writeInt(edad);
            dos.writeInt(numeroAsignaturas);
            dos.writeUTF(ciclo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) dos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void leerFichero(String nombreFichero) {
        DataInputStream dis = null;
        FileInputStream fis = null;
        double sumaEdades = 0;
        int contadorAlumnos = 0;

        try {
            File f = new File(nombreFichero);
            if (f.exists()) {
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);

                String nombre, ciclo;
                int edad, numeroAsignaturas;

                System.out.println("NOMBRE \t\tEDAD \t\tASIGNATURAS \t\tCICLO");
                while (true) {  // bucle infinito para leer todos los registros
                    nombre = dis.readUTF();
                    edad = dis.readInt();
                    numeroAsignaturas = dis.readInt();
                    ciclo = dis.readUTF();

                    sumaEdades += edad;
                    contadorAlumnos++;

                    System.out.println(nombre + "\t\t" + edad + "\t\t" + numeroAsignaturas + "\t\t" + ciclo);
                }
            }
        } catch (EOFException eof) {
            System.out.println("Fin del fichero");
        } catch (FileNotFoundException fnf) {
            System.out.println("Fichero no encontrado: " + fnf);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Calcular y mostrar la media de edad
        if (contadorAlumnos > 0) {
            double mediaEdad = sumaEdades / contadorAlumnos;
            System.out.println("La media de edad de los alumnos es: " + mediaEdad);
        } else {
            System.out.println("No hay alumnos registrados.");
        }
    }
}
