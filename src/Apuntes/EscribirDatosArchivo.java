package Apuntes;

import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirDatosArchivo {

	public static void main(String [] args) {
		
		String cadena = "En un lugar de la mancha de cuyo nombre no quiero acordarme...";
		escribirFileOutputStream(cadena, "cadena.dat");
		}
	
	public static void escribirFileOutputStream (String cadena, String fichero){
		FileOutputStream f = null;
		char caracter = 0;
		try {
		f = new FileOutputStream(fichero);
		for (int i = 0; i < cadena.length(); i++) {
		caracter = cadena.charAt(i);
		f.write((byte) caracter);
		}
		}catch (IOException e) {
		e.printStackTrace();
		}finally{
		try {
		if (f != null) {
		f.close();
		System.out.println("Fichero creado con exito");
		} else
		System.out.println("Fichero NO creado");
		}catch(IOException e){
		e.printStackTrace();
		}
		}
		}
		}


