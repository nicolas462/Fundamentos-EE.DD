import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ordenamiento de arreglos con algoritmo de Mage Sort.
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 15/04/2018
 */
public class MargeSort {
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
	
	public static int [] mergeSort (int [] a) {
		int i=0;
		int nleft = a.length /2; //Tamaño de la primera mitad del arreglo.
		int nright = a.length  - nleft; //Tamaño de la otra mitad del arreglo.
		//Se crean los dos arreglos del tamaño establecido anteriormente.
		int right_sub_array [] = new int [nright];
		int left_sub_array [] = new int [nleft];
		if (a.length == 1) //Cuando el arreglo esté ordenado.
			return a;
		else {
			//Llenar cada mitad del arreglo.
			for (i =0; i<nleft; i++) 
				left_sub_array[i] =  a[i];
			for (i= nleft +1; i< a.length; i++)
				left_sub_array [i - (nleft + 1)] = a[i];
			//Ordenar cada una de las partes
			int [] sortedL = mergeSort (left_sub_array);
			int [] sortedR = mergeSort (right_sub_array);
			// Estrategia divide y vencerás.
			return merge (sortedL, sortedR);		
		}
	}
	public static int [] merge (int[] a, int [] b) {
		int l = a.length + b.length;
		//Crear arreglo 'C'
		int [] c = new int [l];
		int indexA = 0, indexB = 0, indexC = 0;
		while (a.length > indexA && b.length > indexB) {
			if (a[indexA] < b[indexB]) {
				//Añadir elemento del arreglo 'a'.
				c [indexC] = a[indexA];
				indexA ++;
				indexC ++;
			}
			else {
				//Añadir elemento del arreglo 'b'.
				c[indexC] = a[indexA];
				indexB ++;
				indexC ++;
				
			}
		}
		// Uno del 'a' o 'b' tiene aún algunos elementos.
		while (a.length > indexA) {
			c[indexC] = a[indexA];
			indexA ++;
			indexC ++;
		}
		while (b.length > indexB) {
			c[indexC] = b[indexB];
			indexB ++;
			indexC ++;
		}
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
			bw.write("Ingrese números separados por comas : \n");
			bw.flush();
			String line = br.readLine(); 
			int [] arreglo = llenar(line); //Se llama a la función para crear el arreglo de enteros.
			int [] ordenado = mergeSort (arreglo);
			print(ordenado);
			
		}
		catch (Exception ex) {}

	}

}
