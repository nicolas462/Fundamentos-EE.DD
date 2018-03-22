import java.io.*;

/**
 * Esta clase muestra: Factorial, Serie de Fibonacci, Multiplicaci�n y Tri�ngulo de Pascal
 * en forma de recursiones.
 * @author Nicol�s Espejo
 *
 */
public class Recursiones {
	/**
	 * Muestra el m�ximo com�n divisor con el algoritmo de Euclides.
	 * @param a Primer n�mero.
	 * @param b	Segundo n�mero.
	 * @return Retorna el MCD de el primero y segundo n�mero.
	 */
	public int mcd_euclides(int a, int b)
	{
		if (b==0)
			return a;
		else
			return mcd_euclides(b, a%b);
	}
	/**
	 * Calcula el factorial de un n�mero.
	 * @param x N�mero al que se la calcula el factorial.
	 * @return Retorna el resultado del factorial del n�mero ingresado.
	 */
	public int factorial (int n) {
		if (n==1)
			return 1;
		else
			return n* factorial(n-1);
	}
	/**
	 * Muestra el n�mero al que corresponde la posici�n dentro de la serie de Fibonacci.
	 * @param x Posici�n dentro de la serie de Fibonacci.
	 * @return Retorna el n�mero correspondiente a la posici�n ingresada.
	 */
	public int fibonacci (int n){
		if (n==0)
			return 0;
		else
			if(n==1)
				return 1;
			else
				return fibonacci (n-1) + fibonacci (n -2);
	}
	/**
	 * Da la cifra de las coordenadas ingresadas dentro del tri�ngulo de pascal.
	 * @param n Fila dentro del tri�ngulo.
	 * @param k Columna dentro del tri�ngulo.
	 * @return Retorna la cifra correspondiente a las cordenadas ingresadas.
	 */
	public int pascal (int n, int k) //n= columnas. k= filas.
	{
		if (k==0 || k==n)
			return 1;
		else 
			return pascal (n-1, k) + pascal (n-1, k-1);
	}
	/**
	 * Genera el tri�ngulo de pascal.
	 * @return Imprime el tri�ngulo de pascal.
	 */
	public String print_pascal()
	{
		String pascal_matrix = "";
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j <= i; j++)
				pascal_matrix += pascal(i, j) + "\t";
			
			pascal_matrix += "\n";
		}
		
		return pascal_matrix;
	}
	/**
	 * Multiplica dos n�meros.
	 * @param n Multiplicando. 
	 * @param x Multiplicador.
	 * @return Retorna el resultado de la multiplicaci�n entre los n�meros ingresados.
	 */
	public static int multiplicacion (int n, int x){
		if (x==1)
			return n;
		else
			return n + multiplicacion (n, x-1);
	}
	/**
	 * Invierte una cadena de car�cteres ingresada.
	 * @param cadena Cadena de car�cteres ingresdada.
	 * @return Retorna la cadena de car�cteres inveritida.
	 */
	public String inversa_cadena(String cadena)
	{
		if (cadena.length()==1) {
			return cadena;
		}
		else {
			return inversa_cadena (cadena.substring(1, cadena.length())) + cadena.charAt(0) ;
		}
	}
	/**
	 * Llama a las funciones con par�metros ya establecidos para ejecutarlas.
	 * @param args No usado.
	 */
	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		Recursiones recurrencias = new Recursiones();
	
		try
		{
			//Aca puede probar los resultados de sus recurrencias
			bw.write(recurrencias.factorial(15) + "\n"); // respuesta: 2004310016
			
			bw.write(recurrencias.fibonacci(25) + "\n"); // respuesta: 75025
			
			bw.write(recurrencias.multiplicacion(654, 97) + "\n"); // respuesta: 63438
			
			bw.write(recurrencias.mcd_euclides(369, 1218) + "\n"); // respuesta: 3
			
			bw.write(recurrencias.inversa_cadena("asdfghjkl") + "\n"); // respuesta: lkjhgfdsa
			
			bw.write(recurrencias.print_pascal() + "\n");
			/*
			 * 1	
			 * 1	1	
			 * 1	2	1	
			 * 1	3	3	1	
			 * 1	4	6	4	1	
			 * 1	5	10	10	5	1	
			 * 1	6	15	20	15	6	1	
			 * 1	7	21	35	35	21	7	1	
			 * 1	8	28	56	70	56	28	8	1	
			 * 1	9	36	84	126	126	84	36	9	1
			 */

			
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
