import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Solución problema 5.
 * Para hayar el patrón de la progresión aritmética se toman los dos primeros valores del
 * arreglo, se obtiene la diferencia restando el segundo con el primero. Una vez definido
 * el patrón, se empieza a comprobar que el patrón esté en la sucesión, si no está se suma
 * el patrón al número donde no se encuentra la correcta progresión y ésta será la respuesta.
 */

/**
 * @author Nicolás David Espejo Bernal.
 *
 */
public class Problema5 {
	/**
	 * Pasa el arreglo de Strings a un arreglo de Enteros.
	 * @param datos = Arreglo de String que se recibe.
	 * @return = Retorna arreglo de enteros.
	 */
	public static int[] arreglo (String [] datos )
	{
		int [] valores = new int [datos.length]; 
		for (int i= 0; i<datos.length; i++)
			valores[i] = Integer.parseInt(datos[i]);
		return valores;
	}
	/**
	 * Define el patrón de la suceción aritmética.
	 * @param datos = Vector con números.
	 * @return = Valor faltante llamando a otra función.
	 */
	public static int patr (int [] datos) {
		int patr = 0;
		int aux = 0, aux2 = 0;
		for (int i = datos.length - 1; i >0 ; i--) {
			patr = datos [i] - datos [i -1];
			//Si el valor del patrón es mayor (donde se rompe la suceción), se vuelve a establecer a el valor anterior.
			if (aux < patr && aux > 0) {
				aux2 = aux;
				aux = patr;
				patr = aux2;
			}
			else
				aux = patr;
		}
		return faltante (datos, patr);
	}
	/**
	 * Se busca dónde la suceción no cumple la diferencia del patrón.
	 * @param arreglo = Suceción aritmética.
	 * @param patron = patron previamente definido
	 * @return = Número faltante en la suceción.
	 */
	public static int faltante (int [] arreglo, int patron) {
		int respuesta = 0;
		for (int i = 1; i<arreglo.length; i++) { 
			if (arreglo [i]-arreglo[i-1] != patron) 
				respuesta = arreglo [i-1] + patron; 	
		}
		return respuesta;
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
			int [] valores = arreglo(datos); //Se llama a la función para crear el arreglo de enteros.	
			bw.write("Respuesta: "+ patr (valores)); //1, 5, 7, 9 //RTA: 3
			bw.flush();	
		}
		catch(Exception ex) {}

	}

}
