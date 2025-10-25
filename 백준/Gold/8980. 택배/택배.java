import java.io.*;
import java.util.*;
 
class Delivery implements Comparable<Delivery> {
    int start;
    int end;
    int boxNum;
 
    Delivery(int start, int end, int boxNum) {
        this.start = start;
        this.end = end;
        this.boxNum = boxNum;
    }
 
    @Override
    public int compareTo(Delivery arg0) {
        if (end == arg0.end) {
            return start - arg0.start;
        }
        return end - arg0.end;
    }
}
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
 
        int M = Integer.parseInt(br.readLine());
        Delivery[] deliveries = new Delivery[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int boxNum = Integer.parseInt(st.nextToken());
 
            deliveries[i] = new Delivery(start, end, boxNum);
        }
        
        Arrays.sort(deliveries, 1, M + 1);
 
        int[] weight = new int[N + 1];
        for (int i = 1; i < N; i++) {
            weight[i] = C;
        }
 
        int ans = 0;
        for (int i = 1; i <= M; i++) {
            Delivery d = deliveries[i];
 
            int maxBoxNum = Integer.MAX_VALUE;
 
            for (int j = d.start; j < d.end; j++) {
                maxBoxNum = Math.min(maxBoxNum, weight[j]);
            }
 
            if (maxBoxNum >= d.boxNum) {
                for (int j = d.start; j < d.end; j++) {
                    weight[j] -= d.boxNum;
                }
                ans += d.boxNum;
            } else {
                for (int j = d.start; j < d.end; j++) {
                    weight[j] -= maxBoxNum;
                }
                ans += maxBoxNum;
            }
        }
 
        System.out.println(ans);
    }
 
}
