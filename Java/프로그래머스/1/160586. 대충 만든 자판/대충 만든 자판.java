import java.util.*;
import java.math.*;

class Solution {
    
    private Map<Character, Integer> map = new HashMap<>();
    
    public int[] solution(String[] keymap, String[] targets) {
        
        for (String keys : keymap) {
            int len = keys.length();
            for (int i = 0; i < len; i++) {
                char ch = keys.charAt(i);
                if (map.containsKey(ch)) {
                    int order = map.get(ch);
                    if (order > i + 1) {
                        map.put(ch, i + 1);
                    }
                } else {
                    map.put(ch, i + 1);
                }
            }
        }
        
        int length = targets.length;
        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            String target = targets[i];
            int totalCnt = 0;
            for (char ch : target.toCharArray()) {
                if (!map.containsKey(ch)) {
                    totalCnt = -1;
                    break;
                }
                
                totalCnt += map.get(ch);
            }
            answer[i] = totalCnt;
        }
        
        
        return answer;
    }
}