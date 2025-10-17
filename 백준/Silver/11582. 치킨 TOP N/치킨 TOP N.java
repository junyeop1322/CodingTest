import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        int k = Integer.parseInt(br.readLine());
        int temp = n / k;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(num[i]);
            
            if (pq.size() == temp) {
                while (!pq.isEmpty()) {
                    System.out.print(pq.poll() + " ");
                }
            }
        }
    }
}