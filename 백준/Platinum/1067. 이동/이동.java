import java.util.*;
import java.io.*;

public class Main {

    static final int P = 998244353;

    // FFT 알고리즘
    public static void fft(long[] a, boolean inverse) {
        int n = a.length;
        int j = 0;

        for (int i = 1; i < n; i++) {
            int reverse = n >> 1;
            while (j >= reverse) {
                j -= reverse;
                reverse >>= 1;
            }
            j += reverse;
            if (i < j) {
                long temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        for (int step = 2; step <= n; step *= 2) {
            int half = step / 2;
            long u = modPow(3, (P - 1) / step, P); // 원시 근
            if (inverse) {
                u = modPow(u, P - 2, P); // 역원
            }

            for (int i = 0; i < n; i += step) {
                long w = 1;
                for (int k = i; k < i + half; k++) {
                    long v = (a[k + half] * w) % P;
                    a[k + half] = (a[k] - v + P) % P;
                    a[k] = (a[k] + v) % P;
                    w = (w * u) % P;
                }
            }
        }

        if (inverse) {
            long num = modPow(n, P - 2, P); // n의 역원
            for (int i = 0; i < n; i++) {
                a[i] = (a[i] * num) % P;
            }
        }
    }

    // 모듈러 제곱 연산
    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // 다항식의 곱
    public static long[] convolution(long[] a, long[] b) {
        int x = a.length + b.length - 1;
        int n = 1 << (32 - Integer.numberOfLeadingZeros(x - 1)); // 2의 제곱수로 맞추기

        a = Arrays.copyOf(a, n);
        b = Arrays.copyOf(b, n);

        fft(a, false);
        fft(b, false);

        for (int i = 0; i < n; i++) {
            a[i] = (a[i] * b[i]) % P;
        }

        fft(a, true);

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n];
        long[] y = new long[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
        	x[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
        	y[i] = Long.parseLong(st.nextToken());
        }
        
        // y를 뒤집음
        for (int i = 0; i < y.length / 2; i++) {
            long temp = y[i];
            y[i] = y[y.length - i - 1];
            y[y.length - i - 1] = temp;
        }

        long[] result = convolution(concatArrays(x, x), y);

        long max = 0;
        for (long value : result) {
            max = Math.max(max, value);
        }

        System.out.println(max);
    }

    // 배열을 두 번 이어붙이는 함수
    public static long[] concatArrays(long[] a, long[] b) {
        long[] result = new long[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
}
