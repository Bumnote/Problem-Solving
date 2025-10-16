import java.math.*;
import java.util.*;

class Solution {
    
    private int size; 
    private int totalLimit; 
    private int[][] dungeons;
    private boolean[] visited; 
    private int answer; 
    
    public int solution(int k, int[][] dungeons) {
        
        init(k, dungeons);
        solve();  
        
        return answer;
    }
    
    private void init(int k, int[][] dgs) {
        dungeons = dgs;
        size = dgs.length;
        totalLimit = k;
    }
    
    private void solve() {
        visited = new boolean[size];
        bt(0);
    }
    
    private void bt(int tmp) {
        
        answer = Math.max(answer, tmp);    
        
        for (int i = 0; i < size; i++) {
            // 아직 방문하지 않은 경우 -> 방문 
            if (!visited[i]) {
                // 피로도가 넘는 경우 -> continue
                if (dungeons[i][0] > totalLimit) {
                    continue;
                }
                
                visited[i] = true; // 방문 처리
                totalLimit -= dungeons[i][1]; // 피로도 감소 
                bt(tmp + 1);
                totalLimit += dungeons[i][1]; // 피로도 복원
                visited[i] = false; // 복원 처리 
            }
        }
    }
}