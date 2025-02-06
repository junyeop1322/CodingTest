import java.util.Scanner;

public class Main {
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.close();

        System.out.println((fibonacciSum(b) - fibonacciSum(a - 1) + MOD) % MOD);
    }

    static long fibonacciSum(long n) {
        if (n < 0) return 0;
        return (fibonacci(n + 2) - 1 + MOD) % MOD;
    }

    static long fibonacci(long n) {
        if (n == 0) return 0;
        long[][] result = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n % 2 == 1) result = multiplyMatrix(result, base);
            base = multiplyMatrix(base, base);
            n /= 2;
        }
        return result[0][1];
    }

    static long[][] multiplyMatrix(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return res;
    }
}
