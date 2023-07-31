import java.util.Scanner;

public class Main {
    static int cnt;
    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] ans = new int[T];
        int[] count = new int[T];

        for (int t = 0; t < T; t++) {
            cnt = 0;
            String s = sc.next();

            ans[t] = isPalindrome(s);
            count[t] = cnt;
        }

        for (int t = 0; t < T; t++) {
            System.out.printf("%d %d\n", ans[t], count[t]);
        }

    }
}
