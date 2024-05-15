package EjercicosGitHub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Prg_7_12 {
	
	public static void main(String [] args) {
		
//		TotalPorVendedor("Vendedores.txt");
		
		
		IntroducirFicheroAMatriz("Vendedores.txt");
	}
	
	

	/***
	 * @descripcion esta funcion muestra el total por vendedor
	 * y el total de todos los vendedores
	 * 	
	 * @param fichero
	 */
	public static void TotalPorVendedor(String fichero) {
		double TotalVentas=0,sumaAux=0,suma=0;
		int codigo, aux=1;
		File f = new File(fichero);
		if(f.exists()) {
			
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				
				String cadena;
				
				while((cadena = br.readLine()) != null ){
					StringTokenizer stk;
					stk=new StringTokenizer(cadena);
					
					String [] codigoVendedor=new String[4];
					
					for(int i=0;i< 4;i++) {
						codigoVendedor[i]=stk.nextToken();	
					}
					
					
					TotalVentas += Double.parseDouble(codigoVendedor[1]);
					codigo=Integer.parseInt(codigoVendedor[0]);
					
					if(codigo!=aux) {
						System.out.println("El Vendedor con codigo "+ aux +" ha vendido "+sumaAux+"Euros");
						suma=0;
					}
					suma+=Double.parseDouble(codigoVendedor[1]);
					aux = codigo;
					sumaAux=suma;
					
				}
				System.out.println("El Vendedor con codigo "+ aux +" ha vendido "+sumaAux+"Euros");
				System.out.println("Total Vendido por Vendedores:" + TotalVentas);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void IntroducirFicheroAMatriz(String fichero) {
	    BufferedReader br = null;
	    try {
	        File file = new File(fichero);
	        FileReader fileReader = new FileReader(file);
	        br = new BufferedReader(fileReader);
	        String linea;
	        int filas = contarLineas(fichero); // Obtener el número de líneas en el archivo, se lo pasa de la funcion de bajo 
	        int columnas = 4; // Número de columnas basado en el formato del archivo
	        double[][] matriz = new double[filas][columnas]; // Inicializar la matriz

	        int fila = 0; // Contador de filas

	        while ((linea = br.readLine()) != null) {
	            String[] valores = linea.trim().split(" "); // Dividir la línea por espacios
	            int columna = 0; // Contador de columnas

	            for (String valor : valores) {
	                if (columna < columnas) {
	                    matriz[fila][columna] = Double.parseDouble(valor); // Convertir y asignar el valor a la matriz
	                    columna++;
	                }
	            }

	            fila++; // Avanzar al siguiente fila
	        }

	        // Imprimir la matriz
	        for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                System.out.print(matriz[i][j] + " ");
	            }
	            System.out.println(); // Salto de línea al final de cada fila
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
		/***
		 * toma el nombre de un archivo como entrada y devuelve el número de líneas en ese archivo.
		 * 
		 * @param nombreArchivo
		 * @return
		 * @throws IOException
		 */
	public static int contarLineas(String fichero) throws IOException {
	    BufferedReader bf = null;
	    int lineCount = 0;
	    try {
	        bf = new BufferedReader(new FileReader(fichero));
	        while (bf.readLine() != null) {
	            lineCount++;
	        }
	    } finally {
	        if (bf != null) {
	            try {
	            	bf.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return lineCount;
	}
}
