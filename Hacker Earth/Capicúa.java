import java.io.*;
 
public class Clase1 {
	public String capicua(String numero) {
		if (numero.length()==1) {
		return numero;
		}
		else {
			return capicua (numero.substring(1, numero.length()))+ numero.charAt(0);
		}
	}
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			Clase1 capic = new Clase1();
			int cases= Integer.parseInt(br.readLine());
			String n;
			for (int i=0; i<cases; i++) {
				n= br.readLine();
				
				if (capic.capicua(n).equals(n)) {
					bw.write("YES" + "\n");
				}
				else {
					bw.write("NO"+ "\n");
				}
			}
			bw.flush();
			
		}
		catch (Exception ex ) {}
 
	}
 
}
