import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {        
        int time = attacks[attacks.length - 1][0];
        
        System.out.println(time);
        
        int cnt = 0;
        int heal = health;
        
        int count = bandage[0];
        int hp1 = bandage[1];
        int hp2 = bandage[2];
        
        for (int i = 0; i <= time; i++) {
            
            int t = -1;
            
            for (int j = 0; j < attacks.length; j++) {
                if (i == attacks[j][0]) {
                    t = attacks[j][1];
                    break;
                }
            }
            
            if (t == -1) { // 공격 안 받았을 때
                heal += hp1;
                cnt++;
                
                if (cnt == count) {
                    heal += hp2;
                    cnt = 0;
                }
                
                
                if (heal >= health) {
                    heal = health;
                }
            } else { // 공격 받았을 때
                cnt = 0;
                heal -= t;
                
                if (heal <= 0) {
                    return -1;
                }
            }
            
            
        }
        
        return heal;
    }
}