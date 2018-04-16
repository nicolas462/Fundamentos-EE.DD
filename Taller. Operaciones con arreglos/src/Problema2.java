import java.io.*;
/**
 * Solución problema 2.
 * La base del ejercicio está en conocer la operación inversa a la multiplicación,
 * la división. De esta manera si se quiere eliminar la operación hecha por un número
 * de un índice 'x', se tiene que dividir el resultado de la multiplición de todos 
 * los números por 'x'.
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 */
public class Problema2 {
	/**
	 * 
	 * @param array = Arreglo que se usará.
	 * @return = Retorna la multiplicación de todos los números dentro del arreglo.
	 */
	public static int mult (int array[]) //Resultado de multiplicación.
	{
		int acum = 1;
		for (int i= 0; i<array.length; i++)
			acum *= array[i];
		return acum;
	}
	/**
	 * 
	 * @param array = Arreglo que se usará para imprimirlo.
	 */
	public static void print (int array[]) //Imprime arreglos.
	{
		try {
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
			for (int i = 0; i< array.length; i++) {
				if (i == array.length -1)
					bw.write( array[i]+ "\n" );
				else
					bw.write( array[i]+ "," );
			}
			bw.flush();
		}
		catch (Exception ex) {}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
			BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
			String n = br.readLine(); //Se lee la entrada.
			String [] datos = n.split(","); //Se almacenan los datos de entrada en un arraglo de Strings.
			int [] valores = new int [datos.length]; //Se crea un arreglo igual al tamaño del arreglo de Strings.
			for (int i= 0; i<datos.length; i++)//Se pasa el vector de Strings a vector de enteros.
				valores[i] = Integer.parseInt(datos[i]);
			
			int mult = mult(valores); //Se almacena el resultado de la función dentro de un entero para posteriormente usarlo.
			int [] salida = new int [valores.length]; //Se crea el arreglo de salida.
			for (int j=0 ; j<salida.length; j++) //Se realiza la inversa de la multiplicación.
				salida[j] = mult/valores[j];
			
			print(salida);
		}
		catch(Exception ex) {}
	}

}
