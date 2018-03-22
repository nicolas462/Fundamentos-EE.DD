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
			int cases = Integer.parseInt(br.readLine());
			for(int i =0; i < cases; i++) {
				String line = br.readLine();
				String [] datos = line.split(" ");
				a = Integer.parseInt (datos[0]);
				b = Integer.parseInt (datos[1]);
				c = Integer.parseInt (datos[2]);
				int md = mcd(a, b);
				md = mcd(md, c);
				result = (a/md)*(b/md)*(c/md);
				bw.write(md + " " + result + "\n");
			}
			bw.flush();
			bw.close();
		}
		catch (Exception ex) {}
	}
}