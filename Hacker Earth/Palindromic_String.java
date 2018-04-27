import java.io.*;
public class Palindromic_String {
	public String palindromo(String s) //Revierte String
	{
		if (s.length()==1) 
			return s;
		else
			return palindromo (s.substring(1, s.length())) + s.charAt(0);	
	}
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			Palindromic_String prueba = new Palindromic_String();//Llamar función.
			String s = br.readLine();
			if (prueba.palindromo(s).equals(s)) 
				bw.write("YES");
			else 
				bw.write("NO");
			bw.flush();
		}
		catch (Exception ex ) {}
	}
}
