import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        String a = br.readLine();
        String b = br.readLine();

        int len = a.length() * 2;
        int[] dp = new int[len];

        for (int i = 0, j = 0; i < len; i++)
            dp[i] = i % 2 == 0 ? count[a.charAt(j) - 'A'] : count[b.charAt(j++) - 'A'];

        while (len-- > 2) {
            for (int i = 0; i < len; i++)
                dp[i] = (dp[i] + dp[i + 1]) % 10;
        }

        System.out.println(new StringBuilder().append(dp[0]).append(dp[1]).toString());
    }

}