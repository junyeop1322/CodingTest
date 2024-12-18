import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        
        int num = n;
        
        while(true) {
            int[] newArr = new int[num/2];
            int idx = 0;
            boolean chk = false;
            
            for (int i = 0; i < arr.length; i += 2) {
                if ((arr[i] == a && arr[i+1] == b) || (arr[i] == b && arr[i+1] == a)) {
                    chk = true;
                    break;
                } else if (arr[i] == a || arr[i+1] == a) {
                    if (arr[i] == a) {
                        newArr[idx] = arr[i];
                    } else {
                        newArr[idx] = arr[i+1];
                    }
                } else if (arr[i] == b || arr[i+1] == b) {
                    if (arr[i] == b) {
                        newArr[idx] = arr[i];
                    } else {
                        newArr[idx] = arr[i+1];
                    }
                } else {
                    newArr[idx] = arr[i];
                }
                
                idx++;
            }
            
            if (chk) {
                break;
            }
            
            num /= 2;
            arr = newArr;
            answer++;
        }
        
        
        return answer;
    }
}