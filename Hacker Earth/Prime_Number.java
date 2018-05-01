import java.io.*;
public class Prime_Number {

	public static void main(String[] args) {
		try {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int n = Integer.parseInt(br.readLine());//Leer N
		int contador = 0;
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j<= i; j++) //Usa cada número para el residuo
			{
				if (i%j == 0) {
					contador ++;
				}
			}		
			if (contador == 2)//Si hay dos números (1 y el mismo), es un número primo.
			{
				bw.write(i+ " ");
			}
			contador = 0;	
		}
		bw.flush();
		}
		catch (Exception ex ) {}

	}

}
