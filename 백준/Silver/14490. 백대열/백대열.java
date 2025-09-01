import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strInput = bReader.readLine().split(":");
		int N = Integer.parseInt(strInput[0]);
		int M = Integer.parseInt(strInput[1]);
		
		int nFirstNum = N;
		int nSecondNum = M;
		
		int nMul = nFirstNum * nSecondNum;
		
		int nRemainder = 0;
		while(nSecondNum > 0) {
			nRemainder = nFirstNum % nSecondNum;
			nFirstNum = nSecondNum;
			nSecondNum = nRemainder;
		}
		int nGCL = nFirstNum;
		
		N /= nGCL;
		M /= nGCL;
		
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(String.valueOf(N) + ":" + String.valueOf(M));
		
		String ans = strBuild.toString();
		
        System.out.println(ans);
	}
}