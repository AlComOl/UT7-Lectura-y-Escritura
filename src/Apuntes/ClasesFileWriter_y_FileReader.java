package Apuntes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClasesFileWriter_y_FileReader {
	public static void main(String [] args) {
		 
		String [] amigos= {"Jose","Pepe","Andres"};
		
	
	escribirFileWriter(amigos,"cadan.dat");
	
	leerFileReader("cadan.dat");
	
	}
	public static void escribirFileWriter(String[] amigos, String nombreFichero){
		
		
	
		try {
			File fs = new File("..//nombreFichero");
		FileWriter fw = new FileWriter(fs,true); //true para que añada al fichero amigos
		/* int i=0;
		for (String s : amigos) {
		s=i+" "+s;
		fw.write(s, 0, s.length());
		fw.write("\r\n");
		i++;
		}*/
		for (int i=0; i<amigos.length; i++) {
		fw.write(i+ " "+amigos[i]);
		fw.write("\r\n");
		}
		if (fw != null) {fw.close();
		System.out.println("Se ha creado");
		}
		}catch (IOException e) {
		e.printStackTrace();
		}
		}
		public static void leerFileReader(String fichero) {
		File fe = new File(fichero);
		if (fe.exists()) {
		try {
		FileReader fr = new FileReader(fe);
		BufferedReader br = new BufferedReader(fr);
		String cadena;
		while((cadena = br.readLine()) != null) {
		System.out.println(cadena);
		}
		if (fr != null) {fr.close();}
		}catch (IOException e) {
		e.printStackTrace();
		}
		}
		}
}
