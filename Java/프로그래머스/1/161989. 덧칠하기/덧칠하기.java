import java.math.*;
import java.util.*;

class Solution {
    
    private int[] arr;
    
    public int solution(int n, int m, int[] sections) {
    
        arr = new int[n + 1];
        for (int section : sections) {
            arr[section] = 1;
        }
        
        int idx = 0;
        int count = 0;
        int LEN = sections.length;
        
        while (true) {
            int start = sections[idx];
            int nxtIdx = idx;
            if (idx == LEN - 1) {
                count++;
                break;
            }
            for (int nxt = idx + 1; nxt < LEN; nxt++) {
                int end = sections[nxt];
                idx = nxt;
                // 현재 위치까지 칠할 수 없는 경우
                if (end - start + 1 > m) {
                    count++;
                    break;
                }
            }
        }
    
        return count;
    }
}