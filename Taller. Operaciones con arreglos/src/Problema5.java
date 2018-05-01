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
 * @author Nicol�s David Espejo Bernal.
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
	 * Define el patr�n de la suceci�n aritm�tica.
	 * @param datos = Vector con n�meros.
	 * @return = Valor faltante llamando a otra funci�n.
	 */
	public static int patr (int [] datos) {
		int patr = 0;
		int aux = 0, aux2 = 0;
		for (int i = datos.length - 1; i >0 ; i--) {
			patr = datos [i] - datos [i -1];
			//Si el valor del patr�n es mayor (donde se rompe la suceci�n), se vuelve a establecer a el valor anterior.
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
	 * Se busca d�nde la suceci�n no cumple la diferencia del patr�n.
	 * @param arreglo = Suceci�n aritm�tica.
	 * @param patron = patron previamente definido
	 * @return = N�mero faltante en la suceci�n.
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
			int [] valores = arreglo(datos); //Se llama a la funci�n para crear el arreglo de enteros.	
			bw.write("Respuesta: "+ patr (valores)); //1, 5, 7, 9 //RTA: 3
			bw.flush();	
		}
		catch(Exception ex) {}

	}

}
