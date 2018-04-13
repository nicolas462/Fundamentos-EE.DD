import java.io.*;
/**
 * Solución problema 3.
 * Se ejecutrán iteraciones que comprobarán cuántas veces se repite un número. Cada vez
 * que se encuentre el número repetido, se sumará a una variable, esto quiere decir, que si
 * un número se repite dos veces, la suma de la variable será 2. Si en un número la suma no es
 * 2, significa que el número no está dos veces dentro del vector, por lo tanto se imprime.
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 */
public class Problema3 {
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
			
			int acum; 
			int respuesta =0;
			for (int i= 0; i<valores.length; i++) { 
				acum= 0; //Se deja el acumulador nuevamente en cero para empezar otra vez.
				for (int j=0; j<valores.length; j++) 
				{	
					if (valores[i] == valores[j]) //Si el número está dos veces, el acumulador será igual a 2.
						acum ++;				
				}		
			if (acum != 2) //Si el acumulador no es 2, quiere decir que el número no está repetido.
				respuesta = valores[i];
			}
			bw.write("Respuesta: " + respuesta);
			bw.flush();
		}
		catch (Exception ex) {}
	}

}
