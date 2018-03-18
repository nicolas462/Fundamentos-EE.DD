import java.util.Scanner;

/**
 * Esta clase muestra: Factorial, Serie de Fibonacci, Multiplicaci�n y Tri�ngulo de Pascal.
 * @author Nicol�s Espejo
 *
 */
public class Recursiones {
	//Esta funci�n retorna el factorial de un numero
	public static int facto (int n) {
		if (n==1)
			return 1;
		else
			return n* facto(n-1);
	}
	/*Esta funci�n retorna el n�mero de al que corresponde 
		la posici�n dentro de la serie de Fibonacci */
	public static int fib (int n){
		if (n==1)
			return 0;
		else
			if(n==2)
				return 1;
			else
				return fib (n-1) + fib (n -2);
	}
	//Esta funci�n retorna el resultado de la multiplicaci�n de dos numeros.
	public static int mult (int n, int x){
		if (x==1)
			return n;
		else
			return n + mult (n, x-1);
	}
	/*Esta funci�n retorna la cifra de las coordenadas ingresadas dentro del
		tri�ngulo de pascal */
	public static int pasc (int n, int k) //n= columnas. k= filas.
	{
		if (k==0 || k==n)
			return 1;
		else 
			return pasc (n-1, k) + pasc (n-1, k-1);
	}
	
	public static void main(String[] args) {
	}
}
