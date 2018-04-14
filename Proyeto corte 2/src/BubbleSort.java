import java.io.*;
/**
 * Se leen números separados por comas por consola. Posteriormente
 * se imprime la serie de números ordenados de menor a mayor usando el 
 * algoritmo de "Bubble Sort".
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 */
/**
 */
public class BubbleSort {
	/**
	 * Función que ordena el arreglo.
	 * @param array = Arreglo de enteros que se recibe.
	 */
	public static void bubbleSort (int [] array) {
		boolean swapped; //Se crea un booleano que dirá si hubo "swap" o no.
		int swap; //Se crea una variable auxiliar para realizar el cambio dentro del vector.
		for (int i =0; i< array.length -1; i++) {
			swapped = false; //Antes de que comience el ciclo, el booleano quedará en Falso.
			for (int j= 0; j< array.length-1; j++) {
				if (array[j] > array[j+1]) { //Si se cumple la condición se hace "swap".
					swap = array [j];
					array [j] = array [j+1];
					array [j+1] = swap;
					swapped = true; //Si no se entra en esta condición, el booleano quedará con el valor de antes (F).
				}
			}
			if (!swapped) //Si el booleano sigue en falso, se rompe el ciclo.
				break;	
		}
	}
	/**
	 * Función que imprime arreglos de tipo entero.
	 * @param array = Arreglo de enteros.
	 */
	public static void print (int [] array) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			for (int i= 0; i<array.length; i++)
				bw.write(array[i] + " ");
			bw.flush();
		}
		catch (Exception ex) {}
	}
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
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
			bw.write("Ingrese números separados por comas: " + "\n");
			bw.flush();
			String line = br.readLine(); //Línea de números.
			int [] enteros = llenar(line); //Se llama a la función para pasar los números a enteros.
			bubbleSort(enteros); //Se llama la función para arreglar el vector.
			bw.write("Arreglo ordenado : " + "\n");
			bw.flush();
			print (enteros); //Se imprime.
			
		}
		catch (Exception ex) {}
	}

}
