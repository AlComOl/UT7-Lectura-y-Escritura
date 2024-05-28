import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FicheroBinText {

    public static void main(String[] args) {
        boolean result = deTxtABinario("archivo.txt", "archivo.bin");
        System.out.println("Conversión exitosa: " + result);
    }
    
    public static boolean deTxtABinario(String ficheroText, String ficheroBin) {
        File f = new File(ficheroText);
        String linea;
        boolean conversion = false;
        FileReader fr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        
        if (f.exists()) {
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                fos = new FileOutputStream(ficheroBin);
                
                while ((linea = br.readLine()) != null) {
                    fos.write(linea.getBytes());
                    fos.write(System.lineSeparator().getBytes()); // Añade nueva línea
                }
                conversion = true;
            } catch (IOException e) {
                e.printStackTrace();
                conversion = false;
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (fr != null) {
                        fr.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return conversion;
    }
}
