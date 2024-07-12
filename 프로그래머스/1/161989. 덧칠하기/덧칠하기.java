class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        
        for (int i = 0; i < section.length; i++) {
            arr[section[i]] = 1;
        }
        
        while (true) {
            if (check(arr)) {
                break;
            }
            
            int cnt = 0;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    cnt = i;
                    break;
                }
            }
            
            if (cnt + m > arr.length) {
                answer++;
                return answer;
            } else {
                for (int i = cnt; i < cnt + m; i++) {
                    if (arr[i] == 1) {
                        arr[i]--;
                    }
                }
            }
            
            answer++;
        }
        
        return answer;
    }
    
    static boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return false;
            }
        }
        
        return true;
    }
}