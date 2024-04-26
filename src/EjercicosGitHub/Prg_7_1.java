package EjercicosGitHub;
import java.io.File;
import java.io.FileInputStream;
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

	
//		public static String cuentaPalabras(String nombreFichero){
//				
//				FileInputStream f = null;
//				String cadena = "";
//				char caracter;
//				int cont=0;
//			
//				try {
//				f = new FileInputStream(nombreFichero); // abre fichero para leer caracteres byte a byte
//				int tam = f.available();
////itero leo las palabras y las meto en la cadena
//					for (int i = 0; i < tam; i++) {
////leo f (intancia de )FileInputStream y lo meto en caracter haciendo el casting
//					caracter = (char) f.read();
////lo voy añadiendo a cadena
//					cadena += caracter;
//					
//					
//					
//						if(caracter==' ' || caracter=='.' || caracter=='\r'){
//							cont++;
//						}
//					}
//				
//					System.out.println("Hay "+ cont+" palabras en el fichero");
//					
//				}catch (IOException e) {
//					
//				e.printStackTrace();
//				}finally{
//					
//				try {
//				if (f != null) {
//				f.close();
//				System.out.println("Fichero leido con exito");
//				} else
//				System.out.println("Fichero NO leido");
//				}catch(IOException e){
//					e.printStackTrace();
//				}
//				}
//				return cadena;
//				}
	
	 public static void cuentaPalabras(String fileName) throws IOException {

	        try {
	            File file = new File(fileName);
	            Scanner lector = new Scanner(file);
	            String cadena = "";
	            int contador = 0;

	            while (lector.hasNext()) {
	                System.out.println("Palabra: " + lector.next());
	                contador++;
	            }
	            System.out.println("\nHay un total de: " + contador + " palabras");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
