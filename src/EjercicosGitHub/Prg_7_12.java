package EjercicosGitHub;
/***
 * @autor Alvaro Comenge 
 * 
 * @fecha 15/05/24
 * 
 * @descripcion
 * Una empresa guarda en un fichero secuencial, VENTAS, las ventas efectuadas por sus empleados. 
 * Está ordenado por CODIGO y cada vendedor tendrá tantos registros como ventas haya realizado.
 * MES contendrá el número de mes en el que se ha realizado la venta. DIA indicará el día del mes en que
 * se efectuó. R-VENTAS CODIGO IMPORTE MES DIA Se desea visualizar:  el total vendido por cada vendedor, 
 * Total vendido, vendedor XXXXX: 99999999 ... Total vendido, vendedor XXXXX: 99999999 
 *  los totales vendidos por día y el total de mes, TOTALES POR DÍAS MES: XXXXXXXXXX 
 * DIA TOTAL DIA 1 99999999 ... ... 31 99999999 TOTAL MES: 9999999999 
 * los totales vendidos y la venta media en cada uno de los meses, especificando el nombre del mes,
 * así como el total de ventas y la venta media(de las medias). 
 * TOTALVENTA MEDIA ENERO 99999999 999999 FEBRERO 99999999 999999 ... DICIEMBRE 99999999 999999 
 * TOTAL VENTAS: 9999999999
 * 
 */

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
