import java.io.*;
/**
 * Se leen n�meros separados por comas por consola. Posteriormente
 * se imprime la serie de n�meros ordenados de menor a mayor usando el 
 * algoritmo de "Bubble Sort".
 */

/**
 * @author Nicol�s David Espejo Bernal
 *
 */
/**
 */
public class BubbleSort {
	/**
	 * Funci�n que ordena el arreglo.
	 * @param array = Arreglo de enteros que se recibe.
	 */
	public static void bubbleSort (int [] array) {
		boolean swapped; //Se crea un booleano que dir� si hubo "swap" o no.
		int swap; //Se crea una variable auxiliar para realizar el cambio dentro del vector.
		for (int i =0; i< array.length -1; i++) {
			swapped = false; //Antes de que comience el ciclo, el booleano quedar� en Falso.
			for (int j= 0; j< array.length-1; j++) {
				if (array[j] > array[j+1]) { //Si se cumple la condici�n se hace "swap".
					swap = array [j];
					array [j] = array [j+1];
					array [j+1] = swap;
					swapped = true; //Si no se entra en esta condici�n, el booleano quedar� con el valor de antes (F).
				}
			}
			if (!swapped) //Si el booleano sigue en falso, se rompe el ciclo.
				break;	
		}
	}
	/**
	 * Funci�n que imprime arreglos de tipo entero.
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
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
			bw.write("Ingrese n�meros separados por comas: " + "\n");
			bw.flush();
			String line = br.readLine(); //L�nea de n�meros.
			int [] enteros = llenar(line); //Se llama a la funci�n para pasar los n�meros a enteros.
			bubbleSort(enteros); //Se llama la funci�n para arreglar el vector.
			bw.write("Arreglo ordenado : " + "\n");
			bw.flush();
			print (enteros); //Se imprime.
			
		}
		catch (Exception ex) {}
	}

}
