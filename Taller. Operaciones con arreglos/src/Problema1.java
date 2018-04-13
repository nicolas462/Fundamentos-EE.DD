import java.io.*;

/**
 * Soluci�n al problema 1 del taller.
 * Se deben dividir los datos ingresados por consola, que est�ran separados por comas. Estos datos
 * se almacenar�n en un vector de enteros para poder operarlos y poder obtener una salida.
 * Se tomar�n los datos y se operar�n, si la diferencia de los datos es igual a 'k' se suma
 * al acumulador, para al final mostar cu�ntas parejas cumplen con la condici�n.
 */

/**
 * @author Nicol�s David Espejo Bernal
 *
 */
public class Problema1 {
	/**
	 * Retorna la cantidad de parejas que cumplen la condici�n, la cual es que el resultado de su diferencia sea 'k'.
	 * @param arreglo = Arreglo que contiene la serie de n�meros que se ingresar�n por consola.
	 * @param k = Resultado que se debe obtener para que sume el acumulador.
	 * @return acumu = Se sumar� uno cada vez que se cumpla la condici�n.
	 */
	public static int salida(int [] arreglo, int k) 
	{
		int acum=0;
		for (int i= 0; i<arreglo.length; i++) {
			for(int j = 0; j<arreglo.length; j++) {
				if (arreglo[i] - arreglo[j] == k)
					acum ++;
			}
		}
		return acum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //Buffer para leer entradas.
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out)); //Buffer para imprimir.
			String serie; //Ac� se leer� la l�nea de n�meros ingresados.
			
			bw.write("Ingrese n�meros separados por comas: ");
			bw.flush();	
			serie = br.readLine(); //Se ingresa l�nea.
			bw.write("Ingrese 'k': ");
			bw.flush();
			int k = Integer.parseInt(br.readLine()); //Se ingresa K.
			
			String [] datos = serie.split(",");
			int [] arreglo = new int [datos.length]; //Ac� se almacenar�n los datos.
			for (int i= 0; i<datos.length ; i++) //Se almacenan los datos del vector de strings, en uno de enteros.
				arreglo [i] = Integer.parseInt(datos[i]);
			
			bw.write(""+salida(arreglo, k)); //Se imprime llamando a la funci�n.
			bw.flush();
			
		}
		catch (Exception ex) {}

	}

}
