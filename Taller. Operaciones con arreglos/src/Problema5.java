import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Soluci�n problema 5.
 * Para hayar el patr�n de la progresi�n aritm�tica se toman los dos primeros valores del
 * arreglo, se obtiene la diferencia restando el segundo con el primero. Una vez definido
 * el patr�n, se empieza a comprobar que el patr�n est� en la sucesi�n, si no est� se suma
 * el patr�n al n�mero donde no se encuentra la correcta progresi�n y �sta ser� la respuesta.
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
			int [] valores = arreglo(datos); //Se llama a la funci�n para crear el arreglo de enteros.
			
			int respuesta =0;
			int patr = valores[1] - valores[0]; //Se define el patr�n de la secuencia.
			for (int i = 1; i<valores.length; i++) { 
				if (valores [i]-valores[i-1] != patr) //Se busca d�nde la sucesi�n no cumple la diferencia del patr�n.
					respuesta = valores [i-1] + patr; //Se obtiene el n�mero faltante.
				
			}
			bw.write("Respuesta: "+respuesta);
			bw.flush();
			
		}
		catch(Exception ex) {}

	}

}
