package VocabularioFicherosDeTexto;
/*********************************************************
 * @author Álvaro Comenge
 * 
 * @fecha 21/01/24
 * 
 * @descripcion main del vocabulario menu para aceder a las 
 * opciones de 1-cargar menu 2-traducir palabra 3-modificar
 * 4-eliminar 5-cargarfichero
 * 
 * 
 * 
 * *******************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class TestMainVocabulario {
	static Vocabulario v = new Vocabulario(); // Creamos una instancia de la clase Vocabulario

	
	/***********************************************
	  * @autor acome
	  * @descripcion Es el menu de main 
	  * 
	  * **********************************************/
	public static void getMenu(){
		 
	        System.out.println("Elige una opcion:");
	        System.out.println("1.Anadir una palabra");
	        System.out.println("2.Buscar una palabra en otro idioma");
	        System.out.println("3.Modificar palabra");
	        System.out.println("4.Eliminar palabra");
	        System.out.println("5.Cargare el fichero al dicionario");
	        System.out.println("6.Cargar dicionario al fichero resultado.txt");
	        System.out.println("7.Mostrar diccionario");
	        System.out.println("8.Salir");
	        
	 }	 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int key;
		
		Vocabulario v=new Vocabulario();
		
		
		do {
		 getMenu();
		 key=sc.nextInt();
		
		
			switch (key) {
			case 1: 
				v.cargarDiccionario();	
			
			break;
			case 2: 
				System.out.println("Introduce palabra a traducir");
				String p=sc.next();
				
				System.out.println("Introduce digito segun el idioma: \n 1-Espanol \n 2-Ingles \n 3-Frances");
				int idioma=sc.nextInt();
				v.buscarTraduccion(p,idioma);
			
			break;
			case 3:
				System.out.println("Introduce el nombre de la palabra que quieres modificar");
				String palabra=sc.next();
				System.out.println("Introduce la palabra nueva");
				String pamodificar=sc.next();
				
				v.modificarElemento(palabra,pamodificar);
				
			break;
			case 4:
				System.out.println("Introduce palabra a eliminar");
				String eliminar=sc.next();
				
				v.eliminarPalabra(eliminar);
				
			break;
			case 5:
				System.out.println("Introduce nombre el fichero a cargar en el arrayList");
				String fichero=sc.next();
				v.cargarDesdeArchivo(fichero);
			break;
			case 6:
				v.guardarEnArchivo("resultado.txt");
			break;
			case 7:
			System.out.println(v.toString());
			break;
			case 8:
				System.out.println("Adios");
			break;
			default :
				System.out.println("La opcion no esta contemplada");
			}
			
		}while(key!=7);
		
		
		
		
		sc.close();
	}

	
	
	
}
