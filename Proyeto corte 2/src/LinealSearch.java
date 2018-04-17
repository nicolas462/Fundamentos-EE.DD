import java.io.*;
import java.lang.reflect.Array;
/**
 * 
 */

/**
 * @author Nicol�s David Espejo Bernal
 *
 * 17/04/2018
 */
public class LinealSearch {
	/**
	 * Pasa la l�nea ingresada de n�meros separados por comas, a un arreglo de enteros.
	 * @param line = String con n�meros separados por comas.
	 * @return = Arreglo de enteros con n�meros.
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
	 * Busca un valor dentro de un arreglo. Si est� retorna un valor positivo, si no retorna -1;
	 * @param a = Arreglo que se usar�.
	 * @param data = Valor a buscar.
	 * @return = Retorna la primera posici�n donde se encont� el valor.
	 */
	public static int linealSearch (int [] a, int data) {
		int index = -1;
		// Comparar con elementos del arreglo
		for (int i= 0; i<a.length; i++) {
			if (a[i] == data) { 
				index = i;
				break; //Cuando se encuentre el valor dentro del arreglo, se romper� el ciclo.
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
			bw.write("Ingrese n�meros: \n");
			bw.flush();
			String line = br.readLine();
			int [] array =llenar(line); //Se guardan valores de la funci�n en un vector.
			bw.write("Ingrese valor a buscar: \n");
			bw.flush();
			int valor = Integer.parseInt(br.readLine());
			int i = linealSearch(array, valor); //Se guarda el valor retornado en una variable.
			if (i >= 0) //Si no es -1
				bw.write("El valor est� en el �ndice "+ linealSearch(array, valor)+".");
			else
				bw.write("El valor no se encontr�.");
			bw.flush();
		}
		catch (Exception ex) {}
	}

}
