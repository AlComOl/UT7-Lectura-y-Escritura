package Excepciones2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileImput {
	
	
//	public class InputFile {
//		FileInputStream fis;
//		InputFile(String filename) { // el constructor de la clase InputFile
//		fis = new FileInputStream(filename);
//		}
//	}
		

	public class InputFile {
		FileInputStream fis;
		InputFile(String filename)throws FileNotFoundException { // el constructor de la clase InputFile
		fis = new FileInputStream(filename);
		}
		}
	}
