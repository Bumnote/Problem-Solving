import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (n > s) {
            return new int[] {-1};
        }
    
        int[] answer = new int[n];
        int base = s / n;
        Arrays.fill(answer, base);
        int remain = s % n;
        for (int i = n - 1; i > n - 1 - remain; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}