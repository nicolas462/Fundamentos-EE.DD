import java.io.*;
 
public class Birthday_Party {
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			int cases= Integer.parseInt(br.readLine());
			int a, b;
			String line;
			for (int i = 0; i< cases; i++)
			{
			    line = br.readLine();
			    String datos[] = line.split(" ");
			    a = Integer.parseInt(datos[0]);
			    b = Integer.parseInt(datos[1]);
			    if ( b % a==0){
			        bw.write("Yes" + "\n");
			    }
			    else{
			        bw.write("No" + "\n");
			    }
			}
			bw.flush();
			
					
		}
		catch (Exception ex ) {}
 
	}
 
}
