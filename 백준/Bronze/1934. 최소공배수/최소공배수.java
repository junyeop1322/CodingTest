import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int ans = 0;
            int gcb = 0;

            for (int i = 1; i <= Math.min(A, B); i++) {
                if (A % i == 0 && B % i == 0) {
                    gcb = i;
                }
            }

            ans = A * B / gcb;

            System.out.println(ans);
        }
    }
}
