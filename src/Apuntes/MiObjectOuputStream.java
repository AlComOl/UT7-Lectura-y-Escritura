package Apuntes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOuputStream  extends ObjectOutputStream{

	public MiObjectOuputStream(OutputStream out)throws IOException  {
		super(out);
		
	}
	
	public MiObjectOuputStream() throws  IOException, SecurityException {
		super();
		
	}
	
	protected void writeStreamHeader()throws IOException {
		
	}

}
