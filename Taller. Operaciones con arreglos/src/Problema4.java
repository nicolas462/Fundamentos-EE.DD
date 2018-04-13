import java.io.*;
/**
 * Soluci�n problema 4.
 * El beneficio se tendr� que encontrar hayando la diferencia de los �ltimos vectores con 
 * los primeros, venta y compra respectivamente. Se har� realizando dos iteraciones continuas.
 * Puesto que el d�a en que se vende debe ser despu�s del d�a de compra, la segunda iteraci�n
 * tendr� que ir inversa y detenerse en el �ndice de la primera iteraci�n. Posteriormente la
 * diferencia de mayor valor se almacenar� en una variable, que ser� la respuesta (beneficio m�ximo). 
 */

/**
 * @author Nicol�s David Espejo Bernal.
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
			int [] valores = arreglo(datos); //Se llama a la funci�n para crear el arreglo de enteros.;
			
			int benef =0, temp =0, max=0; //benef = Diferencia de valores. temp = Variable auxiliar. max = Beneficio m�ximo.
			for (int i =0; i< valores.length; i++) { 
				for (int j = valores.length-1; j>i; j--) //Iteraci�n inversa que se detiene en el �ndice del for anterior.
				{
					benef = valores[j] - valores[i]; //Operaci�n para hay beneficio.
					if (benef > temp) { //Comprobaci�n de beneficio m�ximo.
						if(max < benef) //Condicional para que el m�ximo no se reemplace siempre.
						max= benef;
					}
					temp = benef; //Se establece la variable auxiliar igual al benef para usarla en la siguiente iteraci�n.
				}
			}
			bw.write("Respuesta: "+ max);
			bw.flush();
		}
		catch(Exception ex) {}

	}

}
