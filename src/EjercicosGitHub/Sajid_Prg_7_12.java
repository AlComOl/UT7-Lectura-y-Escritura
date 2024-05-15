package EjercicosGitHub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sajid_Prg_7_12 {

	public static void main(String[] args) {
		ejercicio1("Vendedores.txt");
	}
	public static void ejercicio1(String nf) {
		double suma = 0,sumaTotal=0,sumaAux = 0;
		int codigo,aux=1;
		File fe = new File(nf);
		if(fe.exists()) {
			try {
				FileReader fr = new FileReader(fe);
				BufferedReader br = new BufferedReader(fr);
				String cadena;
				while((cadena = br.readLine()) != null) {
					StringTokenizer str;
					str = new StringTokenizer(cadena);
					String []vendedor ={str.nextToken(),str.nextToken(),str.nextToken(),str.nextToken()};
					sumaTotal += Double.parseDouble(vendedor[1]);
					codigo = Integer.parseInt(vendedor[0]);

					if(codigo != aux) {
						System.out.println("Total Vendido por:" + aux + " vendido:" + sumaAux);
						suma=0;
					}
					suma += Double.parseDouble(vendedor[1]);
					aux = codigo;
					sumaAux=suma;
					}
				System.out.println("Total Vendido por:" + aux + " vendido:" + sumaAux);
				System.out.println("Total Vendido por Vendedores:" + sumaTotal);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}

}
