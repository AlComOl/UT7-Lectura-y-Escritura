package EjercicosGitHub;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**************************************************************
 * @author Álvaro Comenge 
 * 
 * @Fecha 26/06/24
 * 
 * @descripcion
 * Cree una clase Cuenta con un método cuentaPalabras() que cuente las
 * palabras existentes en un archivo de datos pasado como parámetro.
 * 
 * 
 *************************************************************/
public class Prg_7_1 {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del fichero a leer");
		String fichero=sc.next();
		
		
		cuentaPalabras(fichero);

	}


	
	 public static void cuentaPalabras(String fileName) throws IOException {

	        try {
	            File file = new File(fileName);
	            FileInputStream lector = new FileInputStream(file);
	            FileReader fr = new FileReader(file);
	            BufferedReader br = new BufferedReader(fr);
	            String cadena = "";
	            int contador = 0;
	            String linea;
	            int size=lector.available();
	            
	             while ((linea = br.readLine()) != null) {
	            	for(int i=0;i<size;i++) {
		            	cadena+=(char)lector.read();
		            }
                }
	            
	            
	            for(int i=1;i<cadena.length();i++){
	            	if(cadena.charAt(i-1)==' '&&cadena.charAt(i)!=' '||cadena.charAt(i)=='\n') {
	            		contador++;
	            	}
	            }
	            
	            System.out.println("\nHay un total de: " + contador + " palabras");
	                
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
