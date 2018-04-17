import java.io.*;
import java.lang.reflect.Array;
/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 17/04/2018
 */
public class LinealSearch {
	/**
	 * Pasa la línea ingresada de números separados por comas, a un arreglo de enteros.
	 * @param line = String con números separados por comas.
	 * @return = Arreglo de enteros con números.
	 */
	public static int [] llenar (String line) {
		String [] arreglo = line.split(",");
		int array [] = new int [arreglo.length];
		for (int i= 0; i< arreglo.length; i++) {
			array [i] = Integer.parseInt(arreglo[i]);
		}
		return array;
	}
	/**
	 * Busca un valor dentro de un arreglo. Si está retorna un valor positivo, si no retorna -1;
	 * @param a = Arreglo que se usará.
	 * @param data = Valor a buscar.
	 * @return = Retorna la primera posición donde se encontó el valor.
	 */
	public static int linealSearch (int [] a, int data) {
		int index = -1;
		// Comparar con elementos del arreglo
		for (int i= 0; i<a.length; i++) {
			if (a[i] == data) { 
				index = i;
				break; //Cuando se encuentre el valor dentro del arreglo, se romperá el ciclo.
			}
		}
		return index;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
			bw.write("Ingrese números: \n");
			bw.flush();
			String line = br.readLine();
			int [] array =llenar(line); //Se guardan valores de la función en un vector.
			bw.write("Ingrese valor a buscar: \n");
			bw.flush();
			int valor = Integer.parseInt(br.readLine());
			int i = linealSearch(array, valor); //Se guarda el valor retornado en una variable.
			if (i >= 0) //Si no es -1
				bw.write("El valor está en el índice "+ linealSearch(array, valor)+".");
			else
				bw.write("El valor no se encontró.");
			bw.flush();
		}
		catch (Exception ex) {}
	}

}
