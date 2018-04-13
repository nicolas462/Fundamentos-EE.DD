import java.io.*;

/**
 * Solución al problema 1 del taller.
 * Se deben dividir los datos ingresados por consola, que estáran separados por comas. Estos datos
 * se almacenarán en un vector de enteros para poder operarlos y poder obtener una salida.
 * Se tomarán los datos y se operarán, si la diferencia de los datos es igual a 'k' se suma
 * al acumulador, para al final mostar cuántas parejas cumplen con la condición.
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 */
public class Problema1 {
	/**
	 * Retorna la cantidad de parejas que cumplen la condición, la cual es que el resultado de su diferencia sea 'k'.
	 * @param arreglo = Arreglo que contiene la serie de números que se ingresarán por consola.
	 * @param k = Resultado que se debe obtener para que sume el acumulador.
	 * @return acumu = Se sumará uno cada vez que se cumpla la condición.
	 */
	public static int salida(int [] arreglo, int k) 
	{
		int acum=0;
		for (int i= 0; i<arreglo.length; i++) {
			for(int j = 0; j<arreglo.length; j++) {
				if (arreglo[i] - arreglo[j] == k)
					acum ++;
			}
		}
		return acum;
	}
	
	/**
	 * @param args
	 */
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
			int [] arreglo = new int [datos.length]; //Acá se almacenarán los datos.
			for (int i= 0; i<datos.length ; i++) //Se almacenan los datos del vector de strings, en uno de enteros.
				arreglo [i] = Integer.parseInt(datos[i]);
			
			bw.write(""+salida(arreglo, k)); //Se imprime llamando a la función.
			bw.flush();
			
		}
		catch (Exception ex) {}

	}

}
