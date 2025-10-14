import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(br.readLine()));
        }
        Collections.sort(list);
        
        int k = Integer.parseInt(st.nextToken());

        Deque<Double> deque = new ArrayDeque<>(list);
        for (int i = 0; i < k; i++) {
            deque.pollFirst();
            deque.pollLast();
        }

        double trimmedSum = deque.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        double trimmedAverage = trimmedSum / (n - k * 2);

        double correctedSum = trimmedSum + deque.peekFirst() * k + deque.peekLast() * k; // 보정평균 덧셈
        double correctedAverage = correctedSum / n;

        String result = String.format("%.2f\n", trimmedAverage + 1e-8);
        result += String.format("%.2f\n", correctedAverage + 1e-8);

        System.out.print(result);
    }
}