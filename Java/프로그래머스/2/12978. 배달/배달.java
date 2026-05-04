import java.util.*;
import java.math.*;

class Solution {
    
    private final int INF = (int) 1e9;
    
    public int solution(int N, int[][] road, int K) {
        
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        
        for (int[] r : road) {
            int v1 = r[0];
            int v2 = r[1];
            int cost = r[2];
            
            map[v1][v2] = Math.min(map[v1][v2], cost);
            map[v2][v1] = Math.min(map[v2][v1], cost); 
        }
        
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] == INF || map[k][j] == INF) {
                        continue;
                    }
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}