import java.math.*;
import java.util.*;

class Solution {
    
    private final Map<String, Integer> map = new HashMap<>();
    private int[][] mat;
    private int[] presentPoint;
    private int LEN;
    
    public int solution(String[] friends, String[] gifts) {
    
        
        initExchangeMatrix(friends, gifts);
        initPresentPointMatrix();
        int answer = solve();
        
        return answer;
    }
    
    private void initExchangeMatrix(String[] friends, String[] gifts) {
        LEN = friends.length;
        for (int i = 0; i < LEN; i++) {
            map.put(friends[i], i);
        }
        
        mat = new int[LEN][LEN];
        for (String gift : gifts) {
            String[] matching = gift.split(" ");
            int sender = map.get(matching[0]);
            int receiver = map.get(matching[1]);
            mat[sender][receiver]++;
        }
    }
    
    private void initPresentPointMatrix() {
        
        presentPoint = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            int sendSum = 0;
            int receiveSum = 0;
            for (int j = 0; j < LEN; j++) {
                sendSum += mat[i][j];
                receiveSum += mat[j][i];
            }
            presentPoint[i] = sendSum - receiveSum;
        }
    }
    
    private int solve() {
        
        int[] result = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = i + 1; j < LEN; j++) {
                // 두 사람이 주고받은 기록이 있는 경우
                if (mat[i][j] != 0 || mat[j][i] != 0) {
                    if (mat[i][j] > mat[j][i]) {
                        result[i]++;
                    } else if (mat[i][j] < mat[j][i]) {
                        result[j]++;
                    } else {
                        if (presentPoint[i] > presentPoint[j]) {
                            result[i]++;
                        } else if (presentPoint[i] < presentPoint[j]) {
                            result[j]++;
                        }
                    }
                } 
                // 두 사람이 주고받은 기록이 없는 경우 
                else {
                    if (presentPoint[i] > presentPoint[j]) {
                        result[i]++;
                    } else if (presentPoint[i] < presentPoint[j]) {
                        result[j]++;
                    }
                } 
            }
        }
        
        int MAX = 0;
        for (int i = 0; i < LEN; i++) {
            MAX = Math.max(MAX, result[i]);
        }
    
        return MAX;
    }
}