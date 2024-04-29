package EjercicosGitHub;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=0;
		int sum=0,media;
		
		
		
		System.out.println("Introduce numeros(reales y positivos \n Pulsa -1 para salir");
			
		while(n!=-1) {
		n=sc.nextInt();
			if(n>0) {
				sum+=n;
			}
			
		}
		
		System.out.println(sum);
	}
	
	public static void leeNumerosReales(String fileName)throws IOException{
		
		try {
			File file = new File(fileName);
            FileInputStream lector = new FileInputStream(file);
            String cadena = "";
            int contador = 0;
            int size=lector.available();
            
            while()
			
		} catch (Exception e) {
			
		}
		
	}

}
