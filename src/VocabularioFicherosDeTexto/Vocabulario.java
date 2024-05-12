package VocabularioFicherosDeTexto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*Esta clase es necesaria para manejar listas de elementos 
* y para leer la entrada del usuario desde la consola.*/
import java.util.ArrayList;
import java.util.Scanner;
/***************************************************************
 * @autor Álvaro Comenge
 * @descripcion Esta clase contiene métodos para buscar traducciones de palabras en diferentes idiomas
    y para cargar palabras en el diccionario, además de modificar palabra y eliminar palabra
    cuando se eleimina una palabra se eliminara en todos los idiomas
 * @version ArrayList
 * 
 * @Fecha 20-2-2024
 * 
 *  
 * 
 * **************************************************************/


public class Vocabulario{
	/* vocabulario es un ArrayList que almacenará instancias de la clase Palabra, 
	   representando el diccionario*/
		 ArrayList<Palabra> vocabulario=new ArrayList<Palabra>();
		static Scanner sc=new Scanner(System.in); 
		
		
		
			
		
		
		 

			public void buscarTraduccion(String palabra,int idioma) {
		    	/****************************************************
		    	 * @author acome
		    	 * @param palabra a buscar
		    	 * @descripcion  Este método recibe una palabra como parámetro 
		    	 * y busca su traducción en el diccionario. Itera sobre el ArrayList
		    	 * de palabras y compara la palabra proporcionada con las palabras en español, 
		    	 * inglés y francés de cada instancia de Palabra. Si encuentra una coincidencia,
		    	 * imprime la traducción en los tres idiomas. Si no encuentra ninguna coincidencia, 
		    	 * imprime un mensaje indicando que la palabra no está en el diccionario.
		    	 * 
		    	 * **************************************************/
		    	boolean encontrado=false;
		    	
		    	for(Palabra Voca:vocabulario) {
		    		
		    		if(Voca.getEspanol().equalsIgnoreCase(palabra)&&!encontrado&&idioma==1) {
		    			encontrado=true;
//		    			System.out.println(Voca.ingles);//lo logico seria utilizar 
//		    			System.out.println(Voca.frances);
		    			System.out.println(Voca.toString());
		    			
		    		}else if(Voca.getIngles().equalsIgnoreCase(palabra)&&!encontrado&&idioma==2) {
		    			encontrado=true;
//		    			System.out.println(Voca.espanol);
//		    			System.out.println(Voca.frances);
		    			System.out.println(Voca.toString());
		    			
		    		}else if(Voca.getFrances().equalsIgnoreCase(palabra)&&!encontrado&&idioma==3) {
		    			encontrado=true;
//		    			System.out.println(Voca.ingles);
//		    			System.out.println(Voca.espanol);
		    			System.out.println(Voca.toString());
		    		
		    		}
		    	}
		    	if(encontrado==false) {
	    			System.out.println("la palabra no esta en el dicionario");
	    		}
		    		
		    	}
		    
		    public void cargarDiccionario() {
				/***********************************************************
				 * @author acome
				 * 
				 * @descripcion Este método se encarga de cargar palabras en
				 * el diccionario. Primero solicita al usuario el número de palabras
				 *  que desea ingresar (variable N). Luego, mediante un bucle, 
				 *  solicita al usuario que ingrese cada palabra en español, inglés y francés y 
				 *  crea una instancia de Palabra con esos datos para agregarla al diccionario.
				 * 
				 * ***********************************************************/
				String espanol;
			    String ingles;
			    String frances;
			    
			    int i,n;//numero de palabras a leer N 
			    
			    do {
			    	System.out.println("Numero el numero de palabras que quieres cargar en el dicionario");
			    	n=sc.nextInt();
			    }while(n<0);
			    sc.nextLine();
			    
			    for(i=1;i<=n;i++) {
			    	System.out.println("Palabra "+i);
			    	System.out.println("Palabra en espanol");
			    	espanol=sc.nextLine();
			    	System.out.println("Palabra en Ingles");
			    	ingles=sc.nextLine();
			    	System.out.println("Palabra en Frances");
			    	frances=sc.nextLine();
			    	//introduzco en la instancia el valor
			    	Palabra instancia =new Palabra(espanol,ingles,frances);
				    //por medio de add la instancia en el arraylist<palabra>
				    vocabulario.add(instancia);
			    }
			}
//		    buscar la palabra que quiero modificar el idioma buscada y modifica todos
		    public void modificarElemento(String palabra, String pamodificar) {
		    	/*************************************************************************
		    	 * @author acome
		    	 * @param palabra palabra que se quiere modificar
		    	 * @param pamodificar palabra por la que se va a modificar la palabra
		    	 * 
		    	 * @descripcion la funcion busca la palabra en cada uno de los objetos de
		    	 * vocabulario y si lo encuentra la modifica sino sale un mensage de que no esta
		    	 * 
		    	 * 
		    	 * 
		    	 * ************************************************************************/
		    	boolean encontrado=false;
		    	for(int i=0;i<vocabulario.size()&&encontrado==false;i++) {
		    	Palabra	pal=vocabulario.get(i);//obtiene el elemento de la pos i y lo almacena en pal 
		    		if(pal.getEspanol().equalsIgnoreCase(palabra)){//si el i= palabra
		    			
		    			pal.setEspanol(pamodificar);
		    			encontrado=true;
		    		
		    		}
		    		if(pal.getIngles().equalsIgnoreCase(palabra)) {
		    			
		    			pal.setIngles(pamodificar);
		    			encontrado=true;
		    			
		    		}
		    		if(pal.getFrances().equalsIgnoreCase(palabra)) {
		    			
		    			pal.setFrances(pamodificar);
		    			encontrado=true;
		    			
		    		}
		    		
		    	}
		    	if(encontrado==false) {
	    			System.out.println("La palabra no esta en el vocabulario");
	    		}
		    	
		    }
		    
		    public void eliminarPalabra(String palabra) {
		    	/*******************************************
		    	 * @author acome
		    	 * 
		    	 * @param palabra a modificar
		    	 * 
		    	 * 
		    	 * @descripcion esta funcon hace lo mismo que la anterior
		    	 * con la diferencia que borra la palabra en los 3 idiomas
		    	 * 
		    	 * 
		    	 * *****************************************/
		    	boolean encontrado=false;
		    	for(int i=0;i<vocabulario.size()&&encontrado==false;i++) {
		    	Palabra	pal=vocabulario.get(i);//obtiene el elemento de la pos i y lo almacena en pal 
		    		if(pal.getEspanol().equalsIgnoreCase(palabra)){//si el i= palabra
		    			
		    			vocabulario.remove(i);
		    			encontrado=true;
		    		
		    		}
		    		if(pal.getIngles().equalsIgnoreCase(palabra)) {
		    			
		    			vocabulario.remove(i);
		    			encontrado=true;
		    			
		    		}
		    		if(pal.getFrances().equalsIgnoreCase(palabra)) {
		    			
		    			vocabulario.remove(i);
		    			encontrado=true;
		    			
		    		}
		    		
		    	}
		    	if(encontrado==false) {
	    			System.out.println("La palabra no esta en el vocabulario");
	    		}
		    	
		    }
		    
		    
		    
		    /***
		     * Esta funcion carga el fichero pasado a la funcion en el arrayListr de tipo <Palabra>
		     * del vocavulario
		     * @param fichero
		     */
		    public void cargarDesdeArchivo(String fichero) {
		        BufferedReader br = null; // Declaramos el BufferedReader fuera del try

		        try {
		            br = new BufferedReader(new FileReader(fichero)); // Inicializamos el BufferedReader
		            String linea;
		            while ((linea = br.readLine()) != null) {
		                String[] partes = linea.split(" ");
		                if (partes.length == 3) {
		                    String espanol = partes[0];
		                    String ingles = partes[1];
		                    String frances = partes[2];
		                    Palabra palabra = new Palabra(espanol, ingles, frances);
		                    vocabulario.add(palabra);
		                }
		            }
		            System.out.println("¡Diccionario cargado desde el archivo correctamente!");
		        } catch (IOException e) {
		            System.out.println("Error al leer el archivo: " + e.getMessage());
		        } finally {
		            // Cerramos el BufferedReader en el bloque finally para asegurarnos de que se cierre
		            // independientemente de si ocurre una excepción o no
		            if (br != null) {
		                try {
		                    br.close();
		                } catch (IOException e) {
		                    System.out.println("Error al cerrar el BufferedReader: " + e.getMessage());
		                }
		            }
		        }
		    }
		    
		    /****
		     * Esta funcion escrube el contenido del arraylist de tipo palabras Vocabulario 
		     * dentro del fichero que pasamos por la funcion
		     * 
		     * 
		     * @param fichero
		     */
		    public void guardarEnArchivo(String fichero) {
		        BufferedWriter bw = null;

		        try {
		            bw = new BufferedWriter(new FileWriter(fichero));
		            for (Palabra palabra : vocabulario) {
		                bw.write(palabra.getEspanol() + " " + palabra.getIngles() + " " + palabra.getFrances());
		                bw.newLine(); // Agregar una nueva línea después de cada palabra
		            }
		            System.out.println("¡Diccionario guardado en el archivo correctamente!");
		        } catch (IOException e) {
		            System.out.println("Error al escribir en el archivo: " + e.getMessage());
		        } finally {
		            if (bw != null) {
		                try {
		                    bw.close();
		                } catch (IOException e) {
		                    System.out.println("Error al cerrar el BufferedWriter: " + e.getMessage());
		                }
		            }
		        }
		    }
		    
		    
		    
		    
		    public String toString() {
			    StringBuilder sb = new StringBuilder("Vocabulario:  \n");
			    for (Palabra palabra : vocabulario) {
			        sb.append(palabra.getEspanol()).append(" - ")
			          .append(palabra.getIngles()).append(" - ")
			          .append(palabra.getFrances()).append("\n ");
			    }
			    // Eliminar la última coma y espacio si hay palabras en el vocabulario
			    if (!vocabulario.isEmpty()) {
			        sb.setLength(sb.length() - 2);
			    }
			    return sb.toString();
			}
			 
		    }

