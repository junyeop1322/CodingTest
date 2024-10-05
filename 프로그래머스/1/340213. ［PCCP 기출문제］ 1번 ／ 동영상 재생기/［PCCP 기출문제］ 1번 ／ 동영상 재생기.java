class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
    
        int lenH = Integer.parseInt(video_len.substring(0, 2));
        int lenM = Integer.parseInt(video_len.substring(3, 5));
        
        int opSH = Integer.parseInt(op_start.substring(0, 2));
        int opSM = Integer.parseInt(op_start.substring(3, 5));
        int opEH = Integer.parseInt(op_end.substring(0, 2));
        int opEM = Integer.parseInt(op_end.substring(3, 5));
        
        int curH = Integer.parseInt(pos.substring(0, 2));
        int curM = Integer.parseInt(pos.substring(3, 5));
        
        int hour = curH;
        int min = curM;
        
        for (int t = 0; t < commands.length; t++) {
            String order = commands[t];
            
            // 오프닝 건너뛰기
            if (hour >= opSH && hour <= opEH) {
                if ((hour == opSH && min < opSM) || (hour == opEH && min > opEM)) {
                    
                } else {
                    hour = opEH;
                    min = opEM;
                }
            }
            
            switch(order) {
                case "prev" :
                    if (min < 10) {
                        hour = hour - 1;
                        min = 60 - (10 - min);
                        
                    } else {
                        hour = hour;
                        min = min - 10;
                    }
                    
                    // 동영상 시간을 넘어가는 경우
                    if (hour < 0) {
                        hour = 0;
                        min = 0;
                    }
                    
                    curH = hour;
                    curM = min;
                    break;
                case "next" :
                    if (min >= 50) {
                        hour = hour + 1;
                        min = min - 50;
                        
                    } else {
                        hour = hour;
                        min = min + 10;
                    }
                    
                    if (hour > lenH) {
                        hour = lenH;
                        min = lenM;
                    } else if (hour == lenH && min > lenM) {
                        min = lenM;
                    }
                    
                    curH = hour;
                    curM = min;
                    break;
            }
        }
        
        // 오프닝 건너뛰기
            if (hour >= opSH && hour <= opEH) {
                System.out.println(1);
                if ((hour == opSH && min < opSM) || (hour == opEH && min > opEM)) {
                    
                } else {
                    hour = opEH;
                    min = opEM;
                }
            }
        
        // 정답 출력하기
        if (hour < 10) {
            if (min < 10) {
                answer = "0" + Integer.toString(hour) + ":" + "0" + Integer.toString(min);
            } else {
                answer = "0" + Integer.toString(hour) + ":" + Integer.toString(min);
            }
        } else {
            if (min < 10) {
                answer = Integer.toString(hour) + ":" + "0" + Integer.toString(min);
            } else {
                answer = Integer.toString(hour) + ":" + Integer.toString(min);
            }
        }
        
        return answer;
    }
}