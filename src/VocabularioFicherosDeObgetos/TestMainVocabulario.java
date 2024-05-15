package VocabularioFicherosDeObgetos;
/*********************************************************
 * @author Álvaro Comenge
 * 
 * @fecha 15/05/24
 * 
 * @descripcion main del vocabulario menu para aceder a las 
 * opciones de 1-Añadir Palabra menu 2-Buscar palabra en otro idioma 3-modificar
 * 4-eliminar 5-Mostrar diccionario 6-salir
 * 
 * 
 * 
 * *******************************************************/


import java.io.IOException;
import java.util.*;



public class TestMainVocabulario {


	
	/***********************************************
	  * @autor acome
	  * @descripcion Es el menu de main 
	  * 
	  * **********************************************/
	public static void getMenu(){
		 
	        System.out.println("Elige una opcion:");
	        System.out.println("1.Añadir Palabra");
	        System.out.println("2.Buscar una palabra en otro idioma");
	        System.out.println("3.Modificar palabra");
	        System.out.println("4.Eliminar palabra");
	        System.out.println("5.Mostrar diccionario");
	        System.out.println("8.Salir");
	        
	 }	 
	
	public static void main(String[] args) throws IOException {
		 
		
		
		Scanner sc=new Scanner(System.in);
		int key;
		
		Vocabulario v=new Vocabulario();
		String nfichero="ficheroObjetos.obj";
		v.crearFicheroObgetos(nfichero);//creamos el archivo 
		v.cargarDesdeArchivo(nfichero);//anadir palabras
		
//		anadir palabras
		
		do {
		 getMenu();
		 key=sc.nextInt();
		
		
			switch (key) {
			case 1: 
				v.AnyadirPalabra();	
				v.llenarFicheroObgetos(nfichero);
			
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
				v.llenarFicheroObgetos(nfichero);
				
			break;
			case 4:
				System.out.println("Introduce palabra a eliminar");
				String eliminar=sc.next();
				
				v.eliminarPalabra(eliminar);
				v.llenarFicheroObgetos(nfichero);
				
			break;
			
			case 5:
				System.out.println( v.toString());
			break;
			case 6:
				System.out.println("Adios");
			break;
			default :
				System.out.println("La opcion no esta contemplada");
			}
			
		}while(key!=6);
		
		
		
		
		sc.close();
	}

	
	
	
}
