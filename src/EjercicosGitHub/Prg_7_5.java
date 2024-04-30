package EjercicosGitHub;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;
/********
 * @autor Álvaro Comenge Oliver
 * @fecha 28/04/2024
 * @descripcion
 * Realice un programa que calcule la media de un conjunto de números reales positivos 
 * almacenados en un fichero de texto. 
 * Posteriormente los datos leídos se guardan en un fichero restándoles la media.
 * También se guardará la media
 *
 ********/
public class Prg_7_5 {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		
		
//	Lee y saca la media , lo guarda en la variable media
		float media=leeSacaMedia("prueba.txt");
		
		System.out.println(media);
		
		leeRestaMedia("prueba.txt",media);
	
		
		
//		Restar la media a cada uno de los números de los archivos modificandolos
		
		
		
		}
	
	public static void leeRestaMedia(String fichero,float media) {
		int caracter=0;
		int n=0;
		float res;
		
		
		File file=new File(fichero);
		
		if(file.exists()) {
			
			try {
				FileReader fr = new FileReader(fichero);
				File ft=new File("resultante");
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(ft,true);
				while((caracter=br.read())>0) {
					
					n=Character.getNumericValue(caracter);
					
					res=n-media;
					System.out.println(n);
					System.out.println(media);
					System.out.println(n-media);
					
					
					fw.write(Float.toString(res)+"\n\r");
				}
				if (fw != null) {
					fw.close();
				System.out.println("Se ha creado");
			}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			}
		
		
		
	}
	
	
	public static float leeSacaMedia(String fichero) {
		float s=0;
		int cont=0;
		float res=0;
		int caracter;
		File file=new File(fichero);
		
		if(file.exists()) {
			
			try {
				FileReader fr=new FileReader(file);
				BufferedReader br=new BufferedReader(fr);
				
				
				
				while((caracter=br.read())>0) {
					if( Character.isDigit(caracter)) {//si caracter es un digito
					  float numero=Character.getNumericValue(caracter);//lo obtiene y lo mete en numero
					  s+=numero;//lo va sumado a s
						cont++;
					}
				}
				
					
		
//			 System.out.println(s);
//			 System.out.println(cont);
//			System.out.println(res);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return	res=s/cont;
	}
	
	
	
	/**
	 * Escribe números enteros en un archivo.
	 * 
	 * @param nombreFichero El nombre del archivo en el cual se escribirán los números.
	 * @throws IOException Si ocurre un error de entrada/salida durante la escritura en el archivo.
	 */
	public static void escribirFicheroRealesPositivos(String nombreFichero)throws IOException {
		int cont=0;
		int s=0;
	    try {
	    	FileWriter f = new FileWriter(nombreFichero);
	    	BufferedWriter d = new BufferedWriter(f);
	   
	        int n;
	        
	        System.out.println("Introduce numeros (introduce 0 para terminar):");
			n = sc.nextInt();
			while(n>0) {
						 s+=n;
						 cont++;
						 d.write(Integer.toString(n));//tengo que convertir a String para que escriba en el ficher0
			n=sc.nextInt();
			}		
				
				int r=s/cont;
				d.write(Integer.toString(r));
	        	
		        if (d!=null) {
		            d.close();
		            f.close();

	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    
	}	

	
	

}