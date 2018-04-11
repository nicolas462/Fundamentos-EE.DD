import java.io.*;

/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 */
public class Problema1 {
	/**
	 * @param args
	 */
	public static int salida(int [] vector, int k) {
		int acum=0;
		for (int i= 0; i<vector.length; i++) {
			for(int j = 0; j<vector.length; j++) {
				if (vector[i] - vector[j] == k)
					acum ++;
			}
		}
		
		return acum;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //Buffer para leer entradas.
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out)); //Buffer para imprimir.
			String serie; //Acá se leerá la línea de números ingresados.
			
			bw.write("Ingrese números separados por comas: ");
			bw.flush();	
			serie = br.readLine(); //Se ingresa línea.
			bw.write("Ingrese 'k': ");
			bw.flush();
			int k = Integer.parseInt(br.readLine()); //Se ingresa K.
			
			String [] datos = serie.split(",");
			int [] vector = new int [datos.length]; //Acá se almacenarán los datos.
			for (int i= 0; i<datos.length ; i++) //Se almacenan los datos del vector de strings, en uno de enteros.
				vector [i] = Integer.parseInt(datos[i]);
			
			bw.write(""+salida(vector, k));
			bw.flush();
			
		}
		catch (Exception ex) {}

	}

}
