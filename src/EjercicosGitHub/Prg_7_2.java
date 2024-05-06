package EjercicosGitHub;
import java.io.*;
import java.util.*;

/**********************************************************************
 * @autor Álvaro Comenge 
 * 
 * @fecha 
 * 
 * 
 * @descripcion
 * 
 * Realice una clase con un método cambiaPalabras() al que se pasan tres 
 * parámetros, el primero es un fichero tipo texto de entrada, el segundo tiene parejas 
 * de palabras donde la primera ha de sustituir a la segunda en el fichero y el nuevo fichero 
 * será el tercer parámetro. Fichero entrada -> Fichero con parejas de palabras
 *  -> Fichero de salida Modifique el programa para que el fichero de salida sea el mismo 
 *  fichero de entrada.
 * 
 * *******************************************************************/
public class Prg_7_2 {

	public static void main(String[] args) {
		
		cambiarPalabras("ftexto.txt","fparejas","fresultante");
	}

	public static void cambiarPalabras(String fichero,String fparejas,String fresultante) {
		
		File archivoTexto=new File(fichero);
		File parejas=new File(fparejas);
		File resultante=new File(fresultante);
		
		ArrayList palabrasEmparejadas=new ArrayList <String>();
		
		try {
			FileReader lectorParejas=new FileReader(parejas);
			BufferedReader lineasLectorParejas=new BufferedReader(lectorParejas);
			String palabrasEnLaLinea="";
			while((palabrasEnLaLinea = lineasLectorParejas.readLine())!=null) {
				String [] palabrasPorLinea=palabrasEnLaLinea.split(",");
					for(int i=0; i<palabrasPorLinea.length;i++) {
						palabrasEmparejadas.add(palabrasPorLinea[i]);
					}
			}
			lectorParejas.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int cantidadDePalabrasEmparejadas=palabrasEmparejadas.size();
		
		try {
			FileReader lectorLibro=new FileReader(archivoTexto);
			BufferedReader lineasLectorParejas=new BufferedReader(lectorLibro);
			FileWriter fw=new FileWriter(resultante,true);
			String palabrasEnLaLinea="";
			 Boolean palabraIntroducida = false;
	            while ((palabrasEnLaLinea = lineasLectorParejas.readLine()) != null){
	                String [] palabrasPorLinea = palabrasEnLaLinea.split(",");
	                for(int i = 0; i < palabrasPorLinea.length; i++){
	                    palabraIntroducida = false;
	                    for (int j = 0; j < cantidadDePalabrasEmparejadas && palabraIntroducida == false; j++) {
	                        if (palabrasPorLinea[i].equals(palabrasEmparejadas.get(j))){
	                            fw.write(palabrasEmparejadas.get(j + 1) + "\n");
	                            palabraIntroducida = true;
	                        } 
	                    }
	                    if(palabraIntroducida == false) fw.write(palabrasPorLinea[i] + "\n");
	                }   
	            }
	            lectorLibro.close();
	            fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}