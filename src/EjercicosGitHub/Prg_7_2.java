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
//		pasamos los 3 archivos donde vamos a trabajar a File
		File archivoTexto=new File(fichero);
		File parejas=new File(fparejas);
		File resultante=new File(fresultante);
//		Creamos un arrayList dodne almacenaremos las palabras emparejadas
		ArrayList palabrasEmparejadas=new ArrayList <String>();
		
		try {
//			Aqui metemos en el arrayList las palabras que estan emparejadas en el archivo separadas por comas
			FileReader lectorParejas=new FileReader(parejas);
//			Envolvemos en un BuferedReader para facilitar la lectura linea a linea
			BufferedReader lineasLectorParejas=new BufferedReader(lectorParejas);
			String palabrasEnLaLinea="";
//			mientras haya algo en la linea sigue leyendo, cuando este vacia para 
//			Lo que conseguimos es almacenar las palabras de la linea en el arrayList
			while((palabrasEnLaLinea = lineasLectorParejas.readLine())!=null) {
//				split lo mete en el vector , y lo separa por las comas 
				String [] palabrasPorLinea=palabrasEnLaLinea.split(",");
					for(int i=0; i<palabrasPorLinea.length;i++) {
//						lo va introduciendo en el arrayList
						palabrasEmparejadas.add(palabrasPorLinea[i]);
					}
			}
			lectorParejas.close();//cerramos lectorparejas
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