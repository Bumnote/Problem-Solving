import java.util.*;

class Solution {

    int n;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        this.n = schedules.length;
        
        int answer = 0;
        for (int i = 0; i < this.n; i++) {
            boolean flag = true;                
            int startTime = schedules[i];
            int endTime = schedules[i] + 10;
            if (endTime % 100 >= 60) {
                endTime += 100;
                endTime -= 60;
                if (endTime / 100 == 24) {
                    endTime = endTime % 100;
                }
            }
            for (int j = 0; j < 7; j++) {
                int day = startday + j;
                if (day % 7 == 6 || day % 7 == 0) {
                    continue;
                }   
                
                int targetTime = timelogs[i][j];
                if (endTime < targetTime) {
                    flag = false;
                    break;
                }
            }            
            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}