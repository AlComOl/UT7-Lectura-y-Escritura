package FusionFicheroObjetos;
/********************************************************
 * @autor Álvaro Comenge 
 * 
 * 
 * @descripcio Ejerecicio fusion de Obgetos
 * 
 * @15-05-2024
 * 
 * 
 * 
 * 
 ************************************************************/
import java.io.*;
import java.util.Scanner;

public class TestFicheroObgetos {

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Crear fichero");
            System.out.println("2. Fusion ficheros");
            System.out.println("3. Mostrar contenido");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    cargarFichero();
                    break;
                case 2:
                    fusionarFicheros();
                    break;
                case 3:
                    mostrarContenido();
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("Salir");
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void cargarFichero() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero para cargar: ");
        String nombreFichero = sc.nextLine();

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(nombreFichero);
            oos = new ObjectOutputStream(fos);

            System.out.print("Introduce el numero de enteros a guardar: ");
            int cantidad = sc.nextInt();
            sc.nextLine(); 

            for (int i = 0; i < cantidad; i++) {
                System.out.print("Introduce el entero: ");
                int numero = sc.nextInt();
                sc.nextLine(); 
                oos.writeInt(numero);
            }

            System.out.println("Fichero cargado correctamente.");
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fusionarFicheros() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del primer fichero: ");
        String nombreFichero1 = sc.nextLine();
        System.out.print("Introduce el nombre del segundo fichero: ");
        String nombreFichero2 = sc.nextLine();
        System.out.print("Introduce el nombre del fichero de fusion: ");
        String nombreFicheroFusion = sc.nextLine();

        FileInputStream fis1 = null;
        ObjectInputStream ois1 = null;
        FileInputStream fis2 = null;
        ObjectInputStream ois2 = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fis1 = new FileInputStream(nombreFichero1);
            ois1 = new ObjectInputStream(fis1);
            fis2 = new FileInputStream(nombreFichero2);
            ois2 = new ObjectInputStream(fis2);
            fos = new FileOutputStream(nombreFicheroFusion);
            oos = new ObjectOutputStream(fos);

            int num, fin=0;

            try {
                while (fin==0) {
                	
              
                    num = ois1.readInt();
                    oos.writeInt(num);
                }
            } catch (EOFException e) {}

            try {
                while (fin==0) {
                    num = ois2.readInt();
                    oos.writeInt(num);
                }
            } catch (EOFException e) {}

            System.out.println("Ficheros fusionados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al fusionar los ficheros: ");
        } finally {
            try {
                if (ois1 != null) ois1.close();
                if (fis1 != null) fis1.close();
                if (ois2 != null) ois2.close();
                if (fis2 != null) fis2.close();
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    public static void mostrarContenido() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del fichero a mostrar: ");
        String nombreFichero = sc.nextLine();
        int fin=0;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(nombreFichero);
            ois = new ObjectInputStream(fis);

            System.out.println("Contenido del fichero " + nombreFichero + ":");
            try {
                while (fin==0) {
                    int numero = ois.readInt();
                    System.out.println(numero);
                }
            } catch (EOFException e) {}

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
