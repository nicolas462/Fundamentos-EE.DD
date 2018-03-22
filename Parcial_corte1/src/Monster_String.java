import java.io.*;

public class Monster_String {
	public static int factorial (int n) {
		if (n==1)
			return 1;
		else
			return n* factorial(n-1);
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int t = Integer.parseInt(br.readLine()); //Cantidad de casos.
			for (int i = 0; i<=t; i++) {
				int n = Integer.parseInt(br.readLine()); //Cantidad de veces que se ingresan Srings.
				String [] k = new String[n]; //Se crea vector para almacenar los Strings.
				for (int j = 0; j<=n ; j++) //Ciclo para las entradas del vector.
				{
					k [j] = br.readLine();
				}
				int n1, k1;
				n1 = n;
				k1 = 3;
				int nf= factorial(n1);
				int nfk= factorial(n-k1);
				int resultado = nf/nfk;
				System.out.println("El resultado es: " + resultado);
			}
			bw.flush();
			bw.close();
			br.close();
		}
		catch (Exception ex) {}

	}

}
