import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());

            sb.append(upperbound(hi) - lowerbound(lo)).append("\n");
        }
        System.out.println(sb);
    }

    public static int lowerbound(int key) {
        int lo = 0;
        int hi = n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key <= arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int upperbound(int key) {
        int lo = 0;
        int hi = n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}