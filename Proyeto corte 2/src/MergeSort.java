<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ordenamiento de arreglos con algoritmo de Mage Sort.
 */

/**
 * @author Nicol·s David Espejo Bernal
 *
 * 15/04/2018
 */
public class MergeSort {
	/**
	 * Pasa la lÌnea ingresada de n˙meros separados por comas, a un arreglo de enteros.
	 * @param line = String con n˙meros separados por comas.
	 * @return = Arreglo de enteros con n˙meros.
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
	 * FunciÛn que imprime arreglos de tipo entero.
	 * @param array = Arreglo de enteros.
	 */
	public static void print (int [] array) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			for (int i= 0; i<array.length; i++) {
				if (i == array.length -1)
					bw.write(array[i] + "\n");
				else
					bw.write(array[i] + " ");
			}
			bw.flush();
		}
		catch (Exception ex) {}
	}
	/**
	 * Algoritmo de ordenamiento Merge Sort recursivo. Divide el arreglo hasta que estÈ en tamaÒo 1.
	 * @param a = Arreglo para ordenar.
	 * @return = Arreglo ordenado.
	 */
	public static int [] mergeSort (int [] a) {
		int nleft = a.length /2; //TamaÒo de la primera mitad del arreglo.
		int nright = a.length  - nleft; //TamaÒo de la otra mitad del arreglo.
		//Se crean los dos arreglos del tamaÒo establecido anteriormente.
		int left_sub_array [] = new int [nleft];
		int right_sub_array [] = new int [nright];	
		if (a.length == 1) //Cuando el arreglo estÈ ordenado.
			return a;
		else {
			//Llenar cada mitad del arreglo.
			for (int i =0; i<nleft; i++) 
				left_sub_array[i] =  a[i];
			for (int i= nleft; i< a.length; i++)
				right_sub_array [i - nleft] = a[i];
			//Ordenar cada una de las partes.
			int [] sortedL = mergeSort (left_sub_array);
			int [] sortedR = mergeSort (right_sub_array);
			// Dividir arreglo.
			return merge (sortedL, sortedR);		
		}
	}
	/**
	 * Ordena las soluciones.
	 * @param a = Mitad del arreglo.
	 * @param b = Mitad faltante del arreglo.
	 * @return = Arreglo ordenado.
	 */
	public static int [] merge (int[] a, int [] b) {
		int l = a.length + b.length;
		//Crear arreglo 'C'
		int [] c = new int [l];
		int indexA = 0, indexB = 0, indexC = 0;
		while (a.length > indexA && b.length > indexB) {
			if (a[indexA] < b[indexB]) {
				//AÒadir elemento del arreglo 'a'.
				c [indexC] = a[indexA];
				indexA ++;
				indexC ++;
			}
			else {
				//AÒadir elemento del arreglo 'b'.
				c[indexC] = b[indexB];
				indexB ++;
				indexC ++;	
			}
		}
		// Uno del 'a' o 'b' tiene a˙n algunos elementos.
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
			bw.write("Ingrese n˙meros separados por comas : \n");
			bw.flush();
			String line = br.readLine(); 
			int [] arreglo = llenar(line); //Se llama a la funciÛn para crear el arreglo de enteros.
			int [] ordenado = mergeSort (arreglo); //Se guarda el arreglo creado por el algoritmo.
			bw.write("Arreglo ordenado : \n");
			bw.flush();
			print(ordenado);
		}
		catch (Exception ex) {}

	}

}
=======
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Ordenamiento de arreglos con algoritmo de Mage Sort.
 */

/**
 * @author Nicol√°s David Espejo Bernal
 *
 * 15/04/2018
 */
public class MergeSort {
	/**
	 * Pasa la l√≠nea ingresada de n√∫meros separados por comas, a un arreglo de enteros.
	 * @param line = String con n√∫meros separados por comas.
	 * @return = Arreglo de enteros con n√∫meros.
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
	 * Funci√≥n que imprime arreglos de tipo entero.
	 * @param array = Arreglo de enteros.
	 */
	public static void print (int [] array) {
		try {
			BufferedWriter bw = new BufferedWriter ( new OutputStreamWriter (System.out));
			for (int i= 0; i<array.length; i++) {
				if (i == array.length -1)
					bw.write(array[i] + "\n");
				else
					bw.write(array[i] + " ");
			}
			bw.flush();
		}
		catch (Exception ex) {}
	}
	/**
	 * Algoritmo de ordenamiento Merge Sort recursivo. Divide el arreglo hasta que est√© en tama√±o 1.
	 * @param a = Arreglo para ordenar.
	 * @return = Arreglo ordenado.
	 */
	public static int [] mergeSort (int [] a) {
		int nleft = a.length /2; //Tama√±o de la primera mitad del arreglo.
		int nright = a.length  - nleft; //Tama√±o de la otra mitad del arreglo.
		//Se crean los dos arreglos del tama√±o establecido anteriormente.
		int left_sub_array [] = new int [nleft];
		int right_sub_array [] = new int [nright];	
		if (a.length == 1) //Cuando el arreglo est√© ordenado.
			return a;
		else {
			//Llenar cada mitad del arreglo.
			for (int i =0; i<nleft; i++) 
				left_sub_array[i] =  a[i];
			for (int i= nleft; i< a.length; i++)
				right_sub_array [i - nleft] = a[i];
			//Ordenar cada una de las partes.
			int [] sortedL = mergeSort (left_sub_array);
			int [] sortedR = mergeSort (right_sub_array);
			// Dividir arreglo.
			return merge (sortedL, sortedR);		
		}
	}
	/**
	 * Ordena las soluciones.
	 * @param a = Mitad del arreglo.
	 * @param b = Mitad faltante del arreglo.
	 * @return = Arreglo ordenado.
	 */
	public static int [] merge (int[] a, int [] b) {
		int l = a.length + b.length;
		//Crear arreglo 'C'
		int [] c = new int [l];
		int indexA = 0, indexB = 0, indexC = 0;
		while (a.length > indexA && b.length > indexB) {
			if (a[indexA] < b[indexB]) {
				//A√±adir elemento del arreglo 'a'.
				c [indexC] = a[indexA];
				indexA ++;
				indexC ++;
			}
			else {
				//A√±adir elemento del arreglo 'b'.
				c[indexC] = b[indexB];
				indexB ++;
				indexC ++;	
			}
		}
		// Uno del 'a' o 'b' tiene a√∫n algunos elementos.
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
			bw.write("Ingrese n√∫meros separados por comas : \n");
			bw.flush();
			String line = br.readLine(); 
			int [] arreglo = llenar(line); //Se llama a la funci√≥n para crear el arreglo de enteros.
			int [] ordenado = mergeSort (arreglo); //Se guarda el arreglo creado por el algoritmo.
			bw.write("Arreglo ordenado : \n");
			bw.flush();
			print(ordenado);
		}
		catch (Exception ex) {}
	}

}
>>>>>>> branch 'master' of https://github.com/nicolas462/Fundamentos-EE.DD
