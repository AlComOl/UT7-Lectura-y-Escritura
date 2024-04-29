package Apuntes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOuputStreamDataInputStream {
	
		public static void main(String [] args) {
		String [] amigos = {"Juan Maria", "Maria", "Pepe", "Manuela", "Antonio", "Carmen"};
		long [] telefonos = {600325689, 656457812, 646859652, 636561245, 646124578, 654894523};
		//Escribir cadenas y long en un fichero
		try {
	
		  FileOutputStream fs = new FileOutputStream("amigos.dat");
		  DataOutputStream d = new DataOutputStream(fs);
			for (int i=0; i<amigos.length; i++) {
				d.writeUTF(amigos[i]);
				d.writeLong(telefonos[i]);
				
			}
			if (d != null) {
				d.close();
				fs.close();
			}
		}catch (IOException e) {
		e.printStackTrace();
		}
		//Leer de un fichero cadenas y long
		try {
			File f = null;
			FileInputStream fe = null;
			DataInputStream d = null;
		try {
		f= new File("amigos.dat");
			if(f.exists()) { //si hemos establecido la conexión
			 fe=new FileInputStream(f); // se instancian los objetos
			 d= new DataInputStream(fe); // se instancian los objetos
			 String s;
			 long l;
				while(true) { //bucle infinito
				s = d.readUTF();
				l = d.readLong();
				System.out.println(s + " -> " + l);
				}
			
			}
		}catch (EOFException eof) {
		System.out.println("-------------------------------");
		
		}catch (FileNotFoundException fnf) {
		System.out.println("Fichero no encontrado " +fnf);
		
		}catch (Throwable t) {
		System.err.println("Error de programa "+ t);
		t.printStackTrace();
		
		} finally {
		if (d != null) {
		d.close();
		fe.close();
		}
		}
		}catch (IOException e) {
		e.printStackTrace();
		}
		}
}
