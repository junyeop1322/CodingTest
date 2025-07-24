import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> digraph;
    static ArrayList<ArrayList<Integer>> rdigraph;
    static ArrayList<ArrayList<Integer>> res;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.valueOf(st.nextToken());
        int E = Integer.valueOf(st.nextToken());

        digraph = new ArrayList<>();
        rdigraph = new ArrayList<>();
        res = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            digraph.add(new ArrayList<>());
            rdigraph.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            digraph.get(A).add(B);
            rdigraph.get(B).add(A);
        }

        visited = new boolean[V + 1];
        stack = new Stack<>();

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Arrays.fill(visited, false);
        int groupNum = 0;

        while (!stack.isEmpty()) {
            int start = stack.pop();

            if (visited[start]) {
                continue;
            }

            redfs(start, groupNum);
            groupNum++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(groupNum + "\n");
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < groupNum; i++) {
            Collections.sort(res.get(i));
            map.put(res.get(i).get(0), i);
        }

        map.keySet().forEach(key -> {
            int value = map.get(key);

            for (int now : res.get(value)) {
                sb.append(now + " ");
            }
            sb.append("-1\n");
        });

        System.out.println(sb.toString());
    }

    public static void dfs (int start) {
        visited[start] = true;

        for (int now : digraph.get(start)) {
            if (!visited[now]) {
                dfs(now);
            }
        }

        stack.push(start);
    }

    public static void redfs(int start, int groupNum) {
        visited[start] = true;
        res.get(groupNum).add(start);

        for (int now : rdigraph.get(start)) {
            if (!visited[now]) {
                redfs(now, groupNum);
            }
        }
    }
}