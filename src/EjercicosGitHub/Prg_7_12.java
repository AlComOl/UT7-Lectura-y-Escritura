package EjercicosGitHub;
/****************************************************************
 * @autor Álvaro Comenge 
 * 
 * @Ejercicio 12 de GITHUB
 * 
 * 
 * Entrega 20/05/2024
 * 
 * 
 ****************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Prg_7_12 {

    public static void main(String[] args) {
        String nombreArchivo = "ventas.csv";
        try {
            crearArchivoVentas(nombreArchivo);
            double[] ventas = leerArchivoVentas(nombreArchivo);
            mostrarTotalPorVendedor(ventas);
            mostrarTotalesPorDiaYMes(ventas);
            mostrarTotalVentasYMediaPorMes(ventas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearArchivoVentas(String nombreArchivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
        String[] datosVentas = {
        		"1; 100; 1; 5",
        		"2; 150; 1; 8",
        		"1; 200; 1; 12",
        		"2; 120; 2; 3",
        		"1; 180; 2; 7",
        		"3; 220; 2; 10",
        		"3; 130; 3; 2",
        		"2; 190; 3; 5",
        		"1; 170; 3; 9",
        		"2; 140; 4; 1",
        		"1; 210; 4; 4",
        		"3; 160; 4; 6"
        };

        for (String venta : datosVentas) {
            bw.write(venta);
            bw.newLine();
        }

        bw.close();
    }

    public static double[] leerArchivoVentas(String nombreArchivo) throws IOException {
        // Creamos un lector de archivos para leer el archivo de ventas
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea; // Variable para almacenar cada línea leída del archivo
        int numVentas = 0; // Contador para el número de ventas en el archivo

        // Contamos el número de ventas en el archivo contando las líneas
        while ((linea = br.readLine()) != null) {
            numVentas++; // Incrementamos el contador de ventas
        }
        br.close(); // Cerramos el lector de archivos

        // Creamos un arreglo para almacenar las ventas, multiplicando por 4 para tener en cuenta los cuatro valores por venta
        double[] ventas = new double[numVentas * 4];
        br = new BufferedReader(new FileReader(nombreArchivo)); // Abrimos nuevamente el lector de archivos
        int index = 0; // Índice para almacenar las ventas en el arreglo

        // Leemos cada línea del archivo
        while ((linea = br.readLine()) != null) {
            // Dividimos la línea en partes separadas por ", "
            String[] partes = linea.split("; ");
            // Iteramos sobre cada parte
            for (String parte : partes) {
                ventas[index++] = Double.parseDouble(parte); // Convertimos y almacenamos cada parte como un double en el arreglo
            }
        }
        br.close(); // Cerramos el lector de archivos
        return ventas; // Retornamos el arreglo de ventas
    }

    public static void mostrarTotalPorVendedor(double[] ventas) {
        // Map para almacenar el total vendido por cada vendedor
        Map<Double, Double> totalPorVendedor = new HashMap<>();

        // Iterar sobre las ventas
        for (int i = 0; i < ventas.length; i += 4) {
            // Obtener el código del vendedor y el importe de la venta
            double codigoVendedor = ventas[i];
            double importe = ventas[i + 1];

            // Verificar si el vendedor ya está en el mapa
            if (!totalPorVendedor.containsKey(codigoVendedor)) {
                // Si no está, agregarlo al mapa con el importe actual
                totalPorVendedor.put(codigoVendedor, importe);
            } else {
                // Si ya está, sumar el importe actual al total del vendedor
                double totalActual = totalPorVendedor.get(codigoVendedor);
                totalPorVendedor.put(codigoVendedor, totalActual + importe);
            }
        }

        // Imprimir el total vendido por cada vendedor
        System.out.println("Total vendido por cada vendedor:");
        for (Double codigoVendedor : totalPorVendedor.keySet()) {
            double totalVenta = totalPorVendedor.get(codigoVendedor);
            System.out.println("Total vendido, vendedor " + codigoVendedor + ": " + totalVenta);
        }
    }

 // Esta función muestra los totales vendidos por día y el total del mes.

    public static void mostrarTotalesPorDiaYMes(double[] ventas) {
        // Creamos un arreglo para almacenar los totales vendidos por día (31 días)
        double[] totalPorDia = new double[31];
        // Inicializamos el total del mes en 0
        double totalMes = 0;

        // Iteramos sobre las ventas
        for (int i = 0; i < ventas.length; i += 4) {
            // Obtenemos el día y el importe de la venta de la posición actual en el arreglo
            int dia = (int) ventas[i + 3];
            double importe = ventas[i + 1];
            // Sumamos el importe de la venta al total del día correspondiente
            totalPorDia[dia - 1] += importe;
            // Sumamos el importe de la venta al total del mes
            totalMes += importe;
        }

        // Imprimimos los totales vendidos por día y el total del mes
        System.out.println("Totales vendidos por día y el total de mes:");
        System.out.println("TOTALES POR DÍAS");
        System.out.println("MES: XXXXXXXXXX"); // Esta línea debería mostrar el número del mes
        System.out.println("DIA TOTAL DIA");
        // Iteramos sobre el arreglo de totales por día
        for (int i = 0; i < totalPorDia.length; i++) {
            // Imprimimos el número de día y su respectivo total, usando formato tabulado
            System.out.printf("%-3d %-10.2f%n", (i + 1), totalPorDia[i]);
        }
        // Imprimimos el total del mes
        System.out.println("TOTAL MES: " + totalMes);
    }

    
 // Esta función muestra los totales vendidos y la venta media en cada uno de los meses.

    public static void mostrarTotalVentasYMediaPorMes(double[] ventas) {
        // Creamos un arreglo para almacenar los totales vendidos por cada mes (12 meses)
        double[] totalPorMes = new double[12];
        // Creamos un arreglo para contar el número de ventas por cada mes
        int[] contadorPorMes = new int[12];

        // Iteramos sobre las ventas
        for (int i = 0; i < ventas.length; i += 4) {
            // Obtenemos el mes y el importe de la venta de la posición actual en el arreglo
            int mes = (int) ventas[i + 2];
            double importe = ventas[i + 1];
            // Sumamos el importe de la venta al total del mes correspondiente
            totalPorMes[mes - 1] += importe;
            // Incrementamos el contador de ventas para el mes correspondiente
            contadorPorMes[mes - 1]++;
        }

        // Imprimimos el encabezado de la sección
        System.out.println("Totales vendidos y la venta media en cada uno de los meses:");
        System.out.println("TOTALVENTA MEDIA");
        // Creamos un arreglo con los nombres de los meses
        String[] nombresMeses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        // Inicializamos variables para calcular el total de ventas y el total de ventas en todos los meses
        double totalVentas = 0;
        int totalVentasMeses = 0;

        // Iteramos sobre los totales por mes
        for (int i = 0; i < totalPorMes.length; i++) {
            // Imprimimos el nombre del mes y su respectivo total de ventas, usando formato tabulado
            System.out.printf("%-7s %-10.2f", nombresMeses[i], totalPorMes[i]);
            // Verificamos si hay ventas en el mes actual
            if (contadorPorMes[i] > 0) {
                // Calculamos la venta media para el mes actual
                double ventaMedia = totalPorMes[i] / contadorPorMes[i];
                // Imprimimos la venta media
                System.out.printf(" %-10.2f%n", ventaMedia);
                // Actualizamos el total de ventas y el total de ventas en todos los meses
                totalVentas += totalPorMes[i];
                totalVentasMeses += contadorPorMes[i];
            } else {
                // Si no hay ventas en el mes actual, imprimimos 0 como venta media
                System.out.println(" 0");
            }
        }

        // Calculamos la venta media total
        double ventaMediaTotal = totalVentasMeses > 0 ? totalVentas / totalVentasMeses : 0;
        // Imprimimos el total de ventas y la venta media total
        System.out.println("TOTAL VENTAS: " + totalVentas + " " + ventaMediaTotal);
    }

}
