import java.io.*;

public class TestClass {
    public static String output (String line){
    	String aux2 = ""; 
        for (int i= 0; i< line.length(); i++){
             if (line.charAt(i) != 'A' && line.charAt(i) != 'C' && line.charAt(i) != 'G' && line.charAt(i) != 'T'){
                return "Error RNA nucleobases found!";
             }
            else{
                if (line.charAt(i) == 'A') 
                	aux2 = aux2 + "T" ;
                
                if (line.charAt(i) == 'G') 
                    aux2 = aux2 + "C" ;
                
                if (line.charAt(i) == 'T') 
                    aux2 = aux2 + "A" ;
                
                if (line.charAt(i) == 'C') 
                    aux2 = aux2 + "G" ;
            }
        }
        return aux2;
       
    }
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			int cases= Integer.parseInt(br.readLine());
			int n;
			String line;
			for (int i = 0; i< cases; i++){
			    n= Integer.parseInt(br.readLine());
			    line = br.readLine();
			    bw.write(output(line)+ "\n");
			}
			bw.flush();
		}
		catch (Exception ex ) {}

	}

}
