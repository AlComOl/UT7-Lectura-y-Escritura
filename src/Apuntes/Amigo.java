package Apuntes;
import java.io.*;
	public class Amigo implements Serializable{
	
		
		
				protected String nombre;
				protected long telefono;
				protected String direccion;
				//protected transient int atributo; //con transient se hace que el atributo no sea serializable
				public Amigo(String n, long l,String d){
				nombre = n;
				telefono = l;
				direccion =d;
				}
				public void print(){
				System.out.println(nombre + " -> " + telefono+ "->"+ direccion);
				
				
			
		
		
		}
	
				public static void main(String [] args){
				String [] amigos = {"Juan Maria", "Maria", "Pepe", "Manuela", "Antonio", "Carmen"};
				long [] telefonos = {600325689, 656457812, 646859652, 636561245, 646124578, 654894523};
				String [] direccion = {"Valencia", "Madrid", "Sevilla", "Jaen", "Granada", "Barcelona"};
				//Escribir cadenas y long en un fichero
				try {
				//File f = new File("amigos.obj");
//					primero se carga las palabras con sin el true en FileOutputStream 
				FileOutputStream fs = new FileOutputStream("amigos.obj",true);
//				ObjectOutputStream oos = new ObjectOutputStream(fs);
//				despues se comenta el ObjectOutputStream y se pone el true en FileOutputStream. Descomentando MiObjectOuputStream
				MiObjectOuputStream oos = new MiObjectOuputStream(fs);
				for (int i=0; i<amigos.length; i++) {
				Amigo a = new Amigo(amigos[i], telefonos[i],direccion[i]);
				oos.writeObject(a);
				}
				if (oos != null) {
				oos.close();
				fs.close();
				}
				}catch (IOException e) {
				e.printStackTrace();
				}
				//Leer de un fichero objetos
				try {
				File f = null;
				FileInputStream fe = null;
				ObjectInputStream ois = null;
				try {
				f= new File("amigos.obj");
				if(f.exists()) {
				fe=new FileInputStream(f);
				ois= new ObjectInputStream(fe);
				while(true) {
				Amigo a = null;
				a = (Amigo) ois.readObject();
				a.print();
				// System.out.println("");
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
				if (ois != null) {
				ois.close();
				fe.close();
				}
				
				}
				}catch (IOException e) {
				e.printStackTrace();
				}
				} //del main
				}
				
			
			
