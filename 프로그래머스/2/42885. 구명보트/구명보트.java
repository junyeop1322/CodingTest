import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int right = people.length - 1;
        int left = 0;
        
        while(true) {
            if (right < left) {
                break;
            } else if (right == left) {
                answer++;
                break;
            }
            
            if (people[left] + people[right] <= limit) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        
        return answer;
    }
    
}