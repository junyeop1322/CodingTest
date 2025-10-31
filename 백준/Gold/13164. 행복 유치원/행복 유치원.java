import java.io.*;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        ArrayList<Integer> tall = new ArrayList<>();
        ArrayList<Integer> subTall = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            tall.add(Integer.parseInt(st.nextToken())); 
        }
        
        for(int i = 0; i < N-1; i++){
            subTall.add(tall.get(i+1) - tall.get(i));
        }
        
        Collections.sort(subTall);
 
        for(int i = 0; i < N-K; i++){
            answer += subTall.get(i);
        }
        System.out.println(answer);
    }
}