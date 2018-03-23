import java.io.*;

public class Monster_String {
	public String eat() {
		/*
		 *		 0
		 *    1	 2 	3
		 *  2  3   3
		 * 3
		 */
		return "";
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int t = Integer.parseInt(br.readLine()); //Cantidad de casos.
			int j = 0;
			for (int i = 0; i<=t; i++) {
				int n = Integer.parseInt(br.readLine()); //Cantidad de veces que se ingresan Srings.
				String [] k = new String[n]; //Se crea vector para almacenar los Strings.
				for (j = 0; j<=n ; j++) //Ciclo para las entradas del vector.
				{
					k [j] = br.readLine();
				}
				for (j = 0; j<=n ; j++)
				{
					for (int l = 0; l<=n ; l++)
					{
						if (k[n].equals(k[l])){
						
						}
					}
				}
				int n1, k1;
			
			}
			bw.flush();
			bw.close();
			br.close();
		}
		catch (Exception ex) {}

	}

}
