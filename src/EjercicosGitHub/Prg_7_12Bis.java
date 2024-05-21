package EjercicosGitHub;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
/***************************************************
 * @author Álvaro Comenge 
 * 
 * @fecha 21-05-2024
 * 
 * @descripcion 
 * En el club de baloncesto BAHEETO'S BASKET CLUB se está realizando una campaña de captación de jugadores altos.
 *  Se dispone de un fichero con datos de aspirantes, llamado ALTOS. DAT, que se describe a continuación ALTOS. DAT 
 *  Aspirantes a jugadores del club Campo Descripción Tipo nom Nombre del aspirante string alt Altura del aspirante (en metros) 
 *  float pro Provincia de nacimiento string  El fichero almacena un máximo de 500 registros.  La provincia se almacena en mayúsculas.
 *    El fichero no está ordenado. Construya un programa que realice las siguientes operaciones: 
 *    Solicitar por teclado una provincia y almacenar los nombres y las alturas de los aspirantes nacidos en la provincia indicada.
 *     Calcular la altura media de todos los aspirantes de dicha provincia.  Emitir un informe impreso con los nombres y alturas de los aspirantes de la provincia cuya altura supere la media. El formato del listado debe ser el siguiente: Provincia: xxxxxxxxxxxxxxxxxxxxxxxxx Altura Media: x.xx Nombre Altura xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx x.xx ... 50 líneas de detalle por página
 *************************************************/

public class Prg_7_12Bis {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		String provincia;
		String nfichero="a.csv";
		float fmedia;
		
		System.out.println("Introduce el nombre de la provincia");
		provincia=sc.next().toUpperCase();//la almacena en mayuscula requisito enunciado
		
		try {
			
			fmedia=leerArchivoMedia(nfichero,provincia);
//			System.out.println(fmedia);
			
			leeRegistro(nfichero,fmedia,provincia);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static float leerArchivoMedia(String nfichero,String provincia)throws Exception {
		String columnas[] =new String [4];
		
		String linea=null;
		float elegidos = 0;
		int contabiliza=0;
		float media=0;

		File file = new File(nfichero);
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
			
			while((linea=br.readLine())!=null) {
				
				 columnas=linea.split(";");//dividimos columnas
				
				 if (columnas[2].equalsIgnoreCase(provincia)) {
		                elegidos += Float.parseFloat(columnas[1]); // Ajusta según el formato del número
		                contabiliza++;
		            }
				
			}

		
			if(fr != null&& br != null){
                fr.close();
                br.close();
            }
				media=elegidos/contabiliza;
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	            if (br != null) {
	                br.close();
	            }
	            if (fr != null) {
	                fr.close();
	            }
	        }
	        return media;
	    }

	
	
	public static void leeRegistro(String nfichero,float media,String provincia) {
		float afloat;
	
		String columnas[] =new String [4];
		String linea=null;
		File file= new File(nfichero);
		try {
			
			 FileReader fr= new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         
	         System.out.printf("Provincia: %s%nAltura Media: %.2f%n", provincia, media);
	         System.out.println("****************");
	            System.out.printf("%-40s %s%n", "JUGADOR", "ALTURA");
	         
	         while((linea=br.readLine())!=null) {
	        	 
	        	 columnas=linea.split(";");//dividimos columnas
	        	 
	        	 
	        	 if (columnas[2].equalsIgnoreCase(provincia) && (afloat = Float.parseFloat(columnas[1])) > media) {
	        		    
	        		 System.out.println(columnas[0]+ "              "+columnas[1] );
	        		}

	         }
	         if(fr != null&& br != null){
	                fr.close();
	                br.close();
	            }
			
		} catch (Exception e) {
		e.getMessage();
		}		
	}
}