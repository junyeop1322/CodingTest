import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        String input;
        loop:
        while (!(input = br.readLine()).equals("*")) {
            for (int i = 1; i < input.length(); i++) {
                set.clear();
                for (int j = 0; j < input.length() - i; j++) {
                    String sub = String.valueOf(input.charAt(j)) + input.charAt(j + i);
                    if (!set.contains(sub))
                        set.add(sub);
                    else {
                        sb.append(input).append(" is NOT surprising.\n");
                        continue loop;
                    }
                }
            }
            sb.append(input).append(" is surprising.\n");
        }

        System.out.println(sb.toString());
    }

}