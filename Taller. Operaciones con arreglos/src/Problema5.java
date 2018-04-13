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
 * @author USER
 *
 */
public class Problema5 {
	/**
	 * Pasa el arreglo de Strings a un arreglo de Enteros.
	 * @param datos = Arreglo de String que se recibe.
	 * @return = Retorna arreglo de enteros.
	 */
	public static int[] arreglo (String datos [])
	{
		int [] valores = new int [datos.length]; 
		for (int i= 0; i<datos.length; i++)
			valores[i] = Integer.parseInt(datos[i]);
		return valores;
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
			
			int respuesta =0;
			int patr = valores[1] - valores[0]; //Se define el patrón de la secuencia.
			for (int i = 1; i<valores.length; i++) { 
				if (valores [i]-valores[i-1] != patr) //Se busca dónde la sucesión no cumple la diferencia del patrón.
					respuesta = valores [i-1] + patr; //Se obtiene el número faltante.
				
			}
			bw.write("Respuesta: "+respuesta);
			bw.flush();
			
		}
		catch(Exception ex) {}

	}

}
