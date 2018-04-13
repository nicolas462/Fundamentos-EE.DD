import java.io.*;
/**
 * Solución problema 4.
 * El beneficio se tendrá que encontrar hayando la diferencia de los últimos vectores con 
 * los primeros, venta y compra respectivamente. Se hará realizando dos iteraciones continuas.
 * Puesto que el día en que se vende debe ser después del día de compra, la segunda iteración
 * tendrá que ir inversa y detenerse en el índice de la primera iteración. Posteriormente la
 * diferencia de mayor valor se almacenará en una variable, que será la respuesta (beneficio máximo). 
 */

/**
 * @author Nicolás David Espejo Bernal.
 *
 */
public class Problema4 {
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
			int [] valores = arreglo(datos); //Se llama a la función para crear el arreglo de enteros.;
			
			int benef =0, temp =0, max=0; //benef = Diferencia de valores. temp = Variable auxiliar. max = Beneficio máximo.
			for (int i =0; i< valores.length; i++) { 
				for (int j = valores.length-1; j>i; j--) //Iteración inversa que se detiene en el índice del for anterior.
				{
					benef = valores[j] - valores[i]; //Operación para hay beneficio.
					if (benef > temp) { //Comprobación de beneficio máximo.
						if(max < benef) //Condicional para que el máximo no se reemplace siempre.
						max= benef;
					}
					temp = benef; //Se establece la variable auxiliar igual al benef para usarla en la siguiente iteración.
				}
			}
			bw.write("Respuesta: "+ max);
			bw.flush();
		}
		catch(Exception ex) {}

	}

}
