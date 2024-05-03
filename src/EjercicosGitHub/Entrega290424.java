package EjercicosGitHub;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
/*********
 * @autor Álvaro Comenge 
 * @fecha 29-04-2024
 * 
 ********/
public class Entrega290424 {
	
	private static Scanner sc = new Scanner(System.in); 

	public static void main(String[] args)throws IOException {
		Scanner sc=new Scanner(System.in);
		int key;
		int key2=0;
		
			do {
				menu();
				
				key=sc.nextInt();
				
				switch (key) {
				case 1:
					escribirFichero("prueba3.dat");
					break;
				case 2:
					ficheroLee("prueba3.dat");
					break;
				case 3:
				System.out.println(obtenerMedia("prueba3.dat"));
					break;
				case 4:
					key2 = -1;
					System.out.println("Adios");
                    break;
				default:
					break;
				}
				
			}while(key2 != -1);
		

	}
		/************
		 * @author acome
		 * @descripcion menu
		 * 
		 **********/
		public static void menu() {
		
			System.out.println("1.-Escribir numeros en el fichero"
								+ "\n2.-Mostrar fichero"
								+ "\n3.- Mostrar media"
								+ "\n4.- Salir");
		}
		
		
		/**
		 * Escribe números enteros en un archivo.
		 * 
		 * @param nombreFichero El nombre del archivo en el cual se escribirán los números.
		 * @throws IOException Si ocurre un error de entrada/salida durante la escritura en el archivo.
		 */
		public static void escribirFichero(String nombreFichero)throws IOException {
		    try {
		    	
		    	/*FileOutputStream` se encarga de dirigir los datos hacia el archivo, mientras que `DataOutputStream`
		    	 se encarga de formatear y escribir esos datos en el archivo de acuerdo con los tipos de datos específicos que estás escribiendo*/
		    	
		        FileOutputStream fs = new FileOutputStream(nombreFichero);
		        DataOutputStream d = new DataOutputStream(fs);
		        int n;
		        
	
		        System.out.println("Introduce numeros (introduce 0 para terminar):");
					n = sc.nextInt();
		        while (n!=0) {
		            /*writeInt se encarga de escribirlo en el fichero como un int*/
		            d.writeInt(n);
		            n = sc.nextInt();
		        } 
		        	/**/
		        if (d!=null) {//si cualquier proceso sale mal cancela.
		            d.close();//cierran el flujo de DataOutputStream 
		            fs.close();//cierran el flujo de FileOutputStream 

		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    
		    
		}
		
		
		
		/****
		 * @author acome
		 * @descripcion Lee los datos de un archivo y muestra su contenido en la consola.
		 * @param fichero
		 */
		public static void ficheroLee(String fichero)throws IOException {
				
	        try {
	        	//crea objetos de ,File, FileInputStream,DataInputStream a null para ceclarar que no se han iniciado.
	            File f = null;
	            FileInputStream fe = null;
	            DataInputStream d = null;
	            try {
	            	
	                f = new File (fichero);//se crea el objeto f de tipo file y se le pasa el archivo
	                if (f.exists()) {//se verifica que existe con el metodo de File
	                    fe = new FileInputStream(f);//se canaliza el flujo de entrada pasando el fichero f
	                    d = new DataInputStream(fe);//por medio de DataInputStream de pasa la f 
	                    int n;
	                    while (true) {
	                        n = d.readInt();
	                        System.out.println(n+ " ");
	                    }
	                }
	            } catch (EOFException eof) {
	                System.out.println("-----");
	            } catch (FileNotFoundException fnf) {
	                System.out.println("No se ha encontrado el fichero.");
	            } catch (Throwable t) {
	                System.out.println("!!Error¡¡" + t);
	            } finally {
	            //si cualquier proceso sale mal cancela.
	 		    //cierran el flujo de DataOutputStream 
	 		    //cierran el flujo de FileOutputStream 
	                if (d != null) {
	                    d.close();
	                    fe.close();
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
		
		/**
		 * Calcula la media de los números almacenados en un archivo.
		 * @author acome
		 * @param fichero El nombre del archivo el que se leerán los números.
		 * @return La media de los números en el archivo.
		 */
		public static String obtenerMedia(String fichero)throws IOException {
	        float media = 0;
	        int contador = 0;	
	        int n;
	        double res=0;
	        
	        try {
	        	/*La misma operacion que la funcion anterior y mientras haya numeros los sumamos a media y 
	        	 * y dividimos por el contador que cada vez que hacemos el bucle se incrementa*/
	            File f = null;
	            FileInputStream fe = null;
	            DataInputStream d = null;
	            
	            try {
	                f = new File (fichero);
	                if (f.exists()) {
	                    fe = new FileInputStream(f);
	                    d = new DataInputStream(fe);
	                   
	                    while (true) {
	                        n = d.readInt();
	                        media += n;
	                        contador++;
	                    }
	                    
	                }
	               
	            } catch (EOFException eof) {
	                System.out.print("");
	            } catch (FileNotFoundException fnf) {
	                System.out.println("No se ha encontrado el fichero.");
	            } catch (Throwable t) {
	                System.out.println("!!Error¡¡" + t);
	            } finally {
	            	//si cualquier proceso sale mal cancela.
		 		    //cierran el flujo de DataOutputStream 
		 		    //cierran el flujo de FileOutputStream 
	                if (d != null) {
	                    d.close();
	                    fe.close();
	                }
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
	        res=media/contador;
	        
	        
	        return "La media de los numeros es "+res;
	    }
}
