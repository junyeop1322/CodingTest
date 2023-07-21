import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};

        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - '0';

            sb.append(arr[a]);
        }

        if (str.equals("0")) {
            System.out.println(str);
        }
        else {
            while(sb.charAt(0) == '0') {
                sb = new StringBuilder(sb.substring(1));
            }
            System.out.println(sb);
        }

    }
}
