package EjercicosGitHub;


	/**************************************************************
	 * @author Álvaro Comenge
	 * @fecha 16-05-24
	 * Descripción: Se quiere ordenar de manera ascendente los números 
	 * contenidos en un fichero. Para resolver el problema cree una clase Orden 
	 * con un método ordena() que haga la ordenación de los números. 
	 * Los números están cada uno en una línea del fichero.
	 ***************************************************************/

import java.io.*;
import java.util.*;

public class Prg_7_3 {

    public  class Orden {
        public static void ordena() {
            File fe = new File("numeros.txt");
            if (fe.exists()) {
                int cantidadLineas = 0;
                try {
                    FileReader fr = new FileReader(fe);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        cantidadLineas++;
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int[] numeros = new int[cantidadLineas];
                    int contador = 0;
                    FileReader fr = new FileReader(fe);
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        int numero = Integer.parseInt(linea);
                        numeros[contador] = numero;
                        contador++;
                    }
                    br.close();

                    // Método burbuja para ordenar
                    for (int i = 0; i < contador - 1; i++) {
                        for (int j = 0; j < contador - i - 1; j++) {
                            if (numeros[j] > numeros[j + 1]) {
                                int aux = numeros[j];
                                numeros[j] = numeros[j + 1];
                                numeros[j + 1] = aux;
                            }
                        }
                    }

                    // Escribir los números ordenados en un nuevo fichero
                    FileWriter fw = new FileWriter("numeros_ordenados.txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (int i = 0; i < contador; i++) {
                        bw.write(Integer.toString(numeros[i]));
                        bw.newLine();
                    }
                    bw.close();
                    System.out.println("Numeros han sido ordenados y guardados en 'numeros_ordenados.txt'.");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("El archivo 'numeros.txt' no existe.");
            }
        }
    }
//dento de la clase orden esta el metodo Ordena 
    public static void main(String[] args) {
        Orden.ordena();
    }
}
