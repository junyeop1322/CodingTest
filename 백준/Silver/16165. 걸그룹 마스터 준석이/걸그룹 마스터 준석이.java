import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());            
            List<String> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                list.add(br.readLine());
            }
            map.put(group, list);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int member = Integer.parseInt(br.readLine());

            if (member == 1) {
                for (String group : map.keySet()) {
                    if (map.get(group).contains(name)) {
                        sb.append(group + "\n");
                        break;
                    }
                }
            } else {
                List<String> list = map.get(name);
                Collections.sort(list);
                for (String memberName : list) {
                    sb.append(memberName + "\n");
                }
            }
        }

        System.out.println(sb); // 출력 결과 출력

    }

}