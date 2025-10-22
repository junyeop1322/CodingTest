import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int winCount = 0;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (winCount >= (N+1) / 2) break;

            for (int j = idx; j < N; j++) {
                if (arr1[i] < arr2[j]) {
                    winCount++;
                    idx = j + 1;
                    break;
                }
            }

        }

        System.out.println(winCount >= (N+1) / 2 ? "YES" : "NO");
    }

}
