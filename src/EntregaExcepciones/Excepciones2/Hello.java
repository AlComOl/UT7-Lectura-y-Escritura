package Excepciones2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hello {
		public static void main(String argv[]){
			int uno_diez[] = new int[10];
			
			try {
			uno_diez[12] = 10;
			} catch(java.lang.ArrayIndexOutOfBoundsException e) {
				
			System.out.println("Error, hemos sobrepasado el tamaño del array");
			// aquí podemos hacer lo que queramos
			}
		}
		
		public class InputFile {
			FileInputStream fis;
			InputFile(String filename) throws FileNotFoundException { // el constructor de la clase InputFile
			fis = new FileInputStream(filename);
			}
			}
}
