import java.io.*;

class TestClass {
    public static int ana (String a, String b){
        int contador = 0;
        for (int i =0; i< a.length(); i++){
            for (int j= 0; j< b.length(); j++){
                if (a.charAt(i) == b.charAt(j))
                    contador ++;
            }
        }
        return (a.length() - contador) + (b.length() - contador);
    }
    public static void main(String args[] ) throws Exception {
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i< t; i++){
            String stringA = br.readLine();
            String stringB = br.readLine();
            bw.write(ana(stringA, stringB)+ "\n");
        }
        bw.flush();

    }
    catch (Exception ex) {}

    }
}
