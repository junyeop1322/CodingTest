import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        double[] arr = new double[9];
        
        for (int i = 0; i < 8; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.fill(arr, 8, arr.length, 9999);
        Arrays.sort(arr);

        for (int i = 0; i < N-8; i++) {
            double d = Double.parseDouble(br.readLine());

            for (int j = 0; j < 7; j++) {
                if(arr[j] >= d) {
                    for (int k = 7; k >= j; k--) {
                        arr[k+1] = arr[k];
                    }
                    arr[j] = d;
                    break;
                }

            }
        }

        for(int i = 0; i < 7; i++) {
            System.out.println(String.format("%.3f", arr[i]));
        }
    }
}