import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        Map<Integer, Set<String>> map = new HashMap<>();
        int song = 1;

        while (e-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            Set<String> set = new HashSet<>();
            while (k-- > 0) set.add(st.nextToken());

            if (set.contains("1")) map.put(song++, set);
            else {
                for (String s : set) {
                    for (Set<String> value : map.values())
                        if (value.contains(s)) value.addAll(set);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (Set<String> value : map.values())
                if (value.contains(String.valueOf(i))) cnt++;

            if (cnt == map.size()) sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}