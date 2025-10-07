import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);

        Integer[] numberArray = new Integer[size];

        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            numberArray[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numberArray, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < count; i++) {
            result += (numberArray[i] - i);
        }

        System.out.println(result);
    }
}