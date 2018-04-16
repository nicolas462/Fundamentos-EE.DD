import java.io.*;
/**
 * Soluci�n problema 2.
 * La base del ejercicio est� en conocer la operaci�n inversa a la multiplicaci�n,
 * la divisi�n. De esta manera si se quiere eliminar la operaci�n hecha por un n�mero
 * de un �ndice 'x', se tiene que dividir el resultado de la multiplici�n de todos 
 * los n�meros por 'x'.
 */

/**
 * @author Nicol�s David Espejo Bernal
 *
 */
public class Problema2 {
	/**
	 * 
	 * @param array = Arreglo que se usar�.
	 * @return = Retorna la multiplicaci�n de todos los n�meros dentro del arreglo.
	 */
	public static int mult (int array[]) //Resultado de multiplicaci�n.
	{
		int acum = 1;
		for (int i= 0; i<array.length; i++)
			acum *= array[i];
		return acum;
	}
	/**
	 * 
	 * @param array = Arreglo que se usar� para imprimirlo.
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
			int [] valores = new int [datos.length]; //Se crea un arreglo igual al tama�o del arreglo de Strings.
			for (int i= 0; i<datos.length; i++)//Se pasa el vector de Strings a vector de enteros.
				valores[i] = Integer.parseInt(datos[i]);
			
			int mult = mult(valores); //Se almacena el resultado de la funci�n dentro de un entero para posteriormente usarlo.
			int [] salida = new int [valores.length]; //Se crea el arreglo de salida.
			for (int j=0 ; j<salida.length; j++) //Se realiza la inversa de la multiplicaci�n.
				salida[j] = mult/valores[j];
			
			print(salida);
		}
		catch(Exception ex) {}
	}

}
