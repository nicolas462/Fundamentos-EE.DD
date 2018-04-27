import java.io.*;

public class Confidential {
	public static String message (String line) {
		int middle = line.length() / 2;
		if (line.length() == 1) 
			return line;
		else {
			String left = line.substring(0, middle);
			String right = line.substring(middle);
			return line.charAt(middle) + message(left) + message(right);	
		}		
	}
    
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			String line = "abcd"; //bacd
			bw.write(message(line));
			bw.flush();
		}
		catch (Exception ex ) {}

	}

}
