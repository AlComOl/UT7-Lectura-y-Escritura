package EjercicosGitHub;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
/********
 * @autor Álvaro Comenge Oliver
 * @fecha 28/04/2024
 * @descripcion
 * Realice un programa que almacene y recupere un objeto persona en un fichero.
 * La clase persona contiene los siguientes atributos: 
 *  • Nombre. Campo alfanumérico.
 *  • Apellidos. Campo alfanumérico.
 *  • Teléfono. Campo numérico.
 *
 ********/
public class Persona {

		private String nombre;
		private String apellidos;
		private int telefono;
		
		public Persona(String n, String a,int t) {
			this.nombre=n;
			this.apellidos=a;
			this.telefono=t;
			
		}

		

		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
		}
		
	

	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		String n,a;
		int t;
		
		System.out.println("Introduce el nombre de la persona");
			n=sc.nextLine();
		System.out.println("Introduce el apellido de la persona");
			a=sc.nextLine();
		System.out.println("Introduce el telefono de la persona");
			t=sc.nextInt();
		sc.close();
		Persona p=new Persona(n,a,t);
		
		
		escribeFichero(p,"ejercicio.txt");
		
		
		
		leeFichero("ejercicio.txt");

	}
	
		/**
		 * Escribe los datos de una persona en un archivo especificado.
		 *
		 * @param p Objeto de tipo {@link Persona} que se va a escribir en el archivo.
		 * @param fichero Nombre del archivo donde se escribirán los datos de la persona.
		 * @throws IOException Se lanza si ocurre un error de E/S al escribir en el archivo.
		 */
		public static void escribeFichero(Persona p, String fichero)throws IOException {
			
			   try {
		            File file = new File(fichero);
		            try (FileOutputStream escritor = new FileOutputStream(file)) {
						String nombre=p.toString();
		            	
		            	for(int i=0;i<nombre.length();i++) {
		            	
		            		escritor.write((int)nombre.charAt(i));
		            		
		            	}
					}
		            
		           
		            	System.out.println("El fichero se ha creado y escrito"); 
		            
		            
		            
		            
			   } catch (IOException e) {
		            e.printStackTrace();
		        }
			
			
		}
		/**
		 * Lee los datos de un archivo especificado y los muestra por consola.
		 *
		 * @param fichero Nombre del archivo del cual se leerán los datos.
		 * @throws IOException Se lanza si ocurre un error de E/S al leer el archivo.
		 */
		public static void leeFichero(String fichero)throws IOException {
			
			
			try {
				 File file = new File(fichero);
		         FileInputStream lector = new FileInputStream(file);
		         int size=lector.available();
		         String cadena1=" ";
		         
		         for(int i=0;i<size;i++) {
		        	cadena1+=(char)lector.read();
		         }
		         
		         System.out.println("Lectura del fichero escrito anteriormente");
		         
		         System.out.println(cadena1);
				
			} catch (Exception e) {
				
				 e.printStackTrace();
				
		}	
	}
}
