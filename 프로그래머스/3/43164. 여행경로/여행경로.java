import java.util.*;

class Solution {
    
    static int n;
    static boolean[] visited;
    static List<String> route = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        n = tickets.length;
        visited = new boolean[n];
        
        route.add("ICN");
        
        dfs(tickets, "ICN", 0);
        
        answer = route.toArray(new String[0]);
        
        return answer;
    }
    
    static boolean dfs(String[][] tickets, String current, int count) {
        if (count == n) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            if (tickets[i][0].equals(current) && !visited[i]) {
                visited[i] = true;
                route.add(tickets[i][1]);
                
                if (dfs(tickets, tickets[i][1], count + 1)) {
                    return true;
                }
                
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
        
        return false;
    }
}
