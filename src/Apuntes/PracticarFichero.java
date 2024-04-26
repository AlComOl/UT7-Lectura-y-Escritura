package Apuntes;

import java.io.FileInputStream;
import java.io.IOException;

public class PracticarFichero {

	public static void main(String[] args) {
		

	}
	
	public static void cuentaAmigos(String fichero) {
		
		FileInputStream f = null;
		String cadena = "";
		char caracter;
	
		try {
		f = new FileInputStream(fichero); // abre fichero para leer caracteres byte a byte
		int size = f.available();
		for (int i = 0; i < size; i++) {
		caracter = (char) f.read();
		cadena = cadena + caracter;
		}
		System.out.println(cadena);
		}catch (IOException e) {
		e.printStackTrace();
		}finally{
		try {
		if (f != null) {
		f.close();
		System.out.println("Fichero leido con exito");
		} else
		System.out.println("Fichero NO leido");
		}catch(IOException e){
			e.printStackTrace();
		}
		}
		return cadena;
		
	}
}
