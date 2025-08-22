import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] arr = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            arr[Integer.parseInt(input[0])] = new int[]
                    {Integer.parseInt(input[1])
                    , Integer.parseInt(input[2])
                    , Integer.parseInt(input[3])};
        }
        
        int count = 0;
        int[] medalK = arr[K];
        for (int i = 1; i <= N; i++) {
            if (arr[i][0] > medalK[0]) {
                count++;
            } else if (arr[i][0] == medalK[0] && arr[i][1] > medalK[1]) {
                count++;
            } else if (arr[i][0] == medalK[0] && arr[i][1] == medalK[1] && arr[i][2] > medalK[2]) {
                count++;
            }
        }
        System.out.println(count+1);
    }
}