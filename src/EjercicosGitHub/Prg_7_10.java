package EjercicosGitHub;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**************************************************
 * @autor Álvaro Comenge
 * 
 * @fecha 07-05-2024
 * 
 * @descripcion
 * Escriba un programa que vaya almacenando en un fichero todos los caracteres que se tecleen 
 * hasta que se pulse la tecla Escape. El nombre del archivo se pasará como parámetro en la 
 * línea de órdenes.
 * 
 *************************************************/
public class Prg_7_10 {
public static void main(String[] args) {
        
     Scanner sc = new Scanner(System.in);
       
        try {
        	File fs = new File("Ejercicio7");
    		FileWriter fw = new FileWriter(fs,true);//
            System.out.println("Escribe los caracteres (* para finalizar):");
            String nombreArchivo = sc.next();
//            no me va con el Escape de ninguna de las manera si alguien lo sabe que me lo diga por favor.
            while (!nombreArchivo.equals("*")) {
                fw.write(nombreArchivo);//escribo
                
                fw.write("\n"); // Salto de lonea despuds de cada caracter
                nombreArchivo = sc.next(); // Leemos el siguiente caracter
             
            }
  
            fw.close();// Cerramos el FileWriter despues de escribir todos los caracteres
        } catch (IOException e) {
            e.printStackTrace();
            
            
        } finally {
            sc.close();
        
            
        }
    }
}