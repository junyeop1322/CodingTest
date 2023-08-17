import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	// 연결된 노드들을 나열하기 위해 ArrayList 중첩을 사용함
	
	static int[] checked;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		checked = new int[n+1];
		// 순위 저장 : 노드만큼의 크기로 노드 순위를 저장할 배열을 선언, 노드 번호가 배열의 인덱스로 갈 것이므로 배열의 크기는 1이 추가 됨
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		// ArrayList에 데이터 저장을 위해 그래프 초기화
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}
		// 각 노드와 연결된 노드들끼리 오름차순이 되어 있어야 하므로, ArrayList안에 있는 또다른 ArrayList를 오름차순으로 정렬
		
		
		cnt = 1;
		dfs(r);
		
		for(int i = 1; i < checked.length; i++) {
			sb.append(checked[i]).append("\n");
		}
		
		System.out.println(sb);
	}

	static void dfs(int node) {
		checked[node] = cnt; // 탐색할 노드에 순위 저장
		
		for (int i = 0; i < graph.get(node).size(); i++) {
			int newNode = graph.get(node).get(i);
			if (checked[newNode] == 0) {
				cnt++;
				dfs(newNode);
			}
		}
	}
	
}
