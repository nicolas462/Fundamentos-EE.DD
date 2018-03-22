import java.io.*;

class Cubos {
	public static int mcd(int a, int b) {
		if (b==0)
			return a;
		else
			return mcd(b, a%b);
	}
	
	public static void main(String[] args) {	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader ( System.in ));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter ( System.out ));
			int a, b, c, result;
			int cases = Integer.parseInt(br.readLine()); //Lee la cantidad de casos y los pasa a entero.
			for(int i =0; i < cases; i++) {
				String line = br.readLine(); //Lee una línea de String.
				String [] datos = line.split(" ");//Divide la línea anterior por cada espacio y la asigna al vector.
				a = Integer.parseInt (datos[0]);
				b = Integer.parseInt (datos[1]);
				c = Integer.parseInt (datos[2]);
				int md = mcd(a, b); // Se halla el MCD de a y b.
				md = mcd(md, c); //Se halla el MCD del resultado de a y b, con c.
				result = (a/md)*(b/md)*(c/md); //Cantidad de cubos resultante.
				bw.write(md + " " + result + "\n"); //Se imprime el resultado.
			}
			bw.flush();
			bw.close();
		}
		catch (Exception ex) {}
	}
}