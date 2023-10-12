class Solution {
    static int ans, cnt;
    
    
    public int solution(int[] numbers, int target) {
        ans = 0;
        cnt = target;
        
        dfs(0, 0, numbers);
        
        return ans;
    }
    
    static void dfs(int num, int sum, int[] numbers) {
        if (num == numbers.length) {
            if (sum == cnt) {
                ans++;
            }
            return;
        }
        
        int nSum = sum + numbers[num];
        
        dfs(num+1, nSum, numbers);
        
        int mSum = sum - numbers[num];
        dfs(num+1, mSum, numbers);
        
    }
}