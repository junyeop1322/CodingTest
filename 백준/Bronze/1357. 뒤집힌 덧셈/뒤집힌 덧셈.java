import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        sc.close();

        int XY = rev(X) + rev(Y);

        System.out.println(rev(XY));
    }

    private static int rev(int a) {
        String str = String.valueOf(a);

        char[] arr = str.toCharArray();
        char[] revChar = new char[arr.length];
    
        for (int i = 0; i < arr.length; i++) {
            revChar[arr.length - 1 - i] = arr[i];
        }

        String revString = new String(revChar);
        
        return Integer.parseInt(revString);
    }
}
