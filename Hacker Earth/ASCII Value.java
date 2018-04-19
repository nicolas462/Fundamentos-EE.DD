import java.io.*;
public class Clase1 {
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			char let = (char) br.read();
			System.out.println((int) let);
			
			
					
		}
		catch (Exception ex ) {}
 
	}
 
}
