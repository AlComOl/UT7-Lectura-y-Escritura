package Practica17524;
/************************************************
 * @autor Álvaro Comenge Oliver
 * 
 * @descripcion Esta clase es para que se graben 
 * mas objetos en el fichero de objetos, de manera que solo se haga un cabecera
 * en el archivo.
 * 
 * 
 * ******************************************/

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream  extends ObjectOutputStream{

	public MiObjectOutputStream(OutputStream out)throws IOException  {
		super(out);
		
	}
	
	public MiObjectOutputStream() throws  IOException, SecurityException {
		super();
		
	}
	
	protected void writeStreamHeader()throws IOException {
		
	}

}
