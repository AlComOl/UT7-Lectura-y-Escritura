package EjercicosGitHub;
import java.io.*;
import java.util.Scanner;



public class Prg_7_11 {
	
	    private static final int MAX_REGISTROS = 500;
	    private static String[] nombres = new String[MAX_REGISTROS];
	    private static float[] alturas = new float[MAX_REGISTROS];
	    private static String[] provincias = new String[MAX_REGISTROS];
	    private static int totalRegistros = 0;

	    public static void main(String[] args) {
	        try {
	            crearArchivoAltos("ALTOS.DAT");
	            leerArchivoAltos("ALTOS.DAT");

	            Scanner sc = new Scanner(System.in);
	            System.out.print("Ingrese la provincia: ");
	            String provinciaBuscada = sc.nextLine().toUpperCase();//convierte en mayuscula(requisito del enunciado)

	            // Arrays para almacenar los nombres y alturas de los aspirantes de la provincia buscada
	            String[] aspirantesProvincia = new String[MAX_REGISTROS];
	            float[] alturasProvincia = new float[MAX_REGISTROS];
	            int cuentaAspirantes = 0;
	            float sumaAlturas = 0;

	            // Filtrar aspirantes por provincia y calcular la suma de sus alturas
	            for (int i = 0; i < totalRegistros; i++) {
	                if (provincias[i].equals(provinciaBuscada)) {
	                    aspirantesProvincia[cuentaAspirantes] = nombres[i];
	                    alturasProvincia[cuentaAspirantes] = alturas[i];
	                    sumaAlturas += alturas[i];
	                    cuentaAspirantes++;
	                }
	            }

	            if (cuentaAspirantes == 0) {
	                System.out.println("No hay aspirantes de la provincia indicada.");
	                return;
	            }

	            float alturaMedia = sumaAlturas / cuentaAspirantes;

	            // Emitir el informe con un máximo de 50 líneas por página
	            emitirInforme(provinciaBuscada, alturaMedia, aspirantesProvincia, alturasProvincia, cuentaAspirantes);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Crea un archivo con datos de aspirantes ingresados por teclado.
	     *
	     * @param nombreArchivo el nombre del archivo a crear
	     * @throws IOException si ocurre un error de E/S
	     */
	    private static void crearArchivoAltos(String nombreArchivo) throws IOException {
	        FileWriter fw = new FileWriter(nombreArchivo);
	        BufferedWriter bw = new BufferedWriter(fw);
	        Scanner sc = new Scanner(System.in);
	        String continuar;

	        do {
	            System.out.print("Ingrese el nombre del aspirante: ");
	            String nombre = sc.nextLine();
	            System.out.print("Ingrese la altura del aspirante (en metros): ");
	            float altura = sc.nextFloat();
	            sc.nextLine(); // consume the newline character
	            System.out.print("Ingrese la provincia de nacimiento del aspirante: ");
	            String provincia = sc.nextLine().toUpperCase();

	            bw.write(nombre + ";" + altura + ";" + provincia);
	            bw.newLine();

	            System.out.print("¿Desea ingresar otro aspirante? (s/n): ");
	            continuar = sc.nextLine();
	        } while (continuar.equalsIgnoreCase("s"));

	        bw.close();
	        fw.close();
	    }

	    /**
	     * Lee los datos del archivo y los almacena en los arreglos correspondientes.
	     *
	     * @param nombreArchivo el nombre del archivo a leer
	     * @throws IOException si ocurre un error de E/S
	     */
	    private static void leerArchivoAltos(String nombreArchivo) throws IOException {
	        FileReader fr = new FileReader(nombreArchivo);
	        BufferedReader br = new BufferedReader(fr);
	        String linea;
	        while ((linea = br.readLine()) != null && totalRegistros < MAX_REGISTROS) {
	            String[] campos = linea.split(";");
	            nombres[totalRegistros] = campos[0];
	            alturas[totalRegistros] = Float.parseFloat(campos[1]);
	            provincias[totalRegistros] = campos[2].toUpperCase();
	            totalRegistros++;
	        }
	        br.close();
	        fr.close();
	    }

	    /**
	     * Emite un informe con los nombres y alturas de los aspirantes de una provincia cuya altura supere la media.
	     *
	     * @param provinciaBuscada la provincia buscada
	     * @param alturaMedia la altura media de los aspirantes de la provincia
	     * @param aspirantesProvincia los nombres de los aspirantes de la provincia
	     * @param alturasProvincia las alturas de los aspirantes de la provincia
	     * @param cuentaAspirantes el número de aspirantes de la provincia
	     */
	    private static void emitirInforme(String provinciaBuscada, float alturaMedia, String[] aspirantesProvincia, float[] alturasProvincia, int cuentaAspirantes) {
	        System.out.println("Provincia: " + provinciaBuscada);
//	        altura del aspirante con dos decimales después del punto decimal
	        System.out.printf("Altura Media: %.2f%n", alturaMedia);
	        System.out.println("Nombre                          Altura");
	        System.out.println("-------------------------------------");

	        int lineCount = 0;

	        for (int i = 0; i < cuentaAspirantes; i++) {
	            if (alturasProvincia[i] > alturaMedia) {
//	            	 este código imprimirá el nombre del aspirante justificado a la izquierda en un campo de 30 caracteres
//	            	 y la altura del aspirante con dos decimales después del punto decimal, seguido de un salto de línea
	                System.out.printf("%-30s %.2f%n", aspirantesProvincia[i], alturasProvincia[i]);
	                lineCount++;

	                if (lineCount % 50 == 0) {
	                    System.out.println("Presione Enter para continuar...");
	                    try {
	                        System.in.read();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	}
